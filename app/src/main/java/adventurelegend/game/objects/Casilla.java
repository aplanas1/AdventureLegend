package adventurelegend.game.objects;

import adventurelegend.game.R;

public class Casilla {

    private int propiedad;
    private String lugar;
    private boolean player;
    private int player_image;
    private int place_image;

    @Override
    public String toString() {
        return " " + propiedad;
    }

    public Casilla(int propiedad) {
        this.propiedad = propiedad;
        if (propiedad == 1){
            this.lugar = "Pueblo";
            this.place_image = R.drawable.star1;
        } else if (propiedad == 2) {
            this.lugar = "Bosque";
            this.place_image = R.drawable.sword1;
        } else if (propiedad == 3) {
            this.lugar = "Lago";
            this.place_image = R.drawable.potion1;
        } else {
            this.lugar = "Prado";
            this.place_image = R.drawable.arrow;
        }
        this.player = false;
    }

    public void setPlayer() {
        this.player = true;
        player_image = R.drawable.helmet1;
    }
    public void desetPlayer() {
        this.player = false;
        this.player_image = R.drawable.star1;
    }

    public String getLugar() {
        return lugar;
    }

    public int getPlayer_image() {
        return player_image;
    }

    public void setPlayer_image(int player_image) {
        this.player_image = player_image;
    }

    public int getPlace_image() {
        return place_image;
    }

    public void setPlace_image(int place_image) {
        this.place_image = place_image;
    }

    public int getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(int propiedad) {
        this.propiedad = propiedad;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }
}
