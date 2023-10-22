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
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Comment;
import se331.project.rest.entity.Student;
import se331.project.rest.request.CommentRequest;
import se331.project.rest.service.AdvisorService;
import se331.project.rest.service.CommentService;
import se331.project.rest.service.StudentService;
import se331.project.rest.util.LabMapper;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CommentController {
    final CommentService commentService;
    final StudentService studentService;
    final AdvisorService advisorService;
    @GetMapping("comments")
    public ResponseEntity<?> getCommentLists(@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title",required = false) String title) {
        perPage = perPage == null? 3:perPage;
        page = page == null?1:page;
        Page<Comment> pageOutput;
        if(title ==null){
            pageOutput = commentService.getComments(perPage,page);
        }else{
            pageOutput = commentService.getComments(title, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getCommentDTO(pageOutput.getContent())
                ,responseHeader, HttpStatus.OK);

    }
    @GetMapping("comments/{id}")
    public ResponseEntity<?> getComment(@PathVariable("id") Long id) {
        List<Comment> comment = commentService.getCommentByStudentId(id);
        if (comment != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(comment));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
    @PostMapping("/comments")
    public ResponseEntity<?> addComment(@RequestBody Comment comment) {
        Comment output = commentService.save(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));

    }
    @PostMapping("/comments/{id}")
    public ResponseEntity<?> addComment(@RequestBody CommentRequest request, @PathVariable("id") Long id) {
        Student student = studentService.getStudent(id);
        Advisor advisor = advisorService.getAdvisor(request.getAdvisorId());
        Comment comment = Comment.builder()
                .description(request.getDescription())
                .build();
        comment.setAdvisor(advisor);
        advisor.setOwnComments(List.of(comment));
        student.setOwnComments(List.of(comment));
        comment.setStudent(student);
        Comment output = commentService.save(comment);
        return ResponseEntity.ok(LabMapper.INSTANCE.getCommentDTO(output));

    }
}