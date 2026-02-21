package com.restaurant.bookingservice.repository;

import com.restaurant.bookingservice.model.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;



@Repository
public class TableRepository {
    private final List<Table> tables = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public TableRepository() {
        save(new Table(null, 1, 2, "Окна", "Столик у окна", true));
        save(new Table(null, 2, 3, "VIP", "Столик для VIP клиентов", true));
        save(new Table(null, 3, 10, "Центральный зал", "Большой стол в центре", true));
        save(new Table(null, 4, 4, "Терасса", "Столик на терассе", true));
    }

    public Table save(Table table) {
        if (table.getId() == null) {
            Table newTable = new Table(
                    idGenerator.getAndIncrement(),
                    table.getNumber(),
                    table.getCapacity(),
                    table.getLocation(),
                    table.getDescription(),
                    table.getAvailable());
            tables.add(newTable);
            return newTable;
        } else {
            deleteById(table.getId());
            table.setUpdatedAt(LocalDateTime.now());
            tables.add(table);
            return table;
        }
    }

    public Optional<Table> findById(Long id) {
        for (Table table : tables) {
            if (table.getId().equals(id)) {
                return Optional.of(table);
            }
        }
        return Optional.empty();
    }

    public Optional<Table> findByIdAndNotDeleted(Long id) {
        for (Table table : tables) {
            if (table.getId().equals(id) && !table.isDeleted()) {
                return Optional.of(table);
            }
        }
        return Optional.empty();
    }

    public Optional<Table> findByNumber(Integer number) {
        for (Table table : tables) {
            if (table.getNumber().equals(number)) {
                return Optional.of(table);
            }
        }
        return Optional.empty();
    }

    public List<Table> findAllNotDeleted() {
        List<Table> result = new ArrayList<>();
        for (Table table : tables) {
            if (!table.isDeleted()) {
                result.add(table);
            }
        }
        return result;
    }

    public List<Table> findAll() {
        return new ArrayList<>(tables);
    }

    public List<Table> findByLocation(String location) {
        List<Table> result = new ArrayList<>();
        for (Table table : tables) {
            if (table.getLocation().equalsIgnoreCase(location)) {
                result.add(table);
            }
        }
        return result;
    }

    public List<Table> findByMinCapacity(int capacity) {
        List<Table> result = new ArrayList<>();
        for (Table table : tables) {
            if (table.getCapacity() == capacity) {
                result.add(table);
            }
        }
        return result;
    }

    public List<Table> findByAvailable(boolean available) {
        List<Table> result = new ArrayList<>();
        for (Table table : tables) {
            if (table.getAvailable() == available) {
                result.add(table);
            }
        }
        return result;
    }

    public List<Table> findDeleted() {
        List<Table> result = new ArrayList<>();
        for (Table table : tables) {
            if (table.isDeleted()) {
                result.add(table);
            }
        }
        return result;

    }

    public void deleteById(Long id) {
        tables.removeIf(table -> table.getId().equals(id));
    }

    public void softDeleted(Long id) {
        for (Table table : tables) {
            if (table.getId().equals(id)) {
                table.setDeleted(true);
                table.setUpdatedAt(LocalDateTime.now());
                break;
            }
        }
    }

    public void restoredById(Long id) {
        for (Table table : tables) {
            if (table.getId().equals(id) && table.isDeleted()) {
                table.setDeleted(false);
                table.setUpdatedAt(LocalDateTime.now());
                break;
            }
        }
    }

    public boolean existsByNumber(Integer number) {
        for (Table table : tables) {
            if (table.getNumber().equals(number)) {
                return true;
            }
        }
        return false;
    }

    public boolean existsById(Long id) {
        for (Table table : tables) {
            if (table.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public List<Table> findByFilter(Integer minCapacity, String location, Boolean available) {
        List<Table> result = new ArrayList<>();
        for (Table table : tables) {
            boolean matches = true;

            if (minCapacity != null && table.getCapacity() < minCapacity) {
                matches = false;
            }
            if (matches && location != null && !location.isEmpty() 
                    && !table.getLocation().equalsIgnoreCase(location)) {
                matches = false;
            }
            if (matches && available != null) {
                matches = false;
            }
            if (matches) {
                result.add(table);
            }
        }
        return result;
    }

    public long count() {
        return tables.size();
    }

    public long countNotDeleted() {
        return tables.stream().filter(t -> !t.isDeleted()).count();
    }

}
