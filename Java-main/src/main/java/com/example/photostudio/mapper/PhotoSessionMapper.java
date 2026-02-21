package com.example.photostudio.mapper;

import com.example.photostudio.dto.PhotoSessionAdminResponseDto;
import com.example.photostudio.dto.PhotoSessionRequestDto;
import com.example.photostudio.dto.PhotoSessionResponseDto;
import com.example.photostudio.model.PhotoSession;
import org.springframework.stereotype.Component;

@Component
public class PhotoSessionMapper {
    public PhotoSessionResponseDto toResponseDto(PhotoSession photoSession) {
        if (photoSession == null) {
            return null;
        }

        return new PhotoSessionResponseDto(
                photoSession.getId(),
                photoSession.getClientName(),
                photoSession.getPhotoSessionDate(),
                photoSession.getPrice(),
                photoSession.getPhotographer(),
                photoSession.getStatus());
    }

    public PhotoSessionAdminResponseDto toAdminResponseDto(PhotoSession photoSession) {
        if (photoSession == null) {
            return null;
        }

        return PhotoSessionAdminResponseDto.builder()
                .id(photoSession.getId())
                .clientName(photoSession.getClientName())
                .clientLastName(photoSession.getClientLastName())
                .clientPhone(photoSession.getClientPhone())
                .photoSessionDate(photoSession.getPhotoSessionDate())
                .price(photoSession.getPrice())
                .photographer(photoSession.getPhotographer())
                .status(photoSession.getStatus())
                .build();
    }

    public PhotoSession toEntity(PhotoSessionRequestDto dto) {
        if (dto == null) {
            return null;
        }

        PhotoSession photoSession = new PhotoSession();

        photoSession.setClientLastName(dto.getClientLastName());
        photoSession.setClientName(dto.getClientName());
        photoSession.setClientPhone(dto.getClientPhone());
        photoSession.setPhotoSessionDate(dto.getPhotoSessionDate());
        photoSession.setPhotographer(dto.getPhotographer());
        photoSession.setPrice(dto.getPrice());
        photoSession.setStatus(dto.getStatus());

        return photoSession;
    }

    public void updateEntity(PhotoSession photoSession, PhotoSessionRequestDto dto) {
        if (photoSession == null || dto == null) {
            return;
        }

        photoSession.setClientLastName(dto.getClientLastName());
        photoSession.setClientName(dto.getClientName());
        photoSession.setClientPhone(dto.getClientPhone());
        photoSession.setPhotoSessionDate(dto.getPhotoSessionDate());
        photoSession.setPhotographer(dto.getPhotographer());
        photoSession.setPrice(dto.getPrice());
        photoSession.setStatus(dto.getStatus());
    }

    public PhotoSession toEntityFromAdmin(PhotoSessionAdminResponseDto dto) {
        if (dto == null) {
            return null;
        }

        PhotoSession photoSession = new PhotoSession();

        photoSession.setId(dto.getId());
        photoSession.setClientLastName(dto.getClientLastName());
        photoSession.setClientName(dto.getClientName());
        photoSession.setClientPhone(dto.getClientPhone());
        photoSession.setPhotoSessionDate(dto.getPhotoSessionDate());
        photoSession.setPhotographer(dto.getPhotographer());
        photoSession.setPrice(dto.getPrice());
        photoSession.setStatus(dto.getStatus());

        return photoSession;
    }
}
