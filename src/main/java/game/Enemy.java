package game;

public class Enemy {
    String name;
    int hp;
    int attackPower;

    public Enemy(String name, int hp, int attackPower) {
        this.name = name;
        this.hp = hp;
        this.attackPower = attackPower;
    }

    public void attack(Player player) {
        System.out.println(name + " ataca a " + player.name + " con " + attackPower + " de daño.");
        player.takeDamage(attackPower);
    }

    public void takeDamage(int damage) {
        hp -= damage;
        System.out.println(name + " pierde " + damage + " de HP. HP restante: " + hp);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
