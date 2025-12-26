package org.sheepy.lily.vulkan.extra.model.shape;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure;
import org.sheepy.lily.vulkan.extra.model.shape.builder.IcoSphereBuilder;

public interface IcoSphere extends GeometricStructure {
  static Builder builder() {
    return new IcoSphereBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int subdivisionCount();
  void subdivisionCount(final int subdivisionCount);

  interface FeatureIDs {
    int MESHES = MeshStructure.FeatureIDs.MESHES;
    int SUBDIVISION_COUNT = 609282951;
  }

  interface Features<T extends Features<T>> extends GeometricStructure.Features<T> {
    Relation<Mesh, List<Mesh>, Listener<List<Mesh>>, MeshStructure.Features<?>> MESHES = MeshStructure.Features.MESHES;
    Attribute<Integer, Integer, IntListener, Features<?>> SUBDIVISION_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("subdivisionCount").defaultValue("2").id(IcoSphere.FeatureIDs.SUBDIVISION_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MESHES, SUBDIVISION_COUNT);
  }

  interface Builder extends IFeaturedObject.Builder<IcoSphere> {
    Builder addMeshe(Supplier<GeometricMesh> meshe);
    Builder subdivisionCount(int subdivisionCount);
    Builder addMeshes(List<GeometricMesh> meshes);
  }
}
