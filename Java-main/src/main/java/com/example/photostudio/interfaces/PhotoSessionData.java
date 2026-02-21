package com.example.photostudio.interfaces;

import java.time.LocalDateTime;

public interface PhotoSessionData {

    Long getId();              
    String getClientLastName();
    String getClientName();
    String getClientPhone();
    LocalDateTime getPhotoSessionDate();  
    double getPrice();         
    String getPhotographer();
    String getStatus();
    
    void setId(Long id);
    void setClientLastName(String clientLastName);
    void setClientName(String clientName);
    void setClientPhone(String clientPhone);
    void setPhotoSessionDate(LocalDateTime photoSessionDate);
    void setPrice(double price);  
    void setPhotographer(String photographer);
    void setStatus(String status);
}