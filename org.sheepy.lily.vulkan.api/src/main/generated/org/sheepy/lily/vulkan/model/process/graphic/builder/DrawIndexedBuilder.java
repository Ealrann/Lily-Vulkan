package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.DrawIndexedImpl;

public final class DrawIndexedBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private int indexCount;
  private int instanceCount = 1;
  private int firstIndex = 0;
  private int vertexOffset = 0;
  private int firstInstance = 0;

  public DrawIndexedBuilder() {
  }

  @Override
  public DrawIndexedBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public DrawIndexedBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public DrawIndexedBuilder indexCount(int indexCount) {
    this.indexCount = indexCount;
    return this;
  }

  @Override
  public DrawIndexedBuilder instanceCount(int instanceCount) {
    this.instanceCount = instanceCount;
    return this;
  }

  @Override
  public DrawIndexedBuilder firstIndex(int firstIndex) {
    this.firstIndex = firstIndex;
    return this;
  }

  @Override
  public DrawIndexedBuilder vertexOffset(int vertexOffset) {
    this.vertexOffset = vertexOffset;
    return this;
  }

  @Override
  public DrawIndexedBuilder firstInstance(int firstInstance) {
    this.firstInstance = firstInstance;
    return this;
  }

  @Override
  public DrawIndexed build() {
    final var built = new DrawIndexedImpl(name, indexCount);
    built.enabled(enabled);
    built.instanceCount(instanceCount);
    built.firstIndex(firstIndex);
    built.vertexOffset(vertexOffset);
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
    private static final FeatureInserter<DrawIndexedBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DrawIndexedBuilder>(7, Inserters::attributeIndex).add(DrawIndexed.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(DrawIndexed.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(DrawIndexed.FeatureIDs.INDEX_COUNT, (builder, value) -> builder.indexCount((int) value)).add(DrawIndexed.FeatureIDs.INSTANCE_COUNT, (builder, value) -> builder.instanceCount((int) value)).add(DrawIndexed.FeatureIDs.FIRST_INDEX, (builder, value) -> builder.firstIndex((int) value)).add(DrawIndexed.FeatureIDs.VERTEX_OFFSET, (builder, value) -> builder.vertexOffset((int) value)).add(DrawIndexed.FeatureIDs.FIRST_INSTANCE, (builder, value) -> builder.firstInstance((int) value)).build();
    private static final RelationLazyInserter<DrawIndexedBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DrawIndexedBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DrawIndexed.FeatureIDs.NAME -> 0;
        case DrawIndexed.FeatureIDs.ENABLED -> 1;
        case DrawIndexed.FeatureIDs.INDEX_COUNT -> 2;
        case DrawIndexed.FeatureIDs.INSTANCE_COUNT -> 3;
        case DrawIndexed.FeatureIDs.FIRST_INDEX -> 4;
        case DrawIndexed.FeatureIDs.VERTEX_OFFSET -> 5;
        case DrawIndexed.FeatureIDs.FIRST_INSTANCE -> 6;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
