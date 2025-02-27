package restjava16.apis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restjava16.models.User;
import restjava16.response.SimpleResponse;
import restjava16.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserAPI {
    private final UserService userService;

    //find all
    @GetMapping
    public List<User> getUsers() {
        return userService.getAll();
    }

    // save
    @PostMapping
    public SimpleResponse save(@RequestBody User user) {
       return userService.save(user);
    };

    //update
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user) {
        return userService.updateById(id, user);
    }

    //delete id
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.deleteById(id);
    }


}
