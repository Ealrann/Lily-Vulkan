package org.sheepy.lily.vulkan.model.vulkan.impl;

import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.RunProcess;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;

public final class RunProcessImpl extends FeaturedObject<RunProcess.Features<?>> implements RunProcess {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<RunProcess.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final Supplier<IProcess> process;

  public RunProcessImpl(final Supplier<IProcess> process) {
    this.process = process;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<RunProcess.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public IProcess process() {
    return process.get();
  }

  @Override
  public Group<RunProcess> lmGroup() {
    return VulkanModelDefinition.Groups.RUN_PROCESS;
  }

  @Override
  protected FeatureSetter<RunProcess> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<RunProcess> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case RunProcess.FeatureIDs.PROCESS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<RunProcess> GET_MAP = new FeatureGetter.Builder<RunProcess>(FEATURE_COUNT, RunProcessImpl::featureIndexStatic).add(RunProcess.FeatureIDs.PROCESS, RunProcess::process).build();
    private static final FeatureSetter<RunProcess> SET_MAP = new FeatureSetter.Builder<RunProcess>(FEATURE_COUNT, RunProcessImpl::featureIndexStatic).build();
  }
}
