package cn.davickk.rdi.essentials.general.subscribe.events;

import cn.davickk.rdi.essentials.RDIEssentials;
import cn.davickk.rdi.essentials.general.enums.EColor;
import cn.davickk.rdi.essentials.general.util.PlayerUtils;
import cn.davickk.rdi.essentials.general.util.ServerUtils;
import cn.davickk.rdi.essentials.general.util.TextUtils;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = RDIEssentials.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class EventPlayerRespawn {

    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
        PlayerUtils.teleportPlayer(player, ServerUtils.SPAWN_LOCA);
        //TextUtils.sendChatMessage(player,"您刚才可能掉落了一些物品。");
        //TextUtils.clickableContent2Send(player, EColor.GOLD.code+"[从云端下载物品]","/getfromvoid"," 。");
        TextUtils.clickableContent2Send(player,EColor.GOLD.code+"如果您卡住了，请点击[这里]执行自动修复","/spawn","。");
        TextUtils.clickableContent2Send(player,EColor.BRIGHT_GREEN.code+"[<==返回空岛==>]","/home island"," ");
        //重新设置出生点到主城
        player.setRespawnPosition(player.level.OVERWORLD, ServerUtils.SPAWN_BLKPS, 0f, true, false);
        /*if (ModConfig.spawn_force_on_death) {

            Location location = DataManager.getWorld().getSpawn();
           //TeleportUtils.doTeleport(player, location, true, false);
        }*/
    }
}
