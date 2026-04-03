package br.com.api.rest;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();
    private final AtomicInteger idGenerator = new AtomicInteger(1002);

    public ItemService() {
        items.add(new Item(1000, "cat", "cat is meowing"));
        items.add(new Item(1001, "dog", "dog is barking"));
        items.add(new Item(1002, "bird", "bird is singing"));
    }

    public Map<String, Object> list() {
        return Map.of(
                "count", items.size(),
                "items", items
        );
    }

    public Map<String, Object> search(String q) {
        if (q == null) {
            return Map.of("error", "q parameter required");
        }

        List<Item> results = items.stream()
                .filter(i -> i.name().contains(q))
                .toList();

        return Map.of(
                "count", results.size(),
                "items", results
        );
    }

    public Object add(Map<String, Object> body) {
        String name = (String) body.get("name");
        String description = (String) body.get("description");

        if (name == null || description == null) {
            return Map.of("error", "name and description are required parameters");
        }

        int newId = idGenerator.incrementAndGet();
        Item item = new Item(newId, name, description);
        items.add(item);

        return item;
    }

    public Map<String, Object> delete(Integer id) {
        if (id == null) {
            return Map.of("error", "id parameter required");
        }

        Optional<Item> found = items.stream()
                .filter(i -> i.id().equals(id))
                .findFirst();

        if (found.isPresent()) {
            items.remove(found.get());
            return Map.of("deleted", id);
        }

        return Map.of("error", "item not found with id " + id);
    }
}