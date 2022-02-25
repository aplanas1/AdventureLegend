package adventurelegend.game.objetcs;

public class Casilla {
    private int propiedad;
    private String lugar;
    private boolean player;

    public Casilla(int propiedad) {
        this.propiedad = propiedad;
        if (propiedad == 1){
            this.lugar = "Pueblo";
        } else if (propiedad == 2) {
            this.lugar = "Bosque";
        } else if (propiedad == 2) {
            this.lugar = "Lago";
        } else {
            this.lugar = "Prado";
        }
        this.player = false;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public String getLugar() {
        return lugar;
    }
}
