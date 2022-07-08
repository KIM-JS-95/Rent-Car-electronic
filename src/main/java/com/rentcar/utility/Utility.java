package com.rentcar.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public class Utility {

  public static String checkNull(String str) {
    if (str == null) {
      str = "";
    }
    return str;
  }

  public static String saveFileSpring(MultipartFile mf, String basePath) {
    InputStream inputStream = null;
    OutputStream outputStream = null;
    String filename = "";
    long filesize = mf.getSize();
    String originalFilename = mf.getOriginalFilename();
    try {
      if (filesize > 0) { // 파일이 존재한다면
        // 인풋 스트림을 얻는다.
        inputStream = mf.getInputStream();

        File oldfile = new File(basePath, originalFilename);

        if (oldfile.exists()) {
          for (int k = 0; true; k++) {
            // 파일명 중복을 피하기 위한 일련 번호를 생성하여
            // 파일명으로 조합
            oldfile = new File(basePath, "(" + k + ")" + originalFilename);

            // 조합된 파일명이 존재하지 않는다면, 일련번호가
            // 붙은 파일명 다시 생성
            if (!oldfile.exists()) { // 존재하지 않는 경우
              filename = "(" + k + ")" + originalFilename;
              break;
            }
          }
        } else {
          filename = originalFilename;
        }
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("os: " + os); // windows 10, linux, mac os x
        String serverFullPath = null;
        if (os.equals("mac os x")) { // Mac
          System.out.println("맥");
          serverFullPath = basePath + "/" + filename;
        } else if (os.equals("windows 10")) {
          System.out.println("os: " + os);
          serverFullPath = basePath + "\\" + filename;
        } else if (os.equals("linux")) {
          System.out.println("리눅스");
          serverFullPath = basePath + "/" + filename;
        }

        System.out.println("fileName: " + filename);
        System.out.println("serverFullPath: " + serverFullPath);

        outputStream = new FileOutputStream(serverFullPath);

        // 버퍼를 만든다.
        int readBytes = 0;
        byte[] buffer = new byte[8192];

        while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
          outputStream.write(buffer, 0, readBytes);
        }
        outputStream.close();
        inputStream.close();

      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {

    }

    return filename;
  }

  public static void deleteFile(String upDir, String oldfile) {
    File file = new File(upDir, oldfile);
    if (file.exists())
      file.delete();

  }


}
