package design_pattern.Structural_design_pattern.FlyingWeightDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        BulletRegistry bulletRegistry = new BulletRegistry();
        Bullet bullet = new Bullet();
        bullet.calliber = 5.56;
        bulletRegistry.register(BulletType.T5_56, bullet);

        bullet = new Bullet();
        bullet.calliber = 7.62;
        bulletRegistry.register(BulletType.T7_62, bullet);

        bullet = new Bullet();
        bullet.calliber = 9;
        bulletRegistry.register(BulletType.T9, bullet);

        List<FlyingBullet> flyingBulletList = new ArrayList<>();

        FlyingBullet flyingBullet = new FlyingBullet(bulletRegistry.bulletRegistry.get(BulletType.T5_56), 300, 1);
        flyingBulletList.add(flyingBullet);

    }
}
