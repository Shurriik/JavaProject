package com.restaurant.bookingservice.controller;

import com.restaurant.bookingservice.dto.admin.TableAdminRequest;
import com.restaurant.bookingservice.dto.admin.TableAdminResponse;
import com.restaurant.bookingservice.service.TableService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/admin/tables")
@RequiredArgsConstructor
public class AdminController {
    private final TableService tableService;

    @PostMapping
    public ResponseEntity<TableAdminResponse> createTable(@RequestBody TableAdminRequest request) {
        TableAdminResponse response = tableService.createTableForAdmin(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TableAdminResponse>> getAllTables() {
        return ResponseEntity.ok(tableService.getAllTableForAdmin());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableAdminResponse> getTableById(@PathVariable Long id) {
        return ResponseEntity.ok(tableService.getTableByIdForAdmin(id));
    }

    @GetMapping("/deleted")
    public ResponseEntity<List<TableAdminResponse>> getDeletedTables() {
        return ResponseEntity.ok(tableService.getDeletedTablesForAdmin());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableAdminResponse> updateTable(@PathVariable Long id,
            @RequestBody TableAdminRequest request) {
        return ResponseEntity.ok(tableService.updateTableForAdmin(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteTable(@PathVariable Long id) {
        boolean deleted = tableService.softDeletedTableForAdmin(id);
        return deleted 
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}/hard")
    public ResponseEntity<Void> hardDeleteTable(@PathVariable Long id) {
        boolean deleted = tableService.hardDeletedByIdForAdmin(id);
        return deleted 
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/restore")
    public ResponseEntity<Void> restoreTable(@PathVariable Long id) {
        boolean restored = tableService.restoredTableForAdmin(id);
        return restored 
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTablesCount() {
        return ResponseEntity.ok(tableService.getTablesCountForAdmin());
    }
}