package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelDefinition;

public final class ComputeExecutionRecorderImpl extends FeaturedObject<ComputeExecutionRecorder.Features<?>> implements ComputeExecutionRecorder {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<ComputeExecutionRecorder.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Submission submission;
  private ComputeCommandBuffer commandBuffer;

  public ComputeExecutionRecorderImpl(final Submission submission,
      final ComputeCommandBuffer commandBuffer) {
    this.submission = submission;
    this.commandBuffer = commandBuffer;
    setContainer(submission, ExecutionRecorder.FeatureIDs.SUBMISSION);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ComputeExecutionRecorder.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Submission submission() {
    return submission;
  }

  @Override
  public void submission(final Submission submission) {
    final var oldValue = this.submission;
    final var eventType = submission == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.submission = submission;
    setContainer(submission, ExecutionRecorder.FeatureIDs.SUBMISSION);
    beforeContainmentNotify(eventType, oldValue, submission);
    notifier.notify(ExecutionRecorder.FeatureIDs.SUBMISSION, true, false, eventType, oldValue, submission);
    afterContainmentNotify(eventType, oldValue, submission);
  }

  @Override
  public ComputeCommandBuffer commandBuffer() {
    return commandBuffer;
  }

  @Override
  public void commandBuffer(final ComputeCommandBuffer commandBuffer) {
    final var oldValue = this.commandBuffer;
    final var eventType = commandBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.commandBuffer = commandBuffer;
    notifier.notify(ComputeExecutionRecorder.FeatureIDs.COMMAND_BUFFER, false, false, eventType, oldValue, commandBuffer);
  }

  @Override
  public Group<ComputeExecutionRecorder> lmGroup() {
    return ComputeModelDefinition.Groups.COMPUTE_EXECUTION_RECORDER;
  }

  @Override
  protected FeatureSetter<ComputeExecutionRecorder> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ComputeExecutionRecorder> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ComputeExecutionRecorder.FeatureIDs.SUBMISSION -> 0;
      case ComputeExecutionRecorder.FeatureIDs.COMMAND_BUFFER -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ComputeExecutionRecorder> GET_MAP = new FeatureGetter.Builder<ComputeExecutionRecorder>(FEATURE_COUNT, ComputeExecutionRecorderImpl::featureIndexStatic).add(ComputeExecutionRecorder.FeatureIDs.SUBMISSION, ComputeExecutionRecorder::submission).add(ComputeExecutionRecorder.FeatureIDs.COMMAND_BUFFER, ComputeExecutionRecorder::commandBuffer).build();
    private static final FeatureSetter<ComputeExecutionRecorder> SET_MAP = new FeatureSetter.Builder<ComputeExecutionRecorder>(FEATURE_COUNT, ComputeExecutionRecorderImpl::featureIndexStatic).add(ComputeExecutionRecorder.FeatureIDs.SUBMISSION, (object, value) -> ((ComputeExecutionRecorderImpl) object).submission((Submission) value)).add(ComputeExecutionRecorder.FeatureIDs.COMMAND_BUFFER, (object, value) -> ((ComputeExecutionRecorderImpl) object).commandBuffer((ComputeCommandBuffer) value)).build();
  }
}
