package mc.mec.kotlinguitemplate.command

import mc.mec.kotlinguitemplate.Util
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack


object InvCommand : CommandExecutor{
    val util = Util()
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player = (sender as? Player)
        if (args.isEmpty()) {
            sender.sendMessage("Usage: /inv open")
            return false
        }
        return when(args[0]) {
            "open" -> {
                if ((sender as? Player) != null) {
                    player?.sendMessage("インベントリーを開きます。")
                    val guiList : Map<Int, ItemStack?> = mapOf(1 to util.createItem(ItemStack(Material.DIAMOND),"テストボタン", listOf("ボタンのテスト"), 0),
                            4 to util.createItem(ItemStack(Material.STONE),"ボタン2", listOf("ボタン2"), 2147483647))
                    val inventory = util.createInventoryGUI("INV1",9,guiList)

                    player?.openInventory(inventory)
                }
                true
            }

            else -> {
                sender.sendMessage("ELSE")
                true
            }
        }
    }
}