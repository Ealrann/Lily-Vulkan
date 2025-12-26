package org.sheepy.lily.vulkan.model.process.graphic.builder;

import java.util.function.Supplier;
import org.logoce.lmf.core.feature.FeatureInserter;
import org.logoce.lmf.core.feature.RelationLazyInserter;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.sheepy.lily.vulkan.model.process.graphic.Attachment;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.EAttachmentType;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentRefImpl;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public final class AttachmentRefBuilder implements Builder {
  private Supplier<Attachment> attachment = () -> null;
  private EImageLayout layout = EImageLayout.UNDEFINED;
  private EAttachmentType type = EAttachmentType.Color;

  public AttachmentRefBuilder() {
  }

  @Override
  public AttachmentRefBuilder attachment(Supplier<Attachment> attachment) {
    this.attachment = attachment;
    return this;
  }

  @Override
  public AttachmentRefBuilder layout(EImageLayout layout) {
    this.layout = layout;
    return this;
  }

  @Override
  public AttachmentRefBuilder type(EAttachmentType type) {
    this.type = type;
    return this;
  }

  @Override
  public AttachmentRef build() {
    final var built = new AttachmentRefImpl(type);
    built.attachment(attachment.get());
    built.layout(layout);
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
    private static final FeatureInserter<AttachmentRefBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<AttachmentRefBuilder>(2, Inserters::attributeIndex).add(AttachmentRef.FeatureIDs.LAYOUT, (builder, value) -> builder.layout((EImageLayout) value)).add(AttachmentRef.FeatureIDs.TYPE, (builder, value) -> builder.type((EAttachmentType) value)).build();
    private static final RelationLazyInserter<AttachmentRefBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<AttachmentRefBuilder>(1, Inserters::relationIndex).add(AttachmentRef.FeatureIDs.ATTACHMENT, (builder, value) -> builder.attachment((Supplier<Attachment>) value)).build();

    private static int attributeIndex(final int featureId) {
      return switch (featureId) {
        case AttachmentRef.FeatureIDs.LAYOUT -> 0;
        case AttachmentRef.FeatureIDs.TYPE -> 1;
        default -> throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
      };
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case AttachmentRef.FeatureIDs.ATTACHMENT -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
