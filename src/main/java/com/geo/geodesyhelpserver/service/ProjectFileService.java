package com.geo.geodesyhelpserver.service;

import com.geo.geodesyhelpserver.model.project.Coordinate;
import com.geo.geodesyhelpserver.model.project.Project;
import com.geo.geodesyhelpserver.model.project.ProjectFile;
import com.geo.geodesyhelpserver.repository.ProjectFileRepository;
import com.geo.geodesyhelpserver.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ProjectFileService implements BaseService<ProjectFile,Long> {
    private ProjectFileRepository projectFileRepository;

    @Autowired
    public ProjectFileService(ProjectFileRepository projectFileRepository) {
        this.projectFileRepository = projectFileRepository;
    }

    @Override
    public ProjectFile saveOrUpdate(ProjectFile entity) {
        return projectFileRepository.save(entity);
    }

    @Override
    public ProjectFile findById(Long id) {
        Optional<ProjectFile> projectFileOptional = projectFileRepository.findById(id);
        return projectFileOptional.isPresent()?projectFileOptional.get():null;
    }

    @Override
    public void delete(Long id) {
        projectFileRepository.deleteById(id);
    }

    @Override
    public List<ProjectFile> findAll() {
        return projectFileRepository.findAll();
    }

    public List<Coordinate> parseProjectFile(Project project){
        List<Coordinate> coordinateList = new ArrayList<>();
        byte file[] = Base64.getDecoder().decode(project.getProjectFile().getBase64().split(",")[1]);
        String base64Str = new String(file);
        List<String> coordinateStrArray = Arrays.asList(base64Str.split("\n"));
        for(String c: coordinateStrArray){
            String[] var = c.split(",");
            coordinateList.add(new Coordinate((String)var[0],Double.parseDouble(var[1]),Double.parseDouble(var[2]),Double.parseDouble(var[3]),project));
        }
        System.out.println(coordinateList);
        return coordinateList;
    }
}
