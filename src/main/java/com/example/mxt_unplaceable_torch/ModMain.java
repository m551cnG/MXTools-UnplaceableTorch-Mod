package com.example.mxt_unplaceable_torch;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ModMain.MODID)
public class ModMain {
    public static final String MODID = "mxt_unplaceable_torch";

    public ModMain() {
        // 注册系统接入
        RegistryHandler.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        RegistryHandler.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());

        // 注册创造标签事件（Forge 1.20.1 新事件）
        MinecraftForge.EVENT_BUS.addListener(this::onServerStart);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(RegistryHandler::addToCreativeTab);
    }

    private void onServerStart(ServerStartingEvent event) {
        // 初始化逻辑（可选）
    }
}
