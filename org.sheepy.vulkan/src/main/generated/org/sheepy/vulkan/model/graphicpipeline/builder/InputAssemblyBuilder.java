package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.EPrimitiveTopology;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly;
import org.sheepy.vulkan.model.graphicpipeline.InputAssembly.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.InputAssemblyImpl;

public final class InputAssemblyBuilder implements Builder {
  private boolean primitiveRestartEnabled = false;
  private EPrimitiveTopology primitiveTopology = EPrimitiveTopology.TRIANGLE_LIST;

  public InputAssemblyBuilder() {
  }

  @Override
  public InputAssemblyBuilder primitiveRestartEnabled(boolean primitiveRestartEnabled) {
    this.primitiveRestartEnabled = primitiveRestartEnabled;
    return this;
  }

  @Override
  public InputAssemblyBuilder primitiveTopology(EPrimitiveTopology primitiveTopology) {
    this.primitiveTopology = primitiveTopology;
    return this;
  }

  @Override
  public InputAssembly build() {
    final var built = new InputAssemblyImpl();
    built.primitiveRestartEnabled(primitiveRestartEnabled);
    built.primitiveTopology(primitiveTopology);
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
    private static final FeatureInserter<InputAssemblyBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<InputAssemblyBuilder>(2, Inserters::attributeIndex).add(InputAssembly.FeatureIDs.PRIMITIVE_RESTART_ENABLED, (builder, value) -> builder.primitiveRestartEnabled((boolean) value)).add(InputAssembly.FeatureIDs.PRIMITIVE_TOPOLOGY, (builder, value) -> builder.primitiveTopology((EPrimitiveTopology) value)).build();
    private static final RelationLazyInserter<InputAssemblyBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<InputAssemblyBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case InputAssembly.FeatureIDs.PRIMITIVE_RESTART_ENABLED -> 0;
        case InputAssembly.FeatureIDs.PRIMITIVE_TOPOLOGY -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
