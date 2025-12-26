package org.sheepy.lily.vulkan.model.process.compute.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager.Builder;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputeExecutionManagerImpl;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class ComputeExecutionManagerBuilder implements Builder {
  private final List<Supplier<ProcessExecutionManager>> waitForExecution = new ArrayList<>();
  private final List<Supplier<ProcessExecutionManager>> waitedBy = new ArrayList<>();
  private EPipelineStage waitStage = EPipelineStage.TOP_OF_PIPE_BIT;
  private Supplier<IExecutionAcquirer> acquirer = () -> null;
  private final List<Supplier<ComputeExecutionRecorder>> recorders = new ArrayList<>();
  private int indexCount = 1;
  private final List<Supplier<ComputeCommandBuffer>> CommandBuffers = new ArrayList<>();

  public ComputeExecutionManagerBuilder() {
  }

  @Override
  public ComputeExecutionManagerBuilder addWaitForExecution(
      Supplier<ProcessExecutionManager> waitForExecution) {
    this.waitForExecution.add(waitForExecution);
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder addWaitForExecution(
      final List<ProcessExecutionManager> waitForExecution) {
    waitForExecution.forEach(value -> this.waitForExecution.add(() -> value));
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder addWaitedBy(Supplier<ProcessExecutionManager> waitedBy) {
    this.waitedBy.add(waitedBy);
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder addWaitedBy(final List<ProcessExecutionManager> waitedBy) {
    waitedBy.forEach(value -> this.waitedBy.add(() -> value));
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder waitStage(EPipelineStage waitStage) {
    this.waitStage = waitStage;
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder acquirer(Supplier<IExecutionAcquirer> acquirer) {
    this.acquirer = acquirer;
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder addRecorder(Supplier<ComputeExecutionRecorder> recorder) {
    this.recorders.add(recorder);
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder addRecorders(
      final List<ComputeExecutionRecorder> recorders) {
    recorders.forEach(value -> this.recorders.add(() -> value));
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder indexCount(int indexCount) {
    this.indexCount = indexCount;
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder addCommandBuffer(
      Supplier<ComputeCommandBuffer> CommandBuffer) {
    this.CommandBuffers.add(CommandBuffer);
    return this;
  }

  @Override
  public ComputeExecutionManagerBuilder addCommandBuffers(
      final List<ComputeCommandBuffer> CommandBuffers) {
    CommandBuffers.forEach(value -> this.CommandBuffers.add(() -> value));
    return this;
  }

  @Override
  public ComputeExecutionManager build() {
    final var builtRecorders = BuildUtils.collectSuppliers(recorders);
    final var builtCommandBuffers = BuildUtils.collectSuppliers(CommandBuffers);
    final var built = new ComputeExecutionManagerImpl(waitForExecution, waitedBy, indexCount);
    built.waitStage(waitStage);
    built.acquirer(acquirer.get());
    built.recorders().addAll(builtRecorders);
    built.CommandBuffers().addAll(builtCommandBuffers);
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
    private static final FeatureInserter<ComputeExecutionManagerBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ComputeExecutionManagerBuilder>(2, Inserters::attributeIndex).add(ComputeExecutionManager.FeatureIDs.WAIT_STAGE, (builder, value) -> builder.waitStage((EPipelineStage) value)).add(ComputeExecutionManager.FeatureIDs.INDEX_COUNT, (builder, value) -> builder.indexCount((int) value)).build();
    private static final RelationLazyInserter<ComputeExecutionManagerBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ComputeExecutionManagerBuilder>(5, Inserters::relationIndex).add(ComputeExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION, (builder, value) -> builder.addWaitForExecution((Supplier<ProcessExecutionManager>) value)).add(ComputeExecutionManager.FeatureIDs.WAITED_BY, (builder, value) -> builder.addWaitedBy((Supplier<ProcessExecutionManager>) value)).add(ComputeExecutionManager.FeatureIDs.ACQUIRER, (builder, value) -> builder.acquirer((Supplier<IExecutionAcquirer>) value)).add(ComputeExecutionManager.FeatureIDs.RECORDERS, (builder, value) -> builder.addRecorder((Supplier<ComputeExecutionRecorder>) value)).add(ComputeExecutionManager.FeatureIDs.COMMAND_BUFFERS, (builder, value) -> builder.addCommandBuffer((Supplier<ComputeCommandBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ComputeExecutionManager.FeatureIDs.WAIT_STAGE -> 0;
        case ComputeExecutionManager.FeatureIDs.INDEX_COUNT -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ComputeExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION -> 0;
        case ComputeExecutionManager.FeatureIDs.WAITED_BY -> 1;
        case ComputeExecutionManager.FeatureIDs.ACQUIRER -> 2;
        case ComputeExecutionManager.FeatureIDs.RECORDERS -> 3;
        case ComputeExecutionManager.FeatureIDs.COMMAND_BUFFERS -> 4;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
