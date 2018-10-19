package test.vulkan.mesh;

import static org.lwjgl.vulkan.VK10.*;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.lwjgl.vulkan.VkDescriptorBufferInfo;
import org.lwjgl.vulkan.VkDescriptorPoolSize;
import org.lwjgl.vulkan.VkDescriptorSetLayoutBinding;
import org.lwjgl.vulkan.VkWriteDescriptorSet;
import org.sheepy.vulkan.adapter.VulkanAdapterFactoryImpl;
import org.sheepy.vulkan.demo.model.UniformBuffer;
import org.sheepy.vulkan.execution.IExecutionManagerAdapter;
import org.sheepy.vulkan.model.VulkanApplication;
import org.sheepy.vulkan.resource.ResourceAdapter;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;
import org.sheepy.vulkan.resource.buffer.StandaloneBuffer;
import org.sheepy.vulkan.resource.descriptor.IDescriptorAdapter;
import org.sheepy.vulkan.util.SizeOf;

public class UniformBufferAdapter extends ResourceAdapter implements IDescriptorAdapter
{
	private static final Vector3f UP_AXIS = new Vector3f(0f, 0f, 1f);
	private static final Vector3f AXIS = new Vector3f(0f, 0f, 1f);
	private static final Vector3f CENTER_LOCATION = new Vector3f(0f);
	private static final Vector3f EYE_LOCATION = new Vector3f(1.5f, 1.5f, 1.5f);
	private static final float RADIANS_90 = (float) Math.toRadians(90f);
	private static final float RADIANS_45 = (float) Math.toRadians(45f);

	public static final int SIZE_OF = SizeOf.MATRIX4F * 3;

	private final Matrix4f model = new Matrix4f();
	private final Matrix4f view = new Matrix4f();
	private final Matrix4f proj = new Matrix4f();

	private StandaloneBuffer buffer;
	private ByteBuffer stagingBuffer;
	private float[] stagingValues;

	@Override
	public void flatAllocate(MemoryStack stack)
	{
		final var context = IExecutionManagerAdapter.adapt(target).getExecutionManager();

		stagingBuffer = MemoryUtil.memAlloc(SIZE_OF);
		stagingValues = new float[48];

		buffer = BufferAllocator.allocateCPUBuffer(stack, context.getLogicalDevice(), SIZE_OF,
				VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT);
	}

	private void updateStagingBuffer()
	{
		final FloatBuffer fb = stagingBuffer.asFloatBuffer();

		model.get(stagingValues, 0);
		view.get(stagingValues, 16);
		proj.get(stagingValues, 32);

		fb.put(stagingValues);
	}

	public void update(float time)
	{
		final var uniformBuffer = (UniformBuffer) target;
		final var application = (VulkanApplication) uniformBuffer.eContainer().eContainer();
		final var size = application.getSize();

		model.identity().rotate(time * -RADIANS_90, AXIS);

		view.identity().lookAt(EYE_LOCATION, CENTER_LOCATION, UP_AXIS);

		final int width = size.getX();
		final int height = size.getY();

		proj.identity().perspective(RADIANS_45, (float) width / (float) height, 0.1f, 10f);
		// inverse the y axis
		proj.mul(new Matrix4f().m11(-1f));

		updateStagingBuffer();

		buffer.fillWithBuffer(stagingBuffer);
	}

	@Override
	public void free()
	{
		buffer.free();
		MemoryUtil.memFree(stagingBuffer);
	}

	public long getBufferId()
	{
		return buffer.getId();
	}

	@Override
	public VkDescriptorSetLayoutBinding allocLayoutBinding(MemoryStack stack)
	{
		final VkDescriptorSetLayoutBinding res = VkDescriptorSetLayoutBinding.callocStack(stack);
		res.descriptorType(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
		res.descriptorCount(1);
		res.stageFlags(VK_SHADER_STAGE_VERTEX_BIT);

		return res;
	}

	@Override
	public VkWriteDescriptorSet allocWriteDescriptor(MemoryStack stack)
	{
		final VkDescriptorBufferInfo.Buffer bufferInfos = VkDescriptorBufferInfo.callocStack(1,
				stack);
		bufferInfos.buffer(getBufferId());
		bufferInfos.offset(0);
		bufferInfos.range(SIZE_OF);

		final VkWriteDescriptorSet descriptorWrite = VkWriteDescriptorSet.callocStack(stack);
		descriptorWrite.sType(VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET);
		descriptorWrite.dstArrayElement(0);
		descriptorWrite.descriptorType(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
		descriptorWrite.pBufferInfo(bufferInfos);
		descriptorWrite.pImageInfo(null); // Optional
		descriptorWrite.pTexelBufferView(null); // Optional
		return descriptorWrite;
	}

	@Override
	public VkDescriptorPoolSize allocPoolSize(MemoryStack stack)
	{
		final VkDescriptorPoolSize poolSize = VkDescriptorPoolSize.callocStack(stack);
		poolSize.type(VK_DESCRIPTOR_TYPE_UNIFORM_BUFFER);
		poolSize.descriptorCount(1);
		return poolSize;
	}

	public static UniformBufferAdapter adapt(UniformBuffer buffer)
	{
		return VulkanAdapterFactoryImpl.INSTANCE.adapt(buffer, UniformBufferAdapter.class);
	}
}
