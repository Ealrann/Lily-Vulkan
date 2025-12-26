package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DataDescriptorsProviderBuilder;

public interface DataDescriptorsProvider extends ResourceDescriptorProvider {
  static Builder builder() {
    return new DataDescriptorsProviderBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<DataDescriptor> dataDescriptors();

  interface FeatureIDs {
    int DATA_DESCRIPTORS = 75839401;
  }

  interface Features<T extends Features<T>> extends ResourceDescriptorProvider.Features<T> {
    Relation<DataDescriptor, List<DataDescriptor>, Listener<List<DataDescriptor>>, Features<?>> DATA_DESCRIPTORS = new RelationBuilder<DataDescriptor, List<DataDescriptor>, Listener<List<DataDescriptor>>, Features<?>>().name("dataDescriptors").many(true).mandatory(true).contains(true).id(DataDescriptorsProvider.FeatureIDs.DATA_DESCRIPTORS).concept(() -> RenderingModelDefinition.Groups.DATA_DESCRIPTOR).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(DATA_DESCRIPTORS);
  }

  interface Builder extends IFeaturedObject.Builder<DataDescriptorsProvider> {
    Builder addDataDescriptor(Supplier<DataDescriptor> dataDescriptor);
    Builder addDataDescriptors(List<DataDescriptor> dataDescriptors);
  }
}
