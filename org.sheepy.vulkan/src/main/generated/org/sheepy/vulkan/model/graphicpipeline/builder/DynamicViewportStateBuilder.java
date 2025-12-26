package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.DynamicViewportStateImpl;

public final class DynamicViewportStateBuilder implements Builder {
  private int viewportCount;
  private int scissorCount;

  public DynamicViewportStateBuilder() {
  }

  @Override
  public DynamicViewportStateBuilder viewportCount(int viewportCount) {
    this.viewportCount = viewportCount;
    return this;
  }

  @Override
  public DynamicViewportStateBuilder scissorCount(int scissorCount) {
    this.scissorCount = scissorCount;
    return this;
  }

  @Override
  public DynamicViewportState build() {
    final var built = new DynamicViewportStateImpl();
    built.viewportCount(viewportCount);
    built.scissorCount(scissorCount);
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
    private static final FeatureInserter<DynamicViewportStateBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DynamicViewportStateBuilder>(2, Inserters::attributeIndex).add(DynamicViewportState.FeatureIDs.VIEWPORT_COUNT, (builder, value) -> builder.viewportCount((int) value)).add(DynamicViewportState.FeatureIDs.SCISSOR_COUNT, (builder, value) -> builder.scissorCount((int) value)).build();
    private static final RelationLazyInserter<DynamicViewportStateBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DynamicViewportStateBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DynamicViewportState.FeatureIDs.VIEWPORT_COUNT -> 0;
        case DynamicViewportState.FeatureIDs.SCISSOR_COUNT -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
