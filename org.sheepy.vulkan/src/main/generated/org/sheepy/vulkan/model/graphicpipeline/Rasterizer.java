package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.ECullMode;
import org.sheepy.vulkan.model.enumeration.EFrontFace;
import org.sheepy.vulkan.model.enumeration.EPolygonMode;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.builder.RasterizerBuilder;

public interface Rasterizer extends LMObject {
  static Builder builder() {
    return new RasterizerBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ECullMode cullMode();
  EFrontFace frontFace();
  EPolygonMode polygonMode();
  int lineWidth();
  boolean depthClampEnable();
  boolean discardEnable();
  boolean depthBiasEnable();
  void cullMode(final ECullMode cullMode);
  void frontFace(final EFrontFace frontFace);
  void polygonMode(final EPolygonMode polygonMode);
  void lineWidth(final int lineWidth);
  void depthClampEnable(final boolean depthClampEnable);
  void discardEnable(final boolean discardEnable);
  void depthBiasEnable(final boolean depthBiasEnable);

  interface FeatureIDs {
    int CULL_MODE = 517876662;
    int FRONT_FACE = -431990075;
    int POLYGON_MODE = -1669719844;
    int LINE_WIDTH = 1931859153;
    int DEPTH_CLAMP_ENABLE = -321894436;
    int DISCARD_ENABLE = -1118915872;
    int DEPTH_BIAS_ENABLE = 872910878;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<ECullMode, ECullMode, Listener<ECullMode>, Features<?>> CULL_MODE = new AttributeBuilder<ECullMode, ECullMode, Listener<ECullMode>, Features<?>>().name("cullMode").defaultValue("BACK_BIT").id(Rasterizer.FeatureIDs.CULL_MODE).datatype(() -> EnumerationModelDefinition.Enums.E_CULL_MODE).build();
    Attribute<EFrontFace, EFrontFace, Listener<EFrontFace>, Features<?>> FRONT_FACE = new AttributeBuilder<EFrontFace, EFrontFace, Listener<EFrontFace>, Features<?>>().name("frontFace").defaultValue("CLOCKWISE").id(Rasterizer.FeatureIDs.FRONT_FACE).datatype(() -> EnumerationModelDefinition.Enums.E_FRONT_FACE).build();
    Attribute<EPolygonMode, EPolygonMode, Listener<EPolygonMode>, Features<?>> POLYGON_MODE = new AttributeBuilder<EPolygonMode, EPolygonMode, Listener<EPolygonMode>, Features<?>>().name("polygonMode").defaultValue("FILL").id(Rasterizer.FeatureIDs.POLYGON_MODE).datatype(() -> EnumerationModelDefinition.Enums.E_POLYGON_MODE).build();
    Attribute<Integer, Integer, IntListener, Features<?>> LINE_WIDTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("lineWidth").defaultValue("1").id(Rasterizer.FeatureIDs.LINE_WIDTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> DEPTH_CLAMP_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("depthClampEnable").defaultValue("false").id(Rasterizer.FeatureIDs.DEPTH_CLAMP_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> DISCARD_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("discardEnable").defaultValue("false").id(Rasterizer.FeatureIDs.DISCARD_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> DEPTH_BIAS_ENABLE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("depthBiasEnable").defaultValue("false").id(Rasterizer.FeatureIDs.DEPTH_BIAS_ENABLE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(CULL_MODE, FRONT_FACE, POLYGON_MODE, LINE_WIDTH, DEPTH_CLAMP_ENABLE, DISCARD_ENABLE, DEPTH_BIAS_ENABLE);
  }

  interface Builder extends IFeaturedObject.Builder<Rasterizer> {
    Builder cullMode(ECullMode cullMode);
    Builder frontFace(EFrontFace frontFace);
    Builder polygonMode(EPolygonMode polygonMode);
    Builder lineWidth(int lineWidth);
    Builder depthClampEnable(boolean depthClampEnable);
    Builder discardEnable(boolean discardEnable);
    Builder depthBiasEnable(boolean depthBiasEnable);
  }
}
