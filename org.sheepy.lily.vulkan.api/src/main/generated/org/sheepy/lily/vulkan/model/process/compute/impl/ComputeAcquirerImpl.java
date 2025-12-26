package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelDefinition;

public final class ComputeAcquirerImpl extends FeaturedObject<ComputeAcquirer.Features<?>> implements ComputeAcquirer {
  private static final int FEATURE_COUNT = 0;
  private final ModelNotifier<ComputeAcquirer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);

  public ComputeAcquirerImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ComputeAcquirer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Group<ComputeAcquirer> lmGroup() {
    return ComputeModelDefinition.Groups.COMPUTE_ACQUIRER;
  }

  @Override
  protected FeatureSetter<ComputeAcquirer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ComputeAcquirer> getterMap() {
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
    private static final FeatureGetter<ComputeAcquirer> GET_MAP = new FeatureGetter.Builder<ComputeAcquirer>(FEATURE_COUNT, ComputeAcquirerImpl::featureIndexStatic).build();
    private static final FeatureSetter<ComputeAcquirer> SET_MAP = new FeatureSetter.Builder<ComputeAcquirer>(FEATURE_COUNT, ComputeAcquirerImpl::featureIndexStatic).build();
  }
}
