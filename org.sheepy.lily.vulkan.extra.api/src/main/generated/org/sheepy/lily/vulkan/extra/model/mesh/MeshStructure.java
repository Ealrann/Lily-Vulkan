package org.sheepy.lily.vulkan.extra.model.mesh;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;

public interface MeshStructure<T extends Mesh> extends IMeshStructure {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<T> meshes();

  interface FeatureIDs {
    int MESHES = -2138454712;
  }

  interface Features<T extends Features<T>> extends IMeshStructure.Features<T> {
    Relation<Mesh, List<Mesh>, Listener<List<Mesh>>, Features<?>> MESHES = new RelationBuilder<Mesh, List<Mesh>, Listener<List<Mesh>>, Features<?>>().name("meshes").many(true).mandatory(true).contains(true).id(MeshStructure.FeatureIDs.MESHES).concept(() -> MeshModelDefinition.Groups.MESH).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MESHES);
  }
}
