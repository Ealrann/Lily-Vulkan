package org.sheepy.lily.vulkan.extra.model.nuklear.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont.Builder;
import org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearFontImpl;

public final class NuklearFontBuilder implements Builder {
  private String name;

  public NuklearFontBuilder() {
  }

  @Override
  public NuklearFontBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public NuklearFont build() {
    final var built = new NuklearFontImpl(name);
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
    private static final FeatureInserter<NuklearFontBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<NuklearFontBuilder>(1, Inserters::attributeIndex).add(NuklearFont.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<NuklearFontBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<NuklearFontBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case NuklearFont.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
