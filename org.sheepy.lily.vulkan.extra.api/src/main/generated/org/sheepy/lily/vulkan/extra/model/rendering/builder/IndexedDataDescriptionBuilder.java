package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription;
import org.sheepy.lily.vulkan.extra.model.rendering.IndexedDataDescription.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.IndexedDataDescriptionImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;
import org.sheepy.vulkan.model.enumeration.EIndexType;

public final class IndexedDataDescriptionBuilder<T extends Structure> implements Builder<T> {
  private final List<EBufferUsage> usages = new ArrayList<>();
  private float growFactor = 1.5f;
  private long minSize = 0;
  private Supplier<IBufferDataSource> dataSource = () -> null;
  private String dataSourceName;
  private EIndexType indexType = EIndexType.UINT32;

  public IndexedDataDescriptionBuilder() {
  }

  @Override
  public IndexedDataDescriptionBuilder<T> addUsage(EBufferUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public IndexedDataDescriptionBuilder<T> addUsages(final List<EBufferUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public IndexedDataDescriptionBuilder<T> growFactor(float growFactor) {
    this.growFactor = growFactor;
    return this;
  }

  @Override
  public IndexedDataDescriptionBuilder<T> minSize(long minSize) {
    this.minSize = minSize;
    return this;
  }

  @Override
  public IndexedDataDescriptionBuilder<T> dataSource(Supplier<IBufferDataSource> dataSource) {
    this.dataSource = dataSource;
    return this;
  }

  @Override
  public IndexedDataDescriptionBuilder<T> dataSourceName(String dataSourceName) {
    this.dataSourceName = dataSourceName;
    return this;
  }

  @Override
  public IndexedDataDescriptionBuilder<T> indexType(EIndexType indexType) {
    this.indexType = indexType;
    return this;
  }

  @Override
  public IndexedDataDescription<T> build() {
    final var built = new IndexedDataDescriptionImpl<T>(usages, growFactor, dataSourceName, indexType);
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
    private static final FeatureInserter<IndexedDataDescriptionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<IndexedDataDescriptionBuilder>(5, Inserters::attributeIndex).add(IndexedDataDescription.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EBufferUsage) value)).add(IndexedDataDescription.FeatureIDs.GROW_FACTOR, (builder, value) -> builder.growFactor((float) value)).add(IndexedDataDescription.FeatureIDs.MIN_SIZE, (builder, value) -> builder.minSize((long) value)).add(IndexedDataDescription.FeatureIDs.DATA_SOURCE_NAME, (builder, value) -> builder.dataSourceName((String) value)).add(IndexedDataDescription.FeatureIDs.INDEX_TYPE, (builder, value) -> builder.indexType((EIndexType) value)).build();
    private static final RelationLazyInserter<IndexedDataDescriptionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<IndexedDataDescriptionBuilder>(1, Inserters::relationIndex).add(IndexedDataDescription.FeatureIDs.DATA_SOURCE, (builder, value) -> builder.dataSource((Supplier<IBufferDataSource>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case IndexedDataDescription.FeatureIDs.USAGES -> 0;
        case IndexedDataDescription.FeatureIDs.GROW_FACTOR -> 1;
        case IndexedDataDescription.FeatureIDs.MIN_SIZE -> 2;
        case IndexedDataDescription.FeatureIDs.DATA_SOURCE_NAME -> 3;
        case IndexedDataDescription.FeatureIDs.INDEX_TYPE -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case IndexedDataDescription.FeatureIDs.DATA_SOURCE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
