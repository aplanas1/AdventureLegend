package adventurelegend.game.objects;

public class Armor extends Item{

    private int defensa;
    int calidad;
    String color;

    public Armor(String nombre, int precio, String descripcion, int defensa, int calidad) {
        super(nombre, precio, descripcion);
        this.defensa = defensa;
        this.calidad = calidad;
        setColor(calidad);
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(int calidad) {
        if (calidad == 1) {
            this.color = "#B6B6B6";
        } else if (calidad == 2) {
            this.color = "#8DD351";
        } else if (calidad == 3) {
            this.color = "#4A9AD1";
        } else if (calidad == 4) {
            this.color = "#E68132";
        } else if (calidad == 5) {
            this.color = "#E13232";
        } else if (calidad == 6) {
            this.color = "#A426D3";
        } else {
            this.color = "#BF633C20";
        }
    }
}
