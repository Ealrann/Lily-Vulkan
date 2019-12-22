package org.sheepy.lily.vulkan.nuklear.ui;

import java.util.List;
import java.util.Map;

import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkImage;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.model.application.FileResource;
import org.sheepy.vulkan.window.Window;

public interface IPanelAdapter extends IAdapter
{
	boolean layout(UIContext context);

	default void collectImages(List<FileResource> imageCollection)
	{};

	static final class UIContext
	{
		public final Window window;
		public final NkContext nkContext;
		public final Map<FileResource, NkImage> imageMap;
		public final List<IInputEvent> events;

		public UIContext(	Window window,
							NkContext nkContext,
							Map<FileResource, NkImage> imageMap,
							List<IInputEvent> events)
		{
			this.window = window;
			this.nkContext = nkContext;
			this.imageMap = Map.copyOf(imageMap);
			this.events = List.copyOf(events);
		}
	}
}
