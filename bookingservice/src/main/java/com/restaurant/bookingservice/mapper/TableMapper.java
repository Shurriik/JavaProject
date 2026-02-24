package com.restaurant.bookingservice.mapper;

import com.restaurant.bookingservice.dto.admin.TableAdminRequest;
import com.restaurant.bookingservice.dto.admin.TableAdminResponse;
import com.restaurant.bookingservice.dto.user.TableUserRequest;
import com.restaurant.bookingservice.dto.user.TableUserResponse;
import com.restaurant.bookingservice.model.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class TableMapper {
    
    public TableUserResponse toUserResponse(Table table) {
        if (table == null) {
            return null;
        }

        return TableUserResponse.builder()
                .id(table.getId())
                .number(table.getNumber())
                .capacity(table.getCapacity())
                .location(table.getLocation())
                .description(table.getDescription())
                .available(table.isAvailable())
                .build();
    }

    public Table toEntityFromUserRequest(TableUserRequest request) {
        if (request == null) {
            return null;
        }

        return Table.builder()
                .number(request.getNumber())
                .capacity(request.getCapacity())
                .location(request.getLocation())
                .description(request.getDescription())
                .available(request.isAvailable())
                .createdBy("User")
                .build();
    }

    public TableAdminResponse toAdminResponse(Table table) {
        if (table == null) {
            return null;
        }

        return TableAdminResponse.builder()
                .id(table.getId())
                .number(table.getNumber())
                .capacity(table.getCapacity())
                .location(table.getLocation())
                .description(table.getDescription())
                .available(table.isAvailable())
                .createdAt(table.getCreatedAt())
                .updateAt(table.getUpdatedAt())
                .createdBy(table.getCreatedBy())
                .isDeleted(table.isDeleted())
                .build();
    }

    public Table toEntityFromAdminRequest(TableAdminRequest request) {
        if (request == null) {
            return null;
        }

        return Table.builder()
                .number(request.getNumber())
                .capacity(request.getCapacity())
                .location(request.getLocation())
                .description(request.getDescription())
                .available(request.isAvailable())
                .createdBy(request.getCreatedBy() != null ? request.getCreatedBy() : "admin")
                .isDeleted(request.isDeleted())
                .build();
    }

    public void updateEntityFromAdminRequest(Table table, TableAdminRequest request) {
        if (table == null || request == null) {
            return;
        }

        table.setNumber(request.getNumber());
        table.setCapacity(request.getCapacity());
        table.setLocation(request.getLocation());
        table.setDescription(request.getDescription());
        table.setCreatedBy(request.getCreatedBy());
        table.setDeleted(request.isDeleted());
        table.setUpdatedAt(LocalDateTime.now());
    }

    public List<TableAdminResponse> toAdminResponseList(List<Table> tables) {
        if (tables == null) {
            return List.of();
        }

        return tables.stream()
                .map(this::toAdminResponse)
                .toList(); 
    }

    public List<TableUserResponse> toUserResponseList(List<Table> tables) {
        if (tables == null) {
            return List.of();
        }

        return tables.stream()
                .map(this::toUserResponse)
                .toList(); 
    }
}