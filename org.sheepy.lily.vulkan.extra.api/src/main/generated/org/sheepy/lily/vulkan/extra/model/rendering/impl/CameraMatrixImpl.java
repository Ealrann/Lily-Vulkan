package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraMatrix;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class CameraMatrixImpl extends FeaturedObject<CameraMatrix.Features<?>> implements CameraMatrix {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<CameraMatrix.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private Camera camera;

  public CameraMatrixImpl(final String name, final Camera camera) {
    this.name = name;
    this.camera = camera;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CameraMatrix.Features<?>> notifier() {
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
    notifier.notify(CameraMatrix.FeatureIDs.CAMERA, false, false, eventType, oldValue, camera);
  }

  @Override
  public Group<CameraMatrix> lmGroup() {
    return RenderingModelDefinition.Groups.CAMERA_MATRIX;
  }

  @Override
  protected FeatureSetter<CameraMatrix> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CameraMatrix> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CameraMatrix.FeatureIDs.NAME -> 0;
      case CameraMatrix.FeatureIDs.CAMERA -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CameraMatrix> GET_MAP = new FeatureGetter.Builder<CameraMatrix>(FEATURE_COUNT, CameraMatrixImpl::featureIndexStatic).add(CameraMatrix.FeatureIDs.NAME, CameraMatrix::name).add(CameraMatrix.FeatureIDs.CAMERA, CameraMatrix::camera).build();
    private static final FeatureSetter<CameraMatrix> SET_MAP = new FeatureSetter.Builder<CameraMatrix>(FEATURE_COUNT, CameraMatrixImpl::featureIndexStatic).add(CameraMatrix.FeatureIDs.CAMERA, (object, value) -> ((CameraMatrixImpl) object).camera((Camera) value)).build();
  }
}
