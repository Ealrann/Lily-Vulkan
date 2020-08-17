package org.sheepy.lily.vulkan.demo.adapter;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.system.MemoryUtil;
import org.sheepy.lily.core.api.adapter.annotation.Adapter;
import org.sheepy.lily.core.api.adapter.annotation.Dispose;
import org.sheepy.lily.core.api.adapter.annotation.Load;
import org.sheepy.lily.core.api.cadence.Tick;
import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.ModelExtender;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.vulkan.api.util.SizeOf;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

@ModelExtender(scope = ConstantBuffer.class, name = CameraConstantAdapter.DEMO_CAMERA)
@Adapter(lazy = false)
public class CameraConstantAdapter implements IExtender
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

	private final Scene scene;

	private double rotation = 0;
	private ByteBuffer stagingBuffer;
	private final ConstantBuffer buffer;

	public CameraConstantAdapter(ConstantBuffer buffer)
	{
		this.buffer = buffer;
		this.scene = ModelUtil.getApplication(buffer).getScene();
	}

	@Load
	public void allocate()
	{
		stagingBuffer = MemoryUtil.memAlloc(SIZE_OF);
	}

	@Dispose
	public void free()
	{
		MemoryUtil.memFree(stagingBuffer);
		stagingBuffer = null;
	}

	@Tick
	public void update()
	{
		rotation += RADIANS_STEP;

		final var size = scene.getSize();
		final int width = size.x();
		final int height = size.y();

		model.identity().rotate((float) rotation, AXIS);

		view.identity().lookAt(EYE_LOCATION, CENTER_LOCATION, UP_AXIS);

		proj.identity();
		proj.scale(1, -1, 1);
		proj.perspective(RADIANS_45DEG, (float) width / (float) height, 0.1f, 10f, true);

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
