package org.sheepy.lily.vulkan.extra.model.sprite.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.sprite.ISpriteDataSource;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteExtension;
import org.sheepy.lily.vulkan.extra.model.sprite.SpriteModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.DrawIndexed;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferViewer;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.MemoryChunk;

public final class SpriteExtensionImpl extends FeaturedObject<SpriteExtension.Features<?>> implements SpriteExtension {
  private static final int FEATURE_COUNT = 7;
  private final ModelNotifier<SpriteExtension.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private DrawIndexed drawTask;
  private BufferViewer indexBufferViewer;
  private BufferViewer vertexBufferViewer;
  private ImageDescriptor spritesDescriptor;
  private ISpriteDataSource spriteDataSource;
  private ConstantBuffer spritePipelineSpecialization;
  private MemoryChunk spriteImageMemory;

  public SpriteExtensionImpl(final DrawIndexed drawTask, final BufferViewer indexBufferViewer,
      final BufferViewer vertexBufferViewer, final ImageDescriptor spritesDescriptor,
      final MemoryChunk spriteImageMemory) {
    this.drawTask = drawTask;
    this.indexBufferViewer = indexBufferViewer;
    this.vertexBufferViewer = vertexBufferViewer;
    this.spritesDescriptor = spritesDescriptor;
    this.spriteImageMemory = spriteImageMemory;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<SpriteExtension.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public DrawIndexed drawTask() {
    return drawTask;
  }

  @Override
  public void drawTask(final DrawIndexed drawTask) {
    final var oldValue = this.drawTask;
    final var eventType = drawTask == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.drawTask = drawTask;
    notifier.notify(SpriteExtension.FeatureIDs.DRAW_TASK, false, false, eventType, oldValue, drawTask);
  }

  @Override
  public BufferViewer indexBufferViewer() {
    return indexBufferViewer;
  }

  @Override
  public void indexBufferViewer(final BufferViewer indexBufferViewer) {
    final var oldValue = this.indexBufferViewer;
    final var eventType = indexBufferViewer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.indexBufferViewer = indexBufferViewer;
    notifier.notify(SpriteExtension.FeatureIDs.INDEX_BUFFER_VIEWER, false, false, eventType, oldValue, indexBufferViewer);
  }

  @Override
  public BufferViewer vertexBufferViewer() {
    return vertexBufferViewer;
  }

  @Override
  public void vertexBufferViewer(final BufferViewer vertexBufferViewer) {
    final var oldValue = this.vertexBufferViewer;
    final var eventType = vertexBufferViewer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.vertexBufferViewer = vertexBufferViewer;
    notifier.notify(SpriteExtension.FeatureIDs.VERTEX_BUFFER_VIEWER, false, false, eventType, oldValue, vertexBufferViewer);
  }

  @Override
  public ImageDescriptor spritesDescriptor() {
    return spritesDescriptor;
  }

  @Override
  public void spritesDescriptor(final ImageDescriptor spritesDescriptor) {
    final var oldValue = this.spritesDescriptor;
    final var eventType = spritesDescriptor == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.spritesDescriptor = spritesDescriptor;
    notifier.notify(SpriteExtension.FeatureIDs.SPRITES_DESCRIPTOR, false, false, eventType, oldValue, spritesDescriptor);
  }

  @Override
  public ISpriteDataSource spriteDataSource() {
    return spriteDataSource;
  }

  @Override
  public void spriteDataSource(final ISpriteDataSource spriteDataSource) {
    final var oldValue = this.spriteDataSource;
    final var eventType = spriteDataSource == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.spriteDataSource = spriteDataSource;
    notifier.notify(SpriteExtension.FeatureIDs.SPRITE_DATA_SOURCE, false, false, eventType, oldValue, spriteDataSource);
  }

  @Override
  public ConstantBuffer spritePipelineSpecialization() {
    return spritePipelineSpecialization;
  }

  @Override
  public void spritePipelineSpecialization(final ConstantBuffer spritePipelineSpecialization) {
    final var oldValue = this.spritePipelineSpecialization;
    final var eventType = spritePipelineSpecialization == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.spritePipelineSpecialization = spritePipelineSpecialization;
    notifier.notify(SpriteExtension.FeatureIDs.SPRITE_PIPELINE_SPECIALIZATION, false, false, eventType, oldValue, spritePipelineSpecialization);
  }

  @Override
  public MemoryChunk spriteImageMemory() {
    return spriteImageMemory;
  }

  @Override
  public void spriteImageMemory(final MemoryChunk spriteImageMemory) {
    final var oldValue = this.spriteImageMemory;
    final var eventType = spriteImageMemory == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.spriteImageMemory = spriteImageMemory;
    notifier.notify(SpriteExtension.FeatureIDs.SPRITE_IMAGE_MEMORY, false, false, eventType, oldValue, spriteImageMemory);
  }

  @Override
  public Group<SpriteExtension> lmGroup() {
    return SpriteModelDefinition.Groups.SPRITE_EXTENSION;
  }

  @Override
  protected FeatureSetter<SpriteExtension> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<SpriteExtension> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case SpriteExtension.FeatureIDs.DRAW_TASK -> 0;
      case SpriteExtension.FeatureIDs.INDEX_BUFFER_VIEWER -> 1;
      case SpriteExtension.FeatureIDs.VERTEX_BUFFER_VIEWER -> 2;
      case SpriteExtension.FeatureIDs.SPRITES_DESCRIPTOR -> 3;
      case SpriteExtension.FeatureIDs.SPRITE_DATA_SOURCE -> 4;
      case SpriteExtension.FeatureIDs.SPRITE_PIPELINE_SPECIALIZATION -> 5;
      case SpriteExtension.FeatureIDs.SPRITE_IMAGE_MEMORY -> 6;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<SpriteExtension> GET_MAP = new FeatureGetter.Builder<SpriteExtension>(FEATURE_COUNT, SpriteExtensionImpl::featureIndexStatic).add(SpriteExtension.FeatureIDs.DRAW_TASK, SpriteExtension::drawTask).add(SpriteExtension.FeatureIDs.INDEX_BUFFER_VIEWER, SpriteExtension::indexBufferViewer).add(SpriteExtension.FeatureIDs.VERTEX_BUFFER_VIEWER, SpriteExtension::vertexBufferViewer).add(SpriteExtension.FeatureIDs.SPRITES_DESCRIPTOR, SpriteExtension::spritesDescriptor).add(SpriteExtension.FeatureIDs.SPRITE_DATA_SOURCE, SpriteExtension::spriteDataSource).add(SpriteExtension.FeatureIDs.SPRITE_PIPELINE_SPECIALIZATION, SpriteExtension::spritePipelineSpecialization).add(SpriteExtension.FeatureIDs.SPRITE_IMAGE_MEMORY, SpriteExtension::spriteImageMemory).build();
    private static final FeatureSetter<SpriteExtension> SET_MAP = new FeatureSetter.Builder<SpriteExtension>(FEATURE_COUNT, SpriteExtensionImpl::featureIndexStatic).add(SpriteExtension.FeatureIDs.DRAW_TASK, (object, value) -> ((SpriteExtensionImpl) object).drawTask((DrawIndexed) value)).add(SpriteExtension.FeatureIDs.INDEX_BUFFER_VIEWER, (object, value) -> ((SpriteExtensionImpl) object).indexBufferViewer((BufferViewer) value)).add(SpriteExtension.FeatureIDs.VERTEX_BUFFER_VIEWER, (object, value) -> ((SpriteExtensionImpl) object).vertexBufferViewer((BufferViewer) value)).add(SpriteExtension.FeatureIDs.SPRITES_DESCRIPTOR, (object, value) -> ((SpriteExtensionImpl) object).spritesDescriptor((ImageDescriptor) value)).add(SpriteExtension.FeatureIDs.SPRITE_DATA_SOURCE, (object, value) -> ((SpriteExtensionImpl) object).spriteDataSource((ISpriteDataSource) value)).add(SpriteExtension.FeatureIDs.SPRITE_PIPELINE_SPECIALIZATION, (object, value) -> ((SpriteExtensionImpl) object).spritePipelineSpecialization((ConstantBuffer) value)).add(SpriteExtension.FeatureIDs.SPRITE_IMAGE_MEMORY, (object, value) -> ((SpriteExtensionImpl) object).spriteImageMemory((MemoryChunk) value)).build();
  }
}
