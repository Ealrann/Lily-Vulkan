package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.graphicpipeline.builder.DynamicViewportStateBuilder;

public interface DynamicViewportState extends ViewportState {
  static Builder builder() {
    return new DynamicViewportStateBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int viewportCount();
  int scissorCount();
  void viewportCount(final int viewportCount);
  void scissorCount(final int scissorCount);

  interface FeatureIDs {
    int VIEWPORT_COUNT = 973514969;
    int SCISSOR_COUNT = -1498924093;
  }

  interface Features<T extends Features<T>> extends ViewportState.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> VIEWPORT_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("viewportCount").id(DynamicViewportState.FeatureIDs.VIEWPORT_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> SCISSOR_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("scissorCount").id(DynamicViewportState.FeatureIDs.SCISSOR_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(VIEWPORT_COUNT, SCISSOR_COUNT);
  }

  interface Builder extends IFeaturedObject.Builder<DynamicViewportState> {
    Builder viewportCount(int viewportCount);
    Builder scissorCount(int scissorCount);
  }
}
