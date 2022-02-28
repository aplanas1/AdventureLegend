package adventurelegend.game.objetcs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Special extends Item{
    @PrimaryKey(autoGenerate = true)
    int id;

    public Special(String nombre, int precio, String descripcion) {
        super(nombre, precio, descripcion);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
