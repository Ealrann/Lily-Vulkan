package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicAcquirer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;

public final class GraphicAcquirerImpl extends FeaturedObject<GraphicAcquirer.Features<?>> implements GraphicAcquirer {
  private static final int FEATURE_COUNT = 0;
  private final ModelNotifier<GraphicAcquirer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);

  public GraphicAcquirerImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GraphicAcquirer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Group<GraphicAcquirer> lmGroup() {
    return GraphicModelDefinition.Groups.GRAPHIC_ACQUIRER;
  }

  @Override
  protected FeatureSetter<GraphicAcquirer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GraphicAcquirer> getterMap() {
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
    private static final FeatureGetter<GraphicAcquirer> GET_MAP = new FeatureGetter.Builder<GraphicAcquirer>(FEATURE_COUNT, GraphicAcquirerImpl::featureIndexStatic).build();
    private static final FeatureSetter<GraphicAcquirer> SET_MAP = new FeatureSetter.Builder<GraphicAcquirer>(FEATURE_COUNT, GraphicAcquirerImpl::featureIndexStatic).build();
  }
}
