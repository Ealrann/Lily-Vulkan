package org.sheepy.lily.vulkan.extra.model.sprite.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension.Builder;
import org.sheepy.lily.vulkan.extra.model.sprite.impl.SpriteExtensionImpl;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;

public final class SpriteExtensionBuilder implements Builder {
  private Supplier<DrawIndexed> drawTask;
  private Supplier<BufferViewer> indexBufferViewer;
  private Supplier<BufferViewer> vertexBufferViewer;
  private Supplier<ImageDescriptor> spritesDescriptor;
  private Supplier<ISpriteDataSource> spriteDataSource = () -> null;
  private Supplier<ConstantBuffer> spritePipelineSpecialization = () -> null;
  private Supplier<MemoryChunk> spriteImageMemory;

  public SpriteExtensionBuilder() {
  }

  @Override
  public SpriteExtensionBuilder drawTask(Supplier<DrawIndexed> drawTask) {
    this.drawTask = drawTask;
    return this;
  }

  @Override
  public SpriteExtensionBuilder indexBufferViewer(Supplier<BufferViewer> indexBufferViewer) {
    this.indexBufferViewer = indexBufferViewer;
    return this;
  }

  @Override
  public SpriteExtensionBuilder vertexBufferViewer(Supplier<BufferViewer> vertexBufferViewer) {
    this.vertexBufferViewer = vertexBufferViewer;
    return this;
  }

  @Override
  public SpriteExtensionBuilder spritesDescriptor(Supplier<ImageDescriptor> spritesDescriptor) {
    this.spritesDescriptor = spritesDescriptor;
    return this;
  }

  @Override
  public SpriteExtensionBuilder spriteDataSource(Supplier<ISpriteDataSource> spriteDataSource) {
    this.spriteDataSource = spriteDataSource;
    return this;
  }

  @Override
  public SpriteExtensionBuilder spritePipelineSpecialization(
      Supplier<ConstantBuffer> spritePipelineSpecialization) {
    this.spritePipelineSpecialization = spritePipelineSpecialization;
    return this;
  }

  @Override
  public SpriteExtensionBuilder spriteImageMemory(Supplier<MemoryChunk> spriteImageMemory) {
    this.spriteImageMemory = spriteImageMemory;
    return this;
  }

  @Override
  public SpriteExtension build() {
    final var built = new SpriteExtensionImpl(drawTask.get(), indexBufferViewer.get(), vertexBufferViewer.get(), spritesDescriptor.get(), spriteImageMemory.get());
    built.spriteDataSource(spriteDataSource.get());
    built.spritePipelineSpecialization(spritePipelineSpecialization.get());
    return built;
  }

  @Override
  public <AttributeType> void push(final Attribute<?, ?, ?, ?> attribute,
      final AttributeType value) {
    Inserters.ATTRIBUTE_INSERTER.push(this, attribute.id(), value);
  }

  @Override
  public <RelationType extends LMObject> void push(final Relation<RelationType, ?, ?, ?> relation,
      final Supplier<RelationType> supplier) {
    Inserters.RELATION_INSERTER.push(this, relation.id(), supplier);
  }

  private static final class Inserters {
    private static final FeatureInserter<SpriteExtensionBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<SpriteExtensionBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<SpriteExtensionBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<SpriteExtensionBuilder>(7, Inserters::relationIndex).add(SpriteExtension.FeatureIDs.DRAW_TASK, (builder, value) -> builder.drawTask((Supplier<DrawIndexed>) value)).add(SpriteExtension.FeatureIDs.INDEX_BUFFER_VIEWER, (builder, value) -> builder.indexBufferViewer((Supplier<BufferViewer>) value)).add(SpriteExtension.FeatureIDs.VERTEX_BUFFER_VIEWER, (builder, value) -> builder.vertexBufferViewer((Supplier<BufferViewer>) value)).add(SpriteExtension.FeatureIDs.SPRITES_DESCRIPTOR, (builder, value) -> builder.spritesDescriptor((Supplier<ImageDescriptor>) value)).add(SpriteExtension.FeatureIDs.SPRITE_DATA_SOURCE, (builder, value) -> builder.spriteDataSource((Supplier<ISpriteDataSource>) value)).add(SpriteExtension.FeatureIDs.SPRITE_PIPELINE_SPECIALIZATION, (builder, value) -> builder.spritePipelineSpecialization((Supplier<ConstantBuffer>) value)).add(SpriteExtension.FeatureIDs.SPRITE_IMAGE_MEMORY, (builder, value) -> builder.spriteImageMemory((Supplier<MemoryChunk>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case SpriteExtension.FeatureIDs.DRAW_TASK -> 0;
        case SpriteExtension.FeatureIDs.INDEX_BUFFER_VIEWER -> 1;
        case SpriteExtension.FeatureIDs.VERTEX_BUFFER_VIEWER -> 2;
        case SpriteExtension.FeatureIDs.SPRITES_DESCRIPTOR -> 3;
        case SpriteExtension.FeatureIDs.SPRITE_DATA_SOURCE -> 4;
        case SpriteExtension.FeatureIDs.SPRITE_PIPELINE_SPECIALIZATION -> 5;
        case SpriteExtension.FeatureIDs.SPRITE_IMAGE_MEMORY -> 6;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
