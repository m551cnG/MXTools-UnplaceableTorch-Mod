package com.example.mxt_unplaceable_torch.blocks;
import net.minecraft.world.level.block.Blocks; // 关键导入


import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;

public class UnplaceableTorchBlock extends TorchBlock {
    public UnplaceableTorchBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.TORCH) // 现在可以正确识别
                        .noCollission()
                        .instabreak()
                        .lightLevel(state -> 14),
                ParticleTypes.FLAME);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return false;
    }
}
