package com.ratz.todo.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.boot.SchemaAutoTooling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratz.todo.domain.Todo;
import com.ratz.todo.repository.TodoRepository;
import com.ratz.todo.services.exception.ObjectNotFoundException;

@Service
public class TodoService {
	
	@Autowired
	private TodoRepository todoRepository;
	
	public Todo findById(Integer id) {
		Optional<Todo> objOptional = todoRepository.findById(id);
		return objOptional.orElseThrow(()-> new ObjectNotFoundException("Object not found. Id: " + id + "Tipo: " +
		Todo.class.getName()));
		
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

	public Todo updateTodo(Integer id, Todo obj) {
		Todo todo = findById(id);
		todo.setTitle(obj.getTitle());
		todo.setDateToFinish(obj.getDateToFinish());
		todo.setDescription(obj.getDescription());
		todo.setFinished(obj.getFinished());
		
		return todoRepository.save(todo);
		
	}
}
