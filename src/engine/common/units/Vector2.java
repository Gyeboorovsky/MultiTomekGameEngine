package engine.common.units;

public class Vector2 {
    float x;
    float y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2() {
        this.x = 0;
        this.y = 0;
    }

    public Vector2 getVector() {
        return this;
    }

    public float getX() {
        return x;
    }

    public void moveX(float x) {
        this.x += x;
    }

    public float getY() {
        return y;
    }

    public void moveY(float y) {
        this.y += y;
    }
}
