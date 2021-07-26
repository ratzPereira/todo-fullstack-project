package com.ratz.todo.resourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratz.todo.domain.Todo;
import com.ratz.todo.services.TodoService;

@RestController
@RequestMapping(value = "/todos")
public class TodoResource {
	
	@Autowired
	private TodoService todoservice;
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		Todo obj = todoservice.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping(value = "/open")
	public ResponseEntity<List<Todo>> listAllOpenTodos() {
		
		List<Todo> list = todoservice.findAllOpenTodos();
		return ResponseEntity.ok().body(list);
		
	}
	
	@GetMapping(value = "/closed")
	public ResponseEntity<List<Todo>> listAllClosedTodos() {
		
		List<Todo> list = todoservice.findAllClosedTodos();
		return ResponseEntity.ok().body(list);
				
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<List<Todo>> listAllTodos() {
		
		List<Todo> list = todoservice.findAllTodos();
		return ResponseEntity.ok().body(list);
	}
}


//localhost:8080/todos
//localhost:8080/todos/1