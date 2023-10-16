package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.project.rest.service.CourseService;
import se331.project.rest.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class CourseController {
    final CourseService courseService;
    @GetMapping("/courses")
    ResponseEntity<?> getCourse() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getCourseDTO(courseService.getAllCourse()));

    }
}
