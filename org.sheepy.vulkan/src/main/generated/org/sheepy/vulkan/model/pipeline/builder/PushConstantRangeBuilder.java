package org.sheepy.vulkan.model.pipeline.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.pipeline.PushConstantRange;
import org.sheepy.vulkan.model.pipeline.PushConstantRange.Builder;
import org.sheepy.vulkan.model.pipeline.impl.PushConstantRangeImpl;

public final class PushConstantRangeBuilder implements Builder {
  private final List<EShaderStage> stages = new ArrayList<>();
  private int offset = 0;
  private int size;

  public PushConstantRangeBuilder() {
  }

  @Override
  public PushConstantRangeBuilder addStage(EShaderStage stage) {
    this.stages.add(stage);
    return this;
  }

  @Override
  public PushConstantRangeBuilder addStages(final List<EShaderStage> stages) {
    this.stages.addAll(stages);
    return this;
  }

  @Override
  public PushConstantRangeBuilder offset(int offset) {
    this.offset = offset;
    return this;
  }

  @Override
  public PushConstantRangeBuilder size(int size) {
    this.size = size;
    return this;
  }

  @Override
  public PushConstantRange build() {
    final var built = new PushConstantRangeImpl(stages);
    built.offset(offset);
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
    private static final FeatureInserter<PushConstantRangeBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<PushConstantRangeBuilder>(3, Inserters::attributeIndex).add(PushConstantRange.FeatureIDs.STAGES, (builder, value) -> builder.addStage((EShaderStage) value)).add(PushConstantRange.FeatureIDs.OFFSET, (builder, value) -> builder.offset((int) value)).add(PushConstantRange.FeatureIDs.SIZE, (builder, value) -> builder.size((int) value)).build();
    private static final RelationLazyInserter<PushConstantRangeBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<PushConstantRangeBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case PushConstantRange.FeatureIDs.STAGES -> 0;
        case PushConstantRange.FeatureIDs.OFFSET -> 1;
        case PushConstantRange.FeatureIDs.SIZE -> 2;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
