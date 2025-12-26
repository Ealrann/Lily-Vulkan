package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.nio.ByteBuffer;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer;
import org.sheepy.lily.vulkan.extra.model.rendering.RenderProxyConstantBuffer.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.RenderProxyConstantBufferImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;

public final class RenderProxyConstantBufferBuilder implements Builder {
  private String name;
  private ByteBuffer data;
  private Supplier<ConstantBuffer> constantBuffer;
  private int partIndex;

  public RenderProxyConstantBufferBuilder() {
  }

  @Override
  public RenderProxyConstantBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public RenderProxyConstantBufferBuilder data(ByteBuffer data) {
    this.data = data;
    return this;
  }

  @Override
  public RenderProxyConstantBufferBuilder constantBuffer(Supplier<ConstantBuffer> constantBuffer) {
    this.constantBuffer = constantBuffer;
    return this;
  }

  @Override
  public RenderProxyConstantBufferBuilder partIndex(int partIndex) {
    this.partIndex = partIndex;
    return this;
  }

  @Override
  public RenderProxyConstantBuffer build() {
    final var built = new RenderProxyConstantBufferImpl(name, constantBuffer.get(), partIndex);
    built.data(data);
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
    private static final FeatureInserter<RenderProxyConstantBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<RenderProxyConstantBufferBuilder>(3, Inserters::attributeIndex).add(RenderProxyConstantBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(RenderProxyConstantBuffer.FeatureIDs.DATA, (builder, value) -> builder.data((ByteBuffer) value)).add(RenderProxyConstantBuffer.FeatureIDs.PART_INDEX, (builder, value) -> builder.partIndex((int) value)).build();
    private static final RelationLazyInserter<RenderProxyConstantBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<RenderProxyConstantBufferBuilder>(1, Inserters::relationIndex).add(RenderProxyConstantBuffer.FeatureIDs.CONSTANT_BUFFER, (builder, value) -> builder.constantBuffer((Supplier<ConstantBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case RenderProxyConstantBuffer.FeatureIDs.NAME -> 0;
        case RenderProxyConstantBuffer.FeatureIDs.DATA -> 1;
        case RenderProxyConstantBuffer.FeatureIDs.PART_INDEX -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case RenderProxyConstantBuffer.FeatureIDs.CONSTANT_BUFFER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
