package com.restaurant.bookingservice.mapper;

import com.restaurant.bookingservice.dto.admin.TableAdminRequest;
import com.restaurant.bookingservice.dto.admin.TableAdminResponse;
import com.restaurant.bookingservice.dto.user.TableUserRequest;
import com.restaurant.bookingservice.dto.user.TableUserResponse;
import com.restaurant.bookingservice.model.Table;
import org.springframework.stereotype.Component;
import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;



@Component
public class TableMapper 
{
    public TableUserResponse toUserResponse(Table table)
    {
        if (table == null)
        {
            return null;
        }

        return new TableUserResponse(
            table.getId(),
            table.getNumber(),
            table.getCapacity(),
            table.getLocation(),
            table.getDescription(),
            table.getAvailable()
        );
    }

    public Table toEntityFromUserRequest(TableUserRequest request)
    {
        if (request == null)
        {
            return null;
        }

        Table table = new Table(
            null,
            request.getNumber(),
            request.getCapacity(),
            request.getLocation(),
            request.getDescription(),
            request.getAvailable()
        );
        
        table.setCreatedBy("User");
        return table;
    }

    public TableAdminResponse toAdminResponse(Table table)
    {
        if (table == null)
        {
            return null;
        }

        return new TableAdminResponse(
            table.getId(),
            table.getNumber(),
            table.getCapacity(),
            table.getLocation(),
            table.getDescription(),
            table.getAvailable(),
            table.getCreatedAt(),
            table.getUpdateAt(),
            table.getCreatedBy(),
            table.isDeleted()
        );

    }

    public Table toEntityFromAdminRequest(TableAdminRequest request)
    {
        if(request == null)
        {
            return null;
        } 
        
        Table table = new Table(
            null,
            request.getNumber(),
            request.getCapacity(),
            request.getLocation(),
            request.getDescription(),
            request.getAvailable()
        );
        table.setCreatedBy(request.getCreatedBy() != null ? request.getCreatedBy() : "admin");
        table.setDeleted(request.isDeleted());
        return table;
    }

    public void updateEntityFromAdminRequest(Table table, TableAdminRequest request)
    {
        if (table == null || request == null)
        {
            return;
        }

        table.setNumber(request.getNumber());
        table.setCapacity(request.getCapacity());
        table.setLocation(request.getLocation());
        table.setDescription(request.getDescription());
        table.setCreatedBy(request.getCreatedBy());
        table.setDeleted(request.isDeleted());
        table.setUpdateAt(LocalDateTime.now());
    }

    public List<TableAdminResponse> toAdminResponseList(List<Table> tables)
    {
        if (tables == null)
        {
            return new ArrayList<>();
        }

        List<TableAdminResponse> responses = new ArrayList<>();

        for (Table table : tables)
        {
            responses.add(toAdminResponse(table));
        }
        return responses;

    }

    public List<TableUserResponse> toUserResponseList(List<Table> tables)
    {
        if (tables == null)
        {
            return new ArrayList<>();
        }

        List<TableUserResponse> responses = new ArrayList<>();

        for (Table table : tables)
        {
            responses.add(toUserResponse(table));
        }
        
        return responses;
    }
}
