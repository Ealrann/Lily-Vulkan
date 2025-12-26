package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class MemoryChunkImpl extends FeaturedObject<MemoryChunk.Features<?>> implements MemoryChunk {
  private static final int FEATURE_COUNT = 3;
  private final ModelNotifier<MemoryChunk.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<IMemoryChunkPart> parts = newObservableList(MemoryChunk.FeatureIDs.PARTS, true, true);
  private TransferBuffer transferBuffer;

  public MemoryChunkImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<MemoryChunk.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<IMemoryChunkPart> parts() {
    return parts;
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
    notifier.notify(MemoryChunk.FeatureIDs.TRANSFER_BUFFER, false, false, eventType, oldValue, transferBuffer);
  }

  @Override
  public Group<MemoryChunk> lmGroup() {
    return VulkanResourceModelDefinition.Groups.MEMORY_CHUNK;
  }

  @Override
  protected FeatureSetter<MemoryChunk> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<MemoryChunk> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case MemoryChunk.FeatureIDs.NAME -> 0;
      case MemoryChunk.FeatureIDs.PARTS -> 1;
      case MemoryChunk.FeatureIDs.TRANSFER_BUFFER -> 2;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<MemoryChunk> GET_MAP = new FeatureGetter.Builder<MemoryChunk>(FEATURE_COUNT, MemoryChunkImpl::featureIndexStatic).add(MemoryChunk.FeatureIDs.NAME, MemoryChunk::name).add(MemoryChunk.FeatureIDs.PARTS, MemoryChunk::parts).add(MemoryChunk.FeatureIDs.TRANSFER_BUFFER, MemoryChunk::transferBuffer).build();
    private static final FeatureSetter<MemoryChunk> SET_MAP = new FeatureSetter.Builder<MemoryChunk>(FEATURE_COUNT, MemoryChunkImpl::featureIndexStatic).add(MemoryChunk.FeatureIDs.TRANSFER_BUFFER, (object, value) -> ((MemoryChunkImpl) object).transferBuffer((TransferBuffer) value)).build();
  }
}
