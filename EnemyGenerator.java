/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Yisacor
 * EnemyGenerator class
 */
public class EnemyGenerator {

    private ArrayList<Enemy> enemyList;

    /*
     *Constructor: reads in a file (enemyList.txt) of template enemies and stores 
      them in the ArrayList.
     */
    public EnemyGenerator() {
        enemyList = new ArrayList<>();
        try {
            File enemies = new File("C:\\Users\\Yisacor\\OneDrive\\Desktop\\File\\cecs 277\\Lab-12\\src\\lab\\pkg12\\enemyList.txt");
            Scanner in = new Scanner(enemies);

            while (in.hasNextLine()) {

                String[] str = in.nextLine().split(",");
                enemyList.add(new Enemy((str[str.length - 2]), Integer.parseInt(str[str.length - 1])));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /*
     *@Method: chooses a random enemy from the ArrayList
     *@return: a copy of the random enemy
     */
    public Enemy generateEnemy() {
        return enemyList.get((int) (Math.random() * (enemyList.size()))).clone();
    }
}
