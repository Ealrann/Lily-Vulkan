package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicExecutionManagerBuilder;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public interface GraphicExecutionManager extends ProcessExecutionManager {
  static Builder builder() {
    return new GraphicExecutionManagerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<GraphicExecutionRecorder> recorders();
  List<GraphicCommandBuffer> commandBuffers();

  interface FeatureIDs {
    int WAIT_FOR_EXECUTION = ProcessExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION;
    int WAITED_BY = ProcessExecutionManager.FeatureIDs.WAITED_BY;
    int WAIT_STAGE = ProcessExecutionManager.FeatureIDs.WAIT_STAGE;
    int ACQUIRER = ProcessExecutionManager.FeatureIDs.ACQUIRER;
    int RECORDERS = 1448273489;
    int COMMAND_BUFFERS = 1375888652;
  }

  interface Features<T extends Features<T>> extends ProcessExecutionManager.Features<T> {
    Relation<ProcessExecutionManager, List<ProcessExecutionManager>, Listener<List<ProcessExecutionManager>>, ProcessExecutionManager.Features<?>> WAIT_FOR_EXECUTION = ProcessExecutionManager.Features.WAIT_FOR_EXECUTION;
    Relation<ProcessExecutionManager, List<ProcessExecutionManager>, Listener<List<ProcessExecutionManager>>, ProcessExecutionManager.Features<?>> WAITED_BY = ProcessExecutionManager.Features.WAITED_BY;
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, ProcessExecutionManager.Features<?>> WAIT_STAGE = ProcessExecutionManager.Features.WAIT_STAGE;
    Relation<IExecutionAcquirer, IExecutionAcquirer, Listener<IExecutionAcquirer>, ProcessExecutionManager.Features<?>> ACQUIRER = ProcessExecutionManager.Features.ACQUIRER;
    Relation<GraphicExecutionRecorder, List<GraphicExecutionRecorder>, Listener<List<GraphicExecutionRecorder>>, Features<?>> RECORDERS = new RelationBuilder<GraphicExecutionRecorder, List<GraphicExecutionRecorder>, Listener<List<GraphicExecutionRecorder>>, Features<?>>().name("recorders").many(true).contains(true).id(GraphicExecutionManager.FeatureIDs.RECORDERS).concept(() -> GraphicModelDefinition.Groups.GRAPHIC_EXECUTION_RECORDER).build();
    Relation<GraphicCommandBuffer, List<GraphicCommandBuffer>, Listener<List<GraphicCommandBuffer>>, Features<?>> COMMAND_BUFFERS = new RelationBuilder<GraphicCommandBuffer, List<GraphicCommandBuffer>, Listener<List<GraphicCommandBuffer>>, Features<?>>().name("commandBuffers").many(true).contains(true).id(GraphicExecutionManager.FeatureIDs.COMMAND_BUFFERS).concept(() -> GraphicModelDefinition.Groups.GRAPHIC_COMMAND_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(WAIT_FOR_EXECUTION, WAITED_BY, WAIT_STAGE, ACQUIRER, RECORDERS, COMMAND_BUFFERS);
  }

  interface Builder extends IFeaturedObject.Builder<GraphicExecutionManager> {
    Builder addWaitForExecution(Supplier<ProcessExecutionManager> waitForExecution);
    Builder addWaitedBy(Supplier<ProcessExecutionManager> waitedBy);
    Builder waitStage(EPipelineStage waitStage);
    Builder acquirer(Supplier<IExecutionAcquirer> acquirer);
    Builder addRecorder(Supplier<GraphicExecutionRecorder> recorder);
    Builder addCommandBuffer(Supplier<GraphicCommandBuffer> commandBuffer);
    Builder addWaitForExecution(List<ProcessExecutionManager> waitForExecution);
    Builder addWaitedBy(List<ProcessExecutionManager> waitedBy);
    Builder addRecorders(List<GraphicExecutionRecorder> recorders);
    Builder addCommandBuffers(List<GraphicCommandBuffer> commandBuffers);
  }
}
