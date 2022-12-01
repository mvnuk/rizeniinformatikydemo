package edu.vnum00.rizeniinformatiky.services;

import edu.vnum00.rizeniinformatiky.entity.User;
import edu.vnum00.rizeniinformatiky.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void addUser(User user) {
        user.setId(usersRepository.findNextId());
        usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        usersRepository.remove(id);
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }
}
