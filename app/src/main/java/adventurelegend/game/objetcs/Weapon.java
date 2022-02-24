package adventurelegend.game.objetcs;

import java.util.ArrayList;

public class Weapon extends Item{

    private int damage;

    public Weapon(String nombre, int precio, String descripcion, int damage) {
        super(nombre, precio, descripcion);
        this.damage = damage;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
