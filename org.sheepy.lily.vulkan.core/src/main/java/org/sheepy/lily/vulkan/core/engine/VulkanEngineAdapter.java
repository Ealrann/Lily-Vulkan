package org.sheepy.lily.vulkan.core.engine;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EReference;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.allocation.IAllocationService;
import org.sheepy.lily.core.api.allocation.IRootAllocator;
import org.sheepy.lily.core.api.cadence.ICadenceAdapter;
import org.sheepy.lily.core.api.util.DebugUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.resource.ResourcePackage;
import org.sheepy.lily.game.api.window.IWindow;
import org.sheepy.lily.game.core.allocation.GenericAllocator;
import org.sheepy.lily.game.core.allocation.ModelAllocator;
import org.sheepy.lily.vulkan.api.engine.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.process.IProcessAdapter;
import org.sheepy.lily.vulkan.core.concurrent.VkFence;
import org.sheepy.lily.vulkan.core.device.IVulkanContext;
import org.sheepy.lily.vulkan.core.device.LogicalDevice;
import org.sheepy.lily.vulkan.core.engine.utils.VulkanEngineAllocationRoot;
import org.sheepy.lily.vulkan.core.engine.utils.VulkanEngineUtils;
import org.sheepy.lily.vulkan.core.execution.ExecutionContext;
import org.sheepy.lily.vulkan.core.execution.queue.EQueueType;
import org.sheepy.lily.vulkan.core.input.VulkanInputManager;
import org.sheepy.lily.vulkan.core.process.InternalProcessAdapter;
import org.sheepy.lily.vulkan.core.window.Window;
import org.sheepy.lily.vulkan.model.IProcess;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanPackage;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.system.MemoryStack.stackPush;

@Statefull
@Adapter(scope = VulkanEngine.class)
public final class VulkanEngineAdapter implements IVulkanEngineAdapter
{
	private static final String WAIT_IDLE_RELOAD_ENGINE_RESOURCES = "[WaitIdle] Reload engine resources";
	private static final List<EReference> RESOURCE_FEATURES = List.of(ApplicationPackage.Literals.IENGINE__RESOURCE_PKG,
																	  ResourcePackage.Literals.RESOURCE_PKG__RESOURCES);
	private static final List<EReference> DESCRIPTOR_FEATURES = List.of(VulkanPackage.Literals.VULKAN_ENGINE__DESCRIPTOR_PKG,
																		VulkanPackage.Literals.DESCRIPTOR_PKG__DESCRIPTORS);

	private final List<VkFence> fences = new ArrayList<>();
	private final VulkanInputManager inputManager;
	private final VulkanEngine engine;
	private final Application application;
	private final GenericAllocator<ExecutionContext> resourceAllocator = new GenericAllocator<>(List.of(
			RESOURCE_FEATURES,
			DESCRIPTOR_FEATURES));
	private final ModelAllocator resourceAllocator2 = new ModelAllocator(List.of(RESOURCE_FEATURES,
																				 DESCRIPTOR_FEATURES));
	private final Runnable openListener = this::loadInputManager;
	private final Window window;

	private VulkanContext vulkanContext;
	private ExecutionContext executionContext;
	private IRootAllocator<IVulkanContext> allocator;
	private boolean allocated = false;

	public VulkanEngineAdapter(VulkanEngine engine)
	{
		this.engine = engine;
		application = (Application) engine.eContainer();
		final var scene = application.getScene();
		if (scene != null)
		{
			window = new Window(scene, application.getTitle());
			inputManager = new VulkanInputManager(application, window);
		}
		else
		{
			window = null;
			inputManager = null;
		}
	}

	@NotifyChanged(featureIds = VulkanPackage.VULKAN_ENGINE__ENABLED)
	public void notifyChanged(Notification notification)
	{
		if (engine != null && notification.getNewBooleanValue() != notification.getOldBooleanValue())
		{
			if (engine.isEnabled())
			{
				load();
			}
			else
			{
				dispose();
			}
		}
	}

	@Override
	public void start()
	{
		if (engine.isEnabled())
		{
			load();
		}
	}

	private void load()
	{
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

		try
		{
			allocate();
		}
		catch (final Throwable e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void stop()
	{
		if (engine != null)
		{
			if (engine.isEnabled())
			{
				dispose();
			}
		}
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
		resourceAllocator2.update(executionContext);
		if (allocator.isAllocationDirty())
		{
			for (final var process : engine.getProcesses())
			{
				final var adapter = process.adapt(IProcessAdapter.class);
				adapter.waitIdle();
				if (DebugUtil.DEBUG_VERBOSE_ENABLED)
				{
					System.err.println(WAIT_IDLE_RELOAD_ENGINE_RESOURCES);
				}
			}

			allocator.reloadDirtyElements();
		}
	}

	private void dispose()
	{
		if (allocated == true)
		{
			resourceAllocator.stop(engine);
			free();
		}

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
		executionContext = null;
		vulkanContext.free();
		vulkanContext = null;
	}

	private void allocate()
	{
		resourceAllocator.start(engine);

		final var allocationRoot = new VulkanEngineAllocationRoot(List.of(resourceAllocator.getAllocable()));
		allocator = IAllocationService.INSTANCE.createAllocator(allocationRoot, executionContext);

		resourceAllocator2.start(engine, executionContext);
		allocator.allocate();

		if (DebugUtil.DEBUG_VERBOSE_ENABLED)
		{
			System.out.println("Engine Resources Allocation tree:");
			System.out.println(allocator.toString());
		}

		startProcesses();

		allocated = true;
	}

	private void startProcesses()
	{
		for (final IProcess process : engine.getProcesses())
		{
			final var adapter = process.adaptNotNull(InternalProcessAdapter.class);
			adapter.start(executionContext, allocator);
		}
	}

	private void free()
	{
		executionContext.getQueue().waitIdle();
		stopProcesses();
		allocator.free();
		resourceAllocator2.stop(engine, executionContext);

		for (final VkFence fence : fences)
		{
			fence.free(executionContext);
		}
		allocated = false;
	}

	private void stopProcesses()
	{
		for (final var process : engine.getProcesses())
		{
			final var adapter = process.adaptNotNull(InternalProcessAdapter.class);
			adapter.stop(executionContext);
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
		final VkFence res = new VkFence(signaled);
		res.allocate(executionContext);

		fences.add(res);
		return res;
	}

	public LogicalDevice getLogicalDevice()
	{
		return executionContext.getLogicalDevice();
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
