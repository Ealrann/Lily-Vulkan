package org.sheepy.lily.vulkan.model.process;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.BooleanListener;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.process.builder.PushConstantBufferBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.ConstantBuffer;
import org.sheepy.lily.vulkan.model.vulkanresource.VulkanResourceModelDefinition;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public interface PushConstantBuffer extends PushConstant {
  static Builder builder() {
    return new PushConstantBufferBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  ConstantBuffer buffer();
  void buffer(final ConstantBuffer buffer);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int ENABLED = IPipelineTask.FeatureIDs.ENABLED;
    int STAGES = PushConstant.FeatureIDs.STAGES;
    int BUFFER = -536402533;
  }

  interface Features<T extends Features<T>> extends PushConstant.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<Boolean, Boolean, BooleanListener, IPipelineTask.Features<?>> ENABLED = IPipelineTask.Features.ENABLED;
    Attribute<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, PushConstant.Features<?>> STAGES = PushConstant.Features.STAGES;
    Relation<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, Features<?>> BUFFER = new RelationBuilder<ConstantBuffer, ConstantBuffer, Listener<ConstantBuffer>, Features<?>>().name("buffer").mandatory(true).id(PushConstantBuffer.FeatureIDs.BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.CONSTANT_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, ENABLED, STAGES, BUFFER);
  }

  interface Builder extends IFeaturedObject.Builder<PushConstantBuffer> {
    Builder name(String name);
    Builder enabled(boolean enabled);
    Builder addStage(EShaderStage stage);
    Builder buffer(Supplier<ConstantBuffer> buffer);
    Builder addStages(List<EShaderStage> stages);
  }
}
