package org.sheepy.lily.vulkan.model.vulkan.impl;

import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.WaitProcessIdle;

public final class WaitProcessIdleImpl extends FeaturedObject<WaitProcessIdle.Features<?>> implements WaitProcessIdle {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<WaitProcessIdle.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final Supplier<IProcess> process;

  public WaitProcessIdleImpl(final Supplier<IProcess> process) {
    this.process = process;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<WaitProcessIdle.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public IProcess process() {
    return process.get();
  }

  @Override
  public Group<WaitProcessIdle> lmGroup() {
    return VulkanModelDefinition.Groups.WAIT_PROCESS_IDLE;
  }

  @Override
  protected FeatureSetter<WaitProcessIdle> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<WaitProcessIdle> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case WaitProcessIdle.FeatureIDs.PROCESS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<WaitProcessIdle> GET_MAP = new FeatureGetter.Builder<WaitProcessIdle>(FEATURE_COUNT, WaitProcessIdleImpl::featureIndexStatic).add(WaitProcessIdle.FeatureIDs.PROCESS, WaitProcessIdle::process).build();
    private static final FeatureSetter<WaitProcessIdle> SET_MAP = new FeatureSetter.Builder<WaitProcessIdle>(FEATURE_COUNT, WaitProcessIdleImpl::featureIndexStatic).build();
  }
}
