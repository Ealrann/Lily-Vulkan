package org.sheepy.lily.vulkan.model.process.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;

public final class FetchBufferImpl extends FeaturedObject<FetchBuffer.Features<?>> implements FetchBuffer {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<FetchBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private BufferReference bufferReference;

  public FetchBufferImpl(final String name, final BufferReference bufferReference) {
    this.name = name;
    this.bufferReference = bufferReference;
    setContainer(bufferReference, FetchBuffer.FeatureIDs.BUFFER_REFERENCE);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<FetchBuffer.Features<?>> notifier() {
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
  public BufferReference bufferReference() {
    return bufferReference;
  }

  @Override
  public void bufferReference(final BufferReference bufferReference) {
    final var oldValue = this.bufferReference;
    final var eventType = bufferReference == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.bufferReference = bufferReference;
    setContainer(bufferReference, FetchBuffer.FeatureIDs.BUFFER_REFERENCE);
    beforeContainmentNotify(eventType, oldValue, bufferReference);
    notifier.notify(FetchBuffer.FeatureIDs.BUFFER_REFERENCE, true, false, eventType, oldValue, bufferReference);
    afterContainmentNotify(eventType, oldValue, bufferReference);
  }

  @Override
  public Group<FetchBuffer> lmGroup() {
    return ProcessModelDefinition.Groups.FETCH_BUFFER;
  }

  @Override
  protected FeatureSetter<FetchBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<FetchBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case FetchBuffer.FeatureIDs.NAME -> 0;
      case FetchBuffer.FeatureIDs.ENABLED -> 1;
      case FetchBuffer.FeatureIDs.BUFFER_REFERENCE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<FetchBuffer> GET_MAP = new FeatureGetter.Builder<FetchBuffer>(FEATURE_COUNT, FetchBufferImpl::featureIndexStatic).add(FetchBuffer.FeatureIDs.NAME, FetchBuffer::name).add(FetchBuffer.FeatureIDs.ENABLED, FetchBuffer::enabled).add(FetchBuffer.FeatureIDs.BUFFER_REFERENCE, FetchBuffer::bufferReference).build();
    private static final FeatureSetter<FetchBuffer> SET_MAP = new FeatureSetter.Builder<FetchBuffer>(FEATURE_COUNT, FetchBufferImpl::featureIndexStatic).add(FetchBuffer.FeatureIDs.ENABLED, (object, value) -> ((FetchBufferImpl) object).enabled((boolean) value)).add(FetchBuffer.FeatureIDs.BUFFER_REFERENCE, (object, value) -> ((FetchBufferImpl) object).bufferReference((BufferReference) value)).build();
  }
}
