package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.ResourceDescriptorProviderPkgBuilder;

public interface ResourceDescriptorProviderPkg extends LMObject {
  static Builder builder() {
    return new ResourceDescriptorProviderPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ResourceDescriptorProvider> resourceDescriptorProviders();

  interface FeatureIDs {
    int RESOURCE_DESCRIPTOR_PROVIDERS = -1949839065;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<ResourceDescriptorProvider, List<ResourceDescriptorProvider>, Listener<List<ResourceDescriptorProvider>>, Features<?>> RESOURCE_DESCRIPTOR_PROVIDERS = new RelationBuilder<ResourceDescriptorProvider, List<ResourceDescriptorProvider>, Listener<List<ResourceDescriptorProvider>>, Features<?>>().name("resourceDescriptorProviders").many(true).contains(true).id(ResourceDescriptorProviderPkg.FeatureIDs.RESOURCE_DESCRIPTOR_PROVIDERS).concept(() -> RenderingModelDefinition.Groups.RESOURCE_DESCRIPTOR_PROVIDER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(RESOURCE_DESCRIPTOR_PROVIDERS);
  }

  interface Builder extends IFeaturedObject.Builder<ResourceDescriptorProviderPkg> {
    Builder addResourceDescriptorProvider(
        Supplier<ResourceDescriptorProvider> resourceDescriptorProvider);

    Builder addResourceDescriptorProviders(
        List<ResourceDescriptorProvider> resourceDescriptorProviders);
  }
}
