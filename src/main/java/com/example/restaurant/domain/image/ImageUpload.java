package com.example.restaurant.domain.image;

public interface ImageUpload {
    /**
     * 이미지 경로를 저장하기 위해 만듬
     * @param imagePath 이미지 경로
     */
    void uploadImage(String imagePath);
}
