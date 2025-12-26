package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.pipeline.PipelineModelDefinition;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public interface VkPipeline extends TaskPipeline {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  DescriptorPool descriptorPool();
  ConstantBuffer specializationData();
  List<PushConstantRange> pushConstantRanges();
  List<DescriptorSet> layout();
  void descriptorPool(final DescriptorPool descriptorPool);
  void specializationData(final ConstantBuffer specializationData);

  interface FeatureIDs {
    int RESOURCE_PKG = IResourceContainer.FeatureIDs.RESOURCE_PKG;
    int DESCRIPTOR_PKG = IResourceContainer.FeatureIDs.DESCRIPTOR_PKG;
    int NAME = Named.FeatureIDs.NAME;
    int ALLOCATE = AbstractPipeline.FeatureIDs.ALLOCATE;
    int RECORD = AbstractPipeline.FeatureIDs.RECORD;
    int EXTENSION_PKG = AbstractPipeline.FeatureIDs.EXTENSION_PKG;
    int TASK_PKGS = TaskPipeline.FeatureIDs.TASK_PKGS;
    int DESCRIPTOR_POOL = 2096882349;
    int SPECIALIZATION_DATA = -1019291305;
    int PUSH_CONSTANT_RANGES = 1869789910;
    int LAYOUT = 172289964;
  }

  interface Features<T extends Features<T>> extends TaskPipeline.Features<T> {
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, IResourceContainer.Features<?>> RESOURCE_PKG = IResourceContainer.Features.RESOURCE_PKG;
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, IResourceContainer.Features<?>> DESCRIPTOR_PKG = IResourceContainer.Features.DESCRIPTOR_PKG;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, AbstractPipeline.Features<?>> ALLOCATE = AbstractPipeline.Features.ALLOCATE;
    Attribute<Boolean, Boolean, BooleanListener, AbstractPipeline.Features<?>> RECORD = AbstractPipeline.Features.RECORD;
    Relation<PipelineExtensionPkg, PipelineExtensionPkg, Listener<PipelineExtensionPkg>, AbstractPipeline.Features<?>> EXTENSION_PKG = AbstractPipeline.Features.EXTENSION_PKG;
    Relation<TaskPkg, List<TaskPkg>, Listener<List<TaskPkg>>, TaskPipeline.Features<?>> TASK_PKGS = TaskPipeline.Features.TASK_PKGS;
    Relation<DescriptorPool, DescriptorPool, Listener<DescriptorPool>, Features<?>> DESCRIPTOR_POOL = new RelationBuilder<DescriptorPool, DescriptorPool, Listener<DescriptorPool>, Features<?>>().name("descriptorPool").contains(true).id(VkPipeline.FeatureIDs.DESCRIPTOR_POOL).concept(() -> VulkanResourceModelDefinition.Groups.DESCRIPTOR_POOL).build();
    Relation<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, Features<?>> SPECIALIZATION_DATA = new RelationBuilder<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, Features<?>>().name("specializationData").id(VkPipeline.FeatureIDs.SPECIALIZATION_DATA).concept(() -> VulkanResourceModelDefinition.Groups.CONSTANT_BUFFER).build();
    Relation<PushConstantRange, List<PushConstantRange>, Listener<List<PushConstantRange>>, Features<?>> PUSH_CONSTANT_RANGES = new RelationBuilder<PushConstantRange, List<PushConstantRange>, Listener<List<PushConstantRange>>, Features<?>>().name("pushConstantRanges").many(true).contains(true).id(VkPipeline.FeatureIDs.PUSH_CONSTANT_RANGES).concept(() -> PipelineModelDefinition.Groups.PUSH_CONSTANT_RANGE).build();
    Relation<DescriptorSet, List<DescriptorSet>, Listener<List<DescriptorSet>>, Features<?>> LAYOUT = new RelationBuilder<DescriptorSet, List<DescriptorSet>, Listener<List<DescriptorSet>>, Features<?>>().name("layout").many(true).id(VkPipeline.FeatureIDs.LAYOUT).concept(() -> VulkanResourceModelDefinition.Groups.DESCRIPTOR_SET).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(RESOURCE_PKG, DESCRIPTOR_PKG, NAME, ALLOCATE, RECORD, EXTENSION_PKG, TASK_PKGS, DESCRIPTOR_POOL, SPECIALIZATION_DATA, PUSH_CONSTANT_RANGES, LAYOUT);
  }
}
