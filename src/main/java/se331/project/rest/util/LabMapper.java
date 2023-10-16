package se331.project.rest.util;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import se331.project.rest.entity.*;

import java.util.List;

public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudentDTO(List<Student> students);
    AdvisorDTO getAdvisorDTO(Advisor advisor);
    List<AdvisorDTO> getAdvisorDTO(List<Advisor> advisors);
    CourseDTO getCourseDTO(Course course);
    List<CourseDTO> getCourseDTO(List<Course> courses);

}
