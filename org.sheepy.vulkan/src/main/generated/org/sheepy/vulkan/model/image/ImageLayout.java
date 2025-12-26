package org.sheepy.vulkan.model.image;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.image.builder.ImageLayoutBuilder;

public interface ImageLayout extends LMObject {
  static Builder builder() {
    return new ImageLayoutBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EPipelineStage stage();
  EImageLayout layout();
  List<EAccess> accessMask();
  void stage(final EPipelineStage stage);
  void layout(final EImageLayout layout);

  interface FeatureIDs {
    int STAGE = 888580508;
    int LAYOUT = 1558964300;
    int ACCESS_MASK = 1620863634;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>> STAGE = new AttributeBuilder<EPipelineStage, EPipelineStage, Listener<EPipelineStage>, Features<?>>().name("stage").id(ImageLayout.FeatureIDs.STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_PIPELINE_STAGE).build();
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("layout").defaultValue("SHADER_READ_ONLY_OPTIMAL").id(ImageLayout.FeatureIDs.LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    Attribute<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>> ACCESS_MASK = new AttributeBuilder<EAccess, List<EAccess>, Listener<List<EAccess>>, Features<?>>().name("accessMask").many(true).id(ImageLayout.FeatureIDs.ACCESS_MASK).datatype(() -> EnumerationModelDefinition.Enums.E_ACCESS).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(STAGE, LAYOUT, ACCESS_MASK);
  }

  interface Builder extends IFeaturedObject.Builder<ImageLayout> {
    Builder stage(EPipelineStage stage);
    Builder layout(EImageLayout layout);
    Builder addAccessMask(EAccess accessMask);
    Builder addAccessMask(List<EAccess> accessMask);
  }
}
