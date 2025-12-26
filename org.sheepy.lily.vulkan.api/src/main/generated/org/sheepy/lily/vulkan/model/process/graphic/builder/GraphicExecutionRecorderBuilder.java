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
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicExecutionRecorderImpl;

public final class GraphicExecutionRecorderBuilder implements Builder {
  private Supplier<Submission> submission;
  private final List<Supplier<GraphicCommandBuffer>> commandBuffers = new ArrayList<>();

  public GraphicExecutionRecorderBuilder() {
  }

  @Override
  public GraphicExecutionRecorderBuilder submission(Supplier<Submission> submission) {
    this.submission = submission;
    return this;
  }

  @Override
  public GraphicExecutionRecorderBuilder addCommandBuffer(
      Supplier<GraphicCommandBuffer> commandBuffer) {
    this.commandBuffers.add(commandBuffer);
    return this;
  }

  @Override
  public GraphicExecutionRecorderBuilder addCommandBuffers(
      final List<GraphicCommandBuffer> commandBuffers) {
    commandBuffers.forEach(value -> this.commandBuffers.add(() -> value));
    return this;
  }

  @Override
  public GraphicExecutionRecorder build() {
    final var builtCommandBuffers = BuildUtils.collectSuppliers(commandBuffers);
    final var built = new GraphicExecutionRecorderImpl(submission.get(), builtCommandBuffers);
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
    private static final FeatureInserter<GraphicExecutionRecorderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GraphicExecutionRecorderBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<GraphicExecutionRecorderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GraphicExecutionRecorderBuilder>(2, Inserters::relationIndex).add(GraphicExecutionRecorder.FeatureIDs.SUBMISSION, (builder, value) -> builder.submission((Supplier<Submission>) value)).add(GraphicExecutionRecorder.FeatureIDs.COMMAND_BUFFERS, (builder, value) -> builder.addCommandBuffer((Supplier<GraphicCommandBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case GraphicExecutionRecorder.FeatureIDs.SUBMISSION -> 0;
        case GraphicExecutionRecorder.FeatureIDs.COMMAND_BUFFERS -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
