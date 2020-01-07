import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.BufferDescriptorAdapter;
import org.sheepy.lily.vulkan.resource.buffer.BufferPartAdapter;
import org.sheepy.lily.vulkan.resource.buffer.CompositeBufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.TransferBufferAdapter;
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

@Adapters(classifiers = {
		BufferAdapter.class,
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
		FontImageAdapter.class
})

module org.sheepy.lily.vulkan.resource
{
	requires transitive org.sheepy.lily.vulkan.common;

	exports org.sheepy.lily.vulkan.resource.image;
	exports org.sheepy.lily.vulkan.resource.semaphore;

	opens org.sheepy.lily.vulkan.resource.buffer;
	opens org.sheepy.lily.vulkan.resource.file;
	opens org.sheepy.lily.vulkan.resource.font;
	opens org.sheepy.lily.vulkan.resource.image;
	opens org.sheepy.lily.vulkan.resource.semaphore;
	opens org.sheepy.lily.vulkan.resource.shader;
}
