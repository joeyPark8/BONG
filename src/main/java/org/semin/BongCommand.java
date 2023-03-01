package org.semin;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.DoubleArgument;
import dev.jorel.commandapi.arguments.ItemStackArgument;
import dev.jorel.commandapi.arguments.StringArgument;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static org.semin.Bong.stack;
import static org.semin.Bong.velocity;

public class BongCommand {
    public static void register() {
        new CommandAPICommand("bng")
                .withSubcommand(
                        new CommandAPICommand("spawn")
                                .withArguments(new StringArgument("name"))
                                .withArguments(new ItemStackArgument("stack"))
                                .executes((sender, args) -> {
                                    if (sender instanceof Player player) {

                                        Location loc = player.getLocation();

                                        String name = (String) args[0];

                                        ArmorStand stand = player.getWorld()
                                                .spawn(loc, ArmorStand.class);

                                        ItemStack helmet = (ItemStack) args[1];

                                        //stand.setBasePlate(false);
                                        stand.setGravity(false);
                                        stand.setHelmet(helmet);
                                        stand.setVisible(false);
                                        stand.setCollidable(true);

                                        //fblocks.put(name, stand);
                                    }

                                })
                )
                .withSubcommand(
                        new CommandAPICommand("set")
                                .withSubcommand(
                                        new CommandAPICommand("type")
                                                .withArguments(new ItemStackArgument("stack"))
                                                .executes((sender, args) -> {
                                                    stack = (ItemStack) args[0];

                                                })
                                )
                                .withSubcommand(
                                        new CommandAPICommand("velocity")
                                                .withArguments(new DoubleArgument("speed"))
                                                .executes((sender, args) -> {
                                                    velocity = (double) args[0];
                                                })
                                )
                ).register();
    }
}
