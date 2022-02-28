package adventurelegend.game.objetcs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.lang.reflect.Array;

@Entity
public class Map {
    @PrimaryKey(autoGenerate = true)
    int id;

    public Casilla[][] casillas = new Casilla[98][98];

    public Map() {
        for (int i = 0; i < 98; i++) {
            for (int j = 0; j < 98; j++) {
                int random = (int) (Math.random() * (100 - 1) + 1);
                int valor;
                if (random > 85) {
                    valor = 1;
                } else if (random > 60) {
                    valor = 2;
                } else if (random > 45) {
                    valor = 3;
                } else {
                    valor = 0;
                }

                casillas[i][j] = new Casilla(valor);
            }
        }
        casillas[48][48].setPlayer();
    }

    public String valorCasilla(int a, int b) {
        return casillas[a][b].getLugar();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }
}
