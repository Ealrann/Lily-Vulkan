package org.sheepy.lily.vulkan.model.process.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.process.Pipeline;
import org.sheepy.lily.vulkan.model.process.Pipeline.Builder;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.impl.PipelineImpl;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;

public final class PipelineBuilder implements Builder {
  private Supplier<VulkanResourcePkg> resourcePkg = () -> null;
  private Supplier<DescriptorPkg> descriptorPkg = () -> null;
  private String name;
  private boolean allocate = true;
  private boolean record = true;
  private Supplier<PipelineExtensionPkg> extensionPkg = () -> null;
  private final List<Supplier<TaskPkg>> taskPkgs = new ArrayList<>();

  public PipelineBuilder() {
  }

  @Override
  public PipelineBuilder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public PipelineBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public PipelineBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public PipelineBuilder allocate(boolean allocate) {
    this.allocate = allocate;
    return this;
  }

  @Override
  public PipelineBuilder record(boolean record) {
    this.record = record;
    return this;
  }

  @Override
  public PipelineBuilder extensionPkg(Supplier<PipelineExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public PipelineBuilder addTaskPkg(Supplier<TaskPkg> taskPkg) {
    this.taskPkgs.add(taskPkg);
    return this;
  }

  @Override
  public PipelineBuilder addTaskPkgs(final List<TaskPkg> taskPkgs) {
    taskPkgs.forEach(value -> this.taskPkgs.add(() -> value));
    return this;
  }

  @Override
  public Pipeline build() {
    final var builtTaskPkgs = BuildUtils.collectSuppliers(taskPkgs);
    final var built = new PipelineImpl(name);
    built.resourcePkg(resourcePkg.get());
    built.descriptorPkg(descriptorPkg.get());
    built.allocate(allocate);
    built.record(record);
    built.extensionPkg(extensionPkg.get());
    built.taskPkgs().addAll(builtTaskPkgs);
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
    private static final FeatureInserter<PipelineBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PipelineBuilder>(3, Inserters::attributeIndex).add(Pipeline.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(Pipeline.FeatureIDs.ALLOCATE, (builder, value) -> builder.allocate((boolean) value)).add(Pipeline.FeatureIDs.RECORD, (builder, value) -> builder.record((boolean) value)).build();
    private static final RelationLazyInserter<PipelineBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PipelineBuilder>(4, Inserters::relationIndex).add(Pipeline.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<VulkanResourcePkg>) value)).add(Pipeline.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).add(Pipeline.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<PipelineExtensionPkg>) value)).add(Pipeline.FeatureIDs.TASK_PKGS, (builder, value) -> builder.addTaskPkg((Supplier<TaskPkg>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case Pipeline.FeatureIDs.NAME -> 0;
        case Pipeline.FeatureIDs.ALLOCATE -> 1;
        case Pipeline.FeatureIDs.RECORD -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case Pipeline.FeatureIDs.RESOURCE_PKG -> 0;
        case Pipeline.FeatureIDs.DESCRIPTOR_PKG -> 1;
        case Pipeline.FeatureIDs.EXTENSION_PKG -> 2;
        case Pipeline.FeatureIDs.TASK_PKGS -> 3;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
