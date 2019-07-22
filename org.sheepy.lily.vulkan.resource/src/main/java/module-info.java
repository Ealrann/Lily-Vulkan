import org.sheepy.lily.core.api.adapter.annotation.Adapters;
import org.sheepy.lily.vulkan.resource.buffer.BufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.BufferReferenceAdapter;
import org.sheepy.lily.vulkan.resource.buffer.CompositeBufferAdapter;
import org.sheepy.lily.vulkan.resource.buffer.CompositeBufferReferenceAdapter;
import org.sheepy.lily.vulkan.resource.buffer.PushBufferAdapter;
import org.sheepy.lily.vulkan.resource.file.FileResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.ModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.file.StringModuleResourceAdapter;
import org.sheepy.lily.vulkan.resource.image.FileImageAdapter;
import org.sheepy.lily.vulkan.resource.image.FontImageAdapter;
import org.sheepy.lily.vulkan.resource.image.SampledImageAdapter;
import org.sheepy.lily.vulkan.resource.image.SamplerAdapter;
import org.sheepy.lily.vulkan.resource.image.StaticImageAdapter;
import org.sheepy.lily.vulkan.resource.semaphore.SemaphoreAdapter;
import org.sheepy.lily.vulkan.resource.shader.ShaderAdapter;

@Adapters(classifiers = {
		BufferAdapter.class,
		BufferReferenceAdapter.class,
		CompositeBufferAdapter.class,
		CompositeBufferReferenceAdapter.class,
		FileImageAdapter.class,
		FileResourceAdapter.class,
		FontImageAdapter.class,
		ModuleResourceAdapter.class,
		PushBufferAdapter.class,
		SamplerAdapter.class,
		SampledImageAdapter.class,
		SemaphoreAdapter.class,
		ShaderAdapter.class,
		StaticImageAdapter.class,
		StringModuleResourceAdapter.class
})

module org.sheepy.lily.vulkan.resource
{
	requires transitive org.sheepy.lily.vulkan.common;

	exports org.sheepy.lily.vulkan.resource.image;
	exports org.sheepy.lily.vulkan.resource.semaphore;

	opens org.sheepy.lily.vulkan.resource.buffer;
	opens org.sheepy.lily.vulkan.resource.file;
	opens org.sheepy.lily.vulkan.resource.image;
	opens org.sheepy.lily.vulkan.resource.semaphore;
	opens org.sheepy.lily.vulkan.resource.shader;
}
