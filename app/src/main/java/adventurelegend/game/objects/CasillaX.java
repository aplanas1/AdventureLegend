package adventurelegend.game.objects;

import java.util.ArrayList;
import java.util.List;

public class CasillaX {

    public List<CasillaY> casillaYS;

    public CasillaX() {
        this.casillaYS = new ArrayList<>();
        for (int i = 0; i < 98; i++) {
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
            casillaYS.add(new CasillaY(valor));
        }
    }
    
    public int getPlayer(){
        for (CasillaY casillaY: casillaYS) {
            if (casillaY.isPlayer()) {
                return casillaYS.indexOf(casillaY);
            }
        }

        return -1;
    }
}
