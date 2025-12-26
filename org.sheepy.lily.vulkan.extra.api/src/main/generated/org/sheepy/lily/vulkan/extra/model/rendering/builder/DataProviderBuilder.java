package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProvider.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.DataProviderImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public final class DataProviderBuilder<T extends Structure> implements Builder<T> {
  private final List<EBufferUsage> usages = new ArrayList<>();
  private float growFactor = 1.5f;
  private long minSize = 0;
  private Supplier<IBufferDataSource> dataSource = () -> null;
  private String dataSourceName;

  public DataProviderBuilder() {
  }

  @Override
  public DataProviderBuilder<T> addUsage(EBufferUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public DataProviderBuilder<T> addUsages(final List<EBufferUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public DataProviderBuilder<T> growFactor(float growFactor) {
    this.growFactor = growFactor;
    return this;
  }

  @Override
  public DataProviderBuilder<T> minSize(long minSize) {
    this.minSize = minSize;
    return this;
  }

  @Override
  public DataProviderBuilder<T> dataSource(Supplier<IBufferDataSource> dataSource) {
    this.dataSource = dataSource;
    return this;
  }

  @Override
  public DataProviderBuilder<T> dataSourceName(String dataSourceName) {
    this.dataSourceName = dataSourceName;
    return this;
  }

  @Override
  public DataProvider<T> build() {
    final var built = new DataProviderImpl<T>(usages, growFactor, dataSourceName);
    built.minSize(minSize);
    built.dataSource(dataSource.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<DataProviderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DataProviderBuilder>(4, Inserters::attributeIndex).add(DataProvider.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EBufferUsage) value)).add(DataProvider.FeatureIDs.GROW_FACTOR, (builder, value) -> builder.growFactor((float) value)).add(DataProvider.FeatureIDs.MIN_SIZE, (builder, value) -> builder.minSize((long) value)).add(DataProvider.FeatureIDs.DATA_SOURCE_NAME, (builder, value) -> builder.dataSourceName((String) value)).build();
    private static final RelationLazyInserter<DataProviderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DataProviderBuilder>(1, Inserters::relationIndex).add(DataProvider.FeatureIDs.DATA_SOURCE, (builder, value) -> builder.dataSource((Supplier<IBufferDataSource>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DataProvider.FeatureIDs.USAGES -> 0;
        case DataProvider.FeatureIDs.GROW_FACTOR -> 1;
        case DataProvider.FeatureIDs.MIN_SIZE -> 2;
        case DataProvider.FeatureIDs.DATA_SOURCE_NAME -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case DataProvider.FeatureIDs.DATA_SOURCE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
