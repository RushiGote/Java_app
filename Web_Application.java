package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
@RestController
@RequestMapping("/courses")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    static class Course {
        private int id;
        private String name;
        private String instructor;

        public Course() {}
        public Course(int id, String name, String instructor) {
            this.id = id;
            this.name = name;
            this.instructor = instructor;
        }

        public int getId() { return id; }
        public void setId(int id) { this.id = id; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getInstructor() { return instructor; }
        public void setInstructor(String instructor) { this.instructor = instructor; }
    }

    private List<Course> courseList = new ArrayList<>();

    public DemoApplication() {
        courseList.add(new Course(1, "Java", "Alice"));
        courseList.add(new Course(2, "Python", "Bob"));
    }

    @GetMapping
    public List<Course> getCourses() {
        return courseList;
    }

    @PostMapping
    public String addCourse(@RequestBody Course course) {
        courseList.add(course);
        return "Course added";
    }

    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable int id) {
        courseList.removeIf(c -> c.getId() == id);
        return "Course deleted";
    }
}
