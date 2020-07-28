package com.cenfotec.contacts.ContactsAPI.repository;

import com.cenfotec.contacts.ContactsAPI.model.Travel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, Long> {
}
