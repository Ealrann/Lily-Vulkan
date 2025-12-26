package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraScreenWorldPosition;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class CameraScreenWorldPositionImpl extends FeaturedObject<CameraScreenWorldPosition.Features<?>> implements CameraScreenWorldPosition {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<CameraScreenWorldPosition.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private Camera camera;

  public CameraScreenWorldPositionImpl(final String name, final Camera camera) {
    this.name = name;
    this.camera = camera;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CameraScreenWorldPosition.Features<?>> notifier() {
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
    notifier.notify(CameraScreenWorldPosition.FeatureIDs.CAMERA, false, false, eventType, oldValue, camera);
  }

  @Override
  public Group<CameraScreenWorldPosition> lmGroup() {
    return RenderingModelDefinition.Groups.CAMERA_SCREEN_WORLD_POSITION;
  }

  @Override
  protected FeatureSetter<CameraScreenWorldPosition> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CameraScreenWorldPosition> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CameraScreenWorldPosition.FeatureIDs.NAME -> 0;
      case CameraScreenWorldPosition.FeatureIDs.CAMERA -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CameraScreenWorldPosition> GET_MAP = new FeatureGetter.Builder<CameraScreenWorldPosition>(FEATURE_COUNT, CameraScreenWorldPositionImpl::featureIndexStatic).add(CameraScreenWorldPosition.FeatureIDs.NAME, CameraScreenWorldPosition::name).add(CameraScreenWorldPosition.FeatureIDs.CAMERA, CameraScreenWorldPosition::camera).build();
    private static final FeatureSetter<CameraScreenWorldPosition> SET_MAP = new FeatureSetter.Builder<CameraScreenWorldPosition>(FEATURE_COUNT, CameraScreenWorldPositionImpl::featureIndexStatic).add(CameraScreenWorldPosition.FeatureIDs.CAMERA, (object, value) -> ((CameraScreenWorldPositionImpl) object).camera((Camera) value)).build();
  }
}
