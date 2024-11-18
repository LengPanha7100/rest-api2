package com.example.demospring.restapi2.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendeesRequest {
    private String attendeesName;
    private String email;
}
