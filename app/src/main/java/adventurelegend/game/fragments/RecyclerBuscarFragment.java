package adventurelegend.game.fragments;

import androidx.lifecycle.LiveData;

import java.util.List;

public class RecyclerBuscarFragment extends com.company.room.RecyclerElementosFragment {
    @Override
    LiveData<List<Elemento>> obtenerElementos() {
        return elementosViewModel.buscar();
    }
}
