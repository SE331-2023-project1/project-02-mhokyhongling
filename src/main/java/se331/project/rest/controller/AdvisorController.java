package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se331.project.rest.service.AdvisorService;
import se331.project.rest.util.LabMapper;

@RequiredArgsConstructor
@Controller
public class AdvisorController {
    final AdvisorService advisorService;
    @GetMapping("/advisors")
    ResponseEntity<?> getAdvisors() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getAdvisorDTO(advisorService.getAllAdvisor()));

    }

}
