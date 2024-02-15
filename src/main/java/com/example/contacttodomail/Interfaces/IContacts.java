package com.example.contacttodomail.Interfaces;

import com.example.contacttodomail.DTO.Contact;

import java.util.List;

public interface IContacts {
    List<Contact> GetAllContacts();
    Contact AddNewContact(Contact information) throws Exception;
    Contact UpdateContact(Contact update);
    String DeleteContact(String id);



}
