package org.sheepy.lily.vulkan.resource.buffer;

import org.eclipse.emf.common.notify.Notification;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.ILilyEObject;
import org.sheepy.lily.core.api.adapter.annotation.*;
import org.sheepy.lily.core.api.notification.INotificationListener;
import org.sheepy.lily.core.api.notification.util.AbstractModelSetRegistry;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@Statefull
@Adapter(scope = GenericConstantBuffer.class, lazy = false)
public final class GenericConstantBufferAdapter implements IAdapter
{
	private final INotificationListener valueListener = this::valueChanged;
	private final GenericConstantBuffer constantBuffer;
	private final List<AdaptedVariableEntry<?>> adaptedVariables = new ArrayList<>();
	private final AbstractModelSetRegistry variableListener = new AbstractModelSetRegistry(List.of(VulkanResourcePackage.Literals.GENERIC_CONSTANT_BUFFER__VARIABLES))
	{
		@Override
		protected void add(final ILilyEObject newValue)
		{
			final var variable = (IModelVariable) newValue;
			final var entry = new AdaptedVariableEntry<>(variable);
			entry.adapter.addListener(valueListener, IModelVariableAdapter.Features.Value.ordinal());
			adaptedVariables.add(entry);
		}

		@Override
		protected void remove(final ILilyEObject oldValue)
		{
			final var it = adaptedVariables.iterator();
			while (it.hasNext())
			{
				final var entry = it.next();
				if (entry.variable == oldValue)
				{
					entry.adapter.removeListener(valueListener, IModelVariableAdapter.Features.Value.ordinal());
					it.remove();
					break;
				}
			}
		}
	};

	private boolean bufferDirty = true;
	private boolean valueDirty = true;

	private GenericConstantBufferAdapter(GenericConstantBuffer constantBuffer)
	{
		this.constantBuffer = constantBuffer;
	}

	@Load
	private void load()
	{
		variableListener.startRegister(constantBuffer);
	}

	@Dispose
	private void dispose()
	{
		variableListener.stopRegister(constantBuffer);
	}

	@NotifyChanged(featureIds = VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLES)
	private void variabledChanged()
	{
		bufferDirty = true;
	}

	private void valueChanged(Notification notification)
	{
		valueDirty = true;
	}

	@Tick
	private void tick()
	{
		if (bufferDirty)
		{
			reallocBuffer();
			bufferDirty = false;
			valueDirty = true;
		}

		if (valueDirty)
		{
			fillValues();
			valueDirty = true;
		}
	}

	private void reallocBuffer()
	{
		final ByteBuffer data = constantBuffer.getData();
		if (data != null)
		{
			MemoryUtil.memFree(data);
		}

		final int size = computeSize();
		if (size > 0)
		{
			constantBuffer.setData(MemoryUtil.memAlloc(size));
		}
	}

	private void fillValues()
	{
		final var data = constantBuffer.getData();

		if (data != null)
		{
			for (int i = 0; i < adaptedVariables.size(); i++)
			{
				final var entry = adaptedVariables.get(i);
				final var type = entry.adapter.type();

				switch (type)
				{
					case Int:
						data.putInt(entry.intValue());
				}
			}

			data.flip();
			constantBuffer.setData(data);
		}
	}

	private int computeSize()
	{
		int size = 0;
		for (int i = 0; i < adaptedVariables.size(); i++)
		{
			final var entry = adaptedVariables.get(i);
			size += entry.adapter.bytes();
		}

		return size;
	}

	private static final class AdaptedVariableEntry<T extends IModelVariable>
	{
		final T variable;
		final IModelVariableAdapter<T> adapter;

		AdaptedVariableEntry(T variable)
		{
			this.variable = variable;
			this.adapter = variable.adaptNotNullGeneric(IModelVariableAdapter.class);
		}

		public int intValue()
		{
			return adapter.intValue(variable);
		}
	}
}
