package com.wt.study.util.file.compress;

import com.wt.study.util.file.io.IoUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipUtils {
    private UnzipUtils() {
    }

    public static List<FileNameAndContent> readZipFileContent(File inFile) throws IOException {
        List<FileNameAndContent> fileInfoList = new ArrayList<>();
        ZipFile zipFile = new ZipFile(inFile);
        Enumeration<? extends ZipEntry> zipEnum = zipFile.entries();
        ZipEntry ze;
        while (zipEnum.hasMoreElements()) {
            ze = zipEnum.nextElement();
            if (ze.isDirectory()) {
                continue;
            }
            if (ze.getSize() <= 0) {
                continue;
            }
            InputStream zipEntryStream = zipFile.getInputStream(ze);
            String content = IoUtils.inputStreamToString(zipEntryStream);
            fileInfoList.add(new FileNameAndContent(ze.getName(), content));
        }
        return fileInfoList;
    }
}
