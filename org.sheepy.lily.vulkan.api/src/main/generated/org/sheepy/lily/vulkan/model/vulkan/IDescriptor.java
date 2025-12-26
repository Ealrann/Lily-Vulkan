package org.sheepy.lily.vulkan.model.vulkan;

import java.util.List;
import org.logoce.lmf.core.api.model.IModelNotifier;
import org.logoce.lmf.core.api.notification.listener.Listener;
import org.logoce.lmf.core.lang.Attribute;
import org.logoce.lmf.core.lang.Feature;
import org.logoce.lmf.core.lang.Named;
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface IDescriptor extends LNamedElement {
  @Override
  IModelNotifier<? extends Features<?>> notifier();
  EDescriptorType type();
  List<EShaderStage> shaderStages();
  void type(final EDescriptorType type);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int TYPE = -1018177963;
    int SHADER_STAGES = -1024541291;
  }

  interface Features<T extends Features<T>> extends LNamedElement.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EDescriptorType, EDescriptorType, Listener<EDescriptorType>, Features<?>> TYPE = new AttributeBuilder<EDescriptorType, EDescriptorType, Listener<EDescriptorType>, Features<?>>().name("type").mandatory(true).id(IDescriptor.FeatureIDs.TYPE).datatype(() -> EnumerationModelDefinition.Enums.E_DESCRIPTOR_TYPE).build();
    Attribute<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, Features<?>> SHADER_STAGES = new AttributeBuilder<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, Features<?>>().name("shaderStages").many(true).mandatory(true).id(IDescriptor.FeatureIDs.SHADER_STAGES).datatype(() -> EnumerationModelDefinition.Enums.E_SHADER_STAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, TYPE, SHADER_STAGES);
  }
}
