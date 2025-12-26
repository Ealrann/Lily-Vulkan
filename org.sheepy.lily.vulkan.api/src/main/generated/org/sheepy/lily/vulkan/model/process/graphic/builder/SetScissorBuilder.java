package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor;
import org.sheepy.lily.vulkan.model.process.graphic.SetScissor.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SetScissorImpl;

public final class SetScissorBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private int offsetX = 0;
  private int offsetY = 0;
  private int width;
  private int height;

  public SetScissorBuilder() {
  }

  @Override
  public SetScissorBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SetScissorBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public SetScissorBuilder offsetX(int offsetX) {
    this.offsetX = offsetX;
    return this;
  }

  @Override
  public SetScissorBuilder offsetY(int offsetY) {
    this.offsetY = offsetY;
    return this;
  }

  @Override
  public SetScissorBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public SetScissorBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public SetScissor build() {
    final var built = new SetScissorImpl(name);
    built.enabled(enabled);
    built.offsetX(offsetX);
    built.offsetY(offsetY);
    built.width(width);
    built.height(height);
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
    private static final FeatureInserter<SetScissorBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SetScissorBuilder>(6, Inserters::attributeIndex).add(SetScissor.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(SetScissor.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(SetScissor.FeatureIDs.OFFSETX, (builder, value) -> builder.offsetX((int) value)).add(SetScissor.FeatureIDs.OFFSETY, (builder, value) -> builder.offsetY((int) value)).add(SetScissor.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(SetScissor.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).build();
    private static final RelationLazyInserter<SetScissorBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SetScissorBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SetScissor.FeatureIDs.NAME -> 0;
        case SetScissor.FeatureIDs.ENABLED -> 1;
        case SetScissor.FeatureIDs.OFFSETX -> 2;
        case SetScissor.FeatureIDs.OFFSETY -> 3;
        case SetScissor.FeatureIDs.WIDTH -> 4;
        case SetScissor.FeatureIDs.HEIGHT -> 5;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
