package me.christo.orbithcf.Commands;

import me.christo.orbithcf.Main;
import me.christo.orbithcf.Utils.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

/**
 * Copy Right ©
 * This code is private
 * Owner: Christo
 * From: 10/22/19-2023
 * Any attempts to use these program(s) may result in a penalty of up to $1,000 USD
 **/

public class SwitcherGiveCommand implements CommandExecutor {


    private Main plugin;

    public SwitcherGiveCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("switcher").setExecutor(this);
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;


        Player target = Bukkit.getPlayer(args[1]);

        if (args.length == 0) {
            p.sendMessage(Util.chat("&cInvalid Usage. /switcher give {player} {amount}"));
            return true;
        }
        if (args.length == 1) {
            p.sendMessage(Util.chat("&cInvalid Usage. /switcher give {player} {amount}"));
            return true;
        }
        if (args.length == 2) {
            p.sendMessage(Util.chat("&cInvalid Usage. /switcher give {player} {amount}"));
            return true;
        }

        if (args.length == 3) {
            if (p.hasPermission("switcher.give")) {
                if(target == null) {
                    p.sendMessage(Util.chat("&cPlayer not found."));
                    return true;
                }

                int amount = Integer.parseInt(args[2]);

                ItemStack switcherItem = new ItemStack(Material.SNOW_BALL);
                ItemMeta meta = switcherItem.getItemMeta();
                meta.setDisplayName(Util.chat(Main.getInstance().getConfig().getString("Switcher.SwitcherName")));
                ArrayList<String> lore = new ArrayList<String>();
                lore.add(Util.chat(Main.getInstance().getConfig().getString("Switcher.SwitcherLore")));
                meta.setLore(lore);
                switcherItem.setAmount(amount);
                switcherItem.setItemMeta(meta);

                target.getInventory().addItem(switcherItem);

                return false;
            }
        }
        return false;
    }

}
    //lol

