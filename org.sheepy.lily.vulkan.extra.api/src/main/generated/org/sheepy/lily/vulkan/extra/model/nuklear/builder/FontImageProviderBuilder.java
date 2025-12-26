package org.sheepy.lily.vulkan.extra.model.nuklear.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider;
import org.sheepy.lily.vulkan.extra.model.nuklear.FontImageProvider.Builder;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.impl.FontImageProviderImpl;

public final class FontImageProviderBuilder implements Builder {
  private String name;
  private Supplier<NuklearFont> nuklearFont;

  public FontImageProviderBuilder() {
  }

  @Override
  public FontImageProviderBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FontImageProviderBuilder nuklearFont(Supplier<NuklearFont> nuklearFont) {
    this.nuklearFont = nuklearFont;
    return this;
  }

  @Override
  public FontImageProvider build() {
    final var built = new FontImageProviderImpl(name, nuklearFont.get());
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
    private static final FeatureInserter<FontImageProviderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FontImageProviderBuilder>(1, Inserters::attributeIndex).add(FontImageProvider.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<FontImageProviderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FontImageProviderBuilder>(1, Inserters::relationIndex).add(FontImageProvider.FeatureIDs.NUKLEAR_FONT, (builder, value) -> builder.nuklearFont((Supplier<NuklearFont>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case FontImageProvider.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case FontImageProvider.FeatureIDs.NUKLEAR_FONT -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
