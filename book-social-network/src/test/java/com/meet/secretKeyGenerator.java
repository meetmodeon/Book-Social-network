package com.meet;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;

import javax.crypto.SecretKey;
import java.security.Key;

public class secretKeyGenerator {

    public void generateKey(){
        SecretKey key= Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encodedKey= DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.println("SecretKey: "+encodedKey);
    }
}
