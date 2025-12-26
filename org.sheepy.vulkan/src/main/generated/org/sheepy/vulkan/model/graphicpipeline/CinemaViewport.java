package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.FloatListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.CinemaViewportBuilder;

public interface CinemaViewport extends IViewport {
  static Builder builder() {
    return new CinemaViewportBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  float aspectRatio();
  int minDepth();
  int maxDepth();
  void aspectRatio(final float aspectRatio);
  void minDepth(final int minDepth);
  void maxDepth(final int maxDepth);

  interface FeatureIDs {
    int ASPECT_RATIO = 1335577230;
    int MIN_DEPTH = 733333878;
    int MAX_DEPTH = -1785436764;
  }

  interface Features<T extends Features<T>> extends IViewport.Features<T> {
    Attribute<Float, Float, FloatListener, Features<?>> ASPECT_RATIO = new AttributeBuilder<Float, Float, FloatListener, Features<?>>().name("aspectRatio").mandatory(true).defaultValue("1f").id(CinemaViewport.FeatureIDs.ASPECT_RATIO).datatype(() -> LMCoreModelDefinition.Units.FLOAT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> MIN_DEPTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("minDepth").defaultValue("0").id(CinemaViewport.FeatureIDs.MIN_DEPTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> MAX_DEPTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("maxDepth").defaultValue("1").id(CinemaViewport.FeatureIDs.MAX_DEPTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ASPECT_RATIO, MIN_DEPTH, MAX_DEPTH);
  }

  interface Builder extends IFeaturedObject.Builder<CinemaViewport> {
    Builder aspectRatio(float aspectRatio);
    Builder minDepth(int minDepth);
    Builder maxDepth(int maxDepth);
  }
}
