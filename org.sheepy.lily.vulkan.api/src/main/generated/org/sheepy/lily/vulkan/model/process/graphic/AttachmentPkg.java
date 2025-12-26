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
import org.sheepy.lily.vulkan.model.process.graphic.builder.AttachmentPkgBuilder;

public interface AttachmentPkg extends LMObject {
  static Builder builder() {
    return new AttachmentPkgBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ExtraAttachment> extraAttachments();

  interface FeatureIDs {
    int EXTRA_ATTACHMENTS = -1778460616;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<ExtraAttachment, List<ExtraAttachment>, Listener<List<ExtraAttachment>>, Features<?>> EXTRA_ATTACHMENTS = new RelationBuilder<ExtraAttachment, List<ExtraAttachment>, Listener<List<ExtraAttachment>>, Features<?>>().name("extraAttachments").many(true).contains(true).id(AttachmentPkg.FeatureIDs.EXTRA_ATTACHMENTS).concept(() -> GraphicModelDefinition.Groups.EXTRA_ATTACHMENT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(EXTRA_ATTACHMENTS);
  }

  interface Builder extends IFeaturedObject.Builder<AttachmentPkg> {
    Builder addExtraAttachment(Supplier<ExtraAttachment> extraAttachment);
    Builder addExtraAttachments(List<ExtraAttachment> extraAttachments);
  }
}
