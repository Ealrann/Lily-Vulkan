package org.sheepy.lily.vulkan.core.engine;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.engine.utils.VulkanEngineUtils;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.input.VulkanInputManager;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanPackage;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.system.MemoryStack.stackPush;

@ModelExtender(scope = VulkanEngine.class)
@Allocation
@AllocationChild(features = {VulkanPackage.VULKAN_ENGINE__RESOURCE_PKG, ResourcePackage.RESOURCE_PKG__RESOURCES})
@AllocationChild(features = {VulkanPackage.VULKAN_ENGINE__DESCRIPTOR_PKG, VulkanPackage.DESCRIPTOR_PKG__DESCRIPTORS})
@AllocationChild(features = VulkanPackage.VULKAN_ENGINE__PROCESSES)
public final class VulkanEngineAllocation implements IVulkanEngineAdapter
{
	private final List<VkFence> fences = new ArrayList<>();
	private final VulkanInputManager inputManager;
	private final VulkanEngine engine;
	private final Window window;
	private final VulkanContextAllocation vulkanContext;
	private final ExecutionContext executionContext;

	public VulkanEngineAllocation(VulkanEngine engine)
	{
		final var application = (Application) engine.eContainer();
		final var scene = application.getScene();
		this.engine = engine;
		this.inputManager = application.adapt(VulkanInputManager.class);
		if (scene != null)
		{
			window = new Window(scene, application.getTitle());
			inputManager.connect(window);
			window.open();
		}
		else
		{
			window = null;
		}

		try (final var stack = stackPush())
		{
			final var instanceName = application.getTitle();
			final var queueTypes = VulkanEngineUtils.generateQueueTypes(engine);
			final var features = engine.getFeatures();
			final var contextBuilder = new VulkanContextAllocation.Builder();
			contextBuilder.setWindow(window);

			vulkanContext = contextBuilder.build(stack, instanceName, queueTypes, features);
			executionContext = new ExecutionContext(vulkanContext, EQueueType.Compute, false);
		}
	}

	@ProvideContext
	private ExecutionContext provideContext()
	{
		return executionContext;
	}

	@Override
	public void step()
	{
		for (final var process : engine.getProcesses())
		{
			final var cadence = process.getCadence();
			if (cadence != null)
			{
				final var adapter = cadence.adaptNotNull(ICadenceAdapter.class);
				adapter.run();
			}
		}
	}

	@Free
	private void free()
	{
		freeChildren();

		if (executionContext.getLogicalDevice() != null)
		{
			executionContext.getLogicalDevice().waitIdle();
		}

		if (inputManager != null) inputManager.disconnect();
		executionContext.free(vulkanContext);
		vulkanContext.free();
	}

	private void freeChildren()
	{
		executionContext.getQueue().waitIdle();
		for (final VkFence fence : fences)
		{
			fence.free();
		}
	}

	@Override
	public void waitIdle()
	{
		if (executionContext.getLogicalDevice() != null)
		{
			for (final var process : engine.getProcesses())
			{
				final var adapter = process.adapt(IProcessAdapter.class);
				adapter.waitIdle();
			}

			executionContext.getLogicalDevice().waitIdle();
		}
	}

	@Override
	public VkFence newFence()
	{
		return newFence(false);
	}

	@Override
	public VkFence newFence(boolean signaled)
	{
		final var vkDevice = executionContext.getVkDevice();
		final var vkFence = new VkFence(vkDevice, signaled);
		fences.add(vkFence);
		return vkFence;
	}

	@Override
	public Window getWindow()
	{
		return window;
	}
}
