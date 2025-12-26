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
import org.sheepy.lily.vulkan.extra.model.shape.builder.SphereBuilder;

public interface Sphere extends GeometricStructure {
  static Builder builder() {
    return new SphereBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int sliceCount();
  void sliceCount(final int sliceCount);

  interface FeatureIDs {
    int MESHES = MeshStructure.FeatureIDs.MESHES;
    int SLICE_COUNT = 987644445;
  }

  interface Features<T extends Features<T>> extends GeometricStructure.Features<T> {
    Relation<Mesh, List<Mesh>, Listener<List<Mesh>>, MeshStructure.Features<?>> MESHES = MeshStructure.Features.MESHES;
    Attribute<Integer, Integer, IntListener, Features<?>> SLICE_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("sliceCount").defaultValue("12").id(Sphere.FeatureIDs.SLICE_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MESHES, SLICE_COUNT);
  }

  interface Builder extends IFeaturedObject.Builder<Sphere> {
    Builder addMeshe(Supplier<GeometricMesh> meshe);
    Builder sliceCount(int sliceCount);
    Builder addMeshes(List<GeometricMesh> meshes);
  }
}
