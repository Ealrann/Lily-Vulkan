package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector4fc;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.ImageAttachment.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ImageAttachmentImpl;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class ImageAttachmentBuilder implements Builder {
  private String name;
  private ESampleCount samples = ESampleCount.SAMPLE_COUNT_1_BIT;
  private EAttachmentLoadOp loadOp = EAttachmentLoadOp.LOAD;
  private EAttachmentStoreOp storeOp = EAttachmentStoreOp.STORE;
  private EAttachmentLoadOp stencilLoadOp = EAttachmentLoadOp.LOAD;
  private EAttachmentStoreOp stencilStoreOp = EAttachmentStoreOp.STORE;
  private EImageLayout initialLayout = EImageLayout.UNDEFINED;
  private EImageLayout finalLayout = EImageLayout.UNDEFINED;
  private Vector4fc clearValue = ((Function<String, Vector4fc>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==4){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);float w=Float.parseFloat(split[3]);return new org.joml.Vector4f(x,y,z,w);}}return new org.joml.Vector4f(0f,0f,0f,0f); }).apply("0;0;0;0");
  private Supplier<VulkanEngine> imageRef = () -> null;

  public ImageAttachmentBuilder() {
  }

  @Override
  public ImageAttachmentBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ImageAttachmentBuilder samples(ESampleCount samples) {
    this.samples = samples;
    return this;
  }

  @Override
  public ImageAttachmentBuilder loadOp(EAttachmentLoadOp loadOp) {
    this.loadOp = loadOp;
    return this;
  }

  @Override
  public ImageAttachmentBuilder storeOp(EAttachmentStoreOp storeOp) {
    this.storeOp = storeOp;
    return this;
  }

  @Override
  public ImageAttachmentBuilder stencilLoadOp(EAttachmentLoadOp stencilLoadOp) {
    this.stencilLoadOp = stencilLoadOp;
    return this;
  }

  @Override
  public ImageAttachmentBuilder stencilStoreOp(EAttachmentStoreOp stencilStoreOp) {
    this.stencilStoreOp = stencilStoreOp;
    return this;
  }

  @Override
  public ImageAttachmentBuilder initialLayout(EImageLayout initialLayout) {
    this.initialLayout = initialLayout;
    return this;
  }

  @Override
  public ImageAttachmentBuilder finalLayout(EImageLayout finalLayout) {
    this.finalLayout = finalLayout;
    return this;
  }

  @Override
  public ImageAttachmentBuilder clearValue(Vector4fc clearValue) {
    this.clearValue = clearValue;
    return this;
  }

  @Override
  public ImageAttachmentBuilder imageRef(Supplier<VulkanEngine> imageRef) {
    this.imageRef = imageRef;
    return this;
  }

  @Override
  public ImageAttachment build() {
    final var built = new ImageAttachmentImpl(name);
    built.samples(samples);
    built.loadOp(loadOp);
    built.storeOp(storeOp);
    built.stencilLoadOp(stencilLoadOp);
    built.stencilStoreOp(stencilStoreOp);
    built.initialLayout(initialLayout);
    built.finalLayout(finalLayout);
    built.clearValue(clearValue);
    built.imageRef(imageRef.get());
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
    private static final FeatureInserter<ImageAttachmentBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ImageAttachmentBuilder>(9, Inserters::attributeIndex).add(ImageAttachment.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ImageAttachment.FeatureIDs.SAMPLES, (builder, value) -> builder.samples((ESampleCount) value)).add(ImageAttachment.FeatureIDs.LOAD_OP, (builder, value) -> builder.loadOp((EAttachmentLoadOp) value)).add(ImageAttachment.FeatureIDs.STORE_OP, (builder, value) -> builder.storeOp((EAttachmentStoreOp) value)).add(ImageAttachment.FeatureIDs.STENCIL_LOAD_OP, (builder, value) -> builder.stencilLoadOp((EAttachmentLoadOp) value)).add(ImageAttachment.FeatureIDs.STENCIL_STORE_OP, (builder, value) -> builder.stencilStoreOp((EAttachmentStoreOp) value)).add(ImageAttachment.FeatureIDs.INITIAL_LAYOUT, (builder, value) -> builder.initialLayout((EImageLayout) value)).add(ImageAttachment.FeatureIDs.FINAL_LAYOUT, (builder, value) -> builder.finalLayout((EImageLayout) value)).add(ImageAttachment.FeatureIDs.CLEAR_VALUE, (builder, value) -> builder.clearValue((Vector4fc) value)).build();
    private static final RelationLazyInserter<ImageAttachmentBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ImageAttachmentBuilder>(1, Inserters::relationIndex).add(ImageAttachment.FeatureIDs.IMAGE_REF, (builder, value) -> builder.imageRef((Supplier<VulkanEngine>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ImageAttachment.FeatureIDs.NAME -> 0;
        case ImageAttachment.FeatureIDs.SAMPLES -> 1;
        case ImageAttachment.FeatureIDs.LOAD_OP -> 2;
        case ImageAttachment.FeatureIDs.STORE_OP -> 3;
        case ImageAttachment.FeatureIDs.STENCIL_LOAD_OP -> 4;
        case ImageAttachment.FeatureIDs.STENCIL_STORE_OP -> 5;
        case ImageAttachment.FeatureIDs.INITIAL_LAYOUT -> 6;
        case ImageAttachment.FeatureIDs.FINAL_LAYOUT -> 7;
        case ImageAttachment.FeatureIDs.CLEAR_VALUE -> 8;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case ImageAttachment.FeatureIDs.IMAGE_REF -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
