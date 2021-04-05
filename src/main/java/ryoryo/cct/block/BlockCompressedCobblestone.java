package ryoryo.cct.block;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ryoryo.cct.util.EnumCompressed;
import ryoryo.polishedlib.block.BlockBaseMeta;
import ryoryo.polishedlib.item.ItemBlockMeta;
import ryoryo.polishedlib.util.RegistryUtils;
import ryoryo.polishedlib.util.handlers.ModelHandler;

public class BlockCompressedCobblestone extends BlockBaseMeta {

	public static final PropertyInteger COMPRESSED = PropertyInteger.create("compressed", EnumCompressed.X1.getTier(), EnumCompressed.X8.getTier());

	public BlockCompressedCobblestone() {
		super("compressed_cobblestone", Material.ROCK, CreativeTabs.BUILDING_BLOCKS, SoundType.STONE);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setDefaultState(this.blockState.getBaseState().withProperty(COMPRESSED, EnumCompressed.X1.getTier()));
	}

	@Override
	public boolean canEntityDestroy(IBlockState state, IBlockAccess world, BlockPos pos, Entity entity) {
		return state.getValue(COMPRESSED) <= 6;
	}

	@Override
	public float getExplosionResistance(World world, BlockPos pos, Entity exploder, Explosion explosion) {
		int comp = world.getBlockState(pos).getValue(COMPRESSED);
		float base = 5.0F;
		return base * (float) Math.pow(1.5F, comp - 1);
	}

	@Override
	public float getBlockHardness(IBlockState state, World world, BlockPos pos) {
		int comp = state.getValue(COMPRESSED);
		float base = 2.0F;
		return base * (float) Math.pow(2.25F, comp - 1);
	}

	@Override
	public void addInformation(ItemStack stack, World player, List<String> tooltip, ITooltipFlag advanced) {
		int comp = stack.getMetadata();
		tooltip.add(EnumCompressed.byMeta(comp).getCompressed() + " Blocks");
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(this, 1, getMetaFromState(state));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(COMPRESSED, meta + 1);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(COMPRESSED) - 1;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { COMPRESSED });
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list) {
		RegistryUtils.registerSubBlocks(this, EnumCompressed.getLength(), tab, list);
	}

	@Override
	public ItemBlock createItemBlock() {
		return new ItemBlockMeta(this, EnumCompressed.NAMES);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		ModelHandler.registerBlockModel(this, createItemBlock(), EnumCompressed.NAMES);
	}
}