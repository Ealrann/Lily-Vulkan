package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.vulkan.model.graphicpipeline.IViewport;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;
import org.sheepy.vulkan.model.graphicpipeline.StaticViewportState;
import org.sheepy.vulkan.model.graphicpipeline.StaticViewportState.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.StaticViewportStateImpl;

public final class StaticViewportStateBuilder implements Builder {
  private final List<Supplier<IViewport>> viewports = new ArrayList<>();
  private final List<Supplier<Scissor>> scissors = new ArrayList<>();

  public StaticViewportStateBuilder() {
  }

  @Override
  public StaticViewportStateBuilder addViewport(Supplier<IViewport> viewport) {
    this.viewports.add(viewport);
    return this;
  }

  @Override
  public StaticViewportStateBuilder addViewports(final List<IViewport> viewports) {
    viewports.forEach(value -> this.viewports.add(() -> value));
    return this;
  }

  @Override
  public StaticViewportStateBuilder addScissor(Supplier<Scissor> scissor) {
    this.scissors.add(scissor);
    return this;
  }

  @Override
  public StaticViewportStateBuilder addScissors(final List<Scissor> scissors) {
    scissors.forEach(value -> this.scissors.add(() -> value));
    return this;
  }

  @Override
  public StaticViewportState build() {
    final var builtViewports = BuildUtils.collectSuppliers(viewports);
    final var builtScissors = BuildUtils.collectSuppliers(scissors);
    final var built = new StaticViewportStateImpl(builtViewports, builtScissors);
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
    private static final FeatureInserter<StaticViewportStateBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<StaticViewportStateBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<StaticViewportStateBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<StaticViewportStateBuilder>(2, Inserters::relationIndex).add(StaticViewportState.FeatureIDs.VIEWPORTS, (builder, value) -> builder.addViewport((Supplier<IViewport>) value)).add(StaticViewportState.FeatureIDs.SCISSORS, (builder, value) -> builder.addScissor((Supplier<Scissor>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case StaticViewportState.FeatureIDs.VIEWPORTS -> 0;
        case StaticViewportState.FeatureIDs.SCISSORS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
