package org.sheepy.lily.vulkan.nuklear.logic;

import org.lwjgl.nuklear.NkDrawCommand;

public class DrawCommandData
{
	private static final float fb_scale_x = 1f;
	private static final float fb_scale_y = 1f;

	public final int xOffset;
	public final int yOffset;
	public final int xExtent;
	public final int yExtent;

	public final int descriptorIndex;
	public final int elemCount;

	public DrawCommandData(NkDrawCommand cmd, int descriptorIndex)
	{
		final int elemCount = cmd.elem_count();

		xOffset = (int) (cmd.clip_rect().x() * fb_scale_x);
		yOffset = (int) (cmd.clip_rect().y() * fb_scale_y);
		xExtent = (int) (cmd.clip_rect().w() * fb_scale_x);
		yExtent = (int) (cmd.clip_rect().h() * fb_scale_y);

		this.descriptorIndex = descriptorIndex;
		this.elemCount = elemCount;
		// System.out.println(String.format("Draw %d elements in {%d, %d, %d, %d}, tex %d",
		// elemCount,
		// xOffset, yOffset, xExtent, yExtent, textureId));
	}
}
