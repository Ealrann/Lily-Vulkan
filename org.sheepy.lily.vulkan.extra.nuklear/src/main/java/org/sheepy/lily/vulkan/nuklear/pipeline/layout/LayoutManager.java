package org.sheepy.lily.vulkan.nuklear.pipeline.layout;

import org.sheepy.lily.core.api.adapter.util.AdapterSetRegistry;
import org.sheepy.lily.vulkan.core.window.Extent2D;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter;

public class LayoutManager
{
	private final AdapterSetRegistry<IPanelAdapter> panelRegistry;

	private boolean dirty = true;
	private boolean startedFrame = true;
	private Extent2D currentExtent;

	public LayoutManager(AdapterSetRegistry<IPanelAdapter> panelRegistry)
	{
		this.panelRegistry = panelRegistry;
	}

	public boolean needLayout()
	{
		final var panelAdapters = panelRegistry.getAdapters();
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			if (panelAdapter.needLayout())
			{
				return true;
			}
		}
		return false;
	}

	public void layout(IPanelAdapter.UIContext uiContext, Extent2D extent)
	{
		startedFrame = true;

		if (extent != currentExtent)
		{
			dirty = true;
			currentExtent = extent;
		}

		final var panelAdapters = panelRegistry.getAdapters();
		for (int i = 0; i < panelAdapters.size(); i++)
		{
			final var panelAdapter = panelAdapters.get(i);
			dirty |= panelAdapter.layout(uiContext);
		}
	}

	public boolean isDirty()
	{
		return dirty;
	}

	public void setDirty(boolean dirty)
	{
		this.dirty = dirty;
	}

	public boolean hasStartedFrame()
	{
		return startedFrame;
	}

	public void setStartedFrame(boolean startedFrame)
	{
		this.startedFrame = startedFrame;
	}

	public Extent2D getCurrentExtent()
	{
		return currentExtent;
	}
}
