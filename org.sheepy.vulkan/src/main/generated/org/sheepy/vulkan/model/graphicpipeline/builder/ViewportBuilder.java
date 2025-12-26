package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.function.Supplier;
import org.joml.Vector2ic;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.graphicpipeline.Viewport;
import org.sheepy.vulkan.model.graphicpipeline.Viewport.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.ViewportImpl;

public final class ViewportBuilder implements Builder {
  private int offsetX = 0;
  private int offsetY = 0;
  private int minDepth = 0;
  private int maxDepth = 1;
  private Vector2ic extent;

  public ViewportBuilder() {
  }

  @Override
  public ViewportBuilder offsetX(int offsetX) {
    this.offsetX = offsetX;
    return this;
  }

  @Override
  public ViewportBuilder offsetY(int offsetY) {
    this.offsetY = offsetY;
    return this;
  }

  @Override
  public ViewportBuilder minDepth(int minDepth) {
    this.minDepth = minDepth;
    return this;
  }

  @Override
  public ViewportBuilder maxDepth(int maxDepth) {
    this.maxDepth = maxDepth;
    return this;
  }

  @Override
  public ViewportBuilder extent(Vector2ic extent) {
    this.extent = extent;
    return this;
  }

  @Override
  public Viewport build() {
    final var built = new ViewportImpl();
    built.offsetX(offsetX);
    built.offsetY(offsetY);
    built.minDepth(minDepth);
    built.maxDepth(maxDepth);
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
    private static final FeatureInserter<ViewportBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ViewportBuilder>(5, Inserters::attributeIndex).add(Viewport.FeatureIDs.OFFSETX, (builder, value) -> builder.offsetX((int) value)).add(Viewport.FeatureIDs.OFFSETY, (builder, value) -> builder.offsetY((int) value)).add(Viewport.FeatureIDs.MIN_DEPTH, (builder, value) -> builder.minDepth((int) value)).add(Viewport.FeatureIDs.MAX_DEPTH, (builder, value) -> builder.maxDepth((int) value)).add(Viewport.FeatureIDs.EXTENT, (builder, value) -> builder.extent((Vector2ic) value)).build();
    private static final RelationLazyInserter<ViewportBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ViewportBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Viewport.FeatureIDs.OFFSETX -> 0;
        case Viewport.FeatureIDs.OFFSETY -> 1;
        case Viewport.FeatureIDs.MIN_DEPTH -> 2;
        case Viewport.FeatureIDs.MAX_DEPTH -> 3;
        case Viewport.FeatureIDs.EXTENT -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
