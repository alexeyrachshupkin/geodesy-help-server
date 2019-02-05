package com.geo.geodesyhelpserver.repository;

import com.geo.geodesyhelpserver.model.project.Coordinate;
import com.geo.geodesyhelpserver.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CoordinateRepository extends JpaRepository<Coordinate,Long> {

    @Query("select c from Coordinate c where c.project.id = :projectId")
    List<Coordinate> findByProject( Long projectId);
}
