package cn.davickk.rdi.essentials.general.command.impl.island;

import cn.davickk.rdi.essentials.general.command.BaseCommand;
import cn.davickk.rdi.essentials.general.thread.island.CreateIslandT;
import cn.davickk.rdi.essentials.general.thread.island.DeleteIslandT;
import cn.davickk.rdi.essentials.general.thread.ui.LoadingT;
import cn.davickk.rdi.essentials.general.util.ServerUtils;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.command.CommandSource;

public class DeleteIslandCmd extends BaseCommand {
    public DeleteIslandCmd(String name, int permissionLevel, boolean enabled) {
        super(name, permissionLevel, enabled);
    }
    @Override
    public LiteralArgumentBuilder<CommandSource> setExecution() {
        return builder.executes((context) -> execute(context.getSource()));
    }

    private int execute(CommandSource source) throws CommandSyntaxException {
        //----RDI Aerotech�¼����յ�ϵͳ �汾v1.0---
        //[������] [�ص�]
        ServerUtils.startThread(new DeleteIslandT(source.asPlayer()));
        return Command.SINGLE_SUCCESS;
    }
}