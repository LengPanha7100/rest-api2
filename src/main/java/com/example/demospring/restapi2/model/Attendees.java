package com.example.demospring.restapi2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendees {
    private Long attendeesId;
    private String attendeesName;
    private String email;
}
