package se331.project.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdvisorStudentDTO {
    Long id;
    String studentid;
    String name;
    String surname;
    String department;
    String location;
    List<String> images;
    List<AdvisorStudentDTO> ownStudents;
}
