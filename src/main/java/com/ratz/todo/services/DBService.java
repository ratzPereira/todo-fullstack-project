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
		Todo todo1 = new Todo(null, "Study", "Study Spring Boot 2",
				LocalDateTime.parse("25/04/2021 10:33", formatter), false);
		Todo todo6 = new Todo(null, "Learn", "TypeScript",
				LocalDateTime.parse("25/04/2024 10:33", formatter), true);
		Todo todo2 = new Todo(null, "Buy", "New cloths",
				LocalDateTime.parse("21/04/2021 10:33", formatter), true);
		Todo todo3 = new Todo(null, "Play", "Video Games",
				LocalDateTime.parse("25/04/2021 10:33", formatter), false);
		Todo todo4 = new Todo(null, "Sleep", "More than 5 hours",
				LocalDateTime.parse("25/04/2022 10:33", formatter), true);
		Todo todo5 = new Todo(null, "Eat", "Dinner",
				LocalDateTime.parse("05/04/2021 10:33", formatter), false);

		todoRepository.saveAll(Arrays.asList(todo1,todo2,todo3,todo4,todo5,todo6));
	}
}
