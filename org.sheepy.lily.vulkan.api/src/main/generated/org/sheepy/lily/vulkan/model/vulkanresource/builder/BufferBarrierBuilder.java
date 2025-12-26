package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferBarrierImpl;
import org.sheepy.vulkan.model.enumeration.EAccess;

public final class BufferBarrierBuilder implements Builder {
  private String name;
  private final List<EAccess> srcAccessMask = new ArrayList<>();
  private final List<EAccess> dstAccessMask = new ArrayList<>();
  private Supplier<BufferReference> buffers;

  public BufferBarrierBuilder() {
  }

  @Override
  public BufferBarrierBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BufferBarrierBuilder addSrcAccessMask(EAccess srcAccessMask) {
    this.srcAccessMask.add(srcAccessMask);
    return this;
  }

  @Override
  public BufferBarrierBuilder addSrcAccessMask(final List<EAccess> srcAccessMask) {
    this.srcAccessMask.addAll(srcAccessMask);
    return this;
  }

  @Override
  public BufferBarrierBuilder addDstAccessMask(EAccess dstAccessMask) {
    this.dstAccessMask.add(dstAccessMask);
    return this;
  }

  @Override
  public BufferBarrierBuilder addDstAccessMask(final List<EAccess> dstAccessMask) {
    this.dstAccessMask.addAll(dstAccessMask);
    return this;
  }

  @Override
  public BufferBarrierBuilder buffers(Supplier<BufferReference> buffers) {
    this.buffers = buffers;
    return this;
  }

  @Override
  public BufferBarrier build() {
    final var built = new BufferBarrierImpl(name, buffers.get());
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
    private static final FeatureInserter<BufferBarrierBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BufferBarrierBuilder>(3, Inserters::attributeIndex).add(BufferBarrier.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(BufferBarrier.FeatureIDs.SRC_ACCESS_MASK, (builder, value) -> builder.addSrcAccessMask((EAccess) value)).add(BufferBarrier.FeatureIDs.DST_ACCESS_MASK, (builder, value) -> builder.addDstAccessMask((EAccess) value)).build();
    private static final RelationLazyInserter<BufferBarrierBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BufferBarrierBuilder>(1, Inserters::relationIndex).add(BufferBarrier.FeatureIDs.BUFFERS, (builder, value) -> builder.buffers((Supplier<BufferReference>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BufferBarrier.FeatureIDs.NAME -> 0;
        case BufferBarrier.FeatureIDs.SRC_ACCESS_MASK -> 1;
        case BufferBarrier.FeatureIDs.DST_ACCESS_MASK -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BufferBarrier.FeatureIDs.BUFFERS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
