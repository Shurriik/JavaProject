package com.restaurant.bookingservice.model;

import java.time.LocalDateTime;
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
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();
    @Builder.Default
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Builder.Default
    private String createdBy = "System";
    @Builder.Default
    private boolean isDeleted = false;

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
}