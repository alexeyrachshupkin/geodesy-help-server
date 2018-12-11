package com.geo.geodesyhelpserver.repository;

import com.geo.geodesyhelpserver.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
}
