package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.maintainer.Maintainable;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicProcessBuilder;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;

public interface GraphicProcess extends AbstractProcess, Maintainable<GraphicProcess> {
  static Builder builder() {
    return new GraphicProcessBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  GraphicConfiguration configuration();
  AttachmentPkg attachmentPkg();
  List<Subpass> subpasses();
  void configuration(final GraphicConfiguration configuration);
  void attachmentPkg(final AttachmentPkg attachmentPkg);

  interface FeatureIDs {
    int MAINTAINER = Maintainable.FeatureIDs.MAINTAINER;
    int NAME = Named.FeatureIDs.NAME;
    int RESOURCE_PKG = IResourceContainer.FeatureIDs.RESOURCE_PKG;
    int DESCRIPTOR_PKG = IResourceContainer.FeatureIDs.DESCRIPTOR_PKG;
    int ENABLED = IProcess.FeatureIDs.ENABLED;
    int QUEUE_PRIORITY = IProcess.FeatureIDs.QUEUE_PRIORITY;
    int CADENCE = IProcess.FeatureIDs.CADENCE;
    int DESCRIPTOR_POOL = AbstractProcess.FeatureIDs.DESCRIPTOR_POOL;
    int WAITING_FENCE_DURING_ACQUIRE = AbstractProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE;
    int RESET_ALLOWED = AbstractProcess.FeatureIDs.RESET_ALLOWED;
    int EXTENSION_PKG = AbstractProcess.FeatureIDs.EXTENSION_PKG;
    int EXECUTION_MANAGER = AbstractProcess.FeatureIDs.EXECUTION_MANAGER;
    int CONFIGURATION = -1391984662;
    int ATTACHMENT_PKG = -536628067;
    int SUBPASSES = -1769086029;
  }

  interface Features<T extends Features<T>> extends AbstractProcess.Features<T>, Maintainable.Features<T> {
    Relation<Maintainer<?>, Maintainer<?>, Listener<Maintainer<?>>, Maintainable.Features<?>> MAINTAINER = Maintainable.Features.MAINTAINER;
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, IResourceContainer.Features<?>> RESOURCE_PKG = IResourceContainer.Features.RESOURCE_PKG;
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, IResourceContainer.Features<?>> DESCRIPTOR_PKG = IResourceContainer.Features.DESCRIPTOR_PKG;
    Attribute<Boolean, Boolean, BooleanListener, IProcess.Features<?>> ENABLED = IProcess.Features.ENABLED;
    Attribute<Float, Float, FloatListener, IProcess.Features<?>> QUEUE_PRIORITY = IProcess.Features.QUEUE_PRIORITY;
    Relation<ICadence, ICadence, Listener<ICadence>, IProcess.Features<?>> CADENCE = IProcess.Features.CADENCE;
    Relation<DescriptorPool, DescriptorPool, Listener<DescriptorPool>, AbstractProcess.Features<?>> DESCRIPTOR_POOL = AbstractProcess.Features.DESCRIPTOR_POOL;
    Attribute<Boolean, Boolean, BooleanListener, AbstractProcess.Features<?>> WAITING_FENCE_DURING_ACQUIRE = AbstractProcess.Features.WAITING_FENCE_DURING_ACQUIRE;
    Attribute<Boolean, Boolean, BooleanListener, AbstractProcess.Features<?>> RESET_ALLOWED = AbstractProcess.Features.RESET_ALLOWED;
    Relation<ProcessExtensionPkg, ProcessExtensionPkg, Listener<ProcessExtensionPkg>, AbstractProcess.Features<?>> EXTENSION_PKG = AbstractProcess.Features.EXTENSION_PKG;
    Relation<ProcessExecutionManager, ProcessExecutionManager, Listener<ProcessExecutionManager>, AbstractProcess.Features<?>> EXECUTION_MANAGER = AbstractProcess.Features.EXECUTION_MANAGER;
    Relation<GraphicConfiguration, GraphicConfiguration, Listener<GraphicConfiguration>, Features<?>> CONFIGURATION = new RelationBuilder<GraphicConfiguration, GraphicConfiguration, Listener<GraphicConfiguration>, Features<?>>().name("configuration").mandatory(true).contains(true).id(GraphicProcess.FeatureIDs.CONFIGURATION).concept(() -> GraphicModelDefinition.Groups.GRAPHIC_CONFIGURATION).build();
    Relation<AttachmentPkg, AttachmentPkg, Listener<AttachmentPkg>, Features<?>> ATTACHMENT_PKG = new RelationBuilder<AttachmentPkg, AttachmentPkg, Listener<AttachmentPkg>, Features<?>>().name("attachmentPkg").mandatory(true).contains(true).id(GraphicProcess.FeatureIDs.ATTACHMENT_PKG).concept(() -> GraphicModelDefinition.Groups.ATTACHMENT_PKG).build();
    Relation<Subpass, List<Subpass>, Listener<List<Subpass>>, Features<?>> SUBPASSES = new RelationBuilder<Subpass, List<Subpass>, Listener<List<Subpass>>, Features<?>>().name("subpasses").many(true).contains(true).id(GraphicProcess.FeatureIDs.SUBPASSES).concept(() -> GraphicModelDefinition.Groups.SUBPASS).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MAINTAINER, NAME, RESOURCE_PKG, DESCRIPTOR_PKG, ENABLED, QUEUE_PRIORITY, CADENCE, DESCRIPTOR_POOL, WAITING_FENCE_DURING_ACQUIRE, RESET_ALLOWED, EXTENSION_PKG, EXECUTION_MANAGER, CONFIGURATION, ATTACHMENT_PKG, SUBPASSES);
  }

  interface Builder extends IFeaturedObject.Builder<GraphicProcess> {
    Builder maintainer(Supplier<Maintainer<GraphicProcess>> maintainer);
    Builder name(String name);
    Builder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg);
    Builder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg);
    Builder enabled(boolean enabled);
    Builder queuePriority(float queuePriority);
    Builder cadence(Supplier<ICadence> cadence);
    Builder descriptorPool(Supplier<DescriptorPool> descriptorPool);
    Builder waitingFenceDuringAcquire(boolean waitingFenceDuringAcquire);
    Builder resetAllowed(boolean resetAllowed);
    Builder extensionPkg(Supplier<ProcessExtensionPkg> extensionPkg);
    Builder executionManager(Supplier<ProcessExecutionManager> executionManager);
    Builder configuration(Supplier<GraphicConfiguration> configuration);
    Builder attachmentPkg(Supplier<AttachmentPkg> attachmentPkg);
    Builder addSubpasse(Supplier<Subpass> subpasse);
    Builder addSubpasses(List<Subpass> subpasses);
  }
}
