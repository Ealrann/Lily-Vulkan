package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import java.util.function.Supplier;
import org.joml.Vector4fc;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.builder.ImageAttachmentBuilder;
import org.sheepy.lily.vulkan.model.vulkan.VulkanEngine;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public interface ImageAttachment extends ExtraAttachment {
  static Builder builder() {
    return new ImageAttachmentBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Vector4fc clearValue();
  VulkanEngine imageRef();
  void clearValue(final Vector4fc clearValue);
  void imageRef(final VulkanEngine imageRef);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SAMPLES = Attachment.FeatureIDs.SAMPLES;
    int LOAD_OP = Attachment.FeatureIDs.LOAD_OP;
    int STORE_OP = Attachment.FeatureIDs.STORE_OP;
    int STENCIL_LOAD_OP = Attachment.FeatureIDs.STENCIL_LOAD_OP;
    int STENCIL_STORE_OP = Attachment.FeatureIDs.STENCIL_STORE_OP;
    int INITIAL_LAYOUT = Attachment.FeatureIDs.INITIAL_LAYOUT;
    int FINAL_LAYOUT = Attachment.FeatureIDs.FINAL_LAYOUT;
    int CLEAR_VALUE = -652490809;
    int IMAGE_REF = 838801051;
  }

  interface Features<T extends Features<T>> extends ExtraAttachment.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<ESampleCount, ESampleCount, Listener<ESampleCount>, Attachment.Features<?>> SAMPLES = Attachment.Features.SAMPLES;
    Attribute<EAttachmentLoadOp, EAttachmentLoadOp, Listener<EAttachmentLoadOp>, Attachment.Features<?>> LOAD_OP = Attachment.Features.LOAD_OP;
    Attribute<EAttachmentStoreOp, EAttachmentStoreOp, Listener<EAttachmentStoreOp>, Attachment.Features<?>> STORE_OP = Attachment.Features.STORE_OP;
    Attribute<EAttachmentLoadOp, EAttachmentLoadOp, Listener<EAttachmentLoadOp>, Attachment.Features<?>> STENCIL_LOAD_OP = Attachment.Features.STENCIL_LOAD_OP;
    Attribute<EAttachmentStoreOp, EAttachmentStoreOp, Listener<EAttachmentStoreOp>, Attachment.Features<?>> STENCIL_STORE_OP = Attachment.Features.STENCIL_STORE_OP;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Attachment.Features<?>> INITIAL_LAYOUT = Attachment.Features.INITIAL_LAYOUT;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Attachment.Features<?>> FINAL_LAYOUT = Attachment.Features.FINAL_LAYOUT;
    Attribute<Vector4fc, Vector4fc, Listener<Vector4fc>, Features<?>> CLEAR_VALUE = new AttributeBuilder<Vector4fc, Vector4fc, Listener<Vector4fc>, Features<?>>().name("clearValue").defaultValue("0;0;0;0").id(ImageAttachment.FeatureIDs.CLEAR_VALUE).datatype(() -> TypesModelDefinition.JavaWrappers.COLOR4F).build();
    Relation<VulkanEngine, VulkanEngine, Listener<VulkanEngine>, Features<?>> IMAGE_REF = new RelationBuilder<VulkanEngine, VulkanEngine, Listener<VulkanEngine>, Features<?>>().name("imageRef").id(ImageAttachment.FeatureIDs.IMAGE_REF).concept(() -> VulkanModelDefinition.Groups.VULKAN_ENGINE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SAMPLES, LOAD_OP, STORE_OP, STENCIL_LOAD_OP, STENCIL_STORE_OP, INITIAL_LAYOUT, FINAL_LAYOUT, CLEAR_VALUE, IMAGE_REF);
  }

  interface Builder extends IFeaturedObject.Builder<ImageAttachment> {
    Builder name(String name);
    Builder samples(ESampleCount samples);
    Builder loadOp(EAttachmentLoadOp loadOp);
    Builder storeOp(EAttachmentStoreOp storeOp);
    Builder stencilLoadOp(EAttachmentLoadOp stencilLoadOp);
    Builder stencilStoreOp(EAttachmentStoreOp stencilStoreOp);
    Builder initialLayout(EImageLayout initialLayout);
    Builder finalLayout(EImageLayout finalLayout);
    Builder clearValue(Vector4fc clearValue);
    Builder imageRef(Supplier<VulkanEngine> imageRef);
  }
}
