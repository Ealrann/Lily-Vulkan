package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.nio.ByteBuffer;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ConstantBufferImpl;

public final class ConstantBufferBuilder implements Builder {
  private String name;
  private ByteBuffer data;

  public ConstantBufferBuilder() {
  }

  @Override
  public ConstantBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ConstantBufferBuilder data(ByteBuffer data) {
    this.data = data;
    return this;
  }

  @Override
  public ConstantBuffer build() {
    final var built = new ConstantBufferImpl(name);
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
    private static final FeatureInserter<ConstantBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ConstantBufferBuilder>(2, Inserters::attributeIndex).add(ConstantBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ConstantBuffer.FeatureIDs.DATA, (builder, value) -> builder.data((ByteBuffer) value)).build();
    private static final RelationLazyInserter<ConstantBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ConstantBufferBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ConstantBuffer.FeatureIDs.NAME -> 0;
        case ConstantBuffer.FeatureIDs.DATA -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
