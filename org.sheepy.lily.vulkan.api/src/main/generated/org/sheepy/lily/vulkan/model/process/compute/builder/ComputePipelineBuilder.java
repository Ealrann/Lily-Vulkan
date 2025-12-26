package org.sheepy.lily.vulkan.model.process.compute.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.core.model.maintainer.Maintainer;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.TaskPkg;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline;
import org.sheepy.lily.vulkan.model.process.compute.ComputePipeline.Builder;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputePipelineImpl;
import org.sheepy.lily.vulkan.model.vulkan.DescriptorPkg;
import org.sheepy.lily.vulkan.model.vulkan.VulkanResourcePkg;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorPool;
import org.sheepy.lily.vulkan.model.vulkanresource.DescriptorSet;
import org.sheepy.lily.vulkan.model.vulkanresource.Shader;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;

public final class ComputePipelineBuilder implements Builder {
  private Supplier<Maintainer<ComputePipeline>> maintainer = () -> null;
  private Supplier<VulkanResourcePkg> resourcePkg = () -> null;
  private Supplier<DescriptorPkg> descriptorPkg = () -> null;
  private String name;
  private boolean allocate = true;
  private boolean record = true;
  private Supplier<PipelineExtensionPkg> extensionPkg = () -> null;
  private final List<Supplier<TaskPkg>> taskPkgs = new ArrayList<>();
  private Supplier<DescriptorPool> descriptorPool = () -> null;
  private Supplier<ConstantBuffer> specializationData = () -> null;
  private final List<Supplier<PushConstantRange>> pushConstantRanges = new ArrayList<>();
  private final List<Supplier<DescriptorSet>> layout = new ArrayList<>();
  private Supplier<Shader> shader = () -> null;

  public ComputePipelineBuilder() {
  }

  @Override
  public ComputePipelineBuilder maintainer(Supplier<Maintainer<ComputePipeline>> maintainer) {
    this.maintainer = maintainer;
    return this;
  }

  @SuppressWarnings({
      "unchecked",
      "rawtypes"
  })
  private ComputePipelineBuilder _maintainer(final Supplier<Maintainer<?>> maintainer) {
    this.maintainer = (Supplier) maintainer;
    return this;
  }

  @Override
  public ComputePipelineBuilder resourcePkg(Supplier<VulkanResourcePkg> resourcePkg) {
    this.resourcePkg = resourcePkg;
    return this;
  }

  @Override
  public ComputePipelineBuilder descriptorPkg(Supplier<DescriptorPkg> descriptorPkg) {
    this.descriptorPkg = descriptorPkg;
    return this;
  }

  @Override
  public ComputePipelineBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ComputePipelineBuilder allocate(boolean allocate) {
    this.allocate = allocate;
    return this;
  }

  @Override
  public ComputePipelineBuilder record(boolean record) {
    this.record = record;
    return this;
  }

