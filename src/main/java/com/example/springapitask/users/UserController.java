package com.example.springapitask.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @PutMapping(path = "/{userId}")
    public void updateUser(@PathVariable Long userId, @RequestParam(required = false) String name
            , @RequestParam(required = false) String email,
                           @RequestParam(required = false) String city)
    {
        userService.updateUser(userId, name,email,city);
    }

}
