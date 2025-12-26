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
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.builder.ViewportBuilder;

public interface Viewport extends IViewport {
  static Builder builder() {
    return new ViewportBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int offsetX();
  int offsetY();
  int minDepth();
  int maxDepth();
  Vector2ic extent();
  void offsetX(final int offsetX);
  void offsetY(final int offsetY);
  void minDepth(final int minDepth);
  void maxDepth(final int maxDepth);
  void extent(final Vector2ic extent);

  interface FeatureIDs {
    int OFFSETX = 1133247759;
    int OFFSETY = 1133247760;
    int MIN_DEPTH = 133457383;
    int MAX_DEPTH = 1909654037;
    int EXTENT = 321481472;
  }

  interface Features<T extends Features<T>> extends IViewport.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> OFFSETX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("offsetX").defaultValue("0").id(Viewport.FeatureIDs.OFFSETX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> OFFSETY = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("offsetY").defaultValue("0").id(Viewport.FeatureIDs.OFFSETY).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> MIN_DEPTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("minDepth").defaultValue("0").id(Viewport.FeatureIDs.MIN_DEPTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> MAX_DEPTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("maxDepth").defaultValue("1").id(Viewport.FeatureIDs.MAX_DEPTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>> EXTENT = new AttributeBuilder<Vector2ic, Vector2ic, Listener<Vector2ic>, Features<?>>().name("extent").id(Viewport.FeatureIDs.EXTENT).datatype(() -> TypesModelDefinition.JavaWrappers.VECTOR2I).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(OFFSETX, OFFSETY, MIN_DEPTH, MAX_DEPTH, EXTENT);
  }

  interface Builder extends IFeaturedObject.Builder<Viewport> {
    Builder offsetX(int offsetX);
    Builder offsetY(int offsetY);
    Builder minDepth(int minDepth);
    Builder maxDepth(int maxDepth);
    Builder extent(Vector2ic extent);
  }
}
