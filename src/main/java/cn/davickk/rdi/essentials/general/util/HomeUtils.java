package cn.davickk.rdi.essentials.general.util;

import cn.davickk.rdi.essentials.general.enums.EHomeText;
import net.minecraft.entity.player.ServerPlayerEntity;

public class HomeUtils {
    public static final int MAX_HOME = 16;
    public static final int ACTIV_REQUIRE_XP=5;

    public static void tellPlayerActivHome(ServerPlayerEntity player,String homeName){
        TextUtils.clickableContent2Send(player, EHomeText.ACTIVATE.text.replace("%s",homeName),
                EHomeText.ACTIVATE.cmd.replace("%s",homeName));
    }
    public static void tellPlayerListHome(ServerPlayerEntity player){
        TextUtils.clickableContent2Send(player, EHomeText.LISTHOME.text, EHomeText.LISTHOME.cmd);
    }
//对应的服务器有对应的home表
    /*public static String getHomeDBTable(ServerPlayerEntity player){
        return MyBatisUtils.getHomeTable(player.getServer().getServerPort());
    }*/

    //这个家是否已经存在了？在玩家中

    //是否达到最大可设置家数量？
    /*public static int getRequiredXp(double distance,boolean notOverworld){
        if(notOverworld)
            return 5;
        if(distance>12000)
            return 8;
        if(distance>8000)
            return 4;
        if(distance>4000)
            return 2;
        if(distance>1000)
            return 1;
        else return 0;
    }*/





}
