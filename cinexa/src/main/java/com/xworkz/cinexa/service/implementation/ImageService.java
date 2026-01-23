package com.xworkz.cinexa.service.implementation;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<byte[]> previewMovieImage(String imagePath) throws IOException {
        File file=new File("D:\\cinexa\\"+imagePath);
        byte[] imageBytes = Files.readAllBytes(file.toPath());

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes);

    }



}
