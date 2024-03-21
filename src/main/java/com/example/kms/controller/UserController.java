package com.example.kms.controller;


import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
    /*@Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({ "/users/{id}", "/employees/{id}/user" })
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found user with id = " + id));

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/employees/{employeeId}/user")
    public ResponseEntity<User> createUser(@PathVariable(value = "employeeId") Integer employeeId,
                                                         @RequestBody User userRequest) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Not found employee with id = " + employeeId));

        userRequest.setSalt(userRequest.getSalt());
        userRequest.setRole(userRequest.getRole());
        userRequest.setUsername(userRequest.getUsername());
        userRequest.setPassword(userRequest.getPassword());
        userRequest.setEmployee(employee);
        User user = userRepository.save(userRequest);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id,
                                                         @RequestBody User userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id " + id + " not found"));

        user.setPassword(userRequest.getUsername());
        user.setPassword(userRequest.getPassword());

        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/employees/{employeeId}/user")
    public ResponseEntity<User> deleteUserOfEmployee(@PathVariable(value = "employeeId") Integer employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw new RuntimeException("Not found Employee with id = " + employeeId);
        }

        userRepository.deleteByEmployeeId(employeeId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }*/
}
