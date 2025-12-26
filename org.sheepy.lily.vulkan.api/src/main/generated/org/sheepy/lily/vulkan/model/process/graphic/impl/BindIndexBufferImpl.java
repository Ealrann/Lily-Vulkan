package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.BindIndexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.vulkan.model.enumeration.EIndexType;

public final class BindIndexBufferImpl extends FeaturedObject<BindIndexBuffer.Features<?>> implements BindIndexBuffer {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<BindIndexBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private EIndexType indexType;
  private IBuffer buffer;

  public BindIndexBufferImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BindIndexBuffer.Features<?>> notifier() {
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
  public EIndexType indexType() {
    return indexType;
  }

  @Override
  public void indexType(final EIndexType indexType) {
    final var oldValue = this.indexType;
    this.indexType = indexType;
    notifier.notify(BindIndexBuffer.FeatureIDs.INDEX_TYPE, false, false, oldValue, indexType);
  }

  @Override
  public IBuffer buffer() {
    return buffer;
  }

  @Override
  public void buffer(final IBuffer buffer) {
    final var oldValue = this.buffer;
    final var eventType = buffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.buffer = buffer;
    notifier.notify(BindIndexBuffer.FeatureIDs.BUFFER, false, false, eventType, oldValue, buffer);
  }

  @Override
  public Group<BindIndexBuffer> lmGroup() {
    return GraphicModelDefinition.Groups.BIND_INDEX_BUFFER;
  }

  @Override
  protected FeatureSetter<BindIndexBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BindIndexBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BindIndexBuffer.FeatureIDs.NAME -> 0;
      case BindIndexBuffer.FeatureIDs.ENABLED -> 1;
      case BindIndexBuffer.FeatureIDs.INDEX_TYPE -> 2;
      case BindIndexBuffer.FeatureIDs.BUFFER -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BindIndexBuffer> GET_MAP = new FeatureGetter.Builder<BindIndexBuffer>(FEATURE_COUNT, BindIndexBufferImpl::featureIndexStatic).add(BindIndexBuffer.FeatureIDs.NAME, BindIndexBuffer::name).add(BindIndexBuffer.FeatureIDs.ENABLED, BindIndexBuffer::enabled).add(BindIndexBuffer.FeatureIDs.INDEX_TYPE, BindIndexBuffer::indexType).add(BindIndexBuffer.FeatureIDs.BUFFER, BindIndexBuffer::buffer).build();
    private static final FeatureSetter<BindIndexBuffer> SET_MAP = new FeatureSetter.Builder<BindIndexBuffer>(FEATURE_COUNT, BindIndexBufferImpl::featureIndexStatic).add(BindIndexBuffer.FeatureIDs.ENABLED, (object, value) -> ((BindIndexBufferImpl) object).enabled((boolean) value)).add(BindIndexBuffer.FeatureIDs.INDEX_TYPE, (object, value) -> ((BindIndexBufferImpl) object).indexType((EIndexType) value)).add(BindIndexBuffer.FeatureIDs.BUFFER, (object, value) -> ((BindIndexBufferImpl) object).buffer((IBuffer) value)).build();
  }
}
