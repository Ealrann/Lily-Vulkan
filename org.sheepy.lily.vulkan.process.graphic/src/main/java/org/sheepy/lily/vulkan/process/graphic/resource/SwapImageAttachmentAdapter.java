package org.sheepy.lily.vulkan.process.graphic.resource;

import org.sheepy.lily.core.api.allocation.annotation.Allocation;
import org.sheepy.lily.core.api.allocation.annotation.AllocationDependency;
import org.sheepy.lily.core.api.allocation.annotation.InjectDependency;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.SwapchainConfiguration;
import org.sheepy.lily.vulkan.process.graphic.frame.SwapChainAllocation;
//
//@ModelExtender(scope = SwapImageAttachment.class)
//@Allocation
//@AllocationDependency(parent = SwapchainConfiguration.class, type = SwapChainAllocation.class)
//public final class SwapImageAttachmentAdapter implements IExtender
//{
//	private final SwapChainAllocation swapChain;
//
//	private SwapImageAttachmentAdapter(@InjectDependency(index = 0) SwapChainAllocation swapChain)
//	{
//		this.swapChain = swapChain;
//	}
//
//	public int getImageCount()
//	{
//		return swapChain.getImageCount();
//	}
//
//	public long getImagePtr(int index)
//	{
//		return swapChain.getImagePtr(index);
//	}
//}
