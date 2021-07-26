package com.ratz.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ratz.todo.domain.Todo;
import com.ratz.todo.repository.TodoRepository;

@SpringBootApplication
public class TodoFullstackProjectApplication implements CommandLineRunner{
	
	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoFullstackProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Todo fistTodo = new Todo(null ,"Study","Study Spring Boot 2",LocalDateTime.parse("25/04/2021 10:33", formatter),false);
		
		todoRepository.saveAll(Arrays.asList(fistTodo));
		
	}


}
