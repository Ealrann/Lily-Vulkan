package org.sheepy.lily.vulkan.model.process.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask;
import org.sheepy.lily.vulkan.model.process.CopyBufferTask.Builder;
import org.sheepy.lily.vulkan.model.process.impl.CopyBufferTaskImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;

public final class CopyBufferTaskBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private Supplier<BufferReference> srcBuffer;
  private Supplier<BufferReference> dstBuffer;

  public CopyBufferTaskBuilder() {
  }

  @Override
  public CopyBufferTaskBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public CopyBufferTaskBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public CopyBufferTaskBuilder srcBuffer(Supplier<BufferReference> srcBuffer) {
    this.srcBuffer = srcBuffer;
    return this;
  }

  @Override
  public CopyBufferTaskBuilder dstBuffer(Supplier<BufferReference> dstBuffer) {
    this.dstBuffer = dstBuffer;
    return this;
  }

  @Override
  public CopyBufferTask build() {
    final var built = new CopyBufferTaskImpl(name, srcBuffer.get(), dstBuffer.get());
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
    private static final FeatureInserter<CopyBufferTaskBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<CopyBufferTaskBuilder>(2, Inserters::attributeIndex).add(CopyBufferTask.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(CopyBufferTask.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).build();
    private static final RelationLazyInserter<CopyBufferTaskBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<CopyBufferTaskBuilder>(2, Inserters::relationIndex).add(CopyBufferTask.FeatureIDs.SRC_BUFFER, (builder, value) -> builder.srcBuffer((Supplier<BufferReference>) value)).add(CopyBufferTask.FeatureIDs.DST_BUFFER, (builder, value) -> builder.dstBuffer((Supplier<BufferReference>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case CopyBufferTask.FeatureIDs.NAME -> 0;
        case CopyBufferTask.FeatureIDs.ENABLED -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case CopyBufferTask.FeatureIDs.SRC_BUFFER -> 0;
        case CopyBufferTask.FeatureIDs.DST_BUFFER -> 1;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
