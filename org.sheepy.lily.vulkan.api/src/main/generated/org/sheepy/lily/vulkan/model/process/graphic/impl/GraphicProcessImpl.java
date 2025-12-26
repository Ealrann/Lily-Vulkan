package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;

public final class GraphicProcessImpl extends FeaturedObject<GraphicProcess.Features<?>> implements GraphicProcess {
  private static final int FEATURE_COUNT = 15;
  private final ModelNotifier<GraphicProcess.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private Maintainer<GraphicProcess> maintainer;
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
  private GraphicConfiguration configuration;
  private AttachmentPkg attachmentPkg;
  private final List<Subpass> subpasses = newObservableList(GraphicProcess.FeatureIDs.SUBPASSES, true, true);

  public GraphicProcessImpl(final String name, final float queuePriority,
      final ProcessExecutionManager executionManager, final GraphicConfiguration configuration,
      final AttachmentPkg attachmentPkg) {
    this.name = name;
    this.queuePriority = queuePriority;
    this.executionManager = executionManager;
    this.configuration = configuration;
    this.attachmentPkg = attachmentPkg;
    setContainer(executionManager, AbstractProcess.FeatureIDs.EXECUTION_MANAGER);
    setContainer(configuration, GraphicProcess.FeatureIDs.CONFIGURATION);
    setContainer(attachmentPkg, GraphicProcess.FeatureIDs.ATTACHMENT_PKG);
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<GraphicProcess.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public Maintainer<GraphicProcess> maintainer() {
    return maintainer;
  }

  @Override
  public void maintainer(final Maintainer<GraphicProcess> maintainer) {
    final var oldValue = this.maintainer;
    final var eventType = maintainer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.maintainer = maintainer;
    notifier.notify(Maintainable.FeatureIDs.MAINTAINER, false, false, eventType, oldValue, maintainer);
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
  public GraphicConfiguration configuration() {
    return configuration;
  }

  @Override
  public void configuration(final GraphicConfiguration configuration) {
    final var oldValue = this.configuration;
    final var eventType = configuration == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.configuration = configuration;
    setContainer(configuration, GraphicProcess.FeatureIDs.CONFIGURATION);
    beforeContainmentNotify(eventType, oldValue, configuration);
    notifier.notify(GraphicProcess.FeatureIDs.CONFIGURATION, true, false, eventType, oldValue, configuration);
    afterContainmentNotify(eventType, oldValue, configuration);
  }

  @Override
  public AttachmentPkg attachmentPkg() {
    return attachmentPkg;
  }

  @Override
  public void attachmentPkg(final AttachmentPkg attachmentPkg) {
    final var oldValue = this.attachmentPkg;
    final var eventType = attachmentPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.attachmentPkg = attachmentPkg;
    setContainer(attachmentPkg, GraphicProcess.FeatureIDs.ATTACHMENT_PKG);
    beforeContainmentNotify(eventType, oldValue, attachmentPkg);
    notifier.notify(GraphicProcess.FeatureIDs.ATTACHMENT_PKG, true, false, eventType, oldValue, attachmentPkg);
    afterContainmentNotify(eventType, oldValue, attachmentPkg);
  }

  @Override
  public List<Subpass> subpasses() {
    return subpasses;
  }

  @Override
  public Group<GraphicProcess> lmGroup() {
    return GraphicModelDefinition.Groups.GRAPHIC_PROCESS;
  }

  @Override
  protected FeatureSetter<GraphicProcess> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<GraphicProcess> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case GraphicProcess.FeatureIDs.MAINTAINER -> 0;
      case GraphicProcess.FeatureIDs.NAME -> 1;
      case GraphicProcess.FeatureIDs.RESOURCE_PKG -> 2;
      case GraphicProcess.FeatureIDs.DESCRIPTOR_PKG -> 3;
      case GraphicProcess.FeatureIDs.ENABLED -> 4;
      case GraphicProcess.FeatureIDs.QUEUE_PRIORITY -> 5;
      case GraphicProcess.FeatureIDs.CADENCE -> 6;
      case GraphicProcess.FeatureIDs.DESCRIPTOR_POOL -> 7;
      case GraphicProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE -> 8;
      case GraphicProcess.FeatureIDs.RESET_ALLOWED -> 9;
      case GraphicProcess.FeatureIDs.EXTENSION_PKG -> 10;
      case GraphicProcess.FeatureIDs.EXECUTION_MANAGER -> 11;
      case GraphicProcess.FeatureIDs.CONFIGURATION -> 12;
      case GraphicProcess.FeatureIDs.ATTACHMENT_PKG -> 13;
      case GraphicProcess.FeatureIDs.SUBPASSES -> 14;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<GraphicProcess> GET_MAP = new FeatureGetter.Builder<GraphicProcess>(FEATURE_COUNT, GraphicProcessImpl::featureIndexStatic).add(GraphicProcess.FeatureIDs.MAINTAINER, GraphicProcess::maintainer).add(GraphicProcess.FeatureIDs.NAME, GraphicProcess::name).add(GraphicProcess.FeatureIDs.RESOURCE_PKG, GraphicProcess::resourcePkg).add(GraphicProcess.FeatureIDs.DESCRIPTOR_PKG, GraphicProcess::descriptorPkg).add(GraphicProcess.FeatureIDs.ENABLED, GraphicProcess::enabled).add(GraphicProcess.FeatureIDs.QUEUE_PRIORITY, GraphicProcess::queuePriority).add(GraphicProcess.FeatureIDs.CADENCE, GraphicProcess::cadence).add(GraphicProcess.FeatureIDs.DESCRIPTOR_POOL, GraphicProcess::descriptorPool).add(GraphicProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE, GraphicProcess::waitingFenceDuringAcquire).add(GraphicProcess.FeatureIDs.RESET_ALLOWED, GraphicProcess::resetAllowed).add(GraphicProcess.FeatureIDs.EXTENSION_PKG, GraphicProcess::extensionPkg).add(GraphicProcess.FeatureIDs.EXECUTION_MANAGER, GraphicProcess::executionManager).add(GraphicProcess.FeatureIDs.CONFIGURATION, GraphicProcess::configuration).add(GraphicProcess.FeatureIDs.ATTACHMENT_PKG, GraphicProcess::attachmentPkg).add(GraphicProcess.FeatureIDs.SUBPASSES, GraphicProcess::subpasses).build();
    private static final FeatureSetter<GraphicProcess> SET_MAP = new FeatureSetter.Builder<GraphicProcess>(FEATURE_COUNT, GraphicProcessImpl::featureIndexStatic).add(GraphicProcess.FeatureIDs.MAINTAINER, (object, value) -> ((GraphicProcessImpl) object).maintainer((Maintainer<GraphicProcess>) value)).add(GraphicProcess.FeatureIDs.RESOURCE_PKG, (object, value) -> ((GraphicProcessImpl) object).resourcePkg((VulkanResourcePkg) value)).add(GraphicProcess.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((GraphicProcessImpl) object).descriptorPkg((DescriptorPkg) value)).add(GraphicProcess.FeatureIDs.ENABLED, (object, value) -> ((GraphicProcessImpl) object).enabled((boolean) value)).add(GraphicProcess.FeatureIDs.QUEUE_PRIORITY, (object, value) -> ((GraphicProcessImpl) object).queuePriority((float) value)).add(GraphicProcess.FeatureIDs.CADENCE, (object, value) -> ((GraphicProcessImpl) object).cadence((ICadence) value)).add(GraphicProcess.FeatureIDs.DESCRIPTOR_POOL, (object, value) -> ((GraphicProcessImpl) object).descriptorPool((DescriptorPool) value)).add(GraphicProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE, (object, value) -> ((GraphicProcessImpl) object).waitingFenceDuringAcquire((boolean) value)).add(GraphicProcess.FeatureIDs.RESET_ALLOWED, (object, value) -> ((GraphicProcessImpl) object).resetAllowed((boolean) value)).add(GraphicProcess.FeatureIDs.EXTENSION_PKG, (object, value) -> ((GraphicProcessImpl) object).extensionPkg((ProcessExtensionPkg) value)).add(GraphicProcess.FeatureIDs.EXECUTION_MANAGER, (object, value) -> ((GraphicProcessImpl) object).executionManager((ProcessExecutionManager) value)).add(GraphicProcess.FeatureIDs.CONFIGURATION, (object, value) -> ((GraphicProcessImpl) object).configuration((GraphicConfiguration) value)).add(GraphicProcess.FeatureIDs.ATTACHMENT_PKG, (object, value) -> ((GraphicProcessImpl) object).attachmentPkg((AttachmentPkg) value)).build();
  }
}
