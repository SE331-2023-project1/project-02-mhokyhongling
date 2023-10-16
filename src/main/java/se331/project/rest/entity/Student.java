package se331.project.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String studentid;
    String name;
    String surname;
    String department;
    String location;
    @ElementCollection
    List<String> images;
    @ManyToOne() //นักเรียนหลายคนมีที่ปรึกษาได้1ตน
    Advisor advisor;
    @ManyToMany //นักเรียนหลายคนลงเรียนได้หลายคอร์ส
    List<Course> courses;
}
