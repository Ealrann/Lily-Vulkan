package org.sheepy.lily.vulkan.model.process.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer;
import org.sheepy.lily.vulkan.model.process.PushConstantBuffer.Builder;
import org.sheepy.lily.vulkan.model.process.impl.PushConstantBufferImpl;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class PushConstantBufferBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private final List<EShaderStage> stages = new ArrayList<>();
  private Supplier<ConstantBuffer> buffer;

  public PushConstantBufferBuilder() {
  }

  @Override
  public PushConstantBufferBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public PushConstantBufferBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public PushConstantBufferBuilder addStage(EShaderStage stage) {
    this.stages.add(stage);
    return this;
  }

  @Override
  public PushConstantBufferBuilder addStages(final List<EShaderStage> stages) {
    this.stages.addAll(stages);
    return this;
  }

  @Override
  public PushConstantBufferBuilder buffer(Supplier<ConstantBuffer> buffer) {
    this.buffer = buffer;
    return this;
  }

  @Override
  public PushConstantBuffer build() {
    final var built = new PushConstantBufferImpl(name, stages, buffer.get());
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
    private static final FeatureInserter<PushConstantBufferBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PushConstantBufferBuilder>(3, Inserters::attributeIndex).add(PushConstantBuffer.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(PushConstantBuffer.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(PushConstantBuffer.FeatureIDs.STAGES, (builder, value) -> builder.addStage((EShaderStage) value)).build();
    private static final RelationLazyInserter<PushConstantBufferBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PushConstantBufferBuilder>(1, Inserters::relationIndex).add(PushConstantBuffer.FeatureIDs.BUFFER, (builder, value) -> builder.buffer((Supplier<ConstantBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case PushConstantBuffer.FeatureIDs.NAME -> 0;
        case PushConstantBuffer.FeatureIDs.ENABLED -> 1;
        case PushConstantBuffer.FeatureIDs.STAGES -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case PushConstantBuffer.FeatureIDs.BUFFER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
