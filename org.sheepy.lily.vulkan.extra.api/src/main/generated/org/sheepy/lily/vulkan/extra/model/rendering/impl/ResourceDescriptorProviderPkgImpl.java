package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;

public final class ResourceDescriptorProviderPkgImpl extends FeaturedObject<ResourceDescriptorProviderPkg.Features<?>> implements ResourceDescriptorProviderPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ResourceDescriptorProviderPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ResourceDescriptorProvider> resourceDescriptorProviders = newObservableList(ResourceDescriptorProviderPkg.FeatureIDs.RESOURCE_DESCRIPTOR_PROVIDERS, true, true);

  public ResourceDescriptorProviderPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ResourceDescriptorProviderPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ResourceDescriptorProvider> resourceDescriptorProviders() {
    return resourceDescriptorProviders;
  }

  @Override
  public Group<ResourceDescriptorProviderPkg> lmGroup() {
    return RenderingModelDefinition.Groups.RESOURCE_DESCRIPTOR_PROVIDER_PKG;
  }

  @Override
  protected FeatureSetter<ResourceDescriptorProviderPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ResourceDescriptorProviderPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ResourceDescriptorProviderPkg.FeatureIDs.RESOURCE_DESCRIPTOR_PROVIDERS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ResourceDescriptorProviderPkg> GET_MAP = new FeatureGetter.Builder<ResourceDescriptorProviderPkg>(FEATURE_COUNT, ResourceDescriptorProviderPkgImpl::featureIndexStatic).add(ResourceDescriptorProviderPkg.FeatureIDs.RESOURCE_DESCRIPTOR_PROVIDERS, ResourceDescriptorProviderPkg::resourceDescriptorProviders).build();
    private static final FeatureSetter<ResourceDescriptorProviderPkg> SET_MAP = new FeatureSetter.Builder<ResourceDescriptorProviderPkg>(FEATURE_COUNT, ResourceDescriptorProviderPkgImpl::featureIndexStatic).build();
  }
}
