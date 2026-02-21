package com.restaurant.bookingservice.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableAdminRequest {
    private Integer number;
    private Integer capacity;
    private String location;
    private String description;
    @Builder.Default
    private boolean available = true;
    private String createdBy;
    @Builder.Default
    private boolean isDeleted = false;
}