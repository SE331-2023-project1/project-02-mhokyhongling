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
public class StudentAdvisorDTO {
    Long id;
    String name;
    String surname;
    String academic_position;
    String department;
    List<String> images;
}
