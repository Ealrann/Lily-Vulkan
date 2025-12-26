package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;

public final class PipelinePkgImpl extends FeaturedObject<PipelinePkg.Features<?>> implements PipelinePkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<PipelinePkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<AbstractPipeline> pipelines = newObservableList(PipelinePkg.FeatureIDs.PIPELINES, true, true);

  public PipelinePkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PipelinePkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<AbstractPipeline> pipelines() {
    return pipelines;
  }

  @Override
  public Group<PipelinePkg> lmGroup() {
    return ProcessModelDefinition.Groups.PIPELINE_PKG;
  }

  @Override
  protected FeatureSetter<PipelinePkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PipelinePkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PipelinePkg.FeatureIDs.PIPELINES -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PipelinePkg> GET_MAP = new FeatureGetter.Builder<PipelinePkg>(FEATURE_COUNT, PipelinePkgImpl::featureIndexStatic).add(PipelinePkg.FeatureIDs.PIPELINES, PipelinePkg::pipelines).build();
    private static final FeatureSetter<PipelinePkg> SET_MAP = new FeatureSetter.Builder<PipelinePkg>(FEATURE_COUNT, PipelinePkgImpl::featureIndexStatic).build();
  }
}
