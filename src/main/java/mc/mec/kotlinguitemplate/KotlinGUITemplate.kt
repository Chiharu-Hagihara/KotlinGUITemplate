package mc.mec.kotlinguitemplate

import mc.mec.kotlinguitemplate.command.InvCommand
import org.bukkit.plugin.java.JavaPlugin

/**
 * Created By mii
 */

class KotlinGUITemplate : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("inv")?.setExecutor(InvCommand)
        EventListener()
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}