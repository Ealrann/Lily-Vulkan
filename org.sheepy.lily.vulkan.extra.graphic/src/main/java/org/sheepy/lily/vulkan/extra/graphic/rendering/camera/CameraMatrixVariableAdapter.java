package org.sheepy.lily.vulkan.extra.graphic.rendering.camera;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.vulkan.api.util.SizeOf;
import org.sheepy.lily.vulkan.extra.api.rendering.ICameraAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraMatrix;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = CameraMatrix.class)
@Adapter
public final class CameraMatrixVariableAdapter extends Notifier<IModelVariableAdapter.Features> implements
																								IModelVariableAdapter<CameraMatrix>
{
	public CameraMatrixVariableAdapter(final IObservatoryBuilder observatory)
	{
		super(List.of(Features.Value));

		observatory.explore(RenderingPackage.CAMERA_MATRIX__CAMERA)
				   .adaptNotifier(ICameraAdapter.class)
				   .listen(matrix -> notify(Features.Value, matrix), ICameraAdapter.Features.CameraMatrix);
	}

	@Override
	public int bytes()
	{
		return SizeOf.MATRIX4F;
	}

	@Override
	public void getValue(final CameraMatrix variable, final ByteBuffer buffer)
	{
		final var adpater = variable.getCamera()
									.adaptNotNull(ICameraAdapter.class);
		adpater.getCameraMatrix()
			   .get(buffer.asFloatBuffer());
		buffer.position(buffer.position() + bytes());
	}

	@Override
	public void setValue(final CameraMatrix variable, final String value)
	{
	}
}
