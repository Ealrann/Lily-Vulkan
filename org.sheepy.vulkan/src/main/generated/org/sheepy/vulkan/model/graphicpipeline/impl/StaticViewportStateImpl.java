package org.sheepy.vulkan.model.graphicpipeline.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.IViewport;
import org.sheepy.vulkan.model.graphicpipeline.Scissor;
import org.sheepy.vulkan.model.graphicpipeline.StaticViewportState;

public final class StaticViewportStateImpl extends FeaturedObject<StaticViewportState.Features<?>> implements StaticViewportState {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<StaticViewportState.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IViewport> viewports = newObservableList(StaticViewportState.FeatureIDs.VIEWPORTS, true, true);
  private final List<Scissor> scissors = newObservableList(StaticViewportState.FeatureIDs.SCISSORS, true, true);

  public StaticViewportStateImpl(final List<IViewport> viewports, final List<Scissor> scissors) {
    this.viewports.addAll(viewports);
    this.scissors.addAll(scissors);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<StaticViewportState.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IViewport> viewports() {
    return viewports;
  }

  @Override
  public List<Scissor> scissors() {
    return scissors;
  }

  @Override
  public Group<StaticViewportState> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.STATIC_VIEWPORT_STATE;
  }

  @Override
  protected FeatureSetter<StaticViewportState> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<StaticViewportState> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case StaticViewportState.FeatureIDs.VIEWPORTS -> 0;
      case StaticViewportState.FeatureIDs.SCISSORS -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<StaticViewportState> GET_MAP = new FeatureGetter.Builder<StaticViewportState>(FEATURE_COUNT, StaticViewportStateImpl::featureIndexStatic).add(StaticViewportState.FeatureIDs.VIEWPORTS, StaticViewportState::viewports).add(StaticViewportState.FeatureIDs.SCISSORS, StaticViewportState::scissors).build();
    private static final FeatureSetter<StaticViewportState> SET_MAP = new FeatureSetter.Builder<StaticViewportState>(FEATURE_COUNT, StaticViewportStateImpl::featureIndexStatic).build();
  }
}
