package org.sheepy.vulkan.model.pipeline.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant.Builder;
import org.sheepy.vulkan.model.pipeline.impl.SpecializationConstantImpl;

public final class SpecializationConstantBuilder implements Builder {
  private String name;
  private int constantId;
  private int size;

  public SpecializationConstantBuilder() {
  }

  @Override
  public SpecializationConstantBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SpecializationConstantBuilder constantId(int constantId) {
    this.constantId = constantId;
    return this;
  }

  @Override
  public SpecializationConstantBuilder size(int size) {
    this.size = size;
    return this;
  }

  @Override
  public SpecializationConstant build() {
    final var built = new SpecializationConstantImpl();
    built.name(name);
    built.constantId(constantId);
    built.size(size);
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
    private static final FeatureInserter<SpecializationConstantBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SpecializationConstantBuilder>(3, Inserters::attributeIndex).add(SpecializationConstant.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(SpecializationConstant.FeatureIDs.CONSTANT_ID, (builder, value) -> builder.constantId((int) value)).add(SpecializationConstant.FeatureIDs.SIZE, (builder, value) -> builder.size((int) value)).build();
    private static final RelationLazyInserter<SpecializationConstantBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SpecializationConstantBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SpecializationConstant.FeatureIDs.NAME -> 0;
        case SpecializationConstant.FeatureIDs.CONSTANT_ID -> 1;
        case SpecializationConstant.FeatureIDs.SIZE -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
