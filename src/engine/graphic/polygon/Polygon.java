package engine.graphic.polygon;

import engine.common.units.Point2;
import java.util.ArrayList;

public class Polygon {

    public ArrayList<Point2> points = new ArrayList<>();

    public Polygon(ArrayList<Point2> points) {
        this.points.addAll(points);
    }

    public Polygon() {}

    public void addPoint(float dx, float dy) {
        points.add(new Point2(dx, dy));
    }

    public void addPoint(Point2 point) {
        points.add(point);
    }

    public void rotate() {
        // TO BE IMPLEMENTED
    }
}