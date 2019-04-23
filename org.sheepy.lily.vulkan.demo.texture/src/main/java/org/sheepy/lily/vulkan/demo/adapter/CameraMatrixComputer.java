package org.sheepy.lily.vulkan.demo.adapter;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.joml.Matrix4f;
import org.joml.Vector2i;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryStack;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.common.util.SizeOf;
import org.sheepy.vulkan.allocation.IAllocable;
import org.sheepy.vulkan.allocation.IAllocationContext;
import org.sheepy.vulkan.execution.IExecutionContext;
import org.sheepy.vulkan.resource.buffer.GPUBufferBackend;

public class CameraMatrixComputer implements IAllocable
{
	public static final int SIZE_OF = SizeOf.MATRIX4F * 3;

	private static final Vector3f UP_AXIS = new Vector3f(0f, 0f, 1f);
	private static final Vector3f AXIS = new Vector3f(0f, 0f, 1f);
	private static final Vector3f CENTER_LOCATION = new Vector3f(0f);
	private static final Vector3f EYE_LOCATION = new Vector3f(1.5f, 1.5f, 1.5f);
	private static final float RADIANS_STEP = (float) Math.toRadians(0.1);
	private static final float RADIANS_45DEG = (float) Math.toRadians(45f);

	private final Matrix4f model = new Matrix4f();
	private final Matrix4f view = new Matrix4f();
	private final Matrix4f proj = new Matrix4f();

	private final Application application;
	private final GPUBufferBackend uniformBuffer;

	private double rotation = 0;
	private ByteBuffer stagingBuffer;

	public CameraMatrixComputer(Application application, GPUBufferBackend uniformBuffer)
	{
		this.uniformBuffer = uniformBuffer;
		this.application = application;
	}

	@Override
	public void allocate(MemoryStack stack, IAllocationContext context)
	{
		stagingBuffer = MemoryUtil.memAlloc(SIZE_OF);
	}

	@Override
	public void free(IAllocationContext context)
	{
		MemoryUtil.memFree(stagingBuffer);
	}

	public void update(IExecutionContext executionContext)
	{
		rotation += RADIANS_STEP;

		final Vector2i size = application.getSize();

		model.identity().rotate((float) rotation, AXIS);

		view.identity().lookAt(EYE_LOCATION, CENTER_LOCATION, UP_AXIS);

		final int width = size.x;
		final int height = size.y;

		proj.identity().perspective(RADIANS_45DEG, (float) width / (float) height, 0.1f, 10f);
		// inverse the y axis
		proj.mul(new Matrix4f().m11(-1f));

		updateStagingBuffer();

		uniformBuffer.pushData(executionContext, stagingBuffer);
	}

	private void updateStagingBuffer()
	{
		final FloatBuffer fb = stagingBuffer.asFloatBuffer();

		model.get(fb.position(0));
		view.get(fb.position(16));
		proj.get(fb.position(32));
	}

	@Override
	public boolean isAllocationDirty(IAllocationContext context)
	{
		return false;
	}
}
