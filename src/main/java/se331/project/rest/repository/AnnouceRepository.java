package se331.project.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.project.rest.entity.Annouce;
public interface AnnouceRepository extends JpaRepository<Annouce, Long>{
}
