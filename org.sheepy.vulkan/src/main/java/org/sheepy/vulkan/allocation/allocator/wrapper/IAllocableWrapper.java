package org.sheepy.vulkan.allocation.allocator.wrapper;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.lwjgl.system.MemoryStack;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IBasicAllocable;

public interface IAllocableWrapper extends IAllocable
{
	static IAllocableWrapper newWrapper(EObject eObject)
	{
		return new EObjectWrapper(eObject);
	}
	
	static IAllocableWrapper newWrapper(IBasicAllocable allocable)
	{
		return new AllocableWrapper(allocable);
	}
	
	void deepAllocate(MemoryStack stack);

	void flatAllocate(MemoryStack stack);

	boolean isAllocable();

	List<IAllocableWrapper> getChildWrappers();
}