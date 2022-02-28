package adventurelegend.game.objetcs;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.List;

@Database(entities = {Player.class, Inventory.class, Weapon.class, Armor.class, Potion.class, Special.class, Map.class, Casilla.class}, version = 1, exportSchema = false)
public abstract class AdventureRoomDatabase extends RoomDatabase {

    public abstract ElementosDao obtenerElementosDao();

    private static volatile AdventureRoomDatabase INSTANCIA;

    static AdventureRoomDatabase obtenerInstancia(final Context context) {
        if (INSTANCIA == null) {
            synchronized (AdventureRoomDatabase.class) {
                if (INSTANCIA == null) {
                    INSTANCIA = Room.databaseBuilder(context,
                            AdventureRoomDatabase.class, "adventurelegend.db")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);

                                }
                            })
                            .build();
                }
            }
        }
        return INSTANCIA;
    }

    @Dao
    interface ElementosDao {
        @Query("SELECT * FROM Player")
        LiveData<List<Player>> obtener();

        @Insert
        void insertar(Player player);

        @Update
        void actualizar(Player player);

        @Delete
        void eliminar(Player player);

        @Query("SELECT * FROM Player WHERE nombre LIKE '%' || :d || '%'")
        LiveData<List<Player>> buscar(String d);
    }

}
