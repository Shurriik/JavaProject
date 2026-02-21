package com.restaurant.bookingservice.dto.user;

public class TableUserResponse {
    private Long id;
    private Integer number;
    private Integer capacity;
    private String location;
    private String description;
    private boolean available;

    public TableUserResponse() {
    }

    public TableUserResponse(Long id, Integer number, Integer capacity, String location,
            String description, boolean available) {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.location = location;
        this.description = description;
        this.available = available;
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

}
