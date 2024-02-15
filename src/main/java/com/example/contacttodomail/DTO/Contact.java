package com.example.contacttodomail.DTO;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="Contacts")
public class Contact {
    private String _id;
    private String ContactName;
    private String ContactLastName;
    private String ContactEmail;
    private int ContactPhone;

}
