package se331.project.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.mockito.Answers;
import se331.project.rest.security.user.User;

import java.util.List;

@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String description;
    @ManyToOne
    Student student;
    @ManyToOne
    Advisor advisor;

//    @ManyToOne
//    CommentAnswer commentAnswer;
//    @OneToOne
//    User user;
}
