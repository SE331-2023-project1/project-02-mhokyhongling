package se331.project.rest.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Acl;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import jakarta.servlet.ServletException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import se331.project.rest.entity.StorageFileDto;
import se331.project.rest.entity.*;
import se331.project.rest.security.user.User;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);

    StudentDTO getStudentDTO(Student student);

    List<StudentDTO> getStudentDTO(List<Student> students);

    AdvisorDTO getAdvisorDTO(Advisor advisor);

    List<AdvisorDTO> getAdvisorDTO(List<Advisor> advisors);

    @Mapping(target = "roles", source = "user.roles")
    UserDTO getUserDTO(User user);

    CourseDTO getCourseDTO(Course course);

    List<CourseDTO> getCourseDTO(List<Course> courses);

    CommentDTO getCommentDTO(Comment comment);

    List<CommentDTO> getCommentDTO(List<Comment> comments);
}