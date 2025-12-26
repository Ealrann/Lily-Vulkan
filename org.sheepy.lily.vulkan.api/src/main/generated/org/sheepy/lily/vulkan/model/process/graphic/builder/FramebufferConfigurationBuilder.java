package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration;
import org.sheepy.lily.vulkan.model.process.graphic.FramebufferConfiguration.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.FramebufferConfigurationImpl;

public final class FramebufferConfigurationBuilder implements Builder {
  public FramebufferConfigurationBuilder() {
  }

  @Override
  public FramebufferConfiguration build() {
    final var built = new FramebufferConfigurationImpl();
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
    private static final FeatureInserter<FramebufferConfigurationBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FramebufferConfigurationBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<FramebufferConfigurationBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FramebufferConfigurationBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
