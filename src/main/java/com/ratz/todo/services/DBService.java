package com.ratz.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratz.todo.domain.Todo;
import com.ratz.todo.repository.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;
	

	public void startDataBase() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Todo todo1 = new Todo(null, "Study", "Study Spring Boot 2",
				simpleDateFormat.parse("25/04/2021"), false);
		Todo todo6 = new Todo(null, "Learn", "TypeScript",
				simpleDateFormat.parse("25/04/2024"), true);
		Todo todo2 = new Todo(null, "Buy", "New cloths",
				simpleDateFormat.parse("21/04/2021"), true);
		Todo todo3 = new Todo(null, "Play", "Video Games",
				simpleDateFormat.parse("25/04/2021"), false);
		Todo todo4 = new Todo(null, "Sleep", "More than 5 hours",
				simpleDateFormat.parse("25/04/2022"), true);
		Todo todo5 = new Todo(null, "Eat", "Dinner",
				simpleDateFormat.parse("05/04/2021"), false);
		

		todoRepository.saveAll(Arrays.asList(todo1,todo2,todo3,todo4,todo5,todo6));
	}
}
