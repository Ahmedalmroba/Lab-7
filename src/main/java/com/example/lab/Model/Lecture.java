package com.example.lab.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class Lecture {
    @Size(min = 5, max = 20)
    @NotNull(message = "should not be null")
    private int id;
    @Size(min = 6, max = 15)
    @NotEmpty(message = "should not be empty")
    private String topic;
    @Size(min = 30, max = 100)
    @NotEmpty(message = "should not be empty")
    private String duration;
    private LocalDate startTime;
    private boolean isVacation;
}
