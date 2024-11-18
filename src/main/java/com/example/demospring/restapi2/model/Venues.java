package com.example.demospring.restapi2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venues {
    private Long id;
    private String venuesName;
    private String location;
}
