package adventurelegend.game.objetcs;

import java.lang.reflect.Array;

public class Map {
    Casilla[][] casillas = new Casilla[99][99];

    public Map() {
        for (int i = 0; i < 99; i++) {
            for (int j = 0; j < 99; j++) {
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
    }

    public String valorCasilla(int a, int b) {
        return casillas[a][b].getLugar();
    }
}
