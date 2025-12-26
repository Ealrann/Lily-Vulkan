package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferMemoryImpl;

public final class BufferMemoryBuilder implements Builder {
  private String name;
  private final List<Supplier<IBuffer>> buffers = new ArrayList<>();

  public BufferMemoryBuilder() {
  }

  @Override
  public BufferMemoryBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BufferMemoryBuilder addBuffer(Supplier<IBuffer> buffer) {
    this.buffers.add(buffer);
    return this;
  }

  @Override
  public BufferMemoryBuilder addBuffers(final List<IBuffer> buffers) {
    buffers.forEach(value -> this.buffers.add(() -> value));
    return this;
  }

  @Override
  public BufferMemory build() {
    final var builtBuffers = BuildUtils.collectSuppliers(buffers);
    final var built = new BufferMemoryImpl(name);
    built.buffers().addAll(builtBuffers);
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
    private static final FeatureInserter<BufferMemoryBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BufferMemoryBuilder>(1, Inserters::attributeIndex).add(BufferMemory.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<BufferMemoryBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BufferMemoryBuilder>(1, Inserters::relationIndex).add(BufferMemory.FeatureIDs.BUFFERS, (builder, value) -> builder.addBuffer((Supplier<IBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BufferMemory.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BufferMemory.FeatureIDs.BUFFERS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
