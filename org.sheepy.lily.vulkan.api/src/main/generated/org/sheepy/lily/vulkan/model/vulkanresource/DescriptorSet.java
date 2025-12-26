package org.sheepy.lily.vulkan.model.vulkanresource;

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
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.DescriptorSetBuilder;

public interface DescriptorSet extends LNamedElement {
  static Builder builder() {
    return new DescriptorSetBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IDescriptor> descriptors();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int DESCRIPTORS = 805927058;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<IDescriptor, List<IDescriptor>, Listener<List<IDescriptor>>, Features<?>> DESCRIPTORS = new RelationBuilder<IDescriptor, List<IDescriptor>, Listener<List<IDescriptor>>, Features<?>>().name("descriptors").many(true).mandatory(true).id(DescriptorSet.FeatureIDs.DESCRIPTORS).concept(() -> VulkanModelDefinition.Groups.I_DESCRIPTOR).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, DESCRIPTORS);
  }

  interface Builder extends IFeaturedObject.Builder<DescriptorSet> {
    Builder name(String name);
    Builder addDescriptor(Supplier<IDescriptor> descriptor);
    Builder addDescriptors(List<IDescriptor> descriptors);
  }
}
