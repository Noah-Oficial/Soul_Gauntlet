
package net.mcreator.soulgauntlet.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class SoulgemItem extends Item {
	public SoulgemItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
	}
}
