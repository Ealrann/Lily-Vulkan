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
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EIndexType;

public final class IndexedDataDescriptionImpl<T extends Structure> extends FeaturedObject<IndexedDataDescription.Features<?>> implements IndexedDataDescription<T> {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<IndexedDataDescription.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<EBufferUsage> usages = newObservableList(DataProvider.FeatureIDs.USAGES, false, false);
  private float growFactor;
  private long minSize;
  private IBufferDataSource dataSource;
  private String dataSourceName;
  private EIndexType indexType;

  public IndexedDataDescriptionImpl(final List<EBufferUsage> usages, final float growFactor,
      final String dataSourceName, final EIndexType indexType) {
    this.usages.addAll(usages);
    this.growFactor = growFactor;
    this.dataSourceName = dataSourceName;
    this.indexType = indexType;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<IndexedDataDescription.Features<?>> notifier() {
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
  public EIndexType indexType() {
    return indexType;
  }

  @Override
  public void indexType(final EIndexType indexType) {
    final var oldValue = this.indexType;
    this.indexType = indexType;
    notifier.notify(IndexedDataDescription.FeatureIDs.INDEX_TYPE, false, false, oldValue, indexType);
  }

  @Override
  public Group<IndexedDataDescription<?>> lmGroup() {
    return RenderingModelDefinition.Groups.INDEXED_DATA_DESCRIPTION;
  }

  @Override
  protected FeatureSetter<IndexedDataDescription<?>> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<IndexedDataDescription<?>> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case IndexedDataDescription.FeatureIDs.USAGES -> 0;
      case IndexedDataDescription.FeatureIDs.GROW_FACTOR -> 1;
      case IndexedDataDescription.FeatureIDs.MIN_SIZE -> 2;
      case IndexedDataDescription.FeatureIDs.DATA_SOURCE -> 3;
      case IndexedDataDescription.FeatureIDs.DATA_SOURCE_NAME -> 4;
      case IndexedDataDescription.FeatureIDs.INDEX_TYPE -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<IndexedDataDescription<?>> GET_MAP = new FeatureGetter.Builder<IndexedDataDescription<?>>(FEATURE_COUNT, IndexedDataDescriptionImpl::featureIndexStatic).add(IndexedDataDescription.FeatureIDs.USAGES, IndexedDataDescription::usages).add(IndexedDataDescription.FeatureIDs.GROW_FACTOR, IndexedDataDescription::growFactor).add(IndexedDataDescription.FeatureIDs.MIN_SIZE, IndexedDataDescription::minSize).add(IndexedDataDescription.FeatureIDs.DATA_SOURCE, IndexedDataDescription::dataSource).add(IndexedDataDescription.FeatureIDs.DATA_SOURCE_NAME, IndexedDataDescription::dataSourceName).add(IndexedDataDescription.FeatureIDs.INDEX_TYPE, IndexedDataDescription::indexType).build();
    private static final FeatureSetter<IndexedDataDescription<?>> SET_MAP = new FeatureSetter.Builder<IndexedDataDescription<?>>(FEATURE_COUNT, IndexedDataDescriptionImpl::featureIndexStatic).add(IndexedDataDescription.FeatureIDs.GROW_FACTOR, (object, value) -> ((IndexedDataDescriptionImpl) object).growFactor((float) value)).add(IndexedDataDescription.FeatureIDs.MIN_SIZE, (object, value) -> ((IndexedDataDescriptionImpl) object).minSize((long) value)).add(IndexedDataDescription.FeatureIDs.DATA_SOURCE, (object, value) -> ((IndexedDataDescriptionImpl) object).dataSource((IBufferDataSource) value)).add(IndexedDataDescription.FeatureIDs.DATA_SOURCE_NAME, (object, value) -> ((IndexedDataDescriptionImpl) object).dataSourceName((String) value)).add(IndexedDataDescription.FeatureIDs.INDEX_TYPE, (object, value) -> ((IndexedDataDescriptionImpl) object).indexType((EIndexType) value)).build();
  }
}
