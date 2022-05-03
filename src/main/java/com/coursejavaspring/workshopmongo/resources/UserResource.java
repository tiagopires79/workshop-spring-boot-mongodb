package com.coursejavaspring.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coursejavaspring.workshopmongo.domain.User;
import com.coursejavaspring.workshopmongo.dto.UserDTO;
import com.coursejavaspring.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource{
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method=RequestMethod.GET) //ou
	//@GetMapping
	private ResponseEntity<List<UserDTO>> findAll(){
		List<User> users = service.findAll();
		List<UserDTO> usersDto = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(usersDto);		
	}
}
