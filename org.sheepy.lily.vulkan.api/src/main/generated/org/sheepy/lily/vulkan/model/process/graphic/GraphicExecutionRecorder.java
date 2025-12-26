package org.sheepy.lily.vulkan.model.process.graphic;

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
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicExecutionRecorderBuilder;

public interface GraphicExecutionRecorder extends ExecutionRecorder {
  static Builder builder() {
    return new GraphicExecutionRecorderBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<GraphicCommandBuffer> commandBuffers();

  interface FeatureIDs {
    int SUBMISSION = ExecutionRecorder.FeatureIDs.SUBMISSION;
    int COMMAND_BUFFERS = -2005757875;
  }

  interface Features<T extends Features<T>> extends ExecutionRecorder.Features<T> {
    Relation<Submission, Submission, Listener<Submission>, ExecutionRecorder.Features<?>> SUBMISSION = ExecutionRecorder.Features.SUBMISSION;
    Relation<GraphicCommandBuffer, List<GraphicCommandBuffer>, Listener<List<GraphicCommandBuffer>>, Features<?>> COMMAND_BUFFERS = new RelationBuilder<GraphicCommandBuffer, List<GraphicCommandBuffer>, Listener<List<GraphicCommandBuffer>>, Features<?>>().name("commandBuffers").many(true).mandatory(true).id(GraphicExecutionRecorder.FeatureIDs.COMMAND_BUFFERS).concept(() -> GraphicModelDefinition.Groups.GRAPHIC_COMMAND_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(SUBMISSION, COMMAND_BUFFERS);
  }

  interface Builder extends IFeaturedObject.Builder<GraphicExecutionRecorder> {
    Builder submission(Supplier<Submission> submission);
    Builder addCommandBuffer(Supplier<GraphicCommandBuffer> commandBuffer);
    Builder addCommandBuffers(List<GraphicCommandBuffer> commandBuffers);
  }
}
