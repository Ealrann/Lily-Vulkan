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
import org.sheepy.lily.vulkan.model.process.CompositePipeline;
import org.sheepy.lily.vulkan.model.process.CompositePipeline.Builder;
import org.sheepy.lily.vulkan.model.process.PipelineExtensionPkg;
import org.sheepy.lily.vulkan.model.process.TaskPipeline;
import org.sheepy.lily.vulkan.model.process.impl.CompositePipelineImpl;

public final class CompositePipelineBuilder implements Builder {
  private String name;
  private boolean allocate = true;
  private boolean record = true;
  private Supplier<PipelineExtensionPkg> extensionPkg = () -> null;
  private final List<Supplier<TaskPipeline>> pipelines = new ArrayList<>();
  private int repeat = 1;

  public CompositePipelineBuilder() {
  }

  @Override
  public CompositePipelineBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CompositePipelineBuilder allocate(boolean allocate) {
    this.allocate = allocate;
    return this;
  }

  @Override
  public CompositePipelineBuilder record(boolean record) {
    this.record = record;
    return this;
  }

  @Override
  public CompositePipelineBuilder extensionPkg(Supplier<PipelineExtensionPkg> extensionPkg) {
    this.extensionPkg = extensionPkg;
    return this;
  }

  @Override
  public CompositePipelineBuilder addPipeline(Supplier<TaskPipeline> pipeline) {
    this.pipelines.add(pipeline);
    return this;
  }

  @Override
  public CompositePipelineBuilder addPipelines(final List<TaskPipeline> pipelines) {
    pipelines.forEach(value -> this.pipelines.add(() -> value));
    return this;
  }

  @Override
  public CompositePipelineBuilder repeat(int repeat) {
    this.repeat = repeat;
    return this;
  }

  @Override
  public CompositePipeline build() {
    final var builtPipelines = BuildUtils.collectSuppliers(pipelines);
    final var built = new CompositePipelineImpl(name, repeat);
    built.allocate(allocate);
    built.record(record);
    built.extensionPkg(extensionPkg.get());
    built.pipelines().addAll(builtPipelines);
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
    private static final FeatureInserter<CompositePipelineBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CompositePipelineBuilder>(4, Inserters::attributeIndex).add(CompositePipeline.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(CompositePipeline.FeatureIDs.ALLOCATE, (builder, value) -> builder.allocate((boolean) value)).add(CompositePipeline.FeatureIDs.RECORD, (builder, value) -> builder.record((boolean) value)).add(CompositePipeline.FeatureIDs.REPEAT, (builder, value) -> builder.repeat((int) value)).build();
    private static final RelationLazyInserter<CompositePipelineBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CompositePipelineBuilder>(2, Inserters::relationIndex).add(CompositePipeline.FeatureIDs.EXTENSION_PKG, (builder, value) -> builder.extensionPkg((Supplier<PipelineExtensionPkg>) value)).add(CompositePipeline.FeatureIDs.PIPELINES, (builder, value) -> builder.addPipeline((Supplier<TaskPipeline>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CompositePipeline.FeatureIDs.NAME -> 0;
        case CompositePipeline.FeatureIDs.ALLOCATE -> 1;
        case CompositePipeline.FeatureIDs.RECORD -> 2;
        case CompositePipeline.FeatureIDs.REPEAT -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case CompositePipeline.FeatureIDs.EXTENSION_PKG -> 0;
        case CompositePipeline.FeatureIDs.PIPELINES -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
