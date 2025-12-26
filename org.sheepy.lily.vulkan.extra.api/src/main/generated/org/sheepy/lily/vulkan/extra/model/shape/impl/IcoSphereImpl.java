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
import org.sheepy.lily.vulkan.extra.model.shape.IcoSphere;
import org.sheepy.lily.vulkan.extra.model.shape.ShapeModelDefinition;

public final class IcoSphereImpl extends FeaturedObject<IcoSphere.Features<?>> implements IcoSphere {
  private static final int FEATURE_COUNT = 2;
  private final ModelNotifier<IcoSphere.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<GeometricMesh> meshes = newObservableList(MeshStructure.FeatureIDs.MESHES, true, true);
  private int subdivisionCount;

  public IcoSphereImpl(final List<GeometricMesh> meshes) {
    this.meshes.addAll(meshes);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<IcoSphere.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<GeometricMesh> meshes() {
    return meshes;
  }

  @Override
  public int subdivisionCount() {
    return subdivisionCount;
  }

  @Override
  public void subdivisionCount(final int subdivisionCount) {
    final var oldValue = this.subdivisionCount;
    this.subdivisionCount = subdivisionCount;
    notifier.notifyInt(IcoSphere.FeatureIDs.SUBDIVISION_COUNT, false, false, oldValue, subdivisionCount);
  }

  @Override
  public Group<IcoSphere> lmGroup() {
    return ShapeModelDefinition.Groups.ICO_SPHERE;
  }

  @Override
  protected FeatureSetter<IcoSphere> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<IcoSphere> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case IcoSphere.FeatureIDs.MESHES -> 0;
      case IcoSphere.FeatureIDs.SUBDIVISION_COUNT -> 1;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<IcoSphere> GET_MAP = new FeatureGetter.Builder<IcoSphere>(FEATURE_COUNT, IcoSphereImpl::featureIndexStatic).add(IcoSphere.FeatureIDs.MESHES, IcoSphere::meshes).add(IcoSphere.FeatureIDs.SUBDIVISION_COUNT, IcoSphere::subdivisionCount).build();
    private static final FeatureSetter<IcoSphere> SET_MAP = new FeatureSetter.Builder<IcoSphere>(FEATURE_COUNT, IcoSphereImpl::featureIndexStatic).add(IcoSphere.FeatureIDs.SUBDIVISION_COUNT, (object, value) -> ((IcoSphereImpl) object).subdivisionCount((int) value)).build();
  }
}
