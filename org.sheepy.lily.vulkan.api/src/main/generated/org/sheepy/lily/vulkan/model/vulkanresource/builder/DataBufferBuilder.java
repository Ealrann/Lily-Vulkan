package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.DataBufferImpl;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public final class DataBufferBuilder implements Builder {
  private String name;
  private final List<EBufferUsage> usages = new ArrayList<>();
  private ByteBuffer data;

  public DataBufferBuilder() {
  }

  @Override
  public DataBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public DataBufferBuilder addUsage(EBufferUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public DataBufferBuilder addUsages(final List<EBufferUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public DataBufferBuilder data(ByteBuffer data) {
    this.data = data;
    return this;
  }

  @Override
  public DataBuffer build() {
    final var built = new DataBufferImpl(name);
    built.usages().addAll(usages);
    built.data(data);
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
    private static final FeatureInserter<DataBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DataBufferBuilder>(3, Inserters::attributeIndex).add(DataBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(DataBuffer.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EBufferUsage) value)).add(DataBuffer.FeatureIDs.DATA, (builder, value) -> builder.data((ByteBuffer) value)).build();
    private static final RelationLazyInserter<DataBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DataBufferBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DataBuffer.FeatureIDs.NAME -> 0;
        case DataBuffer.FeatureIDs.USAGES -> 1;
        case DataBuffer.FeatureIDs.DATA -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
