package adventurelegend.game.objects;

public class Potion extends Item{

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
