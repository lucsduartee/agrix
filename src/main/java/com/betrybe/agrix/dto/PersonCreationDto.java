package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Person;
import com.betrybe.agrix.security.Role;

/**
 * PersonCreationDto.
 *
 * @param username username.
 * @param password password.
 * @param role role.
 */
public record PersonCreationDto(
        String username,
        String password,
        Role role
) {
  public Person toEntity() {
    return new Person(username, password, role);
  }
}
