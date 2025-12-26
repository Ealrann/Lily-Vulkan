package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.VertexBindingImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;

public final class VertexBindingBuilder implements Builder {
  private Supplier<IBuffer> buffer = () -> null;

  public VertexBindingBuilder() {
  }

  @Override
  public VertexBindingBuilder buffer(Supplier<IBuffer> buffer) {
    this.buffer = buffer;
    return this;
  }

  @Override
  public VertexBinding build() {
    final var built = new VertexBindingImpl();
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
    private static final FeatureInserter<VertexBindingBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<VertexBindingBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<VertexBindingBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<VertexBindingBuilder>(1, Inserters::relationIndex).add(VertexBinding.FeatureIDs.BUFFER, (builder, value) -> builder.buffer((Supplier<IBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case VertexBinding.FeatureIDs.BUFFER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
