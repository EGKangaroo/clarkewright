package alg.joey.models;

public class Shortcut {
    private Point a;
    private Point b;
    private double totalSaving;

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public double getTotalSaving() {
        return totalSaving;
    }

    public Shortcut(Point a, Point b, double totalSaving) {
        this.a = a;
        this.b = b;
        this.totalSaving = totalSaving;
    }

    @Override
    public String toString(){
        return a.getName() + "," + b.getName() + " total saving: " + totalSaving;
    }
}
