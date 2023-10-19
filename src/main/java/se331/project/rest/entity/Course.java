package se331.project.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String courseid;
    String name;
    String description;
    List<String> images;
    @ManyToMany
    @Builder.Default
    List<Student> studentHistory = new ArrayList<>();



}
