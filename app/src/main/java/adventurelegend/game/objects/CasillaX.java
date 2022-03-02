package adventurelegend.game.objects;

import java.util.ArrayList;
import java.util.List;

public class CasillaX {

    public CasillaY[] casillaYS;

    public CasillaX() {
        this.casillaYS = new CasillaY[98];
        for (int i = 0; i < casillaYS.length; i++) {
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
            casillaYS[i] = new CasillaY(valor);
        }
    }
    
    public int getPlayer(){
        for (int i = 0; i < casillaYS.length; i++) {
            if (casillaYS[i].isPlayer()){
                return i;
            }
        }
        return -1;
    }
}
