package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.application.ICadence;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.ProcessExecutionManager;
import org.sheepy.lily.vulkan.model.process.ProcessExtensionPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicProcess.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.Subpass;
import org.sheepy.lily.vulkan.model.process.graphic.impl.GraphicProcessImpl;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;

public final class GraphicProcessBuilder implements Builder {
  private Supplier<Maintainer<GraphicProcess>> maintainer = () -> null;
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
  private Supplier<GraphicConfiguration> configuration;
  private Supplier<AttachmentPkg> attachmentPkg;
  private final List<Supplier<Subpass>> subpasses = new ArrayList<>();

  public GraphicProcessBuilder() {
  }

  @Override
  public GraphicProcessBuilder maintainer(Supplier<Maintainer<GraphicProcess>> maintainer) {
    this.maintainer = maintainer;
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private GraphicProcessBuilder _maintainer(final Supplier<Maintainer<?>> maintainer) {
    this.maintainer = (Supplier) maintainer;
    return this;
  }

  @Override
  public GraphicProcessBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public GraphicProcessBuilder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public GraphicProcessBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public GraphicProcessBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public GraphicProcessBuilder queuePriority(float queuePriority) {
    this.queuePriority = queuePriority;
    return this;
  }

  @Override
  public GraphicProcessBuilder cadence(Supplier<ICadence> cadence) {
    this.cadence = cadence;
    return this;
  }

  @Override
  public GraphicProcessBuilder descriptorPool(Supplier<DescriptorPool> descriptorPool) {
    this.descriptorPool = descriptorPool;
    return this;
  }

  @Override
  public GraphicProcessBuilder waitingFenceDuringAcquire(boolean waitingFenceDuringAcquire) {
    this.waitingFenceDuringAcquire = waitingFenceDuringAcquire;
    return this;
  }

  @Override
  public GraphicProcessBuilder resetAllowed(boolean resetAllowed) {
    this.resetAllowed = resetAllowed;
    return this;
  }

  @Override
  public GraphicProcessBuilder extensionPkg(Supplier<ProcessExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public GraphicProcessBuilder executionManager(
      Supplier<ProcessExecutionManager> executionManager) {
    this.executionManager = executionManager;
    return this;
  }

  @Override
  public GraphicProcessBuilder configuration(Supplier<GraphicConfiguration> configuration) {
    this.configuration = configuration;
    return this;
  }

  @Override
  public GraphicProcessBuilder attachmentPkg(Supplier<AttachmentPkg> attachmentPkg) {
    this.attachmentPkg = attachmentPkg;
    return this;
  }

  @Override
  public GraphicProcessBuilder addSubpasse(Supplier<Subpass> subpasse) {
    this.subpasses.add(subpasse);
    return this;
  }

  @Override
  public GraphicProcessBuilder addSubpasses(final List<Subpass> subpasses) {
    subpasses.forEach(value -> this.subpasses.add(() -> value));
    return this;
  }

  @Override
  public GraphicProcess build() {
    final var builtSubpasses = BuildUtils.collectSuppliers(subpasses);
    final var built = new GraphicProcessImpl(name, queuePriority, executionManager.get(), configuration.get(), attachmentPkg.get());
    built.maintainer(maintainer.get());
    built.resourcePkg(resourcePkg.get());
    built.descriptorPkg(descriptorPkg.get());
    built.enabled(enabled);
    built.cadence(cadence.get());
    built.descriptorPool(descriptorPool.get());
    built.waitingFenceDuringAcquire(waitingFenceDuringAcquire);
    built.resetAllowed(resetAllowed);
    built.extensionPkg(extensionPkg.get());
    built.subpasses().addAll(builtSubpasses);
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
    private static final FeatureInserter<GraphicProcessBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<GraphicProcessBuilder>(5, Inserters::attributeIndex).add(GraphicProcess.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(GraphicProcess.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(GraphicProcess.FeatureIDs.QUEUE_PRIORITY, (builder, value) -> builder.queuePriority((float) value)).add(GraphicProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE, (builder, value) -> builder.waitingFenceDuringAcquire((boolean) value)).add(GraphicProcess.FeatureIDs.RESET_ALLOWED, (builder, value) -> builder.resetAllowed((boolean) value)).build();
    private static final RelationLazyInserter<GraphicProcessBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<GraphicProcessBuilder>(10, Inserters::relationIndex).add(GraphicProcess.FeatureIDs.MAINTAINER, (builder, value) -> builder._maintainer((Supplier<Maintainer<?>>) value)).add(GraphicProcess.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<VulkanResourcePkg>) value)).add(GraphicProcess.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).add(GraphicProcess.FeatureIDs.CADENCE, (builder, value) -> builder.cadence((Supplier<ICadence>) value)).add(GraphicProcess.FeatureIDs.DESCRIPTOR_POOL, (builder, value) -> builder.descriptorPool((Supplier<DescriptorPool>) value)).add(GraphicProcess.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<ProcessExtensionPkg>) value)).add(GraphicProcess.FeatureIDs.EXECUTION_MANAGER, (builder, value) -> builder.executionManager((Supplier<ProcessExecutionManager>) value)).add(GraphicProcess.FeatureIDs.CONFIGURATION, (builder, value) -> builder.configuration((Supplier<GraphicConfiguration>) value)).add(GraphicProcess.FeatureIDs.ATTACHMENT_PKG, (builder, value) -> builder.attachmentPkg((Supplier<AttachmentPkg>) value)).add(GraphicProcess.FeatureIDs.SUBPASSES, (builder, value) -> builder.addSubpasse((Supplier<Subpass>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case GraphicProcess.FeatureIDs.NAME -> 0;
        case GraphicProcess.FeatureIDs.ENABLED -> 1;
        case GraphicProcess.FeatureIDs.QUEUE_PRIORITY -> 2;
        case GraphicProcess.FeatureIDs.WAITING_FENCE_DURING_ACQUIRE -> 3;
        case GraphicProcess.FeatureIDs.RESET_ALLOWED -> 4;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case GraphicProcess.FeatureIDs.MAINTAINER -> 0;
        case GraphicProcess.FeatureIDs.RESOURCE_PKG -> 1;
        case GraphicProcess.FeatureIDs.DESCRIPTOR_PKG -> 2;
        case GraphicProcess.FeatureIDs.CADENCE -> 3;
        case GraphicProcess.FeatureIDs.DESCRIPTOR_POOL -> 4;
        case GraphicProcess.FeatureIDs.EXTENSION_PKG -> 5;
        case GraphicProcess.FeatureIDs.EXECUTION_MANAGER -> 6;
        case GraphicProcess.FeatureIDs.CONFIGURATION -> 7;
        case GraphicProcess.FeatureIDs.ATTACHMENT_PKG -> 8;
        case GraphicProcess.FeatureIDs.SUBPASSES -> 9;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
