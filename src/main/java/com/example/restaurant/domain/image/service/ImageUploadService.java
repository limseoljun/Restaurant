package com.example.restaurant.domain.image.service;

import com.example.restaurant.domain.image.ImageUpload;
import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadService {
    /**
     * 파일 이름과 파일을 받아 서버 시간과 조합하여 이미지를 서버 경로에 복사 저장
     * 경로를 imageUpload 에 변환 DB에 경로를 저장
     * @param name 파일 이름
     * @param multipartFile 이미지 파일
     * @param imageUpload imagePath 이미지 경로
     */
    void upload(String name, MultipartFile multipartFile, ImageUpload imageUpload);
}
