package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.api.notification.listener.LongListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.IndexedDataDescriptionBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EIndexType;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface IndexedDataDescription<T extends Structure> extends DataProvider<T> {
  static <T extends Structure> Builder<T> builder() {
    return new IndexedDataDescriptionBuilder<>();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EIndexType indexType();
  void indexType(final EIndexType indexType);

  interface FeatureIDs {
    int USAGES = DataProvider.FeatureIDs.USAGES;
    int GROW_FACTOR = DataProvider.FeatureIDs.GROW_FACTOR;
    int MIN_SIZE = DataProvider.FeatureIDs.MIN_SIZE;
    int DATA_SOURCE = DataProvider.FeatureIDs.DATA_SOURCE;
    int DATA_SOURCE_NAME = DataProvider.FeatureIDs.DATA_SOURCE_NAME;
    int INDEX_TYPE = -1754295787;
  }

  interface Features<T extends Features<T>> extends DataProvider.Features<T> {
    Attribute<EBufferUsage, List<EBufferUsage>, Listener<List<EBufferUsage>>, DataProvider.Features<?>> USAGES = DataProvider.Features.USAGES;
    Attribute<Float, Float, FloatListener, DataProvider.Features<?>> GROW_FACTOR = DataProvider.Features.GROW_FACTOR;
    Attribute<Long, Long, LongListener, DataProvider.Features<?>> MIN_SIZE = DataProvider.Features.MIN_SIZE;
    Relation<IBufferDataSource, IBufferDataSource, Listener<IBufferDataSource>, DataProvider.Features<?>> DATA_SOURCE = DataProvider.Features.DATA_SOURCE;
    Attribute<String, String, Listener<String>, DataProvider.Features<?>> DATA_SOURCE_NAME = DataProvider.Features.DATA_SOURCE_NAME;
    Attribute<EIndexType, EIndexType, Listener<EIndexType>, Features<?>> INDEX_TYPE = new AttributeBuilder<EIndexType, EIndexType, Listener<EIndexType>, Features<?>>().name("indexType").mandatory(true).defaultValue("UINT32").id(IndexedDataDescription.FeatureIDs.INDEX_TYPE).datatype(() -> EnumerationModelDefinition.Enums.E_INDEX_TYPE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(USAGES, GROW_FACTOR, MIN_SIZE, DATA_SOURCE, DATA_SOURCE_NAME, INDEX_TYPE);
  }

  interface Builder<T extends Structure> extends IFeaturedObject.Builder<IndexedDataDescription<T>> {
    Builder<T> addUsage(EBufferUsage usage);
    Builder<T> growFactor(float growFactor);
    Builder<T> minSize(long minSize);
    Builder<T> dataSource(Supplier<IBufferDataSource> dataSource);
    Builder<T> dataSourceName(String dataSourceName);
    Builder<T> indexType(EIndexType indexType);
    Builder<T> addUsages(List<EBufferUsage> usages);
  }
}
