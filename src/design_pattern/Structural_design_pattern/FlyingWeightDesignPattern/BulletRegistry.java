package design_pattern.Structural_design_pattern.FlyingWeightDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class BulletRegistry {
    Map<BulletType, Bullet> bulletRegistry = new HashMap<>();

    public void register(BulletType bulletType, Bullet bullet) {
        bulletRegistry.put(bulletType, bullet);
    }

    public void deRegister(BulletType bulletType) {
        bulletRegistry.remove(bulletType);
    }
}
