package org.sheepy.lily.vulkan.model.process.compute.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputeModelDefinition;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;

public final class ComputeProcessImpl extends FeaturedObject<ComputeProcess.Features<?>> implements ComputeProcess {
  private static final int FEATURE_COUNT = 14;
  private final ModelNotifier<ComputeProcess.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private VulkanResourcePkg resourcePkg;
  private DescriptorPkg descriptorPkg;
  private boolean enabled;
  private float queuePriority;
  private ICadence cadence;
  private DescriptorPool descriptorPool;
  private boolean waitingFenceDuringAcquire;
  private boolean resetAllowed;
  private ProcessExtensionPkg extensionPkg;
  private ProcessExecutionManager executionManager;
  private PipelinePkg pipelinePkg;
  private IEngine sourceEngine;
  private ComputeConfiguration configuration;

  public ComputeProcessImpl(final String name, final float queuePriority,
      final ProcessExecutionManager executionManager, final ComputeConfiguration configuration) {
    this.name = name;
    this.queuePriority = queuePriority;
    this.executionManager = executionManager;
    this.configuration = configuration;
    setContainer(executionManager, AbstractProcess.FeatureIDs.EXECUTION_MANAGER);
    setContainer(configuration, ComputeProcess.FeatureIDs.CONFIGURATION);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ComputeProcess.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
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
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(IProcess.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public float queuePriority() {
    return queuePriority;
  }

  @Override
  public void queuePriority(final float queuePriority) {
    final var oldValue = this.queuePriority;
    this.queuePriority = queuePriority;
    notifier.notifyFloat(IProcess.FeatureIDs.QUEUE_PRIORITY, false, false, oldValue, queuePriority);
  }

  @Override
  public ICadence cadence() {
    return cadence;
  }

  @Override
  public void cadence(final ICadence cadence) {
    final var oldValue = this.cadence;
    final var eventType = cadence == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.cadence = cadence;
    setContainer(cadence, IProcess.FeatureIDs.CADENCE);
    beforeContainmentNotify(eventType, oldValue, cadence);
    notifier.notify(IProcess.FeatureIDs.CADENCE, true, false, eventType, oldValue, cadence);
    afterContainmentNotify(eventType, oldValue, cadence);
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
    setContainer(descriptorPool, AbstractProcess.FeatureIDs.DESCRIPTOR_POOL);
    beforeContainmentNotify(eventType, oldValue, descriptorPool);
    notifier.notify(AbstractProcess.FeatureIDs.DESCRIPTOR_POOL, true, false, eventType, oldValue, descriptorPool);
    afterContainmentNotify(eventType, oldValue, descriptorPool);
  }

  @Override
  public boolean waitingFenceDuringAcquire() {
    return waitingFenceDuringAcquire;
  }

  @Override
  public void waitingFenceDuringAcquire(final boolean waitingFenceDuringAcquire) {
    final var oldValue = this.waitingFenceDuringAcquire;
    this.waitingFenceDuringAcquire = waitingFenceDuringAcquire;
    notifier.notifyBoolean(AbstractProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE, false, false, oldValue, waitingFenceDuringAcquire);
  }

  @Override
  public boolean resetAllowed() {
    return resetAllowed;
  }

  @Override
  public void resetAllowed(final boolean resetAllowed) {
    final var oldValue = this.resetAllowed;
    this.resetAllowed = resetAllowed;
    notifier.notifyBoolean(AbstractProcess.FeatureIDs.RESET_ALLOWED, false, false, oldValue, resetAllowed);
  }

  @Override
  public ProcessExtensionPkg extensionPkg() {
    return extensionPkg;
  }

  @Override
  public void extensionPkg(final ProcessExtensionPkg extensionPkg) {
    final var oldValue = this.extensionPkg;
    final var eventType = extensionPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.extensionPkg = extensionPkg;
    setContainer(extensionPkg, AbstractProcess.FeatureIDs.EXTENSION_PKG);
    beforeContainmentNotify(eventType, oldValue, extensionPkg);
    notifier.notify(AbstractProcess.FeatureIDs.EXTENSION_PKG, true, false, eventType, oldValue, extensionPkg);
    afterContainmentNotify(eventType, oldValue, extensionPkg);
  }

  @Override
  public ProcessExecutionManager executionManager() {
    return executionManager;
  }

  @Override
  public void executionManager(final ProcessExecutionManager executionManager) {
    final var oldValue = this.executionManager;
    final var eventType = executionManager == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.executionManager = executionManager;
    setContainer(executionManager, AbstractProcess.FeatureIDs.EXECUTION_MANAGER);
    beforeContainmentNotify(eventType, oldValue, executionManager);
    notifier.notify(AbstractProcess.FeatureIDs.EXECUTION_MANAGER, true, false, eventType, oldValue, executionManager);
    afterContainmentNotify(eventType, oldValue, executionManager);
  }

  @Override
  public PipelinePkg pipelinePkg() {
    return pipelinePkg;
  }

  @Override
  public void pipelinePkg(final PipelinePkg pipelinePkg) {
    final var oldValue = this.pipelinePkg;
    final var eventType = pipelinePkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.pipelinePkg = pipelinePkg;
    setContainer(pipelinePkg, ComputeProcess.FeatureIDs.PIPELINE_PKG);
    beforeContainmentNotify(eventType, oldValue, pipelinePkg);
    notifier.notify(ComputeProcess.FeatureIDs.PIPELINE_PKG, true, false, eventType, oldValue, pipelinePkg);
    afterContainmentNotify(eventType, oldValue, pipelinePkg);
  }

  @Override
  public IEngine sourceEngine() {
    return sourceEngine;
  }

  @Override
  public void sourceEngine(final IEngine sourceEngine) {
    final var oldValue = this.sourceEngine;
    final var eventType = sourceEngine == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.sourceEngine = sourceEngine;
    notifier.notify(ComputeProcess.FeatureIDs.SOURCE_ENGINE, false, false, eventType, oldValue, sourceEngine);
  }

  @Override
  public ComputeConfiguration configuration() {
    return configuration;
  }

  @Override
  public void configuration(final ComputeConfiguration configuration) {
    final var oldValue = this.configuration;
    final var eventType = configuration == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.configuration = configuration;
    setContainer(configuration, ComputeProcess.FeatureIDs.CONFIGURATION);
    beforeContainmentNotify(eventType, oldValue, configuration);
    notifier.notify(ComputeProcess.FeatureIDs.CONFIGURATION, true, false, eventType, oldValue, configuration);
    afterContainmentNotify(eventType, oldValue, configuration);
  }

  @Override
  public Group<ComputeProcess> lmGroup() {
    return ComputeModelDefinition.Groups.COMPUTE_PROCESS;
  }

  @Override
  protected FeatureSetter<ComputeProcess> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ComputeProcess> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ComputeProcess.FeatureIDs.NAME -> 0;
      case ComputeProcess.FeatureIDs.RESOURCE_PKG -> 1;
      case ComputeProcess.FeatureIDs.DESCRIPTOR_PKG -> 2;
      case ComputeProcess.FeatureIDs.ENABLED -> 3;
      case ComputeProcess.FeatureIDs.QUEUE_PRIORITY -> 4;
      case ComputeProcess.FeatureIDs.CADENCE -> 5;
      case ComputeProcess.FeatureIDs.DESCRIPTOR_POOL -> 6;
      case ComputeProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE -> 7;
      case ComputeProcess.FeatureIDs.RESET_ALLOWED -> 8;
      case ComputeProcess.FeatureIDs.EXTENSION_PKG -> 9;
      case ComputeProcess.FeatureIDs.EXECUTION_MANAGER -> 10;
      case ComputeProcess.FeatureIDs.PIPELINE_PKG -> 11;
      case ComputeProcess.FeatureIDs.SOURCE_ENGINE -> 12;
      case ComputeProcess.FeatureIDs.CONFIGURATION -> 13;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ComputeProcess> GET_MAP = new FeatureGetter.Builder<ComputeProcess>(FEATURE_COUNT, ComputeProcessImpl::featureIndexStatic).add(ComputeProcess.FeatureIDs.NAME, ComputeProcess::name).add(ComputeProcess.FeatureIDs.RESOURCE_PKG, ComputeProcess::resourcePkg).add(ComputeProcess.FeatureIDs.DESCRIPTOR_PKG, ComputeProcess::descriptorPkg).add(ComputeProcess.FeatureIDs.ENABLED, ComputeProcess::enabled).add(ComputeProcess.FeatureIDs.QUEUE_PRIORITY, ComputeProcess::queuePriority).add(ComputeProcess.FeatureIDs.CADENCE, ComputeProcess::cadence).add(ComputeProcess.FeatureIDs.DESCRIPTOR_POOL, ComputeProcess::descriptorPool).add(ComputeProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE, ComputeProcess::waitingFenceDuringAcquire).add(ComputeProcess.FeatureIDs.RESET_ALLOWED, ComputeProcess::resetAllowed).add(ComputeProcess.FeatureIDs.EXTENSION_PKG, ComputeProcess::extensionPkg).add(ComputeProcess.FeatureIDs.EXECUTION_MANAGER, ComputeProcess::executionManager).add(ComputeProcess.FeatureIDs.PIPELINE_PKG, ComputeProcess::pipelinePkg).add(ComputeProcess.FeatureIDs.SOURCE_ENGINE, ComputeProcess::sourceEngine).add(ComputeProcess.FeatureIDs.CONFIGURATION, ComputeProcess::configuration).build();
    private static final FeatureSetter<ComputeProcess> SET_MAP = new FeatureSetter.Builder<ComputeProcess>(FEATURE_COUNT, ComputeProcessImpl::featureIndexStatic).add(ComputeProcess.FeatureIDs.RESOURCE_PKG, (object, value) -> ((ComputeProcessImpl) object).resourcePkg((VulkanResourcePkg) value)).add(ComputeProcess.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((ComputeProcessImpl) object).descriptorPkg((DescriptorPkg) value)).add(ComputeProcess.FeatureIDs.ENABLED, (object, value) -> ((ComputeProcessImpl) object).enabled((boolean) value)).add(ComputeProcess.FeatureIDs.QUEUE_PRIORITY, (object, value) -> ((ComputeProcessImpl) object).queuePriority((float) value)).add(ComputeProcess.FeatureIDs.CADENCE, (object, value) -> ((ComputeProcessImpl) object).cadence((ICadence) value)).add(ComputeProcess.FeatureIDs.DESCRIPTOR_POOL, (object, value) -> ((ComputeProcessImpl) object).descriptorPool((DescriptorPool) value)).add(ComputeProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE, (object, value) -> ((ComputeProcessImpl) object).waitingFenceDuringAcquire((boolean) value)).add(ComputeProcess.FeatureIDs.RESET_ALLOWED, (object, value) -> ((ComputeProcessImpl) object).resetAllowed((boolean) value)).add(ComputeProcess.FeatureIDs.EXTENSION_PKG, (object, value) -> ((ComputeProcessImpl) object).extensionPkg((ProcessExtensionPkg) value)).add(ComputeProcess.FeatureIDs.EXECUTION_MANAGER, (object, value) -> ((ComputeProcessImpl) object).executionManager((ProcessExecutionManager) value)).add(ComputeProcess.FeatureIDs.PIPELINE_PKG, (object, value) -> ((ComputeProcessImpl) object).pipelinePkg((PipelinePkg) value)).add(ComputeProcess.FeatureIDs.SOURCE_ENGINE, (object, value) -> ((ComputeProcessImpl) object).sourceEngine((IEngine) value)).add(ComputeProcess.FeatureIDs.CONFIGURATION, (object, value) -> ((ComputeProcessImpl) object).configuration((ComputeConfiguration) value)).build();
  }
}
