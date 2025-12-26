package org.sheepy.lily.vulkan.model.process.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;

public final class PipelineImpl extends FeaturedObject<Pipeline.Features<?>> implements Pipeline {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<Pipeline.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private VulkanResourcePkg resourcePkg;
  private DescriptorPkg descriptorPkg;
  private final String name;
  private boolean allocate;
  private boolean record;
  private PipelineExtensionPkg extensionPkg;
  private final List<TaskPkg> taskPkgs = newObservableList(TaskPipeline.FeatureIDs.TASK_PKGS, true, true);

  public PipelineImpl(final String name) {
    this.name = name;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Pipeline.Features<?>> notifier() {
    return notifier;
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
  public Group<Pipeline> lmGroup() {
    return ProcessModelDefinition.Groups.PIPELINE;
  }

  @Override
  protected FeatureSetter<Pipeline> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Pipeline> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Pipeline.FeatureIDs.RESOURCE_PKG -> 0;
      case Pipeline.FeatureIDs.DESCRIPTOR_PKG -> 1;
      case Pipeline.FeatureIDs.NAME -> 2;
      case Pipeline.FeatureIDs.ALLOCATE -> 3;
      case Pipeline.FeatureIDs.RECORD -> 4;
      case Pipeline.FeatureIDs.EXTENSION_PKG -> 5;
      case Pipeline.FeatureIDs.TASK_PKGS -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Pipeline> GET_MAP = new FeatureGetter.Builder<Pipeline>(FEATURE_COUNT, PipelineImpl::featureIndexStatic).add(Pipeline.FeatureIDs.RESOURCE_PKG, Pipeline::resourcePkg).add(Pipeline.FeatureIDs.DESCRIPTOR_PKG, Pipeline::descriptorPkg).add(Pipeline.FeatureIDs.NAME, Pipeline::name).add(Pipeline.FeatureIDs.ALLOCATE, Pipeline::allocate).add(Pipeline.FeatureIDs.RECORD, Pipeline::record).add(Pipeline.FeatureIDs.EXTENSION_PKG, Pipeline::extensionPkg).add(Pipeline.FeatureIDs.TASK_PKGS, Pipeline::taskPkgs).build();
    private static final FeatureSetter<Pipeline> SET_MAP = new FeatureSetter.Builder<Pipeline>(FEATURE_COUNT, PipelineImpl::featureIndexStatic).add(Pipeline.FeatureIDs.RESOURCE_PKG, (object, value) -> ((PipelineImpl) object).resourcePkg((VulkanResourcePkg) value)).add(Pipeline.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((PipelineImpl) object).descriptorPkg((DescriptorPkg) value)).add(Pipeline.FeatureIDs.ALLOCATE, (object, value) -> ((PipelineImpl) object).allocate((boolean) value)).add(Pipeline.FeatureIDs.RECORD, (object, value) -> ((PipelineImpl) object).record((boolean) value)).add(Pipeline.FeatureIDs.EXTENSION_PKG, (object, value) -> ((PipelineImpl) object).extensionPkg((PipelineExtensionPkg) value)).build();
  }
}
