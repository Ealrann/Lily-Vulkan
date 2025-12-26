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
import org.sheepy.lily.vulkan.model.process.graphic.builder.DrawIndexedBuilder;

public interface DrawIndexed extends IPipelineTask {
  static Builder builder() {
    return new DrawIndexedBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int indexCount();
  int instanceCount();
  int firstIndex();
  int vertexOffset();
  int firstInstance();
  void indexCount(final int indexCount);
  void instanceCount(final int instanceCount);
  void firstIndex(final int firstIndex);
  void vertexOffset(final int vertexOffset);
  void firstInstance(final int firstInstance);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int INDEX_COUNT = -2031287823;
    int INSTANCE_COUNT = 146723430;
    int FIRST_INDEX = 1361226390;
    int VERTEX_OFFSET = -1170736917;
    int FIRST_INSTANCE = -343110575;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<Integer, Integer, IntListener, Features<?>> INDEX_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("indexCount").mandatory(true).id(DrawIndexed.FeatureIDs.INDEX_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> INSTANCE_COUNT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("instanceCount").defaultValue("1").id(DrawIndexed.FeatureIDs.INSTANCE_COUNT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> FIRST_INDEX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("firstIndex").defaultValue("0").id(DrawIndexed.FeatureIDs.FIRST_INDEX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> VERTEX_OFFSET = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("vertexOffset").defaultValue("0").id(DrawIndexed.FeatureIDs.VERTEX_OFFSET).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> FIRST_INSTANCE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("firstInstance").defaultValue("0").id(DrawIndexed.FeatureIDs.FIRST_INSTANCE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, INDEX_COUNT, INSTANCE_COUNT, FIRST_INDEX, VERTEX_OFFSET, FIRST_INSTANCE);
  }

  interface Builder extends IFeaturedObject.Builder<DrawIndexed> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder indexCount(int indexCount);
    Builder instanceCount(int instanceCount);
    Builder firstIndex(int firstIndex);
    Builder vertexOffset(int vertexOffset);
    Builder firstInstance(int firstInstance);
  }
}
