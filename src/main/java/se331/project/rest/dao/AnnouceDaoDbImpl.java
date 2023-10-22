package se331.project.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.project.rest.entity.Annouce;
import se331.project.rest.repository.AnnouceRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AnnouceDaoDbImpl implements AnnouceDao{
    final AnnouceRepository annouceRepository;
    @Override
    public Integer getAnnouceSize(){
        return Math.toIntExact(annouceRepository.count());
    }
    @Override
    public Page<Annouce> getAnnouces(Integer pageSize, Integer page){
        return  annouceRepository.findAll(PageRequest.of(page - 1, pageSize));
    }
    @Override
    public Annouce getAnnouce(Long id){
        return annouceRepository.findById(id).orElse(null);
    }
    @Override
    public Annouce save(Annouce annouce){
        return annouceRepository.save(annouce);
    }
    @Override
    public Page<Annouce> getAnnouces(String title, Pageable page){
        return null;
    }
    @Override
    public  Optional<Annouce> findById(Long id){
        return Optional.empty();
    }
}
