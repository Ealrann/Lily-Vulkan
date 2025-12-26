package org.sheepy.lily.vulkan.model.process.graphic.impl;

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
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.VkPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicsPipeline;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
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

public final class GraphicsPipelineImpl extends FeaturedObject<GraphicsPipeline.Features<?>> implements GraphicsPipeline {
  private static final int FEATURE_COUNT = 20;
  private final ModelNotifier<GraphicsPipeline.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
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

  public GraphicsPipelineImpl(final String name, final List<Shader> shaders,
      final ViewportState viewportState, final InputAssembly inputAssembly,
      final Rasterizer rasterizer, final ColorBlend colorBlend,
      final VertexInputState vertexInputState) {
    this.name = name;
    this.shaders.addAll(shaders);
    this.viewportState = viewportState;
    this.inputAssembly = inputAssembly;
    this.rasterizer = rasterizer;
    this.colorBlend = colorBlend;
    this.vertexInputState = vertexInputState;
    setContainer(viewportState, GraphicsPipeline.FeatureIDs.VIEWPORT_STATE);
    setContainer(inputAssembly, GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY);
    setContainer(rasterizer, GraphicsPipeline.FeatureIDs.RASTERIZER);
    setContainer(colorBlend, GraphicsPipeline.FeatureIDs.COLOR_BLEND);
    setContainer(vertexInputState, GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GraphicsPipeline.Features<?>> notifier() {
    return notifier;
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
  public Group<GraphicsPipeline> lmGroup() {
    return GraphicModelDefinition.Groups.GRAPHICS_PIPELINE;
  }

  @Override
  protected FeatureSetter<GraphicsPipeline> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GraphicsPipeline> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GraphicsPipeline.FeatureIDs.MAINTAINER -> 0;
      case GraphicsPipeline.FeatureIDs.RESOURCE_PKG -> 1;
      case GraphicsPipeline.FeatureIDs.DESCRIPTOR_PKG -> 2;
      case GraphicsPipeline.FeatureIDs.NAME -> 3;
      case GraphicsPipeline.FeatureIDs.ALLOCATE -> 4;
      case GraphicsPipeline.FeatureIDs.RECORD -> 5;
      case GraphicsPipeline.FeatureIDs.EXTENSION_PKG -> 6;
      case GraphicsPipeline.FeatureIDs.TASK_PKGS -> 7;
      case GraphicsPipeline.FeatureIDs.DESCRIPTOR_POOL -> 8;
      case GraphicsPipeline.FeatureIDs.SPECIALIZATION_DATA -> 9;
      case GraphicsPipeline.FeatureIDs.PUSH_CONSTANT_RANGES -> 10;
      case GraphicsPipeline.FeatureIDs.LAYOUT -> 11;
      case GraphicsPipeline.FeatureIDs.SHADERS -> 12;
      case GraphicsPipeline.FeatureIDs.VIEWPORT_STATE -> 13;
      case GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY -> 14;
      case GraphicsPipeline.FeatureIDs.RASTERIZER -> 15;
      case GraphicsPipeline.FeatureIDs.COLOR_BLEND -> 16;
      case GraphicsPipeline.FeatureIDs.DYNAMIC_STATE -> 17;
      case GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE -> 18;
      case GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE -> 19;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GraphicsPipeline> GET_MAP = new FeatureGetter.Builder<GraphicsPipeline>(FEATURE_COUNT, GraphicsPipelineImpl::featureIndexStatic).add(GraphicsPipeline.FeatureIDs.MAINTAINER, GraphicsPipeline::maintainer).add(GraphicsPipeline.FeatureIDs.RESOURCE_PKG, GraphicsPipeline::resourcePkg).add(GraphicsPipeline.FeatureIDs.DESCRIPTOR_PKG, GraphicsPipeline::descriptorPkg).add(GraphicsPipeline.FeatureIDs.NAME, GraphicsPipeline::name).add(GraphicsPipeline.FeatureIDs.ALLOCATE, GraphicsPipeline::allocate).add(GraphicsPipeline.FeatureIDs.RECORD, GraphicsPipeline::record).add(GraphicsPipeline.FeatureIDs.EXTENSION_PKG, GraphicsPipeline::extensionPkg).add(GraphicsPipeline.FeatureIDs.TASK_PKGS, GraphicsPipeline::taskPkgs).add(GraphicsPipeline.FeatureIDs.DESCRIPTOR_POOL, GraphicsPipeline::descriptorPool).add(GraphicsPipeline.FeatureIDs.SPECIALIZATION_DATA, GraphicsPipeline::specializationData).add(GraphicsPipeline.FeatureIDs.PUSH_CONSTANT_RANGES, GraphicsPipeline::pushConstantRanges).add(GraphicsPipeline.FeatureIDs.LAYOUT, GraphicsPipeline::layout).add(GraphicsPipeline.FeatureIDs.SHADERS, GraphicsPipeline::shaders).add(GraphicsPipeline.FeatureIDs.VIEWPORT_STATE, GraphicsPipeline::viewportState).add(GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY, GraphicsPipeline::inputAssembly).add(GraphicsPipeline.FeatureIDs.RASTERIZER, GraphicsPipeline::rasterizer).add(GraphicsPipeline.FeatureIDs.COLOR_BLEND, GraphicsPipeline::colorBlend).add(GraphicsPipeline.FeatureIDs.DYNAMIC_STATE, GraphicsPipeline::dynamicState).add(GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE, GraphicsPipeline::vertexInputState).add(GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE, GraphicsPipeline::depthStencilState).build();
    private static final FeatureSetter<GraphicsPipeline> SET_MAP = new FeatureSetter.Builder<GraphicsPipeline>(FEATURE_COUNT, GraphicsPipelineImpl::featureIndexStatic).add(GraphicsPipeline.FeatureIDs.MAINTAINER, (object, value) -> ((GraphicsPipelineImpl) object).maintainer((Maintainer<GraphicsPipeline>) value)).add(GraphicsPipeline.FeatureIDs.RESOURCE_PKG, (object, value) -> ((GraphicsPipelineImpl) object).resourcePkg((VulkanResourcePkg) value)).add(GraphicsPipeline.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((GraphicsPipelineImpl) object).descriptorPkg((DescriptorPkg) value)).add(GraphicsPipeline.FeatureIDs.ALLOCATE, (object, value) -> ((GraphicsPipelineImpl) object).allocate((boolean) value)).add(GraphicsPipeline.FeatureIDs.RECORD, (object, value) -> ((GraphicsPipelineImpl) object).record((boolean) value)).add(GraphicsPipeline.FeatureIDs.EXTENSION_PKG, (object, value) -> ((GraphicsPipelineImpl) object).extensionPkg((PipelineExtensionPkg) value)).add(GraphicsPipeline.FeatureIDs.DESCRIPTOR_POOL, (object, value) -> ((GraphicsPipelineImpl) object).descriptorPool((DescriptorPool) value)).add(GraphicsPipeline.FeatureIDs.SPECIALIZATION_DATA, (object, value) -> ((GraphicsPipelineImpl) object).specializationData((ConstantBuffer) value)).add(GraphicsPipeline.FeatureIDs.VIEWPORT_STATE, (object, value) -> ((GraphicsPipelineImpl) object).viewportState((ViewportState) value)).add(GraphicsPipeline.FeatureIDs.INPUT_ASSEMBLY, (object, value) -> ((GraphicsPipelineImpl) object).inputAssembly((InputAssembly) value)).add(GraphicsPipeline.FeatureIDs.RASTERIZER, (object, value) -> ((GraphicsPipelineImpl) object).rasterizer((Rasterizer) value)).add(GraphicsPipeline.FeatureIDs.COLOR_BLEND, (object, value) -> ((GraphicsPipelineImpl) object).colorBlend((ColorBlend) value)).add(GraphicsPipeline.FeatureIDs.DYNAMIC_STATE, (object, value) -> ((GraphicsPipelineImpl) object).dynamicState((DynamicState) value)).add(GraphicsPipeline.FeatureIDs.VERTEX_INPUT_STATE, (object, value) -> ((GraphicsPipelineImpl) object).vertexInputState((VertexInputState) value)).add(GraphicsPipeline.FeatureIDs.DEPTH_STENCIL_STATE, (object, value) -> ((GraphicsPipelineImpl) object).depthStencilState((DepthStencilState) value)).build();
  }
}
