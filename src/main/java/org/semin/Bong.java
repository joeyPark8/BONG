package org.semin;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.FallingBlock;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Bong {
    public static Block latestBlock = null;

    public static HashMap<String, ArmorStand> fblocks;

    public static ItemStack stack = null;

    public static double velocity = 0.00;
}
