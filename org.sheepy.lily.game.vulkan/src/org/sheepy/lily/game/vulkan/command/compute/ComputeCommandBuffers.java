//package org.sheepy.lily.game.vulkan.command.compute;
//
//import static org.lwjgl.vulkan.VK10.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.lwjgl.vulkan.VkDevice;
//import org.sheepy.lily.game.vulkan.command.AbstractCommandBuffers;
//import org.sheepy.lily.game.vulkan.command.CommandPool;
//import org.sheepy.lily.game.vulkan.descriptor.DescriptorPool;
//import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager;
//
//public class ComputeCommandBuffers extends AbstractCommandBuffers<ComputeCommandBuffer>
//{
//	private CommandPool commandPool;
//
//	public ComputeCommandBuffers(CommandPool commandPool)
//	{
//		super(commandPool);
//	}
//
//	public void load(SwapChainManager swapChain, int queueIndex, DescriptorPool descriptorPool)
//	{
//
//	}
//
//	@Override
//	protected List<ComputeCommandBuffer> allocCommandBuffers()
//	{
//		List<ComputeCommandBuffer> res = new ArrayList<>();
//		long commandPoolId = commandPool.getId();
//
//		long[] commandBufferIds = allocCommandBuffers(commandPoolId, 1);
//
//		ComputeCommandBuffer commandBuffer = new ComputeCommandBuffer(
//				commandPool.getLogicalDevice(), commandBufferIds[0]);
//
//		
//		
//
//		commandBuffer.start();
//		
//		vkCmdBindDescriptorSets(commandBuffer, VK_PIPELINE_BIND_POINT_COMPUTE, pipelineLayout, 0, 1, descriptorSet, 0, NULL);
//
//        /*
//        Calling vkCmdDispatch basically starts the compute pipeline, and executes the compute shader.
//        The number of workgroups is specified in the arguments.
//        If you are already familiar with compute shaders from OpenGL, this should be nothing new to you.
//        */
//        vkCmdDispatch(commandBuffer, (uint32_t)ceil(WIDTH / float(WORKGROUP_SIZE)), (uint32_t)ceil(HEIGHT / float(WORKGROUP_SIZE)), 1);
//
//
//        commandBuffer.end();
//		
//		
//		res.add(commandBuffer);
//
//		return res;
//	}
//}
