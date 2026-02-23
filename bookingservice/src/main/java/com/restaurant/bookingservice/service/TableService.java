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

    public TableUserResponse getTableByNumberForUser(Integer number) {
        Table table = tableRepository.findByNumber(number).orElse(null);
        return table == null ? null : tableMapper.toUserResponse(table);
    }

    public List<TableUserResponse> getTableByFilterForUser(Integer minCapacity,
            String location, Boolean available) {
        List<Table> tables = tableRepository.findByFilter(minCapacity, location, available);
        return tableMapper.toUserResponseList(tables);
    }

    public List<TableUserResponse> getTableByLocationForUser(String location) {
        List<Table> tables = tableRepository.findByLocation(location);
        return tableMapper.toUserResponseList(tables);
    }

    public List<TableUserResponse> getTableByAvailableForUser() {
        List<Table> tables = tableRepository.findByAvailable(true);
        return tableMapper.toUserResponseList(tables);
    }

    public List<TableUserResponse> getTableByMinCapacityForUser(Integer capacity) {
        List<Table> tables = tableRepository.findByMinCapacity(capacity);
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

    public boolean softDeletedTableForAdmin(Long id) {
        if (!tableRepository.existsById(id)) {
            return false;
        }
        tableRepository.softDeleted(id);
        return true;
    }

    public boolean restoredTableForAdmin(Long id) {
        if (!tableRepository.existsById(id)) {
            return false;
        }
        tableRepository.restoredById(id);
        return true;
    }

    public boolean hardDeletedByIdForAdmin(Long id) {
        if (!tableRepository.existsById(id)) {
            return false;
        }
        tableRepository.deleteById(id);
        return true;
    }

    public List<TableAdminResponse> getDeletedTablesForAdmin() {
        List<Table> tables = tableRepository.findDeleted();
        return tableMapper.toAdminResponseList(tables);
    }

    public long getTablesCountForAdmin() {
        return tableRepository.count();
    }
}