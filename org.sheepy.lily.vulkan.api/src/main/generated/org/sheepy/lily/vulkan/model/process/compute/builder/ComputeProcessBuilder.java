package org.sheepy.lily.vulkan.model.process.compute.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.application.IEngine;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputeConfiguration;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess;
import org.sheepy.lily.vulkan.model.process.compute.ComputeProcess.Builder;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputeProcessImpl;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;

public final class ComputeProcessBuilder implements Builder {
  private String name;
  private Supplier<VulkanResourcePkg> resourcePkg = () -> null;
  private Supplier<DescriptorPkg> descriptorPkg = () -> null;
  private boolean enabled = true;
  private float queuePriority = 1f;
  private Supplier<ICadence> cadence = () -> null;
  private Supplier<DescriptorPool> descriptorPool = () -> null;
  private boolean waitingFenceDuringAcquire = false;
  private boolean resetAllowed;
  private Supplier<ProcessExtensionPkg> extensionPkg = () -> null;
  private Supplier<ProcessExecutionManager> executionManager;
  private Supplier<PipelinePkg> pipelinePkg = () -> null;
  private Supplier<IEngine> sourceEngine = () -> null;
  private Supplier<ComputeConfiguration> configuration;

  public ComputeProcessBuilder() {
  }

  @Override
  public ComputeProcessBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ComputeProcessBuilder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public ComputeProcessBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public ComputeProcessBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public ComputeProcessBuilder queuePriority(float queuePriority) {
    this.queuePriority = queuePriority;
    return this;
  }

  @Override
  public ComputeProcessBuilder cadence(Supplier<ICadence> cadence) {
    this.cadence = cadence;
    return this;
  }

  @Override
  public ComputeProcessBuilder descriptorPool(Supplier<DescriptorPool> descriptorPool) {
    this.descriptorPool = descriptorPool;
    return this;
  }

  @Override
  public ComputeProcessBuilder waitingFenceDuringAcquire(boolean waitingFenceDuringAcquire) {
    this.waitingFenceDuringAcquire = waitingFenceDuringAcquire;
    return this;
  }

  @Override
  public ComputeProcessBuilder resetAllowed(boolean resetAllowed) {
    this.resetAllowed = resetAllowed;
    return this;
  }

  @Override
  public ComputeProcessBuilder extensionPkg(Supplier<ProcessExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public ComputeProcessBuilder executionManager(
      Supplier<ProcessExecutionManager> executionManager) {
    this.executionManager = executionManager;
    return this;
  }

  @Override
  public ComputeProcessBuilder pipelinePkg(Supplier<PipelinePkg> pipelinePkg) {
    this.pipelinePkg = pipelinePkg;
    return this;
  }

  @Override
  public ComputeProcessBuilder sourceEngine(Supplier<IEngine> sourceEngine) {
    this.sourceEngine = sourceEngine;
    return this;
  }

  @Override
  public ComputeProcessBuilder configuration(Supplier<ComputeConfiguration> configuration) {
    this.configuration = configuration;
    return this;
  }

  @Override
  public ComputeProcess build() {
    final var built = new ComputeProcessImpl(name, queuePriority, executionManager.get(), configuration.get());
    built.resourcePkg(resourcePkg.get());
    built.descriptorPkg(descriptorPkg.get());
    built.enabled(enabled);
    built.cadence(cadence.get());
    built.descriptorPool(descriptorPool.get());
    built.waitingFenceDuringAcquire(waitingFenceDuringAcquire);
    built.resetAllowed(resetAllowed);
    built.extensionPkg(extensionPkg.get());
    built.pipelinePkg(pipelinePkg.get());
    built.sourceEngine(sourceEngine.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<ComputeProcessBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ComputeProcessBuilder>(5, Inserters::attributeIndex).add(ComputeProcess.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ComputeProcess.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(ComputeProcess.FeatureIDs.QUEUE_PRIORITY, (builder, value) -> builder.queuePriority((float) value)).add(ComputeProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE, (builder, value) -> builder.waitingFenceDuringAcquire((boolean) value)).add(ComputeProcess.FeatureIDs.RESET_ALLOWED, (builder, value) -> builder.resetAllowed((boolean) value)).build();
    private static final RelationLazyInserter<ComputeProcessBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ComputeProcessBuilder>(9, Inserters::relationIndex).add(ComputeProcess.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<VulkanResourcePkg>) value)).add(ComputeProcess.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).add(ComputeProcess.FeatureIDs.CADENCE, (builder, value) -> builder.cadence((Supplier<ICadence>) value)).add(ComputeProcess.FeatureIDs.DESCRIPTOR_POOL, (builder, value) -> builder.descriptorPool((Supplier<DescriptorPool>) value)).add(ComputeProcess.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<ProcessExtensionPkg>) value)).add(ComputeProcess.FeatureIDs.EXECUTION_MANAGER, (builder, value) -> builder.executionManager((Supplier<ProcessExecutionManager>) value)).add(ComputeProcess.FeatureIDs.PIPELINE_PKG, (builder, value) -> builder.pipelinePkg((Supplier<PipelinePkg>) value)).add(ComputeProcess.FeatureIDs.SOURCE_ENGINE, (builder, value) -> builder.sourceEngine((Supplier<IEngine>) value)).add(ComputeProcess.FeatureIDs.CONFIGURATION, (builder, value) -> builder.configuration((Supplier<ComputeConfiguration>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ComputeProcess.FeatureIDs.NAME -> 0;
        case ComputeProcess.FeatureIDs.ENABLED -> 1;
        case ComputeProcess.FeatureIDs.QUEUE_PRIORITY -> 2;
        case ComputeProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE -> 3;
        case ComputeProcess.FeatureIDs.RESET_ALLOWED -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ComputeProcess.FeatureIDs.RESOURCE_PKG -> 0;
        case ComputeProcess.FeatureIDs.DESCRIPTOR_PKG -> 1;
        case ComputeProcess.FeatureIDs.CADENCE -> 2;
        case ComputeProcess.FeatureIDs.DESCRIPTOR_POOL -> 3;
        case ComputeProcess.FeatureIDs.EXTENSION_PKG -> 4;
        case ComputeProcess.FeatureIDs.EXECUTION_MANAGER -> 5;
        case ComputeProcess.FeatureIDs.PIPELINE_PKG -> 6;
        case ComputeProcess.FeatureIDs.SOURCE_ENGINE -> 7;
        case ComputeProcess.FeatureIDs.CONFIGURATION -> 8;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
