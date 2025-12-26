package org.sheepy.lily.vulkan.model.process.compute.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer.Builder;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputeCommandBufferImpl;

public final class ComputeCommandBufferBuilder implements Builder {
  private int index;

  public ComputeCommandBufferBuilder() {
  }

  @Override
  public ComputeCommandBufferBuilder index(int index) {
    this.index = index;
    return this;
  }

  @Override
  public ComputeCommandBuffer build() {
    final var built = new ComputeCommandBufferImpl(index);
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
    private static final FeatureInserter<ComputeCommandBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ComputeCommandBufferBuilder>(1, Inserters::attributeIndex).add(ComputeCommandBuffer.FeatureIDs.INDEX, (builder, value) -> builder.index((int) value)).build();
    private static final RelationLazyInserter<ComputeCommandBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ComputeCommandBufferBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ComputeCommandBuffer.FeatureIDs.INDEX -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
