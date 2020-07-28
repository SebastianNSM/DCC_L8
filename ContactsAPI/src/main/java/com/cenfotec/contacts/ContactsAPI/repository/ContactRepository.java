package com.cenfotec.contacts.ContactsAPI.repository;

import com.cenfotec.contacts.ContactsAPI.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
