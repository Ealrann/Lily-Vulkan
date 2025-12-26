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
import org.sheepy.lily.vulkan.model.process.graphic.InputDescriptor;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState;
import org.sheepy.lily.vulkan.model.process.graphic.VertexInputState.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.VertexInputStateImpl;

public final class VertexInputStateBuilder implements Builder {
  private final List<Supplier<InputDescriptor>> inputDescriptor = new ArrayList<>();

  public VertexInputStateBuilder() {
  }

  @Override
  public VertexInputStateBuilder addInputDescriptor(Supplier<InputDescriptor> inputDescriptor) {
    this.inputDescriptor.add(inputDescriptor);
    return this;
  }

  @Override
  public VertexInputStateBuilder addInputDescriptor(final List<InputDescriptor> inputDescriptor) {
    inputDescriptor.forEach(value -> this.inputDescriptor.add(() -> value));
    return this;
  }

  @Override
  public VertexInputState build() {
    final var builtInputDescriptor = BuildUtils.collectSuppliers(inputDescriptor);
    final var built = new VertexInputStateImpl();
    built.inputDescriptor().addAll(builtInputDescriptor);
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
    private static final FeatureInserter<VertexInputStateBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<VertexInputStateBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<VertexInputStateBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<VertexInputStateBuilder>(1, Inserters::relationIndex).add(VertexInputState.FeatureIDs.INPUT_DESCRIPTOR, (builder, value) -> builder.addInputDescriptor((Supplier<InputDescriptor>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case VertexInputState.FeatureIDs.INPUT_DESCRIPTOR -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
