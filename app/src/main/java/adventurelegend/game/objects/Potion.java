package adventurelegend.game.objects;

public class Potion extends Item{

    int curarVida;
    int curarMana;
    String color;

    public Potion(String nombre, int precio, String descripcion, int curarVida, int curarMana, int color) {
        super(nombre, precio, descripcion);
        this.curarVida = curarVida;
        this.curarMana= curarMana;
        setColor(color);
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

    public String getColor() {
        return color;
    }

    public void setColor(int color) {
        if (color == 1){
            this.color = "#4CAF50";
        } else if (color == 2){
            this.color = "#2196F3";
        } else if (color == 3){
            this.color = "#FFC107";
        }
    }
}
