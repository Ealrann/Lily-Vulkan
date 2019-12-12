package org.sheepy.lily.vulkan.nuklear.ui;

import static org.lwjgl.nuklear.Nuklear.nk_slider_int;

import java.nio.IntBuffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.presentation.IUIElement;
import org.sheepy.lily.core.model.ui.Slider;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

@Statefull
@Adapter(scope = Slider.class)
public class SliderAdapter implements IUIElementAdapter
{
	private final IntBuffer buffer;
	private final INotificationListener listener = n -> updateValue();
	private final IVariableResolverAdapter<IVariableResolver> resolverAdapter;
	private final IVariableResolver variableResolver;

	private boolean dirty = false;

	@SuppressWarnings("unchecked")
	public SliderAdapter(Slider slider)
	{
		buffer = MemoryUtil.memCallocInt(1);
		variableResolver = slider.getVariableResolver();
		resolverAdapter = variableResolver.adaptNotNull(IVariableResolverAdapter.class);

		updateValue();

		resolverAdapter.addListener(listener);
	}

	@Dispose
	public void dispose()
	{
		resolverAdapter.removeListener(listener);
		MemoryUtil.memFree(buffer);
	}

	private void updateValue()
	{
		final Integer val = (Integer) resolverAdapter.getValue(variableResolver);
		buffer.put(val);
		buffer.flip();
		dirty = true;
	}

	@Override
	public boolean layout(UIContext context, IUIElement control)
	{
		final var slider = (Slider) control;

		boolean res = dirty;
		dirty = false;

		nk_slider_int(	context.nkContext,
						slider.getMinValue(),
						buffer,
						slider.getMaxValue(),
						slider.getStep());

		final Integer val = (Integer) resolverAdapter.getValue(variableResolver);
		if (val != buffer.get(0))
		{
			resolverAdapter.setValue(variableResolver, buffer.get(0));
			res = true;
		}

		return res;
	}
}
