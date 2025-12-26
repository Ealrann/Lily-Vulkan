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
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.EContextIndex;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferReferenceImpl;

public final class BufferReferenceBuilder implements Builder {
  private final List<Supplier<IBuffer>> buffers = new ArrayList<>();
  private int stride = 0;
  private EContextIndex indexType = EContextIndex.ContextInstance;

  public BufferReferenceBuilder() {
  }

  @Override
  public BufferReferenceBuilder addBuffer(Supplier<IBuffer> buffer) {
    this.buffers.add(buffer);
    return this;
  }

  @Override
  public BufferReferenceBuilder addBuffers(final List<IBuffer> buffers) {
    buffers.forEach(value -> this.buffers.add(() -> value));
    return this;
  }

  @Override
  public BufferReferenceBuilder stride(int stride) {
    this.stride = stride;
    return this;
  }

  @Override
  public BufferReferenceBuilder indexType(EContextIndex indexType) {
    this.indexType = indexType;
    return this;
  }

  @Override
  public BufferReference build() {
    final var builtBuffers = BuildUtils.collectSuppliers(buffers);
    final var built = new BufferReferenceImpl(indexType);
    built.buffers().addAll(builtBuffers);
    built.stride(stride);
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
    private static final FeatureInserter<BufferReferenceBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BufferReferenceBuilder>(2, Inserters::attributeIndex).add(BufferReference.FeatureIDs.STRIDE, (builder, value) -> builder.stride((int) value)).add(BufferReference.FeatureIDs.INDEX_TYPE, (builder, value) -> builder.indexType((EContextIndex) value)).build();
    private static final RelationLazyInserter<BufferReferenceBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BufferReferenceBuilder>(1, Inserters::relationIndex).add(BufferReference.FeatureIDs.BUFFERS, (builder, value) -> builder.addBuffer((Supplier<IBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BufferReference.FeatureIDs.STRIDE -> 0;
        case BufferReference.FeatureIDs.INDEX_TYPE -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BufferReference.FeatureIDs.BUFFERS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
