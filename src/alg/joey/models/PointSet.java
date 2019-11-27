package alg.joey.models;

import java.util.ArrayList;
import java.util.List;

public class PointSet {
    private final Point hub;
    private ArrayList<Point> points = new ArrayList<>();

    public Point getHub(){
        return hub;
    }

    public List<Point> getPoints() {
        return points;
    }

    public boolean allPointsVisited(){
        boolean assumption = true;
        for(Point point : points){
            if(!point.getHasBeenVisited()){
                assumption = false;
            }
        }
        return assumption;
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public void initialise(){
        hub.getConnections().clear();
        for(Point item : points){
            item.getConnections().clear();
            item.addConnectionWith(hub);
        }
    }

    public PointSet(){
        hub = new Point("Hub", 0, 0);
        hub.setHub(true);
    }
}
