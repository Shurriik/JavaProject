package com.restaurant.bookingservice.dto.admin;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
}