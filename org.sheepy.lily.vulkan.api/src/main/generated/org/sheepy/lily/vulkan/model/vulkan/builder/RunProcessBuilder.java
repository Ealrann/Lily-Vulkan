package org.sheepy.lily.vulkan.model.vulkan.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkan.IProcess;
import org.sheepy.lily.vulkan.model.vulkan.RunProcess;
import org.sheepy.lily.vulkan.model.vulkan.RunProcess.Builder;
import org.sheepy.lily.vulkan.model.vulkan.impl.RunProcessImpl;

public final class RunProcessBuilder implements Builder {
  private Supplier<IProcess> process;

  public RunProcessBuilder() {
  }

  @Override
  public RunProcessBuilder process(Supplier<IProcess> process) {
    this.process = process;
    return this;
  }

  @Override
  public RunProcess build() {
    final var built = new RunProcessImpl(process);
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
    private static final FeatureInserter<RunProcessBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<RunProcessBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<RunProcessBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<RunProcessBuilder>(1, Inserters::relationIndex).add(RunProcess.FeatureIDs.PROCESS, (builder, value) -> builder.process((Supplier<IProcess>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case RunProcess.FeatureIDs.PROCESS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
