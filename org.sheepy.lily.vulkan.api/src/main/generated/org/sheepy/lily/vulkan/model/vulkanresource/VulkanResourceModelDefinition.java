package org.sheepy.lily.vulkan.model.vulkanresource;

import java.nio.ByteBuffer;
import java.util.List;
import org.logoce.lmf.core.api.model.BuilderSupplier;
import org.logoce.lmf.core.lang.Alias;
import org.logoce.lmf.core.lang.Enum;
import org.logoce.lmf.core.lang.Group;
import org.logoce.lmf.core.lang.JavaWrapper;
import org.logoce.lmf.core.lang.LMCoreModelDefinition;
import org.logoce.lmf.core.lang.Unit;
import org.logoce.lmf.core.lang.builder.EnumAttributeBuilder;
import org.logoce.lmf.core.lang.builder.EnumBuilder;
import org.logoce.lmf.core.lang.builder.GroupBuilder;
import org.logoce.lmf.core.lang.builder.IncludeBuilder;
import org.logoce.lmf.core.lang.builder.JavaWrapperBuilder;
import org.sheepy.lily.core.model.resource.IImage;
import org.sheepy.lily.core.model.resource.ResourceModelDefinition;
import org.sheepy.lily.core.model.types.LNamedElement;
import org.sheepy.lily.core.model.types.TypesModelDefinition;
import org.sheepy.lily.vulkan.model.vulkan.IDescriptor;
import org.sheepy.lily.vulkan.model.vulkan.IVulkanResource;
import org.sheepy.lily.vulkan.model.vulkan.VulkanModelDefinition;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferBarrierBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferDescriptorBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferMemoryBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferReferenceBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.BufferViewerBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.CompositeImageBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ConstantBufferBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.DataBufferBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.DescriptorPoolBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.DescriptorSetBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.FileImageDataProviderBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.GenericConstantBufferBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ImageBarrierBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ImageDataProviderBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ImageDescriptorBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ImageInlayBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ImageViewerBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.MemoryChunkBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.SamplerBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.ShaderBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.StaticBufferBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.StaticImageBuilder;
import org.sheepy.lily.vulkan.model.vulkanresource.builder.TransferBufferBuilder;
import org.sheepy.vulkan.model.barrier.AbstractBufferBarrier;
import org.sheepy.vulkan.model.barrier.AbstractImageBarrier;
import org.sheepy.vulkan.model.barrier.BarrierModelDefinition;
import org.sheepy.vulkan.model.image.ImageInfo;
import org.sheepy.vulkan.model.image.ImageModelDefinition;
import org.sheepy.vulkan.model.image.SamplerInfo;

public interface VulkanResourceModelDefinition {
  interface Generics {
  }

