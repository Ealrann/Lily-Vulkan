package org.sheepy.lily.vulkan.extra.model.nuklear.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearContext.Builder;
import org.sheepy.lily.vulkan.extra.model.nuklear.NuklearFont;
import org.sheepy.lily.vulkan.extra.model.nuklear.impl.NuklearContextImpl;
import org.sheepy.lily.vulkan.model.process.CompositeTask;
import org.sheepy.lily.vulkan.model.vulkanresource.BufferMemory;
import org.sheepy.lily.vulkan.model.vulkanresource.IBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.ImageDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.StaticImage;

public final class NuklearContextBuilder implements Builder {
  private String name;
  private Supplier<NuklearFont> font;
  private Supplier<StaticImage> nullTexture = () -> null;
  private Supplier<ImageDescriptor> imageArrayDescriptor = () -> null;
  private Supplier<IBuffer> vertexBuffer;
  private Supplier<IBuffer> indexBuffer;
  private Supplier<BufferMemory> vertexBufferMemory;
  private Supplier<CompositeTask> compositeDrawTask;

  public NuklearContextBuilder() {
  }

  @Override
  public NuklearContextBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public NuklearContextBuilder font(Supplier<NuklearFont> font) {
    this.font = font;
    return this;
  }

  @Override
  public NuklearContextBuilder nullTexture(Supplier<StaticImage> nullTexture) {
    this.nullTexture = nullTexture;
    return this;
  }

  @Override
  public NuklearContextBuilder imageArrayDescriptor(
      Supplier<ImageDescriptor> imageArrayDescriptor) {
    this.imageArrayDescriptor = imageArrayDescriptor;
    return this;
  }

  @Override
  public NuklearContextBuilder vertexBuffer(Supplier<IBuffer> vertexBuffer) {
    this.vertexBuffer = vertexBuffer;
    return this;
  }

  @Override
  public NuklearContextBuilder indexBuffer(Supplier<IBuffer> indexBuffer) {
    this.indexBuffer = indexBuffer;
    return this;
  }

  @Override
  public NuklearContextBuilder vertexBufferMemory(Supplier<BufferMemory> vertexBufferMemory) {
    this.vertexBufferMemory = vertexBufferMemory;
    return this;
  }

  @Override
  public NuklearContextBuilder compositeDrawTask(Supplier<CompositeTask> compositeDrawTask) {
    this.compositeDrawTask = compositeDrawTask;
    return this;
  }

  @Override
  public NuklearContext build() {
    final var built = new NuklearContextImpl(name, font.get(), vertexBuffer.get(), indexBuffer.get(), vertexBufferMemory.get(), compositeDrawTask.get());
    built.nullTexture(nullTexture.get());
    built.imageArrayDescriptor(imageArrayDescriptor.get());
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
    private static final FeatureInserter<NuklearContextBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<NuklearContextBuilder>(1, Inserters::attributeIndex).add(NuklearContext.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).build();
    private static final RelationLazyInserter<NuklearContextBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<NuklearContextBuilder>(7, Inserters::relationIndex).add(NuklearContext.FeatureIDs.FONT, (builder, value) -> builder.font((Supplier<NuklearFont>) value)).add(NuklearContext.FeatureIDs.NULL_TEXTURE, (builder, value) -> builder.nullTexture((Supplier<StaticImage>) value)).add(NuklearContext.FeatureIDs.IMAGE_ARRAY_DESCRIPTOR, (builder, value) -> builder.imageArrayDescriptor((Supplier<ImageDescriptor>) value)).add(NuklearContext.FeatureIDs.VERTEX_BUFFER, (builder, value) -> builder.vertexBuffer((Supplier<IBuffer>) value)).add(NuklearContext.FeatureIDs.INDEX_BUFFER, (builder, value) -> builder.indexBuffer((Supplier<IBuffer>) value)).add(NuklearContext.FeatureIDs.VERTEX_BUFFER_MEMORY, (builder, value) -> builder.vertexBufferMemory((Supplier<BufferMemory>) value)).add(NuklearContext.FeatureIDs.COMPOSITE_DRAW_TASK, (builder, value) -> builder.compositeDrawTask((Supplier<CompositeTask>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case NuklearContext.FeatureIDs.NAME -> 0;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case NuklearContext.FeatureIDs.FONT -> 0;
        case NuklearContext.FeatureIDs.NULL_TEXTURE -> 1;
        case NuklearContext.FeatureIDs.IMAGE_ARRAY_DESCRIPTOR -> 2;
        case NuklearContext.FeatureIDs.VERTEX_BUFFER -> 3;
        case NuklearContext.FeatureIDs.INDEX_BUFFER -> 4;
        case NuklearContext.FeatureIDs.VERTEX_BUFFER_MEMORY -> 5;
        case NuklearContext.FeatureIDs.COMPOSITE_DRAW_TASK -> 6;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
