package game;

import java.util.Scanner;

public class Battle {
    public static void start(Player player, Enemy enemy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("⚔️ ¡Comienza la batalla contra " + enemy.name + "!");

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\n¿Qué quieres hacer?");
            System.out.println("1. Atacar");
            System.out.println("2. Curarte");
            System.out.println("3. Huir");
            System.out.print("Elige: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    player.attack(enemy);
                    break;
                case 2:
                    player.heal();
                    break;
                case 3:
                    System.out.println("🚪 ¡Has escapado de la batalla!");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }

            if (enemy.isAlive()) {
                enemy.attack(player);
            }
        }
    }
}
