package org.sheepy.lily.vulkan.nuklear.ui;

import java.util.List;

import org.lwjgl.nuklear.NkContext;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterFactoryService;
import org.sheepy.lily.core.api.input.event.IInputEvent;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.vulkan.window.Window;

public interface IUIElementAdapter extends IAdapter
{
	boolean layout(UIContext context, IUIElement control);

	public static IUIElementAdapter adapt(IUIElement object)
	{
		return IAdapterFactoryService.INSTANCE.adapt(object, IUIElementAdapter.class);
	}

	static final class UIContext
	{
		public final Window window;
		public final NkContext nkContext;
		public final List<IInputEvent> events;
		
		public UIContext(Window window, NkContext nkContext, List<IInputEvent> events)
		{
			this.window = window;
			this.nkContext = nkContext;
			this.events = events;
		}
	}
}
