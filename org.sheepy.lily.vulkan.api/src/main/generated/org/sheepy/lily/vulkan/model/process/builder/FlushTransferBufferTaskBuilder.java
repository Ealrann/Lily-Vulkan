package org.sheepy.lily.vulkan.model.process.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask;
import org.sheepy.lily.vulkan.model.process.FlushTransferBufferTask.Builder;
import org.sheepy.lily.vulkan.model.process.impl.FlushTransferBufferTaskImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.TransferBuffer;

public final class FlushTransferBufferTaskBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private Supplier<TransferBuffer> transferBuffer;

  public FlushTransferBufferTaskBuilder() {
  }

  @Override
  public FlushTransferBufferTaskBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FlushTransferBufferTaskBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public FlushTransferBufferTaskBuilder transferBuffer(Supplier<TransferBuffer> transferBuffer) {
    this.transferBuffer = transferBuffer;
    return this;
  }

  @Override
  public FlushTransferBufferTask build() {
    final var built = new FlushTransferBufferTaskImpl(name, transferBuffer.get());
    built.enabled(enabled);
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
    private static final FeatureInserter<FlushTransferBufferTaskBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FlushTransferBufferTaskBuilder>(2, Inserters::attributeIndex).add(FlushTransferBufferTask.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(FlushTransferBufferTask.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).build();
    private static final RelationLazyInserter<FlushTransferBufferTaskBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FlushTransferBufferTaskBuilder>(1, Inserters::relationIndex).add(FlushTransferBufferTask.FeatureIDs.TRANSFER_BUFFER, (builder, value) -> builder.transferBuffer((Supplier<TransferBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case FlushTransferBufferTask.FeatureIDs.NAME -> 0;
        case FlushTransferBufferTask.FeatureIDs.ENABLED -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case FlushTransferBufferTask.FeatureIDs.TRANSFER_BUFFER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
