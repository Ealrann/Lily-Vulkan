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
import org.logoce.lmf.core.lang.builder.AttributeBuilder;
import org.logoce.lmf.core.lang.builder.RelationBuilder;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ImageDescriptorBuilder;
import org.sheepy.vulkan.model.enumeration.EDescriptorType;
import org.sheepy.vulkan.model.enumeration.EImageLayout;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;

public interface ImageDescriptor extends IDescriptor {
  static Builder builder() {
    return new ImageDescriptorBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  List<IVulkanImage> images();
  Sampler sampler();
  EImageLayout layout();
  void sampler(final Sampler sampler);
  void layout(final EImageLayout layout);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int TYPE = IDescriptor.FeatureIDs.TYPE;
    int SHADER_STAGES = IDescriptor.FeatureIDs.SHADER_STAGES;
    int IMAGES = -1347860301;
    int SAMPLER = 1118912813;
    int LAYOUT = -1272331931;
  }

  interface Features<T extends Features<T>> extends IDescriptor.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Attribute<EDescriptorType, EDescriptorType, Listener<EDescriptorType>, IDescriptor.Features<?>> TYPE = IDescriptor.Features.TYPE;
    Attribute<EShaderStage, List<EShaderStage>, Listener<List<EShaderStage>>, IDescriptor.Features<?>> SHADER_STAGES = IDescriptor.Features.SHADER_STAGES;
    Relation<IVulkanImage, List<IVulkanImage>, Listener<List<IVulkanImage>>, Features<?>> IMAGES = new RelationBuilder<IVulkanImage, List<IVulkanImage>, Listener<List<IVulkanImage>>, Features<?>>().name("images").many(true).id(ImageDescriptor.FeatureIDs.IMAGES).concept(() -> VulkanResourceModelDefinition.Groups.I_VULKAN_IMAGE).build();
    Relation<Sampler, Sampler, Listener<Sampler>, Features<?>> SAMPLER = new RelationBuilder<Sampler, Sampler, Listener<Sampler>, Features<?>>().name("sampler").id(ImageDescriptor.FeatureIDs.SAMPLER).concept(() -> VulkanResourceModelDefinition.Groups.SAMPLER).build();
    Attribute<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>> LAYOUT = new AttributeBuilder<EImageLayout, EImageLayout, Listener<EImageLayout>, Features<?>>().name("layout").defaultValue("GENERAL").id(ImageDescriptor.FeatureIDs.LAYOUT).datatype(() -> EnumerationModelDefinition.Enums.E_IMAGE_LAYOUT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, TYPE, SHADER_STAGES, IMAGES, SAMPLER, LAYOUT);
  }

  interface Builder extends IFeaturedObject.Builder<ImageDescriptor> {
    Builder name(String name);
    Builder type(EDescriptorType type);
    Builder addShaderStage(EShaderStage shaderStage);
    Builder addImage(Supplier<IVulkanImage> image);
    Builder sampler(Supplier<Sampler> sampler);
    Builder layout(EImageLayout layout);
    Builder addImages(List<IVulkanImage> images);
    Builder addShaderStages(List<EShaderStage> shaderStages);
  }
}
