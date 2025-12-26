package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDataProvider.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageDataProviderImpl;

public final class ImageDataProviderBuilder implements Builder {
  private String name;

  public ImageDataProviderBuilder() {
  }

  @Override
  public ImageDataProviderBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ImageDataProvider build() {
    final var built = new ImageDataProviderImpl(name);
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
    private static final FeatureInserter<ImageDataProviderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageDataProviderBuilder>(1, Inserters::attributeIndex).add(ImageDataProvider.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<ImageDataProviderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageDataProviderBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageDataProvider.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
