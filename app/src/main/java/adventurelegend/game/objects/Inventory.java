package adventurelegend.game.objects;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    List<Weapon> weapons;
    List<Armor> armors;
    List<Potion> potions;
    List<Special> specials;

    public Inventory() {
        this.weapons = new ArrayList<>();
        this.armors = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.specials = new ArrayList<>();
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

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public void setArmors(ArrayList<Armor> armors) {
        this.armors = armors;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public void setSpecials(ArrayList<Special> specials) {
        this.specials = specials;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Armor> getArmors() {
        return armors;
    }

    public List<Potion> getPotions() {
        return potions;
    }

    public List<Special> getSpecials() {
        return specials;
    }
}
