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
import org.sheepy.lily.vulkan.model.process.graphic.builder.RenderPassBuilder;

public interface RenderPass extends LMObject {
  static Builder builder() {
    return new RenderPassBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<ExtraAttachment> attachments();

  interface FeatureIDs {
    int ATTACHMENTS = -978567292;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<ExtraAttachment, List<ExtraAttachment>, Listener<List<ExtraAttachment>>, Features<?>> ATTACHMENTS = new RelationBuilder<ExtraAttachment, List<ExtraAttachment>, Listener<List<ExtraAttachment>>, Features<?>>().name("attachments").many(true).id(RenderPass.FeatureIDs.ATTACHMENTS).concept(() -> GraphicModelDefinition.Groups.EXTRA_ATTACHMENT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ATTACHMENTS);
  }

  interface Builder extends IFeaturedObject.Builder<RenderPass> {
    Builder addAttachment(Supplier<ExtraAttachment> attachment);
    Builder addAttachments(List<ExtraAttachment> attachments);
  }
}
