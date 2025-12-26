package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.DescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;

public final class DescriptorsProviderImpl extends FeaturedObject<DescriptorsProvider.Features<?>> implements DescriptorsProvider {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<DescriptorsProvider.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IDescriptor> descriptors = newObservableList(DescriptorsProvider.FeatureIDs.DESCRIPTORS, true, false);

  public DescriptorsProviderImpl(final List<IDescriptor> descriptors) {
    this.descriptors.addAll(descriptors);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DescriptorsProvider.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IDescriptor> descriptors() {
    return descriptors;
  }

  @Override
  public Group<DescriptorsProvider> lmGroup() {
    return RenderingModelDefinition.Groups.DESCRIPTORS_PROVIDER;
  }

  @Override
  protected FeatureSetter<DescriptorsProvider> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DescriptorsProvider> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DescriptorsProvider.FeatureIDs.DESCRIPTORS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DescriptorsProvider> GET_MAP = new FeatureGetter.Builder<DescriptorsProvider>(FEATURE_COUNT, DescriptorsProviderImpl::featureIndexStatic).add(DescriptorsProvider.FeatureIDs.DESCRIPTORS, DescriptorsProvider::descriptors).build();
    private static final FeatureSetter<DescriptorsProvider> SET_MAP = new FeatureSetter.Builder<DescriptorsProvider>(FEATURE_COUNT, DescriptorsProviderImpl::featureIndexStatic).build();
  }
}
