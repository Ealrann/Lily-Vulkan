package org.sheepy.lily.vulkan.model.process.compute;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeExecutionRecorderBuilder;

public interface ComputeExecutionRecorder extends ExecutionRecorder {
  static Builder builder() {
    return new ComputeExecutionRecorderBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ComputeCommandBuffer commandBuffer();
  void commandBuffer(final ComputeCommandBuffer commandBuffer);

  interface FeatureIDs {
    int SUBMISSION = ExecutionRecorder.FeatureIDs.SUBMISSION;
    int COMMAND_BUFFER = -235131512;
  }

  interface Features<T extends Features<T>> extends ExecutionRecorder.Features<T> {
    Relation<Submission, Submission, Listener<Submission>, ExecutionRecorder.Features<?>> SUBMISSION = ExecutionRecorder.Features.SUBMISSION;
    Relation<ComputeCommandBuffer, ComputeCommandBuffer, Listener<ComputeCommandBuffer>, Features<?>> COMMAND_BUFFER = new RelationBuilder<ComputeCommandBuffer, ComputeCommandBuffer, Listener<ComputeCommandBuffer>, Features<?>>().name("commandBuffer").mandatory(true).id(ComputeExecutionRecorder.FeatureIDs.COMMAND_BUFFER).concept(() -> ComputeModelDefinition.Groups.COMPUTE_COMMAND_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(SUBMISSION, COMMAND_BUFFER);
  }

  interface Builder extends IFeaturedObject.Builder<ComputeExecutionRecorder> {
    Builder submission(Supplier<Submission> submission);
    Builder commandBuffer(Supplier<ComputeCommandBuffer> commandBuffer);
  }
}
