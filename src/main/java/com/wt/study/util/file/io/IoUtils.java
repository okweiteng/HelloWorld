package com.wt.study.util.file.io;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class IoUtils {
    private IoUtils() {
    }

    public static InputStream readFileAsInputStreamFrom(String filePath) throws IOException {
        ClassPathResource cpr = new ClassPathResource(filePath);
        return cpr.getInputStream();
    }

    public static String readFileAsStringFrom(String filePath) throws IOException {
        ClassPathResource cpr = new ClassPathResource(filePath);
        return inputStreamToString(cpr.getInputStream());
    }

    public static String inputStreamToString(InputStream in) throws IOException {
        byte[] dataBytes = FileCopyUtils.copyToByteArray(in);
        return new String(dataBytes, StandardCharsets.UTF_8);
    }

    public static File multipartToFile(MultipartFile inFile, String filePathPrefix) throws IOException {
        String filePath = filePathPrefix + "/" + System.currentTimeMillis() + "/" + inFile.getOriginalFilename();
        File file = new File(filePath);
        Files.copy(inFile.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        return file;
    }

}
