package org.sheepy.lily.vulkan.resource;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.resource.buffer.*;
import org.sheepy.lily.vulkan.resource.buffer.reference.BufferReferenceAllocation;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorPoolAllocation;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorSetAllocation;
import org.sheepy.lily.vulkan.resource.descriptor.DescriptorSetLayoutAllocation;
import org.sheepy.lily.vulkan.resource.file.LocalResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.StringModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.font.FontImageAllocation;
import org.sheepy.lily.vulkan.resource.image.*;
import org.sheepy.lily.vulkan.resource.memorychunk.MemoryChunkAllocation;
import org.sheepy.lily.vulkan.resource.shader.ShaderAllocation;

import java.util.List;

public class Extenders implements IExtenderProvider
{
	@Override
	public List<Class<? extends IExtender>> classifiers()
	{
		return List.of(BufferAllocation.class,
					   CompositeBufferAllocation.class,
					   CompositeImageAllocation.class,
					   FileImageAllocation.class,
					   TransferBufferAllocation.class,
					   SamplerAllocation.class,
					   SampledImageAllocation.class,
					   ShaderAllocation.class,
					   StaticImageAllocation.class,
					   BufferPartAllocation.class,
					   BufferDescriptorAllocation.class,
					   BufferDescriptorAdapter.class,
					   ImageDescriptorAdapter.class,
					   ImageDescriptorAllocation.class,
					   SampledImageDescriptorAdapter.class,
					   SampledImageDescriptorAllocation.class,
					   ImageArrayDescriptorAllocation.class,
					   SamplerDescriptorAdapter.class,
					   SamplerDescriptorAllocation.class,
					   LocalResourceAdapter.class,
					   ModuleResourceAdapter.class,
					   StringModuleResourceAdapter.class,
					   FontImageAllocation.class,
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
