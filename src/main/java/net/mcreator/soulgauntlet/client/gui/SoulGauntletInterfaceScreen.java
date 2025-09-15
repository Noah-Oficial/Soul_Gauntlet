package net.mcreator.soulgauntlet.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.soulgauntlet.world.inventory.SoulGauntletInterfaceMenu;
import net.mcreator.soulgauntlet.procedures.Slot3Procedure;
import net.mcreator.soulgauntlet.procedures.Slot2Procedure;
import net.mcreator.soulgauntlet.procedures.Slot1Procedure;
import net.mcreator.soulgauntlet.network.SoulGauntletInterfaceButtonMessage;
import net.mcreator.soulgauntlet.SoulGauntletMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SoulGauntletInterfaceScreen extends AbstractContainerScreen<SoulGauntletInterfaceMenu> {
	private final static HashMap<String, Object> guistate = SoulGauntletInterfaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_slot1;
	Button button_slot2;
	Button button_slot3;

	public SoulGauntletInterfaceScreen(SoulGauntletInterfaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("soul_gauntlet:textures/screens/slotgui.png"), this.leftPos + -65, this.topPos + -71, 0, 0, 128, 128, 128, 128);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				Slot1Procedure.execute(entity), -48, -52, -1, false);
		guiGraphics.drawString(this.font,

				Slot2Procedure.execute(entity), -48, -12, -1, false);
		guiGraphics.drawString(this.font,

				Slot3Procedure.execute(entity), -48, 28, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_slot1 = new PlainTextButton(this.leftPos + -56, this.topPos + -55, 51, 20, Component.translatable("gui.soul_gauntlet.soul_gauntlet_interface.button_slot1"), e -> {
			if (true) {
				SoulGauntletMod.PACKET_HANDLER.sendToServer(new SoulGauntletInterfaceButtonMessage(0, x, y, z));
				SoulGauntletInterfaceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_slot1", button_slot1);
		this.addRenderableWidget(button_slot1);
		button_slot2 = new PlainTextButton(this.leftPos + -50, this.topPos + -15, 51, 20, Component.translatable("gui.soul_gauntlet.soul_gauntlet_interface.button_slot2"), e -> {
			if (true) {
				SoulGauntletMod.PACKET_HANDLER.sendToServer(new SoulGauntletInterfaceButtonMessage(1, x, y, z));
				SoulGauntletInterfaceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_slot2", button_slot2);
		this.addRenderableWidget(button_slot2);
		button_slot3 = new PlainTextButton(this.leftPos + -54, this.topPos + 25, 51, 20, Component.translatable("gui.soul_gauntlet.soul_gauntlet_interface.button_slot3"), e -> {
			if (true) {
				SoulGauntletMod.PACKET_HANDLER.sendToServer(new SoulGauntletInterfaceButtonMessage(2, x, y, z));
				SoulGauntletInterfaceButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}, this.font);
		guistate.put("button:button_slot3", button_slot3);
		this.addRenderableWidget(button_slot3);
	}
}
