package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IPipelineExtension;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;

public final class PipelineExtensionPkgImpl extends FeaturedObject<PipelineExtensionPkg.Features<?>> implements PipelineExtensionPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<PipelineExtensionPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IPipelineExtension> extensions = newObservableList(PipelineExtensionPkg.FeatureIDs.EXTENSIONS, true, true);

  public PipelineExtensionPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<PipelineExtensionPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IPipelineExtension> extensions() {
    return extensions;
  }

  @Override
  public Group<PipelineExtensionPkg> lmGroup() {
    return ProcessModelDefinition.Groups.PIPELINE_EXTENSION_PKG;
  }

  @Override
  protected FeatureSetter<PipelineExtensionPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<PipelineExtensionPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case PipelineExtensionPkg.FeatureIDs.EXTENSIONS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<PipelineExtensionPkg> GET_MAP = new FeatureGetter.Builder<PipelineExtensionPkg>(FEATURE_COUNT, PipelineExtensionPkgImpl::featureIndexStatic).add(PipelineExtensionPkg.FeatureIDs.EXTENSIONS, PipelineExtensionPkg::extensions).build();
    private static final FeatureSetter<PipelineExtensionPkg> SET_MAP = new FeatureSetter.Builder<PipelineExtensionPkg>(FEATURE_COUNT, PipelineExtensionPkgImpl::featureIndexStatic).build();
  }
}
