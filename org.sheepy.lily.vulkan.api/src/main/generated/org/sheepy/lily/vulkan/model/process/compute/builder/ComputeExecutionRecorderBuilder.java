package org.sheepy.lily.vulkan.model.process.compute.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder.Builder;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputeExecutionRecorderImpl;

public final class ComputeExecutionRecorderBuilder implements Builder {
  private Supplier<Submission> submission;
  private Supplier<ComputeCommandBuffer> commandBuffer;

  public ComputeExecutionRecorderBuilder() {
  }

  @Override
  public ComputeExecutionRecorderBuilder submission(Supplier<Submission> submission) {
    this.submission = submission;
    return this;
  }

  @Override
  public ComputeExecutionRecorderBuilder commandBuffer(
      Supplier<ComputeCommandBuffer> commandBuffer) {
    this.commandBuffer = commandBuffer;
    return this;
  }

  @Override
  public ComputeExecutionRecorder build() {
    final var built = new ComputeExecutionRecorderImpl(submission.get(), commandBuffer.get());
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
    private static final FeatureInserter<ComputeExecutionRecorderBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ComputeExecutionRecorderBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ComputeExecutionRecorderBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ComputeExecutionRecorderBuilder>(2, Inserters::relationIndex).add(ComputeExecutionRecorder.FeatureIDs.SUBMISSION, (builder, value) -> builder.submission((Supplier<Submission>) value)).add(ComputeExecutionRecorder.FeatureIDs.COMMAND_BUFFER, (builder, value) -> builder.commandBuffer((Supplier<ComputeCommandBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ComputeExecutionRecorder.FeatureIDs.SUBMISSION -> 0;
        case ComputeExecutionRecorder.FeatureIDs.COMMAND_BUFFER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
