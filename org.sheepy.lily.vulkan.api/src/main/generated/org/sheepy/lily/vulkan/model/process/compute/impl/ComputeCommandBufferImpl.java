package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeCommandBuffer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelDefinition;

public final class ComputeCommandBufferImpl extends FeaturedObject<ComputeCommandBuffer.Features<?>> implements ComputeCommandBuffer {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ComputeCommandBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int index;

  public ComputeCommandBufferImpl(final int index) {
    this.index = index;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ComputeCommandBuffer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int index() {
    return index;
  }

  @Override
  public void index(final int index) {
    final var oldValue = this.index;
    this.index = index;
    notifier.notifyInt(ICommandBuffer.FeatureIDs.INDEX, false, false, oldValue, index);
  }

  @Override
  public Group<ComputeCommandBuffer> lmGroup() {
    return ComputeModelDefinition.Groups.COMPUTE_COMMAND_BUFFER;
  }

  @Override
  protected FeatureSetter<ComputeCommandBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ComputeCommandBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ComputeCommandBuffer.FeatureIDs.INDEX -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ComputeCommandBuffer> GET_MAP = new FeatureGetter.Builder<ComputeCommandBuffer>(FEATURE_COUNT, ComputeCommandBufferImpl::featureIndexStatic).add(ComputeCommandBuffer.FeatureIDs.INDEX, ComputeCommandBuffer::index).build();
    private static final FeatureSetter<ComputeCommandBuffer> SET_MAP = new FeatureSetter.Builder<ComputeCommandBuffer>(FEATURE_COUNT, ComputeCommandBufferImpl::featureIndexStatic).add(ComputeCommandBuffer.FeatureIDs.INDEX, (object, value) -> ((ComputeCommandBufferImpl) object).index((int) value)).build();
  }
}
