package org.sheepy.lily.vulkan.extra.model.mesh.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.extra.model.mesh.IMeshStructure;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshModelDefinition;
import org.sheepy.lily.vulkan.extra.model.mesh.MeshRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.DataProviderPkg;
import org.sheepy.lily.vulkan.extra.model.rendering.GenericRenderer;
import org.sheepy.lily.vulkan.extra.model.rendering.ISpecialization;
import org.sheepy.lily.vulkan.extra.model.rendering.ResourceDescriptorProviderPkg;
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

public final class MeshRendererImpl extends FeaturedObject<MeshRenderer.Features<?>> implements MeshRenderer {
  private static final int FEATURE_COUNT = 30;
  private final ModelNotifier<MeshRenderer.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<Maintainable<GraphicsPipeline>> maintained = newObservableList(Maintainer.FeatureIDs.MAINTAINED, true, false);
  private Maintainer<GraphicsPipeline> maintainer;
  private VulkanResourcePkg resourcePkg;
  private DescriptorPkg descriptorPkg;
  private final String name;
  private boolean allocate;
  private boolean record;
  private PipelineExtensionPkg extensionPkg;
  private final List<TaskPkg> taskPkgs = newObservableList(TaskPipeline.FeatureIDs.TASK_PKGS, true, true);
  private DescriptorPool descriptorPool;
  private ConstantBuffer specializationData;
  private final List<PushConstantRange> pushConstantRanges = newObservableList(VkPipeline.FeatureIDs.PUSH_CONSTANT_RANGES, true, true);
  private final List<DescriptorSet> layout = newObservableList(VkPipeline.FeatureIDs.LAYOUT, true, false);
  private final List<Shader> shaders = newObservableList(GraphicsPipeline.FeatureIDs.SHADERS, true, false);
  private ViewportState viewportState;
  private InputAssembly inputAssembly;
  private Rasterizer rasterizer;
  private ColorBlend colorBlend;
  private DynamicState dynamicState;
  private VertexInputState vertexInputState;
  private DepthStencilState depthStencilState;
  private DataProviderPkg<IMeshStructure> dataProviderPkg;
  private final List<IMeshStructure> renderedStructures = newObservableList(GenericRenderer.FeatureIDs.RENDERED_STRUCTURES, true, false);
  private ConstantBuffer constantBuffer;
  private TransferBuffer transferBuffer;
  private ResourceDescriptorProviderPkg descriptorProviderPkg;
  private ISpecialization specialization;
  private FlushTransferBufferTask flushTransferBufferTask;
  private boolean onePipelinePerPart;
  private boolean maintaining;

