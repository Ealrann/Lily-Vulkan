package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;

public final class VertexInputStateImpl extends FeaturedObject<VertexInputState.Features<?>> implements VertexInputState {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<VertexInputState.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<InputDescriptor> inputDescriptor = newObservableList(VertexInputState.FeatureIDs.INPUT_DESCRIPTOR, true, true);

  public VertexInputStateImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<VertexInputState.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<InputDescriptor> inputDescriptor() {
    return inputDescriptor;
  }

  @Override
  public Group<VertexInputState> lmGroup() {
    return GraphicModelDefinition.Groups.VERTEX_INPUT_STATE;
  }

  @Override
  protected FeatureSetter<VertexInputState> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<VertexInputState> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case VertexInputState.FeatureIDs.INPUT_DESCRIPTOR -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<VertexInputState> GET_MAP = new FeatureGetter.Builder<VertexInputState>(FEATURE_COUNT, VertexInputStateImpl::featureIndexStatic).add(VertexInputState.FeatureIDs.INPUT_DESCRIPTOR, VertexInputState::inputDescriptor).build();
    private static final FeatureSetter<VertexInputState> SET_MAP = new FeatureSetter.Builder<VertexInputState>(FEATURE_COUNT, VertexInputStateImpl::featureIndexStatic).build();
  }
}
