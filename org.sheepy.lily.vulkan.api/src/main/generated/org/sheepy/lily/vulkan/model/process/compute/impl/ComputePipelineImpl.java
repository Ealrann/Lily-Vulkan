package org.sheepy.lily.vulkan.model.process.compute.impl;

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
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelDefinition;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public final class ComputePipelineImpl extends FeaturedObject<ComputePipeline.Features<?>> implements ComputePipeline {
  private static final int FEATURE_COUNT = 13;
  private final ModelNotifier<ComputePipeline.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Maintainer<ComputePipeline> maintainer;
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
  private Shader shader;

  public ComputePipelineImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ComputePipeline.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Maintainer<ComputePipeline> maintainer() {
    return maintainer;
  }

  @Override
  public void maintainer(final Maintainer<ComputePipeline> maintainer) {
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
  public Shader shader() {
    return shader;
  }

  @Override
  public void shader(final Shader shader) {
    final var oldValue = this.shader;
    final var eventType = shader == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.shader = shader;
    notifier.notify(ComputePipeline.FeatureIDs.SHADER, false, false, eventType, oldValue, shader);
  }

  @Override
  public Group<ComputePipeline> lmGroup() {
    return ComputeModelDefinition.Groups.COMPUTE_PIPELINE;
  }

  @Override
  protected FeatureSetter<ComputePipeline> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ComputePipeline> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ComputePipeline.FeatureIDs.MAINTAINER -> 0;
      case ComputePipeline.FeatureIDs.RESOURCE_PKG -> 1;
      case ComputePipeline.FeatureIDs.DESCRIPTOR_PKG -> 2;
      case ComputePipeline.FeatureIDs.NAME -> 3;
      case ComputePipeline.FeatureIDs.ALLOCATE -> 4;
      case ComputePipeline.FeatureIDs.RECORD -> 5;
      case ComputePipeline.FeatureIDs.EXTENSION_PKG -> 6;
      case ComputePipeline.FeatureIDs.TASK_PKGS -> 7;
      case ComputePipeline.FeatureIDs.DESCRIPTOR_POOL -> 8;
      case ComputePipeline.FeatureIDs.SPECIALIZATION_DATA -> 9;
      case ComputePipeline.FeatureIDs.PUSH_CONSTANT_RANGES -> 10;
      case ComputePipeline.FeatureIDs.LAYOUT -> 11;
      case ComputePipeline.FeatureIDs.SHADER -> 12;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ComputePipeline> GET_MAP = new FeatureGetter.Builder<ComputePipeline>(FEATURE_COUNT, ComputePipelineImpl::featureIndexStatic).add(ComputePipeline.FeatureIDs.MAINTAINER, ComputePipeline::maintainer).add(ComputePipeline.FeatureIDs.RESOURCE_PKG, ComputePipeline::resourcePkg).add(ComputePipeline.FeatureIDs.DESCRIPTOR_PKG, ComputePipeline::descriptorPkg).add(ComputePipeline.FeatureIDs.NAME, ComputePipeline::name).add(ComputePipeline.FeatureIDs.ALLOCATE, ComputePipeline::allocate).add(ComputePipeline.FeatureIDs.RECORD, ComputePipeline::record).add(ComputePipeline.FeatureIDs.EXTENSION_PKG, ComputePipeline::extensionPkg).add(ComputePipeline.FeatureIDs.TASK_PKGS, ComputePipeline::taskPkgs).add(ComputePipeline.FeatureIDs.DESCRIPTOR_POOL, ComputePipeline::descriptorPool).add(ComputePipeline.FeatureIDs.SPECIALIZATION_DATA, ComputePipeline::specializationData).add(ComputePipeline.FeatureIDs.PUSH_CONSTANT_RANGES, ComputePipeline::pushConstantRanges).add(ComputePipeline.FeatureIDs.LAYOUT, ComputePipeline::layout).add(ComputePipeline.FeatureIDs.SHADER, ComputePipeline::shader).build();
    private static final FeatureSetter<ComputePipeline> SET_MAP = new FeatureSetter.Builder<ComputePipeline>(FEATURE_COUNT, ComputePipelineImpl::featureIndexStatic).add(ComputePipeline.FeatureIDs.MAINTAINER, (object, value) -> ((ComputePipelineImpl) object).maintainer((Maintainer<ComputePipeline>) value)).add(ComputePipeline.FeatureIDs.RESOURCE_PKG, (object, value) -> ((ComputePipelineImpl) object).resourcePkg((VulkanResourcePkg) value)).add(ComputePipeline.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((ComputePipelineImpl) object).descriptorPkg((DescriptorPkg) value)).add(ComputePipeline.FeatureIDs.ALLOCATE, (object, value) -> ((ComputePipelineImpl) object).allocate((boolean) value)).add(ComputePipeline.FeatureIDs.RECORD, (object, value) -> ((ComputePipelineImpl) object).record((boolean) value)).add(ComputePipeline.FeatureIDs.EXTENSION_PKG, (object, value) -> ((ComputePipelineImpl) object).extensionPkg((PipelineExtensionPkg) value)).add(ComputePipeline.FeatureIDs.DESCRIPTOR_POOL, (object, value) -> ((ComputePipelineImpl) object).descriptorPool((DescriptorPool) value)).add(ComputePipeline.FeatureIDs.SPECIALIZATION_DATA, (object, value) -> ((ComputePipelineImpl) object).specializationData((ConstantBuffer) value)).add(ComputePipeline.FeatureIDs.SHADER, (object, value) -> ((ComputePipelineImpl) object).shader((Shader) value)).build();
  }
}
