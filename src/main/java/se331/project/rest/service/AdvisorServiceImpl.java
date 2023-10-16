package se331.project.rest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.AdvisorDao;
import se331.project.rest.entity.Advisor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService{

    final AdvisorDao advisorDao;
    @Override
    public List<Advisor> getAllAdvisor() {
        return advisorDao.getAdvisor(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Advisor> getAdvisor(Integer page, Integer pageSize) {
        return advisorDao.getAdvisor(PageRequest.of(page,pageSize));
    }
}