  interface Groups {
    Group<TransferBuffer> TRANSFER_BUFFER = new GroupBuilder<TransferBuffer>().name("TransferBuffer").concrete(true).addInclude(() -> new IncludeBuilder<IVulkanResource>().group(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build()).addFeatures(TransferBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(TransferBufferBuilder::new)).build();
    Group<DescriptorPool> DESCRIPTOR_POOL = new GroupBuilder<DescriptorPool>().name("DescriptorPool").concrete(true).addFeatures(DescriptorPool.Features.ALL).lmBuilder(new BuilderSupplier<>(DescriptorPoolBuilder::new)).build();
    Group<ConstantBuffer> CONSTANT_BUFFER = new GroupBuilder<ConstantBuffer>().name("ConstantBuffer").concrete(true).addInclude(() -> new IncludeBuilder<IVulkanResource>().group(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build()).addFeatures(ConstantBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(ConstantBufferBuilder::new)).build();
    Group<GenericConstantBuffer> GENERIC_CONSTANT_BUFFER = new GroupBuilder<GenericConstantBuffer>().name("GenericConstantBuffer").concrete(true).addInclude(() -> new IncludeBuilder<ConstantBuffer>().group(() -> CONSTANT_BUFFER).build()).addFeatures(GenericConstantBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(GenericConstantBufferBuilder::new)).build();
    Group<IBuffer> I_BUFFER = new GroupBuilder<IBuffer>().name("IBuffer").addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(IBuffer.Features.ALL).build();
    Group<BufferReference> BUFFER_REFERENCE = new GroupBuilder<BufferReference>().name("BufferReference").concrete(true).addFeatures(BufferReference.Features.ALL).lmBuilder(new BuilderSupplier<>(BufferReferenceBuilder::new)).build();
    Group<IBufferDataSource> I_BUFFER_DATA_SOURCE = new GroupBuilder<IBufferDataSource>().name("IBufferDataSource").addFeatures(IBufferDataSource.Features.ALL).build();
    Group<ImageDataProvider> IMAGE_DATA_PROVIDER = new GroupBuilder<ImageDataProvider>().name("ImageDataProvider").concrete(true).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(ImageDataProvider.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageDataProviderBuilder::new)).build();
    Group<FileImageDataProvider> FILE_IMAGE_DATA_PROVIDER = new GroupBuilder<FileImageDataProvider>().name("FileImageDataProvider").concrete(true).addInclude(() -> new IncludeBuilder<ImageDataProvider>().group(() -> IMAGE_DATA_PROVIDER).build()).addFeatures(FileImageDataProvider.Features.ALL).lmBuilder(new BuilderSupplier<>(FileImageDataProviderBuilder::new)).build();
    Group<ImageInlay> IMAGE_INLAY = new GroupBuilder<ImageInlay>().name("ImageInlay").concrete(true).addFeatures(ImageInlay.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageInlayBuilder::new)).build();
    Group<Sampler> SAMPLER = new GroupBuilder<Sampler>().name("Sampler").concrete(true).addInclude(() -> new IncludeBuilder<SamplerInfo>().group(() -> ImageModelDefinition.Groups.SAMPLER_INFO).build()).addInclude(() -> new IncludeBuilder<IVulkanResource>().group(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build()).addFeatures(Sampler.Features.ALL).lmBuilder(new BuilderSupplier<>(SamplerBuilder::new)).build();
    Group<BufferDescriptor> BUFFER_DESCRIPTOR = new GroupBuilder<BufferDescriptor>().name("BufferDescriptor").concrete(true).addInclude(() -> new IncludeBuilder<IDescriptor>().group(() -> VulkanModelDefinition.Groups.I_DESCRIPTOR).build()).addFeatures(BufferDescriptor.Features.ALL).lmBuilder(new BuilderSupplier<>(BufferDescriptorBuilder::new)).build();
    Group<ImageDescriptor> IMAGE_DESCRIPTOR = new GroupBuilder<ImageDescriptor>().name("ImageDescriptor").concrete(true).addInclude(() -> new IncludeBuilder<IDescriptor>().group(() -> VulkanModelDefinition.Groups.I_DESCRIPTOR).build()).addFeatures(ImageDescriptor.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageDescriptorBuilder::new)).build();
    Group<DescriptorSet> DESCRIPTOR_SET = new GroupBuilder<DescriptorSet>().name("DescriptorSet").concrete(true).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(DescriptorSet.Features.ALL).lmBuilder(new BuilderSupplier<>(DescriptorSetBuilder::new)).build();
    Group<BufferBarrier> BUFFER_BARRIER = new GroupBuilder<BufferBarrier>().name("BufferBarrier").concrete(true).addInclude(() -> new IncludeBuilder<AbstractBufferBarrier>().group(() -> BarrierModelDefinition.Groups.ABSTRACT_BUFFER_BARRIER).build()).addFeatures(BufferBarrier.Features.ALL).lmBuilder(new BuilderSupplier<>(BufferBarrierBuilder::new)).build();
    Group<ImageBarrier> IMAGE_BARRIER = new GroupBuilder<ImageBarrier>().name("ImageBarrier").concrete(true).addInclude(() -> new IncludeBuilder<AbstractImageBarrier>().group(() -> BarrierModelDefinition.Groups.ABSTRACT_IMAGE_BARRIER).build()).addFeatures(ImageBarrier.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageBarrierBuilder::new)).build();
    Group<Shader> SHADER = new GroupBuilder<Shader>().name("Shader").concrete(true).addInclude(() -> new IncludeBuilder<IVulkanResource>().group(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build()).addFeatures(Shader.Features.ALL).lmBuilder(new BuilderSupplier<>(ShaderBuilder::new)).build();
    Group<MemoryChunk> MEMORY_CHUNK = new GroupBuilder<MemoryChunk>().name("MemoryChunk").concrete(true).addInclude(() -> new IncludeBuilder<IVulkanResource>().group(() -> VulkanModelDefinition.Groups.I_VULKAN_RESOURCE).build()).addFeatures(MemoryChunk.Features.ALL).lmBuilder(new BuilderSupplier<>(MemoryChunkBuilder::new)).build();
    Group<IMemoryChunkPart> I_MEMORY_CHUNK_PART = new GroupBuilder<IMemoryChunkPart>().name("IMemoryChunkPart").addFeatures(IMemoryChunkPart.Features.ALL).build();
    Group<BufferMemory> BUFFER_MEMORY = new GroupBuilder<BufferMemory>().name("BufferMemory").concrete(true).addInclude(() -> new IncludeBuilder<IMemoryChunkPart>().group(() -> I_MEMORY_CHUNK_PART).build()).addInclude(() -> new IncludeBuilder<LNamedElement>().group(() -> TypesModelDefinition.Groups.L_NAMED_ELEMENT).build()).addFeatures(BufferMemory.Features.ALL).lmBuilder(new BuilderSupplier<>(BufferMemoryBuilder::new)).build();
    Group<StaticBuffer> STATIC_BUFFER = new GroupBuilder<StaticBuffer>().name("StaticBuffer").concrete(true).addInclude(() -> new IncludeBuilder<IBuffer>().group(() -> I_BUFFER).build()).addFeatures(StaticBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(StaticBufferBuilder::new)).build();
    Group<DataBuffer> DATA_BUFFER = new GroupBuilder<DataBuffer>().name("DataBuffer").concrete(true).addInclude(() -> new IncludeBuilder<IBuffer>().group(() -> I_BUFFER).build()).addFeatures(DataBuffer.Features.ALL).lmBuilder(new BuilderSupplier<>(DataBufferBuilder::new)).build();
    Group<BufferViewer> BUFFER_VIEWER = new GroupBuilder<BufferViewer>().name("BufferViewer").concrete(true).addInclude(() -> new IncludeBuilder<IBuffer>().group(() -> I_BUFFER).build()).addFeatures(BufferViewer.Features.ALL).lmBuilder(new BuilderSupplier<>(BufferViewerBuilder::new)).build();
    Group<IVulkanImage> I_VULKAN_IMAGE = new GroupBuilder<IVulkanImage>().name("IVulkanImage").addInclude(() -> new IncludeBuilder<IImage>().group(() -> ResourceModelDefinition.Groups.I_IMAGE).build()).addFeatures(IVulkanImage.Features.ALL).build();
    Group<CompositeImage> COMPOSITE_IMAGE = new GroupBuilder<CompositeImage>().name("CompositeImage").concrete(true).addInclude(() -> new IncludeBuilder<IVulkanImage>().group(() -> I_VULKAN_IMAGE).build()).addInclude(() -> new IncludeBuilder<ImageInfo>().group(() -> ImageModelDefinition.Groups.IMAGE_INFO).build()).addFeatures(CompositeImage.Features.ALL).lmBuilder(new BuilderSupplier<>(CompositeImageBuilder::new)).build();
    Group<StaticImage> STATIC_IMAGE = new GroupBuilder<StaticImage>().name("StaticImage").concrete(true).addInclude(() -> new IncludeBuilder<IMemoryChunkPart>().group(() -> I_MEMORY_CHUNK_PART).build()).addInclude(() -> new IncludeBuilder<IVulkanImage>().group(() -> I_VULKAN_IMAGE).build()).addInclude(() -> new IncludeBuilder<ImageInfo>().group(() -> ImageModelDefinition.Groups.IMAGE_INFO).build()).addFeatures(StaticImage.Features.ALL).lmBuilder(new BuilderSupplier<>(StaticImageBuilder::new)).build();
    Group<ImageViewer> IMAGE_VIEWER = new GroupBuilder<ImageViewer>().name("ImageViewer").concrete(true).addInclude(() -> new IncludeBuilder<IMemoryChunkPart>().group(() -> I_MEMORY_CHUNK_PART).build()).addInclude(() -> new IncludeBuilder<IVulkanImage>().group(() -> I_VULKAN_IMAGE).build()).addInclude(() -> new IncludeBuilder<ImageInfo>().group(() -> ImageModelDefinition.Groups.IMAGE_INFO).build()).addFeatures(ImageViewer.Features.ALL).lmBuilder(new BuilderSupplier<>(ImageViewerBuilder::new)).build();
    List<Group<?>> ALL = List.of(TRANSFER_BUFFER, DESCRIPTOR_POOL, CONSTANT_BUFFER, GENERIC_CONSTANT_BUFFER, I_BUFFER, BUFFER_REFERENCE, I_BUFFER_DATA_SOURCE, IMAGE_DATA_PROVIDER, FILE_IMAGE_DATA_PROVIDER, IMAGE_INLAY, SAMPLER, BUFFER_DESCRIPTOR, IMAGE_DESCRIPTOR, DESCRIPTOR_SET, BUFFER_BARRIER, IMAGE_BARRIER, SHADER, MEMORY_CHUNK, I_MEMORY_CHUNK_PART, BUFFER_MEMORY, STATIC_BUFFER, DATA_BUFFER, BUFFER_VIEWER, I_VULKAN_IMAGE, COMPOSITE_IMAGE, STATIC_IMAGE, IMAGE_VIEWER);
  }

  interface Units {
    List<Unit<?>> ALL = List.of();
  }

  interface Enums {
    Enum<EContextIndex> E_CONTEXT_INDEX = new EnumBuilder<EContextIndex>().name("EContextIndex").addLiterals(List.of("ContextInstance", "0", "ContextInstance_PlusOne", "1", "ContextInstance_MinusOne", "2")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    Enum<EFlushMode> E_FLUSH_MODE = new EnumBuilder<EFlushMode>().name("EFlushMode").addLiterals(List.of("PUSH", "0", "FETCH", "1")).addAttribute(() -> new EnumAttributeBuilder().name("value").unit(() -> LMCoreModelDefinition.Units.INT).build()).build();
    List<Enum<?>> ALL = List.of(E_CONTEXT_INDEX, E_FLUSH_MODE);
  }

  interface Aliases {
    List<Alias> ALL = List.of();
  }

  interface JavaWrappers {
    JavaWrapper<ByteBuffer> BYTE_BUFFER = new JavaWrapperBuilder<ByteBuffer>().name("ByteBuffer").qualifiedClassName("java.nio.ByteBuffer").build();
    List<JavaWrapper<?>> ALL = List.of(BYTE_BUFFER);
  }
}
