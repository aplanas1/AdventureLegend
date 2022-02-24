package adventurelegend.game.objetcs;

public class Player {
    private int nivel;
    private String nombre;
    private int vida, actualVida;
    private int mana, actualMana;
    private int ataque, defensa;
    private int fuerza, destreza, inteligencia, constitucion, suerte, carisma;
    private Inventory inventory;
    private Weapon weapon;
    private Armor armor;

    public Player(int nivel, String nombre, int vida, int actualVida, int mana, int actualMana, int ataque, int defensa, int fuerza, int destreza, int inteligencia, int constitucion, int suerte, int carisma) {
        this.nivel = nivel;
        this.nombre = nombre;
        this.vida = vida;
        this.actualVida = actualVida;
        this.mana = mana;
        this.actualMana = actualMana;
        this.ataque = ataque;
        this.defensa = defensa;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.constitucion = constitucion;
        this.suerte = suerte;
        this.carisma = carisma;
    }

    public void levelUp(int fuerzaUp, int destrezaUp, int inteligenciaUp, int constitucionUp, int suerteUp, int carismaUp) {
        this.nivel++;
        this.fuerza += 1 + fuerzaUp;
        this.destreza += 1 + destrezaUp;
        this.inteligencia += 1 + inteligenciaUp;
        this.constitucion += 1 + constitucionUp;
        this.suerte += 1 + suerteUp;
        this.carisma += 1 + carismaUp;
        this.ataque += 2;
        this.defensa += 2;
        this.vida += 4 + constitucion;
        this.actualVida = vida;
        this.mana += 2 + inteligencia;
        this.actualMana = mana;
    }

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void equipArmor(Armor armor){
        this.armor = armor;
    }

    public void unequipWeapon(Weapon weapon){
        this.weapon = new Weapon("Nada", 0, "Nada", 0);
    }

    public void unequipArmor(Armor armor){
        this.armor = new Armor("Nada", 0, "Nada", 0);
    }

    public void curar(Potion potion) {
        if (actualVida + potion.curarVida < vida){
            actualVida += potion.curarVida;
        } else {
            actualVida = vida;
        }

        if (actualMana + potion.curarMana < mana){
            actualMana += potion.curarMana;
        } else {
            actualMana = mana;
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getActualVida() {
        return actualVida;
    }

    public void setActualVida(int actualVida) {
        this.actualVida = actualVida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getActualMana() {
        return actualMana;
    }

    public void setActualMana(int actualMana) {
        this.actualMana = actualMana;
    }

    public int getAtaque() {
        return ataque + weapon.getDamage();
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa + armor.getDefensa();
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public int getSuerte() {
        return suerte;
    }

    public void setSuerte(int suerte) {
        this.suerte = suerte;
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
    }
}
