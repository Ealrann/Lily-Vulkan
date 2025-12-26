package org.sheepy.lily.vulkan.extra.graphic.rendering.camera;

import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.Notifier;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.vulkan.api.util.SizeOf;
import org.sheepy.lily.vulkan.extra.api.rendering.ICameraAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraMatrix;

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

		observatory.explore(CameraMatrix.FeatureIDs.CAMERA)
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
		final var adpater = variable.camera()
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
