package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.DepthAttachment.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.DepthAttachmentImpl;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public final class DepthAttachmentBuilder implements Builder {
  private String name;
  private ESampleCount samples = ESampleCount.SAMPLE_COUNT_1_BIT;
  private EAttachmentLoadOp loadOp = EAttachmentLoadOp.LOAD;
  private EAttachmentStoreOp storeOp = EAttachmentStoreOp.STORE;
  private EAttachmentLoadOp stencilLoadOp = EAttachmentLoadOp.LOAD;
  private EAttachmentStoreOp stencilStoreOp = EAttachmentStoreOp.STORE;
  private EImageLayout initialLayout = EImageLayout.UNDEFINED;
  private EImageLayout finalLayout = EImageLayout.UNDEFINED;
  private boolean clear = true;
  private final List<EImageUsage> usages = new ArrayList<>();

  public DepthAttachmentBuilder() {
  }

  @Override
  public DepthAttachmentBuilder name(String name) {
    this.name = name;
    return this;
  }

  @Override
  public DepthAttachmentBuilder samples(ESampleCount samples) {
    this.samples = samples;
    return this;
  }

  @Override
  public DepthAttachmentBuilder loadOp(EAttachmentLoadOp loadOp) {
    this.loadOp = loadOp;
    return this;
  }

  @Override
  public DepthAttachmentBuilder storeOp(EAttachmentStoreOp storeOp) {
    this.storeOp = storeOp;
    return this;
  }

  @Override
  public DepthAttachmentBuilder stencilLoadOp(EAttachmentLoadOp stencilLoadOp) {
    this.stencilLoadOp = stencilLoadOp;
    return this;
  }

  @Override
  public DepthAttachmentBuilder stencilStoreOp(EAttachmentStoreOp stencilStoreOp) {
    this.stencilStoreOp = stencilStoreOp;
    return this;
  }

  @Override
  public DepthAttachmentBuilder initialLayout(EImageLayout initialLayout) {
    this.initialLayout = initialLayout;
    return this;
  }

  @Override
  public DepthAttachmentBuilder finalLayout(EImageLayout finalLayout) {
    this.finalLayout = finalLayout;
    return this;
  }

  @Override
  public DepthAttachmentBuilder clear(boolean clear) {
    this.clear = clear;
    return this;
  }

  @Override
  public DepthAttachmentBuilder addUsage(EImageUsage usage) {
    this.usages.add(usage);
    return this;
  }

  @Override
  public DepthAttachmentBuilder addUsages(final List<EImageUsage> usages) {
    this.usages.addAll(usages);
    return this;
  }

  @Override
  public DepthAttachment build() {
    final var built = new DepthAttachmentImpl(name);
    built.samples(samples);
    built.loadOp(loadOp);
    built.storeOp(storeOp);
    built.stencilLoadOp(stencilLoadOp);
    built.stencilStoreOp(stencilStoreOp);
    built.initialLayout(initialLayout);
    built.finalLayout(finalLayout);
    built.clear(clear);
    built.usages().addAll(usages);
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
    private static final FeatureInserter<DepthAttachmentBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<DepthAttachmentBuilder>(10, Inserters::attributeIndex).add(DepthAttachment.FeatureIDs.NAME, (builder, value) -> builder.name((String) value)).add(DepthAttachment.FeatureIDs.SAMPLES, (builder, value) -> builder.samples((ESampleCount) value)).add(DepthAttachment.FeatureIDs.LOAD_OP, (builder, value) -> builder.loadOp((EAttachmentLoadOp) value)).add(DepthAttachment.FeatureIDs.STORE_OP, (builder, value) -> builder.storeOp((EAttachmentStoreOp) value)).add(DepthAttachment.FeatureIDs.STENCIL_LOAD_OP, (builder, value) -> builder.stencilLoadOp((EAttachmentLoadOp) value)).add(DepthAttachment.FeatureIDs.STENCIL_STORE_OP, (builder, value) -> builder.stencilStoreOp((EAttachmentStoreOp) value)).add(DepthAttachment.FeatureIDs.INITIAL_LAYOUT, (builder, value) -> builder.initialLayout((EImageLayout) value)).add(DepthAttachment.FeatureIDs.FINAL_LAYOUT, (builder, value) -> builder.finalLayout((EImageLayout) value)).add(DepthAttachment.FeatureIDs.CLEAR, (builder, value) -> builder.clear((boolean) value)).add(DepthAttachment.FeatureIDs.USAGES, (builder, value) -> builder.addUsage((EImageUsage) value)).build();
    private static final RelationLazyInserter<DepthAttachmentBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<DepthAttachmentBuilder>(0, Inserters::relationIndex).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case DepthAttachment.FeatureIDs.NAME -> 0;
        case DepthAttachment.FeatureIDs.SAMPLES -> 1;
        case DepthAttachment.FeatureIDs.LOAD_OP -> 2;
        case DepthAttachment.FeatureIDs.STORE_OP -> 3;
        case DepthAttachment.FeatureIDs.STENCIL_LOAD_OP -> 4;
        case DepthAttachment.FeatureIDs.STENCIL_STORE_OP -> 5;
        case DepthAttachment.FeatureIDs.INITIAL_LAYOUT -> 6;
        case DepthAttachment.FeatureIDs.FINAL_LAYOUT -> 7;
        case DepthAttachment.FeatureIDs.CLEAR -> 8;
        case DepthAttachment.FeatureIDs.USAGES -> 9;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
    }
  }
}
