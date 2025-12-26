package org.sheepy.lily.vulkan.model.vulkan.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;

public final class DescriptorPkgImpl extends FeaturedObject<DescriptorPkg.Features<?>> implements DescriptorPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<DescriptorPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IDescriptor> descriptors = newObservableList(DescriptorPkg.FeatureIDs.DESCRIPTORS, true, true);

  public DescriptorPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DescriptorPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IDescriptor> descriptors() {
    return descriptors;
  }

  @Override
  public Group<DescriptorPkg> lmGroup() {
    return VulkanModelDefinition.Groups.DESCRIPTOR_PKG;
  }

  @Override
  protected FeatureSetter<DescriptorPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DescriptorPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DescriptorPkg.FeatureIDs.DESCRIPTORS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DescriptorPkg> GET_MAP = new FeatureGetter.Builder<DescriptorPkg>(FEATURE_COUNT, DescriptorPkgImpl::featureIndexStatic).add(DescriptorPkg.FeatureIDs.DESCRIPTORS, DescriptorPkg::descriptors).build();
    private static final FeatureSetter<DescriptorPkg> SET_MAP = new FeatureSetter.Builder<DescriptorPkg>(FEATURE_COUNT, DescriptorPkgImpl::featureIndexStatic).build();
  }
}
