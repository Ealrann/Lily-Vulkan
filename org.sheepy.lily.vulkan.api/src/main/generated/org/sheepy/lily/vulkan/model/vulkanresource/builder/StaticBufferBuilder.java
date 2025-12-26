package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.StaticBufferImpl;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public final class StaticBufferBuilder implements Builder {
  private String name;
  private final List<EBufferUsage> usages = new ArrayList<>();
  private long size;
  private boolean initWithZero = false;

  public StaticBufferBuilder() {
  }

  @Override
  public StaticBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public StaticBufferBuilder addUsage(EBufferUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public StaticBufferBuilder addUsages(final List<EBufferUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public StaticBufferBuilder size(long size) {
    this.size = size;
    return this;
  }

  @Override
  public StaticBufferBuilder initWithZero(boolean initWithZero) {
    this.initWithZero = initWithZero;
    return this;
  }

  @Override
  public StaticBuffer build() {
    final var built = new StaticBufferImpl(name);
    built.usages().addAll(usages);
    built.size(size);
    built.initWithZero(initWithZero);
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
    private static final FeatureInserter<StaticBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<StaticBufferBuilder>(4, Inserters::attributeIndex).add(StaticBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(StaticBuffer.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EBufferUsage) value)).add(StaticBuffer.FeatureIDs.SIZE, (builder, value) -> builder.size((long) value)).add(StaticBuffer.FeatureIDs.INIT_WITH_ZERO, (builder, value) -> builder.initWithZero((boolean) value)).build();
    private static final RelationLazyInserter<StaticBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<StaticBufferBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case StaticBuffer.FeatureIDs.NAME -> 0;
        case StaticBuffer.FeatureIDs.USAGES -> 1;
        case StaticBuffer.FeatureIDs.SIZE -> 2;
        case StaticBuffer.FeatureIDs.INIT_WITH_ZERO -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
