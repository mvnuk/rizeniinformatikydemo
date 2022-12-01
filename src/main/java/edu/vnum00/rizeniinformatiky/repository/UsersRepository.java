package edu.vnum00.rizeniinformatiky.repository;

import edu.vnum00.rizeniinformatiky.entity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("usersRepository")
public class UsersRepository {

    private Map<Long, User> mapOfUsers;

    public UsersRepository() {
        mapOfUsers = new HashMap();
    }

    public List<User> findAll() {
        return mapOfUsers.values().stream().toList();
    }

    @PostConstruct
    private void fillMockData() {
        mapOfUsers.put(1l, new User( 1l, "Adam", "Novák", 23));
        mapOfUsers.put(2l, new User(2l, "Šimon", "Jáma", 7));
        mapOfUsers.put(3l, new User(3l, "Jana", "Stará", 25));
        mapOfUsers.put(3l, new User(4l, "Anežka", "Jahodová", 89));
    }

    public long findNextId() {
        return Collections.max(mapOfUsers.keySet()) + 1;
    }

    public void save(User user) {
        mapOfUsers.put(user.getId(), user);
    }

    public void remove(Long id) {
        mapOfUsers.remove(id);
    }
}
