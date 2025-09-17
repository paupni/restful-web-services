package com.in28min.rest.webservices.restful_web_services.user;

import com.in28min.rest.webservices.restful_web_services.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.stream.Collectors;


import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("jpa/users")
public class UserJpaResource {

    private UserDaoService service;

    private UserRepository userRepository;

    public UserJpaResource(UserDaoService service, UserRepository userRepository) {
        this.service = service;
        this.userRepository = userRepository;
    }


    @GetMapping()
    public List<User> retrieveAllUsers(@RequestParam(required = false) String name) {
        List<User> users = userRepository.findAll();
        if (name != null && !name.isEmpty()) {
            return users.stream()
                    .filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        return users;

    }

    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable(name = "id") Integer id) {
        User user = userRepository.findById(id).orElse(null);

        if(user == null) {
            throw new UserNotFoundException("id:" + id);
        }

        return user;
    }

    @PostMapping("")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(savedUser.getId())
            .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") Integer id) {
        userRepository.deleteById(id);
    }


    @GetMapping("{id}/posts")
    public List<Post> retrievePostsforUser(@PathVariable(name = "id") Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + id);
        }
        return user.get().getPosts();

    }
}
