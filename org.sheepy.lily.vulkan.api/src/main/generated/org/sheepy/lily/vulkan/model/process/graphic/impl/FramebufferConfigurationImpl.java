package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;

public final class FramebufferConfigurationImpl extends FeaturedObject<FramebufferConfiguration.Features<?>> implements FramebufferConfiguration {
  private static final int FEATURE_COUNT = 0;
  private final ModelNotifier<FramebufferConfiguration.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);

  public FramebufferConfigurationImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FramebufferConfiguration.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Group<FramebufferConfiguration> lmGroup() {
    return GraphicModelDefinition.Groups.FRAMEBUFFER_CONFIGURATION;
  }

  @Override
  protected FeatureSetter<FramebufferConfiguration> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FramebufferConfiguration> getterMap() {
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
    private static final FeatureGetter<FramebufferConfiguration> GET_MAP = new FeatureGetter.Builder<FramebufferConfiguration>(FEATURE_COUNT, FramebufferConfigurationImpl::featureIndexStatic).build();
    private static final FeatureSetter<FramebufferConfiguration> SET_MAP = new FeatureSetter.Builder<FramebufferConfiguration>(FEATURE_COUNT, FramebufferConfigurationImpl::featureIndexStatic).build();
  }
}
