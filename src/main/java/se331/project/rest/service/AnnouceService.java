package se331.project.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.controller.AnnouceController;
import se331.project.rest.entity.Annouce;

import java.util.List;

public interface AnnouceService {
    List<Annouce> getAllAnnouce();
    Integer getAnnouceSize();
    Page<Annouce> getAnnouces(Integer pageSize, Integer page);
    Annouce getAnnouce(Long id);
    Annouce save(Annouce annouce);
    Page<Annouce> getAnnouces(String title, Pageable pageable);
}
