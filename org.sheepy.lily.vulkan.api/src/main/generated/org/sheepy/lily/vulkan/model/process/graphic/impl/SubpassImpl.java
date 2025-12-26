package org.sheepy.lily.vulkan.model.process.graphic.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.core.model.application.ICompositor;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

public final class SubpassImpl extends FeaturedObject<Subpass.Features<?>> implements Subpass {
  private static final int FEATURE_COUNT = 17;
  private final ModelNotifier<Subpass.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private VulkanResourcePkg resourcePkg;
  private DescriptorPkg descriptorPkg;
  private AttachmentRefPkg attachmentRefPkg;
  private AttachmentPkg attachmentPkg;
  private int subpassIndex;
  private PipelinePkg pipelinePkg;
  private int bindPoint;
  private ICompositor compositor;
  private EPipelineStage waitForStage;
  private EPipelineStage syncStage;
  private EPipelineStage finishStage;
  private final List<EAccess> waitForAccesses = newObservableList(Subpass.FeatureIDs.WAIT_FOR_ACCESSES, false, false);
  private final List<EAccess> syncAccesses = newObservableList(Subpass.FeatureIDs.SYNC_ACCESSES, false, false);
  private final List<EAccess> finishAccesses = newObservableList(Subpass.FeatureIDs.FINISH_ACCESSES, false, false);
  private ProcessExtensionPkg extensionPkg;
  private boolean enabled;

