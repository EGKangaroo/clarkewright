package alg.joey.models;

import java.util.ArrayList;

public class Point {
    private ArrayList<Point> connections = new ArrayList<>();

    private String name;
    private boolean isHub = false;
    private float posX;
    private float posY;

    private boolean hasBeenQueried = false;

    private boolean hasBeenVisited = false;

    public ArrayList<Point> getConnections(){
        return connections;
    }

    public boolean getHasBeenVisited(){
        return hasBeenVisited;
    }

    public void setHasBeenVisited(boolean hasBeenVisited){
        this.hasBeenVisited = hasBeenVisited;
    }

    public int getConnectionCount(){
        int connectionCount = 0;
        for (Point item : connections){
            if(!item.isHub){
                connectionCount++;
            }
        }
        return connectionCount;
    }

    public boolean hasConnectionWith(Point point){
        boolean connected = false;
        hasBeenQueried = true;
        for(Point connection : connections){
            if(!connection.isHub && !connection.hasBeenQueried){
                if(connection.equals(point)){
                    connected = true;
                }
                else {
                    connected = connection.hasConnectionWith(point);
                }
            }
        }
        hasBeenQueried = false;
        return connected;
    }

    public void removeConnectionWith(Point point){
        if(connections.contains(point)){
            connections.remove(point);
            point.connections.remove(this);
        }
    }

    public void addConnectionWith(Point point){
        connections.add(point);
        point.connections.add(this);
    }

    public String getName() {
        return name;
    }

    public boolean isHub() {
        return isHub;
    }

    public void setHub(boolean isHub) {
        this.isHub = isHub;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public Point(String name, float posX, float posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append(name).append("\r\n");
        output.append("Connected with: \r\n");
        for (Point connection : connections){
            output.append(connection.name + "\r\n");
        }
        return output.toString();
    }
}
