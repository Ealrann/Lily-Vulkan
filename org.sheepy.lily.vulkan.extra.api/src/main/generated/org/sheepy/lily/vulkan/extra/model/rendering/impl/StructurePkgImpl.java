package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.extra.model.rendering.StructurePkg;

public final class StructurePkgImpl extends FeaturedObject<StructurePkg.Features<?>> implements StructurePkg {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<StructurePkg.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<Structure> structures = newObservableList(StructurePkg.FeatureIDs.STRUCTURES, true, true);

  public StructurePkgImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<StructurePkg.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<Structure> structures() {
    return structures;
  }

  @Override
  public Group<StructurePkg> lmGroup() {
    return RenderingModelDefinition.Groups.STRUCTURE_PKG;
  }

  @Override
  protected FeatureSetter<StructurePkg> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<StructurePkg> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case StructurePkg.FeatureIDs.STRUCTURES -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<StructurePkg> GET_MAP = new FeatureGetter.Builder<StructurePkg>(FEATURE_COUNT, StructurePkgImpl::featureIndexStatic).add(StructurePkg.FeatureIDs.STRUCTURES, StructurePkg::structures).build();
    private static final FeatureSetter<StructurePkg> SET_MAP = new FeatureSetter.Builder<StructurePkg>(FEATURE_COUNT, StructurePkgImpl::featureIndexStatic).build();
  }
}
