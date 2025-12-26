package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.joml.Vector4fc;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SwapImageAttachmentBuilder;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;

public interface SwapImageAttachment extends Attachment {
  static Builder builder() {
    return new SwapImageAttachmentBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  Vector4fc clearValue();
  void clearValue(final Vector4fc clearValue);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SAMPLES = Attachment.FeatureIDs.SAMPLES;
    int LOAD_OP = Attachment.FeatureIDs.LOAD_OP;
    int STORE_OP = Attachment.FeatureIDs.STORE_OP;
    int STENCIL_LOAD_OP = Attachment.FeatureIDs.STENCIL_LOAD_OP;
    int STENCIL_STORE_OP = Attachment.FeatureIDs.STENCIL_STORE_OP;
    int INITIAL_LAYOUT = Attachment.FeatureIDs.INITIAL_LAYOUT;
    int FINAL_LAYOUT = Attachment.FeatureIDs.FINAL_LAYOUT;
    int CLEAR_VALUE = 1619343418;
  }

  interface Features<T extends Features<T>> extends Attachment.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<ESampleCount, ESampleCount, Listener<ESampleCount>, Attachment.Features<?>> SAMPLES = Attachment.Features.SAMPLES;
    Attribute<EAttachmentLoadOp, EAttachmentLoadOp, Listener<EAttachmentLoadOp>, Attachment.Features<?>> LOAD_OP = Attachment.Features.LOAD_OP;
    Attribute<EAttachmentStoreOp, EAttachmentStoreOp, Listener<EAttachmentStoreOp>, Attachment.Features<?>> STORE_OP = Attachment.Features.STORE_OP;
    Attribute<EAttachmentLoadOp, EAttachmentLoadOp, Listener<EAttachmentLoadOp>, Attachment.Features<?>> STENCIL_LOAD_OP = Attachment.Features.STENCIL_LOAD_OP;
    Attribute<EAttachmentStoreOp, EAttachmentStoreOp, Listener<EAttachmentStoreOp>, Attachment.Features<?>> STENCIL_STORE_OP = Attachment.Features.STENCIL_STORE_OP;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Attachment.Features<?>> INITIAL_LAYOUT = Attachment.Features.INITIAL_LAYOUT;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Attachment.Features<?>> FINAL_LAYOUT = Attachment.Features.FINAL_LAYOUT;
    Attribute<Vector4fc, Vector4fc, Listener<Vector4fc>, Features<?>> CLEAR_VALUE = new AttributeBuilder<Vector4fc, Vector4fc, Listener<Vector4fc>, Features<?>>().name("clearValue").defaultValue("0;0;0;0").id(SwapImageAttachment.FeatureIDs.CLEAR_VALUE).datatype(() -> TypesModelDefinition.JavaWrappers.COLOR4F).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SAMPLES, LOAD_OP, STORE_OP, STENCIL_LOAD_OP, STENCIL_STORE_OP, INITIAL_LAYOUT, FINAL_LAYOUT, CLEAR_VALUE);
  }

  interface Builder extends IFeaturedObject.Builder<SwapImageAttachment> {
    Builder name(String name);
    Builder samples(ESampleCount samples);
    Builder loadOp(EAttachmentLoadOp loadOp);
    Builder storeOp(EAttachmentStoreOp storeOp);
    Builder stencilLoadOp(EAttachmentLoadOp stencilLoadOp);
    Builder stencilStoreOp(EAttachmentStoreOp stencilStoreOp);
    Builder initialLayout(EImageLayout initialLayout);
    Builder finalLayout(EImageLayout finalLayout);
    Builder clearValue(Vector4fc clearValue);
  }
}
