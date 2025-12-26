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
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.extra.model.rendering.builder.RenderableDataSourceBuilder;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface RenderableDataSource<T extends Structure> extends IBufferDataSource, LNamedElement, IVulkanResource {
  static <T extends Structure> Builder<T> builder() {
    return new RenderableDataSourceBuilder<>();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  T structure();
  int part();
  IBufferDataSource dataSource();
  void structure(final T structure);
  void part(final int part);
  void dataSource(final IBufferDataSource dataSource);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int STRUCTURE = -1109616752;
    int PART = 446192566;
    int DATA_SOURCE = 1048983016;
  }

  interface Features<T extends Features<T>> extends IBufferDataSource.Features<T>, LNamedElement.Features<T>, IVulkanResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<Structure, Structure, Listener<Structure>, Features<?>> STRUCTURE = new RelationBuilder<Structure, Structure, Listener<Structure>, Features<?>>().name("structure").mandatory(true).id(RenderableDataSource.FeatureIDs.STRUCTURE).concept(() -> RenderingModelDefinition.Groups.STRUCTURE).build();
    Attribute<Integer, Integer, IntListener, Features<?>> PART = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("part").mandatory(true).id(RenderableDataSource.FeatureIDs.PART).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Relation<IBufferDataSource, IBufferDataSource, Listener<IBufferDataSource>, Features<?>> DATA_SOURCE = new RelationBuilder<IBufferDataSource, IBufferDataSource, Listener<IBufferDataSource>, Features<?>>().name("dataSource").id(RenderableDataSource.FeatureIDs.DATA_SOURCE).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER_DATA_SOURCE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, STRUCTURE, PART, DATA_SOURCE);
  }

  interface Builder<T extends Structure> extends IFeaturedObject.Builder<RenderableDataSource<T>> {
    Builder<T> name(String name);
    Builder<T> structure(Supplier<T> structure);
    Builder<T> part(int part);
    Builder<T> dataSource(Supplier<IBufferDataSource> dataSource);
  }
}
