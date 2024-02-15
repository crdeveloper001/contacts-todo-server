package com.example.contacttodomail.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@Data
@Document(collection = "Tasks")
public class Tasks {
    private String _id;
    private String TaskName;
    private String TaskDate;
    private String TaskDescription;

}
