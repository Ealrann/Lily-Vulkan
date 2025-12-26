package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.IProcessExtension;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;

public final class ProcessExtensionPkgImpl extends FeaturedObject<ProcessExtensionPkg.Features<?>> implements ProcessExtensionPkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<ProcessExtensionPkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<IProcessExtension> extensions = newObservableList(ProcessExtensionPkg.FeatureIDs.EXTENSIONS, true, true);

  public ProcessExtensionPkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ProcessExtensionPkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<IProcessExtension> extensions() {
    return extensions;
  }

  @Override
  public Group<ProcessExtensionPkg> lmGroup() {
    return ProcessModelDefinition.Groups.PROCESS_EXTENSION_PKG;
  }

  @Override
  protected FeatureSetter<ProcessExtensionPkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ProcessExtensionPkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ProcessExtensionPkg.FeatureIDs.EXTENSIONS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ProcessExtensionPkg> GET_MAP = new FeatureGetter.Builder<ProcessExtensionPkg>(FEATURE_COUNT, ProcessExtensionPkgImpl::featureIndexStatic).add(ProcessExtensionPkg.FeatureIDs.EXTENSIONS, ProcessExtensionPkg::extensions).build();
    private static final FeatureSetter<ProcessExtensionPkg> SET_MAP = new FeatureSetter.Builder<ProcessExtensionPkg>(FEATURE_COUNT, ProcessExtensionPkgImpl::featureIndexStatic).build();
  }
}
