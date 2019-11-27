package alg.joey.logic;

import alg.joey.models.Point;
import alg.joey.models.PointSet;

import java.util.Random;
import java.util.Scanner;

public class PointSetGenerator {
    private static Random r = new Random();

    public static PointSet generatePointSet(){
        PointSet pointSet = new PointSet();
        int numberOfPoints = 0;
        System.out.println("USER INPUT REQUIRED");
        System.out.println("Through how many points should your route go?");
        while(numberOfPoints == 0){
            Scanner in = new Scanner(System.in);
            numberOfPoints = in.nextInt();
            if(numberOfPoints <= 0){
                System.out.println("Please put in a number greater than 0");
            }
            else{
                System.out.println("You have put in " + numberOfPoints + " points");
            }
        }
        for(int i = 1; i < numberOfPoints; i++){
            float posX = r.nextFloat() * 100;
            float posY = r.nextFloat() * 100;
            String name = "Point " + i;
            Point point = new Point(name, posX, posY);
            pointSet.addPoint(point);
        }
        return pointSet;
    }
}
