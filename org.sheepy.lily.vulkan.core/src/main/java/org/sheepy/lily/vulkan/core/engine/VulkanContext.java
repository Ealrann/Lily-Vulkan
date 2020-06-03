package org.sheepy.lily.vulkan.core.engine;

import org.lwjgl.system.MemoryStack;
import org.lwjgl.vulkan.VkDevice;
import org.lwjgl.vulkan.VkInstance;
import org.lwjgl.vulkan.VkPhysicalDevice;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.game.core.allocation.GameAllocationContext;
import org.sheepy.lily.vulkan.api.device.EPhysicalFeature;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.device.PhysicalDevice;
import org.sheepy.lily.vulkan.core.device.loader.PhysicalDeviceSelector;
import org.sheepy.lily.vulkan.core.engine.extension.EDeviceExtension;
import org.sheepy.lily.vulkan.core.engine.extension.EInstanceExtension;
import org.sheepy.lily.vulkan.core.engine.extension.InstanceExtensions;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.execution.queue.QueueManager;
import org.sheepy.lily.vulkan.core.instance.VulkanInstance;
import org.sheepy.lily.vulkan.core.instance.loader.Layers;
import org.sheepy.lily.vulkan.core.window.VkSurface;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.stream.Collectors;

public final class VulkanContext extends GameAllocationContext implements IVulkanContext
{
	private final VulkanInstance vulkanInstance;
	private final PhysicalDevice physicalDevice;
	private final LogicalDevice logicalDevice;
	private final Window window;

	private VulkanContext(VulkanInstance vulkanInstance,
						  PhysicalDevice physicalDevice,
						  LogicalDevice logicalDevice,
						  Window window)
	{
		this.vulkanInstance = vulkanInstance;
		this.physicalDevice = physicalDevice;
		this.logicalDevice = logicalDevice;
		this.window = window;
	}

	void free()
	{
		logicalDevice.free();

		if (window != null) window.close();
		if (window != null) window.destroy();

		physicalDevice.free();
		vulkanInstance.free();
	}

	@Override
	public Window getWindow()
	{
		return window;
	}

	@Override
	public PhysicalDevice getPhysicalDevice()
	{
		return logicalDevice.physicalDevice;
	}

	@Override
	public VkPhysicalDevice getVkPhysicalDevice()
	{
		return logicalDevice.physicalDevice.vkPhysicalDevice;
	}

	@Override
	public LogicalDevice getLogicalDevice()
	{
		return logicalDevice;
	}

	@Override
	public VkDevice getVkDevice()
	{
		return logicalDevice.getVkDevice();
	}

	@Override
	public VkInstance getVkInstance()
	{
		return vulkanInstance.getVkInstance();
	}

	public static final class Builder
	{
		private Window window;

		public Builder setWindow(Window window)
		{
			this.window = window;
			return this;
		}

		public VulkanContext build(MemoryStack stack,
								   String instanceName,
								   Collection<EQueueType> queueTypes,
								   Collection<EPhysicalDeviceFeature> features)
		{
			final boolean headless = window == null;
			final var extRequirementBuilder = new InstanceExtensions.Builder(stack);
			if (!headless) extRequirementBuilder.requiresWindow();
			if (DebugUtil.DEBUG_ENABLED)
			{
				extRequirementBuilder.requires(EInstanceExtension.VK_EXT_debug_report.name);
				extRequirementBuilder.log(DebugUtil.DEBUG_VERBOSE_ENABLED);
			}
			final var extensionRequirement = extRequirementBuilder.build();

			final var vkInstance = createInstance(instanceName, extensionRequirement, stack);
			if (!headless) window.open();

			final var dummySurface = window != null ? window.createSurface(vkInstance.getVkInstance()) : null;
			final var physicalDevice = pickPhysicalDevice(stack,
														  headless,
														  vkInstance,
														  extensionRequirement,
														  dummySurface);
			final var logicalDevice = createLogicalDevice(stack, physicalDevice, queueTypes, features, dummySurface);
			if (dummySurface != null) dummySurface.free();

			return new VulkanContext(vkInstance, physicalDevice, logicalDevice, window);
		}

		private static VulkanInstance createInstance(String instanceName,
													 InstanceExtensions extensionRequirement,
													 MemoryStack stack)
		{
			final var layersBuilder = new Layers.Builder(stack);
			if (DebugUtil.DEBUG_ENABLED)
			{
				layersBuilder.requiresDebug();
				layersBuilder.log(DebugUtil.DEBUG_VERBOSE_ENABLED);
			}
			final var layers = layersBuilder.build();
			final var vkInstance = new VulkanInstance(instanceName,
													  extensionRequirement,
													  layers,
													  DebugUtil.DEBUG_ENABLED);
			vkInstance.allocate(stack);
			return vkInstance;
		}

		private static PhysicalDevice pickPhysicalDevice(MemoryStack stack,
														 boolean headless,
														 VulkanInstance vulkanInstance,
														 InstanceExtensions extensionRequirement,
														 VkSurface dummySurface)
		{
			final var extensions = headless ? EnumSet.noneOf(EDeviceExtension.class) : EnumSet.of(EDeviceExtension.VK_KHR_swapchain);
			final var deviceSelector = new PhysicalDeviceSelector(vulkanInstance,
																  extensionRequirement,
																  extensions,
																  dummySurface);
			return deviceSelector.findBestPhysicalDevice(stack);
		}

		private static LogicalDevice createLogicalDevice(MemoryStack stack,
														 PhysicalDevice physicalDevice,
														 Collection<EQueueType> queueTypes,
														 Collection<EPhysicalDeviceFeature> features,
														 VkSurface dummySurface)
		{
			final var vkFeatures = features.stream()
										   .map(f -> EPhysicalFeature.valueOf(f.getName()))
										   .collect(Collectors.toList());

			final var queueList = new ArrayList<>(queueTypes);
			queueList.add(EQueueType.Compute);
			final var queueManager = new QueueManager(physicalDevice.vkPhysicalDevice, queueList, dummySurface);
			final var logicalDevice = new LogicalDevice(physicalDevice, queueManager, vkFeatures);
			logicalDevice.allocate(stack);
			return logicalDevice;
		}
	}
}