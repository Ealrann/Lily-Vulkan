package org.sheepy.lily.vulkan.extra.model.mesh.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.extra.model.mesh.IMeshStructure;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshRenderer;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshRenderer.Builder;
import org.sheepy.lily.vulkan.extra.model.mesh.impl.MeshRendererImpl;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.Structure;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
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

public final class MeshRendererBuilder implements Builder {
  private final List<Supplier<Maintainable<GraphicsPipeline>>> maintained = new ArrayList<>();
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
  private Supplier<DataProviderPkg<IMeshStructure>> dataProviderPkg;
  private final List<Supplier<IMeshStructure>> renderedStructures = new ArrayList<>();
  private Supplier<ConstantBuffer> constantBuffer = () -> null;
  private Supplier<TransferBuffer> transferBuffer;
  private Supplier<ResourceDescriptorProviderPkg> descriptorProviderPkg = () -> null;
  private Supplier<ISpecialization> specialization = () -> null;
  private Supplier<FlushTransferBufferTask> flushTransferBufferTask;
  private boolean onePipelinePerPart = false;
  private boolean maintaining = true;

  public MeshRendererBuilder() {
  }

  @Override
  public MeshRendererBuilder addMaintained(Supplier<Maintainable<GraphicsPipeline>> maintained) {
    this.maintained.add(maintained);
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private MeshRendererBuilder _maintained(final Supplier<Maintainable<?>> maintained) {
    this.maintained.add((Supplier) maintained);
    return this;
  }

  @Override
  public MeshRendererBuilder addMaintained(final List<Maintainable<?>> maintained) {
    maintained.forEach(value -> this._maintained(() -> value));
    return this;
  }

  @Override
  public MeshRendererBuilder maintainer(Supplier<Maintainer<GraphicsPipeline>> maintainer) {
    this.maintainer = maintainer;
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private MeshRendererBuilder _maintainer(final Supplier<Maintainer<?>> maintainer) {
    this.maintainer = (Supplier) maintainer;
    return this;
  }

  @Override
  public MeshRendererBuilder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public MeshRendererBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public MeshRendererBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public MeshRendererBuilder allocate(boolean allocate) {
    this.allocate = allocate;
    return this;
  }

  @Override
  public MeshRendererBuilder record(boolean record) {
    this.record = record;
    return this;
  }

  @Override
  public MeshRendererBuilder extensionPkg(Supplier<PipelineExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public MeshRendererBuilder addTaskPkg(Supplier<TaskPkg> taskPkg) {
    this.taskPkgs.add(taskPkg);
    return this;
  }

  @Override
  public MeshRendererBuilder addTaskPkgs(final List<TaskPkg> taskPkgs) {
    taskPkgs.forEach(value -> this.taskPkgs.add(() -> value));
    return this;
  }

  @Override
  public MeshRendererBuilder descriptorPool(Supplier<DescriptorPool> descriptorPool) {
    this.descriptorPool = descriptorPool;
    return this;
  }

  @Override
  public MeshRendererBuilder specializationData(Supplier<ConstantBuffer> specializationData) {
    this.specializationData = specializationData;
    return this;
  }

  @Override
  public MeshRendererBuilder addPushConstantRange(Supplier<PushConstantRange> pushConstantRange) {
    this.pushConstantRanges.add(pushConstantRange);
    return this;
  }

  @Override
  public MeshRendererBuilder addPushConstantRanges(
      final List<PushConstantRange> pushConstantRanges) {
    pushConstantRanges.forEach(value -> this.pushConstantRanges.add(() -> value));
    return this;
  }

  @Override
  public MeshRendererBuilder addLayout(Supplier<DescriptorSet> layout) {
    this.layout.add(layout);
    return this;
  }

  @Override
  public MeshRendererBuilder addLayout(final List<DescriptorSet> layout) {
    layout.forEach(value -> this.layout.add(() -> value));
    return this;
  }

  @Override
  public MeshRendererBuilder addShader(Supplier<Shader> shader) {
    this.shaders.add(shader);
    return this;
  }

  @Override
  public MeshRendererBuilder addShaders(final List<Shader> shaders) {
    shaders.forEach(value -> this.shaders.add(() -> value));
    return this;
  }

  @Override
  public MeshRendererBuilder viewportState(Supplier<ViewportState> viewportState) {
    this.viewportState = viewportState;
    return this;
  }

  @Override
  public MeshRendererBuilder inputAssembly(Supplier<InputAssembly> inputAssembly) {
    this.inputAssembly = inputAssembly;
    return this;
  }

  @Override
  public MeshRendererBuilder rasterizer(Supplier<Rasterizer> rasterizer) {
    this.rasterizer = rasterizer;
    return this;
  }

  @Override
  public MeshRendererBuilder colorBlend(Supplier<ColorBlend> colorBlend) {
    this.colorBlend = colorBlend;
    return this;
  }

  @Override
  public MeshRendererBuilder dynamicState(Supplier<DynamicState> dynamicState) {
    this.dynamicState = dynamicState;
    return this;
  }

  @Override
  public MeshRendererBuilder vertexInputState(Supplier<VertexInputState> vertexInputState) {
    this.vertexInputState = vertexInputState;
    return this;
  }

  @Override
  public MeshRendererBuilder depthStencilState(Supplier<DepthStencilState> depthStencilState) {
    this.depthStencilState = depthStencilState;
    return this;
  }

  @Override
  public MeshRendererBuilder dataProviderPkg(
      Supplier<DataProviderPkg<IMeshStructure>> dataProviderPkg) {
    this.dataProviderPkg = dataProviderPkg;
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private MeshRendererBuilder _dataProviderPkg(final Supplier<DataProviderPkg<?>> dataProviderPkg) {
    this.dataProviderPkg = (Supplier) dataProviderPkg;
    return this;
  }

  @Override
  public MeshRendererBuilder addRenderedStructure(Supplier<IMeshStructure> renderedStructure) {
    this.renderedStructures.add(renderedStructure);
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private MeshRendererBuilder _renderedStructures(final Supplier<Structure> renderedStructure) {
    this.renderedStructures.add((Supplier) renderedStructure);
    return this;
  }

  @Override
  public MeshRendererBuilder addRenderedStructures(final List<IMeshStructure> renderedStructures) {
    renderedStructures.forEach(value -> this._renderedStructures(() -> value));
    return this;
  }

  @Override
  public MeshRendererBuilder constantBuffer(Supplier<ConstantBuffer> constantBuffer) {
    this.constantBuffer = constantBuffer;
    return this;
  }

  @Override
  public MeshRendererBuilder transferBuffer(Supplier<TransferBuffer> transferBuffer) {
    this.transferBuffer = transferBuffer;
    return this;
  }

  @Override
  public MeshRendererBuilder descriptorProviderPkg(
      Supplier<ResourceDescriptorProviderPkg> descriptorProviderPkg) {
    this.descriptorProviderPkg = descriptorProviderPkg;
    return this;
  }

  @Override
  public MeshRendererBuilder specialization(Supplier<ISpecialization> specialization) {
    this.specialization = specialization;
    return this;
  }

  @Override
  public MeshRendererBuilder flushTransferBufferTask(
      Supplier<FlushTransferBufferTask> flushTransferBufferTask) {
    this.flushTransferBufferTask = flushTransferBufferTask;
    return this;
  }

  @Override
  public MeshRendererBuilder onePipelinePerPart(boolean onePipelinePerPart) {
    this.onePipelinePerPart = onePipelinePerPart;
    return this;
  }

  @Override
  public MeshRendererBuilder maintaining(boolean maintaining) {
    this.maintaining = maintaining;
    return this;
  }

  @Override
  public MeshRenderer build() {
    final var builtMaintained = BuildUtils.collectSuppliers(maintained);
    final var builtTaskPkgs = BuildUtils.collectSuppliers(taskPkgs);
    final var builtPushConstantRanges = BuildUtils.collectSuppliers(pushConstantRanges);
    final var builtLayout = BuildUtils.collectSuppliers(layout);
    final var builtShaders = BuildUtils.collectSuppliers(shaders);
    final var builtRenderedStructures = BuildUtils.collectSuppliers(renderedStructures);
    final var built = new MeshRendererImpl(name, builtShaders, viewportState.get(), inputAssembly.get(), rasterizer.get(), colorBlend.get(), vertexInputState.get(), dataProviderPkg.get(), builtRenderedStructures, transferBuffer.get(), flushTransferBufferTask.get(), onePipelinePerPart);
    built.maintained().addAll(builtMaintained);
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
    built.constantBuffer(constantBuffer.get());
    built.descriptorProviderPkg(descriptorProviderPkg.get());
    built.specialization(specialization.get());
    built.maintaining(maintaining);
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
    private static final FeatureInserter<MeshRendererBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<MeshRendererBuilder>(5, Inserters::attributeIndex).add(MeshRenderer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(MeshRenderer.FeatureIDs.ALLOCATE, (builder, value) -> builder.allocate((boolean) value)).add(MeshRenderer.FeatureIDs.RECORD, (builder, value) -> builder.record((boolean) value)).add(MeshRenderer.FeatureIDs.ONE_PIPELINE_PER_PART, (builder, value) -> builder.onePipelinePerPart((boolean) value)).add(MeshRenderer.FeatureIDs.MAINTAINING, (builder, value) -> builder.maintaining((boolean) value)).build();
    private static final RelationLazyInserter<MeshRendererBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<MeshRendererBuilder>(25, Inserters::relationIndex).add(MeshRenderer.FeatureIDs.MAINTAINED, (builder, value) -> builder._maintained((Supplier<Maintainable<?>>) value)).add(MeshRenderer.FeatureIDs.MAINTAINER, (builder, value) -> builder._maintainer((Supplier<Maintainer<?>>) value)).add(MeshRenderer.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<VulkanResourcePkg>) value)).add(MeshRenderer.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).add(MeshRenderer.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<PipelineExtensionPkg>) value)).add(MeshRenderer.FeatureIDs.TASK_PKGS, (builder, value) -> builder.addTaskPkg((Supplier<TaskPkg>) value)).add(MeshRenderer.FeatureIDs.DESCRIPTOR_POOL, (builder, value) -> builder.descriptorPool((Supplier<DescriptorPool>) value)).add(MeshRenderer.FeatureIDs.SPECIALIZATION_DATA, (builder, value) -> builder.specializationData((Supplier<ConstantBuffer>) value)).add(MeshRenderer.FeatureIDs.PUSH_CONSTANT_RANGES, (builder, value) -> builder.addPushConstantRange((Supplier<PushConstantRange>) value)).add(MeshRenderer.FeatureIDs.LAYOUT, (builder, value) -> builder.addLayout((Supplier<DescriptorSet>) value)).add(MeshRenderer.FeatureIDs.SHADERS, (builder, value) -> builder.addShader((Supplier<Shader>) value)).add(MeshRenderer.FeatureIDs.VIEWPORT_STATE, (builder, value) -> builder.viewportState((Supplier<ViewportState>) value)).add(MeshRenderer.FeatureIDs.INPUT_ASSEMBLY, (builder, value) -> builder.inputAssembly((Supplier<InputAssembly>) value)).add(MeshRenderer.FeatureIDs.RASTERIZER, (builder, value) -> builder.rasterizer((Supplier<Rasterizer>) value)).add(MeshRenderer.FeatureIDs.COLOR_BLEND, (builder, value) -> builder.colorBlend((Supplier<ColorBlend>) value)).add(MeshRenderer.FeatureIDs.DYNAMIC_STATE, (builder, value) -> builder.dynamicState((Supplier<DynamicState>) value)).add(MeshRenderer.FeatureIDs.VERTEX_INPUT_STATE, (builder, value) -> builder.vertexInputState((Supplier<VertexInputState>) value)).add(MeshRenderer.FeatureIDs.DEPTH_STENCIL_STATE, (builder, value) -> builder.depthStencilState((Supplier<DepthStencilState>) value)).add(MeshRenderer.FeatureIDs.DATA_PROVIDER_PKG, (builder, value) -> builder._dataProviderPkg((Supplier<DataProviderPkg<?>>) value)).add(MeshRenderer.FeatureIDs.RENDERED_STRUCTURES, (builder, value) -> builder._renderedStructures((Supplier<Structure>) value)).add(MeshRenderer.FeatureIDs.CONSTANT_BUFFER, (builder, value) -> builder.constantBuffer((Supplier<ConstantBuffer>) value)).add(MeshRenderer.FeatureIDs.TRANSFER_BUFFER, (builder, value) -> builder.transferBuffer((Supplier<TransferBuffer>) value)).add(MeshRenderer.FeatureIDs.DESCRIPTOR_PROVIDER_PKG, (builder, value) -> builder.descriptorProviderPkg((Supplier<ResourceDescriptorProviderPkg>) value)).add(MeshRenderer.FeatureIDs.SPECIALIZATION, (builder, value) -> builder.specialization((Supplier<ISpecialization>) value)).add(MeshRenderer.FeatureIDs.FLUSH_TRANSFER_BUFFER_TASK, (builder, value) -> builder.flushTransferBufferTask((Supplier<FlushTransferBufferTask>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case MeshRenderer.FeatureIDs.NAME -> 0;
        case MeshRenderer.FeatureIDs.ALLOCATE -> 1;
        case MeshRenderer.FeatureIDs.RECORD -> 2;
        case MeshRenderer.FeatureIDs.ONE_PIPELINE_PER_PART -> 3;
        case MeshRenderer.FeatureIDs.MAINTAINING -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case MeshRenderer.FeatureIDs.MAINTAINED -> 0;
        case MeshRenderer.FeatureIDs.MAINTAINER -> 1;
        case MeshRenderer.FeatureIDs.RESOURCE_PKG -> 2;
        case MeshRenderer.FeatureIDs.DESCRIPTOR_PKG -> 3;
        case MeshRenderer.FeatureIDs.EXTENSION_PKG -> 4;
        case MeshRenderer.FeatureIDs.TASK_PKGS -> 5;
        case MeshRenderer.FeatureIDs.DESCRIPTOR_POOL -> 6;
        case MeshRenderer.FeatureIDs.SPECIALIZATION_DATA -> 7;
        case MeshRenderer.FeatureIDs.PUSH_CONSTANT_RANGES -> 8;
        case MeshRenderer.FeatureIDs.LAYOUT -> 9;
        case MeshRenderer.FeatureIDs.SHADERS -> 10;
        case MeshRenderer.FeatureIDs.VIEWPORT_STATE -> 11;
        case MeshRenderer.FeatureIDs.INPUT_ASSEMBLY -> 12;
        case MeshRenderer.FeatureIDs.RASTERIZER -> 13;
        case MeshRenderer.FeatureIDs.COLOR_BLEND -> 14;
        case MeshRenderer.FeatureIDs.DYNAMIC_STATE -> 15;
        case MeshRenderer.FeatureIDs.VERTEX_INPUT_STATE -> 16;
        case MeshRenderer.FeatureIDs.DEPTH_STENCIL_STATE -> 17;
        case MeshRenderer.FeatureIDs.DATA_PROVIDER_PKG -> 18;
        case MeshRenderer.FeatureIDs.RENDERED_STRUCTURES -> 19;
        case MeshRenderer.FeatureIDs.CONSTANT_BUFFER -> 20;
        case MeshRenderer.FeatureIDs.TRANSFER_BUFFER -> 21;
        case MeshRenderer.FeatureIDs.DESCRIPTOR_PROVIDER_PKG -> 22;
        case MeshRenderer.FeatureIDs.SPECIALIZATION -> 23;
        case MeshRenderer.FeatureIDs.FLUSH_TRANSFER_BUFFER_TASK -> 24;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
