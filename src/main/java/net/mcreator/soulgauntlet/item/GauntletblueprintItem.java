
package net.mcreator.soulgauntlet.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class GauntletblueprintItem extends Item {
	public GauntletblueprintItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
