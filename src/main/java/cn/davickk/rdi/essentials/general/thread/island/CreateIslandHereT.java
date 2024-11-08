package cn.davickk.rdi.essentials.general.thread.island;

import cn.davickk.rdi.essentials.general.enums.EColor;
import cn.davickk.rdi.essentials.general.model.Location;
import cn.davickk.rdi.essentials.general.request.HomeRequest;
import cn.davickk.rdi.essentials.general.util.TextUtils;
import cn.davickk.rdi.essentials.general.util.WorldUtils;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;

public class CreateIslandHereT extends Thread{
    private final ServerPlayerEntity player;
    public CreateIslandHereT(ServerPlayerEntity player){
        this.player=player;
    }
    public void run(){
        if(WorldUtils.ifNearbySpawn(new Location(player))){
            TextUtils.sendChatMessage(player,"不可以在主城创建空岛");
            return;
        }
        TextUtils.sendChatMessage(player,"正在创建空岛...请不要移动...");
        try{
            HomeRequest hreq=new HomeRequest(player);
            BlockPos bpos=player.blockPosition();
            if (hreq.getHomeCounts()>0) {
                TextUtils.sendChatMessage(player, "您已经有一个空岛了，因此不能创建新的空岛。");
                return;
            }
            hreq.setHomeWithLocation(new Location(player),"island",true,"空岛传送点，请勿删除");
            WorldUtils.pasteIslandSchematic(bpos,player);
            TextUtils.sendChatMessage(player, "成功创建了空岛");
            TextUtils.clickableContent2Send(player,EColor.GOLD.code+"可以正常游玩了。请阅读群文件的手册。",""," ");
                //TODO 回到我的空岛




        }catch (Exception e){e.printStackTrace();}
    }
}
