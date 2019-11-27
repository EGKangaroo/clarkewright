package alg.joey.logic;

import alg.joey.models.Point;
import alg.joey.models.PointSet;
import alg.joey.models.Shortcut;

import java.util.ArrayList;
import java.util.List;

class ShortcutCalculator {
    private static double calculateDistance(Point a, Point b){
        float xDistance = Math.abs(a.getPosX() - b.getPosX());
        float yDistance = Math.abs(a.getPosY() - b.getPosY());
        return Math.sqrt(xDistance + yDistance);
    }

    private static Shortcut calculateSaving(Point hub, Point i, Point j){
        double hubToI = calculateDistance(hub, i);
        double hubToJ = calculateDistance(hub, j);
        double iToJ = calculateDistance(i, j);
        return new Shortcut(i, j, hubToI + hubToJ - iToJ);
    }

    static List<Shortcut> calculateListOfSavings(PointSet pointSet){
        ArrayList<Shortcut> shortcuts = new ArrayList<>();
        Point hub = pointSet.getHub();
        for(int i = 0; i < pointSet.getPoints().size(); i++){
            for(int j = 0; j < pointSet.getPoints().size(); j++){
                //we only need to calculate the shortcuts for two points in ONE direction
                //also we should not calculate the saving for a point with itself
                if(j < i){
                    Shortcut shortcut = calculateSaving(hub, pointSet.getPoints().get(i), pointSet.getPoints().get(j));
                    shortcuts.add(shortcut);
                }
                else{
                    //set j to this list size to jump out of the loop
                    j = pointSet.getPoints().size();
                }
            }
        }
        return shortcuts;
    }
}
