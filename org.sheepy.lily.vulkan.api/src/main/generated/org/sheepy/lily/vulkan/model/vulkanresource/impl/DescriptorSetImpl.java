package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class DescriptorSetImpl extends FeaturedObject<DescriptorSet.Features<?>> implements DescriptorSet {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<DescriptorSet.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<IDescriptor> descriptors = newObservableList(DescriptorSet.FeatureIDs.DESCRIPTORS, true, false);

  public DescriptorSetImpl(final String name, final List<IDescriptor> descriptors) {
    this.name = name;
    this.descriptors.addAll(descriptors);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DescriptorSet.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<IDescriptor> descriptors() {
    return descriptors;
  }

  @Override
  public Group<DescriptorSet> lmGroup() {
    return VulkanResourceModelDefinition.Groups.DESCRIPTOR_SET;
  }

  @Override
  protected FeatureSetter<DescriptorSet> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DescriptorSet> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DescriptorSet.FeatureIDs.NAME -> 0;
      case DescriptorSet.FeatureIDs.DESCRIPTORS -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DescriptorSet> GET_MAP = new FeatureGetter.Builder<DescriptorSet>(FEATURE_COUNT, DescriptorSetImpl::featureIndexStatic).add(DescriptorSet.FeatureIDs.NAME, DescriptorSet::name).add(DescriptorSet.FeatureIDs.DESCRIPTORS, DescriptorSet::descriptors).build();
    private static final FeatureSetter<DescriptorSet> SET_MAP = new FeatureSetter.Builder<DescriptorSet>(FEATURE_COUNT, DescriptorSetImpl::featureIndexStatic).build();
  }
}
