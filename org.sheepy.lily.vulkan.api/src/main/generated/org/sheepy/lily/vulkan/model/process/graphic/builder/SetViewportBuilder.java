package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport;
import org.sheepy.lily.vulkan.model.process.graphic.SetViewport.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SetViewportImpl;

public final class SetViewportBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private float x = 0f;
  private float y = 0f;
  private float width;
  private float height;
  private float minDepth = 1f;
  private float maxDepth = 1f;

  public SetViewportBuilder() {
  }

  @Override
  public SetViewportBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SetViewportBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public SetViewportBuilder x(float x) {
    this.x = x;
    return this;
  }

  @Override
  public SetViewportBuilder y(float y) {
    this.y = y;
    return this;
  }

  @Override
  public SetViewportBuilder width(float width) {
    this.width = width;
    return this;
  }

  @Override
  public SetViewportBuilder height(float height) {
    this.height = height;
    return this;
  }

  @Override
  public SetViewportBuilder minDepth(float minDepth) {
    this.minDepth = minDepth;
    return this;
  }

  @Override
  public SetViewportBuilder maxDepth(float maxDepth) {
    this.maxDepth = maxDepth;
    return this;
  }

  @Override
  public SetViewport build() {
    final var built = new SetViewportImpl(name);
    built.enabled(enabled);
    built.x(x);
    built.y(y);
    built.width(width);
    built.height(height);
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
    private static final FeatureInserter<SetViewportBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SetViewportBuilder>(8, Inserters::attributeIndex).add(SetViewport.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(SetViewport.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(SetViewport.FeatureIDs.X, (builder, value) -> builder.x((float) value)).add(SetViewport.FeatureIDs.Y, (builder, value) -> builder.y((float) value)).add(SetViewport.FeatureIDs.WIDTH, (builder, value) -> builder.width((float) value)).add(SetViewport.FeatureIDs.HEIGHT, (builder, value) -> builder.height((float) value)).add(SetViewport.FeatureIDs.MIN_DEPTH, (builder, value) -> builder.minDepth((float) value)).add(SetViewport.FeatureIDs.MAX_DEPTH, (builder, value) -> builder.maxDepth((float) value)).build();
    private static final RelationLazyInserter<SetViewportBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SetViewportBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SetViewport.FeatureIDs.NAME -> 0;
        case SetViewport.FeatureIDs.ENABLED -> 1;
        case SetViewport.FeatureIDs.X -> 2;
        case SetViewport.FeatureIDs.Y -> 3;
        case SetViewport.FeatureIDs.WIDTH -> 4;
        case SetViewport.FeatureIDs.HEIGHT -> 5;
        case SetViewport.FeatureIDs.MIN_DEPTH -> 6;
        case SetViewport.FeatureIDs.MAX_DEPTH -> 7;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
