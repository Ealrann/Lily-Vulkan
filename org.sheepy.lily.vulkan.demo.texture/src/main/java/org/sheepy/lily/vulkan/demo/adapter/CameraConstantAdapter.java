package org.sheepy.lily.vulkan.demo.adapter;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Autorun;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Statefull;
import org.sheepy.lily.core.api.adapter.annotation.Tick;
import org.sheepy.lily.core.model.application.Application;
import org.sheepy.lily.vulkan.api.adapter.IVulkanAdapter;
import org.sheepy.lily.vulkan.api.util.VulkanModelUtil;
import org.sheepy.lily.vulkan.common.util.SizeOf;
import org.sheepy.lily.vulkan.model.resource.ConstantBuffer;

@Statefull
@Adapter(scope = ConstantBuffer.class, name = CameraConstantAdapter.DEMO_CAMERA)
public class CameraConstantAdapter implements IVulkanAdapter
{
	public static final String DEMO_CAMERA = "DemoCameraPushConstant";
	public static final int SIZE_OF = SizeOf.MATRIX4F;

	private static final Vector3f UP_AXIS = new Vector3f(0f, 0f, 1f);
	private static final Vector3f AXIS = new Vector3f(0f, 0f, 1f);
	private static final Vector3f CENTER_LOCATION = new Vector3f(0f);
	private static final Vector3f EYE_LOCATION = new Vector3f(1.5f, 1.5f, 1.5f);
	private static final float RADIANS_STEP = (float) Math.toRadians(0.1);
	private static final float RADIANS_45DEG = (float) Math.toRadians(45f);

	private final Matrix4f model = new Matrix4f();
	private final Matrix4f view = new Matrix4f();
	private final Matrix4f proj = new Matrix4f();
	private final Matrix4f finalMatrix = new Matrix4f();

	private final Application application;

	private double rotation = 0;
	private ByteBuffer stagingBuffer;
	private final ConstantBuffer buffer;

	public CameraConstantAdapter(ConstantBuffer buffer)
	{
		this.buffer = buffer;
		this.application = VulkanModelUtil.getApplication(buffer);
	}

	@Autorun
	public void allocate()
	{
		stagingBuffer = MemoryUtil.memAlloc(SIZE_OF);
	}

	@Dispose
	public void free()
	{
		MemoryUtil.memFree(stagingBuffer);
	}

	@Tick
	public void update()
	{
		rotation += RADIANS_STEP;

		final var size = application.getSize();
		final int width = size.x();
		final int height = size.y();

		model.identity().rotate((float) rotation, AXIS);

		view.identity().lookAt(EYE_LOCATION, CENTER_LOCATION, UP_AXIS);

		proj.identity().perspective(RADIANS_45DEG, (float) width / (float) height, 0.1f, 10f);
		// inverse the y axis
		proj.mul(new Matrix4f().m11(-1f));

		finalMatrix.identity();
		finalMatrix.mul(proj);
		finalMatrix.mul(view);
		finalMatrix.mul(model);

		updateStagingBuffer();
	}

	private void updateStagingBuffer()
	{
		final FloatBuffer fb = stagingBuffer.asFloatBuffer();
		finalMatrix.get(fb);

		buffer.setData(stagingBuffer);
	}
}
