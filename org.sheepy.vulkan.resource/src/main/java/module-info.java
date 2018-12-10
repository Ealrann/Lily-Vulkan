import org.sheepy.common.api.adapter.ISingletonAdapter;
import org.sheepy.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.vulkan.resource.buffer.ConstantsAdapter;
import org.sheepy.vulkan.resource.descriptor.BasicDescriptorSetAdapter;
import org.sheepy.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.vulkan.resource.image.DepthImageAdapter;
import org.sheepy.vulkan.resource.image.ImageAdapter;
import org.sheepy.vulkan.resource.shader.ShaderAdapter;
import org.sheepy.vulkan.resource.texture.TextureAdapter;

/**
 * 
 */
module org.sheepy.vulkan.resource
{
	requires transitive org.sheepy.vulkan.common;

	exports org.sheepy.vulkan.model.resource;
	exports org.sheepy.vulkan.model.resource.impl;
	exports org.sheepy.vulkan.model.resource.util;

	exports org.sheepy.vulkan.resource;
	exports org.sheepy.vulkan.resource.buffer;
	exports org.sheepy.vulkan.resource.descriptor;
	exports org.sheepy.vulkan.resource.file;
	exports org.sheepy.vulkan.resource.indexed;
	exports org.sheepy.vulkan.resource.image;
	exports org.sheepy.vulkan.resource.image.barrier;
	exports org.sheepy.vulkan.resource.nativehelper;
	exports org.sheepy.vulkan.resource.texture;
	exports org.sheepy.vulkan.resource.shader;

	provides ISingletonAdapter with ShaderAdapter, BufferAdapter, ImageAdapter, TextureAdapter,
			DepthImageAdapter, FileResourceAdapter, ModuleResourceAdapter,
			BasicDescriptorSetAdapter, ConstantsAdapter;
}