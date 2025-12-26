package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.EBlendFactor;
import org.sheepy.vulkan.model.enumeration.EBlendOp;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;

public final class ColorBlendAttachmentImpl extends FeaturedObject<ColorBlendAttachment.Features<?>> implements ColorBlendAttachment {
  private static final int FEATURE_COUNT = 11;
  private final ModelNotifier<ColorBlendAttachment.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private boolean blendEnable;
  private EBlendFactor srcColor;
  private EBlendFactor dstColor;
  private EBlendFactor srcAlpha;
  private EBlendFactor dstAlpha;
  private EBlendOp colorBlendOp;
  private EBlendOp alphaBlendOp;
  private boolean redComponentEnable;
  private boolean greenComponentEnable;
  private boolean blueComponentEnable;
  private boolean alphaComponentEnable;

  public ColorBlendAttachmentImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ColorBlendAttachment.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public boolean blendEnable() {
    return blendEnable;
  }

  @Override
  public void blendEnable(final boolean blendEnable) {
    final var oldValue = this.blendEnable;
    this.blendEnable = blendEnable;
    notifier.notifyBoolean(ColorBlendAttachment.FeatureIDs.BLEND_ENABLE, false, false, oldValue, blendEnable);
  }

  @Override
  public EBlendFactor srcColor() {
    return srcColor;
  }

  @Override
  public void srcColor(final EBlendFactor srcColor) {
    final var oldValue = this.srcColor;
    this.srcColor = srcColor;
    notifier.notify(ColorBlendAttachment.FeatureIDs.SRC_COLOR, false, false, oldValue, srcColor);
  }

  @Override
  public EBlendFactor dstColor() {
    return dstColor;
  }

  @Override
  public void dstColor(final EBlendFactor dstColor) {
    final var oldValue = this.dstColor;
    this.dstColor = dstColor;
    notifier.notify(ColorBlendAttachment.FeatureIDs.DST_COLOR, false, false, oldValue, dstColor);
  }

  @Override
  public EBlendFactor srcAlpha() {
    return srcAlpha;
  }

  @Override
  public void srcAlpha(final EBlendFactor srcAlpha) {
    final var oldValue = this.srcAlpha;
    this.srcAlpha = srcAlpha;
    notifier.notify(ColorBlendAttachment.FeatureIDs.SRC_ALPHA, false, false, oldValue, srcAlpha);
  }

  @Override
  public EBlendFactor dstAlpha() {
    return dstAlpha;
  }

  @Override
  public void dstAlpha(final EBlendFactor dstAlpha) {
    final var oldValue = this.dstAlpha;
    this.dstAlpha = dstAlpha;
    notifier.notify(ColorBlendAttachment.FeatureIDs.DST_ALPHA, false, false, oldValue, dstAlpha);
  }

  @Override
  public EBlendOp colorBlendOp() {
    return colorBlendOp;
  }

  @Override
  public void colorBlendOp(final EBlendOp colorBlendOp) {
    final var oldValue = this.colorBlendOp;
    this.colorBlendOp = colorBlendOp;
    notifier.notify(ColorBlendAttachment.FeatureIDs.COLOR_BLEND_OP, false, false, oldValue, colorBlendOp);
  }

  @Override
  public EBlendOp alphaBlendOp() {
    return alphaBlendOp;
  }

  @Override
  public void alphaBlendOp(final EBlendOp alphaBlendOp) {
    final var oldValue = this.alphaBlendOp;
    this.alphaBlendOp = alphaBlendOp;
    notifier.notify(ColorBlendAttachment.FeatureIDs.ALPHA_BLEND_OP, false, false, oldValue, alphaBlendOp);
  }

  @Override
  public boolean redComponentEnable() {
    return redComponentEnable;
  }

  @Override
  public void redComponentEnable(final boolean redComponentEnable) {
    final var oldValue = this.redComponentEnable;
    this.redComponentEnable = redComponentEnable;
    notifier.notifyBoolean(ColorBlendAttachment.FeatureIDs.RED_COMPONENT_ENABLE, false, false, oldValue, redComponentEnable);
  }

  @Override
  public boolean greenComponentEnable() {
    return greenComponentEnable;
  }

  @Override
  public void greenComponentEnable(final boolean greenComponentEnable) {
    final var oldValue = this.greenComponentEnable;
    this.greenComponentEnable = greenComponentEnable;
    notifier.notifyBoolean(ColorBlendAttachment.FeatureIDs.GREEN_COMPONENT_ENABLE, false, false, oldValue, greenComponentEnable);
  }

  @Override
  public boolean blueComponentEnable() {
    return blueComponentEnable;
  }

  @Override
  public void blueComponentEnable(final boolean blueComponentEnable) {
    final var oldValue = this.blueComponentEnable;
    this.blueComponentEnable = blueComponentEnable;
    notifier.notifyBoolean(ColorBlendAttachment.FeatureIDs.BLUE_COMPONENT_ENABLE, false, false, oldValue, blueComponentEnable);
  }

