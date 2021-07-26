package com.ratz.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ratz.todo.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

	@Query("SELECT obj FROM Todo obj WHERE obj.finished = false ORDER BY obj.dateToFinish")
	List<Todo> findAllOpenTodos();

	@Query("SELECT obj FROM Todo obj WHERE obj.finished = true ORDER BY obj.dateToFinish")
	List<Todo> findAllClosedTodos();

}
