package org.sheepy.lily.vulkan.model.process.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;

public final class CopyBufferTaskImpl extends FeaturedObject<CopyBufferTask.Features<?>> implements CopyBufferTask {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<CopyBufferTask.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private BufferReference srcBuffer;
  private BufferReference dstBuffer;

  public CopyBufferTaskImpl(final String name, final BufferReference srcBuffer,
      final BufferReference dstBuffer) {
    this.name = name;
    this.srcBuffer = srcBuffer;
    this.dstBuffer = dstBuffer;
    setContainer(srcBuffer, CopyBufferTask.FeatureIDs.SRC_BUFFER);
    setContainer(dstBuffer, CopyBufferTask.FeatureIDs.DST_BUFFER);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<CopyBufferTask.Features<?>> notifier() {
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
  public BufferReference srcBuffer() {
    return srcBuffer;
  }

  @Override
  public void srcBuffer(final BufferReference srcBuffer) {
    final var oldValue = this.srcBuffer;
    final var eventType = srcBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.srcBuffer = srcBuffer;
    setContainer(srcBuffer, CopyBufferTask.FeatureIDs.SRC_BUFFER);
    beforeContainmentNotify(eventType, oldValue, srcBuffer);
    notifier.notify(CopyBufferTask.FeatureIDs.SRC_BUFFER, true, false, eventType, oldValue, srcBuffer);
    afterContainmentNotify(eventType, oldValue, srcBuffer);
  }

  @Override
  public BufferReference dstBuffer() {
    return dstBuffer;
  }

  @Override
  public void dstBuffer(final BufferReference dstBuffer) {
    final var oldValue = this.dstBuffer;
    final var eventType = dstBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dstBuffer = dstBuffer;
    setContainer(dstBuffer, CopyBufferTask.FeatureIDs.DST_BUFFER);
    beforeContainmentNotify(eventType, oldValue, dstBuffer);
    notifier.notify(CopyBufferTask.FeatureIDs.DST_BUFFER, true, false, eventType, oldValue, dstBuffer);
    afterContainmentNotify(eventType, oldValue, dstBuffer);
  }

  @Override
  public Group<CopyBufferTask> lmGroup() {
    return ProcessModelDefinition.Groups.COPY_BUFFER_TASK;
  }

  @Override
  protected FeatureSetter<CopyBufferTask> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<CopyBufferTask> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case CopyBufferTask.FeatureIDs.NAME -> 0;
      case CopyBufferTask.FeatureIDs.ENABLED -> 1;
      case CopyBufferTask.FeatureIDs.SRC_BUFFER -> 2;
      case CopyBufferTask.FeatureIDs.DST_BUFFER -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<CopyBufferTask> GET_MAP = new FeatureGetter.Builder<CopyBufferTask>(FEATURE_COUNT, CopyBufferTaskImpl::featureIndexStatic).add(CopyBufferTask.FeatureIDs.NAME, CopyBufferTask::name).add(CopyBufferTask.FeatureIDs.ENABLED, CopyBufferTask::enabled).add(CopyBufferTask.FeatureIDs.SRC_BUFFER, CopyBufferTask::srcBuffer).add(CopyBufferTask.FeatureIDs.DST_BUFFER, CopyBufferTask::dstBuffer).build();
    private static final FeatureSetter<CopyBufferTask> SET_MAP = new FeatureSetter.Builder<CopyBufferTask>(FEATURE_COUNT, CopyBufferTaskImpl::featureIndexStatic).add(CopyBufferTask.FeatureIDs.ENABLED, (object, value) -> ((CopyBufferTaskImpl) object).enabled((boolean) value)).add(CopyBufferTask.FeatureIDs.SRC_BUFFER, (object, value) -> ((CopyBufferTaskImpl) object).srcBuffer((BufferReference) value)).add(CopyBufferTask.FeatureIDs.DST_BUFFER, (object, value) -> ((CopyBufferTaskImpl) object).dstBuffer((BufferReference) value)).build();
  }
}
