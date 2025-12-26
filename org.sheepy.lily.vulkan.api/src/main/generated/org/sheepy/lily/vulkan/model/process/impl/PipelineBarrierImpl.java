package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PipelineBarrier;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class PipelineBarrierImpl extends FeaturedObject<PipelineBarrier.Features<?>> implements PipelineBarrier {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<PipelineBarrier.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private final List<Barrier> barriers = newObservableList(PipelineBarrier.FeatureIDs.BARRIERS, true, true);
  private EPipelineStage srcStage;
  private EPipelineStage dstStage;
  private AbstractProcess srcQueue;
  private AbstractProcess dstQueue;

  public PipelineBarrierImpl(final String name, final List<Barrier> barriers) {
    this.name = name;
    this.barriers.addAll(barriers);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PipelineBarrier.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(IPipelineTask.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public List<Barrier> barriers() {
    return barriers;
  }

  @Override
  public EPipelineStage srcStage() {
    return srcStage;
  }

  @Override
  public void srcStage(final EPipelineStage srcStage) {
    final var oldValue = this.srcStage;
    this.srcStage = srcStage;
    notifier.notify(PipelineBarrier.FeatureIDs.SRC_STAGE, false, false, oldValue, srcStage);
  }

  @Override
  public EPipelineStage dstStage() {
    return dstStage;
  }

  @Override
  public void dstStage(final EPipelineStage dstStage) {
    final var oldValue = this.dstStage;
    this.dstStage = dstStage;
    notifier.notify(PipelineBarrier.FeatureIDs.DST_STAGE, false, false, oldValue, dstStage);
  }

  @Override
  public AbstractProcess srcQueue() {
    return srcQueue;
  }

  @Override
  public void srcQueue(final AbstractProcess srcQueue) {
    final var oldValue = this.srcQueue;
    final var eventType = srcQueue == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.srcQueue = srcQueue;
    notifier.notify(PipelineBarrier.FeatureIDs.SRC_QUEUE, false, false, eventType, oldValue, srcQueue);
  }

  @Override
  public AbstractProcess dstQueue() {
    return dstQueue;
  }

  @Override
  public void dstQueue(final AbstractProcess dstQueue) {
    final var oldValue = this.dstQueue;
    final var eventType = dstQueue == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dstQueue = dstQueue;
    notifier.notify(PipelineBarrier.FeatureIDs.DST_QUEUE, false, false, eventType, oldValue, dstQueue);
  }

  @Override
  public Group<PipelineBarrier> lmGroup() {
    return ProcessModelDefinition.Groups.PIPELINE_BARRIER;
  }

  @Override
  protected FeatureSetter<PipelineBarrier> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PipelineBarrier> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PipelineBarrier.FeatureIDs.NAME -> 0;
      case PipelineBarrier.FeatureIDs.ENABLED -> 1;
      case PipelineBarrier.FeatureIDs.BARRIERS -> 2;
      case PipelineBarrier.FeatureIDs.SRC_STAGE -> 3;
      case PipelineBarrier.FeatureIDs.DST_STAGE -> 4;
      case PipelineBarrier.FeatureIDs.SRC_QUEUE -> 5;
      case PipelineBarrier.FeatureIDs.DST_QUEUE -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PipelineBarrier> GET_MAP = new FeatureGetter.Builder<PipelineBarrier>(FEATURE_COUNT, PipelineBarrierImpl::featureIndexStatic).add(PipelineBarrier.FeatureIDs.NAME, PipelineBarrier::name).add(PipelineBarrier.FeatureIDs.ENABLED, PipelineBarrier::enabled).add(PipelineBarrier.FeatureIDs.BARRIERS, PipelineBarrier::barriers).add(PipelineBarrier.FeatureIDs.SRC_STAGE, PipelineBarrier::srcStage).add(PipelineBarrier.FeatureIDs.DST_STAGE, PipelineBarrier::dstStage).add(PipelineBarrier.FeatureIDs.SRC_QUEUE, PipelineBarrier::srcQueue).add(PipelineBarrier.FeatureIDs.DST_QUEUE, PipelineBarrier::dstQueue).build();
    private static final FeatureSetter<PipelineBarrier> SET_MAP = new FeatureSetter.Builder<PipelineBarrier>(FEATURE_COUNT, PipelineBarrierImpl::featureIndexStatic).add(PipelineBarrier.FeatureIDs.ENABLED, (object, value) -> ((PipelineBarrierImpl) object).enabled((boolean) value)).add(PipelineBarrier.FeatureIDs.SRC_STAGE, (object, value) -> ((PipelineBarrierImpl) object).srcStage((EPipelineStage) value)).add(PipelineBarrier.FeatureIDs.DST_STAGE, (object, value) -> ((PipelineBarrierImpl) object).dstStage((EPipelineStage) value)).add(PipelineBarrier.FeatureIDs.SRC_QUEUE, (object, value) -> ((PipelineBarrierImpl) object).srcQueue((AbstractProcess) value)).add(PipelineBarrier.FeatureIDs.DST_QUEUE, (object, value) -> ((PipelineBarrierImpl) object).dstQueue((AbstractProcess) value)).build();
  }
}
