package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.Advisor;
import se331.project.rest.repository.AdvisorRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AdvisorDaoImpl implements AdvisorDao{

    final AdvisorRepository advisorRepository;

    @Override
    public Page<Advisor> getAdvisor(Pageable pageRequest) {
        return advisorRepository.findAll(pageRequest);
    }

    @Override
    public Optional<Advisor> findById(Long id) {

        return advisorRepository.findById(id);
    }


}
