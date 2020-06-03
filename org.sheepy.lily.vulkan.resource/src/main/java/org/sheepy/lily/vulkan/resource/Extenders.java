package org.sheepy.lily.vulkan.resource;

import org.sheepy.lily.core.api.extender.IExtender;
import org.sheepy.lily.core.api.extender.IExtenderProvider;
import org.sheepy.lily.vulkan.resource.buffer.*;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAllocation;
import org.sheepy.lily.vulkan.resource.file.LocalResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.StringModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.font.FontImageAllocation;
import org.sheepy.lily.vulkan.resource.image.*;
import org.sheepy.lily.vulkan.resource.semaphore.SemaphoreAllocation;
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
					   SemaphoreAllocation.class,
					   ShaderAllocation.class,
					   StaticImageAllocation.class,
					   BufferPartAllocation.class,
					   BufferDescriptorAllocation.class,
					   BufferDescriptorAdapter.class,
					   ImageDescriptorAdapter.class,
					   ImageDescriptorAllocation.class,
					   SampledImageDescriptorAllocation.class,
					   ImageArrayDescriptorAllocation.class,
					   SamplerDescriptorAllocation.class,
					   LocalResourceAdapter.class,
					   ModuleResourceAdapter.class,
					   StringModuleResourceAdapter.class,
					   FontImageAllocation.class,
					   GenericConstantBufferAdapter.class);
	}
}
