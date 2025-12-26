package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.AttachmentRefBuilder;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface AttachmentRef extends LMObject {
  static Builder builder() {
    return new AttachmentRefBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Attachment attachment();
  EImageLayout layout();
  EAttachmentType type();
  void attachment(final Attachment attachment);
  void layout(final EImageLayout layout);
  void type(final EAttachmentType type);

  interface FeatureIDs {
    int ATTACHMENT = 1122020532;
    int LAYOUT = 1616297787;
    int TYPE = 1749427083;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Relation<Attachment, Attachment, Listener<Attachment>, Features<?>> ATTACHMENT = new RelationBuilder<Attachment, Attachment, Listener<Attachment>, Features<?>>().name("attachment").id(AttachmentRef.FeatureIDs.ATTACHMENT).concept(() -> GraphicModelDefinition.Groups.ATTACHMENT).build();
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("layout").id(AttachmentRef.FeatureIDs.LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    Attribute<EAttachmentType, EAttachmentType, Listener<EAttachmentType>, Features<?>> TYPE = new AttributeBuilder<EAttachmentType, EAttachmentType, Listener<EAttachmentType>, Features<?>>().name("type").mandatory(true).defaultValue("Color").id(AttachmentRef.FeatureIDs.TYPE).datatype(() -> GraphicModelDefinition.Enums.E_ATTACHMENT_TYPE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(ATTACHMENT, LAYOUT, TYPE);
  }

  interface Builder extends IFeaturedObject.Builder<AttachmentRef> {
    Builder attachment(Supplier<Attachment> attachment);
    Builder layout(EImageLayout layout);
    Builder type(EAttachmentType type);
  }
}
