package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.graphic.builder.BindVertexBufferBuilder;

public interface BindVertexBuffer extends IPipelineTask {
  static Builder builder() {
    return new BindVertexBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int firstBinding();
  List<VertexBinding> vertexBindings();
  void firstBinding(final int firstBinding);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int FIRST_BINDING = -80028985;
    int VERTEX_BINDINGS = 1002513636;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<Integer, Integer, IntListener, Features<?>> FIRST_BINDING = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("firstBinding").defaultValue("0").id(BindVertexBuffer.FeatureIDs.FIRST_BINDING).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Relation<VertexBinding, List<VertexBinding>, Listener<List<VertexBinding>>, Features<?>> VERTEX_BINDINGS = new RelationBuilder<VertexBinding, List<VertexBinding>, Listener<List<VertexBinding>>, Features<?>>().name("vertexBindings").many(true).mandatory(true).contains(true).id(BindVertexBuffer.FeatureIDs.VERTEX_BINDINGS).concept(() -> GraphicModelDefinition.Groups.VERTEX_BINDING).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, FIRST_BINDING, VERTEX_BINDINGS);
  }

  interface Builder extends IFeaturedObject.Builder<BindVertexBuffer> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder firstBinding(int firstBinding);
    Builder addVertexBinding(Supplier<VertexBinding> vertexBinding);
    Builder addVertexBindings(List<VertexBinding> vertexBindings);
  }
}
