package com.restaurant.bookingservice.model;

import java.time.LocalDateTime;

public class Table 
{
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

    
    public Table() 
    {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.available = true;
        this.isDeleted = false;
    }

    public Table (Long id, Integer number, Integer capacity, 
            String location, String description, boolean available)
    {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.location = location;
        this.description = description;
        this.available = available;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.createdBy = "System";
        this.available = true;
        this.isDeleted = false;
    }

    public Table (Long id, Integer number, Integer capacity, 
            String location, String description, boolean available,
            LocalDateTime createdAt, LocalDateTime updatedAt,
            String createdBy, boolean isDeleted)
    {
        this.id = id;
        this.number = number;
        this.capacity = capacity;
        this.location = location;
        this.description = description;
        this.available = available;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.available = available;
        this.isDeleted = isDeleted;
    }
    

    public Long getId()
    {
        return id;
    }

    public Integer getNumber()
    {
        return number;
    }

    public Integer getCapacity()
    {
        return capacity;
    }

    public String getLocation()
    {
        return location;
    }

    public String getDescription()
    {
        return description;
    }

    public boolean getAvailable()
    {
        return available;
    }

    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }

    public LocalDateTime getUpdateAt()
    {
        return updatedAt;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public boolean isDeleted()
    {
        return isDeleted;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public void setNumber(Integer number)
    {
        this.number = number;
    }

    public void setCapacity(Integer capacity)
    {
        this.capacity = capacity;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public void setUpdateAt(LocalDateTime updateAt)
    {
        this.updatedAt = updateAt;
    }

    public void setDeleted(boolean deleted)
    {
        isDeleted = deleted;
    }


}
