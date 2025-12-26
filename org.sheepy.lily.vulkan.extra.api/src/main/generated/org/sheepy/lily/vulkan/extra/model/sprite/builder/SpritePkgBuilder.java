package org.sheepy.lily.vulkan.extra.model.sprite.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePkg;
import org.sheepy.lily.vulkan.extra.model.sprite.SpritePkg.Builder;
import org.sheepy.lily.vulkan.extra.model.sprite.impl.SpritePkgImpl;

public final class SpritePkgBuilder implements Builder {
  private String name;
  private final List<Supplier<Sprite>> sprites = new ArrayList<>();

  public SpritePkgBuilder() {
  }

  @Override
  public SpritePkgBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SpritePkgBuilder addSprite(Supplier<Sprite> sprite) {
    this.sprites.add(sprite);
    return this;
  }

  @Override
  public SpritePkgBuilder addSprites(final List<Sprite> sprites) {
    sprites.forEach(value -> this.sprites.add(() -> value));
    return this;
  }

  @Override
  public SpritePkg build() {
    final var builtSprites = BuildUtils.collectSuppliers(sprites);
    final var built = new SpritePkgImpl(name);
    built.sprites().addAll(builtSprites);
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
    private static final FeatureInserter<SpritePkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SpritePkgBuilder>(1, Inserters::attributeIndex).add(SpritePkg.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<SpritePkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SpritePkgBuilder>(1, Inserters::relationIndex).add(SpritePkg.FeatureIDs.SPRITES, (builder, value) -> builder.addSprite((Supplier<Sprite>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SpritePkg.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case SpritePkg.FeatureIDs.SPRITES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
