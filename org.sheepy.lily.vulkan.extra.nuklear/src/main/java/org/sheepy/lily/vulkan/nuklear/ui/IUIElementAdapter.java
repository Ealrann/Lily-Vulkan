package org.sheepy.lily.vulkan.nuklear.ui;

import java.util.List;
import java.util.Map;

import org.lwjgl.nuklear.NkContext;
import org.lwjgl.nuklear.NkImage;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.vulkan.model.resource.PathResource;
import org.sheepy.vulkan.window.Window;

public interface IUIElementAdapter extends IAdapter
{
	boolean layout(UIContext context, IUIElement control);

	default void collectImages(List<PathResource> imageCollection)
	{};

	static final class UIContext
	{
		public final Window window;
		public final NkContext nkContext;
		public final Map<PathResource, NkImage> imageMap;
		public final List<IInputEvent> events;

		public UIContext(	Window window,
							NkContext nkContext,
							Map<PathResource, NkImage> imageMap,
							List<IInputEvent> events)
		{
			this.window = window;
			this.nkContext = nkContext;
			this.imageMap = Map.copyOf(imageMap);
			this.events = List.copyOf(events);
		}
	}
}
