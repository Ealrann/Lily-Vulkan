package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription;
import org.sheepy.lily.vulkan.model.process.graphic.AttributeDescription.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttributeDescriptionImpl;
import org.sheepy.vulkan.model.enumeration.EFormat;

public final class AttributeDescriptionBuilder implements Builder {
  private String name;
  private EFormat format = EFormat.UNDEFINED;
  private int offset;

  public AttributeDescriptionBuilder() {
  }

  @Override
  public AttributeDescriptionBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public AttributeDescriptionBuilder format(EFormat format) {
    this.format = format;
    return this;
  }

  @Override
  public AttributeDescriptionBuilder offset(int offset) {
    this.offset = offset;
    return this;
  }

  @Override
  public AttributeDescription build() {
    final var built = new AttributeDescriptionImpl(name);
    built.format(format);
    built.offset(offset);
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
    private static final FeatureInserter<AttributeDescriptionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<AttributeDescriptionBuilder>(3, Inserters::attributeIndex).add(AttributeDescription.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(AttributeDescription.FeatureIDs.FORMAT, (builder, value) -> builder.format((EFormat) value)).add(AttributeDescription.FeatureIDs.OFFSET, (builder, value) -> builder.offset((int) value)).build();
    private static final RelationLazyInserter<AttributeDescriptionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<AttributeDescriptionBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case AttributeDescription.FeatureIDs.NAME -> 0;
        case AttributeDescription.FeatureIDs.FORMAT -> 1;
        case AttributeDescription.FeatureIDs.OFFSET -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
