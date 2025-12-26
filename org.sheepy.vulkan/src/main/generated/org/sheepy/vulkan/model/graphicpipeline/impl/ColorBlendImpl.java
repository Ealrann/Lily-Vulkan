package org.sheepy.vulkan.model.graphicpipeline.impl;

import java.util.List;
import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.vulkan.model.enumeration.ELogicOp;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlend;
import org.sheepy.vulkan.model.graphicpipeline.ColorBlendAttachment;
import org.sheepy.vulkan.model.graphicpipeline.GraphicPipelineModelDefinition;

public final class ColorBlendImpl extends FeaturedObject<ColorBlend.Features<?>> implements ColorBlend {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<ColorBlend.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final List<ColorBlendAttachment> attachments = newObservableList(ColorBlend.FeatureIDs.ATTACHMENTS, true, true);
  private boolean logicOpEnable;
  private ELogicOp logicOp;
  private int blendConstant0;
  private int blendConstant1;
  private int blendConstant2;
  private int blendConstant3;

  public ColorBlendImpl() {
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<ColorBlend.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public List<ColorBlendAttachment> attachments() {
    return attachments;
  }

  @Override
  public boolean logicOpEnable() {
    return logicOpEnable;
  }

  @Override
  public void logicOpEnable(final boolean logicOpEnable) {
    final var oldValue = this.logicOpEnable;
    this.logicOpEnable = logicOpEnable;
    notifier.notifyBoolean(ColorBlend.FeatureIDs.LOGIC_OP_ENABLE, false, false, oldValue, logicOpEnable);
  }

  @Override
  public ELogicOp logicOp() {
    return logicOp;
  }

  @Override
  public void logicOp(final ELogicOp logicOp) {
    final var oldValue = this.logicOp;
    this.logicOp = logicOp;
    notifier.notify(ColorBlend.FeatureIDs.LOGIC_OP, false, false, oldValue, logicOp);
  }

  @Override
  public int blendConstant0() {
    return blendConstant0;
  }

  @Override
  public void blendConstant0(final int blendConstant0) {
    final var oldValue = this.blendConstant0;
    this.blendConstant0 = blendConstant0;
    notifier.notifyInt(ColorBlend.FeatureIDs.BLEND_CONSTANT0, false, false, oldValue, blendConstant0);
  }

  @Override
  public int blendConstant1() {
    return blendConstant1;
  }

  @Override
  public void blendConstant1(final int blendConstant1) {
    final var oldValue = this.blendConstant1;
    this.blendConstant1 = blendConstant1;
    notifier.notifyInt(ColorBlend.FeatureIDs.BLEND_CONSTANT1, false, false, oldValue, blendConstant1);
  }

  @Override
  public int blendConstant2() {
    return blendConstant2;
  }

  @Override
  public void blendConstant2(final int blendConstant2) {
    final var oldValue = this.blendConstant2;
    this.blendConstant2 = blendConstant2;
    notifier.notifyInt(ColorBlend.FeatureIDs.BLEND_CONSTANT2, false, false, oldValue, blendConstant2);
  }

  @Override
  public int blendConstant3() {
    return blendConstant3;
  }

  @Override
  public void blendConstant3(final int blendConstant3) {
    final var oldValue = this.blendConstant3;
    this.blendConstant3 = blendConstant3;
    notifier.notifyInt(ColorBlend.FeatureIDs.BLEND_CONSTANT3, false, false, oldValue, blendConstant3);
  }

  @Override
  public Group<ColorBlend> lmGroup() {
    return GraphicPipelineModelDefinition.Groups.COLOR_BLEND;
  }

  @Override
  protected FeatureSetter<ColorBlend> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<ColorBlend> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case ColorBlend.FeatureIDs.ATTACHMENTS -> 0;
      case ColorBlend.FeatureIDs.LOGIC_OP_ENABLE -> 1;
      case ColorBlend.FeatureIDs.LOGIC_OP -> 2;
      case ColorBlend.FeatureIDs.BLEND_CONSTANT0 -> 3;
      case ColorBlend.FeatureIDs.BLEND_CONSTANT1 -> 4;
      case ColorBlend.FeatureIDs.BLEND_CONSTANT2 -> 5;
      case ColorBlend.FeatureIDs.BLEND_CONSTANT3 -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<ColorBlend> GET_MAP = new FeatureGetter.Builder<ColorBlend>(FEATURE_COUNT, ColorBlendImpl::featureIndexStatic).add(ColorBlend.FeatureIDs.ATTACHMENTS, ColorBlend::attachments).add(ColorBlend.FeatureIDs.LOGIC_OP_ENABLE, ColorBlend::logicOpEnable).add(ColorBlend.FeatureIDs.LOGIC_OP, ColorBlend::logicOp).add(ColorBlend.FeatureIDs.BLEND_CONSTANT0, ColorBlend::blendConstant0).add(ColorBlend.FeatureIDs.BLEND_CONSTANT1, ColorBlend::blendConstant1).add(ColorBlend.FeatureIDs.BLEND_CONSTANT2, ColorBlend::blendConstant2).add(ColorBlend.FeatureIDs.BLEND_CONSTANT3, ColorBlend::blendConstant3).build();
    private static final FeatureSetter<ColorBlend> SET_MAP = new FeatureSetter.Builder<ColorBlend>(FEATURE_COUNT, ColorBlendImpl::featureIndexStatic).add(ColorBlend.FeatureIDs.LOGIC_OP_ENABLE, (object, value) -> ((ColorBlendImpl) object).logicOpEnable((boolean) value)).add(ColorBlend.FeatureIDs.LOGIC_OP, (object, value) -> ((ColorBlendImpl) object).logicOp((ELogicOp) value)).add(ColorBlend.FeatureIDs.BLEND_CONSTANT0, (object, value) -> ((ColorBlendImpl) object).blendConstant0((int) value)).add(ColorBlend.FeatureIDs.BLEND_CONSTANT1, (object, value) -> ((ColorBlendImpl) object).blendConstant1((int) value)).add(ColorBlend.FeatureIDs.BLEND_CONSTANT2, (object, value) -> ((ColorBlendImpl) object).blendConstant2((int) value)).add(ColorBlend.FeatureIDs.BLEND_CONSTANT3, (object, value) -> ((ColorBlendImpl) object).blendConstant3((int) value)).build();
  }
}
