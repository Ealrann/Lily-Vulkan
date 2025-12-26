package org.sheepy.lily.vulkan.model.process.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier.Builder;
import org.sheepy.lily.vulkan.model.process.impl.PipelineBarrierImpl;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class PipelineBarrierBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private final List<Supplier<Barrier>> barriers = new ArrayList<>();
  private EPipelineStage srcStage = EPipelineStage.TOP_OF_PIPE_BIT;
  private EPipelineStage dstStage = EPipelineStage.TOP_OF_PIPE_BIT;
  private Supplier<AbstractProcess> srcQueue = () -> null;
  private Supplier<AbstractProcess> dstQueue = () -> null;

  public PipelineBarrierBuilder() {
  }

  @Override
  public PipelineBarrierBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public PipelineBarrierBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public PipelineBarrierBuilder addBarrier(Supplier<Barrier> barrier) {
    this.barriers.add(barrier);
    return this;
  }

  @Override
  public PipelineBarrierBuilder addBarriers(final List<Barrier> barriers) {
    barriers.forEach(value -> this.barriers.add(() -> value));
    return this;
  }

  @Override
  public PipelineBarrierBuilder srcStage(EPipelineStage srcStage) {
    this.srcStage = srcStage;
    return this;
  }

  @Override
  public PipelineBarrierBuilder dstStage(EPipelineStage dstStage) {
    this.dstStage = dstStage;
    return this;
  }

  @Override
  public PipelineBarrierBuilder srcQueue(Supplier<AbstractProcess> srcQueue) {
    this.srcQueue = srcQueue;
    return this;
  }

  @Override
  public PipelineBarrierBuilder dstQueue(Supplier<AbstractProcess> dstQueue) {
    this.dstQueue = dstQueue;
    return this;
  }

  @Override
  public PipelineBarrier build() {
    final var builtBarriers = BuildUtils.collectSuppliers(barriers);
    final var built = new PipelineBarrierImpl(name, builtBarriers);
    built.enabled(enabled);
    built.srcStage(srcStage);
    built.dstStage(dstStage);
    built.srcQueue(srcQueue.get());
    built.dstQueue(dstQueue.get());
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
    private static final FeatureInserter<PipelineBarrierBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PipelineBarrierBuilder>(4, Inserters::attributeIndex).add(PipelineBarrier.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(PipelineBarrier.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(PipelineBarrier.FeatureIDs.SRC_STAGE, (builder, value) -> builder.srcStage((EPipelineStage) value)).add(PipelineBarrier.FeatureIDs.DST_STAGE, (builder, value) -> builder.dstStage((EPipelineStage) value)).build();
    private static final RelationLazyInserter<PipelineBarrierBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PipelineBarrierBuilder>(3, Inserters::relationIndex).add(PipelineBarrier.FeatureIDs.BARRIERS, (builder, value) -> builder.addBarrier((Supplier<Barrier>) value)).add(PipelineBarrier.FeatureIDs.SRC_QUEUE, (builder, value) -> builder.srcQueue((Supplier<AbstractProcess>) value)).add(PipelineBarrier.FeatureIDs.DST_QUEUE, (builder, value) -> builder.dstQueue((Supplier<AbstractProcess>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case PipelineBarrier.FeatureIDs.NAME -> 0;
        case PipelineBarrier.FeatureIDs.ENABLED -> 1;
        case PipelineBarrier.FeatureIDs.SRC_STAGE -> 2;
        case PipelineBarrier.FeatureIDs.DST_STAGE -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case PipelineBarrier.FeatureIDs.BARRIERS -> 0;
        case PipelineBarrier.FeatureIDs.SRC_QUEUE -> 1;
        case PipelineBarrier.FeatureIDs.DST_QUEUE -> 2;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
