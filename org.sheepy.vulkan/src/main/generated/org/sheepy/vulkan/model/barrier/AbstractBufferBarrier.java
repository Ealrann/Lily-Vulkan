package org.sheepy.vulkan.model.barrier;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.sheepy.vulkan.model.enumeration.EAccess;

public interface AbstractBufferBarrier extends Barrier {
  @Override
  IModelNotifier<? extends Features<?>> notifier();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SRC_ACCESS_MASK = Barrier.FeatureIDs.SRC_ACCESS_MASK;
    int DST_ACCESS_MASK = Barrier.FeatureIDs.DST_ACCESS_MASK;
  }

  interface Features<T extends Features<T>> extends Barrier.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Barrier.Features<?>> SRC_ACCESS_MASK = Barrier.Features.SRC_ACCESS_MASK;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Barrier.Features<?>> DST_ACCESS_MASK = Barrier.Features.DST_ACCESS_MASK;
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SRC_ACCESS_MASK, DST_ACCESS_MASK);
  }
}
