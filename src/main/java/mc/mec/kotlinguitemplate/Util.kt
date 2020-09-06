package mc.mec.kotlinguitemplate

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class Util {
    fun createInventoryGUI(name: String,size: Int,itemList: Map<Int, ItemStack?>) : Inventory {
        val inventory = Bukkit.createInventory(null,size,name)
        itemList.forEach { (index,element) ->
            inventory.setItem(index, element)
        }
        return inventory
    }

    fun createItem(item: ItemStack, name: String?, lore: List<String?>, cmd: Int): ItemStack? {
        val itemMeta = item.itemMeta
        itemMeta!!.setDisplayName(name)
        itemMeta.setCustomModelData(cmd)
        itemMeta.lore = lore
        item.itemMeta = itemMeta
        return item
    }
}