package org.sheepy.vulkan.model.barrier;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface Barrier extends LNamedElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<EAccess> srcAccessMask();
  List<EAccess> dstAccessMask();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int SRC_ACCESS_MASK = -76428736;
    int DST_ACCESS_MASK = -324670239;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>> SRC_ACCESS_MASK = new AttributeBuilder<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>>().name("srcAccessMask").many(true).id(Barrier.FeatureIDs.SRC_ACCESS_MASK).datatype(() -> EnumerationModelDefinition.Enums.E_ACCESS).build();
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>> DST_ACCESS_MASK = new AttributeBuilder<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>>().name("dstAccessMask").many(true).id(Barrier.FeatureIDs.DST_ACCESS_MASK).datatype(() -> EnumerationModelDefinition.Enums.E_ACCESS).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, SRC_ACCESS_MASK, DST_ACCESS_MASK);
  }
}
