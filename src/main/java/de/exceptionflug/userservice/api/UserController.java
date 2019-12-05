package de.exceptionflug.userservice.api;

import de.exceptionflug.userservice.model.database.DatabaseUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface UserController {

  @GetMapping("/api/user")
  ResponseEntity<DatabaseUser> getUser(@RequestParam("id") int id);

  @PutMapping("/api/user")
  ResponseEntity<Integer> create(@RequestParam("name") String name,
                                 @RequestParam("surname") String surname,
                                 @RequestParam("age") int age);

  @GetMapping("/api/users")
  ResponseEntity<List<DatabaseUser>> getUsers();

  @DeleteMapping("/api/user")
  ResponseEntity<Void> delete(@RequestParam("id") int id);
}