  public MeshRendererImpl(final String name, final List<Shader> shaders,
      final ViewportState viewportState, final InputAssembly inputAssembly,
      final Rasterizer rasterizer, final ColorBlend colorBlend,
      final VertexInputState vertexInputState,
      final DataProviderPkg<IMeshStructure> dataProviderPkg,
      final List<IMeshStructure> renderedStructures, final TransferBuffer transferBuffer,
      final FlushTransferBufferTask flushTransferBufferTask, final boolean onePipelinePerPart) {
    this.name = name;
    this.shaders.addAll(shaders);
    this.viewportState = viewportState;
    this.inputAssembly = inputAssembly;
    this.rasterizer = rasterizer;
    this.colorBlend = colorBlend;
    this.vertexInputState = vertexInputState;
    this.dataProviderPkg = dataProviderPkg;
    this.renderedStructures.addAll(renderedStructures);
    this.transferBuffer = transferBuffer;
    this.flushTransferBufferTask = flushTransferBufferTask;
    this.onePipelinePerPart = onePipelinePerPart;
    setContainer(viewportState, GraphicsPipeline.FeatureIDs.VIEWPORT_STATE);
    setContainer(inputAssembly, GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY);
    setContainer(rasterizer, GraphicsPipeline.FeatureIDs.RASTERIZER);
    setContainer(colorBlend, GraphicsPipeline.FeatureIDs.COLOR_BLEND);
    setContainer(vertexInputState, GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE);
    setContainer(dataProviderPkg, GenericRenderer.FeatureIDs.DATA_PROVIDER_PKG);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<MeshRenderer.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<Maintainable<GraphicsPipeline>> maintained() {
    return maintained;
  }

  @Override
  public Maintainer<GraphicsPipeline> maintainer() {
    return maintainer;
  }

  @Override
  public void maintainer(final Maintainer<GraphicsPipeline> maintainer) {
    final var oldValue = this.maintainer;
    final var eventType = maintainer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.maintainer = maintainer;
    notifier.notify(Maintainable.FeatureIDs.MAINTAINER, false, false, eventType, oldValue, maintainer);
  }

  @Override
  public VulkanResourcePkg resourcePkg() {
    return resourcePkg;
  }

  @Override
  public void resourcePkg(final VulkanResourcePkg resourcePkg) {
    final var oldValue = this.resourcePkg;
    final var eventType = resourcePkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.resourcePkg = resourcePkg;
    setContainer(resourcePkg, IResourceContainer.FeatureIDs.RESOURCE_PKG);
    beforeContainmentNotify(eventType, oldValue, resourcePkg);
    notifier.notify(IResourceContainer.FeatureIDs.RESOURCE_PKG, true, false, eventType, oldValue, resourcePkg);
    afterContainmentNotify(eventType, oldValue, resourcePkg);
  }

  @Override
  public DescriptorPkg descriptorPkg() {
    return descriptorPkg;
  }

  @Override
  public void descriptorPkg(final DescriptorPkg descriptorPkg) {
    final var oldValue = this.descriptorPkg;
    final var eventType = descriptorPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.descriptorPkg = descriptorPkg;
    setContainer(descriptorPkg, IResourceContainer.FeatureIDs.DESCRIPTOR_PKG);
    beforeContainmentNotify(eventType, oldValue, descriptorPkg);
    notifier.notify(IResourceContainer.FeatureIDs.DESCRIPTOR_PKG, true, false, eventType, oldValue, descriptorPkg);
    afterContainmentNotify(eventType, oldValue, descriptorPkg);
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean allocate() {
    return allocate;
  }

  @Override
  public void allocate(final boolean allocate) {
    final var oldValue = this.allocate;
    this.allocate = allocate;
    notifier.notifyBoolean(AbstractPipeline.FeatureIDs.ALLOCATE, false, false, oldValue, allocate);
  }

  @Override
  public boolean record() {
    return record;
  }

  @Override
  public void record(final boolean record) {
    final var oldValue = this.record;
    this.record = record;
    notifier.notifyBoolean(AbstractPipeline.FeatureIDs.RECORD, false, false, oldValue, record);
  }

  @Override
  public PipelineExtensionPkg extensionPkg() {
    return extensionPkg;
  }

  @Override
  public void extensionPkg(final PipelineExtensionPkg extensionPkg) {
    final var oldValue = this.extensionPkg;
    final var eventType = extensionPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.extensionPkg = extensionPkg;
    setContainer(extensionPkg, AbstractPipeline.FeatureIDs.EXTENSION_PKG);
    beforeContainmentNotify(eventType, oldValue, extensionPkg);
    notifier.notify(AbstractPipeline.FeatureIDs.EXTENSION_PKG, true, false, eventType, oldValue, extensionPkg);
    afterContainmentNotify(eventType, oldValue, extensionPkg);
  }

  @Override
  public List<TaskPkg> taskPkgs() {
    return taskPkgs;
  }

  @Override
  public DescriptorPool descriptorPool() {
    return descriptorPool;
  }

  @Override
  public void descriptorPool(final DescriptorPool descriptorPool) {
    final var oldValue = this.descriptorPool;
    final var eventType = descriptorPool == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.descriptorPool = descriptorPool;
    setContainer(descriptorPool, VkPipeline.FeatureIDs.DESCRIPTOR_POOL);
    beforeContainmentNotify(eventType, oldValue, descriptorPool);
    notifier.notify(VkPipeline.FeatureIDs.DESCRIPTOR_POOL, true, false, eventType, oldValue, descriptorPool);
    afterContainmentNotify(eventType, oldValue, descriptorPool);
  }

  @Override
  public ConstantBuffer specializationData() {
    return specializationData;
  }

  @Override
  public void specializationData(final ConstantBuffer specializationData) {
    final var oldValue = this.specializationData;
    final var eventType = specializationData == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.specializationData = specializationData;
    notifier.notify(VkPipeline.FeatureIDs.SPECIALIZATION_DATA, false, false, eventType, oldValue, specializationData);
  }

  @Override
  public List<PushConstantRange> pushConstantRanges() {
    return pushConstantRanges;
  }

  @Override
  public List<DescriptorSet> layout() {
    return layout;
  }

  @Override
  public List<Shader> shaders() {
    return shaders;
  }

  @Override
  public ViewportState viewportState() {
    return viewportState;
  }

  @Override
  public void viewportState(final ViewportState viewportState) {
    final var oldValue = this.viewportState;
    final var eventType = viewportState == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.viewportState = viewportState;
    setContainer(viewportState, GraphicsPipeline.FeatureIDs.VIEWPORT_STATE);
    beforeContainmentNotify(eventType, oldValue, viewportState);
    notifier.notify(GraphicsPipeline.FeatureIDs.VIEWPORT_STATE, true, false, eventType, oldValue, viewportState);
    afterContainmentNotify(eventType, oldValue, viewportState);
  }

  @Override
  public InputAssembly inputAssembly() {
    return inputAssembly;
  }

  @Override
  public void inputAssembly(final InputAssembly inputAssembly) {
    final var oldValue = this.inputAssembly;
    final var eventType = inputAssembly == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.inputAssembly = inputAssembly;
    setContainer(inputAssembly, GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY);
    beforeContainmentNotify(eventType, oldValue, inputAssembly);
    notifier.notify(GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY, true, false, eventType, oldValue, inputAssembly);
    afterContainmentNotify(eventType, oldValue, inputAssembly);
  }

  @Override
  public Rasterizer rasterizer() {
    return rasterizer;
  }

  @Override
  public void rasterizer(final Rasterizer rasterizer) {
    final var oldValue = this.rasterizer;
    final var eventType = rasterizer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.rasterizer = rasterizer;
    setContainer(rasterizer, GraphicsPipeline.FeatureIDs.RASTERIZER);
    beforeContainmentNotify(eventType, oldValue, rasterizer);
    notifier.notify(GraphicsPipeline.FeatureIDs.RASTERIZER, true, false, eventType, oldValue, rasterizer);
    afterContainmentNotify(eventType, oldValue, rasterizer);
  }

  @Override
  public ColorBlend colorBlend() {
    return colorBlend;
  }

  @Override
  public void colorBlend(final ColorBlend colorBlend) {
    final var oldValue = this.colorBlend;
    final var eventType = colorBlend == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.colorBlend = colorBlend;
    setContainer(colorBlend, GraphicsPipeline.FeatureIDs.COLOR_BLEND);
    beforeContainmentNotify(eventType, oldValue, colorBlend);
    notifier.notify(GraphicsPipeline.FeatureIDs.COLOR_BLEND, true, false, eventType, oldValue, colorBlend);
    afterContainmentNotify(eventType, oldValue, colorBlend);
  }

  @Override
  public DynamicState dynamicState() {
    return dynamicState;
  }

  @Override
  public void dynamicState(final DynamicState dynamicState) {
    final var oldValue = this.dynamicState;
    final var eventType = dynamicState == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dynamicState = dynamicState;
    setContainer(dynamicState, GraphicsPipeline.FeatureIDs.DYNAMIC_STATE);
    beforeContainmentNotify(eventType, oldValue, dynamicState);
    notifier.notify(GraphicsPipeline.FeatureIDs.DYNAMIC_STATE, true, false, eventType, oldValue, dynamicState);
    afterContainmentNotify(eventType, oldValue, dynamicState);
  }

  @Override
  public VertexInputState vertexInputState() {
    return vertexInputState;
  }

  @Override
  public void vertexInputState(final VertexInputState vertexInputState) {
    final var oldValue = this.vertexInputState;
    final var eventType = vertexInputState == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.vertexInputState = vertexInputState;
    setContainer(vertexInputState, GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE);
    beforeContainmentNotify(eventType, oldValue, vertexInputState);
    notifier.notify(GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE, true, false, eventType, oldValue, vertexInputState);
    afterContainmentNotify(eventType, oldValue, vertexInputState);
  }

  @Override
  public DepthStencilState depthStencilState() {
    return depthStencilState;
  }

  @Override
  public void depthStencilState(final DepthStencilState depthStencilState) {
    final var oldValue = this.depthStencilState;
    final var eventType = depthStencilState == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.depthStencilState = depthStencilState;
    setContainer(depthStencilState, GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE);
    beforeContainmentNotify(eventType, oldValue, depthStencilState);
    notifier.notify(GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE, true, false, eventType, oldValue, depthStencilState);
    afterContainmentNotify(eventType, oldValue, depthStencilState);
  }

  @Override
  public DataProviderPkg<IMeshStructure> dataProviderPkg() {
    return dataProviderPkg;
  }

  @Override
  public void dataProviderPkg(final DataProviderPkg<IMeshStructure> dataProviderPkg) {
    final var oldValue = this.dataProviderPkg;
    final var eventType = dataProviderPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.dataProviderPkg = dataProviderPkg;
    setContainer(dataProviderPkg, GenericRenderer.FeatureIDs.DATA_PROVIDER_PKG);
    beforeContainmentNotify(eventType, oldValue, dataProviderPkg);
    notifier.notify(GenericRenderer.FeatureIDs.DATA_PROVIDER_PKG, true, false, eventType, oldValue, dataProviderPkg);
    afterContainmentNotify(eventType, oldValue, dataProviderPkg);
  }

  @Override
  public List<IMeshStructure> renderedStructures() {
    return renderedStructures;
  }

  @Override
  public ConstantBuffer constantBuffer() {
    return constantBuffer;
  }

  @Override
  public void constantBuffer(final ConstantBuffer constantBuffer) {
    final var oldValue = this.constantBuffer;
    final var eventType = constantBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.constantBuffer = constantBuffer;
    notifier.notify(GenericRenderer.FeatureIDs.CONSTANT_BUFFER, false, false, eventType, oldValue, constantBuffer);
  }

  @Override
  public TransferBuffer transferBuffer() {
    return transferBuffer;
  }

  @Override
  public void transferBuffer(final TransferBuffer transferBuffer) {
    final var oldValue = this.transferBuffer;
    final var eventType = transferBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.transferBuffer = transferBuffer;
    notifier.notify(GenericRenderer.FeatureIDs.TRANSFER_BUFFER, false, false, eventType, oldValue, transferBuffer);
  }

  @Override
  public ResourceDescriptorProviderPkg descriptorProviderPkg() {
    return descriptorProviderPkg;
  }

  @Override
  public void descriptorProviderPkg(final ResourceDescriptorProviderPkg descriptorProviderPkg) {
    final var oldValue = this.descriptorProviderPkg;
    final var eventType = descriptorProviderPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.descriptorProviderPkg = descriptorProviderPkg;
    setContainer(descriptorProviderPkg, GenericRenderer.FeatureIDs.DESCRIPTOR_PROVIDER_PKG);
    beforeContainmentNotify(eventType, oldValue, descriptorProviderPkg);
    notifier.notify(GenericRenderer.FeatureIDs.DESCRIPTOR_PROVIDER_PKG, true, false, eventType, oldValue, descriptorProviderPkg);
    afterContainmentNotify(eventType, oldValue, descriptorProviderPkg);
  }

  @Override
  public ISpecialization specialization() {
    return specialization;
  }

  @Override
  public void specialization(final ISpecialization specialization) {
    final var oldValue = this.specialization;
    final var eventType = specialization == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.specialization = specialization;
    setContainer(specialization, GenericRenderer.FeatureIDs.SPECIALIZATION);
    beforeContainmentNotify(eventType, oldValue, specialization);
    notifier.notify(GenericRenderer.FeatureIDs.SPECIALIZATION, true, false, eventType, oldValue, specialization);
    afterContainmentNotify(eventType, oldValue, specialization);
  }

  @Override
  public FlushTransferBufferTask flushTransferBufferTask() {
    return flushTransferBufferTask;
  }

  @Override
  public void flushTransferBufferTask(final FlushTransferBufferTask flushTransferBufferTask) {
    final var oldValue = this.flushTransferBufferTask;
    final var eventType = flushTransferBufferTask == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.flushTransferBufferTask = flushTransferBufferTask;
    notifier.notify(GenericRenderer.FeatureIDs.FLUSH_TRANSFER_BUFFER_TASK, false, false, eventType, oldValue, flushTransferBufferTask);
  }

  @Override
  public boolean onePipelinePerPart() {
    return onePipelinePerPart;
  }

  @Override
  public void onePipelinePerPart(final boolean onePipelinePerPart) {
    final var oldValue = this.onePipelinePerPart;
    this.onePipelinePerPart = onePipelinePerPart;
    notifier.notifyBoolean(GenericRenderer.FeatureIDs.ONE_PIPELINE_PER_PART, false, false, oldValue, onePipelinePerPart);
  }

  @Override
  public boolean maintaining() {
    return maintaining;
  }

  @Override
  public void maintaining(final boolean maintaining) {
    final var oldValue = this.maintaining;
    this.maintaining = maintaining;
    notifier.notifyBoolean(GenericRenderer.FeatureIDs.MAINTAINING, false, false, oldValue, maintaining);
  }

  @Override
  public Group<MeshRenderer> lmGroup() {
    return MeshModelDefinition.Groups.MESH_RENDERER;
  }

  @Override
  protected FeatureSetter<MeshRenderer> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<MeshRenderer> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case MeshRenderer.FeatureIDs.MAINTAINED -> 0;
      case MeshRenderer.FeatureIDs.MAINTAINER -> 1;
      case MeshRenderer.FeatureIDs.RESOURCE_PKG -> 2;
      case MeshRenderer.FeatureIDs.DESCRIPTOR_PKG -> 3;
      case MeshRenderer.FeatureIDs.NAME -> 4;
      case MeshRenderer.FeatureIDs.ALLOCATE -> 5;
      case MeshRenderer.FeatureIDs.RECORD -> 6;
      case MeshRenderer.FeatureIDs.EXTENSION_PKG -> 7;
      case MeshRenderer.FeatureIDs.TASK_PKGS -> 8;
      case MeshRenderer.FeatureIDs.DESCRIPTOR_POOL -> 9;
      case MeshRenderer.FeatureIDs.SPECIALIZATION_DATA -> 10;
      case MeshRenderer.FeatureIDs.PUSH_CONSTANT_RANGES -> 11;
      case MeshRenderer.FeatureIDs.LAYOUT -> 12;
      case MeshRenderer.FeatureIDs.SHADERS -> 13;
      case MeshRenderer.FeatureIDs.VIEWPORT_STATE -> 14;
      case MeshRenderer.FeatureIDs.INPUT_ASSEMBLY -> 15;
      case MeshRenderer.FeatureIDs.RASTERIZER -> 16;
      case MeshRenderer.FeatureIDs.COLOR_BLEND -> 17;
      case MeshRenderer.FeatureIDs.DYNAMIC_STATE -> 18;
      case MeshRenderer.FeatureIDs.VERTEX_INPUT_STATE -> 19;
      case MeshRenderer.FeatureIDs.DEPTH_STENCIL_STATE -> 20;
      case MeshRenderer.FeatureIDs.DATA_PROVIDER_PKG -> 21;
      case MeshRenderer.FeatureIDs.RENDERED_STRUCTURES -> 22;
      case MeshRenderer.FeatureIDs.CONSTANT_BUFFER -> 23;
      case MeshRenderer.FeatureIDs.TRANSFER_BUFFER -> 24;
      case MeshRenderer.FeatureIDs.DESCRIPTOR_PROVIDER_PKG -> 25;
      case MeshRenderer.FeatureIDs.SPECIALIZATION -> 26;
      case MeshRenderer.FeatureIDs.FLUSH_TRANSFER_BUFFER_TASK -> 27;
      case MeshRenderer.FeatureIDs.ONE_PIPELINE_PER_PART -> 28;
      case MeshRenderer.FeatureIDs.MAINTAINING -> 29;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<MeshRenderer> GET_MAP = new FeatureGetter.Builder<MeshRenderer>(FEATURE_COUNT, MeshRendererImpl::featureIndexStatic).add(MeshRenderer.FeatureIDs.MAINTAINED, MeshRenderer::maintained).add(MeshRenderer.FeatureIDs.MAINTAINER, MeshRenderer::maintainer).add(MeshRenderer.FeatureIDs.RESOURCE_PKG, MeshRenderer::resourcePkg).add(MeshRenderer.FeatureIDs.DESCRIPTOR_PKG, MeshRenderer::descriptorPkg).add(MeshRenderer.FeatureIDs.NAME, MeshRenderer::name).add(MeshRenderer.FeatureIDs.ALLOCATE, MeshRenderer::allocate).add(MeshRenderer.FeatureIDs.RECORD, MeshRenderer::record).add(MeshRenderer.FeatureIDs.EXTENSION_PKG, MeshRenderer::extensionPkg).add(MeshRenderer.FeatureIDs.TASK_PKGS, MeshRenderer::taskPkgs).add(MeshRenderer.FeatureIDs.DESCRIPTOR_POOL, MeshRenderer::descriptorPool).add(MeshRenderer.FeatureIDs.SPECIALIZATION_DATA, MeshRenderer::specializationData).add(MeshRenderer.FeatureIDs.PUSH_CONSTANT_RANGES, MeshRenderer::pushConstantRanges).add(MeshRenderer.FeatureIDs.LAYOUT, MeshRenderer::layout).add(MeshRenderer.FeatureIDs.SHADERS, MeshRenderer::shaders).add(MeshRenderer.FeatureIDs.VIEWPORT_STATE, MeshRenderer::viewportState).add(MeshRenderer.FeatureIDs.INPUT_ASSEMBLY, MeshRenderer::inputAssembly).add(MeshRenderer.FeatureIDs.RASTERIZER, MeshRenderer::rasterizer).add(MeshRenderer.FeatureIDs.COLOR_BLEND, MeshRenderer::colorBlend).add(MeshRenderer.FeatureIDs.DYNAMIC_STATE, MeshRenderer::dynamicState).add(MeshRenderer.FeatureIDs.VERTEX_INPUT_STATE, MeshRenderer::vertexInputState).add(MeshRenderer.FeatureIDs.DEPTH_STENCIL_STATE, MeshRenderer::depthStencilState).add(MeshRenderer.FeatureIDs.DATA_PROVIDER_PKG, MeshRenderer::dataProviderPkg).add(MeshRenderer.FeatureIDs.RENDERED_STRUCTURES, MeshRenderer::renderedStructures).add(MeshRenderer.FeatureIDs.CONSTANT_BUFFER, MeshRenderer::constantBuffer).add(MeshRenderer.FeatureIDs.TRANSFER_BUFFER, MeshRenderer::transferBuffer).add(MeshRenderer.FeatureIDs.DESCRIPTOR_PROVIDER_PKG, MeshRenderer::descriptorProviderPkg).add(MeshRenderer.FeatureIDs.SPECIALIZATION, MeshRenderer::specialization).add(MeshRenderer.FeatureIDs.FLUSH_TRANSFER_BUFFER_TASK, MeshRenderer::flushTransferBufferTask).add(MeshRenderer.FeatureIDs.ONE_PIPELINE_PER_PART, MeshRenderer::onePipelinePerPart).add(MeshRenderer.FeatureIDs.MAINTAINING, MeshRenderer::maintaining).build();
    private static final FeatureSetter<MeshRenderer> SET_MAP = new FeatureSetter.Builder<MeshRenderer>(FEATURE_COUNT, MeshRendererImpl::featureIndexStatic).add(MeshRenderer.FeatureIDs.MAINTAINER, (object, value) -> ((MeshRendererImpl) object).maintainer((Maintainer<GraphicsPipeline>) value)).add(MeshRenderer.FeatureIDs.RESOURCE_PKG, (object, value) -> ((MeshRendererImpl) object).resourcePkg((VulkanResourcePkg) value)).add(MeshRenderer.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((MeshRendererImpl) object).descriptorPkg((DescriptorPkg) value)).add(MeshRenderer.FeatureIDs.ALLOCATE, (object, value) -> ((MeshRendererImpl) object).allocate((boolean) value)).add(MeshRenderer.FeatureIDs.RECORD, (object, value) -> ((MeshRendererImpl) object).record((boolean) value)).add(MeshRenderer.FeatureIDs.EXTENSION_PKG, (object, value) -> ((MeshRendererImpl) object).extensionPkg((PipelineExtensionPkg) value)).add(MeshRenderer.FeatureIDs.DESCRIPTOR_POOL, (object, value) -> ((MeshRendererImpl) object).descriptorPool((DescriptorPool) value)).add(MeshRenderer.FeatureIDs.SPECIALIZATION_DATA, (object, value) -> ((MeshRendererImpl) object).specializationData((ConstantBuffer) value)).add(MeshRenderer.FeatureIDs.VIEWPORT_STATE, (object, value) -> ((MeshRendererImpl) object).viewportState((ViewportState) value)).add(MeshRenderer.FeatureIDs.INPUT_ASSEMBLY, (object, value) -> ((MeshRendererImpl) object).inputAssembly((InputAssembly) value)).add(MeshRenderer.FeatureIDs.RASTERIZER, (object, value) -> ((MeshRendererImpl) object).rasterizer((Rasterizer) value)).add(MeshRenderer.FeatureIDs.COLOR_BLEND, (object, value) -> ((MeshRendererImpl) object).colorBlend((ColorBlend) value)).add(MeshRenderer.FeatureIDs.DYNAMIC_STATE, (object, value) -> ((MeshRendererImpl) object).dynamicState((DynamicState) value)).add(MeshRenderer.FeatureIDs.VERTEX_INPUT_STATE, (object, value) -> ((MeshRendererImpl) object).vertexInputState((VertexInputState) value)).add(MeshRenderer.FeatureIDs.DEPTH_STENCIL_STATE, (object, value) -> ((MeshRendererImpl) object).depthStencilState((DepthStencilState) value)).add(MeshRenderer.FeatureIDs.DATA_PROVIDER_PKG, (object, value) -> ((MeshRendererImpl) object).dataProviderPkg((DataProviderPkg<IMeshStructure>) value)).add(MeshRenderer.FeatureIDs.CONSTANT_BUFFER, (object, value) -> ((MeshRendererImpl) object).constantBuffer((ConstantBuffer) value)).add(MeshRenderer.FeatureIDs.TRANSFER_BUFFER, (object, value) -> ((MeshRendererImpl) object).transferBuffer((TransferBuffer) value)).add(MeshRenderer.FeatureIDs.DESCRIPTOR_PROVIDER_PKG, (object, value) -> ((MeshRendererImpl) object).descriptorProviderPkg((ResourceDescriptorProviderPkg) value)).add(MeshRenderer.FeatureIDs.SPECIALIZATION, (object, value) -> ((MeshRendererImpl) object).specialization((ISpecialization) value)).add(MeshRenderer.FeatureIDs.FLUSH_TRANSFER_BUFFER_TASK, (object, value) -> ((MeshRendererImpl) object).flushTransferBufferTask((FlushTransferBufferTask) value)).add(MeshRenderer.FeatureIDs.ONE_PIPELINE_PER_PART, (object, value) -> ((MeshRendererImpl) object).onePipelinePerPart((boolean) value)).add(MeshRenderer.FeatureIDs.MAINTAINING, (object, value) -> ((MeshRendererImpl) object).maintaining((boolean) value)).build();
  }
}
