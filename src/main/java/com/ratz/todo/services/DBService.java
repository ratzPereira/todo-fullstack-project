package com.ratz.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratz.todo.domain.Todo;
import com.ratz.todo.repository.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void startDataBase() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		Todo fistTodo = new Todo(null, "Study", "Study Spring Boot 2",
				LocalDateTime.parse("25/04/2021 10:33", formatter), false);

		todoRepository.saveAll(Arrays.asList(fistTodo));
	}
}
