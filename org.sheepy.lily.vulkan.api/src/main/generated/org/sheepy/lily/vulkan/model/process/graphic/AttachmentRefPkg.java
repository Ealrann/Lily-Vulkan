package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.AttachmentRefPkgBuilder;

public interface AttachmentRefPkg extends LMObject {
  static Builder builder() {
    return new AttachmentRefPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<AttachmentRef> attachmentRefs();

  interface FeatureIDs {
    int ATTACHMENT_REFS = -256629286;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<AttachmentRef, List<AttachmentRef>, Listener<List<AttachmentRef>>, Features<?>> ATTACHMENT_REFS = new RelationBuilder<AttachmentRef, List<AttachmentRef>, Listener<List<AttachmentRef>>, Features<?>>().name("attachmentRefs").many(true).contains(true).id(AttachmentRefPkg.FeatureIDs.ATTACHMENT_REFS).concept(() -> GraphicModelDefinition.Groups.ATTACHMENT_REF).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ATTACHMENT_REFS);
  }

  interface Builder extends IFeaturedObject.Builder<AttachmentRefPkg> {
    Builder addAttachmentRef(Supplier<AttachmentRef> attachmentRef);
    Builder addAttachmentRefs(List<AttachmentRef> attachmentRefs);
  }
}
