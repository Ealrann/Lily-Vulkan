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
import org.sheepy.lily.core.model.resource.FileImage;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.sprite.Sprite;
import org.sheepy.lily.vulkan.extra.model.sprite.Sprite.Builder;
import org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteImpl;

public final class SpriteBuilder implements Builder {
  private String name;
  private final List<Supplier<PresentableEntity>> presentedEntities = new ArrayList<>();
  private Supplier<FileImage> image;

  public SpriteBuilder() {
  }

  @Override
  public SpriteBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SpriteBuilder addPresentedEntitie(Supplier<PresentableEntity> presentedEntitie) {
    this.presentedEntities.add(presentedEntitie);
    return this;
  }

  @Override
  public SpriteBuilder addPresentedEntities(final List<PresentableEntity> presentedEntities) {
    presentedEntities.forEach(value -> this.presentedEntities.add(() -> value));
    return this;
  }

  @Override
  public SpriteBuilder image(Supplier<FileImage> image) {
    this.image = image;
    return this;
  }

  @Override
  public Sprite build() {
    final var builtPresentedEntities = BuildUtils.collectSuppliers(presentedEntities);
    final var built = new SpriteImpl(name, image.get());
    built.presentedEntities().addAll(builtPresentedEntities);
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
    private static final FeatureInserter<SpriteBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SpriteBuilder>(1, Inserters::attributeIndex).add(Sprite.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<SpriteBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SpriteBuilder>(2, Inserters::relationIndex).add(Sprite.FeatureIDs.PRESENTED_ENTITIES, (builder, value) -> builder.addPresentedEntitie((Supplier<PresentableEntity>) value)).add(Sprite.FeatureIDs.IMAGE, (builder, value) -> builder.image((Supplier<FileImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Sprite.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Sprite.FeatureIDs.PRESENTED_ENTITIES -> 0;
        case Sprite.FeatureIDs.IMAGE -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
