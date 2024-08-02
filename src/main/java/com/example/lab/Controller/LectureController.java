package com.example.lab.Controller;

import com.example.lab.Model.Course;
import com.example.lab.Model.Lecture;
import com.example.lab.Service.LectureService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/lecture")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @GetMapping("/get")
    public ResponseEntity getLecture() {
        ArrayList<Lecture> lectures = lectureService.getLectures();
        return ResponseEntity.status(200).body("get lectures" + lectures);

    }

    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Lecture lecture, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("lecture is not found ");
        }
        lectureService.AddLecture(lecture);
        return ResponseEntity.status(200).body("success");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id, @Valid @RequestBody Lecture lecture, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body("lecture not updated ");
        }
        boolean isUpdated = lectureService.updateLecture(id, lecture);
        if (isUpdated) {
            return ResponseEntity.status(200).body("lecture updated");
        }
        return ResponseEntity.status(400).body("lecture not updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLecture(@PathVariable int id) {
        boolean isDeleted = lectureService.deleteLecture(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body("lecture deleted");
        }
        return ResponseEntity.status(400).body("lecture not deleted");
    }
    @GetMapping("get-list")
    public ResponseEntity getLectureList() {
        return ResponseEntity.status(200).
                body(lectureService.GetLectures());
    }

    @GetMapping("get-topic-list")
    public ResponseEntity getLectureTopicList() {
        return ResponseEntity.status(200).
                body(lectureService.gettopic("get topic list"));


    }

    @GetMapping("/lecture/{id}")
    public ResponseEntity getLectureById(@PathVariable int id) {
        Lecture lecture = lectureService.searchLecture( id);
        if (lecture == null) {
            return ResponseEntity.status(400).body("lecture not found");
        }
        return ResponseEntity.status(200).body(lecture);
    }


    }



