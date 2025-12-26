package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.vulkan.model.enumeration.ELogicOp;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend.Builder;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment;
import org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendImpl;

public final class ColorBlendBuilder implements Builder {
  private final List<Supplier<ColorBlendAttachment>> attachments = new ArrayList<>();
  private boolean logicOpEnable = false;
  private ELogicOp logicOp = ELogicOp.COPY;
  private int blendConstant0 = 0;
  private int blendConstant1 = 0;
  private int blendConstant2 = 0;
  private int blendConstant3 = 1;

  public ColorBlendBuilder() {
  }

  @Override
  public ColorBlendBuilder addAttachment(Supplier<ColorBlendAttachment> attachment) {
    this.attachments.add(attachment);
    return this;
  }

  @Override
  public ColorBlendBuilder addAttachments(final List<ColorBlendAttachment> attachments) {
    attachments.forEach(value -> this.attachments.add(() -> value));
    return this;
  }

  @Override
  public ColorBlendBuilder logicOpEnable(boolean logicOpEnable) {
    this.logicOpEnable = logicOpEnable;
    return this;
  }

  @Override
  public ColorBlendBuilder logicOp(ELogicOp logicOp) {
    this.logicOp = logicOp;
    return this;
  }

  @Override
  public ColorBlendBuilder blendConstant0(int blendConstant0) {
    this.blendConstant0 = blendConstant0;
    return this;
  }

  @Override
  public ColorBlendBuilder blendConstant1(int blendConstant1) {
    this.blendConstant1 = blendConstant1;
    return this;
  }

  @Override
  public ColorBlendBuilder blendConstant2(int blendConstant2) {
    this.blendConstant2 = blendConstant2;
    return this;
  }

  @Override
  public ColorBlendBuilder blendConstant3(int blendConstant3) {
    this.blendConstant3 = blendConstant3;
    return this;
  }

  @Override
  public ColorBlend build() {
    final var builtAttachments = BuildUtils.collectSuppliers(attachments);
    final var built = new ColorBlendImpl();
    built.attachments().addAll(builtAttachments);
    built.logicOpEnable(logicOpEnable);
    built.logicOp(logicOp);
    built.blendConstant0(blendConstant0);
    built.blendConstant1(blendConstant1);
    built.blendConstant2(blendConstant2);
    built.blendConstant3(blendConstant3);
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
    private static final FeatureInserter<ColorBlendBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ColorBlendBuilder>(6, Inserters::attributeIndex).add(ColorBlend.FeatureIDs.LOGIC_OP_ENABLE, (builder, value) -> builder.logicOpEnable((boolean) value)).add(ColorBlend.FeatureIDs.LOGIC_OP, (builder, value) -> builder.logicOp((ELogicOp) value)).add(ColorBlend.FeatureIDs.BLEND_CONSTANT0, (builder, value) -> builder.blendConstant0((int) value)).add(ColorBlend.FeatureIDs.BLEND_CONSTANT1, (builder, value) -> builder.blendConstant1((int) value)).add(ColorBlend.FeatureIDs.BLEND_CONSTANT2, (builder, value) -> builder.blendConstant2((int) value)).add(ColorBlend.FeatureIDs.BLEND_CONSTANT3, (builder, value) -> builder.blendConstant3((int) value)).build();
    private static final RelationLazyInserter<ColorBlendBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ColorBlendBuilder>(1, Inserters::relationIndex).add(ColorBlend.FeatureIDs.ATTACHMENTS, (builder, value) -> builder.addAttachment((Supplier<ColorBlendAttachment>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ColorBlend.FeatureIDs.LOGIC_OP_ENABLE -> 0;
        case ColorBlend.FeatureIDs.LOGIC_OP -> 1;
        case ColorBlend.FeatureIDs.BLEND_CONSTANT0 -> 2;
        case ColorBlend.FeatureIDs.BLEND_CONSTANT1 -> 3;
        case ColorBlend.FeatureIDs.BLEND_CONSTANT2 -> 4;
        case ColorBlend.FeatureIDs.BLEND_CONSTANT3 -> 5;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ColorBlend.FeatureIDs.ATTACHMENTS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
