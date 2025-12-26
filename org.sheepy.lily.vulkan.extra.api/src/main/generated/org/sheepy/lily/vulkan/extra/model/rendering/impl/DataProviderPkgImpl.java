package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

public final class DataProviderPkgImpl<T extends Structure> extends FeaturedObject<DataProviderPkg.Features<?>> implements DataProviderPkg<T> {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<DataProviderPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<DataProvider<T>> dataProviders = newObservableList(DataProviderPkg.FeatureIDs.DATA_PROVIDERS, true, true);

  public DataProviderPkgImpl(final List<DataProvider<T>> dataProviders) {
    this.dataProviders.addAll(dataProviders);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DataProviderPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<DataProvider<T>> dataProviders() {
    return dataProviders;
  }

  @Override
  public Group<DataProviderPkg<?>> lmGroup() {
    return RenderingModelDefinition.Groups.DATA_PROVIDER_PKG;
  }

  @Override
  protected FeatureSetter<DataProviderPkg<?>> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DataProviderPkg<?>> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DataProviderPkg.FeatureIDs.DATA_PROVIDERS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DataProviderPkg<?>> GET_MAP = new FeatureGetter.Builder<DataProviderPkg<?>>(FEATURE_COUNT, DataProviderPkgImpl::featureIndexStatic).add(DataProviderPkg.FeatureIDs.DATA_PROVIDERS, DataProviderPkg::dataProviders).build();
    private static final FeatureSetter<DataProviderPkg<?>> SET_MAP = new FeatureSetter.Builder<DataProviderPkg<?>>(FEATURE_COUNT, DataProviderPkgImpl::featureIndexStatic).build();
  }
}
