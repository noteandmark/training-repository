package com.home.andmark.firstrestapp.controller;

import com.home.andmark.firstrestapp.dto.PersonDTO;
import com.home.andmark.firstrestapp.model.Person;
import com.home.andmark.firstrestapp.service.PersonService;
import com.home.andmark.firstrestapp.util.PersonErrorResponse;
import com.home.andmark.firstrestapp.util.PersonNotCreatedException;
import com.home.andmark.firstrestapp.util.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/people")
public class PersonsController {

    private final PersonService personService;
    private final ModelMapper mapper;

    @Autowired
    public PersonsController(PersonService personService,
                             ModelMapper mapper) {
        this.personService = personService;
        this.mapper = mapper;
    }

    @GetMapping()
    public List<PersonDTO> getPersons() {
        //Jackson конвертирует эти объекты в JSON
        return personService.findAll()
                .stream()
                .map(this::convertToPersonDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable("id") int id) {
        return convertToPersonDTO(personService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid PersonDTO personDTO,
                                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error: errors) {
                errorMsg.append(error.getField())
                        .append(" - ").append(error.getDefaultMessage())
                        .append(";");
            }

            throw new PersonNotCreatedException(errorMsg.toString());

        }

        personService.save(convertToPerson(personDTO));

        //отправляем HTTP ответ с пустым телом и со стасусом 200
        return ResponseEntity.ok(HttpStatus.OK);
    }


    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotFoundException e){
        PersonErrorResponse response = new PersonErrorResponse(
                "Person with this id wasn't found!",
                System.currentTimeMillis()
        );
        //NOT_FOUND - 404 status
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    private ResponseEntity<PersonErrorResponse> handleException(PersonNotCreatedException e){
        PersonErrorResponse response = new PersonErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    private Person convertToPerson(PersonDTO personDTO) {
        return mapper.map(personDTO, Person.class);
    }

    private PersonDTO convertToPersonDTO(Person person) {
        return mapper.map(person,PersonDTO.class);
    }

}
