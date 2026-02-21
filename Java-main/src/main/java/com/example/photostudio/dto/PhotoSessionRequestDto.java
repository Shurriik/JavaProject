package com.example.photostudio.dto;

import com.example.photostudio.interfaces.PhotoSessionData;
import java.time.LocalDateTime;

public class PhotoSessionRequestDto implements PhotoSessionData {
    private Long id;
    private String clientLastName;
    private String clientName;
    private String clientPhone;
    private LocalDateTime photoSessionDate;
    private double price;
    private String photographer;
    private String status;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getClientLastName() {
        return clientLastName;
    }

    @Override
    public void setClientLastName(String clientLastName) {
        this.clientLastName = clientLastName;
    }

    @Override
    public String getClientName() {
        return clientName;
    }

    @Override
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public String getClientPhone() {
        return clientPhone;
    }

    @Override
    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    @Override
    public LocalDateTime getPhotoSessionDate() {
        return photoSessionDate;
    }

    @Override
    public void setPhotoSessionDate(LocalDateTime photoSessionDate) {
        this.photoSessionDate = photoSessionDate;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getPhotographer() {
        return photographer;
    }

    @Override
    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}