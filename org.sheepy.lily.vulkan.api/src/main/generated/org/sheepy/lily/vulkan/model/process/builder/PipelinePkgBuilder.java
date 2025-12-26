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
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.PipelinePkg;
import org.sheepy.lily.vulkan.model.process.PipelinePkg.Builder;
import org.sheepy.lily.vulkan.model.process.impl.PipelinePkgImpl;

public final class PipelinePkgBuilder implements Builder {
  private final List<Supplier<AbstractPipeline>> pipelines = new ArrayList<>();

  public PipelinePkgBuilder() {
  }

  @Override
  public PipelinePkgBuilder addPipeline(Supplier<AbstractPipeline> pipeline) {
    this.pipelines.add(pipeline);
    return this;
  }

  @Override
  public PipelinePkgBuilder addPipelines(final List<AbstractPipeline> pipelines) {
    pipelines.forEach(value -> this.pipelines.add(() -> value));
    return this;
  }

  @Override
  public PipelinePkg build() {
    final var builtPipelines = BuildUtils.collectSuppliers(pipelines);
    final var built = new PipelinePkgImpl();
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
    private static final FeatureInserter<PipelinePkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PipelinePkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<PipelinePkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PipelinePkgBuilder>(1, Inserters::relationIndex).add(PipelinePkg.FeatureIDs.PIPELINES, (builder, value) -> builder.addPipeline((Supplier<AbstractPipeline>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case PipelinePkg.FeatureIDs.PIPELINES -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
