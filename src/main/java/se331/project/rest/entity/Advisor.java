package se331.project.rest.entity;
import java.util.ArrayList;
import java.util.List;
//import se331.project.rest.security.user.User;

import jakarta.persistence.*;
import lombok.*;
import se331.project.rest.security.user.User;

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
    @OneToOne
    User user;
    @OneToMany(mappedBy = "advisor")
    @Builder.Default
    List<Comment> ownComments = new ArrayList<>();
}
