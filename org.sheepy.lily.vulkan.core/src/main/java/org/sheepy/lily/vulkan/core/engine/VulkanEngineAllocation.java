package org.sheepy.lily.vulkan.core.engine;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationChild;
import org.sheepy.lily.core.api.allocation.annotation.Free;
import org.sheepy.lily.core.api.allocation.annotation.ProvideContext;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
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
//	private static final String WAIT_IDLE_RELOAD_ENGINE_RESOURCES = "[WaitIdle] Reload engine resources";

	private final List<VkFence> fences = new ArrayList<>();
	private final VulkanInputManager inputManager;
	private final VulkanEngine engine;
	private final Runnable openListener = this::loadInputManager;
	private final Window window;
	private final VulkanContext vulkanContext;
	private final ExecutionContext executionContext;

	public VulkanEngineAllocation(VulkanEngine engine)
	{
		this.engine = engine;

		final var application = (Application) engine.eContainer();
		final var scene = application.getScene();
		if (scene != null)
		{
			window = new Window(scene, application.getTitle());
			inputManager = new VulkanInputManager(application, window);
			window.open();
		}
		else
		{
			window = null;
			inputManager = null;
		}

		try (final var stack = stackPush())
		{
			final var instanceName = application.getTitle();
			final var queueTypes = VulkanEngineUtils.generateQueueTypes(engine);
			final var features = engine.getFeatures();
			final var contextBuilder = new VulkanContext.Builder();
			contextBuilder.setWindow(window);

			vulkanContext = contextBuilder.build(stack, instanceName, queueTypes, features);
			executionContext = new ExecutionContext(vulkanContext, EQueueType.Compute, false);

			if (window != null)
			{
				loadInputManager();
				window.listenNoParam(openListener, IWindow.Features.Open);
			}
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
		updateAllocation();

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

	private void updateAllocation()
	{
//		executionContext.beforeChildrenAllocation();
//		resourceAllocator.allocate(executionContext);
//		executionContext.afterChildrenAllocation();
//
//		if (allocator.isAllocationDirty())
//		{
//			for (final var process : engine.getProcesses())
//			{
//				final var adapter = process.adapt(IProcessAdapter.class);
//				adapter.waitIdle();
//				if (DebugUtil.DEBUG_VERBOSE_ENABLED)
//				{
//					System.err.println(WAIT_IDLE_RELOAD_ENGINE_RESOURCES);
//				}
//			}
//
//			allocator.reloadDirtyElements();
//		}
	}

	@Free
	private void free()
	{
		freeChildren();

		if (executionContext.getLogicalDevice() != null)
		{
			executionContext.getLogicalDevice().waitIdle();
		}

		if (window != null)
		{
			window.sulkNoParam(openListener, IWindow.Features.Open);
		}

		if (inputManager != null) inputManager.dispose();
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
			executionContext.getLogicalDevice().waitIdle();
		}
	}

	private void loadInputManager()
	{
		inputManager.load();
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

	@Override
	public VulkanInputManager getInputManager()
	{
		return inputManager;
	}
}
