package adventurelegend.game.objects;

import java.util.ArrayList;
import java.util.List;

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
    private Map map;
    private int dinero;
    private int casillaX;
    private int casillaY;
    private String lugar;
    private List<Skill> skills;
    private int xp;
    private int xpNext;

    public Player(String nombre, int fuerza, int destreza, int inteligencia, int constitucion, int suerte, int carisma) {
        this.nivel = 1;
        this.nombre = nombre;
        this.vida = 20 + constitucion;
        this.actualVida = vida;
        this.mana = 5 + inteligencia;
        this.actualMana = mana;
        this.ataque = 5;
        this.defensa = 3;
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.inteligencia = inteligencia;
        this.constitucion = constitucion;
        this.suerte = suerte;
        this.carisma = carisma;
        this.xp = 0;
        this.xpNext = 50;
        this.inventory = new Inventory();
        this.armor = new Armor("Ropas de tela", 2, "Ropas tipicas de cualquier granjero", 1);
        this.weapon = new Weapon("Espada de madera", 2, "Espsda rudimentaria de madera", 1);
        this.map = new Map();
        whereI();
        skills = new ArrayList<>();
        skills.add(new Skill("Slash" ,4,true,true,false, 2));
        skills.add(new Skill("Fireball" ,6,false,false,true, 3));
        skills.add(new Skill("Flamberge" ,8,true,true,true, 5));
    }

    public void levelUp() {
        this.nivel++;
        this.fuerza += 2;
        this.destreza += 2;
        this.inteligencia += 2;
        this.constitucion += 2;
        this.suerte += 2;
        this.carisma += 2;
        this.ataque += 2;
        this.defensa += 2;
        this.vida += 4 + constitucion/2;
        this.actualVida = vida;
        this.mana += 2 + inteligencia;
        this.actualMana = mana;
        this.xp = 0;
        this.xpNext += 50;
    }

    public void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void equipArmor(Armor armor){
        this.armor = armor;
    }

    public void unequipWeapon(Weapon weapon){
        this.weapon = new Weapon("",0,"",0);
    }

    public void unequipArmor(Armor armor){
        this.armor = new Armor("",0,"",0);
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }
    public void masDinero(int dinero) {
        this.dinero += dinero;
    }
    public void menosDinero(int dinero) {
        this.dinero -= dinero;
    }

    public void whereI(){
        setCasillaX(map.getPlayer(true));
        setCasillaY(map.getPlayer(false));
        setLugar(map.getPlayerPlace(casillaX, casillaY));
    }

    public int getCasillaX() {
        return casillaX;
    }

    public void setCasillaX(int casillaX) {
        this.casillaX = casillaX;
    }

    public int getCasillaY() {
        return casillaY;
    }

    public void setCasillaY(int casillaY) {
        this.casillaY = casillaY;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void moveUp(){
        if (casillaY < map.casillas.length - 1) {
            map.casillas[casillaX][casillaY].desetPlayer();
            casillaY++;
            map.casillas[casillaX][casillaY].setPlayer();
            setLugar(map.getPlayerPlace(casillaX, casillaY));
            map.nextTurn();
        }

    }
    public void moveDown(){
        if (casillaY > 0) {
            map.casillas[casillaX][casillaY].desetPlayer();
            casillaY--;
            map.casillas[casillaX][casillaY].setPlayer();
            setLugar(map.getPlayerPlace(casillaX, casillaY));
            map.nextTurn();
        }
    }
    public void moveRight(){
        if (casillaX < map.casillas.length - 1) {
            map.casillas[casillaX][casillaY].desetPlayer();
            casillaX++;
            map.casillas[casillaX][casillaY].setPlayer();
            setLugar(map.getPlayerPlace(casillaX, casillaY));
            map.nextTurn();
        }
    }
    public void moveLeft(){
        if (casillaX > 0){
            map.casillas[casillaX][casillaY].desetPlayer();
            casillaX--;
            map.casillas[casillaX][casillaY].setPlayer();
            setLugar(map.getPlayerPlace(casillaX, casillaY));
            map.nextTurn();
        }
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void addSkills(Skill skill) {
        this.skills.add(skill);
    }

    public int getXp() {
        return xp;
    }

    public void addXp(int points) {
        this.xp += points;
        if (xp>= xpNext) {
            levelUp();
        }
    }

    public int getXpNext() {
        return xpNext;
    }

    public void setXpNext(int xpNext) {
        this.xpNext = xpNext;
    }
}
