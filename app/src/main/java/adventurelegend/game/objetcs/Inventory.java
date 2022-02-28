package adventurelegend.game.objetcs;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Inventory {
    @PrimaryKey(autoGenerate = true)
    int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
