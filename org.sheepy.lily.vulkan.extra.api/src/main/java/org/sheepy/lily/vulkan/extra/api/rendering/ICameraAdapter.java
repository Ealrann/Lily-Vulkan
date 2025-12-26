package org.sheepy.lily.vulkan.extra.api.rendering;

import org.joml.Matrix4dc;
import org.joml.Vector3dc;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.logoce.lmf.core.api.notification.IFeature;
import org.logoce.lmf.core.api.notification.IFeatures;

import java.util.List;
import java.util.function.Consumer;

public interface ICameraAdapter extends INotifierAdapter<ICameraAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		IFeature<Consumer<Matrix4dc>, Features> CameraMatrix = IFeature.newFeature();
		IFeature<Consumer<Vector3dc>, Features> Position = IFeature.newFeature();
		IFeature<Consumer<Vector3dc>, Features> Direction = IFeature.newFeature();

		List<IFeature<?, ? super Features>> values = List.of(CameraMatrix, Position, Direction);
	}

	Matrix4dc getCameraMatrix();
	Vector3dc getPosition();
	Vector3dc getDirection();

	Vector3dc upDirection();
	float getAspect();
}
