package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.EPrimitiveTopology;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;

public final class InputAssemblyImpl extends FeaturedObject<InputAssembly.Features<?>> implements InputAssembly {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<InputAssembly.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private boolean primitiveRestartEnabled;
  private EPrimitiveTopology primitiveTopology;

  public InputAssemblyImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<InputAssembly.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public boolean primitiveRestartEnabled() {
    return primitiveRestartEnabled;
  }

  @Override
  public void primitiveRestartEnabled(final boolean primitiveRestartEnabled) {
    final var oldValue = this.primitiveRestartEnabled;
    this.primitiveRestartEnabled = primitiveRestartEnabled;
    notifier.notifyBoolean(InputAssembly.FeatureIDs.PRIMITIVE_RESTART_ENABLED, false, false, oldValue, primitiveRestartEnabled);
  }

  @Override
  public EPrimitiveTopology primitiveTopology() {
    return primitiveTopology;
  }

  @Override
  public void primitiveTopology(final EPrimitiveTopology primitiveTopology) {
    final var oldValue = this.primitiveTopology;
    this.primitiveTopology = primitiveTopology;
    notifier.notify(InputAssembly.FeatureIDs.PRIMITIVE_TOPOLOGY, false, false, oldValue, primitiveTopology);
  }

  @Override
  public Group<InputAssembly> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.INPUT_ASSEMBLY;
  }

  @Override
  protected FeatureSetter<InputAssembly> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<InputAssembly> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case InputAssembly.FeatureIDs.PRIMITIVE_RESTART_ENABLED -> 0;
      case InputAssembly.FeatureIDs.PRIMITIVE_TOPOLOGY -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<InputAssembly> GET_MAP = new FeatureGetter.Builder<InputAssembly>(FEATURE_COUNT, InputAssemblyImpl::featureIndexStatic).add(InputAssembly.FeatureIDs.PRIMITIVE_RESTART_ENABLED, InputAssembly::primitiveRestartEnabled).add(InputAssembly.FeatureIDs.PRIMITIVE_TOPOLOGY, InputAssembly::primitiveTopology).build();
    private static final FeatureSetter<InputAssembly> SET_MAP = new FeatureSetter.Builder<InputAssembly>(FEATURE_COUNT, InputAssemblyImpl::featureIndexStatic).add(InputAssembly.FeatureIDs.PRIMITIVE_RESTART_ENABLED, (object, value) -> ((InputAssemblyImpl) object).primitiveRestartEnabled((boolean) value)).add(InputAssembly.FeatureIDs.PRIMITIVE_TOPOLOGY, (object, value) -> ((InputAssemblyImpl) object).primitiveTopology((EPrimitiveTopology) value)).build();
  }
}
