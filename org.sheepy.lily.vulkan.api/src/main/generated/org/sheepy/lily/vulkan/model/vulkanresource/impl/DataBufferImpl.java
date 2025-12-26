package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.nio.ByteBuffer;
import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.DataBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public final class DataBufferImpl extends FeaturedObject<DataBuffer.Features<?>> implements DataBuffer {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<DataBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<EBufferUsage> usages = newObservableList(IBuffer.FeatureIDs.USAGES, false, false);
  private ByteBuffer data;

  public DataBufferImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DataBuffer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<EBufferUsage> usages() {
    return usages;
  }

  @Override
  public ByteBuffer data() {
    return data;
  }

  @Override
  public void data(final ByteBuffer data) {
    final var oldValue = this.data;
    this.data = data;
    notifier.notify(DataBuffer.FeatureIDs.DATA, false, false, oldValue, data);
  }

  @Override
  public Group<DataBuffer> lmGroup() {
    return VulkanResourceModelDefinition.Groups.DATA_BUFFER;
  }

  @Override
  protected FeatureSetter<DataBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DataBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DataBuffer.FeatureIDs.NAME -> 0;
      case DataBuffer.FeatureIDs.USAGES -> 1;
      case DataBuffer.FeatureIDs.DATA -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DataBuffer> GET_MAP = new FeatureGetter.Builder<DataBuffer>(FEATURE_COUNT, DataBufferImpl::featureIndexStatic).add(DataBuffer.FeatureIDs.NAME, DataBuffer::name).add(DataBuffer.FeatureIDs.USAGES, DataBuffer::usages).add(DataBuffer.FeatureIDs.DATA, DataBuffer::data).build();
    private static final FeatureSetter<DataBuffer> SET_MAP = new FeatureSetter.Builder<DataBuffer>(FEATURE_COUNT, DataBufferImpl::featureIndexStatic).add(DataBuffer.FeatureIDs.DATA, (object, value) -> ((DataBufferImpl) object).data((ByteBuffer) value)).build();
  }
}
