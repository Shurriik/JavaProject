package com.restaurant.bookingservice.controller;

import com.restaurant.bookingservice.dto.user.TableUserRequest;
import com.restaurant.bookingservice.dto.user.TableUserResponse;
import com.restaurant.bookingservice.service.TableService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/user/tables")
@RequiredArgsConstructor
public class UserController {
    private final TableService tableService;

    @PostMapping
    public ResponseEntity<TableUserResponse> createTable(@RequestBody TableUserRequest request) {
        TableUserResponse response = tableService.createTableForUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TableUserResponse>> getAllTables() {
        return ResponseEntity.ok(tableService.getAllTableForUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableUserResponse> getTableById(@PathVariable Long id) {
        return ResponseEntity.ok(tableService.getTableByIdForUser(id));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TableUserResponse>> getTableByFilter(
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) Integer minCapacity,
            @RequestParam(required = false) String location, 
            @RequestParam(required = false) Boolean available) {
        return ResponseEntity.ok(tableService.getTableByFilterForUser(
            minCapacity, location, available));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}