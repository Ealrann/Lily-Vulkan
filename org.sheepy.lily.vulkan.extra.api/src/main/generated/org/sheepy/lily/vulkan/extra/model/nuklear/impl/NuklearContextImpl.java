package org.sheepy.lily.vulkan.extra.model.nuklear.impl;

import org.logoce.lmf.core.api.model.FeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.model.ModelNotifier;
import org.logoce.lmf.core.api.notification.Notification;
import org.logoce.lmf.core.feature.FeatureGetter;
import org.logoce.lmf.core.feature.FeatureSetter;
import org.logoce.lmf.core.lang.Group;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearModelDefinition;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;

public final class NuklearContextImpl extends FeaturedObject<NuklearContext.Features<?>> implements NuklearContext {
  private static final int FEATURE_COUNT = 8;
  private final ModelNotifier<NuklearContext.Features<?>> notifier = new ModelNotifier<>(this, FEATURE_COUNT, this::featureIndex);
  private final String name;
  private NuklearFont font;
  private StaticImage nullTexture;
  private ImageDescriptor imageArrayDescriptor;
  private IBuffer vertexBuffer;
  private IBuffer indexBuffer;
  private BufferMemory vertexBufferMemory;
  private CompositeTask compositeDrawTask;

  public NuklearContextImpl(final String name, final NuklearFont font, final IBuffer vertexBuffer,
      final IBuffer indexBuffer, final BufferMemory vertexBufferMemory,
      final CompositeTask compositeDrawTask) {
    this.name = name;
    this.font = font;
    this.vertexBuffer = vertexBuffer;
    this.indexBuffer = indexBuffer;
    this.vertexBufferMemory = vertexBufferMemory;
    this.compositeDrawTask = compositeDrawTask;
    notifier.eDeliver(true);
  }

