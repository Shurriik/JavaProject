package com.example.photostudio.dto;

import com.example.photostudio.interfaces.PhotoSessionData;
import java.time.LocalDateTime;

public class PhotoSessionAdminResponseDto implements PhotoSessionData {
    private Long id;
    private String clientLastName;
    private String clientName;
    private String clientPhone;
    private LocalDateTime photoSessionDate;
    private double price;
    private String photographer;
    private String status;

    public PhotoSessionAdminResponseDto() {}

    private PhotoSessionAdminResponseDto(Builder builder) {
        this.id = builder.id;
        this.clientLastName = builder.clientLastName;
        this.clientName = builder.clientName;
        this.clientPhone = builder.clientPhone;
        this.photoSessionDate = builder.photoSessionDate;
        this.price = builder.price;
        this.photographer = builder.photographer;
        this.status = builder.status;
    }

    public static Builder builder() {
        return new Builder();
    }

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

    public static class Builder {
        private Long id;
        private String clientLastName;
        private String clientName;
        private String clientPhone;
        private LocalDateTime photoSessionDate;
        private double price;
        private String photographer;
        private String status;

        private Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder clientLastName(String clientLastName) {
            this.clientLastName = clientLastName;
            return this;
        }

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder clientPhone(String clientPhone) {
            this.clientPhone = clientPhone;
            return this;
        }

        public Builder photoSessionDate(LocalDateTime photoSessionDate) {
            this.photoSessionDate = photoSessionDate;
            return this;
        }

        public Builder price(double price) {
            this.price = price;
            return this;
        }

        public Builder photographer(String photographer) {
            this.photographer = photographer;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public PhotoSessionAdminResponseDto build() {
            return new PhotoSessionAdminResponseDto(this);
        }
    }
}