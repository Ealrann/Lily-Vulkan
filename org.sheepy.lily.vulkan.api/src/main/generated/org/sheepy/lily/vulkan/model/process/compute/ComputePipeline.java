package org.sheepy.lily.vulkan.model.process.compute;

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
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputePipelineBuilder;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public interface ComputePipeline extends VkPipeline, Maintainable<ComputePipeline> {
  static Builder builder() {
    return new ComputePipelineBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Shader shader();
  void shader(final Shader shader);

  interface FeatureIDs {
    int MAINTAINER = Maintainable.FeatureIDs.MAINTAINER;
    int RESOURCE_PKG = IResourceContainer.FeatureIDs.RESOURCE_PKG;
    int DESCRIPTOR_PKG = IResourceContainer.FeatureIDs.DESCRIPTOR_PKG;
    int NAME = Named.FeatureIDs.NAME;
    int ALLOCATE = AbstractPipeline.FeatureIDs.ALLOCATE;
    int RECORD = AbstractPipeline.FeatureIDs.RECORD;
    int EXTENSION_PKG = AbstractPipeline.FeatureIDs.EXTENSION_PKG;
    int TASK_PKGS = TaskPipeline.FeatureIDs.TASK_PKGS;
    int DESCRIPTOR_POOL = VkPipeline.FeatureIDs.DESCRIPTOR_POOL;
    int SPECIALIZATION_DATA = VkPipeline.FeatureIDs.SPECIALIZATION_DATA;
    int PUSH_CONSTANT_RANGES = VkPipeline.FeatureIDs.PUSH_CONSTANT_RANGES;
    int LAYOUT = VkPipeline.FeatureIDs.LAYOUT;
    int SHADER = 1847749726;
  }

  interface Features<T extends Features<T>> extends VkPipeline.Features<T>, Maintainable.Features<T> {
    Relation<Maintainer<?>, Maintainer<?>, Listener<Maintainer<?>>, Maintainable.Features<?>> MAINTAINER = Maintainable.Features.MAINTAINER;
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, IResourceContainer.Features<?>> RESOURCE_PKG = IResourceContainer.Features.RESOURCE_PKG;
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, IResourceContainer.Features<?>> DESCRIPTOR_PKG = IResourceContainer.Features.DESCRIPTOR_PKG;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, AbstractPipeline.Features<?>> ALLOCATE = AbstractPipeline.Features.ALLOCATE;
    Attribute<Boolean, Boolean, BooleanListener, AbstractPipeline.Features<?>> RECORD = AbstractPipeline.Features.RECORD;
    Relation<PipelineExtensionPkg, PipelineExtensionPkg, Listener<PipelineExtensionPkg>, AbstractPipeline.Features<?>> EXTENSION_PKG = AbstractPipeline.Features.EXTENSION_PKG;
    Relation<TaskPkg, List<TaskPkg>, Listener<List<TaskPkg>>, TaskPipeline.Features<?>> TASK_PKGS = TaskPipeline.Features.TASK_PKGS;
    Relation<DescriptorPool, DescriptorPool, Listener<DescriptorPool>, VkPipeline.Features<?>> DESCRIPTOR_POOL = VkPipeline.Features.DESCRIPTOR_POOL;
    Relation<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, VkPipeline.Features<?>> SPECIALIZATION_DATA = VkPipeline.Features.SPECIALIZATION_DATA;
    Relation<PushConstantRange, List<PushConstantRange>, Listener<List<PushConstantRange>>, VkPipeline.Features<?>> PUSH_CONSTANT_RANGES = VkPipeline.Features.PUSH_CONSTANT_RANGES;
    Relation<DescriptorSet, List<DescriptorSet>, Listener<List<DescriptorSet>>, VkPipeline.Features<?>> LAYOUT = VkPipeline.Features.LAYOUT;
    Relation<Shader, Shader, Listener<Shader>, Features<?>> SHADER = new RelationBuilder<Shader, Shader, Listener<Shader>, Features<?>>().name("shader").id(ComputePipeline.FeatureIDs.SHADER).concept(() -> VulkanResourceModelDefinition.Groups.SHADER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MAINTAINER, RESOURCE_PKG, DESCRIPTOR_PKG, NAME, ALLOCATE, RECORD, EXTENSION_PKG, TASK_PKGS, DESCRIPTOR_POOL, SPECIALIZATION_DATA, PUSH_CONSTANT_RANGES, LAYOUT, SHADER);
  }

  interface Builder extends IFeaturedObject.Builder<ComputePipeline> {
    Builder maintainer(Supplier<Maintainer<ComputePipeline>> maintainer);
    Builder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg);
    Builder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg);
    Builder name(String name);
    Builder allocate(boolean allocate);
    Builder record(boolean record);
    Builder extensionPkg(Supplier<PipelineExtensionPkg> extensionPkg);
    Builder addTaskPkg(Supplier<TaskPkg> taskPkg);
    Builder descriptorPool(Supplier<DescriptorPool> descriptorPool);
    Builder specializationData(Supplier<ConstantBuffer> specializationData);
    Builder addPushConstantRange(Supplier<PushConstantRange> pushConstantRange);
    Builder addLayout(Supplier<DescriptorSet> layout);
    Builder shader(Supplier<Shader> shader);
    Builder addTaskPkgs(List<TaskPkg> taskPkgs);
    Builder addPushConstantRanges(List<PushConstantRange> pushConstantRanges);
    Builder addLayout(List<DescriptorSet> layout);
  }
}
