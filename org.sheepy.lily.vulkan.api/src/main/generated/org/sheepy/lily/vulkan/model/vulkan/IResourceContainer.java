package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface IResourceContainer extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  VulkanResourcePkg resourcePkg();
  DescriptorPkg descriptorPkg();
  void resourcePkg(final VulkanResourcePkg resourcePkg);
  void descriptorPkg(final DescriptorPkg descriptorPkg);

  interface FeatureIDs {
    int RESOURCE_PKG = 1450537959;
    int DESCRIPTOR_PKG = 2006318758;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, Features<?>> RESOURCE_PKG = new RelationBuilder<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, Features<?>>().name("resourcePkg").contains(true).id(IResourceContainer.FeatureIDs.RESOURCE_PKG).concept(() -> VulkanModelDefinition.Groups.VULKAN_RESOURCE_PKG).build();
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, Features<?>> DESCRIPTOR_PKG = new RelationBuilder<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, Features<?>>().name("descriptorPkg").contains(true).id(IResourceContainer.FeatureIDs.DESCRIPTOR_PKG).concept(() -> VulkanModelDefinition.Groups.DESCRIPTOR_PKG).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(RESOURCE_PKG, DESCRIPTOR_PKG);
  }
}
