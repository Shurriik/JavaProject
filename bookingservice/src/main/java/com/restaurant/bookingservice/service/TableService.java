package com.restaurant.bookingservice.service;

import com.restaurant.bookingservice.dto.admin.TableAdminRequest;
import com.restaurant.bookingservice.dto.admin.TableAdminResponse;
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
        Table table = tableRepository.findByIdAndNotDeleted(id).orElse(null);
        return table == null ? null : tableMapper.toUserResponse(table);
    }

    public List<TableUserResponse> getTableByFilterForUser(Integer minCapacity,
            String location, Boolean available) {
        List<Table> tables = tableRepository.findByFilter(minCapacity, location, available);
        return tableMapper.toUserResponseList(tables);
    }


    public TableAdminResponse createTableForAdmin(TableAdminRequest request) {
        if (tableRepository.existsByNumber(request.getNumber())) {
            return null;
        }

        Table table = tableMapper.toEntityFromAdminRequest(request);
        Table savedTable = tableRepository.save(table);
        return tableMapper.toAdminResponse(savedTable);
    }

    public List<TableAdminResponse> getAllTableForAdmin() {
        List<Table> tables = tableRepository.findAll();
        return tableMapper.toAdminResponseList(tables);
    }

    public TableAdminResponse getTableByIdForAdmin(Long id) {
        Table table = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Стол с таким id " + id + " не найден"));
        return tableMapper.toAdminResponse(table);
    }

    public TableAdminResponse updateTableForAdmin(Long id, TableAdminRequest request) {
        Table existingTable = tableRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Стол с таким id " + id + " не найден"));
        
        if (!existingTable.getNumber().equals(request.getNumber())
                && tableRepository.existsByNumber(request.getNumber())) {
            return null;
        }

        tableMapper.updateEntityFromAdminRequest(existingTable, request);
        Table updatedTable = tableRepository.save(existingTable);
        return tableMapper.toAdminResponse(updatedTable);
    }

    public long getTablesCountForAdmin() {
        return tableRepository.count();
    }
}