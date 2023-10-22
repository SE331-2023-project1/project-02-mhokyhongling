package se331.project.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Annouce;
import se331.project.rest.service.AnnouceService;
import se331.project.rest.util.LabMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AnnouceController {
    final AnnouceService annouceService;

    @GetMapping("annouces/{id}")
    public ResponseEntity<?> getAnnouce(@PathVariable("id") Long id) {
        Annouce output = annouceService.getAnnouce(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouceDTO((List<Annouce>) output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @GetMapping("/annouces")
    ResponseEntity<?> getAnnouce() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouceDTO(annouceService.getAllAnnouce()));

    }
}
