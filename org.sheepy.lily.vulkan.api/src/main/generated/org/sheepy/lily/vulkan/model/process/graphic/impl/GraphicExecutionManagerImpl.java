package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.process.IExecutionAcquirer;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionManager;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class GraphicExecutionManagerImpl extends FeaturedObject<GraphicExecutionManager.Features<?>> implements GraphicExecutionManager {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<GraphicExecutionManager.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<Supplier<ProcessExecutionManager>> waitForExecution;
  private final List<Supplier<ProcessExecutionManager>> waitedBy;
  private EPipelineStage waitStage;
  private IExecutionAcquirer acquirer;
  private final List<GraphicExecutionRecorder> recorders = newObservableList(GraphicExecutionManager.FeatureIDs.RECORDERS, true, true);
  private final List<GraphicCommandBuffer> commandBuffers = newObservableList(GraphicExecutionManager.FeatureIDs.COMMAND_BUFFERS, true, true);

  public GraphicExecutionManagerImpl(final List<Supplier<ProcessExecutionManager>> waitForExecution,
      final List<Supplier<ProcessExecutionManager>> waitedBy) {
    this.waitForExecution = List.copyOf(waitForExecution);
    this.waitedBy = List.copyOf(waitedBy);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GraphicExecutionManager.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ProcessExecutionManager> waitForExecution() {
    return BuildUtils.collectSuppliers(waitForExecution);
  }

  @Override
  public List<ProcessExecutionManager> waitedBy() {
    return BuildUtils.collectSuppliers(waitedBy);
  }

  @Override
  public EPipelineStage waitStage() {
    return waitStage;
  }

  @Override
  public void waitStage(final EPipelineStage waitStage) {
    final var oldValue = this.waitStage;
    this.waitStage = waitStage;
    notifier.notify(ProcessExecutionManager.FeatureIDs.WAIT_STAGE, false, false, oldValue, waitStage);
  }

  @Override
  public IExecutionAcquirer acquirer() {
    return acquirer;
  }

  @Override
  public void acquirer(final IExecutionAcquirer acquirer) {
    final var oldValue = this.acquirer;
    final var eventType = acquirer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.acquirer = acquirer;
    setContainer(acquirer, ProcessExecutionManager.FeatureIDs.ACQUIRER);
    beforeContainmentNotify(eventType, oldValue, acquirer);
    notifier.notify(ProcessExecutionManager.FeatureIDs.ACQUIRER, true, false, eventType, oldValue, acquirer);
    afterContainmentNotify(eventType, oldValue, acquirer);
  }

  @Override
  public List<GraphicExecutionRecorder> recorders() {
    return recorders;
  }

  @Override
  public List<GraphicCommandBuffer> commandBuffers() {
    return commandBuffers;
  }

  @Override
  public Group<GraphicExecutionManager> lmGroup() {
    return GraphicModelDefinition.Groups.GRAPHIC_EXECUTION_MANAGER;
  }

  @Override
  protected FeatureSetter<GraphicExecutionManager> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GraphicExecutionManager> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GraphicExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION -> 0;
      case GraphicExecutionManager.FeatureIDs.WAITED_BY -> 1;
      case GraphicExecutionManager.FeatureIDs.WAIT_STAGE -> 2;
      case GraphicExecutionManager.FeatureIDs.ACQUIRER -> 3;
      case GraphicExecutionManager.FeatureIDs.RECORDERS -> 4;
      case GraphicExecutionManager.FeatureIDs.COMMAND_BUFFERS -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GraphicExecutionManager> GET_MAP = new FeatureGetter.Builder<GraphicExecutionManager>(FEATURE_COUNT, GraphicExecutionManagerImpl::featureIndexStatic).add(GraphicExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION, GraphicExecutionManager::waitForExecution).add(GraphicExecutionManager.FeatureIDs.WAITED_BY, GraphicExecutionManager::waitedBy).add(GraphicExecutionManager.FeatureIDs.WAIT_STAGE, GraphicExecutionManager::waitStage).add(GraphicExecutionManager.FeatureIDs.ACQUIRER, GraphicExecutionManager::acquirer).add(GraphicExecutionManager.FeatureIDs.RECORDERS, GraphicExecutionManager::recorders).add(GraphicExecutionManager.FeatureIDs.COMMAND_BUFFERS, GraphicExecutionManager::commandBuffers).build();
    private static final FeatureSetter<GraphicExecutionManager> SET_MAP = new FeatureSetter.Builder<GraphicExecutionManager>(FEATURE_COUNT, GraphicExecutionManagerImpl::featureIndexStatic).add(GraphicExecutionManager.FeatureIDs.WAIT_STAGE, (object, value) -> ((GraphicExecutionManagerImpl) object).waitStage((EPipelineStage) value)).add(GraphicExecutionManager.FeatureIDs.ACQUIRER, (object, value) -> ((GraphicExecutionManagerImpl) object).acquirer((IExecutionAcquirer) value)).build();
  }
}
