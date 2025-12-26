package org.sheepy.lily.vulkan.model.process.compute;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeExecutionManagerBuilder;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public interface ComputeExecutionManager extends ProcessExecutionManager {
  static Builder builder() {
    return new ComputeExecutionManagerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ComputeExecutionRecorder> recorders();
  int indexCount();
  List<ComputeCommandBuffer> CommandBuffers();
  void indexCount(final int indexCount);

  interface FeatureIDs {
    int WAIT_FOR_EXECUTION = ProcessExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION;
    int WAITED_BY = ProcessExecutionManager.FeatureIDs.WAITED_BY;
    int WAIT_STAGE = ProcessExecutionManager.FeatureIDs.WAIT_STAGE;
    int ACQUIRER = ProcessExecutionManager.FeatureIDs.ACQUIRER;
    int RECORDERS = -1508349841;
    int INDEX_COUNT = 471536035;
    int COMMAND_BUFFERS = -489270834;
  }

  interface Features<T extends Features<T>> extends ProcessExecutionManager.Features<T> {
    Relation<ProcessExecutionManager, List<ProcessExecutionManager>, Listener<List<ProcessExecutionManager>>, ProcessExecutionManager.Features<?>> WAIT_FOR_EXECUTION = ProcessExecutionManager.Features.WAIT_FOR_EXECUTION;
    Relation<ProcessExecutionManager, List<ProcessExecutionManager>, Listener<List<ProcessExecutionManager>>, ProcessExecutionManager.Features<?>> WAITED_BY = ProcessExecutionManager.Features.WAITED_BY;
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, ProcessExecutionManager.Features<?>> WAIT_STAGE = ProcessExecutionManager.Features.WAIT_STAGE;
    Relation<IExecutionAcquirer, IExecutionAcquirer, Listener<IExecutionAcquirer>, ProcessExecutionManager.Features<?>> ACQUIRER = ProcessExecutionManager.Features.ACQUIRER;
    Relation<ComputeExecutionRecorder, List<ComputeExecutionRecorder>, Listener<List<ComputeExecutionRecorder>>, Features<?>> RECORDERS = new RelationBuilder<ComputeExecutionRecorder, List<ComputeExecutionRecorder>, Listener<List<ComputeExecutionRecorder>>, Features<?>>().name("recorders").many(true).contains(true).id(ComputeExecutionManager.FeatureIDs.RECORDERS).concept(() -> ComputeModelDefinition.Groups.COMPUTE_EXECUTION_RECORDER).build();
    Attribute<Integer, Integer, IntListener, Features<?>> INDEX_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("indexCount").mandatory(true).defaultValue("1").id(ComputeExecutionManager.FeatureIDs.INDEX_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Relation<ComputeCommandBuffer, List<ComputeCommandBuffer>, Listener<List<ComputeCommandBuffer>>, Features<?>> COMMAND_BUFFERS = new RelationBuilder<ComputeCommandBuffer, List<ComputeCommandBuffer>, Listener<List<ComputeCommandBuffer>>, Features<?>>().name("CommandBuffers").many(true).contains(true).id(ComputeExecutionManager.FeatureIDs.COMMAND_BUFFERS).concept(() -> ComputeModelDefinition.Groups.COMPUTE_COMMAND_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(WAIT_FOR_EXECUTION, WAITED_BY, WAIT_STAGE, ACQUIRER, RECORDERS, INDEX_COUNT, COMMAND_BUFFERS);
  }

  interface Builder extends IFeaturedObject.Builder<ComputeExecutionManager> {
    Builder addWaitForExecution(Supplier<ProcessExecutionManager> waitForExecution);
    Builder addWaitedBy(Supplier<ProcessExecutionManager> waitedBy);
    Builder waitStage(EPipelineStage waitStage);
    Builder acquirer(Supplier<IExecutionAcquirer> acquirer);
    Builder addRecorder(Supplier<ComputeExecutionRecorder> recorder);
    Builder indexCount(int indexCount);
    Builder addCommandBuffer(Supplier<ComputeCommandBuffer> CommandBuffer);
    Builder addWaitForExecution(List<ProcessExecutionManager> waitForExecution);
    Builder addWaitedBy(List<ProcessExecutionManager> waitedBy);
    Builder addRecorders(List<ComputeExecutionRecorder> recorders);
    Builder addCommandBuffers(List<ComputeCommandBuffer> CommandBuffers);
  }
}
