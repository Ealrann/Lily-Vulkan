package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferBarrier;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EAccess;

public final class BufferBarrierImpl extends FeaturedObject<BufferBarrier.Features<?>> implements BufferBarrier {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<BufferBarrier.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<EAccess> srcAccessMask = newObservableList(Barrier.FeatureIDs.SRC_ACCESS_MASK, false, false);
  private final List<EAccess> dstAccessMask = newObservableList(Barrier.FeatureIDs.DST_ACCESS_MASK, false, false);
  private BufferReference buffers;

  public BufferBarrierImpl(final String name, final BufferReference buffers) {
    this.name = name;
    this.buffers = buffers;
    setContainer(buffers, BufferBarrier.FeatureIDs.BUFFERS);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BufferBarrier.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<EAccess> srcAccessMask() {
    return srcAccessMask;
  }

  @Override
  public List<EAccess> dstAccessMask() {
    return dstAccessMask;
  }

  @Override
  public BufferReference buffers() {
    return buffers;
  }

  @Override
  public void buffers(final BufferReference buffers) {
    final var oldValue = this.buffers;
    final var eventType = buffers == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.buffers = buffers;
    setContainer(buffers, BufferBarrier.FeatureIDs.BUFFERS);
    beforeContainmentNotify(eventType, oldValue, buffers);
    notifier.notify(BufferBarrier.FeatureIDs.BUFFERS, true, false, eventType, oldValue, buffers);
    afterContainmentNotify(eventType, oldValue, buffers);
  }

  @Override
  public Group<BufferBarrier> lmGroup() {
    return VulkanResourceModelDefinition.Groups.BUFFER_BARRIER;
  }

  @Override
  protected FeatureSetter<BufferBarrier> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BufferBarrier> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BufferBarrier.FeatureIDs.NAME -> 0;
      case BufferBarrier.FeatureIDs.SRC_ACCESS_MASK -> 1;
      case BufferBarrier.FeatureIDs.DST_ACCESS_MASK -> 2;
      case BufferBarrier.FeatureIDs.BUFFERS -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BufferBarrier> GET_MAP = new FeatureGetter.Builder<BufferBarrier>(FEATURE_COUNT, BufferBarrierImpl::featureIndexStatic).add(BufferBarrier.FeatureIDs.NAME, BufferBarrier::name).add(BufferBarrier.FeatureIDs.SRC_ACCESS_MASK, BufferBarrier::srcAccessMask).add(BufferBarrier.FeatureIDs.DST_ACCESS_MASK, BufferBarrier::dstAccessMask).add(BufferBarrier.FeatureIDs.BUFFERS, BufferBarrier::buffers).build();
    private static final FeatureSetter<BufferBarrier> SET_MAP = new FeatureSetter.Builder<BufferBarrier>(FEATURE_COUNT, BufferBarrierImpl::featureIndexStatic).add(BufferBarrier.FeatureIDs.BUFFERS, (object, value) -> ((BufferBarrierImpl) object).buffers((BufferReference) value)).build();
  }
}
