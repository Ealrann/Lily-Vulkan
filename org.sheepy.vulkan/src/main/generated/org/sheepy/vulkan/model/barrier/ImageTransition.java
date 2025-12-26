package org.sheepy.vulkan.model.barrier;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.barrier.builder.ImageTransitionBuilder;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface ImageTransition extends LMObject {
  static Builder builder() {
    return new ImageTransitionBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EImageLayout srcLayout();
  EImageLayout dstLayout();
  List<EAccess> srcAccessMask();
  List<EAccess> dstAccessMask();
  void srcLayout(final EImageLayout srcLayout);
  void dstLayout(final EImageLayout dstLayout);

  interface FeatureIDs {
    int SRC_LAYOUT = 1905561107;
    int DST_LAYOUT = -1396889292;
    int SRC_ACCESS_MASK = 22992089;
    int DST_ACCESS_MASK = -225249414;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> SRC_LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("srcLayout").id(ImageTransition.FeatureIDs.SRC_LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> DST_LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("dstLayout").id(ImageTransition.FeatureIDs.DST_LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>> SRC_ACCESS_MASK = new AttributeBuilder<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>>().name("srcAccessMask").many(true).id(ImageTransition.FeatureIDs.SRC_ACCESS_MASK).datatype(() -> EnumerationModelDefinition.Enums.E_ACCESS).build();
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>> DST_ACCESS_MASK = new AttributeBuilder<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>>().name("dstAccessMask").many(true).id(ImageTransition.FeatureIDs.DST_ACCESS_MASK).datatype(() -> EnumerationModelDefinition.Enums.E_ACCESS).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(SRC_LAYOUT, DST_LAYOUT, SRC_ACCESS_MASK, DST_ACCESS_MASK);
  }

  interface Builder extends IFeaturedObject.Builder<ImageTransition> {
    Builder srcLayout(EImageLayout srcLayout);
    Builder dstLayout(EImageLayout dstLayout);
    Builder addSrcAccessMask(EAccess srcAccessMask);
    Builder addDstAccessMask(EAccess dstAccessMask);
    Builder addSrcAccessMask(List<EAccess> srcAccessMask);
    Builder addDstAccessMask(List<EAccess> dstAccessMask);
  }
}
