package de.exceptionflug.userservice.model.database;

import de.exceptionflug.userservice.model.request.RequestUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DatabaseUser extends RequestUser {

    private int id;

}
