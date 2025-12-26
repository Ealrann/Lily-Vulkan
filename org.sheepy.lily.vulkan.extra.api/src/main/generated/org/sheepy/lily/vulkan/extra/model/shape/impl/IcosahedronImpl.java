package org.sheepy.lily.vulkan.extra.model.shape.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure;
import org.sheepy.lily.vulkan.extra.model.shape.GeometricMesh;
import org.sheepy.lily.vulkan.extra.model.shape.Icosahedron;
import org.sheepy.lily.vulkan.extra.model.shape.ShapeModelDefinition;

public final class IcosahedronImpl extends FeaturedObject<Icosahedron.Features<?>> implements Icosahedron {
  private static final int FEATURE_COUNT = 1;
  private final ModelNotifier<Icosahedron.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<GeometricMesh> meshes = newObservableList(MeshStructure.FeatureIDs.MESHES, true, true);

  public IcosahedronImpl(final List<GeometricMesh> meshes) {
    this.meshes.addAll(meshes);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Icosahedron.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<GeometricMesh> meshes() {
    return meshes;
  }

  @Override
  public Group<Icosahedron> lmGroup() {
    return ShapeModelDefinition.Groups.ICOSAHEDRON;
  }

  @Override
  protected FeatureSetter<Icosahedron> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Icosahedron> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Icosahedron.FeatureIDs.MESHES -> 0;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Icosahedron> GET_MAP = new FeatureGetter.Builder<Icosahedron>(FEATURE_COUNT, IcosahedronImpl::featureIndexStatic).add(Icosahedron.FeatureIDs.MESHES, Icosahedron::meshes).build();
    private static final FeatureSetter<Icosahedron> SET_MAP = new FeatureSetter.Builder<Icosahedron>(FEATURE_COUNT, IcosahedronImpl::featureIndexStatic).build();
  }
}
