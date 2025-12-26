package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public final class BufferMemoryImpl extends FeaturedObject<BufferMemory.Features<?>> implements BufferMemory {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<BufferMemory.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<IBuffer> buffers = newObservableList(BufferMemory.FeatureIDs.BUFFERS, true, true);

  public BufferMemoryImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BufferMemory.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public List<IBuffer> buffers() {
    return buffers;
  }

  @Override
  public Group<BufferMemory> lmGroup() {
    return VulkanResourceModelDefinition.Groups.BUFFER_MEMORY;
  }

  @Override
  protected FeatureSetter<BufferMemory> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BufferMemory> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BufferMemory.FeatureIDs.NAME -> 0;
      case BufferMemory.FeatureIDs.BUFFERS -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BufferMemory> GET_MAP = new FeatureGetter.Builder<BufferMemory>(FEATURE_COUNT, BufferMemoryImpl::featureIndexStatic).add(BufferMemory.FeatureIDs.NAME, BufferMemory::name).add(BufferMemory.FeatureIDs.BUFFERS, BufferMemory::buffers).build();
    private static final FeatureSetter<BufferMemory> SET_MAP = new FeatureSetter.Builder<BufferMemory>(FEATURE_COUNT, BufferMemoryImpl::featureIndexStatic).build();
  }
}
