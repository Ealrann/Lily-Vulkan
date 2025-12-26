package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.BoundType;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Generic;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.EnumAttributeBuilder;
import org.logoce.lmf.core.lang.builder.EnumBuilder;
import org.logoce.lmf.core.lang.builder.GenericBuilder;
import org.logoce.lmf.core.lang.builder.GenericExtensionBuilder;
import org.logoce.lmf.core.lang.builder.GenericParameterBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.core.model.maintainer.MaintainerModelDefinition;
import org.sheepy.lily.core.model.resource.IRootResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.AxisBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.CameraBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.CameraMatrixBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.CameraPositionBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.CameraScreenWorldPositionBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.CameraVariableBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DataDescriptorBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DataDescriptorsProviderBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DataProviderBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DataProviderPkgBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DescriptorsProviderBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.EntityResolverPipelineBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.IndexedDataDescriptionBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.MousePickConstantsBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.MousePickExtensionBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.PhysicalEntityVariableBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.PresentableEntityBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.RenderProxyConstantBufferBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.RenderableDataSourceBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.ResourceDescriptorProviderPkgBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.SelectionProxyBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.StructurePkgBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.StructuresBuilder;
import org.sheepy.lily.vulkan.model.process.IProcessExtension;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface RenderingModelDefinition {
  interface Generics {
    interface GENERIC_RENDERER {
      Generic<? extends Structure> T = new GenericBuilder<Structure>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> RenderingModelDefinition.Groups.STRUCTURE).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }

    interface DATA_PROVIDER_PKG {
      Generic<? extends Structure> T = new GenericBuilder<Structure>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> RenderingModelDefinition.Groups.STRUCTURE).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }

    interface DATA_PROVIDER {
      Generic<? extends Structure> T = new GenericBuilder<Structure>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> RenderingModelDefinition.Groups.STRUCTURE).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }

    interface INDEXED_DATA_DESCRIPTION {
      Generic<? extends Structure> T = new GenericBuilder<Structure>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> RenderingModelDefinition.Groups.STRUCTURE).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }

    interface RENDERABLE_DATA_SOURCE {
      Generic<? extends Structure> T = new GenericBuilder<Structure>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> RenderingModelDefinition.Groups.STRUCTURE).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }

    interface ENTITY_PKG {
      Generic<? extends Entity> T = new GenericBuilder<Entity>().name("T").extension(() -> new GenericExtensionBuilder().type(() -> RenderingModelDefinition.Groups.ENTITY).boundType(BoundType.Extends).build()).build();
      List<Generic<?>> ALL = List.of(T);
    }
  }

  interface Groups {
    Group<Entity> ENTITY = new GroupBuilder<Entity>().name("Entity").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(Entity.Features.ALL).build();
    Group<PhysicalEntity> PHYSICAL_ENTITY = new GroupBuilder<PhysicalEntity>().name("PhysicalEntity").addInclude(() -> new IncludeBuilder<Entity>().group(() -> ENTITY).build()).addFeatures(PhysicalEntity.Features.ALL).build();
    Group<Axis> AXIS = new GroupBuilder<Axis>().name("Axis").concrete(true).addFeatures(Axis.Features.ALL).lmBuilder(new BuilderSupplier<>(AxisBuilder::new)).build();
    Group<Structure> STRUCTURE = new GroupBuilder<Structure>().name("Structure").addFeatures(Structure.Features.ALL).build();
    Group<Presentation> PRESENTATION = new GroupBuilder<Presentation>().name("Presentation").addFeatures(Presentation.Features.ALL).build();
    Group<StructurePkg> STRUCTURE_PKG = new GroupBuilder<StructurePkg>().name("StructurePkg").concrete(true).addFeatures(StructurePkg.Features.ALL).lmBuilder(new BuilderSupplier<>(StructurePkgBuilder::new)).build();
    Group<Structures> STRUCTURES = new GroupBuilder<Structures>().name("Structures").concrete(true).addFeatures(Structures.Features.ALL).lmBuilder(new BuilderSupplier<>(StructuresBuilder::new)).build();
    Group<PresentableEntity> PRESENTABLE_ENTITY = new GroupBuilder<PresentableEntity>().name("PresentableEntity").concrete(true).addInclude(() -> new IncludeBuilder<PhysicalEntity>().group(() -> PHYSICAL_ENTITY).build()).addFeatures(PresentableEntity.Features.ALL).lmBuilder(new BuilderSupplier<>(PresentableEntityBuilder::new)).build();
    Group<GenericRenderer<?>> GENERIC_RENDERER = new GroupBuilder<GenericRenderer<?>>().name("GenericRenderer").addInclude(() -> new IncludeBuilder<GraphicsPipeline>().group(() -> GraphicModelDefinition.Groups.GRAPHICS_PIPELINE).build()).addInclude(() -> new IncludeBuilder<Maintainer<?>>().group(() -> MaintainerModelDefinition.Groups.MAINTAINER).addParameter(() -> new GenericParameterBuilder().type(() -> GraphicModelDefinition.Groups.GRAPHICS_PIPELINE).build()).build()).addFeatures(GenericRenderer.Features.ALL).addGenerics(Generics.GENERIC_RENDERER.ALL).build();
    Group<DataProviderPkg<?>> DATA_PROVIDER_PKG = new GroupBuilder<DataProviderPkg<?>>().name("DataProviderPkg").concrete(true).addFeatures(DataProviderPkg.Features.ALL).addGenerics(Generics.DATA_PROVIDER_PKG.ALL).lmBuilder(new BuilderSupplier<>(DataProviderPkgBuilder::new)).build();
    Group<DataProvider<?>> DATA_PROVIDER = new GroupBuilder<DataProvider<?>>().name("DataProvider").concrete(true).addFeatures(DataProvider.Features.ALL).addGenerics(Generics.DATA_PROVIDER.ALL).lmBuilder(new BuilderSupplier<>(DataProviderBuilder::new)).build();
    Group<IndexedDataDescription<?>> INDEXED_DATA_DESCRIPTION = new GroupBuilder<IndexedDataDescription<?>>().name("IndexedDataDescription").concrete(true).addInclude(() -> new IncludeBuilder<DataProvider<?>>().group(() -> DATA_PROVIDER).addParameter(() -> new GenericParameterBuilder().type(() -> RenderingModelDefinition.Generics.INDEXED_DATA_DESCRIPTION.T).build()).build()).addFeatures(IndexedDataDescription.Features.ALL).addGenerics(Generics.INDEXED_DATA_DESCRIPTION.ALL).lmBuilder(new BuilderSupplier<>(IndexedDataDescriptionBuilder::new)).build();
    Group<RenderableDataSource<?>> RENDERABLE_DATA_SOURCE = new GroupBuilder<RenderableDataSource<?>>().name("RenderableDataSource").concrete(true).addInclude(() -> new IncludeBuilder<IBufferDataSource>().group(() -> VulkanResourceModelDefinition.Groups.I_BUFFER_DATA_SOURCE).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addInclude(() -> new IncludeBuilder<IVulkanResource>().group(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build()).addFeatures(RenderableDataSource.Features.ALL).addGenerics(Generics.RENDERABLE_DATA_SOURCE.ALL).lmBuilder(new BuilderSupplier<>(RenderableDataSourceBuilder::new)).build();
    Group<ResourceDescriptorProvider> RESOURCE_DESCRIPTOR_PROVIDER = new GroupBuilder<ResourceDescriptorProvider>().name("ResourceDescriptorProvider").addFeatures(ResourceDescriptorProvider.Features.ALL).build();
    Group<DescriptorsProvider> DESCRIPTORS_PROVIDER = new GroupBuilder<DescriptorsProvider>().name("DescriptorsProvider").concrete(true).addInclude(() -> new IncludeBuilder<ResourceDescriptorProvider>().group(() -> RESOURCE_DESCRIPTOR_PROVIDER).build()).addFeatures(DescriptorsProvider.Features.ALL).lmBuilder(new BuilderSupplier<>(DescriptorsProviderBuilder::new)).build();
    Group<DataDescriptorsProvider> DATA_DESCRIPTORS_PROVIDER = new GroupBuilder<DataDescriptorsProvider>().name("DataDescriptorsProvider").concrete(true).addInclude(() -> new IncludeBuilder<ResourceDescriptorProvider>().group(() -> RESOURCE_DESCRIPTOR_PROVIDER).build()).addFeatures(DataDescriptorsProvider.Features.ALL).lmBuilder(new BuilderSupplier<>(DataDescriptorsProviderBuilder::new)).build();
    Group<DataDescriptor> DATA_DESCRIPTOR = new GroupBuilder<DataDescriptor>().name("DataDescriptor").concrete(true).addFeatures(DataDescriptor.Features.ALL).lmBuilder(new BuilderSupplier<>(DataDescriptorBuilder::new)).build();
    Group<ResourceDescriptorProviderPkg> RESOURCE_DESCRIPTOR_PROVIDER_PKG = new GroupBuilder<ResourceDescriptorProviderPkg>().name("ResourceDescriptorProviderPkg").concrete(true).addFeatures(ResourceDescriptorProviderPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(ResourceDescriptorProviderPkgBuilder::new)).build();
    Group<RenderProxyConstantBuffer> RENDER_PROXY_CONSTANT_BUFFER = new GroupBuilder<RenderProxyConstantBuffer>().name("RenderProxyConstantBuffer").concrete(true).addInclude(() -> new IncludeBuilder<ConstantBuffer>().group(() -> VulkanResourceModelDefinition.Groups.CONSTANT_BUFFER).build()).addFeatures(RenderProxyConstantBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(RenderProxyConstantBufferBuilder::new)).build();
    Group<ISpecialization> I_SPECIALIZATION = new GroupBuilder<ISpecialization>().name("ISpecialization").addFeatures(ISpecialization.Features.ALL).build();
    Group<EntityPkg<?>> ENTITY_PKG = new GroupBuilder<EntityPkg<?>>().name("EntityPkg").addFeatures(EntityPkg.Features.ALL).addGenerics(Generics.ENTITY_PKG.ALL).build();
    Group<PhysicalEntityVariable> PHYSICAL_ENTITY_VARIABLE = new GroupBuilder<PhysicalEntityVariable>().name("PhysicalEntityVariable").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build()).addFeatures(PhysicalEntityVariable.Features.ALL).lmBuilder(new BuilderSupplier<>(PhysicalEntityVariableBuilder::new)).build();
    Group<Camera> CAMERA = new GroupBuilder<Camera>().name("Camera").concrete(true).addInclude(() -> new IncludeBuilder<IRootResource>().group(() -> ResourceModelDefinition.Groups.I_ROOT_RESOURCE).build()).addFeatures(Camera.Features.ALL).lmBuilder(new BuilderSupplier<>(CameraBuilder::new)).build();
    Group<CameraMatrix> CAMERA_MATRIX = new GroupBuilder<CameraMatrix>().name("CameraMatrix").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build()).addFeatures(CameraMatrix.Features.ALL).lmBuilder(new BuilderSupplier<>(CameraMatrixBuilder::new)).build();
    Group<CameraPosition> CAMERA_POSITION = new GroupBuilder<CameraPosition>().name("CameraPosition").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build()).addFeatures(CameraPosition.Features.ALL).lmBuilder(new BuilderSupplier<>(CameraPositionBuilder::new)).build();
    Group<CameraScreenWorldPosition> CAMERA_SCREEN_WORLD_POSITION = new GroupBuilder<CameraScreenWorldPosition>().name("CameraScreenWorldPosition").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build()).addFeatures(CameraScreenWorldPosition.Features.ALL).lmBuilder(new BuilderSupplier<>(CameraScreenWorldPositionBuilder::new)).build();
    Group<CameraVariable> CAMERA_VARIABLE = new GroupBuilder<CameraVariable>().name("CameraVariable").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build()).addFeatures(CameraVariable.Features.ALL).lmBuilder(new BuilderSupplier<>(CameraVariableBuilder::new)).build();
    Group<MousePickConstants> MOUSE_PICK_CONSTANTS = new GroupBuilder<MousePickConstants>().name("MousePickConstants").concrete(true).addInclude(() -> new IncludeBuilder<ConstantBuffer>().group(() -> VulkanResourceModelDefinition.Groups.CONSTANT_BUFFER).build()).addFeatures(MousePickConstants.Features.ALL).lmBuilder(new BuilderSupplier<>(MousePickConstantsBuilder::new)).build();
    Group<MousePickExtension> MOUSE_PICK_EXTENSION = new GroupBuilder<MousePickExtension>().name("MousePickExtension").concrete(true).addInclude(() -> new IncludeBuilder<IProcessExtension>().group(() -> ProcessModelDefinition.Groups.I_PROCESS_EXTENSION).build()).addFeatures(MousePickExtension.Features.ALL).lmBuilder(new BuilderSupplier<>(MousePickExtensionBuilder::new)).build();
    Group<EntityResolverPipeline> ENTITY_RESOLVER_PIPELINE = new GroupBuilder<EntityResolverPipeline>().name("EntityResolverPipeline").concrete(true).addFeatures(EntityResolverPipeline.Features.ALL).lmBuilder(new BuilderSupplier<>(EntityResolverPipelineBuilder::new)).build();
    Group<IEntityResolver> I_ENTITY_RESOLVER = new GroupBuilder<IEntityResolver>().name("IEntityResolver").addFeatures(IEntityResolver.Features.ALL).build();
    Group<IEntitySelection> I_ENTITY_SELECTION = new GroupBuilder<IEntitySelection>().name("IEntitySelection").addFeatures(IEntitySelection.Features.ALL).build();
    Group<SelectionProxy> SELECTION_PROXY = new GroupBuilder<SelectionProxy>().name("SelectionProxy").concrete(true).addFeatures(SelectionProxy.Features.ALL).lmBuilder(new BuilderSupplier<>(SelectionProxyBuilder::new)).build();
    List<Group<?>> ALL = List.of(ENTITY, PHYSICAL_ENTITY, AXIS, STRUCTURE, PRESENTATION, STRUCTURE_PKG, STRUCTURES, PRESENTABLE_ENTITY, GENERIC_RENDERER, DATA_PROVIDER_PKG, DATA_PROVIDER, INDEXED_DATA_DESCRIPTION, RENDERABLE_DATA_SOURCE, RESOURCE_DESCRIPTOR_PROVIDER, DESCRIPTORS_PROVIDER, DATA_DESCRIPTORS_PROVIDER, DATA_DESCRIPTOR, RESOURCE_DESCRIPTOR_PROVIDER_PKG, RENDER_PROXY_CONSTANT_BUFFER, I_SPECIALIZATION, ENTITY_PKG, PHYSICAL_ENTITY_VARIABLE, CAMERA, CAMERA_MATRIX, CAMERA_POSITION, CAMERA_SCREEN_WORLD_POSITION, CAMERA_VARIABLE, MOUSE_PICK_CONSTANTS, MOUSE_PICK_EXTENSION, ENTITY_RESOLVER_PIPELINE, I_ENTITY_RESOLVER, I_ENTITY_SELECTION, SELECTION_PROXY);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    Enum<EPhysicalEntityFeature> E_PHYSICAL_ENTITY_FEATURE = new EnumBuilder<EPhysicalEntityFeature>().name("EPhysicalEntityFeature").addLiterals(List.of("Location", "0")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    Enum<ECameraField> E_CAMERA_FIELD = new EnumBuilder<ECameraField>().name("ECameraField").addLiterals(List.of("ZNear", "0", "ZFar", "1", "FieldOfViewX", "2", "FieldOfViewY", "3")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    Enum<EMousePickMode> E_MOUSE_PICK_MODE = new EnumBuilder<EMousePickMode>().name("EMousePickMode").addLiterals(List.of("Enabled", "0", "Lock", "1", "Disabled", "2")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    List<Enum<?>> ALL = List.of(E_PHYSICAL_ENTITY_FEATURE, E_CAMERA_FIELD, E_MOUSE_PICK_MODE);
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    List<JavaWrapper<?>> ALL = List.of();
  }
}
