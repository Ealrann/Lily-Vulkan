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
import org.sheepy.lily.vulkan.extra.model.shape.ShapeModelDefinition;
import org.sheepy.lily.vulkan.extra.model.shape.Sphere;

public final class SphereImpl extends FeaturedObject<Sphere.Features<?>> implements Sphere {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<Sphere.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<GeometricMesh> meshes = newObservableList(MeshStructure.FeatureIDs.MESHES, true, true);
  private int sliceCount;

  public SphereImpl(final List<GeometricMesh> meshes) {
    this.meshes.addAll(meshes);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Sphere.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<GeometricMesh> meshes() {
    return meshes;
  }

  @Override
  public int sliceCount() {
    return sliceCount;
  }

  @Override
  public void sliceCount(final int sliceCount) {
    final var oldValue = this.sliceCount;
    this.sliceCount = sliceCount;
    notifier.notifyInt(Sphere.FeatureIDs.SLICE_COUNT, false, false, oldValue, sliceCount);
  }

  @Override
  public Group<Sphere> lmGroup() {
    return ShapeModelDefinition.Groups.SPHERE;
  }

  @Override
  protected FeatureSetter<Sphere> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Sphere> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Sphere.FeatureIDs.MESHES -> 0;
      case Sphere.FeatureIDs.SLICE_COUNT -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Sphere> GET_MAP = new FeatureGetter.Builder<Sphere>(FEATURE_COUNT, SphereImpl::featureIndexStatic).add(Sphere.FeatureIDs.MESHES, Sphere::meshes).add(Sphere.FeatureIDs.SLICE_COUNT, Sphere::sliceCount).build();
    private static final FeatureSetter<Sphere> SET_MAP = new FeatureSetter.Builder<Sphere>(FEATURE_COUNT, SphereImpl::featureIndexStatic).add(Sphere.FeatureIDs.SLICE_COUNT, (object, value) -> ((SphereImpl) object).sliceCount((int) value)).build();
  }
}
