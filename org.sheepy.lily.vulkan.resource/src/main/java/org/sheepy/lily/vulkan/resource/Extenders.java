package org.sheepy.lily.vulkan.resource;

import org.logoce.extender.api.IAdapter;
import org.logoce.extender.api.IAdapterProvider;
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

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Extenders implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(CompositeImageAllocation.class,
					   FileImageProviderAdapter.class,
					   TransferBufferAllocation.class,
					   SamplerAllocation.class,
					   ShaderAllocation.class,
					   StaticImageAdapter.class,
					   StaticImageAllocation.class,
					   ImageViewerAdapter.class,
					   ImageViewerAllocation.class,
					   BufferDescriptorAllocation.class,
					   BufferDescriptorAdapter.class,
					   ImageDescriptorAdapter.class,
					   ImageDescriptorAllocation.class,
					   FileImageAdapter.class,
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
					   BufferMemoryAdapter.class,
					   BufferMemoryAllocation.class);
	}

	@Override
	public MethodHandles.Lookup lookup()
	{
		return MethodHandles.lookup();
	}
}
