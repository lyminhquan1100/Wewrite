package com.arcane.app.web.rest;

import com.arcane.app.service.FileService;
import com.arcane.app.utils.FileManager;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/files")
@Validated
public class FileResource {

    private final FileService fileService;

    public FileResource(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping(value = "/image")
    public ResponseEntity<?> upLoadImage(@RequestParam(name = "image") MultipartFile image) throws IOException {

        if (!new FileManager().isTypeFileImage(image)) {
            return new ResponseEntity<>("File must be image!", HttpStatus.UNPROCESSABLE_ENTITY);
        }

        return new ResponseEntity<String>(fileService.uploadImage(image), HttpStatus.OK);
    }

    @GetMapping(value = "/image")
    public ResponseEntity<?> downloadImage(@RequestParam String nameImage) throws IOException {

        // TODO validate

        File imageFile = fileService.dowwnloadImage(nameImage);
        InputStreamResource imageStream = new InputStreamResource(new FileInputStream(imageFile));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", nameImage));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        return ResponseEntity
            .ok()
            .headers(headers)
            .contentLength(imageFile.length())
            .contentType(MediaType.parseMediaType("application/txt"))
            .body(imageStream);
    }
}
