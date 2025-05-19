package org.sheepy.lily.vulkan.core.instance.loader;

import org.lwjgl.PointerBuffer;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkLayerProperties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.lwjgl.vulkan.VK10.vkEnumerateInstanceLayerProperties;

public class Layers
{
	private static final String[] DEBUG_LAYERS = {"VK_LAYER_KHRONOS_validation",
//			"VK_LAYER_RENDERDOC_Capture",
//			"VK_LAYER_MESA_overlay",
//			"VK_LAYER_LUNARG_monitor",
// 			"VK_LAYER_LUNARG_api_dump"
	};

	public final List<String> layers;

	public Layers(List<String> layers)
	{
		this.layers = List.copyOf(layers);
	}

	public PointerBuffer callocBuffer()
	{
		final int size = layers.size();

		final var res = MemoryUtil.memCallocPointer(size);
		for (int i = 0; i < size; i++)
		{
			res.put(MemoryUtil.memUTF8(layers.get(i)));
		}
		res.flip();
		return res;
	}

	public static final class Builder
	{
		private final List<String> retainedLayers = new ArrayList<>();
		private final Set<String> availableLayers;

		public Builder()
		{
			availableLayers = getAvailableLayers();
		}

		public Builder requiresDebug()
		{
			for (String layer : DEBUG_LAYERS)
			{
				requires(layer);
			}
			return this;
		}

		public Builder requires(String layer)
		{
			if (availableLayers.contains(layer))
			{
				retainedLayers.add(layer);
			}
			else
			{
				System.err.printf("Required layer [%s] is not available.%n", layer);
			}
			return this;
		}

		public void log(boolean verbose)
		{
			System.out.println("\nUsing Layers:");
			for (final var layer : retainedLayers)
			{
				System.out.println("\t- " + layer);
			}
			if (verbose)
			{
				System.out.println("\nAvailable Layers:");
				for (final String layer : availableLayers)
				{
					System.out.println("\t- " + layer);
				}
			}
		}

		public Layers build()
		{
			return new Layers(retainedLayers);
		}

		private static Set<String> getAvailableLayers()
		{
			final Set<String> res = new HashSet<>();
			final int[] ip = new int[1];
			vkEnumerateInstanceLayerProperties(ip, null);
			final int count = ip[0];

			if (count > 0)
			{
				final var instanceLayers = VkLayerProperties.malloc(count);
				vkEnumerateInstanceLayerProperties(ip, instanceLayers);

				for (int i = 0; i < count; i++)
				{
					final String layerName = instanceLayers.get(i).layerNameString();
					res.add(layerName);
				}

				instanceLayers.free();
			}

			return res;
		}
	}
}
