package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraPosition;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class CameraPositionImpl extends FeaturedObject<CameraPosition.Features<?>> implements CameraPosition {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<CameraPosition.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private Camera camera;

  public CameraPositionImpl(final String name, final Camera camera) {
    this.name = name;
    this.camera = camera;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CameraPosition.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public Camera camera() {
    return camera;
  }

  @Override
  public void camera(final Camera camera) {
    final var oldValue = this.camera;
    final var eventType = camera == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.camera = camera;
    notifier.notify(CameraPosition.FeatureIDs.CAMERA, false, false, eventType, oldValue, camera);
  }

  @Override
  public Group<CameraPosition> lmGroup() {
    return RenderingModelDefinition.Groups.CAMERA_POSITION;
  }

  @Override
  protected FeatureSetter<CameraPosition> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CameraPosition> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CameraPosition.FeatureIDs.NAME -> 0;
      case CameraPosition.FeatureIDs.CAMERA -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CameraPosition> GET_MAP = new FeatureGetter.Builder<CameraPosition>(FEATURE_COUNT, CameraPositionImpl::featureIndexStatic).add(CameraPosition.FeatureIDs.NAME, CameraPosition::name).add(CameraPosition.FeatureIDs.CAMERA, CameraPosition::camera).build();
    private static final FeatureSetter<CameraPosition> SET_MAP = new FeatureSetter.Builder<CameraPosition>(FEATURE_COUNT, CameraPositionImpl::featureIndexStatic).add(CameraPosition.FeatureIDs.CAMERA, (object, value) -> ((CameraPositionImpl) object).camera((Camera) value)).build();
  }
}
