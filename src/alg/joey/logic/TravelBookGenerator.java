package alg.joey.logic;

import alg.joey.models.Point;
import alg.joey.models.PointSet;

public class TravelBookGenerator {
    public static void renderPathInConsole(PointSet pointSet){
        //just a check again to make sure that all points have two connections
        for (Point point : pointSet.getPoints()) {
            if(point.getConnections().size() != 2){
                throw new IllegalArgumentException("All your points must have 2 connections");
            }
        }

        //make the travel book
        StringBuilder travelBook = new StringBuilder();
        travelBook.append("This is your travel book: \r\n");

        //start with hub
        Point hub = pointSet.getHub();
        hub.setHasBeenVisited(true);

        //set hub as next point
        Point nextPoint = hub;

        //repeatedly travel to next available unvisited point until you are back at hub
        while(!pointSet.allPointsVisited()) {
            travelBook.append(nextPoint.getName()).append(" -> ");
            if(nextPoint.getConnections().get(0).getHasBeenVisited()){
                nextPoint = nextPoint.getConnections().get(1);
            }
            else{
                nextPoint = nextPoint.getConnections().get(0);
            }
            nextPoint.setHasBeenVisited(true);
        }
        travelBook.append(hub.getName());
        System.out.println(travelBook);
    }
}
