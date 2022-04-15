package com.personal.restfultodoapp.controller;

import com.personal.restfultodoapp.model.Todo;
import com.personal.restfultodoapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/users")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = "/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    @PostMapping(value = "/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{username}/todos/{id}")
    public ResponseEntity<Todo> setTodo(@PathVariable String username, @PathVariable Integer id, @RequestBody Todo todo) {
        todo = todoService.save(todo);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Integer id) {
        Todo todo = todoService.deleteById(id);
        if (todo != null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/{username}/todos/{id}")
    public Todo getTodo(@PathVariable Integer id, @PathVariable String username) {
        return todoService.findById(id);
    }
}
