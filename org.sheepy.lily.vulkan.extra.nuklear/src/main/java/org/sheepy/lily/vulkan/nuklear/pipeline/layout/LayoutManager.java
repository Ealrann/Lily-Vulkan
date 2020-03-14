package org.sheepy.lily.vulkan.nuklear.pipeline.layout;

import org.joml.Vector2ic;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter;

import java.util.List;

public class LayoutManager
{
	private boolean dirty = true;
	private boolean startedFrame = true;
	private Vector2ic currentExtent;

	public void layout(List<IPanelAdapter> panelAdapters, IPanelAdapter.UIContext uiContext, Vector2ic extent)
	{
		startedFrame = true;

		if (extent != currentExtent)
		{
			dirty = true;
			currentExtent = extent;
		}

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

	public Vector2ic getCurrentExtent()
	{
		return currentExtent;
	}
}
