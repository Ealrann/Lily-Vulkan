package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public final class DataProviderImpl<T extends Structure> extends FeaturedObject<DataProvider.Features<?>> implements DataProvider<T> {
  private static final int FEATURE_COUNT = 5;
  private final ModelNotifier<DataProvider.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<EBufferUsage> usages = newObservableList(DataProvider.FeatureIDs.USAGES, false, false);
  private float growFactor;
  private long minSize;
  private IBufferDataSource dataSource;
  private String dataSourceName;

  public DataProviderImpl(final List<EBufferUsage> usages, final float growFactor,
      final String dataSourceName) {
    this.usages.addAll(usages);
    this.growFactor = growFactor;
    this.dataSourceName = dataSourceName;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DataProvider.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<EBufferUsage> usages() {
    return usages;
  }

  @Override
  public float growFactor() {
    return growFactor;
  }

  @Override
  public void growFactor(final float growFactor) {
    final var oldValue = this.growFactor;
    this.growFactor = growFactor;
    notifier.notifyFloat(DataProvider.FeatureIDs.GROW_FACTOR, false, false, oldValue, growFactor);
  }

  @Override
  public long minSize() {
    return minSize;
  }

  @Override
  public void minSize(final long minSize) {
    final var oldValue = this.minSize;
    this.minSize = minSize;
    notifier.notifyLong(DataProvider.FeatureIDs.MIN_SIZE, false, false, oldValue, minSize);
  }

  @Override
  public IBufferDataSource dataSource() {
    return dataSource;
  }

  @Override
  public void dataSource(final IBufferDataSource dataSource) {
    final var oldValue = this.dataSource;
    final var eventType = dataSource == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dataSource = dataSource;
    notifier.notify(DataProvider.FeatureIDs.DATA_SOURCE, false, false, eventType, oldValue, dataSource);
  }

  @Override
  public String dataSourceName() {
    return dataSourceName;
  }

  @Override
  public void dataSourceName(final String dataSourceName) {
    final var oldValue = this.dataSourceName;
    this.dataSourceName = dataSourceName;
    notifier.notify(DataProvider.FeatureIDs.DATA_SOURCE_NAME, false, false, oldValue, dataSourceName);
  }

  @Override
  public Group<DataProvider<?>> lmGroup() {
    return RenderingModelDefinition.Groups.DATA_PROVIDER;
  }

  @Override
  protected FeatureSetter<DataProvider<?>> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DataProvider<?>> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DataProvider.FeatureIDs.USAGES -> 0;
      case DataProvider.FeatureIDs.GROW_FACTOR -> 1;
      case DataProvider.FeatureIDs.MIN_SIZE -> 2;
      case DataProvider.FeatureIDs.DATA_SOURCE -> 3;
      case DataProvider.FeatureIDs.DATA_SOURCE_NAME -> 4;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DataProvider<?>> GET_MAP = new FeatureGetter.Builder<DataProvider<?>>(FEATURE_COUNT, DataProviderImpl::featureIndexStatic).add(DataProvider.FeatureIDs.USAGES, DataProvider::usages).add(DataProvider.FeatureIDs.GROW_FACTOR, DataProvider::growFactor).add(DataProvider.FeatureIDs.MIN_SIZE, DataProvider::minSize).add(DataProvider.FeatureIDs.DATA_SOURCE, DataProvider::dataSource).add(DataProvider.FeatureIDs.DATA_SOURCE_NAME, DataProvider::dataSourceName).build();
    private static final FeatureSetter<DataProvider<?>> SET_MAP = new FeatureSetter.Builder<DataProvider<?>>(FEATURE_COUNT, DataProviderImpl::featureIndexStatic).add(DataProvider.FeatureIDs.GROW_FACTOR, (object, value) -> ((DataProviderImpl) object).growFactor((float) value)).add(DataProvider.FeatureIDs.MIN_SIZE, (object, value) -> ((DataProviderImpl) object).minSize((long) value)).add(DataProvider.FeatureIDs.DATA_SOURCE, (object, value) -> ((DataProviderImpl) object).dataSource((IBufferDataSource) value)).add(DataProvider.FeatureIDs.DATA_SOURCE_NAME, (object, value) -> ((DataProviderImpl) object).dataSourceName((String) value)).build();
  }
}
