package org.sheepy.lily.vulkan.extra.model.mesh;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.BoundType;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Generic;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GenericBuilder;
import org.logoce.lmf.core.lang.builder.GenericExtensionBuilder;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.vulkan.extra.model.mesh.builder.MeshRendererBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.Presentation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderingModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;

public interface MeshModelDefinition {
  interface Generics {
    interface MESH_STRUCTURE {
      Generic<? extends Mesh> T = new GenericBuilder<Mesh>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> MeshModelDefinition.Groups.MESH).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }
  }

  interface Groups {
    Group<Mesh> MESH = new GroupBuilder<Mesh>().name("Mesh").addInclude(() -> new IncludeBuilder<Presentation>().group(() -> RenderingModelDefinition.Groups.PRESENTATION).build()).addFeatures(Mesh.Features.ALL).build();
    Group<MeshRenderer> MESH_RENDERER = new GroupBuilder<MeshRenderer>().name("MeshRenderer").concrete(true).addInclude(() -> new IncludeBuilder<GenericRenderer<?>>().group(() -> RenderingModelDefinition.Groups.GENERIC_RENDERER).addParameter(() -> new GenericParameterBuilder().type(() -> MeshModelDefinition.Groups.I_MESH_STRUCTURE).build()).build()).addFeatures(MeshRenderer.Features.ALL).lmBuilder(new BuilderSupplier<>(MeshRendererBuilder::new)).build();
    Group<IMeshStructure> I_MESH_STRUCTURE = new GroupBuilder<IMeshStructure>().name("IMeshStructure").addInclude(() -> new IncludeBuilder<Structure>().group(() -> RenderingModelDefinition.Groups.STRUCTURE).build()).addFeatures(IMeshStructure.Features.ALL).build();
    Group<MeshStructure<?>> MESH_STRUCTURE = new GroupBuilder<MeshStructure<?>>().name("MeshStructure").addInclude(() -> new IncludeBuilder<IMeshStructure>().group(() -> I_MESH_STRUCTURE).build()).addFeatures(MeshStructure.Features.ALL).addGenerics(Generics.MESH_STRUCTURE.ALL).build();
    List<Group<?>> ALL = List.of(MESH, MESH_RENDERER, I_MESH_STRUCTURE, MESH_STRUCTURE);
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
