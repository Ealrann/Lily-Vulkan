package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;

public final class ScissorImpl extends FeaturedObject<Scissor.Features<?>> implements Scissor {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<Scissor.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int offsetX;
  private int offsetY;
  private Vector2ic extent;

  public ScissorImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Scissor.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int offsetX() {
    return offsetX;
  }

  @Override
  public void offsetX(final int offsetX) {
    final var oldValue = this.offsetX;
    this.offsetX = offsetX;
    notifier.notifyInt(Scissor.FeatureIDs.OFFSETX, false, false, oldValue, offsetX);
  }

  @Override
  public int offsetY() {
    return offsetY;
  }

  @Override
  public void offsetY(final int offsetY) {
    final var oldValue = this.offsetY;
    this.offsetY = offsetY;
    notifier.notifyInt(Scissor.FeatureIDs.OFFSETY, false, false, oldValue, offsetY);
  }

  @Override
  public Vector2ic extent() {
    return extent;
  }

  @Override
  public void extent(final Vector2ic extent) {
    final var oldValue = this.extent;
    this.extent = extent;
    notifier.notify(Scissor.FeatureIDs.EXTENT, false, false, oldValue, extent);
  }

  @Override
  public Group<Scissor> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.SCISSOR;
  }

  @Override
  protected FeatureSetter<Scissor> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Scissor> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Scissor.FeatureIDs.OFFSETX -> 0;
      case Scissor.FeatureIDs.OFFSETY -> 1;
      case Scissor.FeatureIDs.EXTENT -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Scissor> GET_MAP = new FeatureGetter.Builder<Scissor>(FEATURE_COUNT, ScissorImpl::featureIndexStatic).add(Scissor.FeatureIDs.OFFSETX, Scissor::offsetX).add(Scissor.FeatureIDs.OFFSETY, Scissor::offsetY).add(Scissor.FeatureIDs.EXTENT, Scissor::extent).build();
    private static final FeatureSetter<Scissor> SET_MAP = new FeatureSetter.Builder<Scissor>(FEATURE_COUNT, ScissorImpl::featureIndexStatic).add(Scissor.FeatureIDs.OFFSETX, (object, value) -> ((ScissorImpl) object).offsetX((int) value)).add(Scissor.FeatureIDs.OFFSETY, (object, value) -> ((ScissorImpl) object).offsetY((int) value)).add(Scissor.FeatureIDs.EXTENT, (object, value) -> ((ScissorImpl) object).extent((Vector2ic) value)).build();
  }
}
