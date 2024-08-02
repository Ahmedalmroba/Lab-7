package com.example.lab.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    @Size(min = 5, max = 20)
    @NotNull(message = "should not be null")
    private int id;
    @Size(min = 6, max = 15)
    @NotEmpty(message = "should not be empty")
    private String name;
    @NotEmpty(message = "should not be empty")
    @PastOrPresent
    private String year;
    @NotEmpty(message = "should not be empty")
    @Size(min = 5, max = 15)
    private String time;
    @NotEmpty(message = "should not be empty")
    @Size(min = 1, max = 8)
    private String credi_hours;
}
