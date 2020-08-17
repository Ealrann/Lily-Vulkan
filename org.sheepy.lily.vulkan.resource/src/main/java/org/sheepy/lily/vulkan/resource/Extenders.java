package org.sheepy.lily.vulkan.resource;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.resource.buffer.*;
import org.sheepy.lily.vulkan.resource.buffer.descriptor.BufferDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.buffer.descriptor.BufferDescriptorAllocation;
import org.sheepy.lily.vulkan.resource.buffer.reference.BufferReferenceAllocation;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPoolAllocation;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorSetAllocation;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorSetLayoutAllocation;
import org.sheepy.lily.vulkan.resource.file.LocalResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.StringModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.image.*;
import org.sheepy.lily.vulkan.resource.image.descriptor.ImageDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.image.descriptor.ImageDescriptorAllocation;
import org.sheepy.lily.vulkan.resource.memorychunk.MemoryChunkAllocation;
import org.sheepy.lily.vulkan.resource.shader.ShaderAllocation;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(CompositeImageAllocation.class,
					   FileImageProviderAdapter.class,
					   TransferBufferAllocation.class,
					   SamplerAllocation.class,
					   ShaderAllocation.class,
					   StaticImageAllocation.class,
					   ImageViewerAllocation.class,
					   BufferDescriptorAllocation.class,
					   BufferDescriptorAdapter.class,
					   ImageDescriptorAdapter.class,
					   ImageDescriptorAllocation.class,
					   LocalResourceAdapter.class,
					   ModuleResourceAdapter.class,
					   StringModuleResourceAdapter.class,
					   GenericConstantBufferAdapter.class,
					   DescriptorPoolAllocation.class,
					   DescriptorSetLayoutAllocation.class,
					   DescriptorSetAllocation.class,
					   BufferReferenceAllocation.class,
					   MemoryChunkAllocation.class,
					   BufferViewerAdapter.class,
					   BufferViewerAllocation.class,
					   DataBufferAdapter.class,
					   DataBufferAllocation.class,
					   StaticBufferAdapter.class,
					   StaticBufferAllocation.class,
					   BufferMemoryAllocation.class);
	}
}
