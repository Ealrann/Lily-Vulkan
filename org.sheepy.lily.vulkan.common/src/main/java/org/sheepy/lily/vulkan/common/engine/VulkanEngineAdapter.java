package org.sheepy.lily.vulkan.common.engine;

import static org.lwjgl.system.MemoryStack.stackPush;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.joml.Vector2i;
import org.lwjgl.system.MemoryStack;
import org.sheepy.lily.core.api.adapter.IServiceAdapterFactory;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.NotifyChanged;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.vulkan.api.adapter.IVulkanEngineAdapter;
import org.sheepy.lily.vulkan.api.concurrent.IFence;
import org.sheepy.lily.vulkan.api.nativehelper.surface.VkSurface;
import org.sheepy.lily.vulkan.api.nativehelper.window.IWindowListener;
import org.sheepy.lily.vulkan.api.nativehelper.window.Window;
import org.sheepy.lily.vulkan.api.queue.EQueueType;
import org.sheepy.lily.vulkan.common.allocation.allocator.TreeAllocator;
import org.sheepy.lily.vulkan.common.concurrent.VkFence;
import org.sheepy.lily.vulkan.common.device.LogicalDevice;
import org.sheepy.lily.vulkan.common.device.LogicalDeviceContext;
import org.sheepy.lily.vulkan.common.device.PhysicalDevice;
import org.sheepy.lily.vulkan.common.device.VulkanInstance;
import org.sheepy.lily.vulkan.common.device.judge.PhysicalDeviceSelector;
import org.sheepy.lily.vulkan.common.execution.ExecutionContext;
import org.sheepy.lily.vulkan.common.input.VulkanInputManager;
import org.sheepy.lily.vulkan.model.VulkanEngine;
import org.sheepy.lily.vulkan.model.VulkanPackage;

@Statefull
@Adapter(scope = VulkanEngine.class)
public class VulkanEngineAdapter implements IVulkanEngineAdapter
{
	private final IWindowListener resizeListener = new IWindowListener()
	{
		@Override
		public void onWindowResize(VkSurface surface)
		{
			resize(surface);
		}
	};

	private final List<VkFence> fences = new ArrayList<>();
	private final VulkanInputManager inputManager;
	private final VulkanEngine engine;
	private final Application application;
	private final EngineExtensionRequirement extensionRequirement;

	private final boolean debug;

	protected VulkanInstance vkInstance;
	protected PhysicalDevice physicalDevice;
	protected LogicalDevice logicalDevice = null;
	protected LogicalDeviceContext logicalDeviceContext = null;
	protected TreeAllocator allocator;
	private VulkanEngineAllocationRoot allocationRoot;
	private boolean allocated = false;
	private ExecutionContext executionContext = null;

	protected Window window;
	private boolean listeningResize = true;

	private final AdapterImpl applicationAdapter = new AdapterImpl()
	{
		@Override
		public void notifyChanged(Notification notification)
		{
			if (listeningResize)
			{
				if (notification.getFeature() == ApplicationPackage.Literals.APPLICATION__SIZE)
				{
					Vector2i newSize = (Vector2i) notification.getNewValue();
					window.setSize(newSize.x, newSize.y);
				}
			}
		}
	};

	@NotifyChanged
	public void notifyChanged(Notification notification)
	{
		if (notification.getFeature() == VulkanPackage.Literals.VULKAN_ENGINE__ENABLED)
		{
			if (engine != null
					&& notification.getNewBooleanValue() != notification.getOldBooleanValue())
			{
				if (engine.isEnabled())
				{
					start();
				}
				else
				{
					stop();
				}
			}
		}
	}

	public VulkanEngineAdapter(VulkanEngine engine)
	{
		this.engine = engine;
		application = (Application) engine.eContainer();
		debug = application.isDebug();
		executionContext = new ExecutionContext(EQueueType.Graphic, false);
		window = new Window(application.getSize(), application.getTitle(),
				application.isResizeable(), application.isFullscreen());
		inputManager = new VulkanInputManager(application, window);

		try (MemoryStack stack = stackPush())
		{
			extensionRequirement = new EngineExtensionRequirement(engine, stack, debug);
		}
	}

