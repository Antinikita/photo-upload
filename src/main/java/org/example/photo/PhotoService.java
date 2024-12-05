package org.example.photo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public Photo uploadPhoto(MultipartFile file) throws IOException {
         String UPLOAD_DIR = "src/main/resources/static/";

        String fileName = file.getOriginalFilename();
        Path filePath= Paths.get(UPLOAD_DIR+fileName);
        Files.write(filePath,file.getBytes());
        Photo photo = new Photo();
        photo.setFileName(fileName);
        return photoRepository.save(photo);


    }
}
