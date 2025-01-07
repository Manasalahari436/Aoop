package task_1;

public class EasyEnemyFactory extends EnemyFactory {
    public Enemy createEnemy() {
        return new Goblin();
    }
}
