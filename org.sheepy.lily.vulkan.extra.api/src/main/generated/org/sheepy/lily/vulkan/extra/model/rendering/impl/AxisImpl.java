package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import org.joml.Vector3dc;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.Axis;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class AxisImpl extends FeaturedObject<Axis.Features<?>> implements Axis {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<Axis.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Vector3dc frontDirection;
  private Vector3dc upDirection;
  private Vector3dc rightDirection;

  public AxisImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Axis.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Vector3dc frontDirection() {
    return frontDirection;
  }

  @Override
  public void frontDirection(final Vector3dc frontDirection) {
    final var oldValue = this.frontDirection;
    this.frontDirection = frontDirection;
    notifier.notify(Axis.FeatureIDs.FRONT_DIRECTION, false, false, oldValue, frontDirection);
  }

  @Override
  public Vector3dc upDirection() {
    return upDirection;
  }

  @Override
  public void upDirection(final Vector3dc upDirection) {
    final var oldValue = this.upDirection;
    this.upDirection = upDirection;
    notifier.notify(Axis.FeatureIDs.UP_DIRECTION, false, false, oldValue, upDirection);
  }

  @Override
  public Vector3dc rightDirection() {
    return rightDirection;
  }

  @Override
  public void rightDirection(final Vector3dc rightDirection) {
    final var oldValue = this.rightDirection;
    this.rightDirection = rightDirection;
    notifier.notify(Axis.FeatureIDs.RIGHT_DIRECTION, false, false, oldValue, rightDirection);
  }

  @Override
  public Group<Axis> lmGroup() {
    return RenderingModelDefinition.Groups.AXIS;
  }

  @Override
  protected FeatureSetter<Axis> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Axis> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Axis.FeatureIDs.FRONT_DIRECTION -> 0;
      case Axis.FeatureIDs.UP_DIRECTION -> 1;
      case Axis.FeatureIDs.RIGHT_DIRECTION -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Axis> GET_MAP = new FeatureGetter.Builder<Axis>(FEATURE_COUNT, AxisImpl::featureIndexStatic).add(Axis.FeatureIDs.FRONT_DIRECTION, Axis::frontDirection).add(Axis.FeatureIDs.UP_DIRECTION, Axis::upDirection).add(Axis.FeatureIDs.RIGHT_DIRECTION, Axis::rightDirection).build();
    private static final FeatureSetter<Axis> SET_MAP = new FeatureSetter.Builder<Axis>(FEATURE_COUNT, AxisImpl::featureIndexStatic).add(Axis.FeatureIDs.FRONT_DIRECTION, (object, value) -> ((AxisImpl) object).frontDirection((Vector3dc) value)).add(Axis.FeatureIDs.UP_DIRECTION, (object, value) -> ((AxisImpl) object).upDirection((Vector3dc) value)).add(Axis.FeatureIDs.RIGHT_DIRECTION, (object, value) -> ((AxisImpl) object).rightDirection((Vector3dc) value)).build();
  }
}
