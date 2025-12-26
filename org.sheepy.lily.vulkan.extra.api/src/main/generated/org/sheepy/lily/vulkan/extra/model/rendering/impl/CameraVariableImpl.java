package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.Camera;
import org.sheepy.lily.vulkan.extra.model.rendering.CameraVariable;
import org.sheepy.lily.vulkan.extra.model.rendering.ECameraField;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class CameraVariableImpl extends FeaturedObject<CameraVariable.Features<?>> implements CameraVariable {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<CameraVariable.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private Camera camera;
  private ECameraField field;

  public CameraVariableImpl(final String name, final Camera camera, final ECameraField field) {
    this.name = name;
    this.camera = camera;
    this.field = field;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CameraVariable.Features<?>> notifier() {
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
    notifier.notify(CameraVariable.FeatureIDs.CAMERA, false, false, eventType, oldValue, camera);
  }

  @Override
  public ECameraField field() {
    return field;
  }

  @Override
  public void field(final ECameraField field) {
    final var oldValue = this.field;
    this.field = field;
    notifier.notify(CameraVariable.FeatureIDs.FIELD, false, false, oldValue, field);
  }

  @Override
  public Group<CameraVariable> lmGroup() {
    return RenderingModelDefinition.Groups.CAMERA_VARIABLE;
  }

  @Override
  protected FeatureSetter<CameraVariable> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CameraVariable> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CameraVariable.FeatureIDs.NAME -> 0;
      case CameraVariable.FeatureIDs.CAMERA -> 1;
      case CameraVariable.FeatureIDs.FIELD -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CameraVariable> GET_MAP = new FeatureGetter.Builder<CameraVariable>(FEATURE_COUNT, CameraVariableImpl::featureIndexStatic).add(CameraVariable.FeatureIDs.NAME, CameraVariable::name).add(CameraVariable.FeatureIDs.CAMERA, CameraVariable::camera).add(CameraVariable.FeatureIDs.FIELD, CameraVariable::field).build();
    private static final FeatureSetter<CameraVariable> SET_MAP = new FeatureSetter.Builder<CameraVariable>(FEATURE_COUNT, CameraVariableImpl::featureIndexStatic).add(CameraVariable.FeatureIDs.CAMERA, (object, value) -> ((CameraVariableImpl) object).camera((Camera) value)).add(CameraVariable.FeatureIDs.FIELD, (object, value) -> ((CameraVariableImpl) object).field((ECameraField) value)).build();
  }
}
