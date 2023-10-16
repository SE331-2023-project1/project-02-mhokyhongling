package se331.project.rest.entity;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Advisor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String name;
    String surname;
    String academic_position;
    String department;
    @ElementCollection
    List<String> images;
    @OneToMany(mappedBy = "advisor")  //1adviser have many student
    @Builder.Default
    List<Student> ownStudents = new ArrayList<>();
}
