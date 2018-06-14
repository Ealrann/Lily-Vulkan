package org.sheepy.lily.game.vulkan.buffer;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.LongBuffer;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkPipelineLayoutCreateInfo;
import org.sheepy.lily.game.vulkan.descriptor.DescriptorSet;
import org.sheepy.lily.game.vulkan.device.LogicalDevice;
import org.sheepy.lily.game.vulkan.swapchain.SwapChainManager.Extent2D;
import org.sheepy.lily.game.vulkan.util.SizeOf;

public class UniformBufferObject
{
	private static final Vector3f UP_AXIS = new Vector3f(0f, 0f, 1f);
	private static final Vector3f AXIS = new Vector3f(0f, 0f, 1f);
	private static final Vector3f CENTER_LOCATION = new Vector3f(0f);
	private static final Vector3f EYE_LOCATION = new Vector3f(1.5f, 1.5f, 1.5f);
	private static final float RADIANS_90 = (float) Math.toRadians(90f);
	private static final float RADIANS_45 = (float) Math.toRadians(45f);

	public static final int SIZE_OF = SizeOf.MATRIX4F * 3;

	private LogicalDevice logicalDevice;

	private Matrix4f model = new Matrix4f();
	private Matrix4f view = new Matrix4f();
	private Matrix4f proj = new Matrix4f();

	private Buffer buffer;

	public UniformBufferObject(LogicalDevice logicalDevice)
	{
		this.logicalDevice = logicalDevice;
	}

	public void load(DescriptorSet descriptorSet)
	{
		LongBuffer bLayouts = MemoryUtil.memAllocLong(1);
		bLayouts.put(descriptorSet.getLayoutId());
		bLayouts.flip();

		VkPipelineLayoutCreateInfo pipelineLayoutInfo = VkPipelineLayoutCreateInfo.calloc();
		pipelineLayoutInfo.sType(VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO);
		pipelineLayoutInfo.pSetLayouts(bLayouts);

		buffer = Buffer.alloc(logicalDevice, SIZE_OF, VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT,
				VK_MEMORY_PROPERTY_HOST_VISIBLE_BIT | VK_MEMORY_PROPERTY_HOST_COHERENT_BIT);

		update(0);
	}

	private ByteBuffer allocBuffer()
	{
		ByteBuffer res = MemoryUtil.memAlloc(SIZE_OF);
		FloatBuffer fb = res.asFloatBuffer();

		float[] values = new float[48];
		model.get(values, 0);
		view.get(values, 16);
		proj.get(values, 32);

		fb.put(values);

		return res;
	}

	public void update(float time)
	{
		model.identity().rotate((float) (time * -RADIANS_90), AXIS);

		view.identity().lookAt(EYE_LOCATION, CENTER_LOCATION, UP_AXIS);

		Extent2D extent = logicalDevice.getSwapPipeline().getSwapChain().getExtent();

		proj.identity().perspective(RADIANS_45,
				(float) extent.getWidth() / (float) extent.getHeight(), 0.1f, 10f);
		// inverse the y axis
		proj.mul(new Matrix4f().m11(-1f));

		ByteBuffer datas = allocBuffer();
		buffer.fillWithBuffer(datas, SIZE_OF);
		MemoryUtil.memFree(datas);
	}

	public void free()
	{
		buffer.free();
	}

	public long getBufferId()
	{
		return buffer.getId();
	}
}
