package com.example.lab.Service;

import com.example.lab.Model.Course;
import com.example.lab.Model.Lecture;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class LectureService {
    ArrayList<Lecture> lectures = new ArrayList<>();

    public ArrayList<Lecture> getLectures() {
        return lectures;
    }

    public void AddLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public boolean updateLecture(int id, Lecture lecture) {
        for (int i = 0; i < lectures.size(); i++) {
            if (lectures.get(i).getId() == id) {
                lectures.set(i, lecture);
                return true;
            }
        }
        return false;
    }

    public boolean deleteLecture(int id) {
        for (int i = 0; i < lectures.size(); i++) {
            if (lectures.get(i).getId() == id) {
                lectures.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Lecture> GetLectures() {
        ArrayList<Lecture> lectures = new ArrayList<>();
        for (Lecture n : lectures) {
            if (n.isVacation()) {
                lectures.add(n);

            }

        }
        return lectures;
    }
    public ArrayList<Lecture> gettopic(String topic) {
        ArrayList<Lecture> list = new ArrayList();
        for (Lecture n : lectures) {
            if (n.getTopic().equals(topic)) {
                list.add(n);
            }

        }
        return list;

        }
        public Lecture searchLecture(int id) {
        for (Lecture n : lectures) {
            if (n.getId() == id) {
                return n;
            }
        }
        return null;


        }





}










