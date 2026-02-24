package com.restaurant.bookingservice.service;

import com.restaurant.bookingservice.dto.user.TableUserRequest;
import com.restaurant.bookingservice.dto.user.TableUserResponse;
import com.restaurant.bookingservice.mapper.TableMapper;
import com.restaurant.bookingservice.model.Table;
import com.restaurant.bookingservice.repository.TableRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TableService {
    private final TableRepository tableRepository;
    private final TableMapper tableMapper;

    public TableUserResponse createTableForUser(TableUserRequest request) {
        if (tableRepository.existsByNumber(request.getNumber())) {
            return null;  
        }

        Table table = tableMapper.toEntityFromUserRequest(request);
        Table savedTable = tableRepository.save(table);

        return tableMapper.toUserResponse(savedTable);
    }

    public List<TableUserResponse> getAllTableForUser() {
        List<Table> tables = tableRepository.findAll();
        return tableMapper.toUserResponseList(tables);
    }

    public TableUserResponse getTableByIdForUser(Long id) {
        Table table = tableRepository.findById(id).orElse(null);  
        if (table == null) {
            return null;
        }
        return tableMapper.toUserResponse(table);
    }

    public TableUserResponse getTableByNumberForUser(Integer number) {
        Table table = tableRepository.findByNumber(number).orElse(null);
        if (table == null) {
            return null;
        }
        return tableMapper.toUserResponse(table);
    }

    public List<TableUserResponse> getTableByFilterForUser(Integer minCapacity,
            String location, Boolean available) {
        List<Table> tables = tableRepository.findByFilter(minCapacity, location, available);
        return tableMapper.toUserResponseList(tables);
    }
}