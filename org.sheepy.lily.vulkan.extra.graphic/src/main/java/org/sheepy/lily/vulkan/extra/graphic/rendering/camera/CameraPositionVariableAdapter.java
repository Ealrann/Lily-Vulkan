package org.sheepy.lily.vulkan.extra.graphic.rendering.camera;

import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.variable.IModelVariableAdapter;
import org.sheepy.lily.vulkan.extra.api.rendering.ICameraAdapter;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraPosition;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

import java.nio.ByteBuffer;
import java.util.List;

@ModelExtender(scope = CameraPosition.class)
@Adapter
public final class CameraPositionVariableAdapter extends Notifier<IModelVariableAdapter.Features> implements
																								  IModelVariableAdapter<CameraPosition>
{
	public CameraPositionVariableAdapter(final IObservatoryBuilder observatory)
	{
		super(List.of(Features.Value));

		observatory.explore(RenderingPackage.CAMERA_POSITION__CAMERA)
				   .adaptNotifier(ICameraAdapter.class)
				   .listen(pos -> notify(Features.Value, pos), ICameraAdapter.Features.Position);
	}

	@Override
	public int bytes()
	{
		return 4 * Float.BYTES;
	}

	@Override
	public void getValue(final CameraPosition variable, final ByteBuffer buffer)
	{
		final var adpater = variable.getCamera()
									.adaptNotNull(ICameraAdapter.class);
		final var position = adpater.getPosition();
		buffer.putFloat((float) position.x());
		buffer.putFloat((float) position.y());
		buffer.putFloat((float) position.z());
		buffer.putFloat(0);
	}

	@Override
	public void setValue(final CameraPosition variable, final String value)
	{
	}
}
