package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.Draw;
import org.sheepy.lily.vulkan.model.process.graphic.Draw.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.DrawImpl;

public final class DrawBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private int vertexCount;
  private int instanceCount = 1;
  private int firstVertex = 0;
  private int firstInstance = 0;

  public DrawBuilder() {
  }

  @Override
  public DrawBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public DrawBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public DrawBuilder vertexCount(int vertexCount) {
    this.vertexCount = vertexCount;
    return this;
  }

  @Override
  public DrawBuilder instanceCount(int instanceCount) {
    this.instanceCount = instanceCount;
    return this;
  }

  @Override
  public DrawBuilder firstVertex(int firstVertex) {
    this.firstVertex = firstVertex;
    return this;
  }

  @Override
  public DrawBuilder firstInstance(int firstInstance) {
    this.firstInstance = firstInstance;
    return this;
  }

  @Override
  public Draw build() {
    final var built = new DrawImpl(name, vertexCount);
    built.enabled(enabled);
    built.instanceCount(instanceCount);
    built.firstVertex(firstVertex);
    built.firstInstance(firstInstance);
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
    private static final FeatureInserter<DrawBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DrawBuilder>(6, Inserters::attributeIndex).add(Draw.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Draw.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(Draw.FeatureIDs.VERTEX_COUNT, (builder, value) -> builder.vertexCount((int) value)).add(Draw.FeatureIDs.INSTANCE_COUNT, (builder, value) -> builder.instanceCount((int) value)).add(Draw.FeatureIDs.FIRST_VERTEX, (builder, value) -> builder.firstVertex((int) value)).add(Draw.FeatureIDs.FIRST_INSTANCE, (builder, value) -> builder.firstInstance((int) value)).build();
    private static final RelationLazyInserter<DrawBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DrawBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Draw.FeatureIDs.NAME -> 0;
        case Draw.FeatureIDs.ENABLED -> 1;
        case Draw.FeatureIDs.VERTEX_COUNT -> 2;
        case Draw.FeatureIDs.INSTANCE_COUNT -> 3;
        case Draw.FeatureIDs.FIRST_VERTEX -> 4;
        case Draw.FeatureIDs.FIRST_INSTANCE -> 5;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
