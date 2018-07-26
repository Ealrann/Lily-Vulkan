package org.sheepy.vulkan.pipeline;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.command.CommandPool;
import org.sheepy.vulkan.common.AllocationNode;
import org.sheepy.vulkan.common.IAllocable;
import org.sheepy.vulkan.descriptor.DescriptorPool;
import org.sheepy.vulkan.device.LogicalDevice;
import org.sheepy.vulkan.resource.IResource;
import org.sheepy.vulkan.resource.ResourceManager;

/**
 * @author ealrann
 *
 */
public abstract class AbstractProcessPool<T extends AbstractProcess<?>> extends AllocationNode
{
	public final LogicalDevice logicalDevice;
	public final CommandPool commandPool;
	
	public final Context context;

	public final DescriptorPool descriptorPool;
	public final ResourceManager resourceManager;

	protected final List<T> processes = new ArrayList<>();

	public AbstractProcessPool(Configuration configuration, int queueIndex)
	{
		this(configuration, queueIndex, false);
	}

	public AbstractProcessPool(Configuration configuration, int queueIndex, boolean allowReset)
	{
		this.logicalDevice = configuration.logicalDevice;
		commandPool = new CommandPool(logicalDevice, queueIndex, allowReset);
		resourceManager = new ResourceManager(commandPool);
		descriptorPool = new DescriptorPool(logicalDevice);
		
		this.context = createContext(configuration);

		allocationObjects.add(commandPool);
		allocationObjects.add(resourceManager);
		allocationObjects.add(descriptorPool);
		allocationObjects.add(context);

		try (MemoryStack stack = MemoryStack.stackPush())
		{
			// Allocate the pool early, because it's practical
			commandPool.allocate(stack);
		}
	}

	protected Context createContext(Configuration configuration)
	{
		return new Context(configuration, commandPool, resourceManager, descriptorPool);
	}

	public void addResource(IResource resource)
	{
		resourceManager.addResource(resource);
	}

	public void addResource(IAllocable resource)
	{
		resourceManager.addResource(resource);
	}

	public void addProcess(T process)
	{
		processes.add(process);
		allocationObjects.add(process);
	}

	public List<T> getProcesses()
	{
		return processes;
	}

	public final CommandPool getCommandPool()
	{
		return commandPool;
	}

	public abstract void execute();

}
