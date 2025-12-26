package org.sheepy.lily.vulkan.model.process.graphic.builder;

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
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicExecutionManagerImpl;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class GraphicExecutionManagerBuilder implements Builder {
  private final List<Supplier<ProcessExecutionManager>> waitForExecution = new ArrayList<>();
  private final List<Supplier<ProcessExecutionManager>> waitedBy = new ArrayList<>();
  private EPipelineStage waitStage = EPipelineStage.TOP_OF_PIPE_BIT;
  private Supplier<IExecutionAcquirer> acquirer = () -> null;
  private final List<Supplier<GraphicExecutionRecorder>> recorders = new ArrayList<>();
  private final List<Supplier<GraphicCommandBuffer>> commandBuffers = new ArrayList<>();

  public GraphicExecutionManagerBuilder() {
  }

  @Override
  public GraphicExecutionManagerBuilder addWaitForExecution(
      Supplier<ProcessExecutionManager> waitForExecution) {
    this.waitForExecution.add(waitForExecution);
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder addWaitForExecution(
      final List<ProcessExecutionManager> waitForExecution) {
    waitForExecution.forEach(value -> this.waitForExecution.add(() -> value));
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder addWaitedBy(Supplier<ProcessExecutionManager> waitedBy) {
    this.waitedBy.add(waitedBy);
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder addWaitedBy(final List<ProcessExecutionManager> waitedBy) {
    waitedBy.forEach(value -> this.waitedBy.add(() -> value));
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder waitStage(EPipelineStage waitStage) {
    this.waitStage = waitStage;
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder acquirer(Supplier<IExecutionAcquirer> acquirer) {
    this.acquirer = acquirer;
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder addRecorder(Supplier<GraphicExecutionRecorder> recorder) {
    this.recorders.add(recorder);
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder addRecorders(
      final List<GraphicExecutionRecorder> recorders) {
    recorders.forEach(value -> this.recorders.add(() -> value));
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder addCommandBuffer(
      Supplier<GraphicCommandBuffer> commandBuffer) {
    this.commandBuffers.add(commandBuffer);
    return this;
  }

  @Override
  public GraphicExecutionManagerBuilder addCommandBuffers(
      final List<GraphicCommandBuffer> commandBuffers) {
    commandBuffers.forEach(value -> this.commandBuffers.add(() -> value));
    return this;
  }

  @Override
  public GraphicExecutionManager build() {
    final var builtRecorders = BuildUtils.collectSuppliers(recorders);
    final var builtCommandBuffers = BuildUtils.collectSuppliers(commandBuffers);
    final var built = new GraphicExecutionManagerImpl(waitForExecution, waitedBy);
    built.waitStage(waitStage);
    built.acquirer(acquirer.get());
    built.recorders().addAll(builtRecorders);
    built.commandBuffers().addAll(builtCommandBuffers);
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
    private static final FeatureInserter<GraphicExecutionManagerBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GraphicExecutionManagerBuilder>(1, Inserters::attributeIndex).add(GraphicExecutionManager.FeatureIDs.WAIT_STAGE, (builder, value) -> builder.waitStage((EPipelineStage) value)).build();
    private static final RelationLazyInserter<GraphicExecutionManagerBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GraphicExecutionManagerBuilder>(5, Inserters::relationIndex).add(GraphicExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION, (builder, value) -> builder.addWaitForExecution((Supplier<ProcessExecutionManager>) value)).add(GraphicExecutionManager.FeatureIDs.WAITED_BY, (builder, value) -> builder.addWaitedBy((Supplier<ProcessExecutionManager>) value)).add(GraphicExecutionManager.FeatureIDs.ACQUIRER, (builder, value) -> builder.acquirer((Supplier<IExecutionAcquirer>) value)).add(GraphicExecutionManager.FeatureIDs.RECORDERS, (builder, value) -> builder.addRecorder((Supplier<GraphicExecutionRecorder>) value)).add(GraphicExecutionManager.FeatureIDs.COMMAND_BUFFERS, (builder, value) -> builder.addCommandBuffer((Supplier<GraphicCommandBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case GraphicExecutionManager.FeatureIDs.WAIT_STAGE -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case GraphicExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION -> 0;
        case GraphicExecutionManager.FeatureIDs.WAITED_BY -> 1;
        case GraphicExecutionManager.FeatureIDs.ACQUIRER -> 2;
        case GraphicExecutionManager.FeatureIDs.RECORDERS -> 3;
        case GraphicExecutionManager.FeatureIDs.COMMAND_BUFFERS -> 4;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
