package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.vulkan.model.vulkan.builder.MouseLocationBuilder;

public interface MouseLocation extends IModelVariable {
  static Builder builder() {
    return new MouseLocationBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  VulkanEngine vulkanEngine();
  void vulkanEngine(final VulkanEngine vulkanEngine);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int VULKAN_ENGINE = -1298013786;
  }

  interface Features<T extends Features<T>> extends IModelVariable.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<VulkanEngine, VulkanEngine, Listener<VulkanEngine>, Features<?>> VULKAN_ENGINE = new RelationBuilder<VulkanEngine, VulkanEngine, Listener<VulkanEngine>, Features<?>>().name("vulkanEngine").mandatory(true).id(MouseLocation.FeatureIDs.VULKAN_ENGINE).concept(() -> VulkanModelDefinition.Groups.VULKAN_ENGINE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, VULKAN_ENGINE);
  }

  interface Builder extends IFeaturedObject.Builder<MouseLocation> {
    Builder name(String name);
    Builder vulkanEngine(Supplier<VulkanEngine> vulkanEngine);
  }
}
