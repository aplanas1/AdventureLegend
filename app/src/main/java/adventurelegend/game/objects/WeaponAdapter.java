package adventurelegend.game.objects;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import adventurelegend.game.GlobalPlayer;
import adventurelegend.game.R;
import adventurelegend.game.databinding.ViewholderWeaponBinding;

public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.ViewHolder> {

    private List<Weapon> list;

    public WeaponAdapter(List<Weapon> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ViewholderWeaponBinding binding = ViewholderWeaponBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.nombre.setText(list.get(position).getNombre());
        holder.binding.ataque.setText("" + list.get(position).getDamage());
        holder.binding.precio.setText("" + list.get(position).getPrecio());
        holder.binding.imagen.setImageResource(R.drawable.sword1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ViewholderWeaponBinding binding;

        public ViewHolder(@NonNull ViewholderWeaponBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}