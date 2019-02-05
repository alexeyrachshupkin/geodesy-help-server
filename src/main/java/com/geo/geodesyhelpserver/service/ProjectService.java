package com.geo.geodesyhelpserver.service;

import com.geo.geodesyhelpserver.model.project.Coordinate;
import com.geo.geodesyhelpserver.model.project.Project;
import com.geo.geodesyhelpserver.model.project.ProjectFile;
import com.geo.geodesyhelpserver.repository.ProjectRepository;
import com.geo.geodesyhelpserver.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.BASE64Decoder;

import java.util.*;

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
        Optional<Project> projectOptional = projectRepository.findById(id);
        return projectOptional.isPresent()?projectOptional.get():null;
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
