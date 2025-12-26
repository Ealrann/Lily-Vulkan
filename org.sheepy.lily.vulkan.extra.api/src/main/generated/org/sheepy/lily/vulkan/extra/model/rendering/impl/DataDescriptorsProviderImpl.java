package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptorsProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;

public final class DataDescriptorsProviderImpl extends FeaturedObject<DataDescriptorsProvider.Features<?>> implements DataDescriptorsProvider {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<DataDescriptorsProvider.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<DataDescriptor> dataDescriptors = newObservableList(DataDescriptorsProvider.FeatureIDs.DATA_DESCRIPTORS, true, true);

  public DataDescriptorsProviderImpl(final List<DataDescriptor> dataDescriptors) {
    this.dataDescriptors.addAll(dataDescriptors);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DataDescriptorsProvider.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<DataDescriptor> dataDescriptors() {
    return dataDescriptors;
  }

  @Override
  public Group<DataDescriptorsProvider> lmGroup() {
    return RenderingModelDefinition.Groups.DATA_DESCRIPTORS_PROVIDER;
  }

  @Override
  protected FeatureSetter<DataDescriptorsProvider> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DataDescriptorsProvider> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DataDescriptorsProvider.FeatureIDs.DATA_DESCRIPTORS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DataDescriptorsProvider> GET_MAP = new FeatureGetter.Builder<DataDescriptorsProvider>(FEATURE_COUNT, DataDescriptorsProviderImpl::featureIndexStatic).add(DataDescriptorsProvider.FeatureIDs.DATA_DESCRIPTORS, DataDescriptorsProvider::dataDescriptors).build();
    private static final FeatureSetter<DataDescriptorsProvider> SET_MAP = new FeatureSetter.Builder<DataDescriptorsProvider>(FEATURE_COUNT, DataDescriptorsProviderImpl::featureIndexStatic).build();
  }
}
