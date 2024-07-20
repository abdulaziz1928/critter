package com.udacity.jdnd.course3.critter.web.view;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
@Getter
@Setter
public class CustomerDTO {
    private Long id;
    private String name;
    private String phoneNumber;
    private String notes;
    private List<Long> petIds = new ArrayList<>();
}
