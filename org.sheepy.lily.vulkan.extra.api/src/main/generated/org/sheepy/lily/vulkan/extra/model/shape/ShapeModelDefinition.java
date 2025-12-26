package org.sheepy.lily.vulkan.extra.model.shape;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.vulkan.extra.model.mesh.Mesh;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshModelDefinition;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshStructure;
import org.sheepy.lily.vulkan.extra.model.shape.builder.GeometricMeshBuilder;
import org.sheepy.lily.vulkan.extra.model.shape.builder.IcoSphereBuilder;
import org.sheepy.lily.vulkan.extra.model.shape.builder.IcosahedronBuilder;
import org.sheepy.lily.vulkan.extra.model.shape.builder.SphereBuilder;

public interface ShapeModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<GeometricStructure> GEOMETRIC_STRUCTURE = new GroupBuilder<GeometricStructure>().name("GeometricStructure").addInclude(() -> new IncludeBuilder<MeshStructure<?>>().group(() -> MeshModelDefinition.Groups.MESH_STRUCTURE).addParameter(() -> new GenericParameterBuilder().type(() -> ShapeModelDefinition.Groups.GEOMETRIC_MESH).build()).build()).addFeatures(GeometricStructure.Features.ALL).build();
    Group<GeometricMesh> GEOMETRIC_MESH = new GroupBuilder<GeometricMesh>().name("GeometricMesh").concrete(true).addInclude(() -> new IncludeBuilder<Mesh>().group(() -> MeshModelDefinition.Groups.MESH).build()).addFeatures(GeometricMesh.Features.ALL).lmBuilder(new BuilderSupplier<>(GeometricMeshBuilder::new)).build();
    Group<Icosahedron> ICOSAHEDRON = new GroupBuilder<Icosahedron>().name("Icosahedron").concrete(true).addInclude(() -> new IncludeBuilder<GeometricStructure>().group(() -> GEOMETRIC_STRUCTURE).build()).addFeatures(Icosahedron.Features.ALL).lmBuilder(new BuilderSupplier<>(IcosahedronBuilder::new)).build();
    Group<Sphere> SPHERE = new GroupBuilder<Sphere>().name("Sphere").concrete(true).addInclude(() -> new IncludeBuilder<GeometricStructure>().group(() -> GEOMETRIC_STRUCTURE).build()).addFeatures(Sphere.Features.ALL).lmBuilder(new BuilderSupplier<>(SphereBuilder::new)).build();
    Group<IcoSphere> ICO_SPHERE = new GroupBuilder<IcoSphere>().name("IcoSphere").concrete(true).addInclude(() -> new IncludeBuilder<GeometricStructure>().group(() -> GEOMETRIC_STRUCTURE).build()).addFeatures(IcoSphere.Features.ALL).lmBuilder(new BuilderSupplier<>(IcoSphereBuilder::new)).build();
    List<Group<?>> ALL = List.of(GEOMETRIC_STRUCTURE, GEOMETRIC_MESH, ICOSAHEDRON, SPHERE, ICO_SPHERE);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    List<Enum<?>> ALL = List.of();
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
