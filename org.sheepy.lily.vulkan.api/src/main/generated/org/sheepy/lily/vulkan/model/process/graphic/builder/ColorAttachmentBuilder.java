package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import org.joml.Vector4fc;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.ColorAttachment.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.ColorAttachmentImpl;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EFormat;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class ColorAttachmentBuilder implements Builder {
  private String name;
  private ESampleCount samples = ESampleCount.SAMPLE_COUNT_1_BIT;
  private EAttachmentLoadOp loadOp = EAttachmentLoadOp.LOAD;
  private EAttachmentStoreOp storeOp = EAttachmentStoreOp.STORE;
  private EAttachmentLoadOp stencilLoadOp = EAttachmentLoadOp.LOAD;
  private EAttachmentStoreOp stencilStoreOp = EAttachmentStoreOp.STORE;
  private EImageLayout initialLayout = EImageLayout.UNDEFINED;
  private EImageLayout finalLayout = EImageLayout.UNDEFINED;
  private Vector4fc clearValue = ((Function<String, Vector4fc>) it -> { if(it!=null){final String[] split=it.split(";");if(split.length==4){float x=Float.parseFloat(split[0]);float y=Float.parseFloat(split[1]);float z=Float.parseFloat(split[2]);float w=Float.parseFloat(split[3]);return new org.joml.Vector4f(x,y,z,w);}}return new org.joml.Vector4f(0f,0f,0f,0f); }).apply("0;0;0;0");
  private final List<EImageUsage> usages = new ArrayList<>();
  private EFormat format = EFormat.UNDEFINED;

  public ColorAttachmentBuilder() {
  }

  @Override
  public ColorAttachmentBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public ColorAttachmentBuilder samples(ESampleCount samples) {
    this.samples = samples;
    return this;
  }

  @Override
  public ColorAttachmentBuilder loadOp(EAttachmentLoadOp loadOp) {
    this.loadOp = loadOp;
    return this;
  }

  @Override
  public ColorAttachmentBuilder storeOp(EAttachmentStoreOp storeOp) {
    this.storeOp = storeOp;
    return this;
  }

  @Override
  public ColorAttachmentBuilder stencilLoadOp(EAttachmentLoadOp stencilLoadOp) {
    this.stencilLoadOp = stencilLoadOp;
    return this;
  }

  @Override
  public ColorAttachmentBuilder stencilStoreOp(EAttachmentStoreOp stencilStoreOp) {
    this.stencilStoreOp = stencilStoreOp;
    return this;
  }

  @Override
  public ColorAttachmentBuilder initialLayout(EImageLayout initialLayout) {
    this.initialLayout = initialLayout;
    return this;
  }

  @Override
  public ColorAttachmentBuilder finalLayout(EImageLayout finalLayout) {
    this.finalLayout = finalLayout;
    return this;
  }

  @Override
  public ColorAttachmentBuilder clearValue(Vector4fc clearValue) {
    this.clearValue = clearValue;
    return this;
  }

  @Override
  public ColorAttachmentBuilder addUsage(EImageUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public ColorAttachmentBuilder addUsages(final List<EImageUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public ColorAttachmentBuilder format(EFormat format) {
    this.format = format;
    return this;
  }

  @Override
  public ColorAttachment build() {
    final var built = new ColorAttachmentImpl(name);
    built.samples(samples);
    built.loadOp(loadOp);
    built.storeOp(storeOp);
    built.stencilLoadOp(stencilLoadOp);
    built.stencilStoreOp(stencilStoreOp);
    built.initialLayout(initialLayout);
    built.finalLayout(finalLayout);
    built.clearValue(clearValue);
    built.usages().addAll(usages);
    built.format(format);
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
    private static final FeatureInserter<ColorAttachmentBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<ColorAttachmentBuilder>(11, Inserters::attributeIndex).add(ColorAttachment.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(ColorAttachment.FeatureIDs.SAMPLES, (builder, value) -> builder.samples((ESampleCount) value)).add(ColorAttachment.FeatureIDs.LOAD_OP, (builder, value) -> builder.loadOp((EAttachmentLoadOp) value)).add(ColorAttachment.FeatureIDs.STORE_OP, (builder, value) -> builder.storeOp((EAttachmentStoreOp) value)).add(ColorAttachment.FeatureIDs.STENCIL_LOAD_OP, (builder, value) -> builder.stencilLoadOp((EAttachmentLoadOp) value)).add(ColorAttachment.FeatureIDs.STENCIL_STORE_OP, (builder, value) -> builder.stencilStoreOp((EAttachmentStoreOp) value)).add(ColorAttachment.FeatureIDs.INITIAL_LAYOUT, (builder, value) -> builder.initialLayout((EImageLayout) value)).add(ColorAttachment.FeatureIDs.FINAL_LAYOUT, (builder, value) -> builder.finalLayout((EImageLayout) value)).add(ColorAttachment.FeatureIDs.CLEAR_VALUE, (builder, value) -> builder.clearValue((Vector4fc) value)).add(ColorAttachment.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EImageUsage) value)).add(ColorAttachment.FeatureIDs.FORMAT, (builder, value) -> builder.format((EFormat) value)).build();
    private static final RelationLazyInserter<ColorAttachmentBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<ColorAttachmentBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case ColorAttachment.FeatureIDs.NAME -> 0;
        case ColorAttachment.FeatureIDs.SAMPLES -> 1;
        case ColorAttachment.FeatureIDs.LOAD_OP -> 2;
        case ColorAttachment.FeatureIDs.STORE_OP -> 3;
        case ColorAttachment.FeatureIDs.STENCIL_LOAD_OP -> 4;
        case ColorAttachment.FeatureIDs.STENCIL_STORE_OP -> 5;
        case ColorAttachment.FeatureIDs.INITIAL_LAYOUT -> 6;
        case ColorAttachment.FeatureIDs.FINAL_LAYOUT -> 7;
        case ColorAttachment.FeatureIDs.CLEAR_VALUE -> 8;
        case ColorAttachment.FeatureIDs.USAGES -> 9;
        case ColorAttachment.FeatureIDs.FORMAT -> 10;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
