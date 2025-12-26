package org.sheepy.lily.vulkan.extra.model.rendering;

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
import org.sheepy.lily.vulkan.extra.model.rendering.builder.DataDescriptorBuilder;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface DataDescriptor extends LMObject {
  static Builder builder() {
    return new DataDescriptorBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  int part();
  int instance();
  EDescriptorType descriptorType();
  List<EShaderStage> stages();
  void part(final int part);
  void instance(final int instance);
  void descriptorType(final EDescriptorType descriptorType);

  interface FeatureIDs {
    int PART = 1504868978;
    int INSTANCE = -929606764;
    int DESCRIPTOR_TYPE = -1109996792;
    int STAGES = -1121972236;
  }

  interface Features<T extends Features<T>> extends LMObject.Features<T> {
    Attribute<Integer, Integer, IntListener, Features<?>> PART = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("part").mandatory(true).id(DataDescriptor.FeatureIDs.PART).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<Integer, Integer, IntListener, Features<?>> INSTANCE = new AttributeBuilder<Integer, Integer, IntListener, Features<?>>().name("instance").mandatory(true).id(DataDescriptor.FeatureIDs.INSTANCE).datatype(() -> LMCoreModelDefinition.Units.INT).build();
    Attribute<EDescriptorType, EDescriptorType, Listener<EDescriptorType>, Features<?>> DESCRIPTOR_TYPE = new AttributeBuilder<EDescriptorType, EDescriptorType, Listener<EDescriptorType>, Features<?>>().name("descriptorType").mandatory(true).id(DataDescriptor.FeatureIDs.DESCRIPTOR_TYPE).datatype(() -> EnumerationModelDefinition.Enums.E_DESCRIPTOR_TYPE).build();
    Attribute<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, Features<?>> STAGES = new AttributeBuilder<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, Features<?>>().name("stages").many(true).mandatory(true).id(DataDescriptor.FeatureIDs.STAGES).datatype(() -> EnumerationModelDefinition.Enums.E_SHADER_STAGE).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(PART, INSTANCE, DESCRIPTOR_TYPE, STAGES);
  }

  interface Builder extends IFeaturedObject.Builder<DataDescriptor> {
    Builder part(int part);
    Builder instance(int instance);
    Builder descriptorType(EDescriptorType descriptorType);
    Builder addStage(EShaderStage stage);
    Builder addStages(List<EShaderStage> stages);
  }
}
