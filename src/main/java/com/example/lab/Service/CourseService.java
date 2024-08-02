package com.example.lab.Service;

import com.example.lab.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses = new ArrayList<Course>();
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course) {
        courses.add(course);
    }
    public boolean updateCourse(int id, Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
    public Course searchCourse(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }

        }
        return null;
        }
        public ArrayList<Course> getName(String name) {
        ArrayList<Course> list = new ArrayList();
        for (Course l : courses) {
            if (l.getName().equals(name)) {
                list.add(l);
            }
        }
        return list;

        }
        public ArrayList<Course> getCoursesBycredithours(String credithours) {
            ArrayList<Course> listc = new ArrayList();
            for (Course n : courses) {
                if (n.getCredi_hours().equals(credithours)) {
                    listc.add(n);
                }

            }
            return listc;
}}
