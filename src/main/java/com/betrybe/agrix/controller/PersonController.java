package com.betrybe.agrix.controller;

import com.betrybe.agrix.dto.PersonCreationDto;
import com.betrybe.agrix.dto.PersonDto;
import com.betrybe.agrix.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


/**
 * Person Controller.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {
  @Autowired
  private PersonService personService;

  /**
   * Route to create.
   *
   * @param personCreationDto personCreationDto.
   * @return PersonDto.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto create(
          @RequestBody PersonCreationDto personCreationDto
  ) {
    return PersonDto.fromEntity(
            personService.create(personCreationDto.toEntity())
    );
  }
}
