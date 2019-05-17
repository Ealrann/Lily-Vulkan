package org.sheepy.vulkan.allocation;

public interface IAllocationContextProvider<CurentContext extends IAllocationContext, ChildContext extends IAllocationContext>
		extends IAllocationObject<CurentContext>, IAllocationObject.IAllocationContainer<ChildContext>
{
	ChildContext getAllocationContext();
}
