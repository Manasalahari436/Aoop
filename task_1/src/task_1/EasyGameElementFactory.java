package task_1;
public class EasyGameElementFactory implements GameElementFactory {
    public Weapon createWeapon() {
        return new Sword();
    }

    public PowerUp createPowerUp() {
        return new HealthPotion();
    }
}
