package org.sheepy.lily.vulkan.extra.model.rendering.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor;
import org.sheepy.lily.vulkan.extra.model.rendering.DataDescriptor.Builder;
import org.sheepy.lily.vulkan.extra.model.rendering.impl.DataDescriptorImpl;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class DataDescriptorBuilder implements Builder {
  private int part;
  private int instance;
  private EDescriptorType descriptorType = EDescriptorType.SAMPLER;
  private final List<EShaderStage> stages = new ArrayList<>();

  public DataDescriptorBuilder() {
  }

  @Override
  public DataDescriptorBuilder part(int part) {
    this.part = part;
    return this;
  }

  @Override
  public DataDescriptorBuilder instance(int instance) {
    this.instance = instance;
    return this;
  }

  @Override
  public DataDescriptorBuilder descriptorType(EDescriptorType descriptorType) {
    this.descriptorType = descriptorType;
    return this;
  }

  @Override
  public DataDescriptorBuilder addStage(EShaderStage stage) {
    this.stages.add(stage);
    return this;
  }

  @Override
  public DataDescriptorBuilder addStages(final List<EShaderStage> stages) {
    this.stages.addAll(stages);
    return this;
  }

  @Override
  public DataDescriptor build() {
    final var built = new DataDescriptorImpl(part, instance, descriptorType, stages);
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
    private static final FeatureInserter<DataDescriptorBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DataDescriptorBuilder>(4, Inserters::attributeIndex).add(DataDescriptor.FeatureIDs.PART, (builder, value) -> builder.part((int) value)).add(DataDescriptor.FeatureIDs.INSTANCE, (builder, value) -> builder.instance((int) value)).add(DataDescriptor.FeatureIDs.DESCRIPTOR_TYPE, (builder, value) -> builder.descriptorType((EDescriptorType) value)).add(DataDescriptor.FeatureIDs.STAGES, (builder, value) -> builder.addStage((EShaderStage) value)).build();
    private static final RelationLazyInserter<DataDescriptorBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DataDescriptorBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DataDescriptor.FeatureIDs.PART -> 0;
        case DataDescriptor.FeatureIDs.INSTANCE -> 1;
        case DataDescriptor.FeatureIDs.DESCRIPTOR_TYPE -> 2;
        case DataDescriptor.FeatureIDs.STAGES -> 3;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
