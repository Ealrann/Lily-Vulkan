package org.sheepy.lily.vulkan.core.variable;

import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.input.event.CursorLocationEvent;
import org.sheepy.lily.core.api.notification.Notifier;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.input.IVulkanInputManager;
import org.sheepy.lily.vulkan.model.MouseLocation;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Consumer;

@ModelExtender(scope = MouseLocation.class)
@Adapter
public final class MouseLocationAdapter extends Notifier<IModelVariableAdapter.Features> implements
																						 IModelVariableAdapter<MouseLocation>
{
	private final IVulkanInputManager inputManager;
	private final Consumer<CursorLocationEvent> cursorListener = loc -> notify(Features.Value, loc);

	private MouseLocationAdapter(MouseLocation variable)
	{
		super(List.of(Features.Value));
		final var adapter = variable.getVulkanEngine().adapt(IVulkanEngineAdapter.class);
		inputManager = adapter.getInputManager();
	}

	@Load
	private void load()
	{
		inputManager.listen(cursorListener, IInputManager.Features.CursorLocationEvent);
	}

	@Dispose
	private void dispose()
	{
		inputManager.sulk(cursorListener, IInputManager.Features.CursorLocationEvent);
	}

	@Override
	public int bytes()
	{
		return 2 * Integer.BYTES;
	}

	@Override
	public void getValue(final MouseLocation variable, final ByteBuffer buffer)
	{
		final var cursorPosition = inputManager.getCursorPosition();
		buffer.putInt((int) cursorPosition.x());
		buffer.putInt((int) cursorPosition.y());
	}

	@Override
	public void setValue(final MouseLocation variable, final String value)
	{
	}
}
