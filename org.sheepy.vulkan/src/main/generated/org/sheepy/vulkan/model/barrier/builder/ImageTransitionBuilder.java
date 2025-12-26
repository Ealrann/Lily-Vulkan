package org.sheepy.vulkan.model.barrier.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.barrier.ImageTransition;
import org.sheepy.vulkan.model.barrier.ImageTransition.Builder;
import org.sheepy.vulkan.model.barrier.impl.ImageTransitionImpl;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public final class ImageTransitionBuilder implements Builder {
  private EImageLayout srcLayout = EImageLayout.UNDEFINED;
  private EImageLayout dstLayout = EImageLayout.UNDEFINED;
  private final List<EAccess> srcAccessMask = new ArrayList<>();
  private final List<EAccess> dstAccessMask = new ArrayList<>();

  public ImageTransitionBuilder() {
  }

  @Override
  public ImageTransitionBuilder srcLayout(EImageLayout srcLayout) {
    this.srcLayout = srcLayout;
    return this;
  }

  @Override
  public ImageTransitionBuilder dstLayout(EImageLayout dstLayout) {
    this.dstLayout = dstLayout;
    return this;
  }

  @Override
  public ImageTransitionBuilder addSrcAccessMask(EAccess srcAccessMask) {
    this.srcAccessMask.add(srcAccessMask);
    return this;
  }

  @Override
  public ImageTransitionBuilder addSrcAccessMask(final List<EAccess> srcAccessMask) {
    this.srcAccessMask.addAll(srcAccessMask);
    return this;
  }

  @Override
  public ImageTransitionBuilder addDstAccessMask(EAccess dstAccessMask) {
    this.dstAccessMask.add(dstAccessMask);
    return this;
  }

  @Override
  public ImageTransitionBuilder addDstAccessMask(final List<EAccess> dstAccessMask) {
    this.dstAccessMask.addAll(dstAccessMask);
    return this;
  }

  @Override
  public ImageTransition build() {
    final var built = new ImageTransitionImpl();
    built.srcLayout(srcLayout);
    built.dstLayout(dstLayout);
    built.srcAccessMask().addAll(srcAccessMask);
    built.dstAccessMask().addAll(dstAccessMask);
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
    private static final FeatureInserter<ImageTransitionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageTransitionBuilder>(4, Inserters::attributeIndex).add(ImageTransition.FeatureIDs.SRC_LAYOUT, (builder, value) -> builder.srcLayout((EImageLayout) value)).add(ImageTransition.FeatureIDs.DST_LAYOUT, (builder, value) -> builder.dstLayout((EImageLayout) value)).add(ImageTransition.FeatureIDs.SRC_ACCESS_MASK, (builder, value) -> builder.addSrcAccessMask((EAccess) value)).add(ImageTransition.FeatureIDs.DST_ACCESS_MASK, (builder, value) -> builder.addDstAccessMask((EAccess) value)).build();
    private static final RelationLazyInserter<ImageTransitionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageTransitionBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageTransition.FeatureIDs.SRC_LAYOUT -> 0;
        case ImageTransition.FeatureIDs.DST_LAYOUT -> 1;
        case ImageTransition.FeatureIDs.SRC_ACCESS_MASK -> 2;
        case ImageTransition.FeatureIDs.DST_ACCESS_MASK -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
