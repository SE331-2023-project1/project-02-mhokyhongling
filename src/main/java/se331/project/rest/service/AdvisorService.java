package se331.project.rest.service;

import org.springframework.data.domain.Page;
import se331.project.rest.entity.Advisor;

import java.util.List;

public interface AdvisorService {
    List<Advisor> getAllAdvisor();
    Page<Advisor> getAdvisor(Integer page, Integer pageSize);

}
