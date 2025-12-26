package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.vulkan.model.enumeration.ELogicOp;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.builder.ColorBlendBuilder;

public interface ColorBlend extends LMObject {
  static Builder builder() {
    return new ColorBlendBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ColorBlendAttachment> attachments();
  boolean logicOpEnable();
  ELogicOp logicOp();
  int blendConstant0();
  int blendConstant1();
  int blendConstant2();
  int blendConstant3();
  void logicOpEnable(final boolean logicOpEnable);
  void logicOp(final ELogicOp logicOp);
  void blendConstant0(final int blendConstant0);
  void blendConstant1(final int blendConstant1);
  void blendConstant2(final int blendConstant2);
  void blendConstant3(final int blendConstant3);

  interface FeatureIDs {
    int ATTACHMENTS = 698957858;
    int LOGIC_OP_ENABLE = -750606284;
    int LOGIC_OP = -992143535;
    int BLEND_CONSTANT0 = -342246903;
    int BLEND_CONSTANT1 = -342246902;
    int BLEND_CONSTANT2 = -342246901;
    int BLEND_CONSTANT3 = -342246900;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<ColorBlendAttachment, List<ColorBlendAttachment>, Listener<List<ColorBlendAttachment>>, Features<?>> ATTACHMENTS = new RelationBuilder<ColorBlendAttachment, List<ColorBlendAttachment>, Listener<List<ColorBlendAttachment>>, Features<?>>().name("attachments").many(true).contains(true).id(ColorBlend.FeatureIDs.ATTACHMENTS).concept(() -> GraphicPipelineModelDefinition.Groups.COLOR_BLEND_ATTACHMENT).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> LOGIC_OP_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("logicOpEnable").defaultValue("false").id(ColorBlend.FeatureIDs.LOGIC_OP_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<ELogicOp, ELogicOp, Listener<ELogicOp>, Features<?>> LOGIC_OP = new AttributeBuilder<ELogicOp, ELogicOp, Listener<ELogicOp>, Features<?>>().name("logicOp").defaultValue("COPY").id(ColorBlend.FeatureIDs.LOGIC_OP).datatype(() -> EnumerationModelDefinition.Enums.E_LOGIC_OP).build();
    Attribute<Integer, Integer, IntListener, Features<?>> BLEND_CONSTANT0 = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("blendConstant0").defaultValue("0").id(ColorBlend.FeatureIDs.BLEND_CONSTANT0).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> BLEND_CONSTANT1 = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("blendConstant1").defaultValue("0").id(ColorBlend.FeatureIDs.BLEND_CONSTANT1).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> BLEND_CONSTANT2 = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("blendConstant2").defaultValue("0").id(ColorBlend.FeatureIDs.BLEND_CONSTANT2).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> BLEND_CONSTANT3 = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("blendConstant3").defaultValue("1").id(ColorBlend.FeatureIDs.BLEND_CONSTANT3).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ATTACHMENTS, LOGIC_OP_ENABLE, LOGIC_OP, BLEND_CONSTANT0, BLEND_CONSTANT1, BLEND_CONSTANT2, BLEND_CONSTANT3);
  }

  interface Builder extends IFeaturedObject.Builder<ColorBlend> {
    Builder addAttachment(Supplier<ColorBlendAttachment> attachment);
    Builder logicOpEnable(boolean logicOpEnable);
    Builder logicOp(ELogicOp logicOp);
    Builder blendConstant0(int blendConstant0);
    Builder blendConstant1(int blendConstant1);
    Builder blendConstant2(int blendConstant2);
    Builder blendConstant3(int blendConstant3);
    Builder addAttachments(List<ColorBlendAttachment> attachments);
  }
}
