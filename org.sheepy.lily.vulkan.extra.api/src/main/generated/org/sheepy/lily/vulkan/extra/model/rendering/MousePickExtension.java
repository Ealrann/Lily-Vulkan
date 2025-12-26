package org.sheepy.lily.vulkan.extra.model.rendering;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.MousePickExtensionBuilder;
import org.sheepy.lily.vulkan.model.process.IProcessExtension;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface MousePickExtension extends IProcessExtension {
  static Builder builder() {
    return new MousePickExtensionBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  StaticBuffer mousePickBuffer();
  SelectionProxy selectionProxy();
  List<EntityResolverPipeline> entityResolverPipelines();
  int resolverPipelineOffset();
  void mousePickBuffer(final StaticBuffer mousePickBuffer);
  void selectionProxy(final SelectionProxy selectionProxy);
  void resolverPipelineOffset(final int resolverPipelineOffset);

  interface FeatureIDs {
    int MOUSE_PICK_BUFFER = -2127525081;
    int SELECTION_PROXY = -34158783;
    int ENTITY_RESOLVER_PIPELINES = 1522965225;
    int RESOLVER_PIPELINE_OFFSET = -1310402694;
  }

  interface Features<T extends Features<T>> extends IProcessExtension.Features<T> {
    Relation<StaticBuffer, StaticBuffer, Listener<StaticBuffer>, Features<?>> MOUSE_PICK_BUFFER = new RelationBuilder<StaticBuffer, StaticBuffer, Listener<StaticBuffer>, Features<?>>().name("mousePickBuffer").mandatory(true).id(MousePickExtension.FeatureIDs.MOUSE_PICK_BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.STATIC_BUFFER).build();
    Relation<SelectionProxy, SelectionProxy, Listener<SelectionProxy>, Features<?>> SELECTION_PROXY = new RelationBuilder<SelectionProxy, SelectionProxy, Listener<SelectionProxy>, Features<?>>().name("selectionProxy").id(MousePickExtension.FeatureIDs.SELECTION_PROXY).concept(() -> RenderingModelDefinition.Groups.SELECTION_PROXY).build();
    Relation<EntityResolverPipeline, List<EntityResolverPipeline>, Listener<List<EntityResolverPipeline>>, Features<?>> ENTITY_RESOLVER_PIPELINES = new RelationBuilder<EntityResolverPipeline, List<EntityResolverPipeline>, Listener<List<EntityResolverPipeline>>, Features<?>>().name("entityResolverPipelines").many(true).contains(true).id(MousePickExtension.FeatureIDs.ENTITY_RESOLVER_PIPELINES).concept(() -> RenderingModelDefinition.Groups.ENTITY_RESOLVER_PIPELINE).build();
    Attribute<Integer, Integer, IntListener, Features<?>> RESOLVER_PIPELINE_OFFSET = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("resolverPipelineOffset").mandatory(true).defaultValue("0").id(MousePickExtension.FeatureIDs.RESOLVER_PIPELINE_OFFSET).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(MOUSE_PICK_BUFFER, SELECTION_PROXY, ENTITY_RESOLVER_PIPELINES, RESOLVER_PIPELINE_OFFSET);
  }

  interface Builder extends IFeaturedObject.Builder<MousePickExtension> {
    Builder mousePickBuffer(Supplier<StaticBuffer> mousePickBuffer);
    Builder selectionProxy(Supplier<SelectionProxy> selectionProxy);
    Builder addEntityResolverPipeline(Supplier<EntityResolverPipeline> entityResolverPipeline);
    Builder resolverPipelineOffset(int resolverPipelineOffset);
    Builder addEntityResolverPipelines(List<EntityResolverPipeline> entityResolverPipelines);
  }
}
