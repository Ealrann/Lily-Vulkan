package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.BindIndexBufferImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.vulkan.model.enumeration.EIndexType;

public final class BindIndexBufferBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private EIndexType indexType = EIndexType.UINT32;
  private Supplier<IBuffer> buffer = () -> null;

  public BindIndexBufferBuilder() {
  }

  @Override
  public BindIndexBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BindIndexBufferBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public BindIndexBufferBuilder indexType(EIndexType indexType) {
    this.indexType = indexType;
    return this;
  }

  @Override
  public BindIndexBufferBuilder buffer(Supplier<IBuffer> buffer) {
    this.buffer = buffer;
    return this;
  }

  @Override
  public BindIndexBuffer build() {
    final var built = new BindIndexBufferImpl(name);
    built.enabled(enabled);
    built.indexType(indexType);
    built.buffer(buffer.get());
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
    private static final FeatureInserter<BindIndexBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BindIndexBufferBuilder>(3, Inserters::attributeIndex).add(BindIndexBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(BindIndexBuffer.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(BindIndexBuffer.FeatureIDs.INDEX_TYPE, (builder, value) -> builder.indexType((EIndexType) value)).build();
    private static final RelationLazyInserter<BindIndexBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BindIndexBufferBuilder>(1, Inserters::relationIndex).add(BindIndexBuffer.FeatureIDs.BUFFER, (builder, value) -> builder.buffer((Supplier<IBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BindIndexBuffer.FeatureIDs.NAME -> 0;
        case BindIndexBuffer.FeatureIDs.ENABLED -> 1;
        case BindIndexBuffer.FeatureIDs.INDEX_TYPE -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BindIndexBuffer.FeatureIDs.BUFFER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
