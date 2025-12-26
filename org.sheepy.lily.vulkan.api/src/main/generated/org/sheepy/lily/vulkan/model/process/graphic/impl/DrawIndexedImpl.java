package org.sheepy.lily.vulkan.model.process.graphic.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;

public final class DrawIndexedImpl extends FeaturedObject<DrawIndexed.Features<?>> implements DrawIndexed {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<DrawIndexed.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private int indexCount;
  private int instanceCount;
  private int firstIndex;
  private int vertexOffset;
  private int firstInstance;

  public DrawIndexedImpl(final String name, final int indexCount) {
    this.name = name;
    this.indexCount = indexCount;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DrawIndexed.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(IPipelineTask.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public int indexCount() {
    return indexCount;
  }

  @Override
  public void indexCount(final int indexCount) {
    final var oldValue = this.indexCount;
    this.indexCount = indexCount;
    notifier.notifyInt(DrawIndexed.FeatureIDs.INDEX_COUNT, false, false, oldValue, indexCount);
  }

  @Override
  public int instanceCount() {
    return instanceCount;
  }

  @Override
  public void instanceCount(final int instanceCount) {
    final var oldValue = this.instanceCount;
    this.instanceCount = instanceCount;
    notifier.notifyInt(DrawIndexed.FeatureIDs.INSTANCE_COUNT, false, false, oldValue, instanceCount);
  }

  @Override
  public int firstIndex() {
    return firstIndex;
  }

  @Override
  public void firstIndex(final int firstIndex) {
    final var oldValue = this.firstIndex;
    this.firstIndex = firstIndex;
    notifier.notifyInt(DrawIndexed.FeatureIDs.FIRST_INDEX, false, false, oldValue, firstIndex);
  }

  @Override
  public int vertexOffset() {
    return vertexOffset;
  }

  @Override
  public void vertexOffset(final int vertexOffset) {
    final var oldValue = this.vertexOffset;
    this.vertexOffset = vertexOffset;
    notifier.notifyInt(DrawIndexed.FeatureIDs.VERTEX_OFFSET, false, false, oldValue, vertexOffset);
  }

  @Override
  public int firstInstance() {
    return firstInstance;
  }

  @Override
  public void firstInstance(final int firstInstance) {
    final var oldValue = this.firstInstance;
    this.firstInstance = firstInstance;
    notifier.notifyInt(DrawIndexed.FeatureIDs.FIRST_INSTANCE, false, false, oldValue, firstInstance);
  }

  @Override
  public Group<DrawIndexed> lmGroup() {
    return GraphicModelDefinition.Groups.DRAW_INDEXED;
  }

  @Override
  protected FeatureSetter<DrawIndexed> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DrawIndexed> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DrawIndexed.FeatureIDs.NAME -> 0;
      case DrawIndexed.FeatureIDs.ENABLED -> 1;
      case DrawIndexed.FeatureIDs.INDEX_COUNT -> 2;
      case DrawIndexed.FeatureIDs.INSTANCE_COUNT -> 3;
      case DrawIndexed.FeatureIDs.FIRST_INDEX -> 4;
      case DrawIndexed.FeatureIDs.VERTEX_OFFSET -> 5;
      case DrawIndexed.FeatureIDs.FIRST_INSTANCE -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DrawIndexed> GET_MAP = new FeatureGetter.Builder<DrawIndexed>(FEATURE_COUNT, DrawIndexedImpl::featureIndexStatic).add(DrawIndexed.FeatureIDs.NAME, DrawIndexed::name).add(DrawIndexed.FeatureIDs.ENABLED, DrawIndexed::enabled).add(DrawIndexed.FeatureIDs.INDEX_COUNT, DrawIndexed::indexCount).add(DrawIndexed.FeatureIDs.INSTANCE_COUNT, DrawIndexed::instanceCount).add(DrawIndexed.FeatureIDs.FIRST_INDEX, DrawIndexed::firstIndex).add(DrawIndexed.FeatureIDs.VERTEX_OFFSET, DrawIndexed::vertexOffset).add(DrawIndexed.FeatureIDs.FIRST_INSTANCE, DrawIndexed::firstInstance).build();
    private static final FeatureSetter<DrawIndexed> SET_MAP = new FeatureSetter.Builder<DrawIndexed>(FEATURE_COUNT, DrawIndexedImpl::featureIndexStatic).add(DrawIndexed.FeatureIDs.ENABLED, (object, value) -> ((DrawIndexedImpl) object).enabled((boolean) value)).add(DrawIndexed.FeatureIDs.INDEX_COUNT, (object, value) -> ((DrawIndexedImpl) object).indexCount((int) value)).add(DrawIndexed.FeatureIDs.INSTANCE_COUNT, (object, value) -> ((DrawIndexedImpl) object).instanceCount((int) value)).add(DrawIndexed.FeatureIDs.FIRST_INDEX, (object, value) -> ((DrawIndexedImpl) object).firstIndex((int) value)).add(DrawIndexed.FeatureIDs.VERTEX_OFFSET, (object, value) -> ((DrawIndexedImpl) object).vertexOffset((int) value)).add(DrawIndexed.FeatureIDs.FIRST_INSTANCE, (object, value) -> ((DrawIndexedImpl) object).firstInstance((int) value)).build();
  }
}
