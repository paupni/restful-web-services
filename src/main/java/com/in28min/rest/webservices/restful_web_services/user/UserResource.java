package com.in28min.rest.webservices.restful_web_services.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.stream.Collectors;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping()
    public List<User> retrieveAllUsers(@RequestParam(required = false) String name) {
        List<User> users = service.findAllUsers();
        if (name != null && !name.isEmpty()) {
            return users.stream()
                    .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return users;

    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable(name = "id") Integer id) {
        User user = service.findUser(id);

        if(user == null) {
            throw new UserNotFoundException("id:" + id);
        }

        return user;
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) {
        service.deleteUser(id);
    }
}
