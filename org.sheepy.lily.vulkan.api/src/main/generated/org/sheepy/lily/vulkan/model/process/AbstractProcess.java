package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface AbstractProcess extends IProcess {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  DescriptorPool descriptorPool();
  boolean waitingFenceDuringAcquire();
  boolean resetAllowed();
  ProcessExtensionPkg extensionPkg();
  ProcessExecutionManager executionManager();
  void descriptorPool(final DescriptorPool descriptorPool);
  void waitingFenceDuringAcquire(final boolean waitingFenceDuringAcquire);
  void resetAllowed(final boolean resetAllowed);
  void extensionPkg(final ProcessExtensionPkg extensionPkg);
  void executionManager(final ProcessExecutionManager executionManager);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int RESOURCE_PKG = IResourceContainer.FeatureIDs.RESOURCE_PKG;
    int DESCRIPTOR_PKG = IResourceContainer.FeatureIDs.DESCRIPTOR_PKG;
    int ENABLED = IProcess.FeatureIDs.ENABLED;
    int QUEUE_PRIORITY = IProcess.FeatureIDs.QUEUE_PRIORITY;
    int CADENCE = IProcess.FeatureIDs.CADENCE;
    int DESCRIPTOR_POOL = 565941657;
    int WAITING_FENCE_DURING_ACQUIRE = -106704477;
    int RESET_ALLOWED = -1107870137;
    int EXTENSION_PKG = 1005570555;
    int EXECUTION_MANAGER = -851651741;
  }

  interface Features<T extends Features<T>> extends IProcess.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<VulkanResourcePkg, VulkanResourcePkg, Listener<VulkanResourcePkg>, IResourceContainer.Features<?>> RESOURCE_PKG = IResourceContainer.Features.RESOURCE_PKG;
    Relation<DescriptorPkg, DescriptorPkg, Listener<DescriptorPkg>, IResourceContainer.Features<?>> DESCRIPTOR_PKG = IResourceContainer.Features.DESCRIPTOR_PKG;
    Attribute<Boolean, Boolean, BooleanListener, IProcess.Features<?>> ENABLED = IProcess.Features.ENABLED;
    Attribute<Float, Float, FloatListener, IProcess.Features<?>> QUEUE_PRIORITY = IProcess.Features.QUEUE_PRIORITY;
    Relation<ICadence, ICadence, Listener<ICadence>, IProcess.Features<?>> CADENCE = IProcess.Features.CADENCE;
    Relation<DescriptorPool, DescriptorPool, Listener<DescriptorPool>, Features<?>> DESCRIPTOR_POOL = new RelationBuilder<DescriptorPool, DescriptorPool, Listener<DescriptorPool>, Features<?>>().name("descriptorPool").contains(true).id(AbstractProcess.FeatureIDs.DESCRIPTOR_POOL).concept(() -> VulkanResourceModelDefinition.Groups.DESCRIPTOR_POOL).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> WAITING_FENCE_DURING_ACQUIRE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("waitingFenceDuringAcquire").defaultValue("false").id(AbstractProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> RESET_ALLOWED = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("resetAllowed").id(AbstractProcess.FeatureIDs.RESET_ALLOWED).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Relation<ProcessExtensionPkg, ProcessExtensionPkg, Listener<ProcessExtensionPkg>, Features<?>> EXTENSION_PKG = new RelationBuilder<ProcessExtensionPkg, ProcessExtensionPkg, Listener<ProcessExtensionPkg>, Features<?>>().name("extensionPkg").contains(true).id(AbstractProcess.FeatureIDs.EXTENSION_PKG).concept(() -> ProcessModelDefinition.Groups.PROCESS_EXTENSION_PKG).build();
    Relation<ProcessExecutionManager, ProcessExecutionManager, Listener<ProcessExecutionManager>, Features<?>> EXECUTION_MANAGER = new RelationBuilder<ProcessExecutionManager, ProcessExecutionManager, Listener<ProcessExecutionManager>, Features<?>>().name("executionManager").mandatory(true).contains(true).id(AbstractProcess.FeatureIDs.EXECUTION_MANAGER).concept(() -> ProcessModelDefinition.Groups.PROCESS_EXECUTION_MANAGER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, RESOURCE_PKG, DESCRIPTOR_PKG, ENABLED, QUEUE_PRIORITY, CADENCE, DESCRIPTOR_POOL, WAITING_FENCE_DURING_ACQUIRE, RESET_ALLOWED, EXTENSION_PKG, EXECUTION_MANAGER);
  }
}
