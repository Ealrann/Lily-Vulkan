package org.sheepy.vulkan.model.graphicpipeline.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.vulkan.model.enumeration.EBlendFactor;
import org.sheepy.vulkan.model.enumeration.EBlendOp;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment.Builder;
import org.sheepy.vulkan.model.graphicpipeline.impl.ColorBlendAttachmentImpl;

public final class ColorBlendAttachmentBuilder implements Builder {
  private boolean blendEnable = false;
  private EBlendFactor srcColor = EBlendFactor.ONE;
  private EBlendFactor dstColor = EBlendFactor.ZERO;
  private EBlendFactor srcAlpha = EBlendFactor.ONE;
  private EBlendFactor dstAlpha = EBlendFactor.ZERO;
  private EBlendOp colorBlendOp = EBlendOp.ADD;
  private EBlendOp alphaBlendOp = EBlendOp.ADD;
  private boolean redComponentEnable = true;
  private boolean greenComponentEnable = true;
  private boolean blueComponentEnable = true;
  private boolean alphaComponentEnable = true;

  public ColorBlendAttachmentBuilder() {
  }

  @Override
  public ColorBlendAttachmentBuilder blendEnable(boolean blendEnable) {
    this.blendEnable = blendEnable;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder srcColor(EBlendFactor srcColor) {
    this.srcColor = srcColor;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder dstColor(EBlendFactor dstColor) {
    this.dstColor = dstColor;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder srcAlpha(EBlendFactor srcAlpha) {
    this.srcAlpha = srcAlpha;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder dstAlpha(EBlendFactor dstAlpha) {
    this.dstAlpha = dstAlpha;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder colorBlendOp(EBlendOp colorBlendOp) {
    this.colorBlendOp = colorBlendOp;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder alphaBlendOp(EBlendOp alphaBlendOp) {
    this.alphaBlendOp = alphaBlendOp;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder redComponentEnable(boolean redComponentEnable) {
    this.redComponentEnable = redComponentEnable;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder greenComponentEnable(boolean greenComponentEnable) {
    this.greenComponentEnable = greenComponentEnable;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder blueComponentEnable(boolean blueComponentEnable) {
    this.blueComponentEnable = blueComponentEnable;
    return this;
  }

  @Override
  public ColorBlendAttachmentBuilder alphaComponentEnable(boolean alphaComponentEnable) {
    this.alphaComponentEnable = alphaComponentEnable;
    return this;
  }

  @Override
  public ColorBlendAttachment build() {
    final var built = new ColorBlendAttachmentImpl();
    built.blendEnable(blendEnable);
    built.srcColor(srcColor);
    built.dstColor(dstColor);
    built.srcAlpha(srcAlpha);
    built.dstAlpha(dstAlpha);
    built.colorBlendOp(colorBlendOp);
    built.alphaBlendOp(alphaBlendOp);
    built.redComponentEnable(redComponentEnable);
    built.greenComponentEnable(greenComponentEnable);
    built.blueComponentEnable(blueComponentEnable);
    built.alphaComponentEnable(alphaComponentEnable);
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
    private static final FeatureInserter<ColorBlendAttachmentBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ColorBlendAttachmentBuilder>(11, Inserters::attributeIndex).add(ColorBlendAttachment.FeatureIDs.BLEND_ENABLE, (builder, value) -> builder.blendEnable((boolean) value)).add(ColorBlendAttachment.FeatureIDs.SRC_COLOR, (builder, value) -> builder.srcColor((EBlendFactor) value)).add(ColorBlendAttachment.FeatureIDs.DST_COLOR, (builder, value) -> builder.dstColor((EBlendFactor) value)).add(ColorBlendAttachment.FeatureIDs.SRC_ALPHA, (builder, value) -> builder.srcAlpha((EBlendFactor) value)).add(ColorBlendAttachment.FeatureIDs.DST_ALPHA, (builder, value) -> builder.dstAlpha((EBlendFactor) value)).add(ColorBlendAttachment.FeatureIDs.COLOR_BLEND_OP, (builder, value) -> builder.colorBlendOp((EBlendOp) value)).add(ColorBlendAttachment.FeatureIDs.ALPHA_BLEND_OP, (builder, value) -> builder.alphaBlendOp((EBlendOp) value)).add(ColorBlendAttachment.FeatureIDs.RED_COMPONENT_ENABLE, (builder, value) -> builder.redComponentEnable((boolean) value)).add(ColorBlendAttachment.FeatureIDs.GREEN_COMPONENT_ENABLE, (builder, value) -> builder.greenComponentEnable((boolean) value)).add(ColorBlendAttachment.FeatureIDs.BLUE_COMPONENT_ENABLE, (builder, value) -> builder.blueComponentEnable((boolean) value)).add(ColorBlendAttachment.FeatureIDs.ALPHA_COMPONENT_ENABLE, (builder, value) -> builder.alphaComponentEnable((boolean) value)).build();
    private static final RelationLazyInserter<ColorBlendAttachmentBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ColorBlendAttachmentBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ColorBlendAttachment.FeatureIDs.BLEND_ENABLE -> 0;
        case ColorBlendAttachment.FeatureIDs.SRC_COLOR -> 1;
        case ColorBlendAttachment.FeatureIDs.DST_COLOR -> 2;
        case ColorBlendAttachment.FeatureIDs.SRC_ALPHA -> 3;
        case ColorBlendAttachment.FeatureIDs.DST_ALPHA -> 4;
        case ColorBlendAttachment.FeatureIDs.COLOR_BLEND_OP -> 5;
        case ColorBlendAttachment.FeatureIDs.ALPHA_BLEND_OP -> 6;
        case ColorBlendAttachment.FeatureIDs.RED_COMPONENT_ENABLE -> 7;
        case ColorBlendAttachment.FeatureIDs.GREEN_COMPONENT_ENABLE -> 8;
        case ColorBlendAttachment.FeatureIDs.BLUE_COMPONENT_ENABLE -> 9;
        case ColorBlendAttachment.FeatureIDs.ALPHA_COMPONENT_ENABLE -> 10;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
