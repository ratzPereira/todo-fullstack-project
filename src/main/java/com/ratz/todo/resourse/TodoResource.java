package com.ratz.todo.resourse;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping
	public ResponseEntity<List<Todo>> listAllTodos() {
		
		List<Todo> list = todoservice.findAllTodos();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody  Todo obj) {
		obj = todoservice.create(obj);
		
		//for good practice we return the URI of this request
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
		//if we want to send the obj created we can return like this.
		//return ResponseEntity.created(uri).body(obj);
		
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
		
		todoservice.deleteTodo(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable Integer id, @RequestBody Todo obj) {
		
		Todo newObj = todoservice.updateTodo(id,obj);
		return ResponseEntity.ok().body(newObj);
	}
	
}

