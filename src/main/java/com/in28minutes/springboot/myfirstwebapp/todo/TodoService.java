package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;



@Service
//정적인 투두 리스트
public class TodoService {
	
	//todos라는 리스트 변수에 new Todo 변수를 하나씩 담는다. 3개.
	private static List<Todo> todos = new ArrayList<Todo>();
	
	private static int todosCount = 0;
	
	static {
		//리스트를 하나씩 임의로 추가시킨다.
		todos.add(new Todo(++todosCount,"in28minutes","Learn AWS",
				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount,"in28minutes","Learn DevOps",
				LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount,"in28minutes","Learn Full Stack Development",
				LocalDate.now().plusYears(3), false));
	}
	//리스트 내보내기
	//username이 맞으면
	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(predicate).toList();
	}
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(++todosCount,username,description,targetDate,done);
		todos.add(todo);
	}
	
	public void deleteById(int id) {
		
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
		
	}
}
