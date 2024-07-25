package com.itsundefined.blissgems.internal.gems;


import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Strength {

    public static void StrengthTick() {
        for (Player BloodThornsPlayer : Bukkit.getOnlinePlayers()) {
            ItemStack StrengthGemItem = BloodThornsPlayer.getInventory().getItemInOffHand();
            if (true) {
                double health = BloodThornsPlayer.getHealth();
                AttributeInstance BloodThornsAttribute = BloodThornsPlayer.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
                if (BloodThornsAttribute != null) {
                    if (health >= 0.5 && health < 1) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 1 && health < 1.5) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 1.5 && health < 2) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 2 && health < 2.5) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 2.5 && health < 3) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 3 && health < 3.5) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 3.5 && health < 4) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 4 && health < 4.5) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 4.5 && health < 5) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 5.5 && health < 6) {
                        BloodThornsAttribute.setBaseValue(8.0);
                    } else if (health >= 6 && health < 6.5) {
                        BloodThornsAttribute.setBaseValue(5.5);
                    } else if (health >= 6.5 && health < 8) {
                        BloodThornsAttribute.setBaseValue(5.0);
                    } else if (health >= 8 && health < 8.5) {
                        BloodThornsAttribute.setBaseValue(4.5);
                    } else if (health >= 8.5 && health < 10) {
                        BloodThornsAttribute.setBaseValue(3.5);
                    } else if (health >= 10 && health < 10.5) {
                        BloodThornsAttribute.setBaseValue(3.0);
                    } else if (health >= 10.5 && health < 12) {
                        BloodThornsAttribute.setBaseValue(2.5);
                    } else if (health >= 12 && health < 12.5) {
                        BloodThornsAttribute.setBaseValue(2.0);
                    } else if (health >= 12.5 && health < 13) {
                        BloodThornsAttribute.setBaseValue(1.5);
                    } else {
                        BloodThornsAttribute.setBaseValue(1.0);
                    }
                }
            }
        }
    }
}
