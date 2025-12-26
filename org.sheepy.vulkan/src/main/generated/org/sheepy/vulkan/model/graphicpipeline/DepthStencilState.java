package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.ECompareOp;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.builder.DepthStencilStateBuilder;

public interface DepthStencilState extends LMObject {
  static Builder builder() {
    return new DepthStencilStateBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean depthTest();
  boolean depthWrite();
  boolean depthBoundTest();
  boolean stencilTest();
  ECompareOp depthCompareOp();
  float minDepthBounds();
  float maxDepthBounds();
  void depthTest(final boolean depthTest);
  void depthWrite(final boolean depthWrite);
  void depthBoundTest(final boolean depthBoundTest);
  void stencilTest(final boolean stencilTest);
  void depthCompareOp(final ECompareOp depthCompareOp);
  void minDepthBounds(final float minDepthBounds);
  void maxDepthBounds(final float maxDepthBounds);

  interface FeatureIDs {
    int DEPTH_TEST = -1302485227;
    int DEPTH_WRITE = -1719188036;
    int DEPTH_BOUND_TEST = 1679604365;
    int STENCIL_TEST = -390627954;
    int DEPTH_COMPARE_OP = 1417435395;
    int MIN_DEPTH_BOUNDS = -378961786;
    int MAX_DEPTH_BOUNDS = -1035877836;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> DEPTH_TEST = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("depthTest").mandatory(true).defaultValue("true").id(DepthStencilState.FeatureIDs.DEPTH_TEST).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> DEPTH_WRITE = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("depthWrite").mandatory(true).defaultValue("true").id(DepthStencilState.FeatureIDs.DEPTH_WRITE).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> DEPTH_BOUND_TEST = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("depthBoundTest").mandatory(true).defaultValue("false").id(DepthStencilState.FeatureIDs.DEPTH_BOUND_TEST).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> STENCIL_TEST = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("stencilTest").mandatory(true).defaultValue("false").id(DepthStencilState.FeatureIDs.STENCIL_TEST).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<ECompareOp, ECompareOp, Listener<ECompareOp>, Features<?>> DEPTH_COMPARE_OP = new AttributeBuilder<ECompareOp, ECompareOp, Listener<ECompareOp>, Features<?>>().name("depthCompareOp").mandatory(true).defaultValue("LESS").id(DepthStencilState.FeatureIDs.DEPTH_COMPARE_OP).datatype(() -> EnumerationModelDefinition.Enums.E_COMPARE_OP).build();
    Attribute<Float, Float, FloatListener, Features<?>> MIN_DEPTH_BOUNDS = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("minDepthBounds").mandatory(true).defaultValue("0f").id(DepthStencilState.FeatureIDs.MIN_DEPTH_BOUNDS).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> MAX_DEPTH_BOUNDS = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("maxDepthBounds").mandatory(true).defaultValue("1f").id(DepthStencilState.FeatureIDs.MAX_DEPTH_BOUNDS).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(DEPTH_TEST, DEPTH_WRITE, DEPTH_BOUND_TEST, STENCIL_TEST, DEPTH_COMPARE_OP, MIN_DEPTH_BOUNDS, MAX_DEPTH_BOUNDS);
  }

  interface Builder extends IFeaturedObject.Builder<DepthStencilState> {
    Builder depthTest(boolean depthTest);
    Builder depthWrite(boolean depthWrite);
    Builder depthBoundTest(boolean depthBoundTest);
    Builder stencilTest(boolean stencilTest);
    Builder depthCompareOp(ECompareOp depthCompareOp);
    Builder minDepthBounds(float minDepthBounds);
    Builder maxDepthBounds(float maxDepthBounds);
  }
}
