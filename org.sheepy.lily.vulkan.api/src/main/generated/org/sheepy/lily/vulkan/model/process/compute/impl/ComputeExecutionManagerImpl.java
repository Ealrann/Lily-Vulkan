package org.sheepy.lily.vulkan.model.process.compute.impl;

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
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionManager;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelDefinition;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class ComputeExecutionManagerImpl extends FeaturedObject<ComputeExecutionManager.Features<?>> implements ComputeExecutionManager {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<ComputeExecutionManager.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<Supplier<ProcessExecutionManager>> waitForExecution;
  private final List<Supplier<ProcessExecutionManager>> waitedBy;
  private EPipelineStage waitStage;
  private IExecutionAcquirer acquirer;
  private final List<ComputeExecutionRecorder> recorders = newObservableList(ComputeExecutionManager.FeatureIDs.RECORDERS, true, true);
  private int indexCount;
  private final List<ComputeCommandBuffer> CommandBuffers = newObservableList(ComputeExecutionManager.FeatureIDs.COMMAND_BUFFERS, true, true);

  public ComputeExecutionManagerImpl(final List<Supplier<ProcessExecutionManager>> waitForExecution,
      final List<Supplier<ProcessExecutionManager>> waitedBy, final int indexCount) {
    this.waitForExecution = List.copyOf(waitForExecution);
    this.waitedBy = List.copyOf(waitedBy);
    this.indexCount = indexCount;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ComputeExecutionManager.Features<?>> notifier() {
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
  public List<ComputeExecutionRecorder> recorders() {
    return recorders;
  }

  @Override
  public int indexCount() {
    return indexCount;
  }

  @Override
  public void indexCount(final int indexCount) {
    final var oldValue = this.indexCount;
    this.indexCount = indexCount;
    notifier.notifyInt(ComputeExecutionManager.FeatureIDs.INDEX_COUNT, false, false, oldValue, indexCount);
  }

  @Override
  public List<ComputeCommandBuffer> CommandBuffers() {
    return CommandBuffers;
  }

  @Override
  public Group<ComputeExecutionManager> lmGroup() {
    return ComputeModelDefinition.Groups.COMPUTE_EXECUTION_MANAGER;
  }

  @Override
  protected FeatureSetter<ComputeExecutionManager> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ComputeExecutionManager> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ComputeExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION -> 0;
      case ComputeExecutionManager.FeatureIDs.WAITED_BY -> 1;
      case ComputeExecutionManager.FeatureIDs.WAIT_STAGE -> 2;
      case ComputeExecutionManager.FeatureIDs.ACQUIRER -> 3;
      case ComputeExecutionManager.FeatureIDs.RECORDERS -> 4;
      case ComputeExecutionManager.FeatureIDs.INDEX_COUNT -> 5;
      case ComputeExecutionManager.FeatureIDs.COMMAND_BUFFERS -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ComputeExecutionManager> GET_MAP = new FeatureGetter.Builder<ComputeExecutionManager>(FEATURE_COUNT, ComputeExecutionManagerImpl::featureIndexStatic).add(ComputeExecutionManager.FeatureIDs.WAIT_FOR_EXECUTION, ComputeExecutionManager::waitForExecution).add(ComputeExecutionManager.FeatureIDs.WAITED_BY, ComputeExecutionManager::waitedBy).add(ComputeExecutionManager.FeatureIDs.WAIT_STAGE, ComputeExecutionManager::waitStage).add(ComputeExecutionManager.FeatureIDs.ACQUIRER, ComputeExecutionManager::acquirer).add(ComputeExecutionManager.FeatureIDs.RECORDERS, ComputeExecutionManager::recorders).add(ComputeExecutionManager.FeatureIDs.INDEX_COUNT, ComputeExecutionManager::indexCount).add(ComputeExecutionManager.FeatureIDs.COMMAND_BUFFERS, ComputeExecutionManager::CommandBuffers).build();
    private static final FeatureSetter<ComputeExecutionManager> SET_MAP = new FeatureSetter.Builder<ComputeExecutionManager>(FEATURE_COUNT, ComputeExecutionManagerImpl::featureIndexStatic).add(ComputeExecutionManager.FeatureIDs.WAIT_STAGE, (object, value) -> ((ComputeExecutionManagerImpl) object).waitStage((EPipelineStage) value)).add(ComputeExecutionManager.FeatureIDs.ACQUIRER, (object, value) -> ((ComputeExecutionManagerImpl) object).acquirer((IExecutionAcquirer) value)).add(ComputeExecutionManager.FeatureIDs.INDEX_COUNT, (object, value) -> ((ComputeExecutionManagerImpl) object).indexCount((int) value)).build();
  }
}
