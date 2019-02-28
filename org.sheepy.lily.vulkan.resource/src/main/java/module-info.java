import org.sheepy.lily.core.api.adapter.IAdapter;
import org.sheepy.lily.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.ConstantsAdapter;
import org.sheepy.lily.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.StringModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.image.DepthImageAdapter;
import org.sheepy.lily.vulkan.resource.image.ImageAdapter;
import org.sheepy.lily.vulkan.resource.semaphore.SemaphoreAdapter;
import org.sheepy.lily.vulkan.resource.shader.ShaderAdapter;
import org.sheepy.lily.vulkan.resource.texture.FontAdapter;
import org.sheepy.lily.vulkan.resource.texture.TextureAdapter;

/**
 * 
 */
module org.sheepy.lily.vulkan.resource
{
	requires transitive org.sheepy.lily.vulkan.common;

	exports org.sheepy.lily.vulkan.resource;
	exports org.sheepy.lily.vulkan.resource.buffer;
	exports org.sheepy.lily.vulkan.resource.descriptor;
	exports org.sheepy.lily.vulkan.resource.file;
	exports org.sheepy.lily.vulkan.resource.indexed;
	exports org.sheepy.lily.vulkan.resource.image;
	exports org.sheepy.lily.vulkan.resource.barrier;
	exports org.sheepy.lily.vulkan.resource.nativehelper;
	exports org.sheepy.lily.vulkan.resource.texture;
	exports org.sheepy.lily.vulkan.resource.semaphore;
	exports org.sheepy.lily.vulkan.resource.shader;

	provides IAdapter with ShaderAdapter, BufferAdapter, ImageAdapter, TextureAdapter,
			DepthImageAdapter, FileResourceAdapter, ModuleResourceAdapter,
			StringModuleResourceAdapter, ConstantsAdapter, FontAdapter, SemaphoreAdapter;
}
