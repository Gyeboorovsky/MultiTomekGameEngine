package engine.common.models;


import engine.common.units.Point2;
import engine.graphic.polygon.Polygon;

public class MobileObject extends GameObject {
    float speed;

    public MobileObject(Polygon shape, Point2 position, float scale, float speed) {
        super(shape, position, scale);
        this.speed = speed;
    }

    public MobileObject(Polygon shape, Point2 positon, float speed) {
        super(shape, positon);
        this.speed = speed;
    }

    public MobileObject(Point2 positon, float speed) {
        super(positon);
        this.speed = speed;
    }

    public MobileObject(Point2 positon) {
        super(positon);
        this.speed = 0;
    }
}
