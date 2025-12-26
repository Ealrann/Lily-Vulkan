package org.sheepy.lily.vulkan.model.vulkanresource.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferDescriptor.Builder;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.impl.BufferDescriptorImpl;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class BufferDescriptorBuilder implements Builder {
  private String name;
  private EDescriptorType type = EDescriptorType.SAMPLER;
  private final List<EShaderStage> shaderStages = new ArrayList<>();
  private Supplier<IBuffer> buffer;

  public BufferDescriptorBuilder() {
  }

  @Override
  public BufferDescriptorBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public BufferDescriptorBuilder type(EDescriptorType type) {
    this.type = type;
    return this;
  }

  @Override
  public BufferDescriptorBuilder addShaderStage(EShaderStage shaderStage) {
    this.shaderStages.add(shaderStage);
    return this;
  }

  @Override
  public BufferDescriptorBuilder addShaderStages(final List<EShaderStage> shaderStages) {
    this.shaderStages.addAll(shaderStages);
    return this;
  }

  @Override
  public BufferDescriptorBuilder buffer(Supplier<IBuffer> buffer) {
    this.buffer = buffer;
    return this;
  }

  @Override
  public BufferDescriptor build() {
    final var built = new BufferDescriptorImpl(name, type, shaderStages, buffer.get());
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
    private static final FeatureInserter<BufferDescriptorBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<BufferDescriptorBuilder>(3, Inserters::attributeIndex).add(BufferDescriptor.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(BufferDescriptor.FeatureIDs.TYPE, (builder, value) -> builder.type((EDescriptorType) value)).add(BufferDescriptor.FeatureIDs.SHADER_STAGES, (builder, value) -> builder.addShaderStage((EShaderStage) value)).build();
    private static final RelationLazyInserter<BufferDescriptorBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<BufferDescriptorBuilder>(1, Inserters::relationIndex).add(BufferDescriptor.FeatureIDs.BUFFER, (builder, value) -> builder.buffer((Supplier<IBuffer>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case BufferDescriptor.FeatureIDs.NAME -> 0;
        case BufferDescriptor.FeatureIDs.TYPE -> 1;
        case BufferDescriptor.FeatureIDs.SHADER_STAGES -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case BufferDescriptor.FeatureIDs.BUFFER -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
