package com.restaurant.bookingservice.dto.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableUserRequest {
    private Integer number;
    private Integer capacity;
    private String location;
    private String description;
    @Builder.Default
    private boolean available = true;
}