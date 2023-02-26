package engine.common.models;

import engine.common.units.Point2;
import engine.graphic.polygon.Polygon;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class GameObject {
    Polygon shape;
    Point2 postion;
    float scale;

    public GameObject(Polygon shape, Point2 position, float scale) {
        this.shape = shape;
        this.postion = position;
        this.scale = scale;
    }

    public GameObject(Polygon shape, Point2 positon) {
        this.shape = shape;
        this.postion = positon;
        this.scale = 1;
    }

    public GameObject(Point2 positon) {
        this.shape = new Polygon();
        shape.addPoint(-0.1f, -0.1f);
        shape.addPoint(0.1f, -0.1f);
        shape.addPoint(0.1f, 0.1f);
        shape.addPoint(-0.1f, 0.1f);
        this.postion = positon;
        this.scale = 1;
    }

    public void render() {
        glBegin(GL_POLYGON);

        for (Point2 point : shape.points) {
            glVertex2f(
                    point.getX() + postion.x,
                    point.getY() + postion.y);
        }

        glEnd();
    }
}
