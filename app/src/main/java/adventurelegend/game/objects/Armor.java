package adventurelegend.game.objects;

public class Armor extends Item{

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
}
