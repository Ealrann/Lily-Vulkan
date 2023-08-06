package org.sheepy.lily.vulkan.extra.graphic.rendering.camera;

import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Vector4d;
import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.vulkan.api.util.SizeOf;
import org.sheepy.lily.vulkan.extra.api.rendering.ICameraAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = CameraScreenWorldPosition.class)
@Adapter
public final class CameraScreenWorldPositionVariableAdapter extends Notifier<IModelVariableAdapter.Features> implements
																											 IModelVariableAdapter<CameraScreenWorldPosition>
{
	private static final int BYTES = 4 * SizeOf.VECTOR4F;

	private final CameraScreenWorldPosition variable;

	private final Vector4d topLeft = new Vector4d();
	private final Vector4d topRight = new Vector4d();
	private final Vector4d bottomLeft = new Vector4d();
	private final Vector4d bottomRight = new Vector4d();

	private CameraScreenWorldPositionVariableAdapter(final CameraScreenWorldPosition variable,
													 final IObservatoryBuilder observatory)
	{
		super(List.of(Features.Value));
		this.variable = variable;

		observatory.explore(RenderingPackage.CAMERA_SCREEN_WORLD_POSITION__CAMERA)
				   .adaptNotifier(ICameraAdapter.class)
				   .listen(this::update, ICameraAdapter.Features.CameraMatrix);
	}

	@Load
	private void load()
	{
		final var cameraAdapter = variable.getCamera()
										  .adaptNotNull(ICameraAdapter.class);
		update(cameraAdapter.getCameraMatrix());
	}

	@Override
	public int bytes()
	{
		return BYTES;
	}

	public void update(final Matrix4dc cameraMatrix)
	{
		final var invMatrix = cameraMatrix.invert(new Matrix4d());
		final double z = 0;
		final double w = 1;

		topLeft.set(-1, -1, z, w);
		topRight.set(1, -1, z, w);
		bottomLeft.set(-1, 1, z, w);
		bottomRight.set(1, 1, z, w);

		toWorldSpace(topLeft, invMatrix);
		toWorldSpace(topRight, invMatrix);
		toWorldSpace(bottomLeft, invMatrix);
		toWorldSpace(bottomRight, invMatrix);

		notify(Features.Value, new Vector4d[]{topLeft, topRight, bottomLeft, bottomRight});
	}

	@Override
	public void getValue(final CameraScreenWorldPosition variable, final ByteBuffer buffer)
	{
		topLeft.getf(buffer);
		buffer.position(buffer.position() + SizeOf.VECTOR4F);

		topRight.getf(buffer);
		buffer.position(buffer.position() + SizeOf.VECTOR4F);

		bottomLeft.getf(buffer);
		buffer.position(buffer.position() + SizeOf.VECTOR4F);

		bottomRight.getf(buffer);
		buffer.position(buffer.position() + SizeOf.VECTOR4F);
	}

	@Override
	public void setValue(final CameraScreenWorldPosition variable, final String value)
	{
	}

	private static void toWorldSpace(Vector4d screenPoint, Matrix4d invMatrix)
	{
		screenPoint.mul(invMatrix);
		final double invW = 1 / screenPoint.w;
		screenPoint.mul(invW);
		screenPoint.w = invW;
	}
}
