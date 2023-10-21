package se331.project.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import se331.project.rest.security.user.User;

import java.util.ArrayList;
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
    @ManyToOne //นักเรียนหลายคนมีที่ปรึกษาได้1ตน
    Advisor advisor;
    @ManyToMany (mappedBy = "studentHistory") //นักเรียนหลายคนลงเรียนได้หลายคอร์
    @Builder.Default
    List<Course> courses = new ArrayList<>();
    @ElementCollection
    List<String> images;
    @OneToOne
    User user;
}
