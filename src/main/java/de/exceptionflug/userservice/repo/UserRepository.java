package de.exceptionflug.userservice.repo;

import de.exceptionflug.userservice.model.request.RequestUser;
import de.exceptionflug.userservice.model.database.DatabaseUser;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class UserRepository {

  private final AtomicInteger idGenerator = new AtomicInteger();
  private final List<DatabaseUser> users = new ArrayList<>();

  public Optional<DatabaseUser> getUser(int id) {
    return users.stream().filter(user -> user.getId() == id).findAny();
  }

  public List<DatabaseUser> getUsers() {
    return Collections.unmodifiableList(users);
  }

  public void delete(int id) {
    users.removeIf(databaseUser -> databaseUser.getId() == id);
  }

  public DatabaseUser create(RequestUser user) {
    DatabaseUser out = new DatabaseUser();
    out.setId(idGenerator.incrementAndGet());
    out.setAge(user.getAge());
    out.setName(user.getName());
    out.setSurname(user.getSurname());
    users.add(out);
    return out;
  }
}
