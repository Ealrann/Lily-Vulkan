package org.sheepy.lily.vulkan.model.process.compute.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer;
import org.sheepy.lily.vulkan.model.process.compute.ComputeAcquirer.Builder;
import org.sheepy.lily.vulkan.model.process.compute.impl.ComputeAcquirerImpl;

public final class ComputeAcquirerBuilder implements Builder {
  public ComputeAcquirerBuilder() {
  }

  @Override
  public ComputeAcquirer build() {
    final var built = new ComputeAcquirerImpl();
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
    private static final FeatureInserter<ComputeAcquirerBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ComputeAcquirerBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<ComputeAcquirerBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ComputeAcquirerBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
