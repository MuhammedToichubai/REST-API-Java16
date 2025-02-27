package restjava16.service;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restjava16.models.User;
import restjava16.repo.UserRepo;
import restjava16.response.SimpleResponse;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public SimpleResponse save(User user) {
        try {
            userRepo.save(user);
        } catch (Exception e) {
            return SimpleResponse.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.CONFLICT)
                    .build();
        }
        return SimpleResponse.builder()
                .message("User successfully saved")
                .status(HttpStatus.CREATED)
                .build();
    }

    @Override
    @Transactional
    public User updateById(Long id, User user) {
        User foundUser = userRepo.findById(id).orElseThrow(() ->
                new NoSuchElementException("User with id : " + id + "not found"));
        foundUser.setEmail(user.getEmail());
        foundUser.setFirstName(user.getFirstName());
        foundUser.setLastName(user.getLastName());
        foundUser.setPassword(user.getPassword());
        foundUser.setPhone(user.getPhone());
        foundUser.setGender(user.getGender());
        return foundUser;
    }

    @Override
    public void deleteById(Long id) {
        userRepo.findById(id).orElseThrow(() ->
                new NoSuchElementException("User with id : " + id + "not found"));
        userRepo.deleteById(id);
    }
}
