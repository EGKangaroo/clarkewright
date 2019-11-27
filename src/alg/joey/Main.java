package alg.joey;

import alg.joey.logic.PathCalculator;
import alg.joey.logic.PointSetGenerator;
import alg.joey.logic.TravelBookGenerator;
import alg.joey.models.PointSet;

import java.util.Scanner;

public class Main {

    private static boolean cont = true;
    private static Scanner in = new Scanner (System.in);

    public static void main(String[] args) {
        System.out.println("Starting up, owo");
        System.out.println("===================================");
        System.out.println("WELCOME TO THE CLARKE HEURISTICS APP");
        System.out.println("===================================");
        while(cont){
            PointSet points = PointSetGenerator.generatePointSet();

            System.out.println("===================================");
            System.out.println("BEGINNING CLARKE WRIGHT HEURISTICS");
            System.out.println("===================================");
            long start = System.currentTimeMillis();
            PathCalculator.calculatePath(points);
            long end = System.currentTimeMillis();
            System.out.println("This algorithm took " + (end - start) + "ms to complete");

            System.out.println("===================================");
            System.out.println("RESULTS");
            System.out.println("===================================");
            TravelBookGenerator.renderPathInConsole(points);

            String decision;
            System.out.println("USER INPUT REQUIRED");
            System.out.println("Do you want to try again? [Y/N]");
            decision = in.nextLine().toUpperCase();
            while(!decision.equals("Y") && !decision.equals("N")){
                System.out.println("Use either Y or N, do you want to try again? [Y/N]");
                decision = in.nextLine().toUpperCase();
            }
            if(decision.equals("N")){
                cont = false;
            }
        }
        System.out.println("shutting down, uwu");
    }
}
