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
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentPkg.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.ExtraAttachment;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentPkgImpl;

public final class AttachmentPkgBuilder implements Builder {
  private final List<Supplier<ExtraAttachment>> extraAttachments = new ArrayList<>();

  public AttachmentPkgBuilder() {
  }

  @Override
  public AttachmentPkgBuilder addExtraAttachment(Supplier<ExtraAttachment> extraAttachment) {
    this.extraAttachments.add(extraAttachment);
    return this;
  }

  @Override
  public AttachmentPkgBuilder addExtraAttachments(final List<ExtraAttachment> extraAttachments) {
    extraAttachments.forEach(value -> this.extraAttachments.add(() -> value));
    return this;
  }

  @Override
  public AttachmentPkg build() {
    final var builtExtraAttachments = BuildUtils.collectSuppliers(extraAttachments);
    final var built = new AttachmentPkgImpl();
    built.extraAttachments().addAll(builtExtraAttachments);
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
    private static final FeatureInserter<AttachmentPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<AttachmentPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<AttachmentPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<AttachmentPkgBuilder>(1, Inserters::relationIndex).add(AttachmentPkg.FeatureIDs.EXTRA_ATTACHMENTS, (builder, value) -> builder.addExtraAttachment((Supplier<ExtraAttachment>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case AttachmentPkg.FeatureIDs.EXTRA_ATTACHMENTS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
