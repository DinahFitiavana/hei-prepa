package model;


public class Point {
    public int x;
    public int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object object){
        if (!(object instanceof Point)) return false; 
        Point other = (Point) object;
        return this.x == other.x && this.y == other.y;
    }
}