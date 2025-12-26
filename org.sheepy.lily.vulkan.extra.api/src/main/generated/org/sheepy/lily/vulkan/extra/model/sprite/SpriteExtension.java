package org.sheepy.lily.vulkan.extra.model.sprite;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.extra.model.sprite.builder.SpriteExtensionBuilder;
import org.sheepy.lily.vulkan.model.process.IPipelineExtension;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.process.graphic.GraphicModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.IBufferDataSource;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;

public interface SpriteExtension extends IPipelineExtension, IBufferDataSource {
  static Builder builder() {
    return new SpriteExtensionBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  DrawIndexed drawTask();
  BufferViewer indexBufferViewer();
  BufferViewer vertexBufferViewer();
  ImageDescriptor spritesDescriptor();
  ISpriteDataSource spriteDataSource();
  ConstantBuffer spritePipelineSpecialization();
  MemoryChunk spriteImageMemory();
  void drawTask(final DrawIndexed drawTask);
  void indexBufferViewer(final BufferViewer indexBufferViewer);
  void vertexBufferViewer(final BufferViewer vertexBufferViewer);
  void spritesDescriptor(final ImageDescriptor spritesDescriptor);
  void spriteDataSource(final ISpriteDataSource spriteDataSource);
  void spritePipelineSpecialization(final ConstantBuffer spritePipelineSpecialization);
  void spriteImageMemory(final MemoryChunk spriteImageMemory);

  interface FeatureIDs {
    int DRAW_TASK = 879613450;
    int INDEX_BUFFER_VIEWER = -717043613;
    int VERTEX_BUFFER_VIEWER = 1179860503;
    int SPRITES_DESCRIPTOR = 411988060;
    int SPRITE_DATA_SOURCE = 1176688939;
    int SPRITE_PIPELINE_SPECIALIZATION = -1669617517;
    int SPRITE_IMAGE_MEMORY = -979648970;
  }

  interface Features<T extends Features<T>> extends IPipelineExtension.Features<T>, IBufferDataSource.Features<T> {
    Relation<DrawIndexed, DrawIndexed, Listener<DrawIndexed>, Features<?>> DRAW_TASK = new RelationBuilder<DrawIndexed, DrawIndexed, Listener<DrawIndexed>, Features<?>>().name("drawTask").mandatory(true).id(SpriteExtension.FeatureIDs.DRAW_TASK).concept(() -> GraphicModelDefinition.Groups.DRAW_INDEXED).build();
    Relation<BufferViewer, BufferViewer, Listener<BufferViewer>, Features<?>> INDEX_BUFFER_VIEWER = new RelationBuilder<BufferViewer, BufferViewer, Listener<BufferViewer>, Features<?>>().name("indexBufferViewer").mandatory(true).id(SpriteExtension.FeatureIDs.INDEX_BUFFER_VIEWER).concept(() -> VulkanResourceModelDefinition.Groups.BUFFER_VIEWER).build();
    Relation<BufferViewer, BufferViewer, Listener<BufferViewer>, Features<?>> VERTEX_BUFFER_VIEWER = new RelationBuilder<BufferViewer, BufferViewer, Listener<BufferViewer>, Features<?>>().name("vertexBufferViewer").mandatory(true).id(SpriteExtension.FeatureIDs.VERTEX_BUFFER_VIEWER).concept(() -> VulkanResourceModelDefinition.Groups.BUFFER_VIEWER).build();
    Relation<ImageDescriptor, ImageDescriptor, Listener<ImageDescriptor>, Features<?>> SPRITES_DESCRIPTOR = new RelationBuilder<ImageDescriptor, ImageDescriptor, Listener<ImageDescriptor>, Features<?>>().name("spritesDescriptor").mandatory(true).id(SpriteExtension.FeatureIDs.SPRITES_DESCRIPTOR).concept(() -> VulkanResourceModelDefinition.Groups.IMAGE_DESCRIPTOR).build();
    Relation<ISpriteDataSource, ISpriteDataSource, Listener<ISpriteDataSource>, Features<?>> SPRITE_DATA_SOURCE = new RelationBuilder<ISpriteDataSource, ISpriteDataSource, Listener<ISpriteDataSource>, Features<?>>().name("spriteDataSource").id(SpriteExtension.FeatureIDs.SPRITE_DATA_SOURCE).concept(() -> SpriteModelDefinition.Groups.I_SPRITE_DATA_SOURCE).build();
    Relation<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, Features<?>> SPRITE_PIPELINE_SPECIALIZATION = new RelationBuilder<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, Features<?>>().name("spritePipelineSpecialization").id(SpriteExtension.FeatureIDs.SPRITE_PIPELINE_SPECIALIZATION).concept(() -> VulkanResourceModelDefinition.Groups.CONSTANT_BUFFER).build();
    Relation<MemoryChunk, MemoryChunk, Listener<MemoryChunk>, Features<?>> SPRITE_IMAGE_MEMORY = new RelationBuilder<MemoryChunk, MemoryChunk, Listener<MemoryChunk>, Features<?>>().name("spriteImageMemory").mandatory(true).id(SpriteExtension.FeatureIDs.SPRITE_IMAGE_MEMORY).concept(() -> VulkanResourceModelDefinition.Groups.MEMORY_CHUNK).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(DRAW_TASK, INDEX_BUFFER_VIEWER, VERTEX_BUFFER_VIEWER, SPRITES_DESCRIPTOR, SPRITE_DATA_SOURCE, SPRITE_PIPELINE_SPECIALIZATION, SPRITE_IMAGE_MEMORY);
  }

  interface Builder extends IFeaturedObject.Builder<SpriteExtension> {
    Builder drawTask(Supplier<DrawIndexed> drawTask);
    Builder indexBufferViewer(Supplier<BufferViewer> indexBufferViewer);
    Builder vertexBufferViewer(Supplier<BufferViewer> vertexBufferViewer);
    Builder spritesDescriptor(Supplier<ImageDescriptor> spritesDescriptor);
    Builder spriteDataSource(Supplier<ISpriteDataSource> spriteDataSource);
    Builder spritePipelineSpecialization(Supplier<ConstantBuffer> spritePipelineSpecialization);
    Builder spriteImageMemory(Supplier<MemoryChunk> spriteImageMemory);
  }
}
