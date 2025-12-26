package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.core.model.cadence.CadenceModelDefinition;
import org.sheepy.lily.core.model.cadence.ICadenceTask;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.core.model.variable.IModelVariable;
import org.sheepy.lily.core.model.variable.VariableModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.builder.DescriptorPkgBuilder;
import org.sheepy.lily.vulkan.model.vulkan.builder.MouseLocationBuilder;
import org.sheepy.lily.vulkan.model.vulkan.builder.RunProcessBuilder;
import org.sheepy.lily.vulkan.model.vulkan.builder.VulkanEngineBuilder;
import org.sheepy.lily.vulkan.model.vulkan.builder.VulkanResourcePkgBuilder;
import org.sheepy.lily.vulkan.model.vulkan.builder.WaitProcessIdleBuilder;

public interface VulkanModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<IResourceContainer> I_RESOURCE_CONTAINER = new GroupBuilder<IResourceContainer>().name("IResourceContainer").addFeatures(IResourceContainer.Features.ALL).build();
    Group<VulkanEngine> VULKAN_ENGINE = new GroupBuilder<VulkanEngine>().name("VulkanEngine").concrete(true).addInclude(() -> new IncludeBuilder<IEngine>().group(() -> ApplicationModelDefinition.Groups.I_ENGINE).build()).addInclude(() -> new IncludeBuilder<IResourceContainer>().group(() -> I_RESOURCE_CONTAINER).build()).addFeatures(VulkanEngine.Features.ALL).lmBuilder(new BuilderSupplier<>(VulkanEngineBuilder::new)).build();
    Group<VulkanResourcePkg> VULKAN_RESOURCE_PKG = new GroupBuilder<VulkanResourcePkg>().name("VulkanResourcePkg").concrete(true).addFeatures(VulkanResourcePkg.Features.ALL).lmBuilder(new BuilderSupplier<>(VulkanResourcePkgBuilder::new)).build();
    Group<IVulkanResource> I_VULKAN_RESOURCE = new GroupBuilder<IVulkanResource>().name("IVulkanResource").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IVulkanResource.Features.ALL).build();
    Group<IProcess> I_PROCESS = new GroupBuilder<IProcess>().name("IProcess").addInclude(() -> new IncludeBuilder<IResourceContainer>().group(() -> I_RESOURCE_CONTAINER).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IProcess.Features.ALL).build();
    Group<RunProcess> RUN_PROCESS = new GroupBuilder<RunProcess>().name("RunProcess").concrete(true).addInclude(() -> new IncludeBuilder<ICadenceTask>().group(() -> CadenceModelDefinition.Groups.I_CADENCE_TASK).build()).addFeatures(RunProcess.Features.ALL).lmBuilder(new BuilderSupplier<>(RunProcessBuilder::new)).build();
    Group<WaitProcessIdle> WAIT_PROCESS_IDLE = new GroupBuilder<WaitProcessIdle>().name("WaitProcessIdle").concrete(true).addInclude(() -> new IncludeBuilder<ICadenceTask>().group(() -> CadenceModelDefinition.Groups.I_CADENCE_TASK).build()).addFeatures(WaitProcessIdle.Features.ALL).lmBuilder(new BuilderSupplier<>(WaitProcessIdleBuilder::new)).build();
    Group<DescriptorPkg> DESCRIPTOR_PKG = new GroupBuilder<DescriptorPkg>().name("DescriptorPkg").concrete(true).addFeatures(DescriptorPkg.Features.ALL).lmBuilder(new BuilderSupplier<>(DescriptorPkgBuilder::new)).build();
    Group<IDescriptor> I_DESCRIPTOR = new GroupBuilder<IDescriptor>().name("IDescriptor").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IDescriptor.Features.ALL).build();
    Group<MouseLocation> MOUSE_LOCATION = new GroupBuilder<MouseLocation>().name("MouseLocation").concrete(true).addInclude(() -> new IncludeBuilder<IModelVariable>().group(() -> VariableModelDefinition.Groups.I_MODEL_VARIABLE).build()).addFeatures(MouseLocation.Features.ALL).lmBuilder(new BuilderSupplier<>(MouseLocationBuilder::new)).build();
    List<Group<?>> ALL = List.of(I_RESOURCE_CONTAINER, VULKAN_ENGINE, VULKAN_RESOURCE_PKG, I_VULKAN_RESOURCE, I_PROCESS, RUN_PROCESS, WAIT_PROCESS_IDLE, DESCRIPTOR_PKG, I_DESCRIPTOR, MOUSE_LOCATION);
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
