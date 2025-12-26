package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;

public final class ImageViewsImpl extends FeaturedObject<ImageViews.Features<?>> implements ImageViews {
  private static final int FEATURE_COUNT = 0;
  private final ModelNotifier<ImageViews.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);

  public ImageViewsImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ImageViews.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Group<ImageViews> lmGroup() {
    return GraphicModelDefinition.Groups.IMAGE_VIEWS;
  }

  @Override
  protected FeatureSetter<ImageViews> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ImageViews> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    throw new IllegalArgumentException("Unknown featureId: " + featureId);
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ImageViews> GET_MAP = new FeatureGetter.Builder<ImageViews>(FEATURE_COUNT, ImageViewsImpl::featureIndexStatic).build();
    private static final FeatureSetter<ImageViews> SET_MAP = new FeatureSetter.Builder<ImageViews>(FEATURE_COUNT, ImageViewsImpl::featureIndexStatic).build();
  }
}
