package com.wt.study.util.file.compress;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
    private ZipUtils() {
    }

    public static void zipFile(File srcFile, File zipFile, boolean overwrite) throws IOException {
        zipFileParamChecker(zipFile, overwrite);
        zipFileByChannel(srcFile, zipFile);
        // zipFileByMapper(srcFile, zipFile);
    }

    private static void zipFileByChannel(File srcFile, File zipFile) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            zipOut.putNextEntry(new ZipEntry(srcFile.getName()));

            FileChannel fileChannel = new FileInputStream(srcFile).getChannel();
            fileChannel.transferTo(0, srcFile.length(), writableByteChannel);
        }
    }

    private static void zipFileByMapper(File srcFile, File zipFile) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
             WritableByteChannel writableByteChannel = Channels.newChannel(zipOut)) {
            zipOut.putNextEntry(new ZipEntry(srcFile.getName()));

            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(srcFile, "r").getChannel()
                    .map(FileChannel.MapMode.READ_ONLY, 0, srcFile.length());
            writableByteChannel.write(mappedByteBuffer);
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    public static void zipFile(File srcFile, File zipFile) throws IOException {
        zipFile(srcFile, zipFile, true);
    }

    public static void zipFile(File srcFile) throws IOException {
        zipFile(srcFile, new File(srcFile.getAbsolutePath() + ".zip"), true);
    }

    public static void zipDirectory(File srcDir, File zipFile, boolean overwrite) throws IOException {
        zipFileParamChecker(zipFile, overwrite);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            zipDirectory(zipOut, srcDir, srcDir.getName());
        }
    }

    private static void zipDirectory(ZipOutputStream zipOutput, File file, String base) throws IOException {
        if (file.isDirectory()) {
            File[] fileList = file.listFiles();
            zipOutput.putNextEntry(new ZipEntry(base + "/"));
            String childBase = (base.length() == 0) ? "" : base + "/";
            assert fileList != null;
            for (File childFile : fileList) {
                zipDirectory(zipOutput, childFile, childBase + childFile.getName());
            }
        } else {
            zipOutput.putNextEntry(new ZipEntry(base));
            try (FileChannel fileChannel = new FileInputStream(file).getChannel()) {
                WritableByteChannel writableByteChannel = Channels.newChannel(zipOutput);
                fileChannel.transferTo(0, file.length(), writableByteChannel);
            }
        }

    }

    public static void zipDirectory(File srcDir, File zipFile) throws IOException {
        zipDirectory(srcDir, zipFile, true);
    }

    public static void zipDirectory(File srcDir) throws IOException {
        zipDirectory(srcDir, new File(srcDir.getAbsolutePath() + ".zip"), true);
    }

    public static void zipFiles(List<File> files, File zipFile, boolean overwrite) throws IOException {
        zipFileParamChecker(zipFile, overwrite);
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile))) {
            for (File srcFile : files) {
                try (WritableByteChannel writableByteChannel = Channels.newChannel(zipOut);
                     FileChannel fileChannel = new FileInputStream(srcFile).getChannel()) {
                    zipOut.putNextEntry(new ZipEntry(srcFile.getName()));
                    fileChannel.transferTo(0, srcFile.length(), writableByteChannel);
                }
            }
        }
    }

    public static void zipFiles(List<File> srcFiles, File zipFile) throws IOException {
        zipFiles(srcFiles, zipFile, true);
    }

    private static void zipFileParamChecker(File zipFile, boolean overwrite) throws IOException {
        if (zipFile == null) {
            throw new IllegalArgumentException("zipFile不能为空!");
        }
        if (!overwrite && zipFile.exists()) {
            throw new IOException(zipFile.getAbsolutePath() + "文件已存在，参数设定了不能覆盖。");
        }
        if (!zipFile.exists()) {
            boolean createSuccess = zipFile.createNewFile();
            if (!createSuccess) {
                throw new IOException("zip文件不存在，且自动创建失败，请确认文件路径或权限");
            }
        }
    }
}