  @Override
  public ComputePipelineBuilder extensionPkg(Supplier<PipelineExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public ComputePipelineBuilder addTaskPkg(Supplier<TaskPkg> taskPkg) {
    this.taskPkgs.add(taskPkg);
    return this;
  }

  @Override
  public ComputePipelineBuilder addTaskPkgs(final List<TaskPkg> taskPkgs) {
    taskPkgs.forEach(value -> this.taskPkgs.add(() -> value));
    return this;
  }

  @Override
  public ComputePipelineBuilder descriptorPool(Supplier<DescriptorPool> descriptorPool) {
    this.descriptorPool = descriptorPool;
    return this;
  }

  @Override
  public ComputePipelineBuilder specializationData(Supplier<ConstantBuffer> specializationData) {
    this.specializationData = specializationData;
    return this;
  }

  @Override
  public ComputePipelineBuilder addPushConstantRange(
      Supplier<PushConstantRange> pushConstantRange) {
    this.pushConstantRanges.add(pushConstantRange);
    return this;
  }

  @Override
  public ComputePipelineBuilder addPushConstantRanges(
      final List<PushConstantRange> pushConstantRanges) {
    pushConstantRanges.forEach(value -> this.pushConstantRanges.add(() -> value));
    return this;
  }

  @Override
  public ComputePipelineBuilder addLayout(Supplier<DescriptorSet> layout) {
    this.layout.add(layout);
    return this;
  }

  @Override
  public ComputePipelineBuilder addLayout(final List<DescriptorSet> layout) {
    layout.forEach(value -> this.layout.add(() -> value));
    return this;
  }

  @Override
  public ComputePipelineBuilder shader(Supplier<Shader> shader) {
    this.shader = shader;
    return this;
  }

  @Override
  public ComputePipeline build() {
    final var builtTaskPkgs = BuildUtils.collectSuppliers(taskPkgs);
    final var builtPushConstantRanges = BuildUtils.collectSuppliers(pushConstantRanges);
    final var builtLayout = BuildUtils.collectSuppliers(layout);
    final var built = new ComputePipelineImpl(name);
    built.maintainer(maintainer.get());
    built.resourcePkg(resourcePkg.get());
    built.descriptorPkg(descriptorPkg.get());
    built.allocate(allocate);
    built.record(record);
    built.extensionPkg(extensionPkg.get());
    built.taskPkgs().addAll(builtTaskPkgs);
    built.descriptorPool(descriptorPool.get());
    built.specializationData(specializationData.get());
    built.pushConstantRanges().addAll(builtPushConstantRanges);
    built.layout().addAll(builtLayout);
    built.shader(shader.get());
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
    private static final FeatureInserter<ComputePipelineBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ComputePipelineBuilder>(3, Inserters::attributeIndex).add(ComputePipeline.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ComputePipeline.FeatureIDs.ALLOCATE, (builder, value) -> builder.allocate((boolean) value)).add(ComputePipeline.FeatureIDs.RECORD, (builder, value) -> builder.record((boolean) value)).build();
    private static final RelationLazyInserter<ComputePipelineBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ComputePipelineBuilder>(10, Inserters::relationIndex).add(ComputePipeline.FeatureIDs.MAINTAINER, (builder, value) -> builder._maintainer((Supplier<Maintainer<?>>) value)).add(ComputePipeline.FeatureIDs.RESOURCE_PKG, (builder, value) -> builder.resourcePkg((Supplier<VulkanResourcePkg>) value)).add(ComputePipeline.FeatureIDs.DESCRIPTOR_PKG, (builder, value) -> builder.descriptorPkg((Supplier<DescriptorPkg>) value)).add(ComputePipeline.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<PipelineExtensionPkg>) value)).add(ComputePipeline.FeatureIDs.TASK_PKGS, (builder, value) -> builder.addTaskPkg((Supplier<TaskPkg>) value)).add(ComputePipeline.FeatureIDs.DESCRIPTOR_POOL, (builder, value) -> builder.descriptorPool((Supplier<DescriptorPool>) value)).add(ComputePipeline.FeatureIDs.SPECIALIZATION_DATA, (builder, value) -> builder.specializationData((Supplier<ConstantBuffer>) value)).add(ComputePipeline.FeatureIDs.PUSH_CONSTANT_RANGES, (builder, value) -> builder.addPushConstantRange((Supplier<PushConstantRange>) value)).add(ComputePipeline.FeatureIDs.LAYOUT, (builder, value) -> builder.addLayout((Supplier<DescriptorSet>) value)).add(ComputePipeline.FeatureIDs.SHADER, (builder, value) -> builder.shader((Supplier<Shader>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ComputePipeline.FeatureIDs.NAME -> 0;
        case ComputePipeline.FeatureIDs.ALLOCATE -> 1;
        case ComputePipeline.FeatureIDs.RECORD -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ComputePipeline.FeatureIDs.MAINTAINER -> 0;
        case ComputePipeline.FeatureIDs.RESOURCE_PKG -> 1;
        case ComputePipeline.FeatureIDs.DESCRIPTOR_PKG -> 2;
        case ComputePipeline.FeatureIDs.EXTENSION_PKG -> 3;
        case ComputePipeline.FeatureIDs.TASK_PKGS -> 4;
        case ComputePipeline.FeatureIDs.DESCRIPTOR_POOL -> 5;
        case ComputePipeline.FeatureIDs.SPECIALIZATION_DATA -> 6;
        case ComputePipeline.FeatureIDs.PUSH_CONSTANT_RANGES -> 7;
        case ComputePipeline.FeatureIDs.LAYOUT -> 8;
        case ComputePipeline.FeatureIDs.SHADER -> 9;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
