package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class DescriptorPoolImpl extends FeaturedObject<DescriptorPool.Features<?>> implements DescriptorPool {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<DescriptorPool.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<DescriptorSet> descriptorSets = newObservableList(DescriptorPool.FeatureIDs.DESCRIPTOR_SETS, true, true);

  public DescriptorPoolImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DescriptorPool.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<DescriptorSet> descriptorSets() {
    return descriptorSets;
  }

  @Override
  public Group<DescriptorPool> lmGroup() {
    return VulkanResourceModelDefinition.Groups.DESCRIPTOR_POOL;
  }

  @Override
  protected FeatureSetter<DescriptorPool> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DescriptorPool> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DescriptorPool.FeatureIDs.DESCRIPTOR_SETS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DescriptorPool> GET_MAP = new FeatureGetter.Builder<DescriptorPool>(FEATURE_COUNT, DescriptorPoolImpl::featureIndexStatic).add(DescriptorPool.FeatureIDs.DESCRIPTOR_SETS, DescriptorPool::descriptorSets).build();
    private static final FeatureSetter<DescriptorPool> SET_MAP = new FeatureSetter.Builder<DescriptorPool>(FEATURE_COUNT, DescriptorPoolImpl::featureIndexStatic).build();
  }
}
