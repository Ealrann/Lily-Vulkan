package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;
import org.sheepy.vulkan.model.graphicpipeline.Scissor.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.ScissorImpl;

public final class ScissorBuilder implements Builder {
  private int offsetX = 0;
  private int offsetY = 0;
  private Vector2ic extent = ((Function<String, Vector2ic>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==2){int x=Integer.parseInt(split[0]);int y=Integer.parseInt(split[1]);return new org.joml.Vector2i(x,y);}}return new org.joml.Vector2i(0,0); }).apply("0;0");

  public ScissorBuilder() {
  }

  @Override
  public ScissorBuilder offsetX(int offsetX) {
    this.offsetX = offsetX;
    return this;
  }

  @Override
  public ScissorBuilder offsetY(int offsetY) {
    this.offsetY = offsetY;
    return this;
  }

  @Override
  public ScissorBuilder extent(Vector2ic extent) {
    this.extent = extent;
    return this;
  }

  @Override
  public Scissor build() {
    final var built = new ScissorImpl();
    built.offsetX(offsetX);
    built.offsetY(offsetY);
    built.extent(extent);
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
    private static final FeatureInserter<ScissorBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ScissorBuilder>(3, Inserters::attributeIndex).add(Scissor.FeatureIDs.OFFSETX, (builder, value) -> builder.offsetX((int) value)).add(Scissor.FeatureIDs.OFFSETY, (builder, value) -> builder.offsetY((int) value)).add(Scissor.FeatureIDs.EXTENT, (builder, value) -> builder.extent((Vector2ic) value)).build();
    private static final RelationLazyInserter<ScissorBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ScissorBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Scissor.FeatureIDs.OFFSETX -> 0;
        case Scissor.FeatureIDs.OFFSETY -> 1;
        case Scissor.FeatureIDs.EXTENT -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
