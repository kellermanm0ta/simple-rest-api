package br.com.api.rest;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/")
public class ApiController {

    private final ItemService service;

    public ApiController(ItemService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> index() {
        return Map.of(
                "name", "Java Spring Boot REST API Example",
                "summary", "This is simple REST API architecture with Spring Boot",
                "actions", new String[]{"add", "delete", "list", "search"},
                "version", "1.0.0"
        );
    }

    @GetMapping("list")
    public Map<String, Object> list() {
        return service.list();
    }

    @GetMapping("search")
    public Map<String, Object> search(@RequestParam(required = false) String q) {
        return service.search(q);
    }

    @PostMapping("add")
    public Object add(@RequestBody(required = false) Map<String, Object> body) {
        if (body == null) {
            return Map.of("error", "posted data must be in json format");
        }
        return service.add(body);
    }

    @PostMapping("delete")
    public Map<String, Object> delete(@RequestBody Map<String, Object> body) {
        Integer id = body.get("id") instanceof Integer
                ? (Integer) body.get("id")
                : null;

        return service.delete(id);
    }
}