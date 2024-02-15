package com.example.contacttodomail.Services;

import com.example.contacttodomail.DTO.Contact;
import com.example.contacttodomail.Interfaces.IContacts;
import com.example.contacttodomail.Repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactServices implements IContacts {

    @Autowired
    private ContactRepository contact_repo;

    @Override
    public List<Contact> GetAllContacts() {
        return contact_repo.findAll();
    }
    @Override
    public Contact AddNewContact(Contact information) throws Exception {
        try{
            if (information.equals(null) || information.get_id().equals("")) {
                information.set_id(UUID.randomUUID().toString());
                contact_repo.save(information);
                return information;
            }else{
                throw new Exception("INVALID DATA");
            }
        }catch (Exception error){
            throw new Exception("SOMETHING HAPPEN IN THE SERVER OR CONNECTION TO DB FAILS");
        }
    }
    @Override
    public Contact UpdateContact(Contact update) {
        try {
            if (contact_repo.existsById(update.get_id())) {
                contact_repo.save(update);
                return update;
            } else if (!contact_repo.existsById(update.get_id())) {
                return null;
            } else {
                return null;
            }
        } catch (Exception error) {
            throw error;
        }
    }
    @Override
    public String DeleteContact(String id) {
        try {
            if (contact_repo.existsById(id)) {
                contact_repo.deleteById(id);
                return "Contact delete";
            } else if (!contact_repo.existsById(id)) {
                return "contact does not exist";
            } else {
                return "cannot delete contact or unexisting";
            }
        } catch (Exception error) {
            return error.getMessage();
        }
    }
}
