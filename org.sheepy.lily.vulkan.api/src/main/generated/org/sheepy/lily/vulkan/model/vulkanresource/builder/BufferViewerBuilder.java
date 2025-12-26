package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferViewerImpl;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public final class BufferViewerBuilder implements Builder {
  private String name;
  private final List<EBufferUsage> usages = new ArrayList<>();
  private float growFactor = 1f;
  private float growThreshold = 1f;
  private long size = 0;
  private Supplier<IBufferDataSource> dataSource = () -> null;
  private String dataSourceIdentifier;

  public BufferViewerBuilder() {
  }

  @Override
  public BufferViewerBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BufferViewerBuilder addUsage(EBufferUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public BufferViewerBuilder addUsages(final List<EBufferUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public BufferViewerBuilder growFactor(float growFactor) {
    this.growFactor = growFactor;
    return this;
  }

  @Override
  public BufferViewerBuilder growThreshold(float growThreshold) {
    this.growThreshold = growThreshold;
    return this;
  }

  @Override
  public BufferViewerBuilder size(long size) {
    this.size = size;
    return this;
  }

  @Override
  public BufferViewerBuilder dataSource(Supplier<IBufferDataSource> dataSource) {
    this.dataSource = dataSource;
    return this;
  }

  @Override
  public BufferViewerBuilder dataSourceIdentifier(String dataSourceIdentifier) {
    this.dataSourceIdentifier = dataSourceIdentifier;
    return this;
  }

  @Override
  public BufferViewer build() {
    final var built = new BufferViewerImpl(name, growFactor, growThreshold);
    built.usages().addAll(usages);
    built.size(size);
    built.dataSource(dataSource.get());
    built.dataSourceIdentifier(dataSourceIdentifier);
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
    private static final FeatureInserter<BufferViewerBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BufferViewerBuilder>(6, Inserters::attributeIndex).add(BufferViewer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(BufferViewer.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EBufferUsage) value)).add(BufferViewer.FeatureIDs.GROW_FACTOR, (builder, value) -> builder.growFactor((float) value)).add(BufferViewer.FeatureIDs.GROW_THRESHOLD, (builder, value) -> builder.growThreshold((float) value)).add(BufferViewer.FeatureIDs.SIZE, (builder, value) -> builder.size((long) value)).add(BufferViewer.FeatureIDs.DATA_SOURCE_IDENTIFIER, (builder, value) -> builder.dataSourceIdentifier((String) value)).build();
    private static final RelationLazyInserter<BufferViewerBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BufferViewerBuilder>(1, Inserters::relationIndex).add(BufferViewer.FeatureIDs.DATA_SOURCE, (builder, value) -> builder.dataSource((Supplier<IBufferDataSource>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BufferViewer.FeatureIDs.NAME -> 0;
        case BufferViewer.FeatureIDs.USAGES -> 1;
        case BufferViewer.FeatureIDs.GROW_FACTOR -> 2;
        case BufferViewer.FeatureIDs.GROW_THRESHOLD -> 3;
        case BufferViewer.FeatureIDs.SIZE -> 4;
        case BufferViewer.FeatureIDs.DATA_SOURCE_IDENTIFIER -> 5;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BufferViewer.FeatureIDs.DATA_SOURCE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
