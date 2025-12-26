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
import org.sheepy.lily.vulkan.model.vulkan.builder.DescriptorPkgBuilder;

public interface DescriptorPkg extends LMObject {
  static Builder builder() {
    return new DescriptorPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IDescriptor> descriptors();

  interface FeatureIDs {
    int DESCRIPTORS = 1322820942;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<IDescriptor, List<IDescriptor>, Listener<List<IDescriptor>>, Features<?>> DESCRIPTORS = new RelationBuilder<IDescriptor, List<IDescriptor>, Listener<List<IDescriptor>>, Features<?>>().name("descriptors").many(true).contains(true).id(DescriptorPkg.FeatureIDs.DESCRIPTORS).concept(() -> VulkanModelDefinition.Groups.I_DESCRIPTOR).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(DESCRIPTORS);
  }

  interface Builder extends IFeaturedObject.Builder<DescriptorPkg> {
    Builder addDescriptor(Supplier<IDescriptor> descriptor);
    Builder addDescriptors(List<IDescriptor> descriptors);
  }
}
