package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;

public interface ICommandBuffer extends LMObject {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int index();
  void index(final int index);

  interface FeatureIDs {
    int INDEX = -1768405925;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> INDEX = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("index").mandatory(true).id(ICommandBuffer.FeatureIDs.INDEX).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(INDEX);
  }
}
