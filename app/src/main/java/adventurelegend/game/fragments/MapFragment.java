package adventurelegend.game.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import adventurelegend.game.R;
import adventurelegend.game.databinding.FragmentMapBinding;
import adventurelegend.game.GlobalPlayer;

public class MapFragment extends Fragment {

    private FragmentMapBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMapBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.life.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
        binding.mana.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());
        binding.goldText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getDinero());
        binding.turnText.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
        binding.stageText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getDay());


        // PROFILE
        binding.profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_profileFragment);
            }
        });
        // SKILLS
        binding.skillsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_skillsFragment);
            }
        });
        // QUESTS
        binding.questsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_questsFragment);
            }
        });
        // BACKPACK
        binding.inventoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_inventoryFragment_weapons);
            }
        });
        // INTERACT
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_townFragment);
            }
        });
    }
}