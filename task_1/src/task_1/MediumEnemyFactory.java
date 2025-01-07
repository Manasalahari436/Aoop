package task_1;

public class MediumEnemyFactory extends EnemyFactory {
    public Enemy createEnemy() {
        return new Orc();
    }
}
