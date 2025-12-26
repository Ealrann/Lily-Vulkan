package org.sheepy.lily.vulkan.extra.model.nuklear;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.NuklearContextBuilder;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.process.ProcessModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface NuklearContext extends IVulkanResource {
  static Builder builder() {
    return new NuklearContextBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  NuklearFont font();
  StaticImage nullTexture();
  ImageDescriptor imageArrayDescriptor();
  IBuffer vertexBuffer();
  IBuffer indexBuffer();
  BufferMemory vertexBufferMemory();
  CompositeTask compositeDrawTask();
  void font(final NuklearFont font);
  void nullTexture(final StaticImage nullTexture);
  void imageArrayDescriptor(final ImageDescriptor imageArrayDescriptor);
  void vertexBuffer(final IBuffer vertexBuffer);
  void indexBuffer(final IBuffer indexBuffer);
  void vertexBufferMemory(final BufferMemory vertexBufferMemory);
  void compositeDrawTask(final CompositeTask compositeDrawTask);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int FONT = 708860424;
    int NULL_TEXTURE = 1049768379;
    int IMAGE_ARRAY_DESCRIPTOR = 505499526;
    int VERTEX_BUFFER = 1438510013;
    int INDEX_BUFFER = 1665319897;
    int VERTEX_BUFFER_MEMORY = 1132663582;
    int COMPOSITE_DRAW_TASK = -1501398153;
  }

  interface Features<T extends Features<T>> extends IVulkanResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<NuklearFont, NuklearFont, Listener<NuklearFont>, Features<?>> FONT = new RelationBuilder<NuklearFont, NuklearFont, Listener<NuklearFont>, Features<?>>().name("font").mandatory(true).id(NuklearContext.FeatureIDs.FONT).concept(() -> NuklearModelDefinition.Groups.NUKLEAR_FONT).build();
    Relation<StaticImage, StaticImage, Listener<StaticImage>, Features<?>> NULL_TEXTURE = new RelationBuilder<StaticImage, StaticImage, Listener<StaticImage>, Features<?>>().name("nullTexture").id(NuklearContext.FeatureIDs.NULL_TEXTURE).concept(() -> VulkanResourceModelDefinition.Groups.STATIC_IMAGE).build();
    Relation<ImageDescriptor, ImageDescriptor, Listener<ImageDescriptor>, Features<?>> IMAGE_ARRAY_DESCRIPTOR = new RelationBuilder<ImageDescriptor, ImageDescriptor, Listener<ImageDescriptor>, Features<?>>().name("imageArrayDescriptor").id(NuklearContext.FeatureIDs.IMAGE_ARRAY_DESCRIPTOR).concept(() -> VulkanResourceModelDefinition.Groups.IMAGE_DESCRIPTOR).build();
    Relation<IBuffer, IBuffer, Listener<IBuffer>, Features<?>> VERTEX_BUFFER = new RelationBuilder<IBuffer, IBuffer, Listener<IBuffer>, Features<?>>().name("vertexBuffer").mandatory(true).id(NuklearContext.FeatureIDs.VERTEX_BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER).build();
    Relation<IBuffer, IBuffer, Listener<IBuffer>, Features<?>> INDEX_BUFFER = new RelationBuilder<IBuffer, IBuffer, Listener<IBuffer>, Features<?>>().name("indexBuffer").mandatory(true).id(NuklearContext.FeatureIDs.INDEX_BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER).build();
    Relation<BufferMemory, BufferMemory, Listener<BufferMemory>, Features<?>> VERTEX_BUFFER_MEMORY = new RelationBuilder<BufferMemory, BufferMemory, Listener<BufferMemory>, Features<?>>().name("vertexBufferMemory").mandatory(true).id(NuklearContext.FeatureIDs.VERTEX_BUFFER_MEMORY).concept(() -> VulkanResourceModelDefinition.Groups.BUFFER_MEMORY).build();
    Relation<CompositeTask, CompositeTask, Listener<CompositeTask>, Features<?>> COMPOSITE_DRAW_TASK = new RelationBuilder<CompositeTask, CompositeTask, Listener<CompositeTask>, Features<?>>().name("compositeDrawTask").mandatory(true).id(NuklearContext.FeatureIDs.COMPOSITE_DRAW_TASK).concept(() -> ProcessModelDefinition.Groups.COMPOSITE_TASK).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, FONT, NULL_TEXTURE, IMAGE_ARRAY_DESCRIPTOR, VERTEX_BUFFER, INDEX_BUFFER, VERTEX_BUFFER_MEMORY, COMPOSITE_DRAW_TASK);
  }

  interface Builder extends IFeaturedObject.Builder<NuklearContext> {
    Builder name(String name);
    Builder font(Supplier<NuklearFont> font);
    Builder nullTexture(Supplier<StaticImage> nullTexture);
    Builder imageArrayDescriptor(Supplier<ImageDescriptor> imageArrayDescriptor);
    Builder vertexBuffer(Supplier<IBuffer> vertexBuffer);
    Builder indexBuffer(Supplier<IBuffer> indexBuffer);
    Builder vertexBufferMemory(Supplier<BufferMemory> vertexBufferMemory);
    Builder compositeDrawTask(Supplier<CompositeTask> compositeDrawTask);
  }
}
