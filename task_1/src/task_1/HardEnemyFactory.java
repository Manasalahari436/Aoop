package task_1;
public class HardEnemyFactory extends EnemyFactory {
    public Enemy createEnemy() {
        return new Dragon();
    }
}
