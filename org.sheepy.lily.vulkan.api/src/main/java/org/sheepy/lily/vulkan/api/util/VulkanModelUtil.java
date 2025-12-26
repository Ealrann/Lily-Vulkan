package org.sheepy.lily.vulkan.api.util;

import org.logoce.lmf.core.lang.LMObject;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;

import java.util.Collection;
import java.util.function.ToIntFunction;

public final class VulkanModelUtil
{
	private VulkanModelUtil()
	{
	}

	public static VulkanEngine getEngine(final LMObject object)
	{
		return getParent(object, VulkanEngine.class);
	}

	public static GraphicProcess getGraphicProcess(final LMObject object)
	{
		return getParent(object, GraphicProcess.class);
	}

	public static <T> T getParent(final LMObject object, final Class<T> classifier)
	{
		LMObject current = object;
		while (current != null)
		{
			if (classifier.isInstance(current))
			{
				return classifier.cast(current);
			}
			else
			{
				current = current.lmContainer();
			}
		}
		return null;
	}

	public static <E extends Enum<E>> int getEnumeratedFlag(final Collection<E> enumerates,
															final ToIntFunction<? super E> valueMapper)
	{
		int res = 0;

		for (final var enumeration : enumerates)
		{
			res |= valueMapper.applyAsInt(enumeration);
		}

		return res;
	}

	public static int getEnumeratedOrdinalFlag(final Collection<? extends Enum<?>> enumerates)
	{
		int res = 0;

		for (final var enumeration : enumerates)
		{
			res |= 1 << enumeration.ordinal();
		}

		return res;
	}
}

