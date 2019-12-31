package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;

import org.joml.Vector2ic;
import org.lwjgl.nuklear.NkColor;
import org.lwjgl.nuklear.NkImage;
import org.lwjgl.nuklear.NkRect;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.vulkan.api.resource.IImageAdapter;
import org.sheepy.lily.vulkan.api.util.UIUtil;
import org.sheepy.vulkan.window.IWindowListener.ISizeListener;
import org.sheepy.vulkan.window.Window;

@Statefull
@Adapter(scope = Panel.class)
public class PanelAdapter implements IPanelAdapter
{
	private final ISizeListener listener = this::updateLocation;
	private final Panel panel;
	private final ByteBuffer textBuffer;

	private NkRect rect = NkRect.create();
	private Window window = null;
	private int style;
	private boolean dirty = true;
	private boolean hovered = false;

	public PanelAdapter(Panel panel)
	{
		this.panel = panel;
		String name = panel.getName();

		if (name == null)
		{
			name = "";
		}

		style = NK_WINDOW_BORDER | NK_WINDOW_NO_SCROLLBAR | NK_WINDOW_BACKGROUND;
		if (panel.isMinimizable())
		{
			style |= NK_WINDOW_MINIMIZABLE;
		}
		if (panel.isMovable())
		{
			style |= NK_WINDOW_MOVABLE;
		}
		if (panel.isShowTitle())
		{
			style |= NK_WINDOW_TITLE;
		}
		if (panel.isMinimized())
		{
			style |= NK_WINDOW_MINIMIZED;
		}

		textBuffer = MemoryUtil.memUTF8(name);
	}

	@Dispose
	public void unsetTarget()
	{
		MemoryUtil.memFree(textBuffer);
		window.removeListener(listener);
	}

	private void updateLocation(Vector2ic size)
	{
		final int width = panel.getWidth();
		final int height = panel.getHeight();
		final int x = UIUtil.computeXRelative(size, panel);
		final int y = UIUtil.computeYRelative(size, panel);

		rect.set(x, y, width, height);
	}

	protected void updateWindow(UIContext context)
	{
		if (window == null)
		{
			window = context.window;
			updateLocation(window.getSize());
			window.addListener(listener);
		}
	}

	@Override
	public boolean layout(UIContext context)
	{
		boolean res = dirty;
		dirty = false;
		final var stack = context.stack;
		final var nkContext = context.nkContext;
		updateWindow(context);

		rect = NkRect.mallocStack(stack);
		final int width = panel.getWidth();
		final int height = panel.getHeight();
		final int x = UIUtil.computeXRelative(window.getSize(), panel);
		final int y = UIUtil.computeYRelative(window.getSize(), panel);

		if (nk_begin(nkContext, panel.getName(), nk_rect(x, y, width, height, rect), style))
		{
			hovered = nk_window_is_hovered(nkContext);

			if (nk_window_is_collapsed(nkContext, textBuffer) && (style & NK_WINDOW_MINIMIZED) != 0)
			{
				style ^= NK_WINDOW_MINIMIZED;
				dirty = true;
				res = true;
			}

			final var backgroundImage = panel.getBackgroundImage();
			if (backgroundImage != null)
			{
				final var imageAdapter = backgroundImage.adapt(IImageAdapter.class);
				final var nkImage = NkImage.callocStack(stack);
				nk_image_ptr(imageAdapter.getViewPtr(), nkImage);
				final var canvas = nk_window_get_canvas(nkContext);
				final NkColor color = NkColor.callocStack(stack);
				color.set((byte) 255, (byte) 255, (byte) 255, (byte) 255);
				final var region = NkRect.mallocStack(stack);
				nk_window_get_content_region(nkContext, region);
				nk_draw_image(canvas, region, nkImage, color);
			}

			final var controls = panel.getControls();
			for (int i = 0; i < controls.size(); i++)
			{
				final IControl child = controls.get(i);
				final var adapter = child.adaptNotNull(IUIElementAdapter.class);
				res |= adapter.layout(context, child);
			}
		}
		else if ((style & NK_WINDOW_MINIMIZED) == 0)
		{
			hovered = false;
			style |= NK_WINDOW_MINIMIZED;
			res = true;
			dirty = true;
		}

		nk_end(nkContext);

		return res;
	}

	@Override
	public boolean isHovered()
	{
		return hovered;
	}
}
