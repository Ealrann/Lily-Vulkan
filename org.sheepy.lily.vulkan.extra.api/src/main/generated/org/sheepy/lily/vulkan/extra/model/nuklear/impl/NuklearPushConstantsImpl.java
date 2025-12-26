package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearModelDefinition;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class NuklearPushConstantsImpl extends FeaturedObject<NuklearPushConstants.Features<?>> implements NuklearPushConstants {
  private static final int FEATURE_COUNT = 6;
  private final ModelNotifier<NuklearPushConstants.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private boolean enabled;
  private final List<EShaderStage> stages = newObservableList(PushConstant.FeatureIDs.STAGES, false, false);
  private int width;
  private int height;
  private int currentDescriptor;

  public NuklearPushConstantsImpl(final String name, final List<EShaderStage> stages) {
    this.name = name;
    this.stages.addAll(stages);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<NuklearPushConstants.Features<?>> notifier() {
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
  public List<EShaderStage> stages() {
    return stages;
  }

  @Override
  public int width() {
    return width;
  }

  @Override
  public void width(final int width) {
    final var oldValue = this.width;
    this.width = width;
    notifier.notifyInt(NuklearPushConstants.FeatureIDs.WIDTH, false, false, oldValue, width);
  }

  @Override
  public int height() {
    return height;
  }

  @Override
  public void height(final int height) {
    final var oldValue = this.height;
    this.height = height;
    notifier.notifyInt(NuklearPushConstants.FeatureIDs.HEIGHT, false, false, oldValue, height);
  }

  @Override
  public int currentDescriptor() {
    return currentDescriptor;
  }

  @Override
  public void currentDescriptor(final int currentDescriptor) {
    final var oldValue = this.currentDescriptor;
    this.currentDescriptor = currentDescriptor;
    notifier.notifyInt(NuklearPushConstants.FeatureIDs.CURRENT_DESCRIPTOR, false, false, oldValue, currentDescriptor);
  }

  @Override
  public Group<NuklearPushConstants> lmGroup() {
    return NuklearModelDefinition.Groups.NUKLEAR_PUSH_CONSTANTS;
  }

  @Override
  protected FeatureSetter<NuklearPushConstants> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<NuklearPushConstants> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case NuklearPushConstants.FeatureIDs.NAME -> 0;
      case NuklearPushConstants.FeatureIDs.ENABLED -> 1;
      case NuklearPushConstants.FeatureIDs.STAGES -> 2;
      case NuklearPushConstants.FeatureIDs.WIDTH -> 3;
      case NuklearPushConstants.FeatureIDs.HEIGHT -> 4;
      case NuklearPushConstants.FeatureIDs.CURRENT_DESCRIPTOR -> 5;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<NuklearPushConstants> GET_MAP = new FeatureGetter.Builder<NuklearPushConstants>(FEATURE_COUNT, NuklearPushConstantsImpl::featureIndexStatic).add(NuklearPushConstants.FeatureIDs.NAME, NuklearPushConstants::name).add(NuklearPushConstants.FeatureIDs.ENABLED, NuklearPushConstants::enabled).add(NuklearPushConstants.FeatureIDs.STAGES, NuklearPushConstants::stages).add(NuklearPushConstants.FeatureIDs.WIDTH, NuklearPushConstants::width).add(NuklearPushConstants.FeatureIDs.HEIGHT, NuklearPushConstants::height).add(NuklearPushConstants.FeatureIDs.CURRENT_DESCRIPTOR, NuklearPushConstants::currentDescriptor).build();
    private static final FeatureSetter<NuklearPushConstants> SET_MAP = new FeatureSetter.Builder<NuklearPushConstants>(FEATURE_COUNT, NuklearPushConstantsImpl::featureIndexStatic).add(NuklearPushConstants.FeatureIDs.ENABLED, (object, value) -> ((NuklearPushConstantsImpl) object).enabled((boolean) value)).add(NuklearPushConstants.FeatureIDs.WIDTH, (object, value) -> ((NuklearPushConstantsImpl) object).width((int) value)).add(NuklearPushConstants.FeatureIDs.HEIGHT, (object, value) -> ((NuklearPushConstantsImpl) object).height((int) value)).add(NuklearPushConstants.FeatureIDs.CURRENT_DESCRIPTOR, (object, value) -> ((NuklearPushConstantsImpl) object).currentDescriptor((int) value)).build();
  }
}
