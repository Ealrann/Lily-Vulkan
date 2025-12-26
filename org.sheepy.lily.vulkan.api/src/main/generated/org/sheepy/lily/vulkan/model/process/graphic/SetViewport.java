package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SetViewportBuilder;

public interface SetViewport extends IPipelineTask {
  static Builder builder() {
    return new SetViewportBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  float x();
  float y();
  float width();
  float height();
  float minDepth();
  float maxDepth();
  void x(final float x);
  void y(final float y);
  void width(final float width);
  void height(final float height);
  void minDepth(final float minDepth);
  void maxDepth(final float maxDepth);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int X = 1437823167;
    int Y = 1437823168;
    int WIDTH = 2032280205;
    int HEIGHT = -1856817856;
    int MIN_DEPTH = 1794333034;
    int MAX_DEPTH = -724437608;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<Float, Float, FloatListener, Features<?>> X = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("x").defaultValue("0f").id(SetViewport.FeatureIDs.X).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> Y = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("y").defaultValue("0f").id(SetViewport.FeatureIDs.Y).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> WIDTH = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("width").id(SetViewport.FeatureIDs.WIDTH).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> HEIGHT = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("height").id(SetViewport.FeatureIDs.HEIGHT).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> MIN_DEPTH = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("minDepth").defaultValue("1f").id(SetViewport.FeatureIDs.MIN_DEPTH).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Float, Float, FloatListener, Features<?>> MAX_DEPTH = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("maxDepth").defaultValue("1f").id(SetViewport.FeatureIDs.MAX_DEPTH).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, X, Y, WIDTH, HEIGHT, MIN_DEPTH, MAX_DEPTH);
  }

  interface Builder extends IFeaturedObject.Builder<SetViewport> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder x(float x);
    Builder y(float y);
    Builder width(float width);
    Builder height(float height);
    Builder minDepth(float minDepth);
    Builder maxDepth(float maxDepth);
  }
}
