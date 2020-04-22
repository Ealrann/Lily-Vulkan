package org.sheepy.lily.vulkan.resource.buffer;

import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.VariablePackage;
import org.sheepy.lily.vulkan.model.resource.GenericConstantBuffer;
import org.sheepy.lily.vulkan.model.resource.VulkanResourcePackage;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@ModelExtender(scope = GenericConstantBuffer.class)
@Adapter(lazy = false)
public final class GenericConstantBufferAdapter implements IExtender
{
	private final GenericConstantBuffer constantBuffer;
	private final List<AdaptedVariableEntry<?>> adaptedVariables = new ArrayList<>();

	private boolean bufferDirty = true;
	private boolean valueDirty = true;

	private GenericConstantBufferAdapter(GenericConstantBuffer constantBuffer, IObservatoryBuilder observatory)
	{
		this.constantBuffer = constantBuffer;

		observatory.explore(VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__VARIABLE_PKG)
				   .explore(VariablePackage.MODEL_VARIABLE_PKG__VARIABLES, IModelVariable.class)
				   .gather(this::addEntry, this::removeEntry)
				   .adaptNotifier(IModelVariableAdapter.notifierClass())
				   .listenNoParam(() -> valueDirty = true, IModelVariableAdapter.Features.Value);
		observatory.explore(VulkanResourcePackage.GENERIC_CONSTANT_BUFFER__REFERENCED_VARIABLES, IModelVariable.class)
				   .gather(this::addEntry, this::removeEntry)
				   .adaptNotifier(IModelVariableAdapter.notifierClass())
				   .listenNoParam(() -> valueDirty = true, IModelVariableAdapter.Features.Value);
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
			valueDirty = false;
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
				entry.fillData(data);
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

	private void addEntry(final IModelVariable newValue)
	{
		final var variable = (IModelVariable) newValue;
		final var entry = new AdaptedVariableEntry<>(variable);
		adaptedVariables.add(entry);
		bufferDirty = true;
	}

	private void removeEntry(final IModelVariable oldValue)
	{
		final var it = adaptedVariables.iterator();
		while (it.hasNext())
		{
			final var entry = it.next();
			if (entry.variable == oldValue)
			{
				it.remove();
				bufferDirty = true;
				break;
			}
		}
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

		public void fillData(final ByteBuffer data)
		{
			adapter.getValue(variable, data);
		}
	}
}