	@Autorun
	public void load()
	{
		application.eAdapters().add(applicationAdapter);

		if (engine.isEnabled())
		{
			start();
		}
	}

	@Dispose
	public void dispose()
	{
		if (engine != null)
		{
			if (engine.isEnabled())
			{
				stop();
			}
		}

		application.eAdapters().remove(applicationAdapter);
	}

	private void start()
	{
		try (MemoryStack stack = stackPush())
		{
			createInstance(stack);
			window.open(vkInstance.getVkInstance());
			pickPhysicalDevice(stack);
			createLogicalDevice(stack);
			inputManager.load();
			window.addListener(resizeListener);
			allocate(stack);
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
	}

	private void resize(VkSurface surface)
	{
		listeningResize = false;

		try
		{
			Vector2i newSize = new Vector2i(surface.width, surface.height);
			application.setSize(newSize);
			logicalDevice.recreateQueues(surface);
		} catch (Throwable e)
		{
			e.printStackTrace();
		} finally
		{
			listeningResize = true;
		}
	}

	private void stop()
	{
		if (allocated == true)
		{
			free();
		}

		if (logicalDevice != null)
		{
			logicalDevice.waitIdle();
		}

		window.removeListener(resizeListener);
		cleanup();
	}

	private void allocate(MemoryStack stack)
	{
		allocationRoot = new VulkanEngineAllocationRoot(executionContext, gatherAllocationList());
		allocator = new TreeAllocator(allocationRoot);
		allocator.allocate(stack, logicalDeviceContext);
		allocated = true;
	}

	private List<Object> gatherAllocationList()
	{
		List<Object> allocationList = new ArrayList<>();
		var resourcePkg = engine.getResourcePkg();
		if (resourcePkg != null)
		{
			allocationList.addAll(resourcePkg.getResources());
		}
		allocationList.addAll(engine.getProcesses());
		return allocationList;
	}

	private void free()
	{
		executionContext.getQueue().waitIdle();
		allocator.free(logicalDeviceContext);

		for (VkFence fence : fences)
		{
			fence.free(logicalDeviceContext);
		}
		allocated = false;
	}

	private void createInstance(MemoryStack stack)
	{

		vkInstance = new VulkanInstance(application, extensionRequirement, debug);

		vkInstance.allocate(stack);

	}

	private void pickPhysicalDevice(MemoryStack stack)
	{
		final var surface = window.getSurface();
		final var deviceSelector = new PhysicalDeviceSelector(vkInstance, extensionRequirement,
				surface, debug);

		physicalDevice = deviceSelector.findBestPhysicalDevice(stack);

		String deviceInfo = String.format("\nUsing Graphic Device: %s (%s)",
				physicalDevice.getName(), physicalDevice.getDriverVersion());
		System.out.println(deviceInfo);

		if (debug)
		{
			physicalDevice.printRetainedExtensions();
			// physicalDevice.printPhysicalProperties();
		}
	}

	private void createLogicalDevice(MemoryStack stack)
	{
		logicalDevice = LogicalDevice.alloc(stack, physicalDevice, window, true);
		logicalDeviceContext = new LogicalDeviceContext(logicalDevice);
	}

	private void cleanup()
	{
		inputManager.dispose();
		logicalDevice.free();

		window.close();

		physicalDevice.free();

		vkInstance.free();
		vkInstance = null;
	}

	@Override
	public IFence newFence()
	{
		return newFence(false);
	}

	@Override
	public IFence newFence(boolean signaled)
	{
		VkFence res = new VkFence(signaled);
		res.allocate(null, logicalDeviceContext);

		fences.add(res);
		return res;
	}

	public LogicalDevice getLogicalDevice()
	{
		return logicalDevice;
	}

	@Override
	public Window getWindow()
	{
		return window;
	}

	public PhysicalDevice getPhysicalDevice()
	{
		return physicalDevice;
	}

	@Override
	public VulkanInputManager getInputManager()
	{
		return inputManager;
	}

	public static VulkanEngineAdapter adapt(VulkanEngine engine)
	{
		return IServiceAdapterFactory.INSTANCE.adapt(engine, VulkanEngineAdapter.class);
	}
}
