package adventurelegend.game.objetcs;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PlayerRepositorio {

    AdventureRoomDatabase.ElementosDao playersDao;
    Executor executor = Executors.newSingleThreadExecutor();

    PlayerRepositorio(Application application){
        playersDao = AdventureRoomDatabase.obtenerInstancia(application).obtenerElementosDao();
    }


    LiveData<List<Player>> obtener(){
        return playersDao.obtener();
    }


    void insertar(Player player){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                playersDao.insertar(player);
            }
        });
    }

    void actualizar(Player player){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                playersDao.actualizar(player);
            }
        });
    }

    void eliminar(Player player) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                playersDao.eliminar(player);
            }
        });
    }
}
