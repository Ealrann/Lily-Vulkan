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
import org.sheepy.lily.core.model.resource.FileResource;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ShaderBuilder;
import org.sheepy.vulkan.model.enumeration.EShaderStage;
import org.sheepy.vulkan.model.enumeration.EnumerationModelDefinition;
import org.sheepy.vulkan.model.pipeline.PipelineModelDefinition;
import org.sheepy.vulkan.model.pipeline.SpecializationConstant;

public interface Shader extends IVulkanResource {
  static Builder builder() {
    return new ShaderBuilder();
  }

  @Override
  IModelNotifier<? extends Features<?>> notifier();
  FileResource file();
  EShaderStage stage();
  List<SpecializationConstant> constants();
  void file(final FileResource file);
  void stage(final EShaderStage stage);

  interface FeatureIDs {
    int NAME = Named.FeatureIDs.NAME;
    int FILE = -1225343770;
    int STAGE = 681371860;
    int CONSTANTS = -988554203;
  }

  interface Features<T extends Features<T>> extends IVulkanResource.Features<T> {
    Attribute<String, String, Listener<String>, Named.Features<?>> NAME = Named.Features.NAME;
    Relation<FileResource, FileResource, Listener<FileResource>, Features<?>> FILE = new RelationBuilder<FileResource, FileResource, Listener<FileResource>, Features<?>>().name("file").contains(true).id(Shader.FeatureIDs.FILE).concept(() -> ResourceModelDefinition.Groups.FILE_RESOURCE).build();
    Attribute<EShaderStage, EShaderStage, Listener<EShaderStage>, Features<?>> STAGE = new AttributeBuilder<EShaderStage, EShaderStage, Listener<EShaderStage>, Features<?>>().name("stage").id(Shader.FeatureIDs.STAGE).datatype(() -> EnumerationModelDefinition.Enums.E_SHADER_STAGE).build();
    Relation<SpecializationConstant, List<SpecializationConstant>, Listener<List<SpecializationConstant>>, Features<?>> CONSTANTS = new RelationBuilder<SpecializationConstant, List<SpecializationConstant>, Listener<List<SpecializationConstant>>, Features<?>>().name("constants").many(true).contains(true).id(Shader.FeatureIDs.CONSTANTS).concept(() -> PipelineModelDefinition.Groups.SPECIALIZATION_CONSTANT).build();
    List<Feature<?, ?, ?, ?>> ALL = List.of(NAME, FILE, STAGE, CONSTANTS);
  }

  interface Builder extends IFeaturedObject.Builder<Shader> {
    Builder name(String name);
    Builder file(Supplier<FileResource> file);
    Builder stage(EShaderStage stage);
    Builder addConstant(Supplier<SpecializationConstant> constant);
    Builder addConstants(List<SpecializationConstant> constants);
  }
}
