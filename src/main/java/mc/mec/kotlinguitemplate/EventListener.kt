package mc.mec.kotlinguitemplate

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import java.util.logging.Logger

class EventListener(var plg : KotlinGUITemplate, val log : Logger = plg.getLogger()) : Listener {
    init {
        plg.server.pluginManager.registerEvents(this,plg)
        log.info("イベントを登録しました。")
    }

    @EventHandler
    fun playerInteractEvent(e: InventoryClickEvent) {
        val player: Player? = e.whoClicked as? Player
        when (e.whoClicked.openInventory.title) {
            "INV1" -> {
                e.isCancelled = true

                if (e.clickedInventory?.type == InventoryType.CHEST) {
                    when (e.currentItem?.itemMeta?.displayName) {
                        "テストボタン" -> {
                            player?.sendMessage("テストボタンをクリックしました。")
                        }

                        "ボタン2" -> {
                            player?.sendMessage("ボタン2をクリックしました。")
                        }
                    }
                }
            }
        }
    }
}
