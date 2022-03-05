package adventurelegend.game.objects;

public class Map {

    public Casilla[][] casillas;
    private int turn;
    private boolean day;

    public Map() {
        this.casillas = new Casilla[99][99];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
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
        turn = 1;
        day = true;
        casillas[casillas.length/2][casillas.length/2].setPlayer();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                System.out.print(casillas[i][j]);
            }
            System.out.println();
        }
    }

    public Casilla[][] getCasillas() {
        return casillas;
    }

    public Casilla getCasilla(int i, int j) {
        return casillas[i][j];
    }

    public void setCasillas(Casilla[][] casillas) {
        this.casillas = casillas;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public void nextTurn() {
        if (this.turn >= 5) {
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

    public int getPlayer(boolean x){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas.length; j++) {
                if (casillas[i][j].isPlayer()){
                    if (x){
                        return i;
                    } else {
                        return j;
                    }
                }
            }
        }
        return -1;
    }

    public String getPlayerPlace(int x, int y){
        return casillas[x][y].getLugar();
    }
    public int getCasillaPropiedad(int x, int y){
        return casillas[x][y].getPropiedad();
    }

    public int getCasillaImage(int x, int y){
        return casillas[x][y].getPlace_image();
    }
    public int getPlayerImage(int x, int y){
        return casillas[x][y].getPlayer_image();
    }
}
