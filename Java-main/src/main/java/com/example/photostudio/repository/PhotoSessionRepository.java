package com.example.photostudio.repository;

import com.example.photostudio.model.PhotoSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;


@Repository
public class PhotoSessionRepository {
    private final List<PhotoSession> storage = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public PhotoSessionRepository() {
        save(PhotoSession.builder()
                .clientLastName("Михалёнок")
                .clientName("Илона")
                .clientPhone("+375(29)155-00-37")
                .photoSessionDate(LocalDateTime.now().plusDays(1))
                .price(50)
                .photographer("Иванов Иван")
                .status("Отменена")
                .build());
        save(PhotoSession.builder()
                .clientLastName("Петрова")
                .clientName("Катя")
                .clientPhone("+375(44)185-25-69")
                .photoSessionDate(LocalDateTime.now().plusDays(1))
                .price(60)
                .photographer("Иванов Иван")
                .status("Запланирована")
                .build());
        save(PhotoSession.builder()
                .clientLastName("Сурма")
                .clientName("Таисия")
                .clientPhone("+375(29)887-40-65")
                .photoSessionDate(LocalDateTime.now().plusDays(1))
                .price(80)
                .photographer("Ковалькова Ирина")
                .status("Запланирована")
                .build());
        save(PhotoSession.builder()
                .clientLastName("Тасуханов")
                .clientName("Максим")
                .clientPhone("+375(29)741-52-37")
                .photoSessionDate(LocalDateTime.now().plusDays(1))
                .price(65)
                .photographer("Солонович Анна")
                .status("Завершина")
                .build());
    }

    public PhotoSession save(PhotoSession photoSession) {
        if (photoSession.getId() == null) {
            photoSession.setId(idGenerator.getAndIncrement());
            storage.add(photoSession);
        } else {
            for (int i = 0; i < storage.size(); i++) {
                if (storage.get(i).getId().equals(photoSession.getId())) {
                    storage.set(i, photoSession);
                    break;
                }
            }

        }
        return photoSession;
    }

    public List<PhotoSession> findAll() {
        return new ArrayList<>(storage);
    }

    public PhotoSession findById(Long id) {
        for (PhotoSession photoSession : storage) {
            if (photoSession.getId().equals(id)) {
                return photoSession;
            }
        }
        return null;
    }

    public void deleteById(Long id) {
        storage.removeIf(photoSession -> photoSession.getId().equals(id));
    }

    public boolean existById(Long id) {
        for (PhotoSession photoSession : storage) {
            if (photoSession.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<PhotoSession> findByFirstNameAndLastName(String clientName, String clientLastName) {
        List<PhotoSession> result = new ArrayList<>();
        for (PhotoSession photoSession : storage) {
            if (photoSession.getClientLastName().equalsIgnoreCase(clientLastName)
                    && (photoSession.getClientName().equalsIgnoreCase(clientName))) {
                result.add(photoSession);
            }
        }
        return result;
    }

    public List<PhotoSession> findByClientName(String clientName) {
        List<PhotoSession> result = new ArrayList<>();
        for (PhotoSession photoSession : storage) {
            if (photoSession.getClientName().equalsIgnoreCase(clientName)) {
                result.add(photoSession);
            }
        }
        return result;
    }

    public List<PhotoSession> findByStatus(String status) {
        List<PhotoSession> result = new ArrayList<>();
        for (PhotoSession photoSession : storage) {
            if (photoSession.getStatus().equalsIgnoreCase(status)) {
                result.add(photoSession);
            }
        }
        return result;
    }

    public List<PhotoSession> findByPhotographer(String photographer) {
        List<PhotoSession> result = new ArrayList<>();
        for (PhotoSession photoSession : storage) {
            if (photoSession.getPhotographer().equalsIgnoreCase(photographer)) {
                result.add(photoSession);
            }
        }
        return result;
    }
}
