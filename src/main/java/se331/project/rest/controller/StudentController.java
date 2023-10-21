package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.rest.entity.Student;
import se331.project.rest.service.StudentService;
import se331.project.rest.util.LabMapper;

@RequiredArgsConstructor
@Controller
public class StudentController {
    final StudentService studentService;
    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title",required = false) String title) {
        perPage = perPage == null? 3:perPage;
        page = page == null?1:page;
        Page<Student> pageOutput;
        if(title ==null){
            pageOutput = studentService.getStudents(perPage,page);
        }else{
            pageOutput = studentService.getStudents(title, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getStudentDTO(pageOutput.getContent())
                ,responseHeader, HttpStatus.OK);

    }
    @GetMapping("students/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Student output = studentService.getStudent(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }


    @PostMapping("students/{id}")
    public ResponseEntity<?> addStudent(@RequestBody Student student,@PathVariable("id") Long id) {
        Student student1 = studentService.getStudent(id);

        if (!student.getName().isEmpty()) {
            student1.setName(student.getName());
        }
        if (!student.getStudentid().isEmpty()) {
            student1.setStudentid(student.getStudentid());
        }
        if (!student.getSurname().isEmpty()) {
            student1.setSurname(student.getSurname());
        }
        if (!student.getDepartment().isEmpty()) {
            student1.setDepartment(student.getDepartment());
        }
        if (!student.getLocation().isEmpty()) {
            student1.setLocation(student.getLocation());
        }
        if (!student.getImages().isEmpty()) {
            student1.setImages(student.getImages());
        }

        Student output = studentService.save(student1);

        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));


    }
    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student output = studentService.save(student);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));

    }
}


