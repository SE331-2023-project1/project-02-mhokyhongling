package se331.project.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.AdvisorDao;
import se331.project.rest.dao.StudentDao;
import se331.project.rest.entity.Advisor;
import se331.project.rest.entity.Student;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService{

    final StudentDao studentDao;

    final AdvisorDao advisorDao;

    @Override
    public List<Advisor> getAllAdvisor() {
        return null;
    }

    @Override
    public Integer getAdvisorSize() {
        return advisorDao.getAdvisorSize();
    }
    @Override
    public Page<Advisor> getAdvisors(Integer pageSize, Integer page) {
        return advisorDao.getAdvisors(pageSize, page);
    }
    @Override
    public Advisor getAdvisor(Long id) {
        return advisorDao.getAdvisor(id);
    }
    @Override
    @Transactional
    public Advisor save(Advisor advisor) {
        return advisorDao.save(advisor);
    }

    @Override
    public Page<Advisor> getAdvisors(String name, Pageable pageable) {
        return advisorDao.getAdvisors(name,pageable);
    }
}
