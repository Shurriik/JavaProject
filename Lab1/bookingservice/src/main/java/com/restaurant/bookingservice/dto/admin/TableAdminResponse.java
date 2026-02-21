package com.restaurant.bookingservice.dto.admin;

import java.time.LocalDateTime;

public class TableAdminResponse {
    private Long id;
    private Integer number;
    private Integer capacity;
    private String location;
    private String description;
    private boolean available;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private String createdBy;
    private boolean isDeleted;

    public TableAdminResponse() {
    }

    public TableAdminResponse(Builder builder) {
        this.id = builder.id;
        this.number = builder.number;
        this.capacity = builder.capacity;
        this.location = builder.location;
        this.description = builder.description;
        this.available = builder.available;
        this.createdAt = builder.createdAt;
        this.updateAt = builder.updateAt;
        this.createdBy = builder.createdBy;
        this.isDeleted = builder.isDeleted;

    }

    public static class Builder {
        private Long id;
        private Integer number;
        private Integer capacity;
        private String location;
        private String description;
        private boolean available;
        private LocalDateTime createdAt;
        private LocalDateTime updateAt;
        private String createdBy;
        private boolean isDeleted;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder number(Integer number) {
            this.number = number;
            return this;
        }

        public Builder capacity(Integer capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
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
        
        public Builder updateAt(LocalDateTime updateAt) {
            this.updateAt = updateAt;
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

        public TableAdminResponse build() {
            return new TableAdminResponse(this);
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

    public LocalDateTime getUpdateAt() {
        return updateAt;
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

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
