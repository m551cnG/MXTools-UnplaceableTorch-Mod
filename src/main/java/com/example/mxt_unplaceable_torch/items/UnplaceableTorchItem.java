package com.example.mxt_unplaceable_torch.items;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.block.Block; // 关键导入

public class UnplaceableTorchItem extends BlockItem {
    // 构造器参数修正
    public UnplaceableTorchItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        return InteractionResult.FAIL;
    }
}
