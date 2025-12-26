package org.sheepy.vulkan.model.pipeline;

import java.util.List;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.IntListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.pipeline.builder.PushConstantRangeBuilder;

public interface PushConstantRange extends LMObject {
  static Builder builder() {
    return new PushConstantRangeBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<EShaderStage> stages();
  int offset();
  int size();
  void offset(final int offset);
  void size(final int size);

  interface FeatureIDs {
    int STAGES = -1929157638;
    int OFFSET = -2056443048;
    int SIZE = 2085131270;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, Features<?>> STAGES = new AttributeBuilder<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, Features<?>>().name("stages").many(true).mandatory(true).id(PushConstantRange.FeatureIDs.STAGES).datatype(() -> EnumerationModelDefinition.Enums.E_SHADER_STAGE).build();
    Attribute<Integer, Integer, IntListener, Features<?>> OFFSET = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("offset").defaultValue("0").id(PushConstantRange.FeatureIDs.OFFSET).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> SIZE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("size").id(PushConstantRange.FeatureIDs.SIZE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(STAGES, OFFSET, SIZE);
  }

  interface Builder extends IFeaturedObject.Builder<PushConstantRange> {
    Builder addStage(EShaderStage stage);
    Builder offset(int offset);
    Builder size(int size);
    Builder addStages(List<EShaderStage> stages);
  }
}
