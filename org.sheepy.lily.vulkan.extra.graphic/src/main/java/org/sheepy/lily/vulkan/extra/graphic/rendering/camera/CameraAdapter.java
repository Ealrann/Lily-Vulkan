package org.sheepy.lily.vulkan.extra.graphic.rendering.camera;

import org.sheepy.lily.vulkan.extra.api.rendering.ICameraAdapter;
import org.joml.Matrix4d;
import org.joml.Matrix4dc;
import org.joml.Vector3d;
import org.joml.Vector3dc;
import org.logoce.adapter.api.Adapter;
import org.logoce.extender.api.ModelExtender;
import org.logoce.notification.api.Notifier;
import org.sheepy.lily.core.api.adapter.Load;
import org.sheepy.lily.core.api.adapter.NotifyChanged;
import org.sheepy.lily.core.api.cadence.AutoLoad;
import org.sheepy.lily.core.api.notification.observatory.IObservatoryBuilder;
import org.sheepy.lily.core.api.util.ModelUtil;
import org.sheepy.lily.core.model.application.ApplicationPackage;
import org.sheepy.lily.core.model.application.Scene;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingPackage;

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
						 .getScene();

		observatory.listenNoParam(this::updateProjection, RenderingPackage.CAMERA__ZNEAR)
				   .listenNoParam(this::updateProjection, RenderingPackage.CAMERA__ZFAR);
		observatory.focus(scene)
				   .listenNoParam(this::updateProjection, ApplicationPackage.SCENE__SIZE);
		observatory.listenNoParam(this::updateLocation, RenderingPackage.CAMERA__POSITION)
				   .listenNoParam(this::updateLocation, RenderingPackage.CAMERA__AXIS)
				   .listenNoParam(this::updateLocation, RenderingPackage.CAMERA__LOOK_DIRECTION);
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
		position = new Vector3d(camera.getPosition());
		lookDirection = camera.getLookDirection();
		final var axis = camera.getAxis();
		if (axis != null)
		{
			upDirection = axis.getUpDirection();
		}

		notify(Features.Position, position);
		notify(Features.Direction, lookDirection);
	}

	@NotifyChanged(featureIds = RenderingPackage.CAMERA__FIELD_OF_VIEW)
	public void updateProjection()
	{
		final var size = scene.getSize();
		final float fovy = (float) Math.toRadians(camera.getFieldOfView());
		final float width = size.x();
		final float height = size.y();
		final float zNear = camera.getZNear();
		final float zFar = camera.getZFar();
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
