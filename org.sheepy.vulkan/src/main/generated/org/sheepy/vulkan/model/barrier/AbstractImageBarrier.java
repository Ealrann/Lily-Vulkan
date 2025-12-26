package org.sheepy.vulkan.model.barrier;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface AbstractImageBarrier extends Barrier {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EImageLayout srcLayout();
  EImageLayout dstLayout();
  void srcLayout(final EImageLayout srcLayout);
  void dstLayout(final EImageLayout dstLayout);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SRC_ACCESS_MASK = Barrier.FeatureIDs.SRC_ACCESS_MASK;
    int DST_ACCESS_MASK = Barrier.FeatureIDs.DST_ACCESS_MASK;
    int SRC_LAYOUT = 1882698851;
    int DST_LAYOUT = -1419751548;
  }

  interface Features<T extends Features<T>> extends Barrier.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Barrier.Features<?>> SRC_ACCESS_MASK = Barrier.Features.SRC_ACCESS_MASK;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Barrier.Features<?>> DST_ACCESS_MASK = Barrier.Features.DST_ACCESS_MASK;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> SRC_LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("srcLayout").id(AbstractImageBarrier.FeatureIDs.SRC_LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> DST_LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("dstLayout").id(AbstractImageBarrier.FeatureIDs.DST_LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SRC_ACCESS_MASK, DST_ACCESS_MASK, SRC_LAYOUT, DST_LAYOUT);
  }
}
