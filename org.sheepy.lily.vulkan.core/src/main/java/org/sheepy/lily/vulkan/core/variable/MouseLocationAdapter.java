package org.sheepy.lily.vulkan.core.variable;

import org.logoce.adapter.api.Adapter;
import org.sheepy.lily.core.api.adapter.Dispose;
import org.sheepy.lily.core.api.adapter.Load;
import org.logoce.extender.api.ModelExtender;
import org.sheepy.lily.core.api.input.IInputManager;
import org.sheepy.lily.core.api.input.event.CursorLocationEvent;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.model.MouseLocation;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.function.Consumer;

@ModelExtender(scope = MouseLocation.class)
@Adapter
public final class MouseLocationAdapter extends Notifier<IModelVariableAdapter.Features> implements
																						 IModelVariableAdapter<MouseLocation>
{
	private final IInputManager inputManager;
	private final Consumer<CursorLocationEvent> cursorListener = loc -> notify(Features.Value, loc);

	private MouseLocationAdapter(MouseLocation variable)
	{
		super(List.of(Features.Value));
		final var application = (Application) variable.getVulkanEngine().eContainer();
		inputManager = application.adapt(IInputManager.class);
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
