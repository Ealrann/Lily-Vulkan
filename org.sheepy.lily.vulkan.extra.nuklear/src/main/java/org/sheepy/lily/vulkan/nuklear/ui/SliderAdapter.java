package org.sheepy.lily.vulkan.nuklear.ui;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.variable.IVariableResolverAdapter;
import org.sheepy.lily.core.model.ui.IUIElement;
import org.sheepy.lily.core.model.ui.Slider;
import org.sheepy.lily.core.model.variable.IVariableResolver;
import org.sheepy.lily.vulkan.nuklear.ui.IPanelAdapter.UIContext;

import java.nio.IntBuffer;
import java.util.function.Consumer;

import static org.lwjgl.nuklear.Nuklear.nk_slider_int;

@Statefull
@Adapter(scope = Slider.class)
public class SliderAdapter implements IUIElementAdapter
{
	private final IntBuffer buffer;
	private final Consumer<Object> listener = this::valueChanged;
	private final IVariableResolverAdapter<IVariableResolver> resolverAdapter;
	private final IVariableResolver variableResolver;

	private boolean dirty = true;

	@SuppressWarnings("unchecked")
	public SliderAdapter(Slider slider)
	{
		buffer = MemoryUtil.memCallocInt(1);
		variableResolver = slider.getVariableResolver();
		resolverAdapter = variableResolver.adaptNotNull(IVariableResolverAdapter.class);

		final var val = (Integer) resolverAdapter.getValue(variableResolver);
		updateValue(val);

		resolverAdapter.listen(listener);
	}

	@Dispose
	public void dispose()
	{
		resolverAdapter.sulk(listener);
		MemoryUtil.memFree(buffer);
	}

	private void valueChanged(Object value)
	{
		updateValue((Integer) value);
	}

	private void updateValue(int val)
	{
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

		context.setFont(slider.getFont());
		nk_slider_int(context.nkContext, slider.getMinValue(), buffer, slider.getMaxValue(), slider.getStep());

		final Integer val = (Integer) resolverAdapter.getValue(variableResolver);
		if (val != buffer.get(0))
		{
			resolverAdapter.setValue(variableResolver, buffer.get(0));
			res = true;
		}

		return res;
	}

	@Override
	public boolean needLayout()
	{
		return dirty;
	}
}
