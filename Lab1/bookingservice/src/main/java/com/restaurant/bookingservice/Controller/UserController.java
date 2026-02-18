package com.restaurant.bookingservice.Controller;
import com.restaurant.bookingservice.dto.user.TableUserRequest;
import com.restaurant.bookingservice.dto.user.TableUserResponse;
import com.restaurant.bookingservice.service.TableService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/tables")
public class UserController 
{
    private final TableService tableService;

    public UserController(TableService tableService)
    {
        this.tableService = tableService;
    }

    @PostMapping
    public ResponseEntity<TableUserResponse> createTable(@RequestBody TableUserRequest request)
    {
        TableUserResponse response = tableService.createTableForUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TableUserResponse>> getAllTables()
    {
        return ResponseEntity.ok(tableService.getAllTableForUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableUserResponse> getTableById(@PathVariable Long id)
    {
        return ResponseEntity.ok(tableService.getTableByIdForUser(id));
    }

    @GetMapping("/byNumber")
    public ResponseEntity<TableUserResponse> getTableByNumber(@RequestParam Integer number)
    {
        return ResponseEntity.ok(tableService.getTableByNumberForUser(number));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<TableUserResponse>> getTableByFilter(@RequestParam(required = false) Integer minCapacity, @RequestParam(required = false) String location, @RequestParam(required = false) boolean available)
    {
        return ResponseEntity.ok(tableService.getTableByFilterForUser(minCapacity, location, available));
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<TableUserResponse>> getTablesByLocation(@PathVariable String location) 
    {
        return ResponseEntity.ok(tableService.getTableByLocationForUser(location));
    }

    @GetMapping("/capacity/{minCapacity}")
    public ResponseEntity<List<TableUserResponse>> getTableByMinCapacity(@PathVariable Integer minCapacity)
    {
        return ResponseEntity.ok(tableService.getTableByMinCapacityForUser(minCapacity));
    }

    @GetMapping("/available")
    public ResponseEntity<List<TableUserResponse>> getTableByAvailable()
    {
        return ResponseEntity.ok(tableService.getTableByAvailableForUser());
    }

        @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex)
    {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
