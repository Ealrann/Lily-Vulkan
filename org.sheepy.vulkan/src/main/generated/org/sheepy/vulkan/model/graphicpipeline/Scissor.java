package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.joml.Vector2ic;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.builder.ScissorBuilder;

public interface Scissor extends LMObject {
  static Builder builder() {
    return new ScissorBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int offsetX();
  int offsetY();
  Vector2ic extent();
  void offsetX(final int offsetX);
  void offsetY(final int offsetY);
  void extent(final Vector2ic extent);

  interface FeatureIDs {
    int OFFSETX = 2142562057;
    int OFFSETY = 2142562058;
    int EXTENT = 631134662;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> OFFSETX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("offsetX").defaultValue("0").id(Scissor.FeatureIDs.OFFSETX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> OFFSETY = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("offsetY").defaultValue("0").id(Scissor.FeatureIDs.OFFSETY).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>> EXTENT = new AttributeBuilder<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>>().name("extent").defaultValue("0;0").id(Scissor.FeatureIDs.EXTENT).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR2I).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(OFFSETX, OFFSETY, EXTENT);
  }

  interface Builder extends IFeaturedObject.Builder<Scissor> {
    Builder offsetX(int offsetX);
    Builder offsetY(int offsetY);
    Builder extent(Vector2ic extent);
  }
}
