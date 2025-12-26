package org.sheepy.lily.vulkan.extra.graphic.rendering.camera;

import org.sheepy.lily.vulkan.extra.api.rendering.ICameraAdapter;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.logoce.lmf.core.api.adapter.Adapter;
import org.logoce.lmf.core.api.extender.ModelExtender;
import org.logoce.lmf.core.api.notification.Notifier;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.api.adapter.NotifyChanged;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.logoce.lmf.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;

@ModelExtender(scope = Camera.class)
@Adapter
@AutoLoad
public final class CameraAdapter extends Notifier<ICameraAdapter.Features> implements ICameraAdapter
{
	private final Camera camera;
	private final Vector3d tmp = new Vector3d();
	private final Matrix4d cameraMatrix = new Matrix4d();
	private final Scene scene;

	private Vector3d position = new Vector3d();
	private Vector3dc lookDirection = new Vector3d();
	private Vector3dc upDirection = new Vector3d();
	private float aspect;

	private CameraAdapter(final Camera camera, final IObservatoryBuilder observatory)
	{
		super(Features.values);
		this.camera = camera;
		scene = ModelUtil.getApplication(camera)
						 .scene();

		observatory.listenNoParam(this::updateProjection, Camera.FeatureIDs.Z_NEAR)
				   .listenNoParam(this::updateProjection, Camera.FeatureIDs.Z_FAR);
		observatory.focus(scene)
				   .listenNoParam(this::updateProjection, Scene.FeatureIDs.SIZE);
		observatory.listenNoParam(this::updateLocation, Camera.FeatureIDs.LOCATION)
				   .listenNoParam(this::updateLocation, Camera.FeatureIDs.AXIS)
				   .listenNoParam(this::updateLocation, Camera.FeatureIDs.LOOK_DIRECTION);
	}

	@Load
	private void load()
	{
		updateLocation();
	}

	private void updateLocation()
	{
		updatePosition();
		updateProjection();
	}

	private void updatePosition()
	{
		position = new Vector3d(camera.location());
		lookDirection = camera.lookDirection();
		final var axis = camera.axis();
		if (axis != null)
		{
			upDirection = axis.upDirection();
		}

		notify(Features.Position, position);
		notify(Features.Direction, lookDirection);
	}

	@NotifyChanged(featureIds = Camera.FeatureIDs.FIELD_OF_VIEW)
	public void updateProjection()
	{
		final var size = scene.size();
		final float fovy = (float) Math.toRadians(camera.fieldOfView());
		final float width = size.x();
		final float height = size.y();
		final float zNear = camera.zNear();
		final float zFar = camera.zFar();
		aspect = width / height;

		position.add(lookDirection, tmp);

		cameraMatrix.identity();
		cameraMatrix.scale(1, -1, 1);
		cameraMatrix.perspective(fovy, aspect, zNear, zFar, true);
		cameraMatrix.lookAt(position, tmp, upDirection);

		notify(Features.CameraMatrix, cameraMatrix);
	}

	@Override
	public float getAspect()
	{
		return aspect;
	}

	@Override
	public Matrix4dc getCameraMatrix()
	{
		return cameraMatrix;
	}

	@Override
	public Vector3dc getPosition()
	{
		return position;
	}

	@Override
	public Vector3dc getDirection()
	{
		return lookDirection;
	}

	@Override
	public Vector3dc upDirection()
	{
		return upDirection;
	}
}
