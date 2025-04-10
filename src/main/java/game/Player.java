package game;

public class Player {
    String name;
    int hp;
    int maxHp;
    int attackPower;

    public Player(String name) {
        this.name = name;
        this.maxHp = 100;
        this.hp = maxHp;
        this.attackPower = 20;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " ataca a " + enemy.name + " con " + attackPower + " de daño.");
        enemy.takeDamage(attackPower);
    }

    public void heal() {
        int heal = 20;
        hp = Math.min(maxHp, hp + heal);
        System.out.println(name + " se cura " + heal + " puntos. HP actual: " + hp);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " recibe " + damage + " de daño. HP restante: " + hp);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
