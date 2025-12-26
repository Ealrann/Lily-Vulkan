package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.graphicpipeline.CinemaViewport;
import org.sheepy.vulkan.model.graphicpipeline.CinemaViewport.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.CinemaViewportImpl;

public final class CinemaViewportBuilder implements Builder {
  private float aspectRatio = 1f;
  private int minDepth = 0;
  private int maxDepth = 1;

  public CinemaViewportBuilder() {
  }

  @Override
  public CinemaViewportBuilder aspectRatio(float aspectRatio) {
    this.aspectRatio = aspectRatio;
    return this;
  }

  @Override
  public CinemaViewportBuilder minDepth(int minDepth) {
    this.minDepth = minDepth;
    return this;
  }

  @Override
  public CinemaViewportBuilder maxDepth(int maxDepth) {
    this.maxDepth = maxDepth;
    return this;
  }

  @Override
  public CinemaViewport build() {
    final var built = new CinemaViewportImpl(aspectRatio);
    built.minDepth(minDepth);
    built.maxDepth(maxDepth);
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
    private static final FeatureInserter<CinemaViewportBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CinemaViewportBuilder>(3, Inserters::attributeIndex).add(CinemaViewport.FeatureIDs.ASPECT_RATIO, (builder, value) -> builder.aspectRatio((float) value)).add(CinemaViewport.FeatureIDs.MIN_DEPTH, (builder, value) -> builder.minDepth((int) value)).add(CinemaViewport.FeatureIDs.MAX_DEPTH, (builder, value) -> builder.maxDepth((int) value)).build();
    private static final RelationLazyInserter<CinemaViewportBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CinemaViewportBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CinemaViewport.FeatureIDs.ASPECT_RATIO -> 0;
        case CinemaViewport.FeatureIDs.MIN_DEPTH -> 1;
        case CinemaViewport.FeatureIDs.MAX_DEPTH -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