  public SubpassImpl(final String name, final int subpassIndex, final int bindPoint,
      final EPipelineStage waitForStage, final EPipelineStage syncStage,
      final EPipelineStage finishStage, final boolean enabled) {
    this.name = name;
    this.subpassIndex = subpassIndex;
    this.bindPoint = bindPoint;
    this.waitForStage = waitForStage;
    this.syncStage = syncStage;
    this.finishStage = finishStage;
    this.enabled = enabled;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<Subpass.Features<?>> notifier() {
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
  public AttachmentRefPkg attachmentRefPkg() {
    return attachmentRefPkg;
  }

  @Override
  public void attachmentRefPkg(final AttachmentRefPkg attachmentRefPkg) {
    final var oldValue = this.attachmentRefPkg;
    final var eventType = attachmentRefPkg == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.attachmentRefPkg = attachmentRefPkg;
    setContainer(attachmentRefPkg, Subpass.FeatureIDs.ATTACHMENT_REF_PKG);
    beforeContainmentNotify(eventType, oldValue, attachmentRefPkg);
    notifier.notify(Subpass.FeatureIDs.ATTACHMENT_REF_PKG, true, false, eventType, oldValue, attachmentRefPkg);
    afterContainmentNotify(eventType, oldValue, attachmentRefPkg);
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
    setContainer(attachmentPkg, Subpass.FeatureIDs.ATTACHMENT_PKG);
    beforeContainmentNotify(eventType, oldValue, attachmentPkg);
    notifier.notify(Subpass.FeatureIDs.ATTACHMENT_PKG, true, false, eventType, oldValue, attachmentPkg);
    afterContainmentNotify(eventType, oldValue, attachmentPkg);
  }

  @Override
  public int subpassIndex() {
    return subpassIndex;
  }

  @Override
  public void subpassIndex(final int subpassIndex) {
    final var oldValue = this.subpassIndex;
    this.subpassIndex = subpassIndex;
    notifier.notifyInt(Subpass.FeatureIDs.SUBPASS_INDEX, false, false, oldValue, subpassIndex);
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
    setContainer(pipelinePkg, Subpass.FeatureIDs.PIPELINE_PKG);
    beforeContainmentNotify(eventType, oldValue, pipelinePkg);
    notifier.notify(Subpass.FeatureIDs.PIPELINE_PKG, true, false, eventType, oldValue, pipelinePkg);
    afterContainmentNotify(eventType, oldValue, pipelinePkg);
  }

  @Override
  public int bindPoint() {
    return bindPoint;
  }

  @Override
  public void bindPoint(final int bindPoint) {
    final var oldValue = this.bindPoint;
    this.bindPoint = bindPoint;
    notifier.notifyInt(Subpass.FeatureIDs.BIND_POINT, false, false, oldValue, bindPoint);
  }

  @Override
  public ICompositor compositor() {
    return compositor;
  }

  @Override
  public void compositor(final ICompositor compositor) {
    final var oldValue = this.compositor;
    final var eventType = compositor == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.compositor = compositor;
    notifier.notify(Subpass.FeatureIDs.COMPOSITOR, false, false, eventType, oldValue, compositor);
  }

  @Override
  public EPipelineStage waitForStage() {
    return waitForStage;
  }

  @Override
  public void waitForStage(final EPipelineStage waitForStage) {
    final var oldValue = this.waitForStage;
    this.waitForStage = waitForStage;
    notifier.notify(Subpass.FeatureIDs.WAIT_FOR_STAGE, false, false, oldValue, waitForStage);
  }

  @Override
  public EPipelineStage syncStage() {
    return syncStage;
  }

  @Override
  public void syncStage(final EPipelineStage syncStage) {
    final var oldValue = this.syncStage;
    this.syncStage = syncStage;
    notifier.notify(Subpass.FeatureIDs.SYNC_STAGE, false, false, oldValue, syncStage);
  }

  @Override
  public EPipelineStage finishStage() {
    return finishStage;
  }

  @Override
  public void finishStage(final EPipelineStage finishStage) {
    final var oldValue = this.finishStage;
    this.finishStage = finishStage;
    notifier.notify(Subpass.FeatureIDs.FINISH_STAGE, false, false, oldValue, finishStage);
  }

  @Override
  public List<EAccess> waitForAccesses() {
    return waitForAccesses;
  }

  @Override
  public List<EAccess> syncAccesses() {
    return syncAccesses;
  }

  @Override
  public List<EAccess> finishAccesses() {
    return finishAccesses;
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
    setContainer(extensionPkg, Subpass.FeatureIDs.EXTENSION_PKG);
    beforeContainmentNotify(eventType, oldValue, extensionPkg);
    notifier.notify(Subpass.FeatureIDs.EXTENSION_PKG, true, false, eventType, oldValue, extensionPkg);
    afterContainmentNotify(eventType, oldValue, extensionPkg);
  }

  @Override
  public boolean enabled() {
    return enabled;
  }

  @Override
  public void enabled(final boolean enabled) {
    final var oldValue = this.enabled;
    this.enabled = enabled;
    notifier.notifyBoolean(Subpass.FeatureIDs.ENABLED, false, false, oldValue, enabled);
  }

  @Override
  public Group<Subpass> lmGroup() {
    return GraphicModelDefinition.Groups.SUBPASS;
  }

  @Override
  protected FeatureSetter<Subpass> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<Subpass> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case Subpass.FeatureIDs.NAME -> 0;
      case Subpass.FeatureIDs.RESOURCE_PKG -> 1;
      case Subpass.FeatureIDs.DESCRIPTOR_PKG -> 2;
      case Subpass.FeatureIDs.ATTACHMENT_REF_PKG -> 3;
      case Subpass.FeatureIDs.ATTACHMENT_PKG -> 4;
      case Subpass.FeatureIDs.SUBPASS_INDEX -> 5;
      case Subpass.FeatureIDs.PIPELINE_PKG -> 6;
      case Subpass.FeatureIDs.BIND_POINT -> 7;
      case Subpass.FeatureIDs.COMPOSITOR -> 8;
      case Subpass.FeatureIDs.WAIT_FOR_STAGE -> 9;
      case Subpass.FeatureIDs.SYNC_STAGE -> 10;
      case Subpass.FeatureIDs.FINISH_STAGE -> 11;
      case Subpass.FeatureIDs.WAIT_FOR_ACCESSES -> 12;
      case Subpass.FeatureIDs.SYNC_ACCESSES -> 13;
      case Subpass.FeatureIDs.FINISH_ACCESSES -> 14;
      case Subpass.FeatureIDs.EXTENSION_PKG -> 15;
      case Subpass.FeatureIDs.ENABLED -> 16;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<Subpass> GET_MAP = new FeatureGetter.Builder<Subpass>(FEATURE_COUNT, SubpassImpl::featureIndexStatic).add(Subpass.FeatureIDs.NAME, Subpass::name).add(Subpass.FeatureIDs.RESOURCE_PKG, Subpass::resourcePkg).add(Subpass.FeatureIDs.DESCRIPTOR_PKG, Subpass::descriptorPkg).add(Subpass.FeatureIDs.ATTACHMENT_REF_PKG, Subpass::attachmentRefPkg).add(Subpass.FeatureIDs.ATTACHMENT_PKG, Subpass::attachmentPkg).add(Subpass.FeatureIDs.SUBPASS_INDEX, Subpass::subpassIndex).add(Subpass.FeatureIDs.PIPELINE_PKG, Subpass::pipelinePkg).add(Subpass.FeatureIDs.BIND_POINT, Subpass::bindPoint).add(Subpass.FeatureIDs.COMPOSITOR, Subpass::compositor).add(Subpass.FeatureIDs.WAIT_FOR_STAGE, Subpass::waitForStage).add(Subpass.FeatureIDs.SYNC_STAGE, Subpass::syncStage).add(Subpass.FeatureIDs.FINISH_STAGE, Subpass::finishStage).add(Subpass.FeatureIDs.WAIT_FOR_ACCESSES, Subpass::waitForAccesses).add(Subpass.FeatureIDs.SYNC_ACCESSES, Subpass::syncAccesses).add(Subpass.FeatureIDs.FINISH_ACCESSES, Subpass::finishAccesses).add(Subpass.FeatureIDs.EXTENSION_PKG, Subpass::extensionPkg).add(Subpass.FeatureIDs.ENABLED, Subpass::enabled).build();
    private static final FeatureSetter<Subpass> SET_MAP = new FeatureSetter.Builder<Subpass>(FEATURE_COUNT, SubpassImpl::featureIndexStatic).add(Subpass.FeatureIDs.RESOURCE_PKG, (object, value) -> ((SubpassImpl) object).resourcePkg((VulkanResourcePkg) value)).add(Subpass.FeatureIDs.DESCRIPTOR_PKG, (object, value) -> ((SubpassImpl) object).descriptorPkg((DescriptorPkg) value)).add(Subpass.FeatureIDs.ATTACHMENT_REF_PKG, (object, value) -> ((SubpassImpl) object).attachmentRefPkg((AttachmentRefPkg) value)).add(Subpass.FeatureIDs.ATTACHMENT_PKG, (object, value) -> ((SubpassImpl) object).attachmentPkg((AttachmentPkg) value)).add(Subpass.FeatureIDs.SUBPASS_INDEX, (object, value) -> ((SubpassImpl) object).subpassIndex((int) value)).add(Subpass.FeatureIDs.PIPELINE_PKG, (object, value) -> ((SubpassImpl) object).pipelinePkg((PipelinePkg) value)).add(Subpass.FeatureIDs.BIND_POINT, (object, value) -> ((SubpassImpl) object).bindPoint((int) value)).add(Subpass.FeatureIDs.COMPOSITOR, (object, value) -> ((SubpassImpl) object).compositor((ICompositor) value)).add(Subpass.FeatureIDs.WAIT_FOR_STAGE, (object, value) -> ((SubpassImpl) object).waitForStage((EPipelineStage) value)).add(Subpass.FeatureIDs.SYNC_STAGE, (object, value) -> ((SubpassImpl) object).syncStage((EPipelineStage) value)).add(Subpass.FeatureIDs.FINISH_STAGE, (object, value) -> ((SubpassImpl) object).finishStage((EPipelineStage) value)).add(Subpass.FeatureIDs.EXTENSION_PKG, (object, value) -> ((SubpassImpl) object).extensionPkg((ProcessExtensionPkg) value)).add(Subpass.FeatureIDs.ENABLED, (object, value) -> ((SubpassImpl) object).enabled((boolean) value)).build();
  }
}
