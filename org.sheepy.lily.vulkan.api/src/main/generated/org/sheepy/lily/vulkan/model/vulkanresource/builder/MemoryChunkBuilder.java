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
import org.sheepy.lily.vulkan.model.vulkanresource.IMemoryChunkPart;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.MemoryChunkImpl;

public final class MemoryChunkBuilder implements Builder {
  private String name;
  private final List<Supplier<IMemoryChunkPart>> parts = new ArrayList<>();
  private Supplier<TransferBuffer> transferBuffer = () -> null;

  public MemoryChunkBuilder() {
  }

  @Override
  public MemoryChunkBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public MemoryChunkBuilder addPart(Supplier<IMemoryChunkPart> part) {
    this.parts.add(part);
    return this;
  }

  @Override
  public MemoryChunkBuilder addParts(final List<IMemoryChunkPart> parts) {
    parts.forEach(value -> this.parts.add(() -> value));
    return this;
  }

  @Override
  public MemoryChunkBuilder transferBuffer(Supplier<TransferBuffer> transferBuffer) {
    this.transferBuffer = transferBuffer;
    return this;
  }

  @Override
  public MemoryChunk build() {
    final var builtParts = BuildUtils.collectSuppliers(parts);
    final var built = new MemoryChunkImpl(name);
    built.parts().addAll(builtParts);
    built.transferBuffer(transferBuffer.get());
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
    private static final FeatureInserter<MemoryChunkBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<MemoryChunkBuilder>(1, Inserters::attributeIndex).add(MemoryChunk.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<MemoryChunkBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<MemoryChunkBuilder>(2, Inserters::relationIndex).add(MemoryChunk.FeatureIDs.PARTS, (builder, value) -> builder.addPart((Supplier<IMemoryChunkPart>) value)).add(MemoryChunk.FeatureIDs.TRANSFER_BUFFER, (builder, value) -> builder.transferBuffer((Supplier<TransferBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case MemoryChunk.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case MemoryChunk.FeatureIDs.PARTS -> 0;
        case MemoryChunk.FeatureIDs.TRANSFER_BUFFER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
