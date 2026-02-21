package com.restaurant.bookingservice.model;

import java.time.LocalDateTime;

public class Table {
    private Long id;
    private Integer number;
    private Integer capacity;
    private String location;
    private String description;
    private boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private boolean isDeleted;

    private Table(Builder builder) {
        this.id = builder.id;
        this.number = builder.number;
        this.capacity = builder.capacity;
        this.location = builder.location;
        this.description = builder.description;
        this.available = builder.available;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
        this.createdBy = builder.createdBy;
        this.isDeleted = builder.isDeleted;
    }

    public Table() {
    }

    public Table(Long id, Integer number, Integer capacity,
            String location, String description, boolean available) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.location = location;
        this.description = description;
        this.available = available;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.createdBy = "System";
        this.isDeleted = false;
    }

    public static class Builder {
        private Long id;
        private Integer number;
        private Integer capacity;
        private String location;
        private String description;
        private boolean available;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private String createdBy;
        private boolean isDeleted;

        public Builder(Integer number, Integer capacity, String location) {
            this.number = number;
            this.capacity = capacity;
            this.location = location;
            this.available = true;
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
            this.createdBy = "System";
            this.isDeleted = false;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder available(boolean available) {
            this.available = available;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder createdBy(String createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public Builder isDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
            return this;
        }

        public Table build() {
            return new Table(this);
        }
    }

    public Long getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public boolean getAvailable() {
        return available;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setUpdatedAt(LocalDateTime updateAt) {
        this.updatedAt = updateAt;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

}
