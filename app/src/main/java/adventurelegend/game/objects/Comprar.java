package adventurelegend.game.objects;

import android.app.Activity;

import adventurelegend.game.GlobalPlayer;

public class Comprar {

    public Comprar() {
    }

    public void comprarArma(Weapon weapon){
        //((GlobalPlayer)getApplication()).getPlayer().menosDinero(weapon.getPrecio());
        //((GlobalPlayer)getActivity.getApplication()).getPlayer().getInventory().addWeapon(weapon);
    }
    public void comprarArmadura(Armor armor){
        //((GlobalPlayer)getApplication()).getPlayer().menosDinero(armor.getPrecio());
        //((GlobalPlayer)getApplication()).getPlayer().getInventory().addArmor(armor);
    }
    public void comprarPotion(Potion potion){
        //((GlobalPlayer)getApplication()).getPlayer().menosDinero(potion.getPrecio());
        //((GlobalPlayer)getApplication()).getPlayer().getInventory().addPotion(potion);
    }
    public void comprarSpecial(Special special){
        //((GlobalPlayer)getApplication()).getPlayer().menosDinero(special.getPrecio());
        //((GlobalPlayer)getApplication()).getPlayer().getInventory().addSpecial(special);
    }
}
