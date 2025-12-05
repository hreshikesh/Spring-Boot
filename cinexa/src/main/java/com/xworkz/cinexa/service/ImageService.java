package com.xworkz.cinexa.service;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService {

    public String saveImageLocally(String name, MultipartFile file) throws IOException{

       try {
           byte[] filePart = file.getBytes();
           Path path = Paths.get("D:\\cinexa\\" + name + System.currentTimeMillis() + ".jpg");
           Files.write(path, filePart);
           return path.getFileName().toString();
       }catch (Exception ex){
           throw  new IOException("Error in uploading file");
       }


    }

    public void previewMovieImage(String imagePath,HttpServletResponse response) throws IOException {
        File file=new File("D:\\unity_hospital\\"+imagePath);
        try{
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
            ServletOutputStream outputStream = response.getOutputStream();
            IOUtils.copy(inputStream, outputStream);
            response.flushBuffer();
        }catch (IOException ex){
            throw new IOException("Image not found");
        }
    }

}
