package org.sheepy.vulkan.model.graphicpipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EDynamicState;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.graphicpipeline.builder.DynamicStateBuilder;

public interface DynamicState extends LMObject {
  static Builder builder() {
    return new DynamicStateBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<EDynamicState> states();

  interface FeatureIDs {
    int STATES = -634930068;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EDynamicState, List<EDynamicState>, Listener<List<EDynamicState>>, Features<?>> STATES = new AttributeBuilder<EDynamicState, List<EDynamicState>, Listener<List<EDynamicState>>, Features<?>>().name("states").many(true).id(DynamicState.FeatureIDs.STATES).datatype(() -> EnumerationModelDefinition.Enums.E_DYNAMIC_STATE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(STATES);
  }

  interface Builder extends IFeaturedObject.Builder<DynamicState> {
    Builder addState(EDynamicState state);
    Builder addStates(List<EDynamicState> states);
  }
}
