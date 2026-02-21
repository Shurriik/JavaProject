package com.restaurant.bookingservice.dto.admin;

public class TableAdminRequest {
    private Integer number;
    private Integer capacity;
    private String location;
    private String description;
    private boolean available;
    private String createdBy;
    private boolean isDeleted;

    public TableAdminRequest() {
        this.available = true;
        this.isDeleted = false;
    }

    public TableAdminRequest(Integer number, Integer capacity, String location, String description,
            boolean available, String createdBy, boolean isDeleted) {
        this.number = number;
        this.capacity = capacity;
        this.location = location;
        this.description = description;
        this.available = available;
        this.createdBy = createdBy;
        this.isDeleted = isDeleted;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public boolean isDeleted() {
        return isDeleted;
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

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

}