  @Override
  public boolean alphaComponentEnable() {
    return alphaComponentEnable;
  }

  @Override
  public void alphaComponentEnable(final boolean alphaComponentEnable) {
    final var oldValue = this.alphaComponentEnable;
    this.alphaComponentEnable = alphaComponentEnable;
    notifier.notifyBoolean(ColorBlendAttachment.FeatureIDs.ALPHA_COMPONENT_ENABLE, false, false, oldValue, alphaComponentEnable);
  }

  @Override
  public Group<ColorBlendAttachment> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.COLOR_BLEND_ATTACHMENT;
  }

  @Override
  protected FeatureSetter<ColorBlendAttachment> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ColorBlendAttachment> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
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
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ColorBlendAttachment> GET_MAP = new FeatureGetter.Builder<ColorBlendAttachment>(FEATURE_COUNT, ColorBlendAttachmentImpl::featureIndexStatic).add(ColorBlendAttachment.FeatureIDs.BLEND_ENABLE, ColorBlendAttachment::blendEnable).add(ColorBlendAttachment.FeatureIDs.SRC_COLOR, ColorBlendAttachment::srcColor).add(ColorBlendAttachment.FeatureIDs.DST_COLOR, ColorBlendAttachment::dstColor).add(ColorBlendAttachment.FeatureIDs.SRC_ALPHA, ColorBlendAttachment::srcAlpha).add(ColorBlendAttachment.FeatureIDs.DST_ALPHA, ColorBlendAttachment::dstAlpha).add(ColorBlendAttachment.FeatureIDs.COLOR_BLEND_OP, ColorBlendAttachment::colorBlendOp).add(ColorBlendAttachment.FeatureIDs.ALPHA_BLEND_OP, ColorBlendAttachment::alphaBlendOp).add(ColorBlendAttachment.FeatureIDs.RED_COMPONENT_ENABLE, ColorBlendAttachment::redComponentEnable).add(ColorBlendAttachment.FeatureIDs.GREEN_COMPONENT_ENABLE, ColorBlendAttachment::greenComponentEnable).add(ColorBlendAttachment.FeatureIDs.BLUE_COMPONENT_ENABLE, ColorBlendAttachment::blueComponentEnable).add(ColorBlendAttachment.FeatureIDs.ALPHA_COMPONENT_ENABLE, ColorBlendAttachment::alphaComponentEnable).build();
    private static final FeatureSetter<ColorBlendAttachment> SET_MAP = new FeatureSetter.Builder<ColorBlendAttachment>(FEATURE_COUNT, ColorBlendAttachmentImpl::featureIndexStatic).add(ColorBlendAttachment.FeatureIDs.BLEND_ENABLE, (object, value) -> ((ColorBlendAttachmentImpl) object).blendEnable((boolean) value)).add(ColorBlendAttachment.FeatureIDs.SRC_COLOR, (object, value) -> ((ColorBlendAttachmentImpl) object).srcColor((EBlendFactor) value)).add(ColorBlendAttachment.FeatureIDs.DST_COLOR, (object, value) -> ((ColorBlendAttachmentImpl) object).dstColor((EBlendFactor) value)).add(ColorBlendAttachment.FeatureIDs.SRC_ALPHA, (object, value) -> ((ColorBlendAttachmentImpl) object).srcAlpha((EBlendFactor) value)).add(ColorBlendAttachment.FeatureIDs.DST_ALPHA, (object, value) -> ((ColorBlendAttachmentImpl) object).dstAlpha((EBlendFactor) value)).add(ColorBlendAttachment.FeatureIDs.COLOR_BLEND_OP, (object, value) -> ((ColorBlendAttachmentImpl) object).colorBlendOp((EBlendOp) value)).add(ColorBlendAttachment.FeatureIDs.ALPHA_BLEND_OP, (object, value) -> ((ColorBlendAttachmentImpl) object).alphaBlendOp((EBlendOp) value)).add(ColorBlendAttachment.FeatureIDs.RED_COMPONENT_ENABLE, (object, value) -> ((ColorBlendAttachmentImpl) object).redComponentEnable((boolean) value)).add(ColorBlendAttachment.FeatureIDs.GREEN_COMPONENT_ENABLE, (object, value) -> ((ColorBlendAttachmentImpl) object).greenComponentEnable((boolean) value)).add(ColorBlendAttachment.FeatureIDs.BLUE_COMPONENT_ENABLE, (object, value) -> ((ColorBlendAttachmentImpl) object).blueComponentEnable((boolean) value)).add(ColorBlendAttachment.FeatureIDs.ALPHA_COMPONENT_ENABLE, (object, value) -> ((ColorBlendAttachmentImpl) object).alphaComponentEnable((boolean) value)).build();
  }
}
