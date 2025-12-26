package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.graphicpipeline.DynamicViewportState;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;

public final class DynamicViewportStateImpl extends FeaturedObject<DynamicViewportState.Features<?>> implements DynamicViewportState {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<DynamicViewportState.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private int viewportCount;
  private int scissorCount;

  public DynamicViewportStateImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DynamicViewportState.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public int viewportCount() {
    return viewportCount;
  }

  @Override
  public void viewportCount(final int viewportCount) {
    final var oldValue = this.viewportCount;
    this.viewportCount = viewportCount;
    notifier.notifyInt(DynamicViewportState.FeatureIDs.VIEWPORT_COUNT, false, false, oldValue, viewportCount);
  }

  @Override
  public int scissorCount() {
    return scissorCount;
  }

  @Override
  public void scissorCount(final int scissorCount) {
    final var oldValue = this.scissorCount;
    this.scissorCount = scissorCount;
    notifier.notifyInt(DynamicViewportState.FeatureIDs.SCISSOR_COUNT, false, false, oldValue, scissorCount);
  }

  @Override
  public Group<DynamicViewportState> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.DYNAMIC_VIEWPORT_STATE;
  }

  @Override
  protected FeatureSetter<DynamicViewportState> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DynamicViewportState> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DynamicViewportState.FeatureIDs.VIEWPORT_COUNT -> 0;
      case DynamicViewportState.FeatureIDs.SCISSOR_COUNT -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DynamicViewportState> GET_MAP = new FeatureGetter.Builder<DynamicViewportState>(FEATURE_COUNT, DynamicViewportStateImpl::featureIndexStatic).add(DynamicViewportState.FeatureIDs.VIEWPORT_COUNT, DynamicViewportState::viewportCount).add(DynamicViewportState.FeatureIDs.SCISSOR_COUNT, DynamicViewportState::scissorCount).build();
    private static final FeatureSetter<DynamicViewportState> SET_MAP = new FeatureSetter.Builder<DynamicViewportState>(FEATURE_COUNT, DynamicViewportStateImpl::featureIndexStatic).add(DynamicViewportState.FeatureIDs.VIEWPORT_COUNT, (object, value) -> ((DynamicViewportStateImpl) object).viewportCount((int) value)).add(DynamicViewportState.FeatureIDs.SCISSOR_COUNT, (object, value) -> ((DynamicViewportStateImpl) object).scissorCount((int) value)).build();
  }
}
