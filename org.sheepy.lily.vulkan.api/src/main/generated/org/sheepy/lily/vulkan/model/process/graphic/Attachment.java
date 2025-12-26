package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.vulkan.model.vulkanresource.IVulkanImage;
import org.sheepy.vulkan.model.enumeration.EAttachmentLoadOp;
import org.sheepy.vulkan.model.enumeration.EAttachmentStoreOp;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.ESampleCount;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface Attachment extends LNamedElement, IVulkanImage {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ESampleCount samples();
  EAttachmentLoadOp loadOp();
  EAttachmentStoreOp storeOp();
  EAttachmentLoadOp stencilLoadOp();
  EAttachmentStoreOp stencilStoreOp();
  EImageLayout initialLayout();
  EImageLayout finalLayout();
  void samples(final ESampleCount samples);
  void loadOp(final EAttachmentLoadOp loadOp);
  void storeOp(final EAttachmentStoreOp storeOp);
  void stencilLoadOp(final EAttachmentLoadOp stencilLoadOp);
  void stencilStoreOp(final EAttachmentStoreOp stencilStoreOp);
  void initialLayout(final EImageLayout initialLayout);
  void finalLayout(final EImageLayout finalLayout);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SAMPLES = -1979343815;
    int LOAD_OP = 2103610167;
    int STORE_OP = -1433490734;
    int STENCIL_LOAD_OP = -958012813;
    int STENCIL_STORE_OP = -1854522602;
    int INITIAL_LAYOUT = -1900006466;
    int FINAL_LAYOUT = -28443536;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T>, IVulkanImage.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<ESampleCount, ESampleCount, Listener<ESampleCount>, Features<?>> SAMPLES = new AttributeBuilder<ESampleCount, ESampleCount, Listener<ESampleCount>, Features<?>>().name("samples").id(Attachment.FeatureIDs.SAMPLES).datatype(() -> EnumerationModelDefinition.Enums.E_SAMPLE_COUNT).build();
    Attribute<EAttachmentLoadOp, EAttachmentLoadOp, Listener<EAttachmentLoadOp>, Features<?>> LOAD_OP = new AttributeBuilder<EAttachmentLoadOp, EAttachmentLoadOp, Listener<EAttachmentLoadOp>, Features<?>>().name("loadOp").id(Attachment.FeatureIDs.LOAD_OP).datatype(() -> EnumerationModelDefinition.Enums.E_ATTACHMENT_LOAD_OP).build();
    Attribute<EAttachmentStoreOp, EAttachmentStoreOp, Listener<EAttachmentStoreOp>, Features<?>> STORE_OP = new AttributeBuilder<EAttachmentStoreOp, EAttachmentStoreOp, Listener<EAttachmentStoreOp>, Features<?>>().name("storeOp").id(Attachment.FeatureIDs.STORE_OP).datatype(() -> EnumerationModelDefinition.Enums.E_ATTACHMENT_STORE_OP).build();
    Attribute<EAttachmentLoadOp, EAttachmentLoadOp, Listener<EAttachmentLoadOp>, Features<?>> STENCIL_LOAD_OP = new AttributeBuilder<EAttachmentLoadOp, EAttachmentLoadOp, Listener<EAttachmentLoadOp>, Features<?>>().name("stencilLoadOp").id(Attachment.FeatureIDs.STENCIL_LOAD_OP).datatype(() -> EnumerationModelDefinition.Enums.E_ATTACHMENT_LOAD_OP).build();
    Attribute<EAttachmentStoreOp, EAttachmentStoreOp, Listener<EAttachmentStoreOp>, Features<?>> STENCIL_STORE_OP = new AttributeBuilder<EAttachmentStoreOp, EAttachmentStoreOp, Listener<EAttachmentStoreOp>, Features<?>>().name("stencilStoreOp").id(Attachment.FeatureIDs.STENCIL_STORE_OP).datatype(() -> EnumerationModelDefinition.Enums.E_ATTACHMENT_STORE_OP).build();
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> INITIAL_LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("initialLayout").id(Attachment.FeatureIDs.INITIAL_LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> FINAL_LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("finalLayout").id(Attachment.FeatureIDs.FINAL_LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SAMPLES, LOAD_OP, STORE_OP, STENCIL_LOAD_OP, STENCIL_STORE_OP, INITIAL_LAYOUT, FINAL_LAYOUT);
  }
}
