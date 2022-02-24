package adventurelegend.game.objetcs;

import java.util.ArrayList;

public class Item {
    private String nombre;
    private String descripcion;
    private int precio;

    public Item(String nombre, int precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
}
