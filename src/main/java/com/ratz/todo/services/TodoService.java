package com.ratz.todo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratz.todo.domain.Todo;
import com.ratz.todo.repository.TodoRepository;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo findById(Integer id) {
		Optional<Todo> objOptional = todoRepository.findById(id);
		return objOptional.orElse(null);
		
	}

	public List<Todo> findAllOpenTodos() {
		List<Todo> list = todoRepository.findAllOpenTodos();
		return list;
	}

	public List<Todo> findAllClosedTodos() {
		List<Todo> list = todoRepository.findAllClosedTodos();
		return list;
	}

	public List<Todo> findAllTodos() {
		List<Todo> list = todoRepository.findAll();
		return list;
	}

	public Todo create(Todo obj) {
		obj.setId(null);
		return todoRepository.save(obj);
	}

	public void deleteTodo(Integer id) {
		todoRepository.deleteById(id);
		}
}
