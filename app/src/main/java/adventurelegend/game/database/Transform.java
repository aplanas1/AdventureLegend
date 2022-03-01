package adventurelegend.game.database;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import adventurelegend.game.objetcs.Armor;
import adventurelegend.game.objetcs.Casilla;
import adventurelegend.game.objetcs.Inventory;
import adventurelegend.game.objetcs.Map;
import adventurelegend.game.objetcs.Potion;
import adventurelegend.game.objetcs.Special;
import adventurelegend.game.objetcs.Weapon;

public class Transform {

    // STORE TO ROOM
    // Object -> Serialize -> String -> Store
    // READ FROM ROOM
    // String -> Deserialize -> Object -> Read

    // OBJECT
    // INVENTORY
    public String stringFromInventory(Inventory inventory){
        Gson gson = new Gson();
        String jsonString = gson.toJson(inventory);
        return jsonString;
    }
    public Inventory getInventoryFromString(String jsonString){
        Type inventoryType = new TypeToken<Inventory>(){}.getType();
        Inventory inventory = new Gson().fromJson(jsonString, inventoryType);
        return inventory;
    }
    // MAP
    public String stringFromMap(Map map){
        Gson gson = new Gson();
        String jsonString = gson.toJson(map);
        return jsonString;
    }
    public Map getMapFromString(String jsonString){
        Type mapType = new TypeToken<Inventory>(){}.getType();
        Map map = new Gson().fromJson(jsonString, mapType);
        return map;
    }
    // WEAPON
    public String stringFromWeapon(Weapon weapon){
        Gson gson = new Gson();
        String jsonString = gson.toJson(weapon);
        return jsonString;
    }
    public Weapon getWeaponFromString(String jsonString){
        Type weaponType = new TypeToken<Inventory>(){}.getType();
        Weapon weapon = new Gson().fromJson(jsonString, weaponType);
        return weapon;
    }
    // ARMOR
    public String stringFromArmor(Armor armor){
        Gson gson = new Gson();
        String jsonString = gson.toJson(armor);
        return jsonString;
    }
    public Armor getArmorFromString(String jsonString){
        Type armorType = new TypeToken<Inventory>(){}.getType();
        Armor armor = new Gson().fromJson(jsonString, armorType);
        return armor;
    }

    //LIST
    //WEAPON
    public String stringFromWeapons(List<Weapon> list){

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        return jsonString;

    }
    public List<Weapon> getOWeaponsFromString(String jsonString){

        Type listType = new TypeToken<ArrayList<Weapon>>(){}.getType();
        List<Weapon> list = new Gson().fromJson(jsonString, listType);
        return list;

    }
    //ARMOR
    public String stringFromArmors(List<Armor> list){

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        return jsonString;

    }
    public List<Armor> getArmorsFromString(String jsonString){

        Type listType = new TypeToken<ArrayList<Armor>>(){}.getType();
        List<Armor> list = new Gson().fromJson(jsonString, listType);
        return list;

    }
    //POTIONS
    public String stringFromPotions(List<Potion> list){

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        return jsonString;

    }
    public List<Potion> getPotionsFromString(String jsonString){

        Type listType = new TypeToken<ArrayList<Potion>>(){}.getType();
        List<Potion> list = new Gson().fromJson(jsonString, listType);
        return list;

    }
    //SPECIAL
    public String stringFromSpecial(List<Special> list){

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        return jsonString;

    }
    public List<Special> getSpecialFromString(String jsonString){

        Type listType = new TypeToken<ArrayList<Special>>(){}.getType();
        List<Special> list = new Gson().fromJson(jsonString, listType);
        return list;

    }
    //CASILLA
    public String stringFromCasillas(Casilla[][] list){

        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        return jsonString;

    }
    public Casilla[][] getCasillasFromString(String jsonString){

        Type listType = new TypeToken<ArrayList<Casilla>>(){}.getType();
        Casilla[][] list = new Gson().fromJson(jsonString, listType);
        return list;

    }
}
