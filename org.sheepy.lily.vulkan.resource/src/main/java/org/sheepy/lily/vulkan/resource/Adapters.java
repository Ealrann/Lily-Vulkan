package org.sheepy.lily.vulkan.resource;

import java.util.List;

import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.core.api.adapter.IAdapterProvider;
import org.sheepy.lily.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.BufferDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.buffer.BufferPartAdapter;
import org.sheepy.lily.vulkan.resource.buffer.CompositeBufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.transfer.TransferBufferAdapter;
import org.sheepy.lily.vulkan.resource.file.LocalResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.StringModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.font.FontImageAdapter;
import org.sheepy.lily.vulkan.resource.image.FileImageAdapter;
import org.sheepy.lily.vulkan.resource.image.ImageArrayDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.image.ImageDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.image.SampledImageAdapter;
import org.sheepy.lily.vulkan.resource.image.SampledImageDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.image.SamplerAdapter;
import org.sheepy.lily.vulkan.resource.image.SamplerDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.image.StaticImageAdapter;
import org.sheepy.lily.vulkan.resource.semaphore.SemaphoreAdapter;
import org.sheepy.lily.vulkan.resource.shader.ShaderAdapter;

public class Adapters implements IAdapterProvider
{
	@Override
	public List<Class<? extends IAdapter>> classifiers()
	{
		return List.of(	BufferAdapter.class,
						CompositeBufferAdapter.class,
						FileImageAdapter.class,
						TransferBufferAdapter.class,
						SamplerAdapter.class,
						SampledImageAdapter.class,
						SemaphoreAdapter.class,
						ShaderAdapter.class,
						StaticImageAdapter.class,
						BufferPartAdapter.class,
						BufferDescriptorAdapter.class,
						ImageDescriptorAdapter.class,
						SampledImageDescriptorAdapter.class,
						ImageArrayDescriptorAdapter.class,
						SamplerDescriptorAdapter.class,
						LocalResourceAdapter.class,
						ModuleResourceAdapter.class,
						StringModuleResourceAdapter.class,
						FontImageAdapter.class);
	}
}
