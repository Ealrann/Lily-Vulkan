package org.sheepy.lily.vulkan.model.vulkan.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;

public final class VulkanResourcePkgImpl extends FeaturedObject<VulkanResourcePkg.Features<?>> implements VulkanResourcePkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<VulkanResourcePkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IVulkanResource> resources = newObservableList(VulkanResourcePkg.FeatureIDs.RESOURCES, true, true);

  public VulkanResourcePkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<VulkanResourcePkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IVulkanResource> resources() {
    return resources;
  }

  @Override
  public Group<VulkanResourcePkg> lmGroup() {
    return VulkanModelDefinition.Groups.VULKAN_RESOURCE_PKG;
  }

  @Override
  protected FeatureSetter<VulkanResourcePkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<VulkanResourcePkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case VulkanResourcePkg.FeatureIDs.RESOURCES -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<VulkanResourcePkg> GET_MAP = new FeatureGetter.Builder<VulkanResourcePkg>(FEATURE_COUNT, VulkanResourcePkgImpl::featureIndexStatic).add(VulkanResourcePkg.FeatureIDs.RESOURCES, VulkanResourcePkg::resources).build();
    private static final FeatureSetter<VulkanResourcePkg> SET_MAP = new FeatureSetter.Builder<VulkanResourcePkg>(FEATURE_COUNT, VulkanResourcePkgImpl::featureIndexStatic).build();
  }
}
