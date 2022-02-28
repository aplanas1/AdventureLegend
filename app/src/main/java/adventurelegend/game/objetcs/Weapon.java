package adventurelegend.game.objetcs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Weapon extends Item{
    @PrimaryKey(autoGenerate = true)
    int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
