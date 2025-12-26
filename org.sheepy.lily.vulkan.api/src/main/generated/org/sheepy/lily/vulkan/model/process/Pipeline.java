package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.builder.PipelineBuilder;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;

public interface Pipeline extends TaskPipeline {
  static Builder builder() {
    return new PipelineBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int RESOURCE_PKG = IResourceContainer.FeatureIDs.RESOURCE_PKG;
    int DESCRIPTOR_PKG = IResourceContainer.FeatureIDs.DESCRIPTOR_PKG;
    int NAME = Named.FeatureIDs.NAME;
    int ALLOCATE = AbstractPipeline.FeatureIDs.ALLOCATE;
    int RECORD = AbstractPipeline.FeatureIDs.RECORD;
    int EXTENSION_PKG = AbstractPipeline.FeatureIDs.EXTENSION_PKG;
    int TASK_PKGS = TaskPipeline.FeatureIDs.TASK_PKGS;
  }

  interface Features<T extends Features<T>> extends TaskPipeline.Features<T> {
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, IResourceContainer.Features<?>> RESOURCE_PKG = IResourceContainer.Features.RESOURCE_PKG;
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, IResourceContainer.Features<?>> DESCRIPTOR_PKG = IResourceContainer.Features.DESCRIPTOR_PKG;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, AbstractPipeline.Features<?>> ALLOCATE = AbstractPipeline.Features.ALLOCATE;
    Attribute<Boolean, Boolean, BooleanListener, AbstractPipeline.Features<?>> RECORD = AbstractPipeline.Features.RECORD;
    Relation<PipelineExtensionPkg, PipelineExtensionPkg, Listener<PipelineExtensionPkg>, AbstractPipeline.Features<?>> EXTENSION_PKG = AbstractPipeline.Features.EXTENSION_PKG;
    Relation<TaskPkg, List<TaskPkg>, Listener<List<TaskPkg>>, TaskPipeline.Features<?>> TASK_PKGS = TaskPipeline.Features.TASK_PKGS;
    List<Feature<?, ?, ?, ?>> ALL = List.of(RESOURCE_PKG, DESCRIPTOR_PKG, NAME, ALLOCATE, RECORD, EXTENSION_PKG, TASK_PKGS);
  }

  interface Builder extends IFeaturedObject.Builder<Pipeline> {
    Builder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg);
    Builder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg);
    Builder name(String name);
    Builder allocate(boolean allocate);
    Builder record(boolean record);
    Builder extensionPkg(Supplier<PipelineExtensionPkg> extensionPkg);
    Builder addTaskPkg(Supplier<TaskPkg> taskPkg);
    Builder addTaskPkgs(List<TaskPkg> taskPkgs);
  }
}
