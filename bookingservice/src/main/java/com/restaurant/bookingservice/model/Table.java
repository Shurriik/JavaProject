package com.restaurant.bookingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Table {
    private Long id;
    private Integer number;
    private Integer capacity;
    private String location;
    private String description;
    
    @Builder.Default
    private boolean available = true;
}