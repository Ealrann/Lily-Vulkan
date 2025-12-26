package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.ExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.Submission;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicCommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicExecutionRecorder;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;

public final class GraphicExecutionRecorderImpl extends FeaturedObject<GraphicExecutionRecorder.Features<?>> implements GraphicExecutionRecorder {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<GraphicExecutionRecorder.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Submission submission;
  private final List<GraphicCommandBuffer> commandBuffers = newObservableList(GraphicExecutionRecorder.FeatureIDs.COMMAND_BUFFERS, true, false);

  public GraphicExecutionRecorderImpl(final Submission submission,
      final List<GraphicCommandBuffer> commandBuffers) {
    this.submission = submission;
    this.commandBuffers.addAll(commandBuffers);
    setContainer(submission, ExecutionRecorder.FeatureIDs.SUBMISSION);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GraphicExecutionRecorder.Features<?>> notifier() {
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
  public List<GraphicCommandBuffer> commandBuffers() {
    return commandBuffers;
  }

  @Override
  public Group<GraphicExecutionRecorder> lmGroup() {
    return GraphicModelDefinition.Groups.GRAPHIC_EXECUTION_RECORDER;
  }

  @Override
  protected FeatureSetter<GraphicExecutionRecorder> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GraphicExecutionRecorder> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GraphicExecutionRecorder.FeatureIDs.SUBMISSION -> 0;
      case GraphicExecutionRecorder.FeatureIDs.COMMAND_BUFFERS -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GraphicExecutionRecorder> GET_MAP = new FeatureGetter.Builder<GraphicExecutionRecorder>(FEATURE_COUNT, GraphicExecutionRecorderImpl::featureIndexStatic).add(GraphicExecutionRecorder.FeatureIDs.SUBMISSION, GraphicExecutionRecorder::submission).add(GraphicExecutionRecorder.FeatureIDs.COMMAND_BUFFERS, GraphicExecutionRecorder::commandBuffers).build();
    private static final FeatureSetter<GraphicExecutionRecorder> SET_MAP = new FeatureSetter.Builder<GraphicExecutionRecorder>(FEATURE_COUNT, GraphicExecutionRecorderImpl::featureIndexStatic).add(GraphicExecutionRecorder.FeatureIDs.SUBMISSION, (object, value) -> ((GraphicExecutionRecorderImpl) object).submission((Submission) value)).build();
  }
}
