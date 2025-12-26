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
import org.sheepy.lily.vulkan.model.process.graphic.builder.DrawBuilder;

public interface Draw extends IPipelineTask {
  static Builder builder() {
    return new DrawBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int vertexCount();
  int instanceCount();
  int firstVertex();
  int firstInstance();
  void vertexCount(final int vertexCount);
  void instanceCount(final int instanceCount);
  void firstVertex(final int firstVertex);
  void firstInstance(final int firstInstance);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int VERTEX_COUNT = 1151981020;
    int INSTANCE_COUNT = -1474207413;
    int FIRST_VERTEX = 1090284677;
    int FIRST_INSTANCE = -1964041418;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<Integer, Integer, IntListener, Features<?>> VERTEX_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("vertexCount").mandatory(true).id(Draw.FeatureIDs.VERTEX_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> INSTANCE_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("instanceCount").defaultValue("1").id(Draw.FeatureIDs.INSTANCE_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> FIRST_VERTEX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("firstVertex").defaultValue("0").id(Draw.FeatureIDs.FIRST_VERTEX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> FIRST_INSTANCE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("firstInstance").defaultValue("0").id(Draw.FeatureIDs.FIRST_INSTANCE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, VERTEX_COUNT, INSTANCE_COUNT, FIRST_VERTEX, FIRST_INSTANCE);
  }

  interface Builder extends IFeaturedObject.Builder<Draw> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder vertexCount(int vertexCount);
    Builder instanceCount(int instanceCount);
    Builder firstVertex(int firstVertex);
    Builder firstInstance(int firstInstance);
  }
}
