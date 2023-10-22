package se331.project.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Annouce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String title;
    String description;
    @ElementCollection
    List<String> file;
    @ManyToMany(mappedBy = "annouce") //many annouce have many student
    @Builder.Default
    List<Student> ownStudents = new ArrayList<>();
    @ManyToOne
    Advisor advisor;



}
