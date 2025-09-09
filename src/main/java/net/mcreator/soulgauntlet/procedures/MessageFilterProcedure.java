package net.mcreator.soulgauntlet.procedures;

import net.minecraft.network.chat.Component;

public class MessageFilterProcedure {
	public static String execute(String Target_) {
		if (Target_ == null)
			return "";
		String Texto = "";
		Texto = Component.translatable("Savior_History").getString();
		Texto = Texto.substring(Texto.indexOf(Target_, 0));
		return (Texto.replace(Texto.substring(Texto.indexOf("<Part=End>", 0)), "")).replace(Target_, "");
	}
}
