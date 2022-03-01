package adventurelegend.game.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import adventurelegend.game.R;
import adventurelegend.game.databinding.FragmentSavesBinding;
import adventurelegend.game.databinding.ViewholderSaveBinding;
import adventurelegend.game.objetcs.Player;
import adventurelegend.game.database.PlayerViewModel;

import java.util.List;

public class SavesFragment extends Fragment {

    private FragmentSavesBinding binding;
    PlayerViewModel playerViewModel;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentSavesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        // PROFILE
        binding.newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_mapFragment);
            }
        });

        playerViewModel = new ViewModelProvider(requireActivity()).get(PlayerViewModel.class);

        PlayerAdapter playerAdapter;
        playerAdapter = new PlayerAdapter();

        binding.recyclerView.setAdapter(playerAdapter);

        binding.recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                ItemTouchHelper.RIGHT  | ItemTouchHelper.LEFT) {

            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int posicion = viewHolder.getAdapterPosition();
                Player player = playerAdapter.obtenerElemento(posicion);
                playerViewModel.eliminar(player);

            }
        }).attachToRecyclerView(binding.recyclerView);

        obtenerPlayers().observe(getViewLifecycleOwner(), new Observer<List<Player>>() {
            @Override
            public void onChanged(List<Player> players) {
                playerAdapter.establecerLista(players);
            }
        });
    }

    LiveData<List<Player>> obtenerPlayers(){
        return playerViewModel.obtener();
    }

    class PlayerAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

        List<Player> players;

        @NonNull
        @Override
        public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PokemonViewHolder(ViewholderSaveBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {

            Player player = players.get(position);

            holder.binding.nombre.setText(player.getNombre());
            Glide.with(SavesFragment.this).load(R.drawable.arrow).into(holder.binding.imagen);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playerViewModel.seleccionar(player);
                    navController.navigate(R.id.action_global_mapFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return players != null ? players.size() : 0;
        }

        public void establecerLista(List<Player> players){
            this.players = players;
            notifyDataSetChanged();
        }

        public Player obtenerElemento(int posicion){
            return players.get(posicion);
        }
    }

    static class PokemonViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderSaveBinding binding;

        public PokemonViewHolder(ViewholderSaveBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}