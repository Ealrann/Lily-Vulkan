package org.sheepy.vulkan.common.util;

import static org.lwjgl.vulkan.VK10.vkEnumerateInstanceLayerProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkLayerProperties;

public class LayerFinder
{
	public static PointerBuffer convertToPointerBuffer(MemoryStack stack, String[] requiredLayers)
	{
		Set<String> availableLayers = getAvailableLayers(stack, requiredLayers);
		List<String> selectedLayers = filterRequiredLayers(requiredLayers, availableLayers);
		PointerBuffer res = convertToBuffer(stack, selectedLayers);

		return res;
	}

	private static PointerBuffer convertToBuffer(MemoryStack stack, List<String> selectedLayers)
	{
		PointerBuffer res;
		int size = selectedLayers.size();
		res = stack.mallocPointer(size);
		for (int i = 0; i < size; i++)
		{
			res.put(stack.UTF8(selectedLayers.get(i)));
		}
		res.flip();
		return res;
	}

	private static List<String> filterRequiredLayers(	String[] requiredLayers,
														Set<String> availableLayers)
	{
		List<String> selectedLayers = new ArrayList<>();
		for (String layer : requiredLayers)
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

	private static Set<String> getAvailableLayers(MemoryStack stack, String[] requiredLayers)
	{
		Set<String> res = new HashSet<>();
		final int[] ip = new int[1];
		vkEnumerateInstanceLayerProperties(ip, null);
		final int count = ip[0];

		if (count > 0)
		{
			final var instanceLayers = VkLayerProperties.mallocStack(count, stack);
			vkEnumerateInstanceLayerProperties(ip, instanceLayers);

			System.out.println("System Layers:");
			for (int i = 0; i < count; i++)
			{
				String layerName = instanceLayers.get(i).layerNameString();
				System.out.println("\t" + layerName);
				res.add(layerName);
			}
		}

		return res;
	}

}
