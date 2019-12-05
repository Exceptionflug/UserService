package de.exceptionflug.userservice.api.impl;

import de.exceptionflug.userservice.api.UserController;
import de.exceptionflug.userservice.model.request.RequestUser;
import de.exceptionflug.userservice.model.database.DatabaseUser;
import de.exceptionflug.userservice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRestController implements UserController {

  private final UserRepository repository;

  @Override
  public ResponseEntity<DatabaseUser> getUser(int id) {
    Optional<DatabaseUser> userOptional = repository.getUser(id);
    return userOptional
        .map(databaseUser -> new ResponseEntity<>(databaseUser, HttpStatus.OK))
        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @Override
  public ResponseEntity<Integer> create(String name, String surname, int age) {
    if (surname == null ||
        name == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(repository.create(new RequestUser(name, surname, age)).getId(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<DatabaseUser>> getUsers() {
    return new ResponseEntity<>(repository.getUsers(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> delete(int id) {
    repository.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
