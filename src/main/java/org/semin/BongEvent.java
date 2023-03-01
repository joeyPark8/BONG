package org.semin;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import static org.semin.Bong.*;

public class BongEvent implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            Material handitem = player.getInventory().getItemInMainHand().getType();
            if (handitem == Material.BLAZE_ROD) {
                Location loc = player.getLocation();

                ArmorStand stand = player.getWorld()
                        .spawn(loc, ArmorStand.class);

                ItemStack helmet = stack;

                stand.setCanMove(true);
                stand.setGravity(true);
                stand.setHelmet(helmet);
                stand.setVisible(false);
                stand.setCollidable(true);

                Vector direction = stand.getLocation().getDirection();
                Vector unitVector = new Vector(
                        direction.getX(),
                        direction.getY(),
                        direction.getZ()
                );
                unitVector = unitVector.normalize();
                stand.setVelocity(unitVector.multiply(velocity));
            }
        }
    }

}
