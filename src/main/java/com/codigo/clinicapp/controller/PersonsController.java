package com.codigo.clinicapp.controller;

import com.codigo.clinicapp.aggregates.request.RequestPersons;
import com.codigo.clinicapp.aggregates.response.ResponseBase;
import com.codigo.clinicapp.service.PersonsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/persons")
public class PersonsController {
    private final PersonsService personsService;

    public PersonsController(PersonsService personsService) {
        this.personsService = personsService;
    }

    @PostMapping
    public ResponseBase createPerson(@RequestBody RequestPersons requestPersons) {
        return personsService.createPersons(requestPersons);
    }

    @GetMapping("{id}")
    public ResponseBase findOnePersonById(@PathVariable int id) {
        return personsService.findOnePersonById(id);
    }

    @GetMapping("/doc/{document}")
    public ResponseBase findOnePersonByDocument(@PathVariable String document) {
        return personsService.findOnePersonByDocument(document);
    }

    @GetMapping
    public ResponseBase findAllPersons() {
        return personsService.findAllPersons();
    }

    @PatchMapping("{id}")
    public ResponseBase updatePerson(@PathVariable int id, @RequestBody RequestPersons requestPersons) {
        return personsService.updatePerson(id, requestPersons);
    }

    @DeleteMapping("{id}")
    public ResponseBase deletePerson(@PathVariable int id){
        return personsService.deletePerson(id);
    }

    @GetMapping("/reniec/{numero}")
    public ResponseBase getInfoReniec(@PathVariable String numero) {
        return personsService.getInfoReniec(numero);
    }
}
