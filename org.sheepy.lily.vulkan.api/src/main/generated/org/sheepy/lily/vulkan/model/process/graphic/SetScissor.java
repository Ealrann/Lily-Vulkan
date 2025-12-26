package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SetScissorBuilder;

public interface SetScissor extends IPipelineTask {
  static Builder builder() {
    return new SetScissorBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int offsetX();
  int offsetY();
  int width();
  int height();
  void offsetX(final int offsetX);
  void offsetY(final int offsetY);
  void width(final int width);
  void height(final int height);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int OFFSETX = -103751860;
    int OFFSETY = -103751859;
    int WIDTH = 43121837;
    int HEIGHT = 903782176;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<Integer, Integer, IntListener, Features<?>> OFFSETX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("offsetX").defaultValue("0").id(SetScissor.FeatureIDs.OFFSETX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> OFFSETY = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("offsetY").defaultValue("0").id(SetScissor.FeatureIDs.OFFSETY).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> WIDTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("width").id(SetScissor.FeatureIDs.WIDTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> HEIGHT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("height").id(SetScissor.FeatureIDs.HEIGHT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, OFFSETX, OFFSETY, WIDTH, HEIGHT);
  }

  interface Builder extends IFeaturedObject.Builder<SetScissor> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder offsetX(int offsetX);
    Builder offsetY(int offsetY);
    Builder width(int width);
    Builder height(int height);
  }
}
