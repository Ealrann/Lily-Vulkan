package org.sheepy.vulkan.demo.mesh;

import static org.lwjgl.vulkan.VK10.VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.common.api.types.SVector2i;
import org.sheepy.common.model.application.Application;
import org.sheepy.vulkan.common.util.ModelUtil;
import org.sheepy.vulkan.common.util.SizeOf;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.resource.Buffer;
import org.sheepy.vulkan.model.resource.impl.BufferImpl;
import org.sheepy.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.vulkan.resource.buffer.BufferAllocator;

public class UniformBufferManager
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

	public final Buffer buffer;

	private ByteBuffer stagingBuffer;
	private float[] stagingValues;
	private final BufferAdapter adapter;
	private Application application;

	public UniformBufferManager()
	{
		buffer = createUniformBuffer();
		adapter = BufferAdapter.adapt(buffer);
	}

	private final Buffer createUniformBuffer()
	{
		Buffer res = new BufferImpl();

		res.setSize(SIZE_OF);
		res.setUsage(VK_BUFFER_USAGE_UNIFORM_BUFFER_BIT);
		res.setProperties(BufferAllocator.HOST_VISIBLE);
		res.setDescriptorType(EDescriptorType.UNIFORM_BUFFER);
		res.getShaderStages().add(EShaderStage.VERTEX_BIT);
		res.setChangeable(true);

		stagingBuffer = MemoryUtil.memAlloc(SIZE_OF);
		stagingValues = new float[48];

		return res;
	}

	public void update(float time)
	{
		if (application == null)
		{
			application = ModelUtil.getVulkanApplication(buffer);
		}
		SVector2i size = application.getSize();

		model.identity().rotate(time * -RADIANS_90, AXIS);

		view.identity().lookAt(EYE_LOCATION, CENTER_LOCATION, UP_AXIS);

		final int width = size.getX();
		final int height = size.getY();

		proj.identity().perspective(RADIANS_45, (float) width / (float) height, 0.1f, 10f);
		// inverse the y axis
		proj.mul(new Matrix4f().m11(-1f));

		updateStagingBuffer();

		adapter.pushData(stagingBuffer);
	}

	private void updateStagingBuffer()
	{
		final FloatBuffer fb = stagingBuffer.asFloatBuffer();

		model.get(stagingValues, 0);
		view.get(stagingValues, 16);
		proj.get(stagingValues, 32);

		fb.put(stagingValues);
	}
}
