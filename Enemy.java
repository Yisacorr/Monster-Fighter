package lab.pkg12;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Yisacor
 * Enemy class
 */
public class Enemy {

    private String name;
    private int maxHp;
    private int hp;

    /**
     * Enemy constructor: initialize name, hp and maxhp. 
     * @param n name of the enemy.
     * @param h hit point of the enemy.
     */
    public Enemy(String n, int h) {
        name = n;
        hp = h;
        maxHp = h;
    }

    /**
     * copy constructor: creates enemy with the same value form the constructor.
     * @param e
     */
    public Enemy(Enemy e) {
        if (e != null) {
            this.name = e.name;
            this.hp = e.hp;
            this.maxHp = e.maxHp;
        }
    }
    
    /*
     *method: getName
     *@return enemy name
     */
    public String getName() {
        return name;
    }
    
    /*
     *method: getHp
     *@return hp
     */
    public int getHp() {
        return hp;
    }
    
    /* 
     *@method takeDamage: calculates hp of the enemy
     */
    public void takeDamage(int h) {
        hp = hp - h;
        if (hp < 0)
        {
          hp = 0;
        }
    }
    /*
     *Method: attack
     *@returns: a random amount of damage that the enemy does.
     */
    public int attack() {
        return ((int) (Math.random() * (5) + 1));
    }

    /*
     *@return: the name and hp of the enemy in a format we want.
     */
    @Override
    public String toString() {
        return (name + " \n" + "HP: "+ hp + "/" + maxHp );
    }

    /*
     *Method clone: creates and returns a copy of the enemy by calling the copy constructor.
     *@return:  a copy of the enemy.
     */
    @Override
    public Enemy clone() {
        return new Enemy(this);
    }
}
