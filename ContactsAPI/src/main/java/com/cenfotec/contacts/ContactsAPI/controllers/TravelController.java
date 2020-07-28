package com.cenfotec.contacts.ContactsAPI.controllers;

import java.util.List;

import com.cenfotec.contacts.ContactsAPI.model.Travel;
import com.cenfotec.contacts.ContactsAPI.repository.ContactRepository;
import com.cenfotec.contacts.ContactsAPI.repository.TravelRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/travels" })
public class TravelController {
    private TravelRepository repository;
    private ContactRepository contactRepository;

    TravelController(TravelRepository travelRepository, ContactRepository contactRepository) {
        this.repository = travelRepository;
        this.contactRepository = contactRepository;
    }

    @GetMapping
    public List findAll() {
        return repository.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Travel> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Travel create(@RequestBody Travel travel) {
        travel.setContact(contactRepository.findById(travel.getContact().getId()));
        return repository.save(travel);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Travel> update(@PathVariable("id") long id, @RequestBody Travel travel) {
        return repository.findById(id).map(record -> {
            record.setId(travel.getId());
            record.setStartDate(travel.getStartDate());
            record.setEndDate(travel.getEndDate());
            record.setDestiny(travel.getDestiny());
            record.setContact(contactRepository.findById(travel.getContact().getId());
                    Travel updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                    }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
