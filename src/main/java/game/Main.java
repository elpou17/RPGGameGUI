package game;

public class Main {
    public static void main(String[] args) {
        System.out.println("🏰 Bienvenido al Reino de Eldoria...");
        Player hero = new Player("Arthas el Guerrero");
        Enemy slime = new Enemy("Slime", 30, 5);
        Enemy boss = new Enemy("Dragón Oscuro", 100, 20);

        Battle.start(hero, slime);
        if (hero.isAlive()) {
            System.out.println("\n🎉 ¡Has vencido al slime! Pero el verdadero enemigo te espera...\n");
            Battle.start(hero, boss);

            if (hero.isAlive()) {
                System.out.println("\n👑 ¡Has rescatado a la princesa! El reino está a salvo.");
            } else {
                System.out.println("\n💀 El dragón te ha vencido. La princesa no fue rescatada...");
            }
        } else {
            System.out.println("\n💀 Has caído. El slime fue demasiado fuerte.");
        }
    }
}
