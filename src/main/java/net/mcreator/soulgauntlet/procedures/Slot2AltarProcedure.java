package net.mcreator.soulgauntlet.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class Slot2AltarProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z) {
		String Texto = "";
		if (!(new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "Slot2")).equals("")) {
			Texto = new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "Slot2");
			Texto = Texto.replace("_", " ");
			return "\u00A7f" + (Texto.substring((int) (Texto.indexOf(":", 1) + 1), (int) (Texto.indexOf(":", 1) + 2))).toUpperCase() + Texto.substring((int) (Texto.indexOf(":", 1) + 2), (Texto).length());
		}
		return "\u00A7f";
	}
}
