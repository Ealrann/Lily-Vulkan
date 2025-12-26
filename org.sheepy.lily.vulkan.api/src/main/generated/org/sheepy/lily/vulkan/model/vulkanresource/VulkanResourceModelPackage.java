package org.sheepy.lily.vulkan.model.vulkanresource;

import java.util.List;
import java.util.Optional;
import org.logoce.lmf.core.api.model.IFeaturedObject;
import org.logoce.lmf.core.api.model.IJavaWrapperConverter;
import org.logoce.lmf.core.api.model.IModelPackage;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMObject;
import org.logoce.lmf.core.lang.MetaModel;
import org.logoce.lmf.core.lang.builder.MetaModelBuilder;

public final class VulkanResourceModelPackage implements IModelPackage {
  public static final VulkanResourceModelPackage Instance = new VulkanResourceModelPackage();

  public static final MetaModel MODEL = new MetaModelBuilder().name("VulkanResource").domain("org.sheepy.lily.vulkan.model").addImports(List.of("org.sheepy.lily.core.model.Resource", "org.sheepy.lily.core.model.Types", "org.sheepy.lily.core.model.Variable", "org.sheepy.lily.vulkan.model.Vulkan", "org.sheepy.vulkan.model.Barrier", "org.sheepy.vulkan.model.Enumeration", "org.sheepy.vulkan.model.Image", "org.sheepy.vulkan.model.Pipeline")).genNamePackage(true).lmPackage(Instance).addGroups(VulkanResourceModelDefinition.Groups.ALL).addEnums(VulkanResourceModelDefinition.Enums.ALL).addUnits(VulkanResourceModelDefinition.Units.ALL).addAliases(VulkanResourceModelDefinition.Aliases.ALL).addJavaWrappers(VulkanResourceModelDefinition.JavaWrappers.ALL).build();

  private VulkanResourceModelPackage() {
  }

  @Override
  public MetaModel model() {
    return MODEL;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T extends LMObject> Optional<IFeaturedObject.Builder<T>> builder(Group<T> group) {
    if (group == VulkanResourceModelDefinition.Groups.TRANSFER_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) TransferBuffer.builder());
    else if (group == VulkanResourceModelDefinition.Groups.DESCRIPTOR_POOL) return Optional.of((IFeaturedObject.Builder<T>) DescriptorPool.builder());
    else if (group == VulkanResourceModelDefinition.Groups.CONSTANT_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) ConstantBuffer.builder());
    else if (group == VulkanResourceModelDefinition.Groups.GENERIC_CONSTANT_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) GenericConstantBuffer.builder());
    else if (group == VulkanResourceModelDefinition.Groups.BUFFER_REFERENCE) return Optional.of((IFeaturedObject.Builder<T>) BufferReference.builder());
    else if (group == VulkanResourceModelDefinition.Groups.IMAGE_DATA_PROVIDER) return Optional.of((IFeaturedObject.Builder<T>) ImageDataProvider.builder());
    else if (group == VulkanResourceModelDefinition.Groups.FILE_IMAGE_DATA_PROVIDER) return Optional.of((IFeaturedObject.Builder<T>) FileImageDataProvider.builder());
    else if (group == VulkanResourceModelDefinition.Groups.IMAGE_INLAY) return Optional.of((IFeaturedObject.Builder<T>) ImageInlay.builder());
    else if (group == VulkanResourceModelDefinition.Groups.SAMPLER) return Optional.of((IFeaturedObject.Builder<T>) Sampler.builder());
    else if (group == VulkanResourceModelDefinition.Groups.BUFFER_DESCRIPTOR) return Optional.of((IFeaturedObject.Builder<T>) BufferDescriptor.builder());
    else if (group == VulkanResourceModelDefinition.Groups.IMAGE_DESCRIPTOR) return Optional.of((IFeaturedObject.Builder<T>) ImageDescriptor.builder());
    else if (group == VulkanResourceModelDefinition.Groups.DESCRIPTOR_SET) return Optional.of((IFeaturedObject.Builder<T>) DescriptorSet.builder());
    else if (group == VulkanResourceModelDefinition.Groups.BUFFER_BARRIER) return Optional.of((IFeaturedObject.Builder<T>) BufferBarrier.builder());
    else if (group == VulkanResourceModelDefinition.Groups.IMAGE_BARRIER) return Optional.of((IFeaturedObject.Builder<T>) ImageBarrier.builder());
    else if (group == VulkanResourceModelDefinition.Groups.SHADER) return Optional.of((IFeaturedObject.Builder<T>) Shader.builder());
    else if (group == VulkanResourceModelDefinition.Groups.MEMORY_CHUNK) return Optional.of((IFeaturedObject.Builder<T>) MemoryChunk.builder());
    else if (group == VulkanResourceModelDefinition.Groups.BUFFER_MEMORY) return Optional.of((IFeaturedObject.Builder<T>) BufferMemory.builder());
    else if (group == VulkanResourceModelDefinition.Groups.STATIC_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) StaticBuffer.builder());
    else if (group == VulkanResourceModelDefinition.Groups.DATA_BUFFER) return Optional.of((IFeaturedObject.Builder<T>) DataBuffer.builder());
    else if (group == VulkanResourceModelDefinition.Groups.BUFFER_VIEWER) return Optional.of((IFeaturedObject.Builder<T>) BufferViewer.builder());
    else if (group == VulkanResourceModelDefinition.Groups.COMPOSITE_IMAGE) return Optional.of((IFeaturedObject.Builder<T>) CompositeImage.builder());
    else if (group == VulkanResourceModelDefinition.Groups.STATIC_IMAGE) return Optional.of((IFeaturedObject.Builder<T>) StaticImage.builder());
    else if (group == VulkanResourceModelDefinition.Groups.IMAGE_VIEWER) return Optional.of((IFeaturedObject.Builder<T>) ImageViewer.builder());
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<T> resolveEnumLiteral(Enum<T> enum_, String value) {
    if (enum_ == VulkanResourceModelDefinition.Enums.E_CONTEXT_INDEX) return (Optional<T>) Optional.of(EContextIndex.valueOf(value));
    else if (enum_ == VulkanResourceModelDefinition.Enums.E_FLUSH_MODE) return (Optional<T>) Optional.of(EFlushMode.valueOf(value));
    return Optional.empty();
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> Optional<IJavaWrapperConverter<T>> resolveJavaWrapperConverter(
      JavaWrapper<T> wrapper) {
    return Optional.empty();
  }
}
