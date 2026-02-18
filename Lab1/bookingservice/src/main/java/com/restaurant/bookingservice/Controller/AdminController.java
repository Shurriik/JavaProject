package com.restaurant.bookingservice.Controller;
import com.restaurant.bookingservice.dto.admin.TableAdminRequest;
import com.restaurant.bookingservice.dto.admin.TableAdminResponse;
import com.restaurant.bookingservice.service.TableService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/tables")
public class AdminController
{

    private final TableService tableService;

    public AdminController(TableService tableService)
    {
        this.tableService = tableService;
    }

    @PostMapping
    public ResponseEntity<TableAdminResponse> createTable(@RequestBody TableAdminRequest request)
    {
        TableAdminResponse response = tableService.createTableForAdmin(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TableAdminResponse>> getAllTables()
    {
        return ResponseEntity.ok(tableService.getAllTableForAdmin());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TableAdminResponse> getTableById(@PathVariable Long id)
    {
        return ResponseEntity.ok(tableService.getTableByIdForAdmin(id));
    }
    
    @GetMapping("/deleted")
    public ResponseEntity<List<TableAdminResponse>> getDeletedTables()
    {
        return ResponseEntity.ok(tableService.getDeletedTablesForAdmin());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableAdminResponse> updateTable(@PathVariable Long id, @RequestBody TableAdminRequest request)
    {
        return ResponseEntity.ok(tableService.updateTableForAdmin(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> softDeleteTable(@PathVariable Long id)
    {
        tableService.softDeletedTableForAdmin(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/hard")
    public ResponseEntity<Void> hardDeleteTable(@PathVariable Long id)
    {
        tableService.hardDeletedByIdForAdmin(id);
        return ResponseEntity.noContent().build();
    }
    
    @PutMapping("/{id}/restore")
    public ResponseEntity<Void> restoreTable(@PathVariable Long id)
    {
        tableService.restoredTableForAdmin(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTablesCount()
    {
        return ResponseEntity.ok(tableService.getTablesCountForAdmin());
    }


        
}
