package alg.joey.logic;

import alg.joey.models.Point;
import alg.joey.models.Shortcut;

class CycleChecker {
    //you can only create a path if it will not create a cycle or cut into an existing path
    static boolean isValidToCreatePath(Shortcut shortcut){
        Point a = shortcut.getA();
        Point b = shortcut.getB();
        return !a.hasConnectionWith(b) && a.getConnectionCount() < 2 && b.getConnectionCount() < 2;
    }
}
