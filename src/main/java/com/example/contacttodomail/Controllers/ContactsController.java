package com.example.contacttodomail.Controllers;

import com.example.contacttodomail.DTO.Contact;
import com.example.contacttodomail.Services.ContactServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/Contacts")
public class ContactsController {
    @Autowired
    private ContactServices contact_service;

    @GetMapping("/GetAllContacts")
    @ResponseBody
    public ResponseEntity<List<Contact>> GetAllContacts(){
        return new ResponseEntity<>(contact_service.GetAllContacts(), HttpStatus.OK);
    }

    @PostMapping("/NewContact")
    public Contact PostUser(@RequestBody Contact user) throws Exception {
        return contact_service.AddNewContact(user);
    }

    @PutMapping("/UpdateContact")
    public Contact PutUser(@RequestBody Contact update) {
        return contact_service.UpdateContact(update);
    }

    @DeleteMapping("/DeleteContact/{id}")
    public String DeleteProfile(@PathVariable("id") String id) {
        return contact_service.DeleteContact(id);
    }


}
