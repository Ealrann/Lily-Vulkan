package org.sheepy.lily.vulkan.nuklear.ui;

import org.joml.Vector2ic;
import org.lwjgl.nuklear.NkColor;
import org.lwjgl.nuklear.NkImage;
import org.lwjgl.nuklear.NkRect;
import org.lwjgl.system.MemoryUtil;
import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.model.ui.Font;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.util.UIUtil;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Consumer;

import static org.lwjgl.nuklear.Nuklear.*;

@ModelExtender(scope = Panel.class)
@Adapter
public class PanelAdapter extends Notifier<ITextWidgetAdapter.Features> implements IPanelAdapter, ITextWidgetAdapter
{
	private final Consumer<Vector2ic> sizeListener = this::updateLocation;
	private final Panel panel;
	private final ByteBuffer textBuffer;

	private NkRect rect = NkRect.create();
	private IWindow window = null;
	private int style;
	private boolean dirty = true;
	private boolean hovered = false;

	public PanelAdapter(Panel panel)
	{
		super(List.of(Features.Text));
		this.panel = panel;
		final String name = panel.getName();

		assert name != null && name.isEmpty() == false;

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

		if (window != null)
		{
			window.sulk(sizeListener, IWindow.Features.Size);
		}
	}

	@Override
	public Panel getPanel()
	{
		return panel;
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
			window.listen(sizeListener, IWindow.Features.Size);
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

		rect = NkRect.malloc(stack);
		final int width = panel.getWidth();
		final int height = panel.getHeight();
		final int x = UIUtil.computeXRelative(window.getSize(), panel);
		final int y = UIUtil.computeYRelative(window.getSize(), panel);

		final var backgroundColor = context.nkContext.style().window().fixed_background().data().color();
		backgroundColor.r((byte) panel.getBackgroundColor().x());
		backgroundColor.g((byte) panel.getBackgroundColor().y());
		backgroundColor.b((byte) panel.getBackgroundColor().z());
		backgroundColor.a((byte) panel.getBackgroundColor().w());
		final var boderColor = context.nkContext.style().window().border_color();
		boderColor.r((byte) panel.getBorderColor().x());
		boderColor.g((byte) panel.getBorderColor().y());
		boderColor.b((byte) panel.getBorderColor().z());
		boderColor.a((byte) panel.getBorderColor().w());

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
				final var imageIndex = context.imageIndex(backgroundImage);
				final var nkImage = NkImage.calloc(stack);
				nk_image_ptr(imageIndex, nkImage);
				final var canvas = nk_window_get_canvas(nkContext);
				if (canvas != null)
				{
					final NkColor color = NkColor.calloc(stack);
					color.set((byte) 255, (byte) 255, (byte) 255, (byte) 255);
					final var region = NkRect.malloc(stack);
					nk_window_get_content_region(nkContext, region);
					nk_draw_image(canvas, region, nkImage, color);
				}
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
	public boolean needLayout()
	{
		if ((style & NK_WINDOW_MINIMIZED) == 0)
		{
			final var controls = panel.getControls();
			for (int i = 0; i < controls.size(); i++)
			{
				final var child = controls.get(i);
				final var adapter = child.adaptNotNull(IUIElementAdapter.class);
				if (adapter.needLayout())
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean isHovered()
	{
		return hovered;
	}

	@Override
	public String getText()
	{
		if (panel.isShowTitle())
		{
			return panel.getName();
		}
		else
		{
			return "";
		}
	}

	@Override
	public Font getFont()
	{
		return null;
	}
}
