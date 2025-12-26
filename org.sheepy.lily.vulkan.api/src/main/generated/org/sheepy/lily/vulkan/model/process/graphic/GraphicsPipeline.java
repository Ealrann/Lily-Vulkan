package org.sheepy.lily.vulkan.model.process.graphic;

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
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicsPipelineBuilder;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public interface GraphicsPipeline extends VkPipeline, Maintainable<GraphicsPipeline> {
  static Builder builder() {
    return new GraphicsPipelineBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<Shader> shaders();
  ViewportState viewportState();
  InputAssembly inputAssembly();
  Rasterizer rasterizer();
  ColorBlend colorBlend();
  DynamicState dynamicState();
  VertexInputState vertexInputState();
  DepthStencilState depthStencilState();
  void viewportState(final ViewportState viewportState);
  void inputAssembly(final InputAssembly inputAssembly);
  void rasterizer(final Rasterizer rasterizer);
  void colorBlend(final ColorBlend colorBlend);
  void dynamicState(final DynamicState dynamicState);
  void vertexInputState(final VertexInputState vertexInputState);
  void depthStencilState(final DepthStencilState depthStencilState);

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
    int SHADERS = 111131464;
    int VIEWPORT_STATE = 1724517925;
    int INPUT_ASSEMBLY = -928822678;
    int RASTERIZER = 1882246209;
    int COLOR_BLEND = 1871020628;
    int DYNAMIC_STATE = 1090145720;
    int VERTEX_INPUT_STATE = 1590076113;
    int DEPTH_STENCIL_STATE = -1582011342;
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
    Relation<Shader, List<Shader>, Listener<List<Shader>>, Features<?>> SHADERS = new RelationBuilder<Shader, List<Shader>, Listener<List<Shader>>, Features<?>>().name("shaders").many(true).mandatory(true).id(GraphicsPipeline.FeatureIDs.SHADERS).concept(() -> VulkanResourceModelDefinition.Groups.SHADER).build();
    Relation<ViewportState, ViewportState, Listener<ViewportState>, Features<?>> VIEWPORT_STATE = new RelationBuilder<ViewportState, ViewportState, Listener<ViewportState>, Features<?>>().name("viewportState").mandatory(true).contains(true).id(GraphicsPipeline.FeatureIDs.VIEWPORT_STATE).concept(() -> GraphicPipelineModelDefinition.Groups.VIEWPORT_STATE).build();
    Relation<InputAssembly, InputAssembly, Listener<InputAssembly>, Features<?>> INPUT_ASSEMBLY = new RelationBuilder<InputAssembly, InputAssembly, Listener<InputAssembly>, Features<?>>().name("inputAssembly").mandatory(true).contains(true).id(GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY).concept(() -> GraphicPipelineModelDefinition.Groups.INPUT_ASSEMBLY).build();
    Relation<Rasterizer, Rasterizer, Listener<Rasterizer>, Features<?>> RASTERIZER = new RelationBuilder<Rasterizer, Rasterizer, Listener<Rasterizer>, Features<?>>().name("rasterizer").mandatory(true).contains(true).id(GraphicsPipeline.FeatureIDs.RASTERIZER).concept(() -> GraphicPipelineModelDefinition.Groups.RASTERIZER).build();
    Relation<ColorBlend, ColorBlend, Listener<ColorBlend>, Features<?>> COLOR_BLEND = new RelationBuilder<ColorBlend, ColorBlend, Listener<ColorBlend>, Features<?>>().name("colorBlend").mandatory(true).contains(true).id(GraphicsPipeline.FeatureIDs.COLOR_BLEND).concept(() -> GraphicPipelineModelDefinition.Groups.COLOR_BLEND).build();
    Relation<DynamicState, DynamicState, Listener<DynamicState>, Features<?>> DYNAMIC_STATE = new RelationBuilder<DynamicState, DynamicState, Listener<DynamicState>, Features<?>>().name("dynamicState").contains(true).id(GraphicsPipeline.FeatureIDs.DYNAMIC_STATE).concept(() -> GraphicPipelineModelDefinition.Groups.DYNAMIC_STATE).build();
    Relation<VertexInputState, VertexInputState, Listener<VertexInputState>, Features<?>> VERTEX_INPUT_STATE = new RelationBuilder<VertexInputState, VertexInputState, Listener<VertexInputState>, Features<?>>().name("vertexInputState").mandatory(true).contains(true).id(GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE).concept(() -> GraphicModelDefinition.Groups.VERTEX_INPUT_STATE).build();
    Relation<DepthStencilState, DepthStencilState, Listener<DepthStencilState>, Features<?>> DEPTH_STENCIL_STATE = new RelationBuilder<DepthStencilState, DepthStencilState, Listener<DepthStencilState>, Features<?>>().name("depthStencilState").contains(true).id(GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE).concept(() -> GraphicPipelineModelDefinition.Groups.DEPTH_STENCIL_STATE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MAINTAINER, RESOURCE_PKG, DESCRIPTOR_PKG, NAME, ALLOCATE, RECORD, EXTENSION_PKG, TASK_PKGS, DESCRIPTOR_POOL, SPECIALIZATION_DATA, PUSH_CONSTANT_RANGES, LAYOUT, SHADERS, VIEWPORT_STATE, INPUT_ASSEMBLY, RASTERIZER, COLOR_BLEND, DYNAMIC_STATE, VERTEX_INPUT_STATE, DEPTH_STENCIL_STATE);
  }

  interface Builder extends IFeaturedObject.Builder<GraphicsPipeline> {
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
    Builder addTaskPkgs(List<TaskPkg> taskPkgs);
    Builder addPushConstantRanges(List<PushConstantRange> pushConstantRanges);
    Builder addLayout(List<DescriptorSet> layout);
    Builder addShaders(List<Shader> shaders);
  }
}
