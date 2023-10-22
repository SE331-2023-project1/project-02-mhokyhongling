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
import se331.project.rest.entity.Student;
import se331.project.rest.service.AdvisorService;
import se331.project.rest.service.StudentService;
import se331.project.rest.util.LabMapper;

@RequiredArgsConstructor
@Controller
public class AdvisorController {
    final AdvisorService advisorService;
    @GetMapping("advisors")
    public ResponseEntity<?> getAdvisorLists(@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title",required = false) String title) {
        perPage = perPage == null? 3:perPage;
        page = page == null?1:page;
        Page<Advisor> pageOutput;
        if(title ==null){
            pageOutput = advisorService.getAdvisors(perPage,page);
        }else{
            pageOutput = advisorService.getAdvisors(title, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAdvisorDTO(pageOutput.getContent())
                ,responseHeader, HttpStatus.OK);

    }
    @GetMapping("advisors/{id}")
    public ResponseEntity<?> getAdvisor(@PathVariable("id") Long id) {
        Advisor output = advisorService.getAdvisor(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
    @PostMapping("advisors/{id}")
    public ResponseEntity<?> addAdvisor(@RequestBody Advisor advisor,@PathVariable("id") Long id) {
        Advisor advisor1 = advisorService.getAdvisor(id);
        if (!advisor.getName().isEmpty()) {
            advisor1.setName(advisor.getName());
        }
        if (!advisor.getSurname().isEmpty()) {
            advisor1.setSurname(advisor.getSurname());
        }
        if (!advisor.getDepartment().isEmpty()) {
            advisor1.setDepartment(advisor.getDepartment());
        }
        if (!advisor.getAcademic_position().isEmpty()) {
            advisor1.setAcademic_position(advisor.getAcademic_position());
        }
        if (!advisor.getImages().isEmpty()) {
            advisor1.setImages(advisor.getImages());
        }
        Advisor output = advisorService.save(advisor);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(output));

    }
    @PostMapping("/advisors")
    public ResponseEntity<?> addAdvisor(@RequestBody Advisor advisor) {
        Advisor output = advisorService.save(advisor);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(output));

    }
}
