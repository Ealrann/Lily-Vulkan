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
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.BindVertexBuffer.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.VertexBinding;
import org.sheepy.lily.vulkan.model.process.graphic.impl.BindVertexBufferImpl;

public final class BindVertexBufferBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private int firstBinding = 0;
  private final List<Supplier<VertexBinding>> vertexBindings = new ArrayList<>();

  public BindVertexBufferBuilder() {
  }

  @Override
  public BindVertexBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BindVertexBufferBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public BindVertexBufferBuilder firstBinding(int firstBinding) {
    this.firstBinding = firstBinding;
    return this;
  }

  @Override
  public BindVertexBufferBuilder addVertexBinding(Supplier<VertexBinding> vertexBinding) {
    this.vertexBindings.add(vertexBinding);
    return this;
  }

  @Override
  public BindVertexBufferBuilder addVertexBindings(final List<VertexBinding> vertexBindings) {
    vertexBindings.forEach(value -> this.vertexBindings.add(() -> value));
    return this;
  }

  @Override
  public BindVertexBuffer build() {
    final var builtVertexBindings = BuildUtils.collectSuppliers(vertexBindings);
    final var built = new BindVertexBufferImpl(name, builtVertexBindings);
    built.enabled(enabled);
    built.firstBinding(firstBinding);
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
    private static final FeatureInserter<BindVertexBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BindVertexBufferBuilder>(3, Inserters::attributeIndex).add(BindVertexBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(BindVertexBuffer.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(BindVertexBuffer.FeatureIDs.FIRST_BINDING, (builder, value) -> builder.firstBinding((int) value)).build();
    private static final RelationLazyInserter<BindVertexBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BindVertexBufferBuilder>(1, Inserters::relationIndex).add(BindVertexBuffer.FeatureIDs.VERTEX_BINDINGS, (builder, value) -> builder.addVertexBinding((Supplier<VertexBinding>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BindVertexBuffer.FeatureIDs.NAME -> 0;
        case BindVertexBuffer.FeatureIDs.ENABLED -> 1;
        case BindVertexBuffer.FeatureIDs.FIRST_BINDING -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BindVertexBuffer.FeatureIDs.VERTEX_BINDINGS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
