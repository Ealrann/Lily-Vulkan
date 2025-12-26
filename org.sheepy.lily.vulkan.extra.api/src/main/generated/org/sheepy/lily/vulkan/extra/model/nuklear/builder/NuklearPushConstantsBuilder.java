package org.sheepy.lily.vulkan.extra.model.nuklear.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearPushConstants.Builder;
import org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearPushConstantsImpl;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public final class NuklearPushConstantsBuilder implements Builder {
  private String name;
  private boolean enabled = true;
  private final List<EShaderStage> stages = new ArrayList<>();
  private int width;
  private int height;
  private int currentDescriptor;

  public NuklearPushConstantsBuilder() {
  }

  @Override
  public NuklearPushConstantsBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public NuklearPushConstantsBuilder enabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  @Override
  public NuklearPushConstantsBuilder addStage(EShaderStage stage) {
    this.stages.add(stage);
    return this;
  }

  @Override
  public NuklearPushConstantsBuilder addStages(final List<EShaderStage> stages) {
    this.stages.addAll(stages);
    return this;
  }

  @Override
  public NuklearPushConstantsBuilder width(int width) {
    this.width = width;
    return this;
  }

  @Override
  public NuklearPushConstantsBuilder height(int height) {
    this.height = height;
    return this;
  }

  @Override
  public NuklearPushConstantsBuilder currentDescriptor(int currentDescriptor) {
    this.currentDescriptor = currentDescriptor;
    return this;
  }

  @Override
  public NuklearPushConstants build() {
    final var built = new NuklearPushConstantsImpl(name, stages);
    built.enabled(enabled);
    built.width(width);
    built.height(height);
    built.currentDescriptor(currentDescriptor);
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
    private static final FeatureInserter<NuklearPushConstantsBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<NuklearPushConstantsBuilder>(6, Inserters::attributeIndex).add(NuklearPushConstants.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(NuklearPushConstants.FeatureIDs.ENABLED, (builder, value) -> builder.enabled((boolean) value)).add(NuklearPushConstants.FeatureIDs.STAGES, (builder, value) -> builder.addStage((EShaderStage) value)).add(NuklearPushConstants.FeatureIDs.WIDTH, (builder, value) -> builder.width((int) value)).add(NuklearPushConstants.FeatureIDs.HEIGHT, (builder, value) -> builder.height((int) value)).add(NuklearPushConstants.FeatureIDs.CURRENT_DESCRIPTOR, (builder, value) -> builder.currentDescriptor((int) value)).build();
    private static final RelationLazyInserter<NuklearPushConstantsBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<NuklearPushConstantsBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case NuklearPushConstants.FeatureIDs.NAME -> 0;
        case NuklearPushConstants.FeatureIDs.ENABLED -> 1;
        case NuklearPushConstants.FeatureIDs.STAGES -> 2;
        case NuklearPushConstants.FeatureIDs.WIDTH -> 3;
        case NuklearPushConstants.FeatureIDs.HEIGHT -> 4;
        case NuklearPushConstants.FeatureIDs.CURRENT_DESCRIPTOR -> 5;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
