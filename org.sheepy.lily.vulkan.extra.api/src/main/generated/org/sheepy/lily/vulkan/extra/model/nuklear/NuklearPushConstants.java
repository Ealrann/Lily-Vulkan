package org.sheepy.lily.vulkan.extra.model.nuklear;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.vulkan.extra.model.nuklear.builder.NuklearPushConstantsBuilder;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;
import org.sheepy.lily.vulkan.model.process.PushConstant;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public interface NuklearPushConstants extends PushConstant {
  static Builder builder() {
    return new NuklearPushConstantsBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int width();
  int height();
  int currentDescriptor();
  void width(final int width);
  void height(final int height);
  void currentDescriptor(final int currentDescriptor);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int STAGES = PushConstant.FeatureIDs.STAGES;
    int WIDTH = 2034888403;
    int HEIGHT = -1775963718;
    int CURRENT_DESCRIPTOR = -364101803;
  }

  interface Features<T extends Features<T>> extends PushConstant.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, PushConstant.Features<?>> STAGES = PushConstant.Features.STAGES;
    Attribute<Integer, Integer, IntListener, Features<?>> WIDTH = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("width").id(NuklearPushConstants.FeatureIDs.WIDTH).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> HEIGHT = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("height").id(NuklearPushConstants.FeatureIDs.HEIGHT).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> CURRENT_DESCRIPTOR = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("currentDescriptor").id(NuklearPushConstants.FeatureIDs.CURRENT_DESCRIPTOR).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, STAGES, WIDTH, HEIGHT, CURRENT_DESCRIPTOR);
  }

  interface Builder extends IFeaturedObject.Builder<NuklearPushConstants> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder addStage(EShaderStage stage);
    Builder width(int width);
    Builder height(int height);
    Builder currentDescriptor(int currentDescriptor);
    Builder addStages(List<EShaderStage> stages);
  }
}
