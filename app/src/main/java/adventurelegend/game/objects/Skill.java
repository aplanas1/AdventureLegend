package adventurelegend.game.objects;

public class Skill {
    public String name;
    private int damage;
    private boolean fuerza;
    private boolean destreza;
    private boolean inteligencia;
    private int cost;
    private int image;

    public Skill(String name, int damage, boolean fuerza, boolean destreza, boolean inteligencia, int cost) {
        this.name = name;
        this.damage = damage;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.cost = cost;
    }

    public int getDamage(int statFue, int statDes, int statInt) {
        int total = damage;
        if (fuerza) total += statFue;
        if (destreza) total += statDes;
        if (inteligencia) total += statInt;

        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isFuerza() {
        return fuerza;
    }

    public void setFuerza(boolean fuerza) {
        this.fuerza = fuerza;
    }

    public boolean isDestreza() {
        return destreza;
    }

    public void setDestreza(boolean destreza) {
        this.destreza = destreza;
    }

    public boolean isInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(boolean inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
