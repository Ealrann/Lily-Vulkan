package org.sheepy.lily.vulkan.extra.model.shape;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure;

public interface GeometricStructure extends MeshStructure<GeometricMesh> {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int MESHES = MeshStructure.FeatureIDs.MESHES;
  }

  interface Features<T extends Features<T>> extends MeshStructure.Features<T> {
    Relation<Mesh, List<Mesh>, Listener<List<Mesh>>, MeshStructure.Features<?>> MESHES = MeshStructure.Features.MESHES;
    List<Feature<?, ?, ?, ?>> ALL = List.of(MESHES);
  }
}
