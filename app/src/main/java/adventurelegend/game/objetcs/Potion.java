package adventurelegend.game.objetcs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Potion extends Item{
    @PrimaryKey(autoGenerate = true)
    int id;

    int curarVida;
    int curarMana;


    public Potion(String nombre, int precio, String descripcion, int curarVida, int curarMana) {
        super(nombre, precio, descripcion);
        this.curarVida = curarVida;
        this.curarMana= curarMana;
    }

    public int getCurarVida() {
        return curarVida;
    }

    public void setCurarVida(int curarVida) {
        this.curarVida = curarVida;
    }

    public int getCurarMana() {
        return curarMana;
    }

    public void setCurarMana(int curarMana) {
        this.curarMana = curarMana;
    }
}
