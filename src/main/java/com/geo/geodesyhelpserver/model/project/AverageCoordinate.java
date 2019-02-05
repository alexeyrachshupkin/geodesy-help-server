package com.geo.geodesyhelpserver.model.project;

import com.geo.geodesyhelpserver.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class AverageCoordinate extends BaseEntity {

    @OneToMany
    private List<Coordinate> coordinateList;

    @ManyToOne
    private Coordinate average;

    public List<Coordinate> getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    public Coordinate getAverage() {
        return average;
    }

    public void setAverage(Coordinate average) {
        this.average = average;
    }
}
