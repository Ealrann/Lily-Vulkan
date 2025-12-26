package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.nio.ByteBuffer;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

public final class RenderProxyConstantBufferImpl extends FeaturedObject<RenderProxyConstantBuffer.Features<?>> implements RenderProxyConstantBuffer {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<RenderProxyConstantBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private ByteBuffer data;
  private ConstantBuffer constantBuffer;
  private int partIndex;

  public RenderProxyConstantBufferImpl(final String name, final ConstantBuffer constantBuffer,
      final int partIndex) {
    this.name = name;
    this.constantBuffer = constantBuffer;
    this.partIndex = partIndex;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<RenderProxyConstantBuffer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public ByteBuffer data() {
    return data;
  }

  @Override
  public void data(final ByteBuffer data) {
    final var oldValue = this.data;
    this.data = data;
    notifier.notify(ConstantBuffer.FeatureIDs.DATA, false, false, oldValue, data);
  }

  @Override
  public ConstantBuffer constantBuffer() {
    return constantBuffer;
  }

  @Override
  public void constantBuffer(final ConstantBuffer constantBuffer) {
    final var oldValue = this.constantBuffer;
    final var eventType = constantBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.constantBuffer = constantBuffer;
    notifier.notify(RenderProxyConstantBuffer.FeatureIDs.CONSTANT_BUFFER, false, false, eventType, oldValue, constantBuffer);
  }

  @Override
  public int partIndex() {
    return partIndex;
  }

  @Override
  public void partIndex(final int partIndex) {
    final var oldValue = this.partIndex;
    this.partIndex = partIndex;
    notifier.notifyInt(RenderProxyConstantBuffer.FeatureIDs.PART_INDEX, false, false, oldValue, partIndex);
  }

  @Override
  public Group<RenderProxyConstantBuffer> lmGroup() {
    return RenderingModelDefinition.Groups.RENDER_PROXY_CONSTANT_BUFFER;
  }

  @Override
  protected FeatureSetter<RenderProxyConstantBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<RenderProxyConstantBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case RenderProxyConstantBuffer.FeatureIDs.NAME -> 0;
      case RenderProxyConstantBuffer.FeatureIDs.DATA -> 1;
      case RenderProxyConstantBuffer.FeatureIDs.CONSTANT_BUFFER -> 2;
      case RenderProxyConstantBuffer.FeatureIDs.PART_INDEX -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<RenderProxyConstantBuffer> GET_MAP = new FeatureGetter.Builder<RenderProxyConstantBuffer>(FEATURE_COUNT, RenderProxyConstantBufferImpl::featureIndexStatic).add(RenderProxyConstantBuffer.FeatureIDs.NAME, RenderProxyConstantBuffer::name).add(RenderProxyConstantBuffer.FeatureIDs.DATA, RenderProxyConstantBuffer::data).add(RenderProxyConstantBuffer.FeatureIDs.CONSTANT_BUFFER, RenderProxyConstantBuffer::constantBuffer).add(RenderProxyConstantBuffer.FeatureIDs.PART_INDEX, RenderProxyConstantBuffer::partIndex).build();
    private static final FeatureSetter<RenderProxyConstantBuffer> SET_MAP = new FeatureSetter.Builder<RenderProxyConstantBuffer>(FEATURE_COUNT, RenderProxyConstantBufferImpl::featureIndexStatic).add(RenderProxyConstantBuffer.FeatureIDs.DATA, (object, value) -> ((RenderProxyConstantBufferImpl) object).data((ByteBuffer) value)).add(RenderProxyConstantBuffer.FeatureIDs.CONSTANT_BUFFER, (object, value) -> ((RenderProxyConstantBufferImpl) object).constantBuffer((ConstantBuffer) value)).add(RenderProxyConstantBuffer.FeatureIDs.PART_INDEX, (object, value) -> ((RenderProxyConstantBufferImpl) object).partIndex((int) value)).build();
  }
}
