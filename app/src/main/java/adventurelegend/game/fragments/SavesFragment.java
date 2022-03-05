package adventurelegend.game.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import adventurelegend.game.GlobalPlayer;
import adventurelegend.game.R;
import adventurelegend.game.databinding.FragmentSavesBinding;
import adventurelegend.game.objects.Player;

public class SavesFragment extends Fragment {

    private FragmentSavesBinding binding;
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

        // BACK
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack();
            }
        });

        // SAVE 1
        binding.save1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.name1.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getNombre());
                binding.level1.setText("LVL: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getNivel());
                binding.gold1.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getDinero() + " gold");
                binding.turn1.setText("TURN " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
                binding.hero1.setImageResource(R.drawable.link);
            }
        });
        // SAVE 2
        binding.save2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.name2.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getNombre());
                binding.level2.setText("LVL: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getNivel());
                binding.gold2.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getDinero() + " gold");
                binding.turn2.setText("TURN " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
                binding.hero2.setImageResource(R.drawable.link);
            }
        });// SAVE 3
        binding.save3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.name3.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getNombre());
                binding.level3.setText("LVL: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getNivel());
                binding.gold3.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getDinero() + " gold");
                binding.turn3.setText("TURN " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
                binding.hero3.setImageResource(R.drawable.link);
            }
        });

    }
}