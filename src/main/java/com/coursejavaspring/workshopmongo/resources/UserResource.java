package com.coursejavaspring.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coursejavaspring.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource{
	
	@RequestMapping(method=RequestMethod.GET) //ou
	//@GetMapping
	private ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Brow", "maria@gmail.com");
		User alex = new User("2", "Alex Green", "alex@gmail.com");
		User bob = new User("3", "Bob Silva", "bob@gmail.com");
		
		List<User> users = new ArrayList<>();
		users.addAll(Arrays.asList(maria,alex,bob));		
		return ResponseEntity.ok().body(users);		
	}
}
