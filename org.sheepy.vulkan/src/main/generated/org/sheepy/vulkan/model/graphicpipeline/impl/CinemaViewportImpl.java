package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.graphicpipeline.CinemaViewport;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;

public final class CinemaViewportImpl extends FeaturedObject<CinemaViewport.Features<?>> implements CinemaViewport {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<CinemaViewport.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private float aspectRatio;
  private int minDepth;
  private int maxDepth;

  public CinemaViewportImpl(final float aspectRatio) {
    this.aspectRatio = aspectRatio;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CinemaViewport.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public float aspectRatio() {
    return aspectRatio;
  }

  @Override
  public void aspectRatio(final float aspectRatio) {
    final var oldValue = this.aspectRatio;
    this.aspectRatio = aspectRatio;
    notifier.notifyFloat(CinemaViewport.FeatureIDs.ASPECT_RATIO, false, false, oldValue, aspectRatio);
  }

  @Override
  public int minDepth() {
    return minDepth;
  }

  @Override
  public void minDepth(final int minDepth) {
    final var oldValue = this.minDepth;
    this.minDepth = minDepth;
    notifier.notifyInt(CinemaViewport.FeatureIDs.MIN_DEPTH, false, false, oldValue, minDepth);
  }

  @Override
  public int maxDepth() {
    return maxDepth;
  }

  @Override
  public void maxDepth(final int maxDepth) {
    final var oldValue = this.maxDepth;
    this.maxDepth = maxDepth;
    notifier.notifyInt(CinemaViewport.FeatureIDs.MAX_DEPTH, false, false, oldValue, maxDepth);
  }

  @Override
  public Group<CinemaViewport> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.CINEMA_VIEWPORT;
  }

  @Override
  protected FeatureSetter<CinemaViewport> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CinemaViewport> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CinemaViewport.FeatureIDs.ASPECT_RATIO -> 0;
      case CinemaViewport.FeatureIDs.MIN_DEPTH -> 1;
      case CinemaViewport.FeatureIDs.MAX_DEPTH -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CinemaViewport> GET_MAP = new FeatureGetter.Builder<CinemaViewport>(FEATURE_COUNT, CinemaViewportImpl::featureIndexStatic).add(CinemaViewport.FeatureIDs.ASPECT_RATIO, CinemaViewport::aspectRatio).add(CinemaViewport.FeatureIDs.MIN_DEPTH, CinemaViewport::minDepth).add(CinemaViewport.FeatureIDs.MAX_DEPTH, CinemaViewport::maxDepth).build();
    private static final FeatureSetter<CinemaViewport> SET_MAP = new FeatureSetter.Builder<CinemaViewport>(FEATURE_COUNT, CinemaViewportImpl::featureIndexStatic).add(CinemaViewport.FeatureIDs.ASPECT_RATIO, (object, value) -> ((CinemaViewportImpl) object).aspectRatio((float) value)).add(CinemaViewport.FeatureIDs.MIN_DEPTH, (object, value) -> ((CinemaViewportImpl) object).minDepth((int) value)).add(CinemaViewport.FeatureIDs.MAX_DEPTH, (object, value) -> ((CinemaViewportImpl) object).maxDepth((int) value)).build();
  }
}
