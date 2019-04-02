package org.sheepy.lily.vulkan.demo.adapter;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.joml.Matrix4f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.common.util.ModelUtil;
import org.sheepy.lily.vulkan.common.util.SizeOf;
import org.sheepy.lily.vulkan.demo.mesh.MeshModelFactory;
import org.sheepy.lily.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.lily.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.lily.vulkan.model.enumeration.EShaderStage;
import org.sheepy.lily.vulkan.model.resource.Buffer;
import org.sheepy.lily.vulkan.resource.buffer.BufferAdapter;

@Statefull
@Adapter(scope = Buffer.class, name = MeshModelFactory.MESH_UNIFORM_BUFFER_NAME)
public class UniformBufferAdapter extends BufferAdapter
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

	private final ByteBuffer stagingBuffer;
	private Application application;

	private long timeNs = 0;

	public UniformBufferAdapter(Buffer buffer)
	{
		super(buffer);

		buffer.setSize(SIZE_OF);
		buffer.getUsages().add(EBufferUsage.UNIFORM_BUFFER_BIT);
		buffer.setDescriptorType(EDescriptorType.UNIFORM_BUFFER);
		buffer.getShaderStages().add(EShaderStage.VERTEX_BIT);
		buffer.setGpuBuffer(false);
		buffer.setOftenUpdated(true);

		stagingBuffer = MemoryUtil.memAlloc(SIZE_OF);
	}

	@Dispose
	public void dispose()
	{
		MemoryUtil.memFree(stagingBuffer);
	}

	@Tick
	public void update(Buffer buffer, long stepNs)
	{
		if (application == null)
		{
			application = ModelUtil.getApplication(buffer);
		}
		final Vector2i size = application.getSize();

		timeNs += stepNs;
		final float step = timeNs / 1e12f;
		model.identity().rotate(step * -RADIANS_90, AXIS);

		view.identity().lookAt(EYE_LOCATION, CENTER_LOCATION, UP_AXIS);

		final int width = size.x;
		final int height = size.y;

		proj.identity().perspective(RADIANS_45, (float) width / (float) height, 0.1f, 10f);
		// inverse the y axis
		proj.mul(new Matrix4f().m11(-1f));

		updateStagingBuffer();

		pushData(stagingBuffer);
	}

	private void updateStagingBuffer()
	{
		final FloatBuffer fb = stagingBuffer.asFloatBuffer();

		model.get(fb.position(0));
		view.get(fb.position(16));
		proj.get(fb.position(32));
	}
}
