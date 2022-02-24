package adventurelegend.game.objetcs;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Weapon> weapons = new ArrayList<>();
    ArrayList<Armor> armors = new ArrayList<>();
    ArrayList<Potion> potions = new ArrayList<>();
    ArrayList<Special> specials = new ArrayList<>();

    public Inventory() {
    }

    public void addWeapon(Weapon weapon){
        this.weapons.add(weapon);
    }
    public void addArmor(Armor armor){
        this.armors.add(armor);
    }
    public void addPotion(Potion potion){
        this.potions.add(potion);
    }
    public void addSpecial(Special special){
        this.specials.add(special);
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Special> getSpecials() {
        return specials;
    }
}
