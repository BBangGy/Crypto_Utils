package com.hgc.cryptotest.service;

import org.springframework.stereotype.Service;

import java.rmi.UnexpectedException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class CryptoService {

    public static String hashSha1(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] hashedBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hashSha256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static String hashSha512(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] hashedBytes = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String textToHash(String input, String option) {
        if (input.isEmpty()) {
            return "retry";
        }
        String result = switch (option) {
            case "SHA1" -> hashSha1(input);
            case "SHA256" -> hashSha256(input);
            case "SHA512" -> hashSha512(input);
            default -> throw new IllegalArgumentException("지원하지 않는 해시 옵션입니다."+option);
        };
        return result;
    }

}
