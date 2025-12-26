package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.nio.ByteBuffer;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class ConstantBufferImpl extends FeaturedObject<ConstantBuffer.Features<?>> implements ConstantBuffer {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<ConstantBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private ByteBuffer data;

  public ConstantBufferImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ConstantBuffer.Features<?>> notifier() {
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
  public Group<ConstantBuffer> lmGroup() {
    return VulkanResourceModelDefinition.Groups.CONSTANT_BUFFER;
  }

  @Override
  protected FeatureSetter<ConstantBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ConstantBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ConstantBuffer.FeatureIDs.NAME -> 0;
      case ConstantBuffer.FeatureIDs.DATA -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ConstantBuffer> GET_MAP = new FeatureGetter.Builder<ConstantBuffer>(FEATURE_COUNT, ConstantBufferImpl::featureIndexStatic).add(ConstantBuffer.FeatureIDs.NAME, ConstantBuffer::name).add(ConstantBuffer.FeatureIDs.DATA, ConstantBuffer::data).build();
    private static final FeatureSetter<ConstantBuffer> SET_MAP = new FeatureSetter.Builder<ConstantBuffer>(FEATURE_COUNT, ConstantBufferImpl::featureIndexStatic).add(ConstantBuffer.FeatureIDs.DATA, (object, value) -> ((ConstantBufferImpl) object).data((ByteBuffer) value)).build();
  }
}
