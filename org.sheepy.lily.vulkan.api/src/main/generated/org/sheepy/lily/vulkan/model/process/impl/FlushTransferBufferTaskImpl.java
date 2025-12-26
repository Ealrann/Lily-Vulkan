package org.sheepy.lily.vulkan.model.process.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;

public final class FlushTransferBufferTaskImpl extends FeaturedObject<FlushTransferBufferTask.Features<?>> implements FlushTransferBufferTask {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<FlushTransferBufferTask.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private TransferBuffer transferBuffer;

  public FlushTransferBufferTaskImpl(final String name, final TransferBuffer transferBuffer) {
    this.name = name;
    this.transferBuffer = transferBuffer;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FlushTransferBufferTask.Features<?>> notifier() {
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
  public TransferBuffer transferBuffer() {
    return transferBuffer;
  }

  @Override
  public void transferBuffer(final TransferBuffer transferBuffer) {
    final var oldValue = this.transferBuffer;
    final var eventType = transferBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.transferBuffer = transferBuffer;
    notifier.notify(FlushTransferBufferTask.FeatureIDs.TRANSFER_BUFFER, false, false, eventType, oldValue, transferBuffer);
  }

  @Override
  public Group<FlushTransferBufferTask> lmGroup() {
    return ProcessModelDefinition.Groups.FLUSH_TRANSFER_BUFFER_TASK;
  }

  @Override
  protected FeatureSetter<FlushTransferBufferTask> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FlushTransferBufferTask> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FlushTransferBufferTask.FeatureIDs.NAME -> 0;
      case FlushTransferBufferTask.FeatureIDs.ENABLED -> 1;
      case FlushTransferBufferTask.FeatureIDs.TRANSFER_BUFFER -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FlushTransferBufferTask> GET_MAP = new FeatureGetter.Builder<FlushTransferBufferTask>(FEATURE_COUNT, FlushTransferBufferTaskImpl::featureIndexStatic).add(FlushTransferBufferTask.FeatureIDs.NAME, FlushTransferBufferTask::name).add(FlushTransferBufferTask.FeatureIDs.ENABLED, FlushTransferBufferTask::enabled).add(FlushTransferBufferTask.FeatureIDs.TRANSFER_BUFFER, FlushTransferBufferTask::transferBuffer).build();
    private static final FeatureSetter<FlushTransferBufferTask> SET_MAP = new FeatureSetter.Builder<FlushTransferBufferTask>(FEATURE_COUNT, FlushTransferBufferTaskImpl::featureIndexStatic).add(FlushTransferBufferTask.FeatureIDs.ENABLED, (object, value) -> ((FlushTransferBufferTaskImpl) object).enabled((boolean) value)).add(FlushTransferBufferTask.FeatureIDs.TRANSFER_BUFFER, (object, value) -> ((FlushTransferBufferTaskImpl) object).transferBuffer((TransferBuffer) value)).build();
  }
}
