package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;

public final class ViewportImpl extends FeaturedObject<Viewport.Features<?>> implements Viewport {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<Viewport.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int offsetX;
  private int offsetY;
  private int minDepth;
  private int maxDepth;
  private Vector2ic extent;

  public ViewportImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Viewport.Features<?>> notifier() {
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
    notifier.notifyInt(Viewport.FeatureIDs.OFFSETX, false, false, oldValue, offsetX);
  }

  @Override
  public int offsetY() {
    return offsetY;
  }

  @Override
  public void offsetY(final int offsetY) {
    final var oldValue = this.offsetY;
    this.offsetY = offsetY;
    notifier.notifyInt(Viewport.FeatureIDs.OFFSETY, false, false, oldValue, offsetY);
  }

  @Override
  public int minDepth() {
    return minDepth;
  }

  @Override
  public void minDepth(final int minDepth) {
    final var oldValue = this.minDepth;
    this.minDepth = minDepth;
    notifier.notifyInt(Viewport.FeatureIDs.MIN_DEPTH, false, false, oldValue, minDepth);
  }

  @Override
  public int maxDepth() {
    return maxDepth;
  }

  @Override
  public void maxDepth(final int maxDepth) {
    final var oldValue = this.maxDepth;
    this.maxDepth = maxDepth;
    notifier.notifyInt(Viewport.FeatureIDs.MAX_DEPTH, false, false, oldValue, maxDepth);
  }

  @Override
  public Vector2ic extent() {
    return extent;
  }

  @Override
  public void extent(final Vector2ic extent) {
    final var oldValue = this.extent;
    this.extent = extent;
    notifier.notify(Viewport.FeatureIDs.EXTENT, false, false, oldValue, extent);
  }

  @Override
  public Group<Viewport> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.VIEWPORT;
  }

  @Override
  protected FeatureSetter<Viewport> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Viewport> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Viewport.FeatureIDs.OFFSETX -> 0;
      case Viewport.FeatureIDs.OFFSETY -> 1;
      case Viewport.FeatureIDs.MIN_DEPTH -> 2;
      case Viewport.FeatureIDs.MAX_DEPTH -> 3;
      case Viewport.FeatureIDs.EXTENT -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Viewport> GET_MAP = new FeatureGetter.Builder<Viewport>(FEATURE_COUNT, ViewportImpl::featureIndexStatic).add(Viewport.FeatureIDs.OFFSETX, Viewport::offsetX).add(Viewport.FeatureIDs.OFFSETY, Viewport::offsetY).add(Viewport.FeatureIDs.MIN_DEPTH, Viewport::minDepth).add(Viewport.FeatureIDs.MAX_DEPTH, Viewport::maxDepth).add(Viewport.FeatureIDs.EXTENT, Viewport::extent).build();
    private static final FeatureSetter<Viewport> SET_MAP = new FeatureSetter.Builder<Viewport>(FEATURE_COUNT, ViewportImpl::featureIndexStatic).add(Viewport.FeatureIDs.OFFSETX, (object, value) -> ((ViewportImpl) object).offsetX((int) value)).add(Viewport.FeatureIDs.OFFSETY, (object, value) -> ((ViewportImpl) object).offsetY((int) value)).add(Viewport.FeatureIDs.MIN_DEPTH, (object, value) -> ((ViewportImpl) object).minDepth((int) value)).add(Viewport.FeatureIDs.MAX_DEPTH, (object, value) -> ((ViewportImpl) object).maxDepth((int) value)).add(Viewport.FeatureIDs.EXTENT, (object, value) -> ((ViewportImpl) object).extent((Vector2ic) value)).build();
  }
}
