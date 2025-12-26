package org.sheepy.lily.vulkan.model.vulkan.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine.Builder;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkan.impl.VulkanEngineImpl;
import org.sheepy.vulkan.model.enumeration.EPhysicalDeviceFeature;

public final class VulkanEngineBuilder implements Builder {
  private Supplier<VulkanResourcePkg> resourcePkg = () -> null;
  private Supplier<DescriptorPkg> descriptorPkg = () -> null;
  private boolean enabled = true;
  private final List<Supplier<IProcess>> processes = new ArrayList<>();
  private final List<EPhysicalDeviceFeature> features = new ArrayList<>();

  public VulkanEngineBuilder() {
  }

  @Override
  public VulkanEngineBuilder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public VulkanEngineBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public VulkanEngineBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public VulkanEngineBuilder addProcesse(Supplier<IProcess> processe) {
    this.processes.add(processe);
    return this;
  }

  @Override
  public VulkanEngineBuilder addProcesses(final List<IProcess> processes) {
    processes.forEach(value -> this.processes.add(() -> value));
    return this;
  }

  @Override
  public VulkanEngineBuilder addFeature(EPhysicalDeviceFeature feature) {
    this.features.add(feature);
    return this;
  }

  @Override
  public VulkanEngineBuilder addFeatures(final List<EPhysicalDeviceFeature> features) {
    this.features.addAll(features);
    return this;
  }

  @Override
  public VulkanEngine build() {
    final var builtProcesses = BuildUtils.collectSuppliers(processes);
    final var built = new VulkanEngineImpl();
    built.resourcePkg(resourcePkg.get());
    built.descriptorPkg(descriptorPkg.get());
    built.enabled(enabled);
    built.processes().addAll(builtProcesses);
    built.features().addAll(features);
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
    private static final FeatureInserter<VulkanEngineBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<VulkanEngineBuilder>(2, Inserters::attributeIndex).add(VulkanEngine.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(VulkanEngine.FeatureIDs.FEATURES, (builder, value) -> builder.addFeature((EPhysicalDeviceFeature) value)).build();
    private static final RelationLazyInserter<VulkanEngineBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<VulkanEngineBuilder>(3, Inserters::relationIndex).add(VulkanEngine.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<VulkanResourcePkg>) value)).add(VulkanEngine.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).add(VulkanEngine.FeatureIDs.PROCESSES, (builder, value) -> builder.addProcesse((Supplier<IProcess>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case VulkanEngine.FeatureIDs.ENABLED -> 0;
        case VulkanEngine.FeatureIDs.FEATURES -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case VulkanEngine.FeatureIDs.RESOURCE_PKG -> 0;
        case VulkanEngine.FeatureIDs.DESCRIPTOR_PKG -> 1;
        case VulkanEngine.FeatureIDs.PROCESSES -> 2;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
