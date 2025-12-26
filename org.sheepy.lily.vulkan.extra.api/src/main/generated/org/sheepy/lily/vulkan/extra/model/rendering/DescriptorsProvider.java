package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DescriptorsProviderBuilder;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;

public interface DescriptorsProvider extends ResourceDescriptorProvider {
  static Builder builder() {
    return new DescriptorsProviderBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IDescriptor> descriptors();

  interface FeatureIDs {
    int DESCRIPTORS = -1683285699;
  }

  interface Features<T extends Features<T>> extends ResourceDescriptorProvider.Features<T> {
    Relation<IDescriptor, List<IDescriptor>, Listener<List<IDescriptor>>, Features<?>> DESCRIPTORS = new RelationBuilder<IDescriptor, List<IDescriptor>, Listener<List<IDescriptor>>, Features<?>>().name("descriptors").many(true).mandatory(true).id(DescriptorsProvider.FeatureIDs.DESCRIPTORS).concept(() -> VulkanModelDefinition.Groups.I_DESCRIPTOR).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(DESCRIPTORS);
  }

  interface Builder extends IFeaturedObject.Builder<DescriptorsProvider> {
    Builder addDescriptor(Supplier<IDescriptor> descriptor);
    Builder addDescriptors(List<IDescriptor> descriptors);
  }
}
