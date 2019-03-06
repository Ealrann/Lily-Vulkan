package org.sheepy.lily.vulkan.nuklear.adapter;

import static org.lwjgl.nuklear.Nuklear.*;

import java.nio.ByteBuffer;

import org.lwjgl.nuklear.NkRect;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.core.model.ui.IControl;
import org.sheepy.lily.core.model.ui.Panel;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.common.ui.UIUtil;

@Statefull
@Adapter(scope = Panel.class)
public class PanelAdapter implements IUIElementAdapter
{
	private final IWindowListener listener = new IWindowListener()
	{
		@Override
		public void onWindowResize(VkSurface surface)
		{
			updateLocation(surface);
		}
	};

	private final Panel panel;
	private final ByteBuffer textBuffer;

	private NkRect rect = NkRect.create();

	private Window window = null;
	private int style;

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

	private void updateLocation(VkSurface surface)
	{
		int width = panel.getWidth();
		int height = panel.getHeight();
		int x = UIUtil.computeXRelative(surface, panel);
		int y = UIUtil.computeYRelative(surface, panel);

		rect.set(x, y, width, height);
	}

	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		boolean res = false;
		var nkContext = context.nkContext;

		if (window == null)
		{
			window = context.window;
			updateLocation(window.getSurface());
			window.addListener(listener);
		}

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			rect = NkRect.mallocStack(stack);
			int width = panel.getWidth();
			int height = panel.getHeight();
			int x = UIUtil.computeXRelative(window.getSurface(), panel);
			int y = UIUtil.computeYRelative(window.getSurface(), panel);

			if (nk_begin(nkContext, panel.getName(), nk_rect(x, y, width, height, rect), style))
			{
				if (nk_window_is_collapsed(nkContext, textBuffer)
						&& (style & NK_WINDOW_MINIMIZED) != 0)
				{
					style ^= NK_WINDOW_MINIMIZED;
				}

				for (IControl child : panel.getControls())
				{
					var adapter = IUIElementAdapter.adapt(child);
					res |= adapter.layout(context, child);
				}
			}
			nk_end(nkContext);
		}

		return res;
	}
}
