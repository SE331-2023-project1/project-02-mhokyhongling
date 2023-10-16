package se331.project.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    String studentid;
    String name;
    String surname;
    String department;
    String location;
    List<String> images;
    StudentAdvisorDTO advisor;
    List<StudentCourseDTO> courses;

}
