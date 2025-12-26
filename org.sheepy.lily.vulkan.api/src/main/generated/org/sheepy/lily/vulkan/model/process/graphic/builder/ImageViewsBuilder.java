package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews;
import org.sheepy.lily.vulkan.model.process.graphic.ImageViews.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ImageViewsImpl;

public final class ImageViewsBuilder implements Builder {
  public ImageViewsBuilder() {
  }

  @Override
  public ImageViews build() {
    final var built = new ImageViewsImpl();
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
    private static final FeatureInserter<ImageViewsBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageViewsBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ImageViewsBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageViewsBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
