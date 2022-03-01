package adventurelegend.game.objects;

import java.util.ArrayList;
import java.util.List;

public class Map {

    public List<CasillaX> casillaXS;
    private int turn;
    private boolean day;

    public Map() {
        this.casillaXS = new ArrayList<>();
        for (int i = 0; i < 98; i++) {
            casillaXS.add(new CasillaX());
        }
        int turn = 1;
        day = true;
    }

    public List<CasillaX> getCasillaXS() {
        return casillaXS;
    }

    public void setCasillaXS(List<CasillaX> casillaXS) {
        this.casillaXS = casillaXS;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void nextTurn() {
        if (this.turn > 5) {
            this.turn = 1;
            if (isDay()){
                setNight();
            } else {
                setDay();
            }
        } else {
            this.turn++;
        }
    }

    public boolean isDay() {
        return day;
    }

    public String getDay() {
        if (isDay()) {
            return "Day";
        } else {
            return "Night";
        }
    }

    public void setDay() {
        this.day = true;
    }
    public void setNight() {
        this.day = false;
    }

    public void getPlayer(){
        for (CasillaX casillaX: casillaXS) {
            casillaX.getPlayer();
        }
    }
}
