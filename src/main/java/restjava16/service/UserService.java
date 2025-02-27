package restjava16.service;

import restjava16.models.User;
import restjava16.response.SimpleResponse;

import java.util.List;

public interface UserService {
    List<User> getAll();

    SimpleResponse save(User user);

    User updateById(Long id, User user);

    void deleteById(Long id);
}
