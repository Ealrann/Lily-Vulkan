package org.sheepy.lily.vulkan.extra.model.mesh;

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
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.extra.model.mesh.builder.MeshRendererBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public interface MeshRenderer extends GenericRenderer<IMeshStructure> {
  static Builder builder() {
    return new MeshRendererBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int MAINTAINED = Maintainer.FeatureIDs.MAINTAINED;
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
    int SHADERS = GraphicsPipeline.FeatureIDs.SHADERS;
    int VIEWPORT_STATE = GraphicsPipeline.FeatureIDs.VIEWPORT_STATE;
    int INPUT_ASSEMBLY = GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY;
    int RASTERIZER = GraphicsPipeline.FeatureIDs.RASTERIZER;
    int COLOR_BLEND = GraphicsPipeline.FeatureIDs.COLOR_BLEND;
    int DYNAMIC_STATE = GraphicsPipeline.FeatureIDs.DYNAMIC_STATE;
    int VERTEX_INPUT_STATE = GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE;
    int DEPTH_STENCIL_STATE = GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE;
    int DATA_PROVIDER_PKG = GenericRenderer.FeatureIDs.DATA_PROVIDER_PKG;
    int RENDERED_STRUCTURES = GenericRenderer.FeatureIDs.RENDERED_STRUCTURES;
    int CONSTANT_BUFFER = GenericRenderer.FeatureIDs.CONSTANT_BUFFER;
    int TRANSFER_BUFFER = GenericRenderer.FeatureIDs.TRANSFER_BUFFER;
    int DESCRIPTOR_PROVIDER_PKG = GenericRenderer.FeatureIDs.DESCRIPTOR_PROVIDER_PKG;
    int SPECIALIZATION = GenericRenderer.FeatureIDs.SPECIALIZATION;
    int FLUSH_TRANSFER_BUFFER_TASK = GenericRenderer.FeatureIDs.FLUSH_TRANSFER_BUFFER_TASK;
    int ONE_PIPELINE_PER_PART = GenericRenderer.FeatureIDs.ONE_PIPELINE_PER_PART;
    int MAINTAINING = GenericRenderer.FeatureIDs.MAINTAINING;
  }

  interface Features<T extends Features<T>> extends GenericRenderer.Features<T> {
    Relation<Maintainable<?>, List<Maintainable<?>>, Listener<List<Maintainable<?>>>, Maintainer.Features<?>> MAINTAINED = Maintainer.Features.MAINTAINED;
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
    Relation<Shader, List<Shader>, Listener<List<Shader>>, GraphicsPipeline.Features<?>> SHADERS = GraphicsPipeline.Features.SHADERS;
    Relation<ViewportState, ViewportState, Listener<ViewportState>, GraphicsPipeline.Features<?>> VIEWPORT_STATE = GraphicsPipeline.Features.VIEWPORT_STATE;
    Relation<InputAssembly, InputAssembly, Listener<InputAssembly>, GraphicsPipeline.Features<?>> INPUT_ASSEMBLY = GraphicsPipeline.Features.INPUT_ASSEMBLY;
    Relation<Rasterizer, Rasterizer, Listener<Rasterizer>, GraphicsPipeline.Features<?>> RASTERIZER = GraphicsPipeline.Features.RASTERIZER;
    Relation<ColorBlend, ColorBlend, Listener<ColorBlend>, GraphicsPipeline.Features<?>> COLOR_BLEND = GraphicsPipeline.Features.COLOR_BLEND;
    Relation<DynamicState, DynamicState, Listener<DynamicState>, GraphicsPipeline.Features<?>> DYNAMIC_STATE = GraphicsPipeline.Features.DYNAMIC_STATE;
    Relation<VertexInputState, VertexInputState, Listener<VertexInputState>, GraphicsPipeline.Features<?>> VERTEX_INPUT_STATE = GraphicsPipeline.Features.VERTEX_INPUT_STATE;
    Relation<DepthStencilState, DepthStencilState, Listener<DepthStencilState>, GraphicsPipeline.Features<?>> DEPTH_STENCIL_STATE = GraphicsPipeline.Features.DEPTH_STENCIL_STATE;
    Relation<DataProviderPkg<?>, DataProviderPkg<?>, Listener<DataProviderPkg<?>>, GenericRenderer.Features<?>> DATA_PROVIDER_PKG = GenericRenderer.Features.DATA_PROVIDER_PKG;
    Relation<Structure, List<Structure>, Listener<List<Structure>>, GenericRenderer.Features<?>> RENDERED_STRUCTURES = GenericRenderer.Features.RENDERED_STRUCTURES;
    Relation<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, GenericRenderer.Features<?>> CONSTANT_BUFFER = GenericRenderer.Features.CONSTANT_BUFFER;
    Relation<TransferBuffer, TransferBuffer, Listener<TransferBuffer>, GenericRenderer.Features<?>> TRANSFER_BUFFER = GenericRenderer.Features.TRANSFER_BUFFER;
    Relation<ResourceDescriptorProviderPkg, ResourceDescriptorProviderPkg, Listener<ResourceDescriptorProviderPkg>, GenericRenderer.Features<?>> DESCRIPTOR_PROVIDER_PKG = GenericRenderer.Features.DESCRIPTOR_PROVIDER_PKG;
    Relation<ISpecialization, ISpecialization, Listener<ISpecialization>, GenericRenderer.Features<?>> SPECIALIZATION = GenericRenderer.Features.SPECIALIZATION;
    Relation<FlushTransferBufferTask, FlushTransferBufferTask, Listener<FlushTransferBufferTask>, GenericRenderer.Features<?>> FLUSH_TRANSFER_BUFFER_TASK = GenericRenderer.Features.FLUSH_TRANSFER_BUFFER_TASK;
    Attribute<Boolean, Boolean, BooleanListener, GenericRenderer.Features<?>> ONE_PIPELINE_PER_PART = GenericRenderer.Features.ONE_PIPELINE_PER_PART;
    Attribute<Boolean, Boolean, BooleanListener, GenericRenderer.Features<?>> MAINTAINING = GenericRenderer.Features.MAINTAINING;
    List<Feature<?, ?, ?, ?>> ALL = List.of(MAINTAINED, MAINTAINER, RESOURCE_PKG, DESCRIPTOR_PKG, NAME, ALLOCATE, RECORD, EXTENSION_PKG, TASK_PKGS, DESCRIPTOR_POOL, SPECIALIZATION_DATA, PUSH_CONSTANT_RANGES, LAYOUT, SHADERS, VIEWPORT_STATE, INPUT_ASSEMBLY, RASTERIZER, COLOR_BLEND, DYNAMIC_STATE, VERTEX_INPUT_STATE, DEPTH_STENCIL_STATE, DATA_PROVIDER_PKG, RENDERED_STRUCTURES, CONSTANT_BUFFER, TRANSFER_BUFFER, DESCRIPTOR_PROVIDER_PKG, SPECIALIZATION, FLUSH_TRANSFER_BUFFER_TASK, ONE_PIPELINE_PER_PART, MAINTAINING);
  }

  interface Builder extends IFeaturedObject.Builder<MeshRenderer> {
    Builder addMaintained(Supplier<Maintainable<GraphicsPipeline>> maintained);
    Builder maintainer(Supplier<Maintainer<GraphicsPipeline>> maintainer);
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
    Builder addShader(Supplier<Shader> shader);
    Builder viewportState(Supplier<ViewportState> viewportState);
    Builder inputAssembly(Supplier<InputAssembly> inputAssembly);
    Builder rasterizer(Supplier<Rasterizer> rasterizer);
    Builder colorBlend(Supplier<ColorBlend> colorBlend);
    Builder dynamicState(Supplier<DynamicState> dynamicState);
    Builder vertexInputState(Supplier<VertexInputState> vertexInputState);
    Builder depthStencilState(Supplier<DepthStencilState> depthStencilState);
    Builder dataProviderPkg(Supplier<DataProviderPkg<IMeshStructure>> dataProviderPkg);
    Builder addRenderedStructure(Supplier<IMeshStructure> renderedStructure);
    Builder constantBuffer(Supplier<ConstantBuffer> constantBuffer);
    Builder transferBuffer(Supplier<TransferBuffer> transferBuffer);
    Builder descriptorProviderPkg(Supplier<ResourceDescriptorProviderPkg> descriptorProviderPkg);
    Builder specialization(Supplier<ISpecialization> specialization);
    Builder flushTransferBufferTask(Supplier<FlushTransferBufferTask> flushTransferBufferTask);
    Builder onePipelinePerPart(boolean onePipelinePerPart);
    Builder maintaining(boolean maintaining);
    Builder addMaintained(List<Maintainable<?>> maintained);
    Builder addTaskPkgs(List<TaskPkg> taskPkgs);
    Builder addPushConstantRanges(List<PushConstantRange> pushConstantRanges);
    Builder addLayout(List<DescriptorSet> layout);
    Builder addShaders(List<Shader> shaders);
    Builder addRenderedStructures(List<IMeshStructure> renderedStructures);
  }
}
