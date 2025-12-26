package org.sheepy.lily.vulkan.model.process.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.FetchBuffer;
import org.sheepy.lily.vulkan.model.process.FetchBuffer.Builder;
import org.sheepy.lily.vulkan.model.process.impl.FetchBufferImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferReference;

public final class FetchBufferBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private Supplier<BufferReference> bufferReference;

  public FetchBufferBuilder() {
  }

  @Override
  public FetchBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public FetchBufferBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public FetchBufferBuilder bufferReference(Supplier<BufferReference> bufferReference) {
    this.bufferReference = bufferReference;
    return this;
  }

  @Override
  public FetchBuffer build() {
    final var built = new FetchBufferImpl(name, bufferReference.get());
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
    private static final FeatureInserter<FetchBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<FetchBufferBuilder>(2, Inserters::attributeIndex).add(FetchBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(FetchBuffer.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).build();
    private static final RelationLazyInserter<FetchBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<FetchBufferBuilder>(1, Inserters::relationIndex).add(FetchBuffer.FeatureIDs.BUFFER_REFERENCE, (builder, value) -> builder.bufferReference((Supplier<BufferReference>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case FetchBuffer.FeatureIDs.NAME -> 0;
        case FetchBuffer.FeatureIDs.ENABLED -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case FetchBuffer.FeatureIDs.BUFFER_REFERENCE -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
