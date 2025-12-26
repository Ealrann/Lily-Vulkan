package org.sheepy.lily.vulkan.model.process.graphic;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.model.process.ICommandBuffer;
import org.sheepy.lily.vulkan.model.process.graphic.builder.GraphicCommandBufferBuilder;

public interface GraphicCommandBuffer extends ICommandBuffer {
  static Builder builder() {
    return new GraphicCommandBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int imageID();
  void imageID(final int imageID);

  interface FeatureIDs {
    int INDEX = ICommandBuffer.FeatureIDs.INDEX;
    int IMAGEID = -632225946;
  }

  interface Features<T extends Features<T>> extends ICommandBuffer.Features<T> {
    Attribute<Integer, Integer, IntListener, ICommandBuffer.Features<?>> INDEX = ICommandBuffer.Features.INDEX;
    Attribute<Integer, Integer, IntListener, Features<?>> IMAGEID = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("imageID").mandatory(true).id(GraphicCommandBuffer.FeatureIDs.IMAGEID).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(INDEX, IMAGEID);
  }

  interface Builder extends IFeaturedObject.Builder<GraphicCommandBuffer> {
    Builder index(int index);
    Builder imageID(int imageID);
  }
}
