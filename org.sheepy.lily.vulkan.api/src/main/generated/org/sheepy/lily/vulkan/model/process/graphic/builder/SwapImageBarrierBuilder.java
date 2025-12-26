package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier;
import org.sheepy.lily.vulkan.model.process.graphic.SwapImageBarrier.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.SwapImageBarrierImpl;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public final class SwapImageBarrierBuilder implements Builder {
  private String name;
  private final List<EAccess> srcAccessMask = new ArrayList<>();
  private final List<EAccess> dstAccessMask = new ArrayList<>();
  private EImageLayout srcLayout = EImageLayout.UNDEFINED;
  private EImageLayout dstLayout = EImageLayout.UNDEFINED;

  public SwapImageBarrierBuilder() {
  }

  @Override
  public SwapImageBarrierBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public SwapImageBarrierBuilder addSrcAccessMask(EAccess srcAccessMask) {
    this.srcAccessMask.add(srcAccessMask);
    return this;
  }

  @Override
  public SwapImageBarrierBuilder addSrcAccessMask(final List<EAccess> srcAccessMask) {
    this.srcAccessMask.addAll(srcAccessMask);
    return this;
  }

  @Override
  public SwapImageBarrierBuilder addDstAccessMask(EAccess dstAccessMask) {
    this.dstAccessMask.add(dstAccessMask);
    return this;
  }

  @Override
  public SwapImageBarrierBuilder addDstAccessMask(final List<EAccess> dstAccessMask) {
    this.dstAccessMask.addAll(dstAccessMask);
    return this;
  }

  @Override
  public SwapImageBarrierBuilder srcLayout(EImageLayout srcLayout) {
    this.srcLayout = srcLayout;
    return this;
  }

  @Override
  public SwapImageBarrierBuilder dstLayout(EImageLayout dstLayout) {
    this.dstLayout = dstLayout;
    return this;
  }

  @Override
  public SwapImageBarrier build() {
    final var built = new SwapImageBarrierImpl(name);
    built.srcAccessMask().addAll(srcAccessMask);
    built.dstAccessMask().addAll(dstAccessMask);
    built.srcLayout(srcLayout);
    built.dstLayout(dstLayout);
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
    private static final FeatureInserter<SwapImageBarrierBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SwapImageBarrierBuilder>(5, Inserters::attributeIndex).add(SwapImageBarrier.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(SwapImageBarrier.FeatureIDs.SRC_ACCESS_MASK, (builder, value) -> builder.addSrcAccessMask((EAccess) value)).add(SwapImageBarrier.FeatureIDs.DST_ACCESS_MASK, (builder, value) -> builder.addDstAccessMask((EAccess) value)).add(SwapImageBarrier.FeatureIDs.SRC_LAYOUT, (builder, value) -> builder.srcLayout((EImageLayout) value)).add(SwapImageBarrier.FeatureIDs.DST_LAYOUT, (builder, value) -> builder.dstLayout((EImageLayout) value)).build();
    private static final RelationLazyInserter<SwapImageBarrierBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SwapImageBarrierBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case SwapImageBarrier.FeatureIDs.NAME -> 0;
        case SwapImageBarrier.FeatureIDs.SRC_ACCESS_MASK -> 1;
        case SwapImageBarrier.FeatureIDs.DST_ACCESS_MASK -> 2;
        case SwapImageBarrier.FeatureIDs.SRC_LAYOUT -> 3;
        case SwapImageBarrier.FeatureIDs.DST_LAYOUT -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
