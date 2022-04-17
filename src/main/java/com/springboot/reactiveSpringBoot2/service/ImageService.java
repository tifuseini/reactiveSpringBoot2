package com.springboot.reactiveSpringBoot2.service;

import com.springboot.reactiveSpringBoot2.model.Image;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private static final String UPLOAD_ROOT = "upload-dir";

    private final ResourceLoader resourceLoader;

    public ImageService(ResourceLoader resourceLoader){
        this.resourceLoader = resourceLoader;
    }
}
