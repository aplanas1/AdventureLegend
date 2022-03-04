package adventurelegend.game.objects;

public class Special extends Item{

    int calidad;
    String color;

    public Special(String nombre, int precio, String descripcion, int calidad) {
        super(nombre, precio, descripcion);
        this.calidad = calidad;
        setColor(calidad);
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
            this.color = "#8E8278";
        } else if (calidad == 2) {
            this.color = "#C0C39E";
        } else {
            this.color = "#BF633C20";
        }
    }
}
