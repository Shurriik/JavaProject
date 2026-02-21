package com.example.photostudio.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PhotoSessionResponseDto {
    private Long id;
    private String clientName;
    private String photoSessionDate;
    private String price;
    private String photographer;
    private String status;

    public PhotoSessionResponseDto() {
    }

    public PhotoSessionResponseDto(Long id, String clientName, 
        LocalDateTime photoSessionDate, double price,
            String photographer, String status) {
        this.id = id;
        this.clientName = clientName;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        this.photoSessionDate = photoSessionDate.format(formatter);
        this.price = String.format("%.0f руб", price);
        this.photographer = photographer;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getPhotoSessionDate() {
        return photoSessionDate;
    }

    public String getPrice() {
        return price;
    }

    public String getPhotographer() {
        return photographer;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setSessionDate(String photoSessionDate) {
        this.photoSessionDate = photoSessionDate;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}