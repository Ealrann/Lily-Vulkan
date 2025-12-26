package org.sheepy.lily.vulkan.extra.model.rendering.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.StructurePkg;
import org.sheepy.lily.vulkan.extra.model.rendering.Structures;

public final class StructuresImpl extends FeaturedObject<Structures.Features<?>> implements Structures {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<Structures.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<StructurePkg> structurePkgs = newObservableList(Structures.FeatureIDs.STRUCTURE_PKGS, true, true);

  public StructuresImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Structures.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<StructurePkg> structurePkgs() {
    return structurePkgs;
  }

  @Override
  public Group<Structures> lmGroup() {
    return RenderingModelDefinition.Groups.STRUCTURES;
  }

  @Override
  protected FeatureSetter<Structures> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Structures> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Structures.FeatureIDs.STRUCTURE_PKGS -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Structures> GET_MAP = new FeatureGetter.Builder<Structures>(FEATURE_COUNT, StructuresImpl::featureIndexStatic).add(Structures.FeatureIDs.STRUCTURE_PKGS, Structures::structurePkgs).build();
    private static final FeatureSetter<Structures> SET_MAP = new FeatureSetter.Builder<Structures>(FEATURE_COUNT, StructuresImpl::featureIndexStatic).build();
  }
}
