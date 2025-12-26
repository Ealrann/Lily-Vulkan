package org.sheepy.lily.vulkan.extra.model.shape.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.rendering.PresentableEntity;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.shape.ShapeModelDefinition;

public final class GeometricMeshImpl extends FeaturedObject<GeometricMesh.Features<?>> implements GeometricMesh {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<GeometricMesh.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<PresentableEntity> presentedEntities = newObservableList(Presentation.FeatureIDs.PRESENTED_ENTITIES, true, false);

  public GeometricMeshImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GeometricMesh.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<PresentableEntity> presentedEntities() {
    return presentedEntities;
  }

  @Override
  public Group<GeometricMesh> lmGroup() {
    return ShapeModelDefinition.Groups.GEOMETRIC_MESH;
  }

  @Override
  protected FeatureSetter<GeometricMesh> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GeometricMesh> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GeometricMesh.FeatureIDs.PRESENTED_ENTITIES -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GeometricMesh> GET_MAP = new FeatureGetter.Builder<GeometricMesh>(FEATURE_COUNT, GeometricMeshImpl::featureIndexStatic).add(GeometricMesh.FeatureIDs.PRESENTED_ENTITIES, GeometricMesh::presentedEntities).build();
    private static final FeatureSetter<GeometricMesh> SET_MAP = new FeatureSetter.Builder<GeometricMesh>(FEATURE_COUNT, GeometricMeshImpl::featureIndexStatic).build();
  }
}
