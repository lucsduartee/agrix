package com.betrybe.agrix.dto;

import com.betrybe.agrix.entity.Person;
import com.betrybe.agrix.security.Role;

/**
 * PersonDto.
 *
 * @param id  id.
 * @param username username.
 * @param role role.
 */
public record PersonDto(
        Long id,
        String username,
        Role role
) {
  /**
   * From entity.
   *
   * @param person person.
   * @return personDto.
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
            person.getId(),
            person.getUsername(),
            person.getRole()
    );
  }
}
