package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicsPipelineImpl;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.DynamicState;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.Rasterizer;
import org.sheepy.vulkan.model.graphicpipeline.ViewportState;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public final class GraphicsPipelineBuilder implements Builder {
  private Supplier<Maintainer<GraphicsPipeline>> maintainer = () -> null;
  private Supplier<VulkanResourcePkg> resourcePkg = () -> null;
  private Supplier<DescriptorPkg> descriptorPkg = () -> null;
  private String name;
  private boolean allocate = true;
  private boolean record = true;
  private Supplier<PipelineExtensionPkg> extensionPkg = () -> null;
  private final List<Supplier<TaskPkg>> taskPkgs = new ArrayList<>();
  private Supplier<DescriptorPool> descriptorPool = () -> null;
  private Supplier<ConstantBuffer> specializationData = () -> null;
  private final List<Supplier<PushConstantRange>> pushConstantRanges = new ArrayList<>();
  private final List<Supplier<DescriptorSet>> layout = new ArrayList<>();
  private final List<Supplier<Shader>> shaders = new ArrayList<>();
  private Supplier<ViewportState> viewportState;
  private Supplier<InputAssembly> inputAssembly;
  private Supplier<Rasterizer> rasterizer;
  private Supplier<ColorBlend> colorBlend;
  private Supplier<DynamicState> dynamicState = () -> null;
  private Supplier<VertexInputState> vertexInputState;
  private Supplier<DepthStencilState> depthStencilState = () -> null;

  public GraphicsPipelineBuilder() {
  }

  @Override
  public GraphicsPipelineBuilder maintainer(Supplier<Maintainer<GraphicsPipeline>> maintainer) {
    this.maintainer = maintainer;
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private GraphicsPipelineBuilder _maintainer(final Supplier<Maintainer<?>> maintainer) {
    this.maintainer = (Supplier) maintainer;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder allocate(boolean allocate) {
    this.allocate = allocate;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder record(boolean record) {
    this.record = record;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder extensionPkg(Supplier<PipelineExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder addTaskPkg(Supplier<TaskPkg> taskPkg) {
    this.taskPkgs.add(taskPkg);
    return this;
  }

  @Override
  public GraphicsPipelineBuilder addTaskPkgs(final List<TaskPkg> taskPkgs) {
    taskPkgs.forEach(value -> this.taskPkgs.add(() -> value));
    return this;
  }

  @Override
  public GraphicsPipelineBuilder descriptorPool(Supplier<DescriptorPool> descriptorPool) {
    this.descriptorPool = descriptorPool;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder specializationData(Supplier<ConstantBuffer> specializationData) {
    this.specializationData = specializationData;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder addPushConstantRange(
      Supplier<PushConstantRange> pushConstantRange) {
    this.pushConstantRanges.add(pushConstantRange);
    return this;
  }

  @Override
  public GraphicsPipelineBuilder addPushConstantRanges(
      final List<PushConstantRange> pushConstantRanges) {
    pushConstantRanges.forEach(value -> this.pushConstantRanges.add(() -> value));
    return this;
  }

  @Override
  public GraphicsPipelineBuilder addLayout(Supplier<DescriptorSet> layout) {
    this.layout.add(layout);
    return this;
  }

  @Override
  public GraphicsPipelineBuilder addLayout(final List<DescriptorSet> layout) {
    layout.forEach(value -> this.layout.add(() -> value));
    return this;
  }

  @Override
  public GraphicsPipelineBuilder addShader(Supplier<Shader> shader) {
    this.shaders.add(shader);
    return this;
  }

  @Override
  public GraphicsPipelineBuilder addShaders(final List<Shader> shaders) {
    shaders.forEach(value -> this.shaders.add(() -> value));
    return this;
  }

  @Override
  public GraphicsPipelineBuilder viewportState(Supplier<ViewportState> viewportState) {
    this.viewportState = viewportState;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder inputAssembly(Supplier<InputAssembly> inputAssembly) {
    this.inputAssembly = inputAssembly;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder rasterizer(Supplier<Rasterizer> rasterizer) {
    this.rasterizer = rasterizer;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder colorBlend(Supplier<ColorBlend> colorBlend) {
    this.colorBlend = colorBlend;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder dynamicState(Supplier<DynamicState> dynamicState) {
    this.dynamicState = dynamicState;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder vertexInputState(Supplier<VertexInputState> vertexInputState) {
    this.vertexInputState = vertexInputState;
    return this;
  }

  @Override
  public GraphicsPipelineBuilder depthStencilState(Supplier<DepthStencilState> depthStencilState) {
    this.depthStencilState = depthStencilState;
    return this;
  }

  @Override
  public GraphicsPipeline build() {
    final var builtTaskPkgs = BuildUtils.collectSuppliers(taskPkgs);
    final var builtPushConstantRanges = BuildUtils.collectSuppliers(pushConstantRanges);
    final var builtLayout = BuildUtils.collectSuppliers(layout);
    final var builtShaders = BuildUtils.collectSuppliers(shaders);
    final var built = new GraphicsPipelineImpl(name, builtShaders, viewportState.get(), inputAssembly.get(), rasterizer.get(), colorBlend.get(), vertexInputState.get());
    built.maintainer(maintainer.get());
    built.resourcePkg(resourcePkg.get());
    built.descriptorPkg(descriptorPkg.get());
    built.allocate(allocate);
    built.record(record);
    built.extensionPkg(extensionPkg.get());
    built.taskPkgs().addAll(builtTaskPkgs);
    built.descriptorPool(descriptorPool.get());
    built.specializationData(specializationData.get());
    built.pushConstantRanges().addAll(builtPushConstantRanges);
    built.layout().addAll(builtLayout);
    built.dynamicState(dynamicState.get());
    built.depthStencilState(depthStencilState.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<GraphicsPipelineBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GraphicsPipelineBuilder>(3, Inserters::attributeIndex).add(GraphicsPipeline.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(GraphicsPipeline.FeatureIDs.ALLOCATE, (builder, value) -> builder.allocate((boolean) value)).add(GraphicsPipeline.FeatureIDs.RECORD, (builder, value) -> builder.record((boolean) value)).build();
    private static final RelationLazyInserter<GraphicsPipelineBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GraphicsPipelineBuilder>(17, Inserters::relationIndex).add(GraphicsPipeline.FeatureIDs.MAINTAINER, (builder, value) -> builder._maintainer((Supplier<Maintainer<?>>) value)).add(GraphicsPipeline.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<VulkanResourcePkg>) value)).add(GraphicsPipeline.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).add(GraphicsPipeline.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<PipelineExtensionPkg>) value)).add(GraphicsPipeline.FeatureIDs.TASK_PKGS, (builder, value) -> builder.addTaskPkg((Supplier<TaskPkg>) value)).add(GraphicsPipeline.FeatureIDs.DESCRIPTOR_POOL, (builder, value) -> builder.descriptorPool((Supplier<DescriptorPool>) value)).add(GraphicsPipeline.FeatureIDs.SPECIALIZATION_DATA, (builder, value) -> builder.specializationData((Supplier<ConstantBuffer>) value)).add(GraphicsPipeline.FeatureIDs.PUSH_CONSTANT_RANGES, (builder, value) -> builder.addPushConstantRange((Supplier<PushConstantRange>) value)).add(GraphicsPipeline.FeatureIDs.LAYOUT, (builder, value) -> builder.addLayout((Supplier<DescriptorSet>) value)).add(GraphicsPipeline.FeatureIDs.SHADERS, (builder, value) -> builder.addShader((Supplier<Shader>) value)).add(GraphicsPipeline.FeatureIDs.VIEWPORT_STATE, (builder, value) -> builder.viewportState((Supplier<ViewportState>) value)).add(GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY, (builder, value) -> builder.inputAssembly((Supplier<InputAssembly>) value)).add(GraphicsPipeline.FeatureIDs.RASTERIZER, (builder, value) -> builder.rasterizer((Supplier<Rasterizer>) value)).add(GraphicsPipeline.FeatureIDs.COLOR_BLEND, (builder, value) -> builder.colorBlend((Supplier<ColorBlend>) value)).add(GraphicsPipeline.FeatureIDs.DYNAMIC_STATE, (builder, value) -> builder.dynamicState((Supplier<DynamicState>) value)).add(GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE, (builder, value) -> builder.vertexInputState((Supplier<VertexInputState>) value)).add(GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE, (builder, value) -> builder.depthStencilState((Supplier<DepthStencilState>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case GraphicsPipeline.FeatureIDs.NAME -> 0;
        case GraphicsPipeline.FeatureIDs.ALLOCATE -> 1;
        case GraphicsPipeline.FeatureIDs.RECORD -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case GraphicsPipeline.FeatureIDs.MAINTAINER -> 0;
        case GraphicsPipeline.FeatureIDs.RESOURCE_PKG -> 1;
        case GraphicsPipeline.FeatureIDs.DESCRIPTOR_PKG -> 2;
        case GraphicsPipeline.FeatureIDs.EXTENSION_PKG -> 3;
        case GraphicsPipeline.FeatureIDs.TASK_PKGS -> 4;
        case GraphicsPipeline.FeatureIDs.DESCRIPTOR_POOL -> 5;
        case GraphicsPipeline.FeatureIDs.SPECIALIZATION_DATA -> 6;
        case GraphicsPipeline.FeatureIDs.PUSH_CONSTANT_RANGES -> 7;
        case GraphicsPipeline.FeatureIDs.LAYOUT -> 8;
        case GraphicsPipeline.FeatureIDs.SHADERS -> 9;
        case GraphicsPipeline.FeatureIDs.VIEWPORT_STATE -> 10;
        case GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY -> 11;
        case GraphicsPipeline.FeatureIDs.RASTERIZER -> 12;
        case GraphicsPipeline.FeatureIDs.COLOR_BLEND -> 13;
        case GraphicsPipeline.FeatureIDs.DYNAMIC_STATE -> 14;
        case GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE -> 15;
        case GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE -> 16;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
