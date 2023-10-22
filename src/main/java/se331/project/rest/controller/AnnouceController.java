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
import se331.project.rest.entity.Annouce;
import se331.project.rest.service.AdvisorService;
import se331.project.rest.service.AnnouceService;
import se331.project.rest.util.LabMapper;

@RequiredArgsConstructor
@Controller
public class AnnouceController {
    final AnnouceService annouceService;
    @GetMapping("annouces")
    public ResponseEntity<?> getAnnouceLists(@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page
            , @RequestParam(value = "title",required = false) String title) {
        perPage = perPage == null? 3:perPage;
        page = page == null?1:page;
        Page<Annouce> pageOutput;
        if(title ==null){
            pageOutput = annouceService.getAnnouces(perPage,page);
        }else{
            pageOutput = annouceService.getAnnouces(title, PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAnnouceDTO(pageOutput.getContent())
                ,responseHeader, HttpStatus.OK);

    }
    @GetMapping("annouces/{id}")
    public ResponseEntity<?> getAnnouce(@PathVariable("id") Long id) {
        Annouce output = annouceService.getAnnouce(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouceDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }
    @PostMapping("annouces/{id}")
    public ResponseEntity<?> addAnnouce(@RequestBody Annouce annouce, @PathVariable("id") Long id) {
        Annouce annouce1 = annouceService.getAnnouce(id);
        if (!annouce.getTitle().isEmpty()) {
            annouce1.setTitle(annouce.getTitle());
        }
        if (!annouce.getDescription().isEmpty()) {
            annouce1.setDescription(annouce.getDescription());
        }
        if (!annouce.getFile().isEmpty()) {
            annouce1.setFile(annouce.getFile());
        }
        Annouce output = annouceService.save(annouce1);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouceDTO(output));

    }
    @PostMapping("/annouces")
    public ResponseEntity<?> addAnnouce(@RequestBody Annouce annouce) {
        Annouce output = annouceService.save(annouce);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouceDTO(output));

    }
}
