package org.sheepy.lily.vulkan.model.process.compute;

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
import org.sheepy.lily.core.model.application.ApplicationModelDefinition;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.process.compute.builder.ComputeProcessBuilder;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.IResourceContainer;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;

public interface ComputeProcess extends AbstractProcess {
  static Builder builder() {
    return new ComputeProcessBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  PipelinePkg pipelinePkg();
  IEngine sourceEngine();
  ComputeConfiguration configuration();
  void pipelinePkg(final PipelinePkg pipelinePkg);
  void sourceEngine(final IEngine sourceEngine);
  void configuration(final ComputeConfiguration configuration);

  interface FeatureIDs {
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
    int PIPELINE_PKG = -504221856;
    int SOURCE_ENGINE = 2109523303;
    int CONFIGURATION = 117777164;
  }

  interface Features<T extends Features<T>> extends AbstractProcess.Features<T> {
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
    Relation<PipelinePkg, PipelinePkg, Listener<PipelinePkg>, Features<?>> PIPELINE_PKG = new RelationBuilder<PipelinePkg, PipelinePkg, Listener<PipelinePkg>, Features<?>>().name("pipelinePkg").contains(true).id(ComputeProcess.FeatureIDs.PIPELINE_PKG).concept(() -> ProcessModelDefinition.Groups.PIPELINE_PKG).build();
    Relation<IEngine, IEngine, Listener<IEngine>, Features<?>> SOURCE_ENGINE = new RelationBuilder<IEngine, IEngine, Listener<IEngine>, Features<?>>().name("sourceEngine").id(ComputeProcess.FeatureIDs.SOURCE_ENGINE).concept(() -> ApplicationModelDefinition.Groups.I_ENGINE).build();
    Relation<ComputeConfiguration, ComputeConfiguration, Listener<ComputeConfiguration>, Features<?>> CONFIGURATION = new RelationBuilder<ComputeConfiguration, ComputeConfiguration, Listener<ComputeConfiguration>, Features<?>>().name("configuration").mandatory(true).contains(true).id(ComputeProcess.FeatureIDs.CONFIGURATION).concept(() -> ComputeModelDefinition.Groups.COMPUTE_CONFIGURATION).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, RESOURCE_PKG, DESCRIPTOR_PKG, ENABLED, QUEUE_PRIORITY, CADENCE, DESCRIPTOR_POOL, WAITING_FENCE_DURING_ACQUIRE, RESET_ALLOWED, EXTENSION_PKG, EXECUTION_MANAGER, PIPELINE_PKG, SOURCE_ENGINE, CONFIGURATION);
  }

  interface Builder extends IFeaturedObject.Builder<ComputeProcess> {
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
    Builder pipelinePkg(Supplier<PipelinePkg> pipelinePkg);
    Builder sourceEngine(Supplier<IEngine> sourceEngine);
    Builder configuration(Supplier<ComputeConfiguration> configuration);
  }
}