  @Override
  public IModelNotifier.Impl<NuklearContext.Features<?>> notifier() {
    return notifier;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public NuklearFont font() {
    return font;
  }

  @Override
  public void font(final NuklearFont font) {
    final var oldValue = this.font;
    final var eventType = font == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.font = font;
    notifier.notify(NuklearContext.FeatureIDs.FONT, false, false, eventType, oldValue, font);
  }

  @Override
  public StaticImage nullTexture() {
    return nullTexture;
  }

  @Override
  public void nullTexture(final StaticImage nullTexture) {
    final var oldValue = this.nullTexture;
    final var eventType = nullTexture == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.nullTexture = nullTexture;
    notifier.notify(NuklearContext.FeatureIDs.NULL_TEXTURE, false, false, eventType, oldValue, nullTexture);
  }

  @Override
  public ImageDescriptor imageArrayDescriptor() {
    return imageArrayDescriptor;
  }

  @Override
  public void imageArrayDescriptor(final ImageDescriptor imageArrayDescriptor) {
    final var oldValue = this.imageArrayDescriptor;
    final var eventType = imageArrayDescriptor == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.imageArrayDescriptor = imageArrayDescriptor;
    notifier.notify(NuklearContext.FeatureIDs.IMAGE_ARRAY_DESCRIPTOR, false, false, eventType, oldValue, imageArrayDescriptor);
  }

  @Override
  public IBuffer vertexBuffer() {
    return vertexBuffer;
  }

  @Override
  public void vertexBuffer(final IBuffer vertexBuffer) {
    final var oldValue = this.vertexBuffer;
    final var eventType = vertexBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.vertexBuffer = vertexBuffer;
    notifier.notify(NuklearContext.FeatureIDs.VERTEX_BUFFER, false, false, eventType, oldValue, vertexBuffer);
  }

  @Override
  public IBuffer indexBuffer() {
    return indexBuffer;
  }

  @Override
  public void indexBuffer(final IBuffer indexBuffer) {
    final var oldValue = this.indexBuffer;
    final var eventType = indexBuffer == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.indexBuffer = indexBuffer;
    notifier.notify(NuklearContext.FeatureIDs.INDEX_BUFFER, false, false, eventType, oldValue, indexBuffer);
  }

  @Override
  public BufferMemory vertexBufferMemory() {
    return vertexBufferMemory;
  }

  @Override
  public void vertexBufferMemory(final BufferMemory vertexBufferMemory) {
    final var oldValue = this.vertexBufferMemory;
    final var eventType = vertexBufferMemory == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.vertexBufferMemory = vertexBufferMemory;
    notifier.notify(NuklearContext.FeatureIDs.VERTEX_BUFFER_MEMORY, false, false, eventType, oldValue, vertexBufferMemory);
  }

  @Override
  public CompositeTask compositeDrawTask() {
    return compositeDrawTask;
  }

  @Override
  public void compositeDrawTask(final CompositeTask compositeDrawTask) {
    final var oldValue = this.compositeDrawTask;
    final var eventType = compositeDrawTask == null ? Notification.EventType.UNSET : Notification.EventType.SET;
    this.compositeDrawTask = compositeDrawTask;
    notifier.notify(NuklearContext.FeatureIDs.COMPOSITE_DRAW_TASK, false, false, eventType, oldValue, compositeDrawTask);
  }

  @Override
  public Group<NuklearContext> lmGroup() {
    return NuklearModelDefinition.Groups.NUKLEAR_CONTEXT;
  }

  @Override
  protected FeatureSetter<NuklearContext> setterMap() {
    return Inserters.SET_MAP;
  }

  @Override
  protected FeatureGetter<NuklearContext> getterMap() {
    return Inserters.GET_MAP;
  }

  public static int featureIndexStatic(int featureId) {
    return switch (featureId) {
      case NuklearContext.FeatureIDs.NAME -> 0;
      case NuklearContext.FeatureIDs.FONT -> 1;
      case NuklearContext.FeatureIDs.NULL_TEXTURE -> 2;
      case NuklearContext.FeatureIDs.IMAGE_ARRAY_DESCRIPTOR -> 3;
      case NuklearContext.FeatureIDs.VERTEX_BUFFER -> 4;
      case NuklearContext.FeatureIDs.INDEX_BUFFER -> 5;
      case NuklearContext.FeatureIDs.VERTEX_BUFFER_MEMORY -> 6;
      case NuklearContext.FeatureIDs.COMPOSITE_DRAW_TASK -> 7;
      default -> throw new IllegalArgumentException("Unknown featureId: " + featureId);
    };
  }

  @Override
  public int featureIndex(int featureId) {
    return featureIndexStatic(featureId);
  }

  private static final class Inserters {
    private static final FeatureGetter<NuklearContext> GET_MAP = new FeatureGetter.Builder<NuklearContext>(FEATURE_COUNT, NuklearContextImpl::featureIndexStatic).add(NuklearContext.FeatureIDs.NAME, NuklearContext::name).add(NuklearContext.FeatureIDs.FONT, NuklearContext::font).add(NuklearContext.FeatureIDs.NULL_TEXTURE, NuklearContext::nullTexture).add(NuklearContext.FeatureIDs.IMAGE_ARRAY_DESCRIPTOR, NuklearContext::imageArrayDescriptor).add(NuklearContext.FeatureIDs.VERTEX_BUFFER, NuklearContext::vertexBuffer).add(NuklearContext.FeatureIDs.INDEX_BUFFER, NuklearContext::indexBuffer).add(NuklearContext.FeatureIDs.VERTEX_BUFFER_MEMORY, NuklearContext::vertexBufferMemory).add(NuklearContext.FeatureIDs.COMPOSITE_DRAW_TASK, NuklearContext::compositeDrawTask).build();
    private static final FeatureSetter<NuklearContext> SET_MAP = new FeatureSetter.Builder<NuklearContext>(FEATURE_COUNT, NuklearContextImpl::featureIndexStatic).add(NuklearContext.FeatureIDs.FONT, (object, value) -> ((NuklearContextImpl) object).font((NuklearFont) value)).add(NuklearContext.FeatureIDs.NULL_TEXTURE, (object, value) -> ((NuklearContextImpl) object).nullTexture((StaticImage) value)).add(NuklearContext.FeatureIDs.IMAGE_ARRAY_DESCRIPTOR, (object, value) -> ((NuklearContextImpl) object).imageArrayDescriptor((ImageDescriptor) value)).add(NuklearContext.FeatureIDs.VERTEX_BUFFER, (object, value) -> ((NuklearContextImpl) object).vertexBuffer((IBuffer) value)).add(NuklearContext.FeatureIDs.INDEX_BUFFER, (object, value) -> ((NuklearContextImpl) object).indexBuffer((IBuffer) value)).add(NuklearContext.FeatureIDs.VERTEX_BUFFER_MEMORY, (object, value) -> ((NuklearContextImpl) object).vertexBufferMemory((BufferMemory) value)).add(NuklearContext.FeatureIDs.COMPOSITE_DRAW_TASK, (object, value) -> ((NuklearContextImpl) object).compositeDrawTask((CompositeTask) value)).build();
  }
}
