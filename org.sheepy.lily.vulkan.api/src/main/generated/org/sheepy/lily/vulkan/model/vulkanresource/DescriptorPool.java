package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.DescriptorPoolBuilder;

public interface DescriptorPool extends LMObject {
  static Builder builder() {
    return new DescriptorPoolBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<DescriptorSet> descriptorSets();

  interface FeatureIDs {
    int DESCRIPTOR_SETS = 1775100228;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<DescriptorSet, List<DescriptorSet>, Listener<List<DescriptorSet>>, Features<?>> DESCRIPTOR_SETS = new RelationBuilder<DescriptorSet, List<DescriptorSet>, Listener<List<DescriptorSet>>, Features<?>>().name("descriptorSets").many(true).contains(true).id(DescriptorPool.FeatureIDs.DESCRIPTOR_SETS).concept(() -> VulkanResourceModelDefinition.Groups.DESCRIPTOR_SET).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(DESCRIPTOR_SETS);
  }

  interface Builder extends IFeaturedObject.Builder<DescriptorPool> {
    Builder addDescriptorSet(Supplier<DescriptorSet> descriptorSet);
    Builder addDescriptorSets(List<DescriptorSet> descriptorSets);
  }
}
