package org.sheepy.lily.vulkan.core.instance.loader;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkLayerProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.lwjgl.vulkan.VK10.vkEnumerateInstanceLayerProperties;

public final class LayerFinder
{
	public static PointerBuffer convertToPointerBuffer(MemoryStack stack, String[] requiredLayers, boolean verbose)
	{
		final Set<String> availableLayers = getAvailableLayers(stack, requiredLayers, verbose);
		final List<String> selectedLayers = filterRequiredLayers(requiredLayers, availableLayers);
		final PointerBuffer res = convertToBuffer(stack, selectedLayers);

		return res;
	}

	private static PointerBuffer convertToBuffer(MemoryStack stack, List<String> selectedLayers)
	{
		final int size = selectedLayers.size();
		final var res = stack.mallocPointer(size);
		for (int i = 0; i < size; i++)
		{
			res.put(stack.UTF8(selectedLayers.get(i)));
		}
		res.flip();
		return res;
	}

	private static List<String> filterRequiredLayers(String[] requiredLayers, Set<String> availableLayers)
	{
		final List<String> selectedLayers = new ArrayList<>();
		for (final String layer : requiredLayers)
		{
			if (availableLayers.contains(layer) == false)
			{
				System.err.println(String.format("Required layer [%s] is not available.", layer));
			}
			else
			{
				selectedLayers.add(layer);
			}
		}
		return selectedLayers;
	}

	private static Set<String> getAvailableLayers(MemoryStack stack, String[] requiredLayers, boolean verbose)
	{
		final Set<String> res = new HashSet<>();
		final int[] ip = new int[1];
		vkEnumerateInstanceLayerProperties(ip, null);
		final int count = ip[0];

		if (count > 0)
		{
			final var instanceLayers = VkLayerProperties.mallocStack(count, stack);
			vkEnumerateInstanceLayerProperties(ip, instanceLayers);

			if (verbose)
			{
				System.out.println("System Layers:");
			}

			for (int i = 0; i < count; i++)
			{
				final String layerName = instanceLayers.get(i).layerNameString();

				if (verbose)
				{
					System.out.println("\t" + layerName);
				}
				res.add(layerName);
			}

			if (verbose)
			{
				System.out.println();
			}
		}

		return res;
	}

}
