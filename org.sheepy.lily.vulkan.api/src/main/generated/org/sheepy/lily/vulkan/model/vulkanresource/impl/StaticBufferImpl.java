package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public final class StaticBufferImpl extends FeaturedObject<StaticBuffer.Features<?>> implements StaticBuffer {
  private static final int FEATURE_COUNT = 4;
  private final ModelNotifier<StaticBuffer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<EBufferUsage> usages = newObservableList(IBuffer.FeatureIDs.USAGES, false, false);
  private long size;
  private boolean initWithZero;

  public StaticBufferImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<StaticBuffer.Features<?>> notifier() {
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
  public long size() {
    return size;
  }

  @Override
  public void size(final long size) {
    final var oldValue = this.size;
    this.size = size;
    notifier.notifyLong(StaticBuffer.FeatureIDs.SIZE, false, false, oldValue, size);
  }

  @Override
  public boolean initWithZero() {
    return initWithZero;
  }

  @Override
  public void initWithZero(final boolean initWithZero) {
    final var oldValue = this.initWithZero;
    this.initWithZero = initWithZero;
    notifier.notifyBoolean(StaticBuffer.FeatureIDs.INIT_WITH_ZERO, false, false, oldValue, initWithZero);
  }

  @Override
  public Group<StaticBuffer> lmGroup() {
    return VulkanResourceModelDefinition.Groups.STATIC_BUFFER;
  }

  @Override
  protected FeatureSetter<StaticBuffer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<StaticBuffer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case StaticBuffer.FeatureIDs.NAME -> 0;
      case StaticBuffer.FeatureIDs.USAGES -> 1;
      case StaticBuffer.FeatureIDs.SIZE -> 2;
      case StaticBuffer.FeatureIDs.INIT_WITH_ZERO -> 3;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<StaticBuffer> GET_MAP = new FeatureGetter.Builder<StaticBuffer>(FEATURE_COUNT, StaticBufferImpl::featureIndexStatic).add(StaticBuffer.FeatureIDs.NAME, StaticBuffer::name).add(StaticBuffer.FeatureIDs.USAGES, StaticBuffer::usages).add(StaticBuffer.FeatureIDs.SIZE, StaticBuffer::size).add(StaticBuffer.FeatureIDs.INIT_WITH_ZERO, StaticBuffer::initWithZero).build();
    private static final FeatureSetter<StaticBuffer> SET_MAP = new FeatureSetter.Builder<StaticBuffer>(FEATURE_COUNT, StaticBufferImpl::featureIndexStatic).add(StaticBuffer.FeatureIDs.SIZE, (object, value) -> ((StaticBufferImpl) object).size((long) value)).add(StaticBuffer.FeatureIDs.INIT_WITH_ZERO, (object, value) -> ((StaticBufferImpl) object).initWithZero((boolean) value)).build();
  }
}
