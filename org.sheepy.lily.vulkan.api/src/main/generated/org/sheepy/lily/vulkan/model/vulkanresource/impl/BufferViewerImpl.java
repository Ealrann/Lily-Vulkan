package org.sheepy.lily.vulkan.model.vulkanresource.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EBufferUsage;

public final class BufferViewerImpl extends FeaturedObject<BufferViewer.Features<?>> implements BufferViewer {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<BufferViewer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private final List<EBufferUsage> usages = newObservableList(IBuffer.FeatureIDs.USAGES, false, false);
  private float growFactor;
  private float growThreshold;
  private long size;
  private IBufferDataSource dataSource;
  private String dataSourceIdentifier;

  public BufferViewerImpl(final String name, final float growFactor, final float growThreshold) {
    this.name = name;
    this.growFactor = growFactor;
    this.growThreshold = growThreshold;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<BufferViewer.Features<?>> notifier() {
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
  public float growFactor() {
    return growFactor;
  }

  @Override
  public void growFactor(final float growFactor) {
    final var oldValue = this.growFactor;
    this.growFactor = growFactor;
    notifier.notifyFloat(BufferViewer.FeatureIDs.GROW_FACTOR, false, false, oldValue, growFactor);
  }

  @Override
  public float growThreshold() {
    return growThreshold;
  }

  @Override
  public void growThreshold(final float growThreshold) {
    final var oldValue = this.growThreshold;
    this.growThreshold = growThreshold;
    notifier.notifyFloat(BufferViewer.FeatureIDs.GROW_THRESHOLD, false, false, oldValue, growThreshold);
  }

  @Override
  public long size() {
    return size;
  }

  @Override
  public void size(final long size) {
    final var oldValue = this.size;
    this.size = size;
    notifier.notifyLong(BufferViewer.FeatureIDs.SIZE, false, false, oldValue, size);
  }

  @Override
  public IBufferDataSource dataSource() {
    return dataSource;
  }

  @Override
  public void dataSource(final IBufferDataSource dataSource) {
    final var oldValue = this.dataSource;
    final var eventType = dataSource == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dataSource = dataSource;
    notifier.notify(BufferViewer.FeatureIDs.DATA_SOURCE, false, false, eventType, oldValue, dataSource);
  }

  @Override
  public String dataSourceIdentifier() {
    return dataSourceIdentifier;
  }

  @Override
  public void dataSourceIdentifier(final String dataSourceIdentifier) {
    final var oldValue = this.dataSourceIdentifier;
    this.dataSourceIdentifier = dataSourceIdentifier;
    notifier.notify(BufferViewer.FeatureIDs.DATA_SOURCE_IDENTIFIER, false, false, oldValue, dataSourceIdentifier);
  }

  @Override
  public Group<BufferViewer> lmGroup() {
    return VulkanResourceModelDefinition.Groups.BUFFER_VIEWER;
  }

  @Override
  protected FeatureSetter<BufferViewer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<BufferViewer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case BufferViewer.FeatureIDs.NAME -> 0;
      case BufferViewer.FeatureIDs.USAGES -> 1;
      case BufferViewer.FeatureIDs.GROW_FACTOR -> 2;
      case BufferViewer.FeatureIDs.GROW_THRESHOLD -> 3;
      case BufferViewer.FeatureIDs.SIZE -> 4;
      case BufferViewer.FeatureIDs.DATA_SOURCE -> 5;
      case BufferViewer.FeatureIDs.DATA_SOURCE_IDENTIFIER -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<BufferViewer> GET_MAP = new FeatureGetter.Builder<BufferViewer>(FEATURE_COUNT, BufferViewerImpl::featureIndexStatic).add(BufferViewer.FeatureIDs.NAME, BufferViewer::name).add(BufferViewer.FeatureIDs.USAGES, BufferViewer::usages).add(BufferViewer.FeatureIDs.GROW_FACTOR, BufferViewer::growFactor).add(BufferViewer.FeatureIDs.GROW_THRESHOLD, BufferViewer::growThreshold).add(BufferViewer.FeatureIDs.SIZE, BufferViewer::size).add(BufferViewer.FeatureIDs.DATA_SOURCE, BufferViewer::dataSource).add(BufferViewer.FeatureIDs.DATA_SOURCE_IDENTIFIER, BufferViewer::dataSourceIdentifier).build();
    private static final FeatureSetter<BufferViewer> SET_MAP = new FeatureSetter.Builder<BufferViewer>(FEATURE_COUNT, BufferViewerImpl::featureIndexStatic).add(BufferViewer.FeatureIDs.GROW_FACTOR, (object, value) -> ((BufferViewerImpl) object).growFactor((float) value)).add(BufferViewer.FeatureIDs.GROW_THRESHOLD, (object, value) -> ((BufferViewerImpl) object).growThreshold((float) value)).add(BufferViewer.FeatureIDs.SIZE, (object, value) -> ((BufferViewerImpl) object).size((long) value)).add(BufferViewer.FeatureIDs.DATA_SOURCE, (object, value) -> ((BufferViewerImpl) object).dataSource((IBufferDataSource) value)).add(BufferViewer.FeatureIDs.DATA_SOURCE_IDENTIFIER, (object, value) -> ((BufferViewerImpl) object).dataSourceIdentifier((String) value)).build();
  }
}
