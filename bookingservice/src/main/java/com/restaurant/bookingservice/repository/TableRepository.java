package com.restaurant.bookingservice.repository;

import com.restaurant.bookingservice.model.Table;
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
        save(Table.builder().number(1).capacity(2).location("Окна")
                .description("Столик у окна").available(true).build());
        save(Table.builder().number(2).capacity(3).location("VIP")
                .description("Столик для VIP клиентов").available(true).build());
        save(Table.builder().number(3).capacity(10).location("Центральный зал")
                .description("Большой стол в центре").available(true).build());
        save(Table.builder().number(4).capacity(4).location("Терасса")
                .description("Столик на терассе").available(true).build());
    }

    public Table save(Table table) {
        if (table.getId() == null) {
            Table newTable = Table.builder()
                    .id(idGenerator.getAndIncrement())
                    .number(table.getNumber())
                    .capacity(table.getCapacity())
                    .location(table.getLocation())
                    .description(table.getDescription())
                    .available(table.isAvailable())
                    .build();
            tables.add(newTable);
            return newTable;
        } else {
            deleteById(table.getId());
            tables.add(table);
            return table;
        }
    }

    public Optional<Table> findById(Long id) {
        return tables.stream()
                .filter(table -> table.getId().equals(id))
                .findFirst();
    }

    public Optional<Table> findByNumber(Integer number) {
        return tables.stream()
                .filter(table -> table.getNumber().equals(number))
                .findFirst();
    }

    public List<Table> findAll() {
        return new ArrayList<>(tables);
    }

    public List<Table> findByFilter(Integer minCapacity, String location, Boolean available) {
        return tables.stream()
                .filter(table -> {
                    if (minCapacity != null && table.getCapacity() < minCapacity) {
                        return false;
                    }
                    if (location != null && !location.isEmpty() 
                            && !table.getLocation().equalsIgnoreCase(location)) {
                        return false;
                    }
                    return available == null || table.isAvailable() == available;
                })
                .toList();
    }

    public void deleteById(Long id) {
        tables.removeIf(table -> table.getId().equals(id));
    }

    public boolean existsByNumber(Integer number) {
        return tables.stream().anyMatch(table -> table.getNumber().equals(number));
    }

    public boolean existsById(Long id) {
        return tables.stream().anyMatch(table -> table.getId().equals(id));
    }

    public long count() {
        return tables.size();
    }
}