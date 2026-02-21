package com.example.photostudio.controller;

import com.example.photostudio.dto.PhotoSessionAdminResponseDto;
import com.example.photostudio.dto.PhotoSessionRequestDto;
import com.example.photostudio.dto.PhotoSessionResponseDto;
import com.example.photostudio.service.PhotoSessionService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/photoSession")
public class PhotoSessionController {
    private final PhotoSessionService service;

    public PhotoSessionController(PhotoSessionService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PhotoSessionResponseDto>> getPhotosessions(
            @RequestParam(value = "client", required = false) String clientName) {
        List<PhotoSessionResponseDto> photoSessions;

        if (clientName != null && !clientName.trim().isEmpty()) {
            photoSessions = service.getPhotoSessionByClientName(clientName);
        } else {
            photoSessions = service.getAllPhotoSessions();
        }
        return new ResponseEntity<>(photoSessions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoSessionResponseDto> getPhotoSessionById(@PathVariable Long id) {
        PhotoSessionResponseDto photoSession = service.getPhotoSessionById(id);

        if (photoSession == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(photoSession, HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<PhotoSessionAdminResponseDto>> getPhotoSessionFormAdmin(
            @RequestParam(value = "client", required = false) 
            String clientName, String clientLastName) {
        List<PhotoSessionAdminResponseDto> photoSessions;

        if ((clientName != null && !clientName.trim().isEmpty())
                || (clientLastName != null && !clientLastName.trim().isEmpty())) {
            photoSessions = service.
            getPhotoSessionForAdminClientFullName(clientLastName, clientName);
        } else {
            photoSessions = service.getAllPhotoSessionForAdmin();
        }
        return new ResponseEntity<>(photoSessions, HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<PhotoSessionAdminResponseDto>
        getPhotoSessionFormAdminById(@PathVariable Long id) {
        PhotoSessionAdminResponseDto photoSession = service.getPhotoSessionForAdminById(id);

        if (photoSession == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(photoSession, HttpStatus.OK);
    }

    @PostMapping("/admin")
    public ResponseEntity<PhotoSessionResponseDto>
        createPhotoSession(@RequestBody PhotoSessionRequestDto requestDto) {
        PhotoSessionResponseDto createdPhotoSession = service.createPhotoSession(requestDto);
        return new ResponseEntity<>(createdPhotoSession, HttpStatus.CREATED);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<PhotoSessionAdminResponseDto> updatePhotoSession(@PathVariable Long id,
            @RequestBody PhotoSessionAdminResponseDto adminDto) {
        PhotoSessionAdminResponseDto photoSession = 
            service.updatePhotoSessionFormAdmin(id, adminDto);

        if (photoSession == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(photoSession, HttpStatus.OK);
    }

    @PatchMapping("/admin/{id}")
    public ResponseEntity<PhotoSessionResponseDto> partialUpdatePhotoSession(@PathVariable Long id,
            @RequestBody PhotoSessionRequestDto requestDto) {
        PhotoSessionResponseDto updatePhotoSession = service.updatePhotoSession(id, requestDto);

        if (updatePhotoSession == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatePhotoSession, HttpStatus.OK);
    }

    @DeleteMapping("/admin{id}")
    public ResponseEntity<Void> deletePhotoSession(@PathVariable long id) {
        boolean delete = service.deletePhotoSession(id);

        if (delete) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
