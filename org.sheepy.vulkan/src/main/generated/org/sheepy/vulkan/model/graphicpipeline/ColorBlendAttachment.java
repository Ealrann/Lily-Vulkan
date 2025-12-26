package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EBlendFactor;
import org.sheepy.vulkan.model.enumeration.EBlendOp;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.builder.ColorBlendAttachmentBuilder;

public interface ColorBlendAttachment extends LMObject {
  static Builder builder() {
    return new ColorBlendAttachmentBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean blendEnable();
  EBlendFactor srcColor();
  EBlendFactor dstColor();
  EBlendFactor srcAlpha();
  EBlendFactor dstAlpha();
  EBlendOp colorBlendOp();
  EBlendOp alphaBlendOp();
  boolean redComponentEnable();
  boolean greenComponentEnable();
  boolean blueComponentEnable();
  boolean alphaComponentEnable();
  void blendEnable(final boolean blendEnable);
  void srcColor(final EBlendFactor srcColor);
  void dstColor(final EBlendFactor dstColor);
  void srcAlpha(final EBlendFactor srcAlpha);
  void dstAlpha(final EBlendFactor dstAlpha);
  void colorBlendOp(final EBlendOp colorBlendOp);
  void alphaBlendOp(final EBlendOp alphaBlendOp);
  void redComponentEnable(final boolean redComponentEnable);
  void greenComponentEnable(final boolean greenComponentEnable);
  void blueComponentEnable(final boolean blueComponentEnable);
  void alphaComponentEnable(final boolean alphaComponentEnable);

  interface FeatureIDs {
    int BLEND_ENABLE = 694032233;
    int SRC_COLOR = 128556490;
    int DST_COLOR = 1130404489;
    int SRC_ALPHA = 126623685;
    int DST_ALPHA = 1128471684;
    int COLOR_BLEND_OP = 394059162;
    int ALPHA_BLEND_OP = 650001215;
    int RED_COMPONENT_ENABLE = -805221318;
    int GREEN_COMPONENT_ENABLE = 1356850376;
    int BLUE_COMPONENT_ENABLE = -1960581541;
    int ALPHA_COMPONENT_ENABLE = 15769869;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> BLEND_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("blendEnable").defaultValue("false").id(ColorBlendAttachment.FeatureIDs.BLEND_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<EBlendFactor, EBlendFactor, Listener<EBlendFactor>, Features<?>> SRC_COLOR = new AttributeBuilder<EBlendFactor, EBlendFactor, Listener<EBlendFactor>, Features<?>>().name("srcColor").defaultValue("ONE").id(ColorBlendAttachment.FeatureIDs.SRC_COLOR).datatype(() -> EnumerationModelDefinition.Enums.E_BLEND_FACTOR).build();
    Attribute<EBlendFactor, EBlendFactor, Listener<EBlendFactor>, Features<?>> DST_COLOR = new AttributeBuilder<EBlendFactor, EBlendFactor, Listener<EBlendFactor>, Features<?>>().name("dstColor").defaultValue("ZERO").id(ColorBlendAttachment.FeatureIDs.DST_COLOR).datatype(() -> EnumerationModelDefinition.Enums.E_BLEND_FACTOR).build();
    Attribute<EBlendFactor, EBlendFactor, Listener<EBlendFactor>, Features<?>> SRC_ALPHA = new AttributeBuilder<EBlendFactor, EBlendFactor, Listener<EBlendFactor>, Features<?>>().name("srcAlpha").defaultValue("ONE").id(ColorBlendAttachment.FeatureIDs.SRC_ALPHA).datatype(() -> EnumerationModelDefinition.Enums.E_BLEND_FACTOR).build();
    Attribute<EBlendFactor, EBlendFactor, Listener<EBlendFactor>, Features<?>> DST_ALPHA = new AttributeBuilder<EBlendFactor, EBlendFactor, Listener<EBlendFactor>, Features<?>>().name("dstAlpha").defaultValue("ZERO").id(ColorBlendAttachment.FeatureIDs.DST_ALPHA).datatype(() -> EnumerationModelDefinition.Enums.E_BLEND_FACTOR).build();
    Attribute<EBlendOp, EBlendOp, Listener<EBlendOp>, Features<?>> COLOR_BLEND_OP = new AttributeBuilder<EBlendOp, EBlendOp, Listener<EBlendOp>, Features<?>>().name("colorBlendOp").defaultValue("ADD").id(ColorBlendAttachment.FeatureIDs.COLOR_BLEND_OP).datatype(() -> EnumerationModelDefinition.Enums.E_BLEND_OP).build();
    Attribute<EBlendOp, EBlendOp, Listener<EBlendOp>, Features<?>> ALPHA_BLEND_OP = new AttributeBuilder<EBlendOp, EBlendOp, Listener<EBlendOp>, Features<?>>().name("alphaBlendOp").defaultValue("ADD").id(ColorBlendAttachment.FeatureIDs.ALPHA_BLEND_OP).datatype(() -> EnumerationModelDefinition.Enums.E_BLEND_OP).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> RED_COMPONENT_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("redComponentEnable").defaultValue("true").id(ColorBlendAttachment.FeatureIDs.RED_COMPONENT_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> GREEN_COMPONENT_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("greenComponentEnable").defaultValue("true").id(ColorBlendAttachment.FeatureIDs.GREEN_COMPONENT_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> BLUE_COMPONENT_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("blueComponentEnable").defaultValue("true").id(ColorBlendAttachment.FeatureIDs.BLUE_COMPONENT_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> ALPHA_COMPONENT_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("alphaComponentEnable").defaultValue("true").id(ColorBlendAttachment.FeatureIDs.ALPHA_COMPONENT_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(BLEND_ENABLE, SRC_COLOR, DST_COLOR, SRC_ALPHA, DST_ALPHA, COLOR_BLEND_OP, ALPHA_BLEND_OP, RED_COMPONENT_ENABLE, GREEN_COMPONENT_ENABLE, BLUE_COMPONENT_ENABLE, ALPHA_COMPONENT_ENABLE);
  }

  interface Builder extends IFeaturedObject.Builder<ColorBlendAttachment> {
    Builder blendEnable(boolean blendEnable);
    Builder srcColor(EBlendFactor srcColor);
    Builder dstColor(EBlendFactor dstColor);
    Builder srcAlpha(EBlendFactor srcAlpha);
    Builder dstAlpha(EBlendFactor dstAlpha);
    Builder colorBlendOp(EBlendOp colorBlendOp);
    Builder alphaBlendOp(EBlendOp alphaBlendOp);
    Builder redComponentEnable(boolean redComponentEnable);
    Builder greenComponentEnable(boolean greenComponentEnable);
    Builder blueComponentEnable(boolean blueComponentEnable);
    Builder alphaComponentEnable(boolean alphaComponentEnable);
  }
}
