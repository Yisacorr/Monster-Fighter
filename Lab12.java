/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg12;

/**
 * CECCS 227 Sec 4 Lab #12
 *
 * @author Yisacor Description: The program generates new Enemies for the user
 * to fight. The user will attack the enemy, and if the enemy is still alive, it
 * will attack the user back.
 */
public class Lab12 {

    /**
     * @param args the command line arguments 
     * main method: asks the user if they
                    want to attack the enemy or quit the game. if the user wants to attack
                    the game will continue until the users runs out of hp.
     */
    public static void main(String[] args) {

        int enemieSlainCount = 0;
        int userHp = 25;
        int maxUserHp = 25;
        boolean quit = false;

        do {
            EnemyGenerator g = new EnemyGenerator();
            Enemy enemy = g.generateEnemy();
            System.out.println("You have " + userHp + "/" + maxUserHp + " hp.");
            System.out.println("You encounter a " + enemy);
            do {

                System.out.println("What do you want to do? ");
                System.out.println("1. Attack Enemy");
                System.out.println("2. Quit");
                int option = CheckInput.getIntRange(1, 2);
                switch (option) {
                    case 1:

                        int randAttack = ((int) (Math.random() * (5) + 1));

                        System.out.println("You attack " + enemy.getName() + " for " + randAttack + " damage");
                        enemy.takeDamage(randAttack);

                        if (enemy.getHp() > 0) {
                            int enemyDamage = enemy.attack();
                            System.out.println(enemy.getName() + " attack you for " + enemyDamage + " damage");
                            userHp -= enemyDamage;
                            System.out.println(enemy);
                        }
                        if (enemy.getHp() == 0) {
                            System.out.println("You have slain the " + enemy.getName());
                            System.out.println();
                            enemieSlainCount += 1;
                        }
                        break;
                    case 2:
                        quit = true;
                        break;
                }
            } while (!quit && (enemy.getHp() > 0) && userHp > 0);

        } while (!quit && userHp > 0);
        if (userHp <= 0) {
            System.out.println("You have died.\nEnemies Slain: " + enemieSlainCount + "\nGame Over.");

        }
    }

}
