package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkan.builder.VulkanResourcePkgBuilder;

public interface VulkanResourcePkg extends LMObject {
  static Builder builder() {
    return new VulkanResourcePkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IVulkanResource> resources();

  interface FeatureIDs {
    int RESOURCES = -1209162523;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IVulkanResource, List<IVulkanResource>, Listener<List<IVulkanResource>>, Features<?>> RESOURCES = new RelationBuilder<IVulkanResource, List<IVulkanResource>, Listener<List<IVulkanResource>>, Features<?>>().name("resources").many(true).contains(true).id(VulkanResourcePkg.FeatureIDs.RESOURCES).concept(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(RESOURCES);
  }

  interface Builder extends IFeaturedObject.Builder<VulkanResourcePkg> {
    Builder addResource(Supplier<IVulkanResource> resource);
    Builder addResources(List<IVulkanResource> resources);
  }
}
