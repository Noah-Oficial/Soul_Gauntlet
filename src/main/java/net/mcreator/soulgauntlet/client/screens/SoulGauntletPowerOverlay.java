
package net.mcreator.soulgauntlet.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.soulgauntlet.procedures.PassiveProcedure;
import net.mcreator.soulgauntlet.procedures.OpenGuiProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SoulGauntletPowerOverlay {
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (PassiveProcedure.execute(world, entity)) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					OpenGuiProcedure.execute(world, x, y, z, entity), w - 85, h - 17, -1, false);
		}
	}
}
