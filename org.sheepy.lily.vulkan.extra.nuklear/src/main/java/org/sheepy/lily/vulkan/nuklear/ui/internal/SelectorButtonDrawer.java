package org.sheepy.lily.vulkan.nuklear.ui.internal;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;

import org.lwjgl.nuklear.NkColor;
import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkImage;
import org.lwjgl.nuklear.NkRect;
import org.lwjgl.nuklear.NkVec2;
import org.sheepy.lily.vulkan.extra.model.nuklear.SelectorPanel;

public final class SelectorButtonDrawer
{
	private static final int STYLE = NK_WINDOW_NO_SCROLLBAR | NK_WINDOW_BORDER;

	private final int buttonSize;
	private final NkColor defaultBorderColor;
	private final NkColor selectedBorderColor;

	private float defaultPaddingX;
	private float defaultPaddingY;

	private NkColor borderColor;
	private NkVec2 padding;
	private boolean isHovered = false;

	public SelectorButtonDrawer(SelectorPanel panel)
	{
		this.buttonSize = panel.getButtonSizePx();

		defaultBorderColor = NkColor.create();
		selectedBorderColor = NkColor.create();

		final var r = (byte) panel.getSelectionR();
		final var g = (byte) panel.getSelectionG();
		final var b = (byte) panel.getSelectionB();

		selectedBorderColor.set(r, g, b, (byte) 255);
	}

	public void prepare(NkContext nkContext)
	{
		borderColor = nkContext.style().window().border_color();
		defaultBorderColor.set(borderColor);

		padding = nkContext.style().window().padding();

		defaultPaddingX = padding.x();
		defaultPaddingY = padding.y();
	}

	public boolean draw(NkContext nkContext,
						boolean selected,
						NkImage image,
						NkColor color,
						ByteBuffer id,
						NkRect rect)
	{
		boolean res = false;
		padding.x(0);
		padding.y(0);

		if (selected)
		{
			borderColor.set(selectedBorderColor);
		}
		else
		{
			borderColor.a((byte) 0);
		}

		if (nk_begin(nkContext, id, rect, STYLE))
		{
			isHovered = nk_window_is_hovered(nkContext);

			nk_layout_row_dynamic(nkContext, buttonSize, 1);
			if (image != null)
			{
				res |= nk_button_image(nkContext, image);
			}
			else
			{
				res |= nk_button_color(nkContext, color);
			}
		}
		nk_end(nkContext);

		if (selected)
		{
			borderColor.set(defaultBorderColor);
			borderColor.a((byte) 0);
		}

		padding.x(defaultPaddingX);
		padding.y(defaultPaddingY);

		return res;
	}

	public void finish()
	{
		borderColor.a(defaultBorderColor.a());
	}

	public boolean isHovered()
	{
		return isHovered;
	}
}
