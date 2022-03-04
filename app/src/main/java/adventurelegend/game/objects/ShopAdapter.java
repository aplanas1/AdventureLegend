package adventurelegend.game.objects;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import adventurelegend.game.R;
import adventurelegend.game.databinding.ViewholderItemBinding;

public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    final int VIEW_TYPE_POTION = 0;
    final int VIEW_TYPE_SPECIAL = 1;

    private List<Potion> listPotion;
    private List<Special> listSpecial;
    private Comprar comprar;

    public ShopAdapter(List<Potion> list, List<Special> list2) {
        this.listPotion = list;
        this.listSpecial = list2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_POTION){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ViewholderItemBinding binding = ViewholderItemBinding.inflate(inflater, parent, false);
            return new PotionViewHolder(binding);
        }

        if(viewType == VIEW_TYPE_SPECIAL){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ViewholderItemBinding binding = ViewholderItemBinding.inflate(inflater, parent, false);
            return new SpecialViewHolder(binding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof PotionViewHolder){
            ((PotionViewHolder) holder).populate(listPotion.get(position));
        }

        if(holder instanceof SpecialViewHolder){
            ((SpecialViewHolder) holder).populate(listSpecial.get(position - listPotion.size()));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder instanceof PotionViewHolder){
                    comprar.comprarPotion(listPotion.get(position));

                }

                if(holder instanceof SpecialViewHolder){
                    comprar.comprarSpecial(listSpecial.get(position - listPotion.size()));
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position){
        if(position < listPotion.size()){
            return VIEW_TYPE_POTION;
        }

        if(position - listPotion.size() < listSpecial.size()){
            return VIEW_TYPE_SPECIAL;
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        return listPotion.size() + listSpecial.size();
    }

    public class PotionViewHolder extends RecyclerView.ViewHolder {

        private ViewholderItemBinding binding;

        public PotionViewHolder(@NonNull ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void populate (Potion potion){
            binding.nombre.setText(potion.getNombre());
            binding.atributo.setText("Vida: " + potion.getCurarVida());
            binding.atributo2.setText("Mana: " + potion.getCurarMana());
            binding.imagen.setImageResource(R.drawable.potion1);
            binding.cuadro.setBackgroundColor(Color.parseColor(potion.getColor()));
        }
    }
    public class SpecialViewHolder extends RecyclerView.ViewHolder {

        private ViewholderItemBinding binding;

        public SpecialViewHolder(@NonNull ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void populate (Special special){
            binding.nombre.setText(special.getNombre());
            binding.precio.setText("Valor: " + special.getPrecio());
            binding.imagen.setImageResource(R.drawable.star1);
            binding.cuadro.setBackgroundColor(Color.parseColor(special.getColor()));
        }
    }
}