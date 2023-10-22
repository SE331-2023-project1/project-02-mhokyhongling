package se331.project.rest.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.project.rest.dao.AnnouceDao;
import se331.project.rest.entity.Annouce;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AnnouceServiceImpl implements AnnouceService{
    final AnnouceDao annouceDao;
    @Override
    public List<Annouce> getAllAnnouce() {
        return null;
    }

    @Override
    public Integer getAnnouceSize() {
        return annouceDao.getAnnouceSize();
    }
    @Override
    public Page<Annouce> getAnnouces(Integer pageSize, Integer page) {
        return annouceDao.getAnnouces(pageSize, page);
    }
    @Override
    public Annouce getAnnouce(Long id) {
        return annouceDao.getAnnouce(id);
    }
    @Override
    @Transactional
    public Annouce save(Annouce annouce) {
        return annouceDao.save(annouce);
    }

    @Override
    public Page<Annouce> getAnnouces(String name, Pageable pageable) {
        return annouceDao.getAnnouces(name,pageable);
    }
}
