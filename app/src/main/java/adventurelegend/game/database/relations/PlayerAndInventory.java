package adventurelegend.game.database.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import adventurelegend.game.objetcs.Inventory;
import adventurelegend.game.objetcs.Player;

public class PlayerAndInventory {
    @Embedded
    Inventory inventory;

    @Relation(
            parentColumn = "id",
            entityColumn = "inventory"
    )
    Player player;
}
