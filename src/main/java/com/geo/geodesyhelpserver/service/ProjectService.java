package com.geo.geodesyhelpserver.service;

import com.geo.geodesyhelpserver.model.project.Project;
import com.geo.geodesyhelpserver.repository.ProjectRepository;
import com.geo.geodesyhelpserver.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectService implements BaseService<Project,Long> {


    private ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project saveOrUpdate(Project entity) {
        return projectRepository.save(entity);
    }

    @Override
    public Project findById(Long id) {
        if(projectRepository.findById(id).isPresent()){
            return projectRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);

    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }
}
