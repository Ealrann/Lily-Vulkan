package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface PushConstant extends IPipelineTask {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<EShaderStage> stages();

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int STAGES = -1354371152;
  }

  interface Features<T extends Features<T>> extends IPipelineTask.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, Features<?>> STAGES = new AttributeBuilder<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, Features<?>>().name("stages").many(true).mandatory(true).id(PushConstant.FeatureIDs.STAGES).datatype(() -> EnumerationModelDefinition.Enums.E_SHADER_STAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, STAGES);
  }
}
