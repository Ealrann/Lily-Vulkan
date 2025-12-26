package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.function.Supplier;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.Relation;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferDescriptorBuilder;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;

public interface BufferDescriptor extends IDescriptor {
  static Builder builder() {
    return new BufferDescriptorBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  IBuffer buffer();
  void buffer(final IBuffer buffer);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int TYPE = IDescriptor.FeatureIDs.TYPE;
    int SHADER_STAGES = IDescriptor.FeatureIDs.SHADER_STAGES;
    int BUFFER = -1797524544;
  }

  interface Features<T extends Features<T>> extends IDescriptor.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EDescriptorType, EDescriptorType, Listener<EDescriptorType>, IDescriptor.Features<?>> TYPE = IDescriptor.Features.TYPE;
    Attribute<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, IDescriptor.Features<?>> SHADER_STAGES = IDescriptor.Features.SHADER_STAGES;
    Relation<IBuffer, IBuffer, Listener<IBuffer>, Features<?>> BUFFER = new RelationBuilder<IBuffer, IBuffer, Listener<IBuffer>, Features<?>>().name("buffer").mandatory(true).id(BufferDescriptor.FeatureIDs.BUFFER).concept(() -> VulkanResourceModelDefinition.Groups.I_BUFFER).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, TYPE, SHADER_STAGES, BUFFER);
  }

  interface Builder extends IFeaturedObject.Builder<BufferDescriptor> {
    Builder name(String name);
    Builder type(EDescriptorType type);
    Builder addShaderStage(EShaderStage shaderStage);
    Builder buffer(Supplier<IBuffer> buffer);
    Builder addShaderStages(List<EShaderStage> shaderStages);
  }
}
