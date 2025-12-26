package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.util.BuildUtils;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass;
import org.sheepy.lily.vulkan.model.process.graphic.RenderPass.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.RenderPassImpl;

public final class RenderPassBuilder implements Builder {
  private final List<Supplier<ExtraAttachment>> attachments = new ArrayList<>();

  public RenderPassBuilder() {
  }

  @Override
  public RenderPassBuilder addAttachment(Supplier<ExtraAttachment> attachment) {
    this.attachments.add(attachment);
    return this;
  }

  @Override
  public RenderPassBuilder addAttachments(final List<ExtraAttachment> attachments) {
    attachments.forEach(value -> this.attachments.add(() -> value));
    return this;
  }

  @Override
  public RenderPass build() {
    final var builtAttachments = BuildUtils.collectSuppliers(attachments);
    final var built = new RenderPassImpl();
    built.attachments().addAll(builtAttachments);
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
    private static final FeatureInserter<RenderPassBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<RenderPassBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<RenderPassBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<RenderPassBuilder>(1, Inserters::relationIndex).add(RenderPass.FeatureIDs.ATTACHMENTS, (builder, value) -> builder.addAttachment((Supplier<ExtraAttachment>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case RenderPass.FeatureIDs.ATTACHMENTS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
