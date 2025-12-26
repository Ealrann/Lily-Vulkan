package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.EDynamicState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.DynamicStateImpl;

public final class DynamicStateBuilder implements Builder {
  private final List<EDynamicState> states = new ArrayList<>();

  public DynamicStateBuilder() {
  }

  @Override
  public DynamicStateBuilder addState(EDynamicState state) {
    this.states.add(state);
    return this;
  }

  @Override
  public DynamicStateBuilder addStates(final List<EDynamicState> states) {
    this.states.addAll(states);
    return this;
  }

  @Override
  public DynamicState build() {
    final var built = new DynamicStateImpl();
    built.states().addAll(states);
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
    private static final FeatureInserter<DynamicStateBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DynamicStateBuilder>(1, Inserters::attributeIndex).add(DynamicState.FeatureIDs.STATES, (builder, value) -> builder.addState((EDynamicState) value)).build();
    private static final RelationLazyInserter<DynamicStateBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DynamicStateBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DynamicState.FeatureIDs.STATES -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
