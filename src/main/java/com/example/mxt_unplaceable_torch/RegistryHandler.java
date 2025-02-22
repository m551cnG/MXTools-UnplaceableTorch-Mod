package com.example.mxt_unplaceable_torch;

import com.example.mxt_unplaceable_torch.blocks.UnplaceableTorchBlock;
import com.example.mxt_unplaceable_torch.items.UnplaceableTorchItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class RegistryHandler {
    // 注册器初始化（使用常量MODID）
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ModMain.MODID);
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModMain.MODID);

    // 方块注册
    public static final RegistryObject<Block> UNPLACEABLE_TORCH =
            BLOCKS.register("unplaceable_torch", UnplaceableTorchBlock::new);

    // 物品注册（移除分类设置）
    public static final RegistryObject<Item> UNPLACEABLE_TORCH_ITEM =
            ITEMS.register("unplaceable_torch",
                    () -> new UnplaceableTorchItem(
                            UNPLACEABLE_TORCH.get(),
                            new Item.Properties() // 不再使用 .tab()
                    )
            );

    // 创造标签注册方法（Forge 1.20.1+）
    public static void addToCreativeTab(BuildCreativeModeTabContentsEvent event) {
        // 精确匹配工具分类
        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(UNPLACEABLE_TORCH_ITEM);
        }
    }
}
