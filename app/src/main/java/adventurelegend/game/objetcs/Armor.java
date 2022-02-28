package adventurelegend.game.objetcs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Armor extends Item{
    @PrimaryKey(autoGenerate = true)
    int id;

    private int defensa;

    public Armor(String nombre, int precio, String descripcion, int defensa) {
        super(nombre, precio, descripcion);
        this.defensa = defensa;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
