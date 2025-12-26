package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.TransferBufferImpl;

public final class TransferBufferBuilder implements Builder {
  private String name;
  private long size;
  private boolean usedToPush = true;
  private boolean usedToFetch = false;

  public TransferBufferBuilder() {
  }

  @Override
  public TransferBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public TransferBufferBuilder size(long size) {
    this.size = size;
    return this;
  }

  @Override
  public TransferBufferBuilder usedToPush(boolean usedToPush) {
    this.usedToPush = usedToPush;
    return this;
  }

  @Override
  public TransferBufferBuilder usedToFetch(boolean usedToFetch) {
    this.usedToFetch = usedToFetch;
    return this;
  }

  @Override
  public TransferBuffer build() {
    final var built = new TransferBufferImpl(name, usedToPush, usedToFetch);
    built.size(size);
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
    private static final FeatureInserter<TransferBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<TransferBufferBuilder>(4, Inserters::attributeIndex).add(TransferBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(TransferBuffer.FeatureIDs.SIZE, (builder, value) -> builder.size((long) value)).add(TransferBuffer.FeatureIDs.USED_TO_PUSH, (builder, value) -> builder.usedToPush((boolean) value)).add(TransferBuffer.FeatureIDs.USED_TO_FETCH, (builder, value) -> builder.usedToFetch((boolean) value)).build();
    private static final RelationLazyInserter<TransferBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<TransferBufferBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case TransferBuffer.FeatureIDs.NAME -> 0;
        case TransferBuffer.FeatureIDs.SIZE -> 1;
        case TransferBuffer.FeatureIDs.USED_TO_PUSH -> 2;
        case TransferBuffer.FeatureIDs.USED_TO_FETCH -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
