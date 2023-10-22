package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Student;
import se331.project.rest.repository.AdvisorRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AdvisorDaoDbImpl implements AdvisorDao{

    final AdvisorRepository advisorRepository;
    @Override
    public Integer getAdvisorSize() {
        return Math.toIntExact(advisorRepository.count());
    }

    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page) {

        return advisorRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Advisor getAdvisor(Long id) {

        return advisorRepository.findById(id).orElse(null);
    }

    @Override
    public Advisor save(Advisor advisor) {
        return advisorRepository.save(advisor);
    }

    @Override
    public Page<Advisor> getAdvisors(String name, Pageable page) {
        return null;
    }

    @Override
    public Optional<Advisor> findById(Long id) {
        return Optional.empty();
    }


}