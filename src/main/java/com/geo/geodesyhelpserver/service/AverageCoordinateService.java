package com.geo.geodesyhelpserver.service;

import com.geo.geodesyhelpserver.model.project.AverageCoordinate;
import com.geo.geodesyhelpserver.model.project.Coordinate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class AverageCoordinateService {


    public List<AverageCoordinate> sortCoordinate(List<Coordinate> coordinateList,Double range){
        List<AverageCoordinate> averageCoordinateList = new ArrayList<>();
        for(Coordinate c : coordinateList){
            if(c.getDeleted()){
                continue;
            }
            AverageCoordinate averageCoordinate = getAverageCoordinate(c,coordinateList,range);
            averageCoordinateList.add(averageCoordinate);
            averageCoordinateList.sort(new Comparator<AverageCoordinate>() {
                @Override
                public int compare(AverageCoordinate o1, AverageCoordinate o2) {
                    if(o1.getCoordinateList().size()==o2.getCoordinateList().size())
                        return 0;
                    if(o1.getCoordinateList().size()>o2.getCoordinateList().size())
                        return -1;
                    if(o1.getCoordinateList().size()<o2.getCoordinateList().size())
                        return 1;
                    return 0;
                }
            });
        }
        return averageCoordinateList;
    }

    private AverageCoordinate getAverageCoordinate(Coordinate coordinate, List<Coordinate> coordinateList, Double range){
        AverageCoordinate averageCoordinate = new AverageCoordinate();
        averageCoordinate.setCoordinateList(getCoordinateListByRange(coordinate,coordinateList,range));
        averageCoordinate.setAverage(calculateAverageCoordinate(averageCoordinate.getCoordinateList()));
        return averageCoordinate;
    }

    private Coordinate calculateAverageCoordinate(List<Coordinate> coordinateList){
        Coordinate coordinate = new Coordinate();
        double x = 0D;
        double y = 0D;
        double z = 0D;
        for(Coordinate c:coordinateList){
            x +=c.getX();
            y +=c.getY();
            z +=c.getZ();
        }
        coordinate.setName("average");
        coordinate.setX(Math.round(1000.0*(x/coordinateList.size()))/1000.0);
        coordinate.setY(Math.round(1000.0*(y/coordinateList.size()))/1000.0);
        coordinate.setZ(Math.round(1000.0*(z/coordinateList.size()))/1000.0);
        return coordinate;
    }


    private List<Coordinate> getCoordinateListByRange(Coordinate coordinate,List<Coordinate> allCoordinates, Double range){
        List<Coordinate> coordinateList = new ArrayList<>();
        for(Coordinate c : allCoordinates){
            if(c.getDeleted()){
                continue;
            }
            if(findCoordinateByRange(coordinate,c,range)){
                c.setDeleted(true);
                coordinate.setDeleted(true);
                coordinateList.add(c);
            }
        }
        return coordinateList;
    }

    private boolean findCoordinateByRange(Coordinate c1,Coordinate c2, Double range){
        if (checkCoordinateByRange(c1.getX(), c2.getX(), range)) {
            if (checkCoordinateByRange(c1.getY(), c2.getY(), range)) {
                return checkCoordinateByRange(c1.getZ(), c2.getZ(), range);
            }
        }
        return false;
    }

    private boolean checkCoordinateByRange(Double v1,Double v2,Double range){
        return Math.abs(v1 - v2)<=range;
    }
}
