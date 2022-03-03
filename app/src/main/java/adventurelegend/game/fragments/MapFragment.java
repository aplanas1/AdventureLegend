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
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.android.material.tabs.TabLayout;

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
        binding.goldText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getDinero() + " gold");
        binding.turnText.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
        binding.stageText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getDay());
        binding.placeText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getLugar());
        setMap();

        // UP
        binding.arrowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GlobalPlayer)getActivity().getApplication()).getPlayer().moveUp();
                binding.turnText.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
                binding.stageText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getDay());
                binding.placeText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getLugar());
                updateMap();
            }
        });
        // DOWN
        binding.arrowDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GlobalPlayer)getActivity().getApplication()).getPlayer().moveDown();
                binding.turnText.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
                binding.stageText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getDay());
                binding.placeText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getLugar());
                updateMap();
            }
        });
        // RIGHT
        binding.arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GlobalPlayer)getActivity().getApplication()).getPlayer().moveRight();
                binding.turnText.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
                binding.stageText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getDay());
                binding.placeText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getLugar());
                updateMap();
            }
        });
        // LEFT
        binding.arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GlobalPlayer)getActivity().getApplication()).getPlayer().moveLeft();
                binding.turnText.setText(((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getTurn() + " / 5");
                binding.stageText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getDay());
                binding.placeText.setText("" + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getLugar());
                updateMap();
            }
        });

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
                if (locateMenu() == 1) {
                    navController.navigate(R.id.action_global_townFragment);
                } else if (locateMenu() == 2) {
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().setEnemy((int) (Math.random() * 3 + 1));
                    navController.navigate(R.id.action_global_combatFragment);
                }
            }
        });
    }

    public void setMap(){
        int minX = ((GlobalPlayer)getActivity().getApplication()).getPlayer().getCasillaX() - 2;
        int maxX = ((GlobalPlayer)getActivity().getApplication()).getPlayer().getCasillaX() + 2;
        int minY = ((GlobalPlayer)getActivity().getApplication()).getPlayer().getCasillaY() - 2;
        int maxY = ((GlobalPlayer)getActivity().getApplication()).getPlayer().getCasillaY() + 2;
        TableLayout stk = binding.mapView;

        for (int i = minX; i <= maxX; i++) {
            TableRow tbrow = new TableRow(getActivity());
            for (int j = minY; j <= maxY; j++) {
                ImageView tv = new ImageView(getActivity());
                if (i >= 0 && i < ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().casillas.length) {
                    if (j >= 0 && j < ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().casillas.length) {
                        tv.setImageResource(((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getCasillaImage(i,j));
                    } else {
                        tv.setImageResource(R.drawable.backpack);
                    }
                } else {
                    tv.setImageResource(R.drawable.backpack);
                }
                tbrow.addView(tv);
            }
            stk.addView(tbrow);
        }

    }

    public void clearMap(){
        TableLayout stk = binding.mapView;
        int count = stk.getChildCount();
        for (int i = 0; i < count; i++) {
            View child = stk.getChildAt(i);
            if (child instanceof TableRow) ((ViewGroup) child).removeAllViews();
        }
    }

    public void updateMap(){
        clearMap();
        setMap();
    }

    public int locateMenu(){
        int propiedad = ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().getCasillaPropiedad(((GlobalPlayer)getActivity().getApplication()).getPlayer().getCasillaX(),((GlobalPlayer)getActivity().getApplication()).getPlayer().getCasillaY());
        if (propiedad == 1) {
            return 1;
        } else if (propiedad == 2) {
            return 2;
        } else if (propiedad == 3) {
            return 3;
        }
        return 0;
    }
}