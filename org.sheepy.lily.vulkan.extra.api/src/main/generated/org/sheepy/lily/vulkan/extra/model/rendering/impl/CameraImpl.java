package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.joml.Vector3dc;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class CameraImpl extends FeaturedObject<Camera.Features<?>> implements Camera {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<Camera.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private float fieldOfView;
  private float zNear;
  private float zFar;
  private Vector3dc location;
  private Axis axis;
  private Vector3dc lookDirection;

  public CameraImpl(final String name, final float fieldOfView, final float zNear, final float zFar,
      final Axis axis) {
    this.name = name;
    this.fieldOfView = fieldOfView;
    this.zNear = zNear;
    this.zFar = zFar;
    this.axis = axis;
    setContainer(axis, Camera.FeatureIDs.AXIS);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Camera.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public float fieldOfView() {
    return fieldOfView;
  }

  @Override
  public void fieldOfView(final float fieldOfView) {
    final var oldValue = this.fieldOfView;
    this.fieldOfView = fieldOfView;
    notifier.notifyFloat(Camera.FeatureIDs.FIELD_OF_VIEW, false, false, oldValue, fieldOfView);
  }

  @Override
  public float zNear() {
    return zNear;
  }

  @Override
  public void zNear(final float zNear) {
    final var oldValue = this.zNear;
    this.zNear = zNear;
    notifier.notifyFloat(Camera.FeatureIDs.Z_NEAR, false, false, oldValue, zNear);
  }

  @Override
  public float zFar() {
    return zFar;
  }

  @Override
  public void zFar(final float zFar) {
    final var oldValue = this.zFar;
    this.zFar = zFar;
    notifier.notifyFloat(Camera.FeatureIDs.Z_FAR, false, false, oldValue, zFar);
  }

  @Override
  public Vector3dc location() {
    return location;
  }

  @Override
  public void location(final Vector3dc location) {
    final var oldValue = this.location;
    this.location = location;
    notifier.notify(Camera.FeatureIDs.LOCATION, false, false, oldValue, location);
  }

  @Override
  public Axis axis() {
    return axis;
  }

  @Override
  public void axis(final Axis axis) {
    final var oldValue = this.axis;
    final var eventType = axis == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.axis = axis;
    setContainer(axis, Camera.FeatureIDs.AXIS);
    beforeContainmentNotify(eventType, oldValue, axis);
    notifier.notify(Camera.FeatureIDs.AXIS, true, false, eventType, oldValue, axis);
    afterContainmentNotify(eventType, oldValue, axis);
  }

  @Override
  public Vector3dc lookDirection() {
    return lookDirection;
  }

  @Override
  public void lookDirection(final Vector3dc lookDirection) {
    final var oldValue = this.lookDirection;
    this.lookDirection = lookDirection;
    notifier.notify(Camera.FeatureIDs.LOOK_DIRECTION, false, false, oldValue, lookDirection);
  }

  @Override
  public Group<Camera> lmGroup() {
    return RenderingModelDefinition.Groups.CAMERA;
  }

  @Override
  protected FeatureSetter<Camera> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Camera> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Camera.FeatureIDs.NAME -> 0;
      case Camera.FeatureIDs.FIELD_OF_VIEW -> 1;
      case Camera.FeatureIDs.Z_NEAR -> 2;
      case Camera.FeatureIDs.Z_FAR -> 3;
      case Camera.FeatureIDs.LOCATION -> 4;
      case Camera.FeatureIDs.AXIS -> 5;
      case Camera.FeatureIDs.LOOK_DIRECTION -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Camera> GET_MAP = new FeatureGetter.Builder<Camera>(FEATURE_COUNT, CameraImpl::featureIndexStatic).add(Camera.FeatureIDs.NAME, Camera::name).add(Camera.FeatureIDs.FIELD_OF_VIEW, Camera::fieldOfView).add(Camera.FeatureIDs.Z_NEAR, Camera::zNear).add(Camera.FeatureIDs.Z_FAR, Camera::zFar).add(Camera.FeatureIDs.LOCATION, Camera::location).add(Camera.FeatureIDs.AXIS, Camera::axis).add(Camera.FeatureIDs.LOOK_DIRECTION, Camera::lookDirection).build();
    private static final FeatureSetter<Camera> SET_MAP = new FeatureSetter.Builder<Camera>(FEATURE_COUNT, CameraImpl::featureIndexStatic).add(Camera.FeatureIDs.FIELD_OF_VIEW, (object, value) -> ((CameraImpl) object).fieldOfView((float) value)).add(Camera.FeatureIDs.Z_NEAR, (object, value) -> ((CameraImpl) object).zNear((float) value)).add(Camera.FeatureIDs.Z_FAR, (object, value) -> ((CameraImpl) object).zFar((float) value)).add(Camera.FeatureIDs.LOCATION, (object, value) -> ((CameraImpl) object).location((Vector3dc) value)).add(Camera.FeatureIDs.AXIS, (object, value) -> ((CameraImpl) object).axis((Axis) value)).add(Camera.FeatureIDs.LOOK_DIRECTION, (object, value) -> ((CameraImpl) object).lookDirection((Vector3dc) value)).build();
  }
}
