package com.springboot.reactiveSpringBoot2.service;

import com.springboot.reactiveSpringBoot2.model.Image;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class ImageService {

    public static final String UPLOAD_ROOT = "upload-dir";

    public final ResourceLoader resourceLoader;

    public ImageService(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }

    public Flux<Image> findAllImages(){
        try {
            return Flux.fromIterable(
                    Files.newDirectoryStream(Paths.get(UPLOAD_ROOT)))
                    .map(path ->
                        new Image(path.hashCode(),
                            path.getFileName().toString()));
        } catch (IOException e){
            return Flux.empty();
        }
    }

    public Mono<Resource> findOneImage(String filename){
        return Mono.fromSupplier(() ->
                resourceLoader.getResource(
                        "file:" + UPLOAD_ROOT + "/" + filename
                ));
    }

    public Mono<Void> createImage(Flux<FilePart> files)

    @Bean
    CommandLineRunner setUp() throws IOException{
        return args -> {
            FileSystemUtils.deleteRecursively(new File(UPLOAD_ROOT));

            Files.createDirectory(Paths.get(UPLOAD_ROOT));

            FileCopyUtils.copy("Test File",
                    new FileWriter(UPLOAD_ROOT + "image1"));

            FileCopyUtils.copy("Test File",
                    new FileWriter(UPLOAD_ROOT + "image2"));

            FileCopyUtils.copy("Test File",
                    new FileWriter(UPLOAD_ROOT + "image3"));
        };
    }
}
