package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.sheepy.lily.vulkan.model.process.graphic.builder.SwapImageBarrierBuilder;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.Barrier;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;

public interface SwapImageBarrier extends AbstractImageBarrier {
  static Builder builder() {
    return new SwapImageBarrierBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SRC_ACCESS_MASK = Barrier.FeatureIDs.SRC_ACCESS_MASK;
    int DST_ACCESS_MASK = Barrier.FeatureIDs.DST_ACCESS_MASK;
    int SRC_LAYOUT = AbstractImageBarrier.FeatureIDs.SRC_LAYOUT;
    int DST_LAYOUT = AbstractImageBarrier.FeatureIDs.DST_LAYOUT;
  }

  interface Features<T extends Features<T>> extends AbstractImageBarrier.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Barrier.Features<?>> SRC_ACCESS_MASK = Barrier.Features.SRC_ACCESS_MASK;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Barrier.Features<?>> DST_ACCESS_MASK = Barrier.Features.DST_ACCESS_MASK;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, AbstractImageBarrier.Features<?>> SRC_LAYOUT = AbstractImageBarrier.Features.SRC_LAYOUT;
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, AbstractImageBarrier.Features<?>> DST_LAYOUT = AbstractImageBarrier.Features.DST_LAYOUT;
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SRC_ACCESS_MASK, DST_ACCESS_MASK, SRC_LAYOUT, DST_LAYOUT);
  }

  interface Builder extends IFeaturedObject.Builder<SwapImageBarrier> {
    Builder name(String name);
    Builder addSrcAccessMask(EAccess srcAccessMask);
    Builder addDstAccessMask(EAccess dstAccessMask);
    Builder srcLayout(EImageLayout srcLayout);
    Builder dstLayout(EImageLayout dstLayout);
    Builder addSrcAccessMask(List<EAccess> srcAccessMask);
    Builder addDstAccessMask(List<EAccess> dstAccessMask);
  }
}
