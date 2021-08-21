package com.learnwebservices.restfulwebservices.User;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class UserResource {
	@Autowired
	private UserDaoService service ;
	
	@GetMapping("/users")
	public List<User> findall()
	{
		return service.finadAll() ;
	}
	
	
	
	@GetMapping("/users/{id}")
	public EntityModel<User> findone(@PathVariable int id)
	{
		
		User user = service.findone(id);
		
		if(user == null) {
			throw new UserNotFoundException("id- "+ id);
		}
EntityModel<User> resource = EntityModel.of(user);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).findall());
		
		resource.add(linkTo.withRel("all-users"));
		return resource ;
	}
	@DeleteMapping("/users/{id}")
	public void deleteOne(@PathVariable int id)
	{
		
		User user = service.deleteOne(id);
		
		if(user == null) {
			throw new UserNotFoundException("id- "+ id);
		}
		
		
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createuser(@Valid @RequestBody User user)
	{
		User savedUser =  service.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
