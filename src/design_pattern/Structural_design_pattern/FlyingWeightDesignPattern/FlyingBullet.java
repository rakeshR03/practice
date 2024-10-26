package design_pattern.Structural_design_pattern.FlyingWeightDesignPattern;

public class FlyingBullet {
    Bullet bullet;
    int speed;
    int direction;

    FlyingBullet(Bullet bullet, int speed, int direction) {
        this.bullet = bullet;
        this.speed = speed;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public int getSpeed() {
        return speed;
    }
}
