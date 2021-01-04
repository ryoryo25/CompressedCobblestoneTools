package ryoryo.cct.crafting;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;
import ryoryo.cct.util.References;

public class RecipeCompressTools extends IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

	private Item output;
	private Item input;

	public RecipeCompressTools(Item output, Item input) {
		this.output = output;
		this.input = input;
	}

	/**
	 * Recipe
	 * [i i i]
	 * [i i i] -> [o]
	 * [i i i]
	 *
	 * search all stacks in slots, check that all ingredients equal to the input
	 */
	@Override
	public boolean matches(InventoryCrafting inv, World worldIn) {
		List<ItemStack> list = Lists.newArrayList();

		for(int i = 0; i < inv.getSizeInventory(); i ++) {
			ItemStack stack = inv.getStackInSlot(i);

			if(!stack.isEmpty()) {
				list.add(stack);

				if(stack.getItem() != this.input || stack.getCount() != 1) {
					return false;
				}
			}
		}

		return list.size() == 9;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		List<ItemStack> list = Lists.newArrayList();

		for(int i = 0; i < inv.getSizeInventory(); i ++) {
			ItemStack stack = inv.getStackInSlot(i);

			if(!stack.isEmpty()) {
				list.add(stack);

				if(stack.getItem() != this.input || stack.getCount() != 1) {
					return ItemStack.EMPTY;
				}
			}
		}

		if(list.size() == 9) {
			// add all damages
			int newDamage = 0;
			for(ItemStack ingredient : list) {
				newDamage += ingredient.getItemDamage();
			}

			return new ItemStack(this.output, 1, newDamage);
		}

		return ItemStack.EMPTY;
	}

	@Override
	public boolean isDynamic() {
		return true;
	}

	@Override
	public boolean canFit(int width, int height) {
		return width * height == 9;
	}

	@Override
	public ItemStack getRecipeOutput() {
		return ItemStack.EMPTY;
	}

	// recipe register
	public static void addRecipe(String name, Item output, Item input) {
		RecipeCompressTools recipe = new RecipeCompressTools(output, input);
		recipe.setRegistryName(References.MOD_ID, name);
		ForgeRegistries.RECIPES.register(recipe);
	}
}