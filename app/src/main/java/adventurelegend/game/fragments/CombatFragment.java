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

import adventurelegend.game.GlobalPlayer;
import adventurelegend.game.R;
import adventurelegend.game.databinding.FragmentCombatBinding;
import adventurelegend.game.objects.Potion;

public class CombatFragment extends Fragment {

    private FragmentCombatBinding binding;
    private NavController navController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentCombatBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
        binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());
        binding.enemy.setImageResource(((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().getImage());

        binding.attackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getAtaque());
                ((GlobalPlayer)getActivity().getApplication()).getPlayer().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().getDamage());

                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());

                int resultado = resultado();
                if (resultado == 1) {
                    navController.navigate(R.id.action_global_homeFragment);
                } else if (resultado == 2) {
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().addXp(((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().getXp());
                    navController.navigate(R.id.action_global_mapFragment);
                }
            }
        });
        binding.skillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.skills.setVisibility(View.VISIBLE);
                binding.back.setVisibility(View.VISIBLE);
            }
        });
        binding.skill1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((GlobalPlayer)getActivity().getApplication()).getPlayer().isPosible("Slash")){
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getSkillDamage("Slash"));
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().getDamage());
                }
                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());

                binding.skills.setVisibility(View.INVISIBLE);

                int resultado = resultado();
                if (resultado == 1) {
                    navController.navigate(R.id.action_global_homeFragment);
                } else if (resultado == 2) {
                    navController.navigate(R.id.action_global_mapFragment);
                }
            }
        });
        binding.skill2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((GlobalPlayer)getActivity().getApplication()).getPlayer().isPosible("Fireball")){
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getSkillDamage("Fireball"));
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().getDamage());
                }
                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());

                binding.skills.setVisibility(View.INVISIBLE);

                int resultado = resultado();
                if (resultado == 1) {
                    navController.navigate(R.id.action_global_homeFragment);
                } else if (resultado == 2) {
                    navController.navigate(R.id.action_global_mapFragment);
                }
            }
        });
        binding.skill3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((GlobalPlayer)getActivity().getApplication()).getPlayer().isPosible("Flamberge")){
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getSkillDamage("Flamberge"));
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().getDamage());
                }
                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());

                binding.skills.setVisibility(View.INVISIBLE);

                int resultado = resultado();
                if (resultado== 1) {
                    navController.navigate(R.id.action_global_homeFragment);
                } else if (resultado == 2) {
                    navController.navigate(R.id.action_global_mapFragment);
                }
            }
        });

        binding.skill4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((GlobalPlayer)getActivity().getApplication()).getPlayer().isPosible("Ice")){
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getSkillDamage("Flamberge"));
                    ((GlobalPlayer)getActivity().getApplication()).getPlayer().reciveDamage(((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().getDamage());
                }
                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());

                binding.skills.setVisibility(View.INVISIBLE);

                int resultado = resultado();
                if (resultado== 1) {
                    navController.navigate(R.id.action_global_homeFragment);
                } else if (resultado == 2) {
                    navController.navigate(R.id.action_global_mapFragment);
                }
            }
        });

        binding.itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.items.setVisibility(View.VISIBLE);
                binding.back.setVisibility(View.VISIBLE);
            }
        });

        binding.item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Potion potion: ((GlobalPlayer)getActivity().getApplication()).getPlayer().getInventory().getPotions()) {
                    if(potion.getNombre().equals("Pocion de vida")){
                        ((GlobalPlayer)getActivity().getApplication()).getPlayer().curar(potion);
                    }
                }
                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());
                binding.items.setVisibility(View.INVISIBLE);
            }
        });
        binding.item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Potion potion: ((GlobalPlayer)getActivity().getApplication()).getPlayer().getInventory().getPotions()) {
                    if(potion.getNombre().equals("Pocion de mana")){
                        ((GlobalPlayer)getActivity().getApplication()).getPlayer().curar(potion);
                    }
                }
                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());
                binding.items.setVisibility(View.INVISIBLE);
            }
        });
        binding.item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Potion potion: ((GlobalPlayer)getActivity().getApplication()).getPlayer().getInventory().getPotions()) {
                    if(potion.getNombre().equals("Pocion total")){
                        ((GlobalPlayer)getActivity().getApplication()).getPlayer().curar(potion);
                    }
                }
                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());
                binding.items.setVisibility(View.INVISIBLE);
            }
        });

        binding.item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Potion potion: ((GlobalPlayer)getActivity().getApplication()).getPlayer().getInventory().getPotions()) {
                    if(potion.getNombre().equals("Pocion de megavida")){
                        ((GlobalPlayer)getActivity().getApplication()).getPlayer().curar(potion);
                    }
                }
                binding.life.setText("LIFE: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getVida());
                binding.mana.setText("MANA: " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualMana() + " / " + ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMana());
                binding.items.setVisibility(View.INVISIBLE);
            }
        });

        binding.runButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_mapFragment);
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.skills.setVisibility(View.INVISIBLE);
                binding.items.setVisibility(View.INVISIBLE);
                binding.back.setVisibility(View.INVISIBLE);
            }
        });


    }

    public int resultado(){
        if (((GlobalPlayer)getActivity().getApplication()).getPlayer().getActualVida() <= 0) {
            return 1;
        } else if (((GlobalPlayer)getActivity().getApplication()).getPlayer().getEnemy().isDeath()) {
            ((GlobalPlayer)getActivity().getApplication()).getPlayer().getMap().nextTurn();
            return 2;
        }
        return 0;
    }
}