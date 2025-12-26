package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class BufferReferenceImpl extends FeaturedObject<BufferReference.Features<?>> implements BufferReference {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<BufferReference.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IBuffer> buffers = newObservableList(BufferReference.FeatureIDs.BUFFERS, true, false);
  private int stride;
  private EContextIndex indexType;

  public BufferReferenceImpl(final EContextIndex indexType) {
    this.indexType = indexType;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BufferReference.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IBuffer> buffers() {
    return buffers;
  }

  @Override
  public int stride() {
    return stride;
  }

  @Override
  public void stride(final int stride) {
    final var oldValue = this.stride;
    this.stride = stride;
    notifier.notifyInt(BufferReference.FeatureIDs.STRIDE, false, false, oldValue, stride);
  }

  @Override
  public EContextIndex indexType() {
    return indexType;
  }

  @Override
  public void indexType(final EContextIndex indexType) {
    final var oldValue = this.indexType;
    this.indexType = indexType;
    notifier.notify(BufferReference.FeatureIDs.INDEX_TYPE, false, false, oldValue, indexType);
  }

  @Override
  public Group<BufferReference> lmGroup() {
    return VulkanResourceModelDefinition.Groups.BUFFER_REFERENCE;
  }

  @Override
  protected FeatureSetter<BufferReference> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BufferReference> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BufferReference.FeatureIDs.BUFFERS -> 0;
      case BufferReference.FeatureIDs.STRIDE -> 1;
      case BufferReference.FeatureIDs.INDEX_TYPE -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BufferReference> GET_MAP = new FeatureGetter.Builder<BufferReference>(FEATURE_COUNT, BufferReferenceImpl::featureIndexStatic).add(BufferReference.FeatureIDs.BUFFERS, BufferReference::buffers).add(BufferReference.FeatureIDs.STRIDE, BufferReference::stride).add(BufferReference.FeatureIDs.INDEX_TYPE, BufferReference::indexType).build();
    private static final FeatureSetter<BufferReference> SET_MAP = new FeatureSetter.Builder<BufferReference>(FEATURE_COUNT, BufferReferenceImpl::featureIndexStatic).add(BufferReference.FeatureIDs.STRIDE, (object, value) -> ((BufferReferenceImpl) object).stride((int) value)).add(BufferReference.FeatureIDs.INDEX_TYPE, (object, value) -> ((BufferReferenceImpl) object).indexType((EContextIndex) value)).build();
  }
}
