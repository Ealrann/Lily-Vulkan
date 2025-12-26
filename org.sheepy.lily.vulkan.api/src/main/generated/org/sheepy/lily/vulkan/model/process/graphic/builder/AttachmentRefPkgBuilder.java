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
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRef;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg;
import org.sheepy.lily.vulkan.model.process.graphic.AttachmentRefPkg.Builder;
import org.sheepy.lily.vulkan.model.process.graphic.impl.AttachmentRefPkgImpl;

public final class AttachmentRefPkgBuilder implements Builder {
  private final List<Supplier<AttachmentRef>> attachmentRefs = new ArrayList<>();

  public AttachmentRefPkgBuilder() {
  }

  @Override
  public AttachmentRefPkgBuilder addAttachmentRef(Supplier<AttachmentRef> attachmentRef) {
    this.attachmentRefs.add(attachmentRef);
    return this;
  }

  @Override
  public AttachmentRefPkgBuilder addAttachmentRefs(final List<AttachmentRef> attachmentRefs) {
    attachmentRefs.forEach(value -> this.attachmentRefs.add(() -> value));
    return this;
  }

  @Override
  public AttachmentRefPkg build() {
    final var builtAttachmentRefs = BuildUtils.collectSuppliers(attachmentRefs);
    final var built = new AttachmentRefPkgImpl();
    built.attachmentRefs().addAll(builtAttachmentRefs);
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
    private static final FeatureInserter<AttachmentRefPkgBuilder> ATTRIBUTE_INSERTER = new FeatureInserter.Builder<AttachmentRefPkgBuilder>(0, Inserters::attributeIndex).build();
    private static final RelationLazyInserter<AttachmentRefPkgBuilder> RELATION_INSERTER = new RelationLazyInserter.Builder<AttachmentRefPkgBuilder>(1, Inserters::relationIndex).add(AttachmentRefPkg.FeatureIDs.ATTACHMENT_REFS, (builder, value) -> builder.addAttachmentRef((Supplier<AttachmentRef>) value)).build();

    private static int attributeIndex(final int featureId) {
      throw new IllegalArgumentException("Unknown attribute featureId: " + featureId);
    }

    private static int relationIndex(final int featureId) {
      return switch (featureId) {
        case AttachmentRefPkg.FeatureIDs.ATTACHMENT_REFS -> 0;
        default -> throw new IllegalArgumentException("Unknown relation featureId: " + featureId);
      };
    }
  }
}
