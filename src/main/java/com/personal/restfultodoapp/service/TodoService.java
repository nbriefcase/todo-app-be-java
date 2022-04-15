package com.personal.restfultodoapp.service;

import com.personal.restfultodoapp.model.Todo;
import com.personal.restfultodoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo deleteById(int id) {
        Todo toDelete = findById(id);
        if (toDelete == null) {
            return null;
        }
        todoRepository.delete(toDelete);
        return toDelete;
    }

    public Todo findById(long id) {
        return todoRepository.findById(id).orElse(new Todo());
    }
}
