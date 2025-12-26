package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.model.process.graphic.builder.DepthAttachmentBuilder;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EImageUsage;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface DepthAttachment extends ExtraAttachment {
  static Builder builder() {
    return new DepthAttachmentBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  boolean clear();
  List<EImageUsage> usages();
  void clear(final boolean clear);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SAMPLES = Attachment.FeatureIDs.SAMPLES;
    int LOAD_OP = Attachment.FeatureIDs.LOAD_OP;
    int STORE_OP = Attachment.FeatureIDs.STORE_OP;
    int STENCIL_LOAD_OP = Attachment.FeatureIDs.STENCIL_LOAD_OP;
    int STENCIL_STORE_OP = Attachment.FeatureIDs.STENCIL_STORE_OP;
    int INITIAL_LAYOUT = Attachment.FeatureIDs.INITIAL_LAYOUT;
    int FINAL_LAYOUT = Attachment.FeatureIDs.FINAL_LAYOUT;
    int CLEAR = 1014462770;
    int USAGES = 1905250477;
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
    Attribute<Boolean, Boolean, BooleanListener, Features<?>> CLEAR = new AttributeBuilder<Boolean, Boolean, BooleanListener, Features<?>>().name("clear").defaultValue("true").id(DepthAttachment.FeatureIDs.CLEAR).datatype(() -> LMCoreModelDefinition.Units.BOOLEAN).build();
    Attribute<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, Features<?>> USAGES = new AttributeBuilder<EImageUsage, List<EImageUsage>, Listener<List<EImageUsage>>, Features<?>>().name("usages").many(true).id(DepthAttachment.FeatureIDs.USAGES).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_USAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SAMPLES, LOAD_OP, STORE_OP, STENCIL_LOAD_OP, STENCIL_STORE_OP, INITIAL_LAYOUT, FINAL_LAYOUT, CLEAR, USAGES);
  }

  interface Builder extends IFeaturedObject.Builder<DepthAttachment> {
    Builder name(String name);
    Builder samples(ESampleCount samples);
    Builder loadOp(EAttachmentLoadOp loadOp);
    Builder storeOp(EAttachmentStoreOp storeOp);
    Builder stencilLoadOp(EAttachmentLoadOp stencilLoadOp);
    Builder stencilStoreOp(EAttachmentStoreOp stencilStoreOp);
    Builder initialLayout(EImageLayout initialLayout);
    Builder finalLayout(EImageLayout finalLayout);
    Builder clear(boolean clear);
    Builder addUsage(EImageUsage usage);
    Builder addUsages(List<EImageUsage> usages);
  }
}
