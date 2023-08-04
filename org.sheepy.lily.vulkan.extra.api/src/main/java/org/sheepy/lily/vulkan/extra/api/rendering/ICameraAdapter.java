package org.sheepy.lily.vulkan.extra.api.rendering;

import org.joml.Matrix4dc;
import org.joml.Vector3dc;
import org.sheepy.lily.core.api.adapter.INotifierAdapter;
import org.logoce.notification.api.Feature;
import org.logoce.notification.api.IFeatures;

import java.util.List;
import java.util.function.Consumer;

public interface ICameraAdapter extends INotifierAdapter<ICameraAdapter.Features>
{
	interface Features extends IFeatures<Features>
	{
		Feature<Consumer<Matrix4dc>, Features> CameraMatrix = Feature.newFeature();
		Feature<Consumer<Vector3dc>, Features> Position = Feature.newFeature();
		Feature<Consumer<Vector3dc>, Features> Direction = Feature.newFeature();

		List<Feature<?, ? super Features>> values = List.of(CameraMatrix, Position, Direction);
	}

	Matrix4dc getCameraMatrix();
	Vector3dc getPosition();
	Vector3dc getDirection();

	Vector3dc upDirection();
	float getAspect();
}
