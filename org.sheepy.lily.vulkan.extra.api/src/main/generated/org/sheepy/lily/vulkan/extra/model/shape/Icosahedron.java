package org.sheepy.lily.vulkan.extra.model.shape;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure;
import org.sheepy.lily.vulkan.extra.model.shape.builder.IcosahedronBuilder;

public interface Icosahedron extends GeometricStructure {
  static Builder builder() {
    return new IcosahedronBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int MESHES = MeshStructure.FeatureIDs.MESHES;
  }

  interface Features<T extends Features<T>> extends GeometricStructure.Features<T> {
    Relation<Mesh, List<Mesh>, Listener<List<Mesh>>, MeshStructure.Features<?>> MESHES = MeshStructure.Features.MESHES;
    List<Feature<?, ?, ?, ?>> ALL = List.of(MESHES);
  }

  interface Builder extends IFeaturedObject.Builder<Icosahedron> {
    Builder addMeshe(Supplier<GeometricMesh> meshe);
    Builder addMeshes(List<GeometricMesh> meshes);
  }
}
