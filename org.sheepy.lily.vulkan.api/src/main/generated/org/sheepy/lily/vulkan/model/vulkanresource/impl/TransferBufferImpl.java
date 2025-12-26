package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class TransferBufferImpl extends FeaturedObject<TransferBuffer.Features<?>> implements TransferBuffer {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<TransferBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private long size;
  private boolean usedToPush;
  private boolean usedToFetch;

  public TransferBufferImpl(final String name, final boolean usedToPush,
      final boolean usedToFetch) {
    this.name = name;
    this.usedToPush = usedToPush;
    this.usedToFetch = usedToFetch;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<TransferBuffer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public long size() {
    return size;
  }

  @Override
  public void size(final long size) {
    final var oldValue = this.size;
    this.size = size;
    notifier.notifyLong(TransferBuffer.FeatureIDs.SIZE, false, false, oldValue, size);
  }

  @Override
  public boolean usedToPush() {
    return usedToPush;
  }

  @Override
  public void usedToPush(final boolean usedToPush) {
    final var oldValue = this.usedToPush;
    this.usedToPush = usedToPush;
    notifier.notifyBoolean(TransferBuffer.FeatureIDs.USED_TO_PUSH, false, false, oldValue, usedToPush);
  }

  @Override
  public boolean usedToFetch() {
    return usedToFetch;
  }

  @Override
  public void usedToFetch(final boolean usedToFetch) {
    final var oldValue = this.usedToFetch;
    this.usedToFetch = usedToFetch;
    notifier.notifyBoolean(TransferBuffer.FeatureIDs.USED_TO_FETCH, false, false, oldValue, usedToFetch);
  }

  @Override
  public Group<TransferBuffer> lmGroup() {
    return VulkanResourceModelDefinition.Groups.TRANSFER_BUFFER;
  }

  @Override
  protected FeatureSetter<TransferBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<TransferBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case TransferBuffer.FeatureIDs.NAME -> 0;
      case TransferBuffer.FeatureIDs.SIZE -> 1;
      case TransferBuffer.FeatureIDs.USED_TO_PUSH -> 2;
      case TransferBuffer.FeatureIDs.USED_TO_FETCH -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<TransferBuffer> GET_MAP = new FeatureGetter.Builder<TransferBuffer>(FEATURE_COUNT, TransferBufferImpl::featureIndexStatic).add(TransferBuffer.FeatureIDs.NAME, TransferBuffer::name).add(TransferBuffer.FeatureIDs.SIZE, TransferBuffer::size).add(TransferBuffer.FeatureIDs.USED_TO_PUSH, TransferBuffer::usedToPush).add(TransferBuffer.FeatureIDs.USED_TO_FETCH, TransferBuffer::usedToFetch).build();
    private static final FeatureSetter<TransferBuffer> SET_MAP = new FeatureSetter.Builder<TransferBuffer>(FEATURE_COUNT, TransferBufferImpl::featureIndexStatic).add(TransferBuffer.FeatureIDs.SIZE, (object, value) -> ((TransferBufferImpl) object).size((long) value)).add(TransferBuffer.FeatureIDs.USED_TO_PUSH, (object, value) -> ((TransferBufferImpl) object).usedToPush((boolean) value)).add(TransferBuffer.FeatureIDs.USED_TO_FETCH, (object, value) -> ((TransferBufferImpl) object).usedToFetch((boolean) value)).build();
  }
}
