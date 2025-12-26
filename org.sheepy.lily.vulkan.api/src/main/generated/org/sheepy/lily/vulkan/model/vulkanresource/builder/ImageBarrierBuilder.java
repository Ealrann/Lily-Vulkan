package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageBarrier.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.ImageBarrierImpl;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public final class ImageBarrierBuilder implements Builder {
  private String name;
  private final List<EAccess> srcAccessMask = new ArrayList<>();
  private final List<EAccess> dstAccessMask = new ArrayList<>();
  private EImageLayout srcLayout = EImageLayout.UNDEFINED;
  private EImageLayout dstLayout = EImageLayout.UNDEFINED;
  private Supplier<IVulkanImage> image = () -> null;

  public ImageBarrierBuilder() {
  }

  @Override
  public ImageBarrierBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ImageBarrierBuilder addSrcAccessMask(EAccess srcAccessMask) {
    this.srcAccessMask.add(srcAccessMask);
    return this;
  }

  @Override
  public ImageBarrierBuilder addSrcAccessMask(final List<EAccess> srcAccessMask) {
    this.srcAccessMask.addAll(srcAccessMask);
    return this;
  }

  @Override
  public ImageBarrierBuilder addDstAccessMask(EAccess dstAccessMask) {
    this.dstAccessMask.add(dstAccessMask);
    return this;
  }

  @Override
  public ImageBarrierBuilder addDstAccessMask(final List<EAccess> dstAccessMask) {
    this.dstAccessMask.addAll(dstAccessMask);
    return this;
  }

  @Override
  public ImageBarrierBuilder srcLayout(EImageLayout srcLayout) {
    this.srcLayout = srcLayout;
    return this;
  }

  @Override
  public ImageBarrierBuilder dstLayout(EImageLayout dstLayout) {
    this.dstLayout = dstLayout;
    return this;
  }

  @Override
  public ImageBarrierBuilder image(Supplier<IVulkanImage> image) {
    this.image = image;
    return this;
  }

  @Override
  public ImageBarrier build() {
    final var built = new ImageBarrierImpl(name);
    built.srcAccessMask().addAll(srcAccessMask);
    built.dstAccessMask().addAll(dstAccessMask);
    built.srcLayout(srcLayout);
    built.dstLayout(dstLayout);
    built.image(image.get());
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
    private static final FeatureInserter<ImageBarrierBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageBarrierBuilder>(5, Inserters::attributeIndex).add(ImageBarrier.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ImageBarrier.FeatureIDs.SRC_ACCESS_MASK, (builder, value) -> builder.addSrcAccessMask((EAccess) value)).add(ImageBarrier.FeatureIDs.DST_ACCESS_MASK, (builder, value) -> builder.addDstAccessMask((EAccess) value)).add(ImageBarrier.FeatureIDs.SRC_LAYOUT, (builder, value) -> builder.srcLayout((EImageLayout) value)).add(ImageBarrier.FeatureIDs.DST_LAYOUT, (builder, value) -> builder.dstLayout((EImageLayout) value)).build();
    private static final RelationLazyInserter<ImageBarrierBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageBarrierBuilder>(1, Inserters::relationIndex).add(ImageBarrier.FeatureIDs.IMAGE, (builder, value) -> builder.image((Supplier<IVulkanImage>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageBarrier.FeatureIDs.NAME -> 0;
        case ImageBarrier.FeatureIDs.SRC_ACCESS_MASK -> 1;
        case ImageBarrier.FeatureIDs.DST_ACCESS_MASK -> 2;
        case ImageBarrier.FeatureIDs.SRC_LAYOUT -> 3;
        case ImageBarrier.FeatureIDs.DST_LAYOUT -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ImageBarrier.FeatureIDs.IMAGE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
