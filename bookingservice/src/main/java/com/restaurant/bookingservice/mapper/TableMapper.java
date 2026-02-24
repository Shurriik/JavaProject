package com.restaurant.bookingservice.mapper;

import com.restaurant.bookingservice.dto.user.TableUserRequest;
import com.restaurant.bookingservice.dto.user.TableUserResponse;
import com.restaurant.bookingservice.model.Table;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
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
                .build();
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