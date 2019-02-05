package com.geo.geodesyhelpserver.service;

import com.geo.geodesyhelpserver.model.project.Coordinate;
import com.geo.geodesyhelpserver.model.project.Project;
import com.geo.geodesyhelpserver.repository.CoordinateRepository;
import com.geo.geodesyhelpserver.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CoordinateService implements BaseService<Coordinate,Long> {

    private CoordinateRepository coordinateRepository;

    @Autowired
    public CoordinateService(CoordinateRepository coordinateRepository) {
        this.coordinateRepository = coordinateRepository;
    }

    @Override
    public Coordinate saveOrUpdate(Coordinate entity) {
        return null;
    }

    @Override
    public Coordinate findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Coordinate> findAll() {
        return null;
    }

    public List<Coordinate> saveAll(List<Coordinate> coordinateList){
        return coordinateRepository.saveAll(coordinateList);
    }
    public List<Coordinate> findByProjectId(Long projectId){
        return coordinateRepository.findByProject(projectId);
    }


}
