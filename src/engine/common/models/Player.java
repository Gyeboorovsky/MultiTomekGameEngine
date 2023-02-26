package engine.common.models;

import engine.common.units.Point2;
import engine.common.units.Vector2;
import engine.graphic.polygon.Polygon;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;

public class Player {
    static Polygon shape;
    static Point2 position;
    static float speed;
    static Vector2 vector;

    public static void initializePlayer() {
        shape = new Polygon();
        shape.addPoint(-0.1f, -0.1f);
        shape.addPoint(.1f, -0.1f);
        shape.addPoint(0.1f, 0.1f);
        shape.addPoint(-0.1f, 0.1f);
        position = new Point2(0.0f, 0.0f);
        speed = 0.02f;
        vector = new Vector2();
    }

    public static void renderPlayer() {
        position.x += vector.getX();
        position.y += vector.getY();

        glBegin(GL_POLYGON);
        for (Point2 point : shape.points) {
            glVertex2f(
                    point.getX() + position.x,
                    point.getY() + position.y);
        }
        glEnd();
    }

    public static void playerMovingRight() {
        vector.moveX(speed);
    }

    public static void playerMovingLeft() {
        vector.moveX(-speed);
    }

    public static void playerMovingUp() {
        vector.moveY(speed);
    }

    public static void playerMovingDown() {
        vector.moveY(-speed);
    }

    public static void playerStopMovingLeft() {
        vector.moveX(speed);
    }

    public static void playerStopMovingRight() {
        vector.moveX(-speed);
    }

    public static void playerStopMovingUp() {
        vector.moveY(-speed);
    }

    public static void playerStopMovingDown() {
        vector.moveY(speed);
    }

}
