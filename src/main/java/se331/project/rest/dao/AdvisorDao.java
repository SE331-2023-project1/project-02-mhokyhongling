package se331.project.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Student;

import java.util.Optional;

public interface AdvisorDao {
    Integer getAdvisorSize();
    Page<Advisor> getAdvisors(Integer pageSize, Integer page);
    Advisor getAdvisor(Long id);
    Advisor save(Advisor advisor);
    Page<Advisor> getAdvisors(String name, Pageable page);
    Optional<Advisor> findById(Long id);
}
