package com.example.lab.Controller;

import com.example.lab.Model.Course;
import com.example.lab.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;

    @GetMapping("get")
    public ResponseEntity getCourse() {
        ArrayList<Course> courses = courseService.getCourses();
        return ResponseEntity.status(200).body("get courses" + courses);
    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("course is not found ");
        }
        courseService.addCourse(course);
        return ResponseEntity.status(200).body("course added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id, @Valid @RequestBody Course course, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("course is not found ");

        }
        boolean isUpdated = courseService.updateCourse(id, course);
        if (isUpdated) {
            return ResponseEntity.status(200).body("course updated");
        }
        return ResponseEntity.status(400).body("course not updated");


}
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id) {
        boolean isDeleted = courseService.deleteCourse(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("course deleted");

        }
        return ResponseEntity.status(400).body("course not deleted");
    }
    @GetMapping("/curse/{id}")
    public ResponseEntity searchCurse(@PathVariable int id) {
        Course course = courseService.searchCourse(id);
        if (course != null) {
            return ResponseEntity.status(200).body(course);
        }
        return ResponseEntity.status(400).body("course not found");
    }
    @GetMapping("/get-name-list")
    public ResponseEntity getCourseNameList() {
        return ResponseEntity.status(200).body(
                courseService.getName("get-name-list"));
    }
    @GetMapping("/credit-list")
    public ResponseEntity getCourseCreditList() {
        return ResponseEntity.status(200).body(
                courseService.getCoursesBycredithours("get-name-list"));

    }

}
