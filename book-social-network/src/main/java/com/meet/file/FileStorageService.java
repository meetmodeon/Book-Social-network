package com.meet.file;

import lombok.extern.slf4j.Slf4j;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@Slf4j
public class FileStorageService {

    private String fileUploadPath="./upload";
    public String saveFile(
            @NonNull MultipartFile sourceFile,
            @NonNull Integer userId) {
        final String fileUploadSubPath = "users"+ File.separator+ userId;
        return uploadFile(sourceFile, fileUploadSubPath);
    }

    private String uploadFile(
            @NonNull MultipartFile sourceFile,
            @NonNull String fileUploadSubPath) {
        final String finalUploadPath = fileUploadPath+ File.separator + fileUploadSubPath;
        File targetFolder = new File(finalUploadPath);
        if(!targetFolder.exists()){
            boolean folderCreated = targetFolder.mkdirs();
            if(!folderCreated){
                log.info("Failed to create the target folder");
                return null;
            }
        }
        final String fileExtension= getFileExtension(sourceFile.getOriginalFilename());
        // ./upload/users/1/1223234324.jpg
        String targetFilePath = fileUploadSubPath + File.separator+System.currentTimeMillis()+"."+fileExtension;
        Path targetPath = Paths.get(targetFilePath);
        try{
            Files.write(targetPath,sourceFile.getBytes());
            log.info("File saved to "+ targetFilePath);
            return targetFilePath;
        }catch (IOException ex){
            log.error("File was not saved",ex);
        }
        return null;
    }

    private String getFileExtension(String fileName) {
        if(fileName == null || fileName.isEmpty()){
            return "";
        }
        int lastDotIndex= fileName.lastIndexOf(".");
        if(lastDotIndex == -1){
            return "";
        }
        return fileName.substring(lastDotIndex+1).toLowerCase();
    }
}
