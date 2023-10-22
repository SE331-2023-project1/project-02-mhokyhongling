package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Annouce;

import java.util.Optional;

public interface AnnouceDao {
    Integer getAnnouceSize();
    Page<Annouce> getAnnouces(Integer pageSize, Integer page);
    Annouce getAnnouce(Long id);
    Annouce save(Annouce annouce);
    Page<Annouce> getAnnouces(String title, Pageable page);
    Optional<Annouce> findById(Long id);

}
