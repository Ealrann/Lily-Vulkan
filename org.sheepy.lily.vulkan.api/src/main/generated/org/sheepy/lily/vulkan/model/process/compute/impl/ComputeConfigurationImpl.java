package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelDefinition;

public final class ComputeConfigurationImpl extends FeaturedObject<ComputeConfiguration.Features<?>> implements ComputeConfiguration {
  private static final int FEATURE_COUNT = 0;
  private final ModelNotifier<ComputeConfiguration.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);

  public ComputeConfigurationImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ComputeConfiguration.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Group<ComputeConfiguration> lmGroup() {
    return ComputeModelDefinition.Groups.COMPUTE_CONFIGURATION;
  }

  @Override
  protected FeatureSetter<ComputeConfiguration> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ComputeConfiguration> getterMap() {
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
    private static final FeatureGetter<ComputeConfiguration> GET_MAP = new FeatureGetter.Builder<ComputeConfiguration>(FEATURE_COUNT, ComputeConfigurationImpl::featureIndexStatic).build();
    private static final FeatureSetter<ComputeConfiguration> SET_MAP = new FeatureSetter.Builder<ComputeConfiguration>(FEATURE_COUNT, ComputeConfigurationImpl::featureIndexStatic).build();
  }
}
