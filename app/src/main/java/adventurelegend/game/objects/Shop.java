package adventurelegend.game.objects;

import java.util.ArrayList;
import java.util.List;

public class Shop {

    List<Weapon> weapons;
    List<Armor> armors;
    List<Potion> potions;
    List<Special> specials;

    public Shop() {
        this.weapons = new ArrayList<>();
        this.armors = new ArrayList<>();
        this.potions = new ArrayList<>();
        this.specials = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            addWeapon(new Weapon("Espada de hierro", 10, "Espada rudimentaria de hierro", 5, 2));
        }
        for (int i = 0; i < 4; i++) {
            addArmor(new Armor("Armadura de hierro", 10, "Armadura rudimentaria de hierro", 5, 2));
        }
        for (int i = 0; i < 10; i++) {
            addPotion(new Potion("Pocion de vida", 5, "Pocion para sanar la salud", 10, 0,1));
        }
        for (int i = 0; i < 5; i++) {
            addPotion(new Potion("Pocion de mana", 5, "Pocion para sanar el mana", 0, 10, 2));
        }
        for (int i = 0; i < 3; i++) {
            addSpecial(new Special("Madera", 3, "Madera", 1));
        }

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
