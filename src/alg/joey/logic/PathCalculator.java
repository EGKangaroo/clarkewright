package alg.joey.logic;

import alg.joey.models.PointSet;
import alg.joey.models.Shortcut;

import java.util.Comparator;
import java.util.List;

public class PathCalculator {
    public static void calculatePath(PointSet points){
        points.initialise();
        //compute time shortcuts for taking shortcuts instead of going via hub
        List<Shortcut> shortcuts = ShortcutCalculator.calculateListOfSavings(points);
        //sort list
        shortcuts.sort(Comparator.comparing(Shortcut::getTotalSaving).reversed());

        int tryIndex = 0;
        //keep going until there are only 2 hub connections left
        while(points.getHub().getConnections().size() > 2){
            //get the biggest shortcut
            Shortcut shortcut = shortcuts.get(tryIndex);
            if(CycleChecker.isValidToCreatePath(shortcut)){
                shortcut.getA().addConnectionWith(shortcut.getB());
                if(shortcut.getA().getConnectionCount() == 2){
                    shortcut.getA().removeConnectionWith(points.getHub());
                }
                if(shortcut.getB().getConnectionCount() == 2){
                    shortcut.getB().removeConnectionWith(points.getHub());
                }
            }
            tryIndex++;
        }
        System.out.println("Tried until tryIndex " + tryIndex);
    }
}
