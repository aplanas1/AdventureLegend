package adventurelegend.game.objects;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import adventurelegend.game.R;
import adventurelegend.game.databinding.ViewholderItemBinding;

public class ForgeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int VIEW_TYPE_ARMOR = 0;
    final int VIEW_TYPE_WEAPON = 1;

    private List<Armor> listArmor;
    private List<Weapon> listWeapon;
    private Comprar comprar = new Comprar();

    public ForgeAdapter(List<Armor> list, List<Weapon> list2) {
        this.listArmor = list;
        this.listWeapon = list2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_ARMOR){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ViewholderItemBinding binding = ViewholderItemBinding.inflate(inflater, parent, false);
            return new ArmorViewHolder(binding);
        }

        if(viewType == VIEW_TYPE_WEAPON){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ViewholderItemBinding binding = ViewholderItemBinding.inflate(inflater, parent, false);
            return new WeaponViewHolder(binding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ArmorViewHolder){
            ((ArmorViewHolder) holder).populate(listArmor.get(position));
        }

        if(holder instanceof WeaponViewHolder){
            ((WeaponViewHolder) holder).populate(listWeapon.get(position - listArmor.size()));
        }
    }

    @Override
    public int getItemViewType(int position){
        if(position < listArmor.size()){
            return VIEW_TYPE_ARMOR;
        }

        if(position - listArmor.size() < listWeapon.size()){
            return VIEW_TYPE_WEAPON;
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        return listArmor.size() + listWeapon.size();
    }

    public class ArmorViewHolder extends RecyclerView.ViewHolder{

        private ViewholderItemBinding binding;

        public ArmorViewHolder(@NonNull ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void populate (Armor armor){
            binding.nombre.setText(armor.getNombre());
            binding.atributo.setText("Defensa: " + armor.getDefensa());
            binding.precio.setText("Valor: " + armor.getPrecio());
            binding.imagen.setImageResource(R.drawable.helmet1);
            binding.cuadro.setBackgroundColor(Color.parseColor(armor.getColor()));
        }
    }
    public class WeaponViewHolder extends RecyclerView.ViewHolder {

        private ViewholderItemBinding binding;

        public WeaponViewHolder(@NonNull ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void populate (Weapon weapon){
            binding.nombre.setText(weapon.getNombre());
            binding.atributo.setText("Daño: " + weapon.getDamage());
            binding.precio.setText("Valor: " + weapon.getPrecio());
            binding.imagen.setImageResource(R.drawable.sword1);
            binding.cuadro.setBackgroundColor(Color.parseColor(weapon.getColor()));
        }
    }
}