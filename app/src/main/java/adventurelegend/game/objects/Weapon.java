package adventurelegend.game.objects;

public class Weapon extends Item{

    private int damage;
    int calidad;
    String color;

    public Weapon(String nombre, int precio, String descripcion, int damage, int calidad) {
        super(nombre, precio, descripcion);
        this.damage = damage;
        this.calidad = calidad;
        setColor(calidad);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
