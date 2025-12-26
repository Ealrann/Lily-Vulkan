package org.sheepy.vulkan.model.graphicpipeline.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.EDynamicState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;

public final class DynamicStateImpl extends FeaturedObject<DynamicState.Features<?>> implements DynamicState {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<DynamicState.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<EDynamicState> states = newObservableList(DynamicState.FeatureIDs.STATES, false, false);

  public DynamicStateImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<DynamicState.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<EDynamicState> states() {
    return states;
  }

  @Override
  public Group<DynamicState> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.DYNAMIC_STATE;
  }

  @Override
  protected FeatureSetter<DynamicState> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<DynamicState> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case DynamicState.FeatureIDs.STATES -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<DynamicState> GET_MAP = new FeatureGetter.Builder<DynamicState>(FEATURE_COUNT, DynamicStateImpl::featureIndexStatic).add(DynamicState.FeatureIDs.STATES, DynamicState::states).build();
    private static final FeatureSetter<DynamicState> SET_MAP = new FeatureSetter.Builder<DynamicState>(FEATURE_COUNT, DynamicStateImpl::featureIndexStatic).build();
  }
}
