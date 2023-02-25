package engine.graphic.polygon.Polygon;

import engine.common.units.Point2;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class Polygon {

    private ArrayList<Point2> points = new ArrayList<>();

    public Polygon(ArrayList<Point2> points) {
        this.points.addAll(points);
    }

    public Polygon() {  }

    public void addPoint(float dx, float dy) {
        points.add(new Point2(dx, dy));
    }

    public void addPoint(Point2 point) {
        points.add(point);
    }

    public void rotate() {
        // TO BE IMPLEMENTED
    }

    public void render() {
        glBegin(GL_POLYGON);

        for (Point2 point : points) {
            glVertex2f(point.getX(), point.getY());
        }

        glEnd();
    }
}