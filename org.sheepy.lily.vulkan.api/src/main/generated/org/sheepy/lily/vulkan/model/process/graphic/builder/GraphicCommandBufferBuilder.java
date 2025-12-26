package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicCommandBufferImpl;

public final class GraphicCommandBufferBuilder implements Builder {
  private int index;
  private int imageID;

  public GraphicCommandBufferBuilder() {
  }

  @Override
  public GraphicCommandBufferBuilder index(int index) {
    this.index = index;
    return this;
  }

  @Override
  public GraphicCommandBufferBuilder imageID(int imageID) {
    this.imageID = imageID;
    return this;
  }

  @Override
  public GraphicCommandBuffer build() {
    final var built = new GraphicCommandBufferImpl(index, imageID);
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
    private static final FeatureInserter<GraphicCommandBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GraphicCommandBufferBuilder>(2, Inserters::attributeIndex).add(GraphicCommandBuffer.FeatureIDs.INDEX, (builder, value) -> builder.index((int) value)).add(GraphicCommandBuffer.FeatureIDs.IMAGEID, (builder, value) -> builder.imageID((int) value)).build();
    private static final RelationLazyInserter<GraphicCommandBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GraphicCommandBufferBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case GraphicCommandBuffer.FeatureIDs.INDEX -> 0;
        case GraphicCommandBuffer.FeatureIDs.IMAGEID -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
